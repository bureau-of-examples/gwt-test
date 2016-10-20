package zhy2002.uinode;

/**
 * Created by ZHY on 11/10/2016.
 */
public class ApplicantNameUiNode extends StringUiNode {


    public void addChangeRule(ChangeUiNodeRuleFactory<ApplicantNameUiNode> uiNodeRuleFactory) {
        UiNodeRule<ApplicantNameUiNode, ChangeUiNodeEvent> rule = uiNodeRuleFactory.createRule(this);
        addChangeRule(rule);
    }
}
