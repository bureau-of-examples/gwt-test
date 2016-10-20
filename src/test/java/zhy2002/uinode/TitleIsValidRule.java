package zhy2002.uinode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by john.zhang on 10/20/2016.
 */
public class TitleIsValidRule extends ValidationRule<ApplicantTitleUiNode> {

    protected TitleIsValidRule(ApplicantTitleUiNode host) {
        super(host);
    }

    private static final List<String> VALID_TITLES = Arrays.asList("Mr", "Ms");

    @Override
    public void validate() {
        String value = getHost().getValue();
        if(!VALID_TITLES.contains(value)) {
            getHost().addError(new UiNodeError());
        }
    }
}
