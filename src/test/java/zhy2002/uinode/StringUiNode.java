package zhy2002.uinode;

/**
 * Created by john.zhang on 10/12/2016.
 */
public class StringUiNode extends UiNode {

    public String getValue() {
        return (String) getContext().getLatestValue(this, "value");
    }

    public void setValue(String value) {
        getContext().processChangeEvent(this, "value", value);
    }
}
