package zhy2002.uinode;

/**
 * Created by ZHY on 18/10/2016.
 */
public class UpdateDescriptionRule extends UiNodeRule<ApplicantUiNode, ChangeUiNodeEvent> {
    protected UpdateDescriptionRule(ApplicantUiNode hostUiNode) {
        super(hostUiNode);
    }

    protected ApplicantPreferredNameUiNode getPreferredName() {
        return getHostUiNode().getPreferredName();
    }

    protected ApplicantDescriptionUiNode getDescription() {
        return getHostUiNode().getDescription();
    }

    @Override
    public void fire(ChangeUiNodeEvent event) {
        if (getPreferredName().getValue() != null) {
            getDescription().setValue(getPreferredName().getValue() + "'s application");
        }
    }

    @Override
    public void init() {
        getPreferredName().addListener(this);
    }


}
