package zhy2002.uinode;

/**
 * Created by john.zhang on 10/20/2016.
 */
public abstract class ValidationRule<T extends UiNode> {

    protected ValidationRule(T host) {
        this.host = host;
    }

    public T getHost() {
        return host;
    }

    private T host;

    public abstract void validate();


}
