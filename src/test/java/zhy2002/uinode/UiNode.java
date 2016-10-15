package zhy2002.uinode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZHY on 11/10/2016.
 */
public abstract class UiNode {

    private String nodeName;
    private UiNodeContext context;
    private UiNode parent;
    private List<UiNodeRule<? extends UiNode, ChangeUiNodeEvent>> rules = new ArrayList<>();

    public String getNodeName() {
        return nodeName;
    }

    void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    void setContext(UiNodeContext context) {
        this.context = context;
    }

    public UiNodeContext getContext() {
        return context;
    }

    public <P extends UiNode> void setParent(P parent) {
        this.parent = parent;
    }

    public UiNode getParent() {
        return parent;
    }

    protected void addChangeRule(UiNodeRule<? extends UiNode, ChangeUiNodeEvent> uiNodeRule) {
        rules.add(uiNodeRule);
    }
}
