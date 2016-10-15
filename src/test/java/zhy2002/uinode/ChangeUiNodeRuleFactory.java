package zhy2002.uinode;

/**
 * Created by john.zhang on 10/13/2016.
 */
public interface ChangeUiNodeRuleFactory<T extends UiNode> {

    UiNodeRule<T, ChangeUiNodeEvent> createRule(T hostUiNode);
}
