package zhy2002.gwt.client.page;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.shared.Receiver;
import zhy2002.gwt.client.model.AddressProxy;
import zhy2002.gwt.client.model.PersonProxy;
import zhy2002.gwt.client.requestfactory.ExpensesRequestFactory;
import zhy2002.gwt.client.requestfactory.PersonRequestContext;
import zhy2002.gwt.client.widget.AddressEditor;

import javax.inject.Inject;
import java.util.List;

public class PersonViewImpl extends Composite implements PersonPresenter.PersonView, IsEditor<PersonEditor> {

    interface PersonViewImplUiBinder extends UiBinder<Widget, PersonViewImpl> {
    }

    private static PersonViewImplUiBinder uiBinder = GWT.create(PersonViewImplUiBinder.class);

    interface Driver extends SimpleBeanEditorDriver<PersonProxy, PersonEditor> {
    }

    private Driver driver = GWT.create(Driver.class);

    @UiField
    ValueBoxEditorDecorator<String> firstNameTextBox;

    @UiField
    ValueBoxEditorDecorator<String> lastNameTextBox;

    @UiField
    IsEditor<AddressEditor> addressEditor;

    @UiField
    TextBox idTextBox;

    @Inject
    private ExpensesRequestFactory requestFactory;

    PersonRequestContext personRequestContext;

    private PersonEditor editor = new PersonEditor() {
        @Override
        public ValueBoxEditor<String> firstNameEditor() {
            return firstNameTextBox.asEditor();
        }

        @Override
        public ValueBoxEditor<String> lastNameEditor() {
            return lastNameTextBox.asEditor();
        }

        @Override
        public AddressEditor addressEditor() {
            return addressEditor.asEditor();
        }
    };

    public PersonViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
        setWidgetIds();
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        driver.initialize(this.asEditor());
        personRequestContext = requestFactory.personRequestContext();
        driver.edit(personRequestContext.create(PersonProxy.class));
    }

    private void setWidgetIds() {
        firstNameTextBox.getElement().setId("firstNameTexBox");
        lastNameTextBox.getElement().setId("lastNameTexBox");
    }

    @Override
    public PersonEditor asEditor() {
        return editor;
    }

    @UiHandler("createButton")
    void handelCreateButtonClicked(ClickEvent e) {
        PersonProxy personProxy = personRequestContext.create(PersonProxy.class);
        personProxy.setFirstName("New");
        personProxy.setLastName("Person");
        personProxy.setAddress(personRequestContext.create(AddressProxy.class));
        personProxy.getAddress().setStreet1("type line 1 here");
        driver.edit(personProxy);
    }

    private static boolean isEmpty(String val) {
        return val == null || val.length() == 0;
    }

    private boolean validate(PersonProxy personProxy) {
        boolean validate = true;
        if (isEmpty(personProxy.getFirstName())) {
            firstNameTextBox.asEditor().getDelegate().recordError("cannot be empty man", null, null);
            validate = false;
        }
        if (isEmpty(personProxy.getLastName())) {
            lastNameTextBox.asEditor().getDelegate().recordError("cannot be empty mate", null, null);
            validate = false;
        }
        return validate;
    }

    private void showErrors() {
        (new Timer() {
            @Override
            public void run() {
                driver.flush();
                List<EditorError> errorList = driver.getErrors();
                firstNameTextBox.showErrors(errorList);
                lastNameTextBox.showErrors(errorList);
                for (EditorError error : errorList) {
                    error.setConsumed(true);
                }
            }
        }).schedule(1);
    }

    @UiHandler("saveButton")
    void handleSaveButtonClicked(ClickEvent e) {
        PersonProxy personProxy = driver.flush();
        //validation
        if (!validate(personProxy)) {
            showErrors();
            return;
        }

        personRequestContext.savePerson(personProxy).with("address").fire(new Receiver<PersonProxy>() {
            @Override
            public void onSuccess(final PersonProxy response) {

                (new Timer() {
                    public void run() {
                        idTextBox.setText(String.valueOf(response.getId()));
                        personRequestContext = requestFactory.personRequestContext(); //must start a new context when editing a new object.
                        driver.edit(personRequestContext.edit(response));
                    }
                }).schedule(10);
            }
        });
    }

    @UiHandler("loadButton")
    void handleLoadButtonClicked(ClickEvent e) {
        int id;

        try {
            id = Integer.parseInt(idTextBox.getValue());
        } catch (Exception ex) {
            Window.alert("Invalid person id: " + idTextBox.getValue());
            return;
        }
        personRequestContext.testMethod((long) id).with("address").fire(new Receiver<PersonProxy>() {
            @Override
            public void onSuccess(final PersonProxy response) {
                if (response == null) {
                    Window.alert("Person not found.");
                    return;
                }
                (new Timer() {
                    @Override
                    public void run() {
                        personRequestContext = requestFactory.personRequestContext();
                        driver.edit(personRequestContext.edit(response));
                    }
                }).schedule(10);

            }
        });

    }

}
