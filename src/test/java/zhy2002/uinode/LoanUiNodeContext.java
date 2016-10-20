package zhy2002.uinode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZHY on 11/10/2016.
 */
public class LoanUiNodeContext extends UiNodeContext {

    public LoanUiNodeContext() {

    }

    private List<UiNode> rootUiNodes = new ArrayList<>();

    public void addRootUiNode(ApplicantUiNode applicant) {
        applicant.setContext(this);
        rootUiNodes.add(applicant);
    }
}
