package com.neueda.jetbrains.plugin.graphdb.jetbrains.ui.datasource.metadata;

import com.intellij.ui.treeStructure.PatchedDefaultMutableTreeNode;
import com.neueda.jetbrains.plugin.graphdb.jetbrains.component.datasource.metadata.*;
import com.neueda.jetbrains.plugin.graphdb.jetbrains.component.datasource.state.DataSourceApi;
import com.neueda.jetbrains.plugin.graphdb.jetbrains.ui.datasource.tree.dto.ValueWithIcon;
import com.neueda.jetbrains.plugin.graphdb.platform.GraphIcons;

public class DataSourceMetadataUi {

    private final DataSourcesComponentMetadata dataSourcesComponent;

    public DataSourceMetadataUi(DataSourcesComponentMetadata dataSourcesComponent) {
        this.dataSourcesComponent = dataSourcesComponent;
    }

    public boolean updateDataSourceMetadataUi(PatchedDefaultMutableTreeNode node, DataSourceApi nodeDataSource) {
        switch (nodeDataSource.getDataSourceType()) {
            case NEO4J_BOLT:
                return dataSourcesComponent.getMetadata(nodeDataSource)
                           .map(dataSourceMetadata -> updateNeo4jBoltCypherMetadataUi(node, dataSourceMetadata))
                           .orElse(false);
            default:
                return false;
        }
    }

    // ui
    private boolean updateNeo4jBoltCypherMetadataUi(PatchedDefaultMutableTreeNode dataSourceRootTreeNode,
                                                    DataSourceMetadata dataSourceMetadata) {
        // Remove existing metadata from ui
        dataSourceRootTreeNode.removeAllChildren();

        // Prepare new metadata root tree nodes
        PatchedDefaultMutableTreeNode labelsTreeNode = new PatchedDefaultMutableTreeNode(
                   new ValueWithIcon(GraphIcons.Nodes.LABEL, "labels"));
        PatchedDefaultMutableTreeNode relationshipTypesTreeNode = new PatchedDefaultMutableTreeNode(
                   new ValueWithIcon(GraphIcons.Nodes.RELATIONSHIP_TYPE, "relationship types"));
        PatchedDefaultMutableTreeNode propertyKeysTreeNode = new PatchedDefaultMutableTreeNode(
                   new ValueWithIcon(GraphIcons.Nodes.PROPERTY_KEY, "property keys"));
        PatchedDefaultMutableTreeNode storedProceduresTreeNode = new PatchedDefaultMutableTreeNode(
                   new ValueWithIcon(GraphIcons.Nodes.STORED_PROCEDURE, "stored procedures"));

        // Update metadata tree nodes
        dataSourceMetadata
                   .getMetadata(Neo4jBoltCypherDataSourceMetadata.LABELS)
                   .forEach((row) -> labelsTreeNode.add(new PatchedDefaultMutableTreeNode(row.get("label"))));
        dataSourceMetadata
                   .getMetadata(Neo4jBoltCypherDataSourceMetadata.RELATIONSHIP_TYPES)
                   .forEach((row) -> relationshipTypesTreeNode.add(new PatchedDefaultMutableTreeNode(row.get("relationshipType"))));
        dataSourceMetadata
                   .getMetadata(Neo4jBoltCypherDataSourceMetadata.PROPERTY_KEYS)
                   .forEach((row) -> propertyKeysTreeNode.add(new PatchedDefaultMutableTreeNode(row.get("propertyKey"))));
        dataSourceMetadata
                   .getMetadata(Neo4jBoltCypherDataSourceMetadata.STORED_PROCEDURES)
                   .forEach((row) -> {
                       PatchedDefaultMutableTreeNode nameNode = new PatchedDefaultMutableTreeNode(row.get("name"));
                       PatchedDefaultMutableTreeNode descriptionNode = new PatchedDefaultMutableTreeNode(row.get("signature"));
                       nameNode.add(descriptionNode);
                       storedProceduresTreeNode.add(nameNode);
                   });

        // Add metadata tree nodes back to UI
        dataSourceRootTreeNode.add(labelsTreeNode);
        dataSourceRootTreeNode.add(relationshipTypesTreeNode);
        dataSourceRootTreeNode.add(propertyKeysTreeNode);
        dataSourceRootTreeNode.add(storedProceduresTreeNode);

        return true;
    }
}
