package zhy2002.uinode;

/**
 * Created by john.zhang on 10/13/2016.
 */
public abstract class UiNodeEvent {
    private final UiNode uiNode;

    public UiNodeEvent(UiNode uiNode) {
        this.uiNode = uiNode;
    }

    public UiNode getUiNode() {
        return uiNode;
    }
}
