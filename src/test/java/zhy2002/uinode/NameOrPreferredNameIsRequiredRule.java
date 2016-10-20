package zhy2002.uinode;

/**
 * Created by ZHY on 20/10/2016.
 */
public class NameOrPreferredNameIsRequiredRule extends ValidationRule<ApplicantUiNode> {

    public NameOrPreferredNameIsRequiredRule(ApplicantUiNode applicant) {
        super(applicant);
    }

    protected ApplicantNameUiNode getName() {
        return getHost().getName();
    }

    protected ApplicantPreferredNameUiNode getPreferredName() {
        return getHost().getPreferredName();
    }

    @Override
    public void validate() {
        getName().clearErrors();
        getPreferredName().clearErrors();
        if (getName().getValue() == null && getPreferredName().getValue() == null) {
            getName().addError(new UiNodeError());
            getPreferredName().addError(new UiNodeError());
        }
    }


}
