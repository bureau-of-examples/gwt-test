package zhy2002.gwt.client.page;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class PersonViewImpl extends Composite implements PersonPresenter.PersonView {

    interface PersonViewImplUiBinder extends UiBinder<Widget, PersonViewImpl> {
    }

    private static PersonViewImplUiBinder uiBinder = GWT.create(PersonViewImplUiBinder.class);

    @UiField
    TextBox firstNameTextBox;

    @UiField
    TextBox lastNameTextBox;

    public PersonViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
        firstNameTextBox.getElement().setId("firstNameTexBox");
        lastNameTextBox.getElement().setId("lastNameTexBox");
    }

    @UiHandler("okButton")
    void handleOkButtonClicked(ClickEvent e) {
        Window.alert("the person is:" + firstNameTextBox.getText() + " " + lastNameTextBox.getText());
    }
}
