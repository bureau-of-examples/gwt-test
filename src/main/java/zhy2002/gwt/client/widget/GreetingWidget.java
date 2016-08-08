package zhy2002.gwt.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import zhy2002.gwt.client.model.Greeting;


/**
 * A widget which is used to display a greeting message.
 */
public class GreetingWidget extends Composite {

    interface GreetingWidgetUiBinder extends UiBinder<Widget, GreetingWidget> {
    }

    private static GreetingWidgetUiBinder uiBinder = GWT.create(GreetingWidgetUiBinder.class);

    @UiField
    Panel itemPanel;

    public GreetingWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onLoad() {
        super.onLoad();
//        Greeting defaultGreeting = new Greeting();
//        defaultGreeting.setPhrase("Hello");
//        defaultGreeting.setName("Stranger");
//        defaultGreeting.setTitle("Mr");
//        defaultGreeting.setRepeat(3);
//        update(defaultGreeting);
    }

    public void update(Greeting greeting) {
        if (greeting == null) {
            Window.alert("Greeting is null!");
            return;
        }

        itemPanel.clear();
        int count = greeting.getRepeat();
        if (count <= 0)
            count = 1;
        for (int i = 0; i < count; i++) {
            String text = greeting.getPhrase() + " " + greeting.getTitle() + " " + greeting.getName();
            Label label = new Label(text);
            itemPanel.add(label);
        }
    }
}
