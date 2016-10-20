package zhy2002.uinode;

/**
 * Created by john.zhang on 10/19/2016.
 */
public class NameCheckRule extends UiNodeRule<ApplicantNameUiNode, ChangeUiNodeEvent> {

    protected NameCheckRule(ApplicantNameUiNode hostUiNode) {
        super(hostUiNode);
    }

    protected ApplicantNameUiNode getName() {
        return getHostUiNode();
    }

    @Override
    public void fire(ChangeUiNodeEvent event) {
        if("Hello".equals(getName().getValue())) {
            throw new InvalidUiNodeChangeException();
        }
    }

    @Override
    public void init() {
        getName().addListener(this);
    }
}
