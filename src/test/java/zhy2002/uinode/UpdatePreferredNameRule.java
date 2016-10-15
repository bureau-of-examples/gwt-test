package zhy2002.uinode;

/**
 * Created by john.zhang on 10/12/2016.
 */
public class UpdatePreferredNameRule extends UiNodeRule<ApplicantUiNode, ChangeUiNodeEvent> {

    protected UpdatePreferredNameRule(ApplicantUiNode hostUiNode) {
        super(hostUiNode);
    }

    protected ApplicantTitleUiNode getTitle() {
        return getHostUiNode().getTitle();
    }

    protected ApplicantNameUiNode getName() {
        return getHostUiNode().getName();
    }

    protected ApplicantPreferredNameUiNode getPreferredName() {
        return getHostUiNode().getPreferredName();
    }

    public void fire(ChangeUiNodeEvent event) {
        if(getTitle().getValue() != null && getName().getValue() != null && getPreferredName().getValue() == null) {
            String preferredName = getTitle().getValue() + " " + getName().getValue();
            getPreferredName().setValue(preferredName);
        }
    }

}
