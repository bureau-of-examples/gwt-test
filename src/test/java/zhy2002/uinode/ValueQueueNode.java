package zhy2002.uinode;

/**
 * Created by ZHY on 15/10/2016.
 */
public class ValueQueueNode {
    private final String value;
    private final ChangeUiNodeEvent changeEvent;
    private ValueQueueNode previous;
    private ValueQueueNode next;

    public ValueQueueNode(ChangeUiNodeEvent changeEvent) {
        this.changeEvent = changeEvent;
        this.value = changeEvent.getValue();
    }

    public String getValue() {
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
}
