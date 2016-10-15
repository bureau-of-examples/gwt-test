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

        applicant.addChangeRule(new ChangeUiNodeRuleFactory<ApplicantUiNode>() {
            @Override
            public UiNodeRule<ApplicantUiNode, ChangeUiNodeEvent> createRule(ApplicantUiNode hostUiNode) {
                return new UpdatePreferredNameRule(hostUiNode);
            }
        });

        return applicant;
    }
}
