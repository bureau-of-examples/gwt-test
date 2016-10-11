package zhy2002.uinode;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class ApplicantTests {

    @Test
    public void canCreateApplicant() {

        LoanUiNodeContext loanUiNodeContext = new LoanUiNodeContext();
        ApplicantUiNode applicant = LoanUiNodeFactory.createApplicant();
        loanUiNodeContext.addRootUiNode(applicant);
        
        assertThat(applicant.getName(), instanceOf(ApplicantNameUiNode.class));
        //assertThat(applicant.getName(), instanceOf(ApplicantNameUiNode.class));
    }


}
