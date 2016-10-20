package zhy2002.uinode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZHY on 11/10/2016.
 */
public abstract class CompositeUiNode extends UiNode {

    private Map<String, UiNode> children = new HashMap<>();

    protected void addChild(UiNode node) {
        if (node.getNodeName() == null)
            throw new UiNodeConfigException("Ui Node must have a name to be a composite child.");

        node.setParent(this);
        node.setContext(this.getContext());
        children.put(node.getNodeName(), node);
    }

    public void recursivelyValidate() {
        getContext().clearAllErrors();
        getContext().clearFiredRule();
        for (UiNode child : children.values()) {
            child.validate();
        }
        validate();
        getContext().clearFiredRule();
    }

    @SuppressWarnings("unchecked")
    protected <C extends UiNode> C getChild(String name) {
        return (C) children.get(name);
    }
}
