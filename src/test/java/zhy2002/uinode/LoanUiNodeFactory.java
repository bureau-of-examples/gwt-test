package zhy2002.uinode;

/**
 * Created by ZHY on 11/10/2016.
 */
public class LoanUiNodeFactory {
    public static ApplicantUiNode createApplicant() {
        LoanUiNodeContext context = new LoanUiNodeContext();
        ApplicantUiNode applicant = new ApplicantUiNode();
        applicant.setContext(context);

        ApplicantTitleUiNode title = new ApplicantTitleUiNode();
        title.setNodeName("title");
        applicant.addChild(title);

        ApplicantNameUiNode name = new ApplicantNameUiNode();
        name.setNodeName("name");
        applicant.addChild(name);

        ApplicantPreferredNameUiNode preferredName = new ApplicantPreferredNameUiNode();
        preferredName.setNodeName("preferredName");
        applicant.addChild(preferredName);

        ApplicantDescriptionUiNode description = new ApplicantDescriptionUiNode();
        description.setNodeName("description");
        applicant.addChild(description);

        ApplicantResidentialPostcodeUiNode postcode = new ApplicantResidentialPostcodeUiNode();
        postcode.setNodeName("postcode");
        applicant.addChild(postcode);

        ApplicantResidentialSuburbUiNode suburb = new ApplicantResidentialSuburbUiNode();
        suburb.setNodeName("suburb");
        applicant.addChild(suburb);

        ApplicantResidentialStateUiNode state = new ApplicantResidentialStateUiNode();
        state.setNodeName("state");
        applicant.addChild(state);

        applicant.addChangeRule(new ChangeUiNodeRuleFactory<ApplicantUiNode>() {
            @Override
            public UiNodeRule<ApplicantUiNode, ChangeUiNodeEvent> createRule(ApplicantUiNode hostUiNode) {
                return new UpdatePreferredNameRule(hostUiNode);
            }
        });

        applicant.addChangeRule(new ChangeUiNodeRuleFactory<ApplicantUiNode>() {
            @Override
            public UiNodeRule<ApplicantUiNode, ChangeUiNodeEvent> createRule(ApplicantUiNode hostUiNode) {
                return new UpdateDescriptionRule(hostUiNode);
            }
        });

        name.addChangeRule(new ChangeUiNodeRuleFactory<ApplicantNameUiNode>() {

            @Override
            public UiNodeRule<ApplicantNameUiNode, ChangeUiNodeEvent> createRule(ApplicantNameUiNode hostUiNode) {
                return new NameCheckRule(hostUiNode);
            }
        });

        suburb.addChangeRule(new UpdateSuburbListRule());

        title.addValidationRule(new TitleIsValidRule(title));

        NameOrPreferredNameIsRequiredRule rule = new NameOrPreferredNameIsRequiredRule(applicant);
        name.addValidationRule(rule);
        preferredName.addValidationRule(rule);

        return applicant;
    }
}
