package zhy2002.gwt.client.page;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import zhy2002.gwt.client.model.PersonProxy;
import zhy2002.gwt.client.widget.AddressEditor;

public interface PersonEditor extends Editor<PersonProxy> {

    ValueBoxEditor<String> firstNameEditor();

    ValueBoxEditor<String> lastNameEditor();

    AddressEditor addressEditor();
}
