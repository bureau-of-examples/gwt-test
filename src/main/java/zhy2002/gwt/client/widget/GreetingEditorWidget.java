package zhy2002.gwt.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import zhy2002.gwt.client.GreetingService;
import zhy2002.gwt.client.GreetingServiceAsync;
import zhy2002.gwt.client.model.Greeting;

/**
 * Greeting editor.
 */
public class GreetingEditorWidget extends Composite {
    interface GreetingEditorWidgetUiBinder extends UiBinder<Widget, GreetingEditorWidget> {
    }

    private static GreetingEditorWidgetUiBinder uiBinder = GWT.create(GreetingEditorWidgetUiBinder.class);

    interface Driver extends SimpleBeanEditorDriver<Greeting, GreetingEditor> {
    }

    private Driver driver = GWT.create(Driver.class);

    @UiField
    TextBox phraseTextBox;
    @UiField
    TextBox titleTextBox;
    @UiField
    TextBox nameTextBox;
    @UiField
    IntegerBox repeatIntegerBox;
    @UiField
    Button okButton;
    @UiField
    GreetingWidget greetingWidget;

    private GreetingEditor editor;

    private GreetingServiceAsync greetingService;

    public GreetingEditorWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        this.editor = new GreetingEditor(phraseTextBox, titleTextBox, nameTextBox, repeatIntegerBox);
        driver.initialize(editor);
        Greeting defaultGreeting = new Greeting();
        defaultGreeting.setName("Stranger");
        defaultGreeting.setPhrase("Hello");
        defaultGreeting.setTitle("");
        defaultGreeting.setRepeat(1);
        driver.edit(defaultGreeting);
    }

    @UiHandler("okButton")
    void handleOkButtonClick(ClickEvent e) {
        Greeting greeting = driver.flush();
        greetingWidget.update(greeting);
    }

    @UiHandler("serverButton")
    void handleServerButtonClick(ClickEvent e) {
        if (greetingService == null) {
            greetingService = GWT.create(GreetingService.class);
        }
        greetingService.greetServer(nameTextBox.getValue(), new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Error: " + caught.getMessage());
            }

            @Override
            public void onSuccess(String result) {
                Window.alert(result);
            }
        });
    }
}
