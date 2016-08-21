package zhy2002.gwt.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import zhy2002.gwt.client.model.AddressProxy;

public class AddressEditorWidget extends Composite implements IsEditor<AddressEditor> {

    interface AddressEditorWidgetUiBinder extends UiBinder<Widget, AddressEditorWidget> {
    }

    private static final AddressEditorWidgetUiBinder uiBinder = GWT.create(AddressEditorWidgetUiBinder.class);

    interface Driver extends SimpleBeanEditorDriver<AddressProxy, AddressEditor> {
    }

    private final Driver driver = GWT.create(Driver.class);

    private AddressEditor editor = new AddressEditor() {
        @Override
        public ValueBoxEditor<String> street1Editor() {
            return street1TextBox.asEditor();
        }

        @Override
        public ValueBoxEditor<String> street2Editor() {
            return street2TextBox.asEditor();
        }

        @Override
        public ValueBoxEditor<String> cityEditor() {
            return cityTextBox.asEditor();
        }

        @Override
        public ValueBoxEditor<String> stEditor() {
            return stateTextBox.asEditor();
        }

        @Override
        public ValueBoxEditor<String> zipEditor() {
            return zipTextBox.asEditor();
        }
    };

    @UiField
    ValueBoxEditorDecorator<String> street1TextBox;
    @UiField
    ValueBoxEditorDecorator<String> street2TextBox;
    @UiField
    ValueBoxEditorDecorator<String> cityTextBox;
    @UiField
    ValueBoxEditorDecorator<String> stateTextBox;
    @UiField
    ValueBoxEditorDecorator<String> zipTextBox;

    public AddressEditorWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        driver.initialize(this.asEditor());
    }

    @Override
    public AddressEditor asEditor() {
        return editor;
    }
}
