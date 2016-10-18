package zhy2002.uinode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

public class ApplicantTests {

    private ApplicantUiNode applicant;

    @BeforeMethod
    public void setup() {
        LoanUiNodeContext loanUiNodeContext = new LoanUiNodeContext();
        applicant = LoanUiNodeFactory.createApplicant();
        loanUiNodeContext.addRootUiNode(applicant);
    }

    @Test
    public void canCreateApplicant() {

        assertThat(applicant.getTitle(), instanceOf(ApplicantTitleUiNode.class));
        assertThat(applicant.getName(), instanceOf(ApplicantNameUiNode.class));
        assertThat(applicant.getPreferredName(), instanceOf(ApplicantPreferredNameUiNode.class));
    }


    @Test
    public void canRetrieveSetValue() {
        final String TEST_TITLE = "Mr";

        applicant.getTitle().setValue(TEST_TITLE);

        assertThat(applicant.getTitle().getValue(), equalTo(TEST_TITLE));
    }

    @Test
    public void whenTitleOrNameChangesPreferredNameIsUpdated() {
        applicant.getTitle().setValue("Mr");
        applicant.getName().setValue("Rambo");

        assertThat(applicant.getPreferredName().getValue(), equalTo("Mr Rambo"));
    }

    @Test
    public void canDoCascadeUpdate() {
        applicant.getTitle().setValue("Mr");
        applicant.getName().setValue("Rambo");

        assertThat(applicant.getDescription().getValue(), equalTo("Mr Rambo's application"));
    }

}
