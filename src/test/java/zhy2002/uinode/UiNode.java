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
    private final List<UiNodeRule<? extends UiNode, ChangeUiNodeEvent>> rules = new ArrayList<>();
    private final List<UiNodeRule<? extends UiNode, ChangeUiNodeEvent>> listeners = new ArrayList<>();
    private final List<ValidationRule<? extends UiNode>> validators = new ArrayList<>();

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

    protected <N extends UiNode> void addChangeRule(UiNodeRule<N, ChangeUiNodeEvent> uiNodeRule) {
        uiNodeRule.setHostUiNode((N) this);
        uiNodeRule.init();
        rules.add(uiNodeRule);
    }

    public void addListener(UiNodeRule<? extends UiNode, ChangeUiNodeEvent> uiNodeRule) {
        listeners.add(uiNodeRule);
    }

    public List<UiNodeRule<? extends UiNode, ChangeUiNodeEvent>> getRules() {
        return listeners;
    }

    public List<UiNodeError> getErrors() {
        return getContext().getErrors(this);
    }

    public void clearErrors() {
        getContext().clearErrors(this);
    }

    public void addError(UiNodeError error) {
        getContext().addErrors(this, error);
    }

    public void addValidationRule(ValidationRule<?> validationRule) {
        validators.add(validationRule);
    }

    public void validate() {
        for (ValidationRule<?> validationRule : validators) {
            if (getContext().isRuleFired(validationRule))
                continue;
            validationRule.validate();
            getContext().markRuleFired(validationRule);
        }
    }


    public void setProperty(String propertyName, Object value) {
        getContext().processChangeEvent(this, propertyName, value);
    }

    public Object getProperty(String propertyName) {
        return getContext().getLatestValue(this, propertyName);
    }
}
