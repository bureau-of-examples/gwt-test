package zhy2002.uinode;

/**
 * Created by ZHY on 11/10/2016.
 */
public class LoanUiNodeFactory {
    public static ApplicantUiNode createApplicant() {
        ApplicantUiNode applicant = new ApplicantUiNode();
        ApplicantNameUiNode name = new ApplicantNameUiNode();
        name.setNodeName("name");
        applicant.addChild(name);
        return applicant;
    }
}
