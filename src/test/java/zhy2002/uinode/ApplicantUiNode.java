package zhy2002.uinode;

/**
 * Created by ZHY on 11/10/2016.
 */
public class ApplicantUiNode extends CompositeUiNode {


    public ApplicantNameUiNode getName() {
        return getChild("name");
    }

    public ApplicantPreferredNameUiNode getPreferredName() {
        return getChild("preferredName");
    }

    public ApplicantTitleUiNode getTitle() {
        return getChild("title");
    }

    public void addChangeRule(ChangeUiNodeRuleFactory<ApplicantUiNode> uiNodeRuleFactory) {
        UiNodeRule<ApplicantUiNode, ChangeUiNodeEvent> rule = uiNodeRuleFactory.createRule(this);
        addChangeRule(rule);
    }
}
