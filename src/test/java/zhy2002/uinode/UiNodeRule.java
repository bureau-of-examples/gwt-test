package zhy2002.uinode;

/**
 * Created by john.zhang on 10/12/2016.
 */
public abstract class UiNodeRule<T extends UiNode, E extends UiNodeEvent> {

    private T hostUiNode;

    protected UiNodeRule() {
    }

    protected UiNodeRule(T hostUiNode) {
        this.hostUiNode = hostUiNode;
    }

    public T getHostUiNode() {
        return hostUiNode;
    }

    public void setHostUiNode(T hostUiNode) {
        this.hostUiNode = hostUiNode;
    }

    public abstract void fire(E event);

    public abstract void init();
}
