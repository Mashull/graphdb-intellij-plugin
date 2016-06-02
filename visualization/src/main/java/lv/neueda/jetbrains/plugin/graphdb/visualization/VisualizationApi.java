package lv.neueda.jetbrains.plugin.graphdb.visualization;

import lv.neueda.jetbrains.plugin.graphdb.database.api.GraphNode;
import lv.neueda.jetbrains.plugin.graphdb.database.api.GraphRelationship;
import lv.neueda.jetbrains.plugin.graphdb.visualization.events.EventType;
import lv.neueda.jetbrains.plugin.graphdb.visualization.events.NodeCallback;
import lv.neueda.jetbrains.plugin.graphdb.visualization.events.RelationshipCallback;

import javax.swing.*;

public interface VisualizationApi {

    JComponent getCanvas();

    void addNode(GraphNode node);

    void addRelation(GraphRelationship relationship);

    void clear();

    void paint();

    void stop();

    void addNodeListener(EventType type, NodeCallback action);

    void addEdgeListener(EventType type, RelationshipCallback action);
}
