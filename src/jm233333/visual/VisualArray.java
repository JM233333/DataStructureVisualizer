package jm233333.visual;

import java.util.*;

/**
 * The {@code VisualArray} class defines the graphic components of an array that is displayed on the monitor.
 * Used in subclasses of {@code VisualizedDataStructure}.
 */
public class VisualArray extends Visual {

    private ArrayList<VisualArrayNode> arrayNode = new ArrayList<>();
    private HashMap<String, VisualIndex> mapIndexField = new HashMap<>();
    
    public VisualArray(String name, int n) {
        // super
        super(name);
        // initialize
        this.getStyleClass().add("visual-array");
        // initialize nodes
        for (int i = 0; i < n; i ++) {
            VisualArrayNode node = new VisualArrayNode();
            node.setLayoutX(node.getWidth() * i);
            arrayNode.add(node);
            this.getChildren().add(node);
        }
    }

    public void addIndexField(String name, int value) {
        VisualIndex indexField = new VisualIndex(name, value);
        VisualArrayNode firstNode = arrayNode.get(0);
        indexField.setLayoutX(firstNode.getLayoutX() + firstNode.getWidth() * value);
        indexField.setLayoutY(firstNode.getLayoutY() + firstNode.getHeight());
        mapIndexField.put(name, indexField);
        this.getChildren().add(indexField);
    }

    public void updateIndexField(String name, int value) {
        VisualIndex indexField = mapIndexField.get(name);
        indexField.setValue(value);
    }

    public void updateElement(int index, int value) {
        VisualArrayNode node = arrayNode.get(index);
        node.setValue(value);
    }

    public void eraseElement(int index) {
        VisualArrayNode node = arrayNode.get(index);
        node.clear();
    }
}
