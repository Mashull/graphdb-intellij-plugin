/**
 * Copied and adapted from plugin
 * <a href="https://github.com/neueda/jetbrains-plugin-graph-database-support">Graph Database Support</a>
 * by Neueda Technologies, Ltd.
 * Modified by Alberto Venturini, 2022
 */
package com.albertoventurini.graphdbplugin.jetbrains.ui.renderes.tree;

import com.albertoventurini.graphdbplugin.jetbrains.ui.datasource.tree.TreeNodeModelApi;
import com.intellij.ui.ColoredTreeCellRenderer;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.ui.components.labels.LinkLabel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class PropertyTreeCellRenderer extends ColoredTreeCellRenderer {

    @Override
    public void customizeCellRenderer(@NotNull JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Object userObject = ((DefaultMutableTreeNode) value).getUserObject();

        if (userObject instanceof TreeNodeModelApi) {
            TreeNodeModelApi model = (TreeNodeModelApi) userObject;

            append(model.getText().orElse("") + ": ", SimpleTextAttributes.REGULAR_BOLD_ATTRIBUTES, true);
            if (model.getDescription().isPresent()) {
                append(model.getDescription().get(), SimpleTextAttributes.GRAYED_SMALL_ATTRIBUTES);
            } else {
                if (model.getValue().isPresent()) {
                    append(model.getValue().get().toString());
                }
            }
        } else if (userObject instanceof LinkLabel) {
            String text = ((LinkLabel) userObject).getText();
            append(text, SimpleTextAttributes.LINK_ATTRIBUTES);
        } else if (userObject != null) {
            append(userObject.toString());
        }
    }
}