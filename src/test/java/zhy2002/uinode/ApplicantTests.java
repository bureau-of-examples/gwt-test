package zhy2002.uinode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ApplicantTests {

    private ApplicantUiNode applicant;

    @BeforeMethod
    public void setup() {
        applicant = LoanUiNodeFactory.createApplicant();
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

    @Test
    public void canUndoChanges() {

        applicant.getName().setValue("Hello");
        assertThat(applicant.getName().getValue(), nullValue());
    }

    @Test
    public void canRestoreToOldValue() {
        applicant.getName().setValue("Hello1");
        applicant.getName().setValue("Hello");

        assertThat(applicant.getName().getValue(), equalTo("Hello1"));
    }

    @Test
    public void canReportError() {

        applicant.getTitle().setValue("Bad");

        assertThat(applicant.getTitle().getErrors(), hasSize(greaterThan(0)));
    }

    @Test
    public void canClearInvalidValue() {

        applicant.getSuburb().setValue("test");

        assertThat(applicant.getSuburb().getValue(), equalTo("test"));

        applicant.getState().setValue("NSW");

        assertThat(applicant.getSuburb().getValue(), nullValue());
    }

    @Test
    public void nameOrPreferredNameIsRequired() {

        applicant.recursivelyValidate();

        assertThat(applicant.getName().getErrors(), hasSize(1));
        assertThat(applicant.getPreferredName().getErrors(), hasSize(1));

        applicant.getPreferredName().setValue("Mr Hank");

        assertThat(applicant.getName().getErrors(), hasSize(0));
        assertThat(applicant.getPreferredName().getErrors(), hasSize(0));

    }
}
