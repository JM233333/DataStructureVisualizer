package jm233333.visualized;

import javafx.util.Pair;
import jm233333.Director;
import jm233333.ui.CodeTracker;

/**
 * The {@code VisualizedStack} class defines the data structure {@code Stack} for visualizing.
 * Extended from abstract class {@code VisualizedDataStructure}.
 */
public class VisualizedStack extends VisualizedDataStructure {

    private int[] data;
    private int top;
    private ModeStack mode;

    public VisualizedStack(int n) {
        this(n, ModeStack.TOP_TO_UPON);
    }
    public VisualizedStack(int n, ModeStack mode) {
        super();
        data = new int[n];
        top = 0;
        this.mode = mode;
    }

    @Override
    void createVisual() {
        createVisualArray(getName(), data.length, new Pair<>("top", 0));
    }

    public void push(int value) {
        if (_isFull()) {
            trackCodeEntrance(CodeTracker.NEXT_LINE);
            Director.getInstance().playAnimation();
            return;
        }
        trackCodeEntrance(getCodeCurrentMethod() + "_main_begin");
        data[top] = value;
        getVisualArray(getName()).updateElement(top, value);
        trackCodeEntrance(CodeTracker.NEXT_LINE);
        top ++;
        getVisualArray(getName()).updateIndexField("top", top);
        trackCodeEntrance(CodeTracker.NEXT_LINE);
        Director.getInstance().playAnimation();
    }

    public void pop() {
        if (_isEmpty()) {
            trackCodeEntrance(CodeTracker.NEXT_LINE);
            Director.getInstance().playAnimation();
            return;
        }
        trackCodeEntrance(getCodeCurrentMethod() + "_main_begin");
        top --;
        getVisualArray(getName()).updateIndexField("top", top);
        getVisualArray(getName()).eraseElement(top);
        trackCodeEntrance(CodeTracker.NEXT_LINE);
        Director.getInstance().playAnimation();
    }

    public int top() {
        if (_isEmpty()) {
            trackCodeEntrance(CodeTracker.NEXT_LINE);
            Director.getInstance().playAnimation();
            return 0;
        }
        trackCodeEntrance(getCodeCurrentMethod() + "_main_begin");
        trackCodeEntrance(CodeTracker.NEXT_LINE);
        outputMessage(getCodeCurrentMethod() + " " + data[top - 1]);
        Director.getInstance().playAnimation();
        return data[top - 1];
    }

    public boolean isEmpty() {
        boolean flag = (top == 0);
        outputMessage(getCodeCurrentMethod() + " " + (flag ? "true" : "false"));
        Director.getInstance().playAnimation();
        return flag;
    }
    public boolean isFull() {
        boolean flag = (top == data.length);
        outputMessage(getCodeCurrentMethod() + " " + (flag ? "true" : "false"));
        Director.getInstance().playAnimation();
        return flag;
    }

    private boolean _isEmpty() {
        return (top == 0);
    }
    private boolean _isFull() {
        return (top == data.length);
    }

//    public void setMode(ModeStack mode) {
//        if (this.mode == mode) {
//            return;
//        }
//        if (this.mode == ModeStack.TOP_TO_UPON) {
//            for (int i = top; i >= 1; i --) {
//                updateArrayElement("data", i, data[i - 1]);
//            }
//            eraseArrayElement("data", 0);
//        } else {
//            for (int i = 0; i < top; i ++) {
//                updateArrayElement("data", i, data[i + 1]);
//            }
//            eraseArrayElement("data", top);
//        }
//        this.mode = mode;
//        Director.getInstance().playAnimation();
//    }
}
