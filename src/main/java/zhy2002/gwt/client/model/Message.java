package zhy2002.gwt.client.model;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Overlay type.
 */
public class Message extends JavaScriptObject {

    protected Message() {
    }

    public final native String getMessage() /*-{
        return this.message;
    }-*/;

    public final native String getBy() /*-{
        return this.by;
    }-*/;

    public final native String getTime() /*-{
        return this.time;
    }-*/;
}
