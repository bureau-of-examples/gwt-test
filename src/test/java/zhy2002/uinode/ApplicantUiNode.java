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

    public ApplicantDescriptionUiNode getDescription() {
        return getChild("description");
    }

    public ApplicantResidentialStateUiNode getState() {
        return getChild("state");
    }

    public ApplicantResidentialSuburbUiNode getSuburb() {
        return getChild("suburb");
    }

    public ApplicantResidentialPostcodeUiNode getPostcode() {
        return getChild("postcode");
    }

    public void addChangeRule(ChangeUiNodeRuleFactory<ApplicantUiNode> uiNodeRuleFactory) {
        UiNodeRule<ApplicantUiNode, ChangeUiNodeEvent> rule = uiNodeRuleFactory.createRule(this);
        addChangeRule(rule);
    }
}
