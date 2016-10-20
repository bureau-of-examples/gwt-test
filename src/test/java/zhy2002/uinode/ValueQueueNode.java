package zhy2002.uinode;

/**
 * Created by ZHY on 15/10/2016.
 */
public class ValueQueueNode {
    private final Object value;
    private final ChangeUiNodeEvent changeEvent;
    private ValueQueueNode previous;
    private ValueQueueNode next;

    public ValueQueueNode(ChangeUiNodeEvent changeEvent) {
        this.changeEvent = changeEvent;
        this.value = changeEvent.getValue();
    }

    public Object getValue() {
        return value;
    }

    public ChangeUiNodeEvent getChangeEvent() {
        return changeEvent;
    }

    public Pair<UiNode, String> getKey() {
        return getChangeEvent().getKey();
    }

    public void setPrevious(ValueQueueNode previous) {
        this.previous = previous;
    }

    public void setNext(ValueQueueNode next) {
        this.next = next;
    }

    public ValueQueueNode getNext() {
        return next;
    }
}
