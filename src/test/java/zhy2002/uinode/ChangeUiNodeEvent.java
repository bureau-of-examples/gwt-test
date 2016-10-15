package zhy2002.uinode;

/**
 * Created by john.zhang on 10/13/2016.
 */
public class ChangeUiNodeEvent extends UiNodeEvent {

    private final String property;
    private final String value;
    private final Pair<UiNode, String> key;

    public ChangeUiNodeEvent(UiNode uiNode, String property, String value) {
        super(uiNode);

        this.property = property;
        this.value = value;
        this.key = new Pair<>(uiNode, property);
    }

    public String getProperty() {
        return property;
    }

    public String getValue() {
        return value;
    }

    public Pair<UiNode, String> getKey() {
        return key;
    }
}
