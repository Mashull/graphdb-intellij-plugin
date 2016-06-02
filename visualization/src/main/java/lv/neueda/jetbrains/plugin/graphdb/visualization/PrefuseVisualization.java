package lv.neueda.jetbrains.plugin.graphdb.visualization;

import lv.neueda.jetbrains.plugin.graphdb.database.api.GraphNode;
import lv.neueda.jetbrains.plugin.graphdb.database.api.GraphRelationship;
import lv.neueda.jetbrains.plugin.graphdb.visualization.events.EventType;
import lv.neueda.jetbrains.plugin.graphdb.visualization.events.NodeCallback;
import lv.neueda.jetbrains.plugin.graphdb.visualization.events.RelationshipCallback;

import javax.swing.*;

public class PrefuseVisualization implements VisualizationApi {

    private GraphDisplay display = new GraphDisplay();

    @Override
    public void addNode(GraphNode node) {
        display.addNode(node);
    }

    @Override
    public void addRelation(GraphRelationship relationship) {
        display.addRelationship(relationship);
    }

    @Override
    public void clear() {
        display.clearGraph();
    }

    @Override
    public void paint() {
        display.startLayout();
    }

    @Override
    public void stop() {
        display.stopLayout();
    }

    @Override
    public JComponent getCanvas() {
        return display;
    }

    @Override
    public void addNodeListener(EventType type, NodeCallback action) {
        display.addNodeListener(type, action);
    }

    @Override
    public void addEdgeListener(EventType type, RelationshipCallback action) {
        display.addEdgeListener(type, action);
    }
}
