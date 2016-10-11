package zhy2002.uinode;

/**
 * Created by ZHY on 11/10/2016.
 */
public class ApplicantUiNode extends CompositeUiNode {

    public ApplicantNameUiNode getName() {
        return getChild("name");
    }
}
