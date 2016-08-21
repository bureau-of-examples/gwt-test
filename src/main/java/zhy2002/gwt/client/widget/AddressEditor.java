package zhy2002.gwt.client.widget;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import zhy2002.gwt.client.model.AddressProxy;

public interface AddressEditor extends Editor<AddressProxy> {

    ValueBoxEditor<String> street1Editor();

    ValueBoxEditor<String> street2Editor();

    ValueBoxEditor<String> cityEditor();

    ValueBoxEditor<String> stEditor();

    ValueBoxEditor<String> zipEditor();

}
