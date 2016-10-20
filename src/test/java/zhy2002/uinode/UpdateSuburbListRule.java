package zhy2002.uinode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john.zhang on 10/20/2016.
 */
public class UpdateSuburbListRule extends UiNodeRule<ApplicantResidentialSuburbUiNode, ChangeUiNodeEvent> {

    protected ApplicantResidentialStateUiNode getState() {
        return getHostUiNode().getParent().getState();
    }

    protected ApplicantResidentialSuburbUiNode getSuburb() {
        return getHostUiNode();
    }

    @Override
    public void fire(ChangeUiNodeEvent event) {

        List<String> suburbList = new ArrayList<>();
        String stateName = getState().getValue();
        if (stateName != null) {
            AustraliaStateEnum state = AustraliaStateEnum.valueOf(stateName);
            suburbList.addAll(state.getSuburbs());
        }

        getSuburb().setProperty("options", suburbList);
        if (!suburbList.contains(getSuburb().getValue())) {
            getSuburb().setValue(null);
        }
    }

    @Override
    public void init() {
        getState().addListener(this);
    }
}
