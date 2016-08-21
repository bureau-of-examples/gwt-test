package zhy2002.gwt.client.widget;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.TextBox;
import zhy2002.gwt.client.model.Greeting;

class GreetingEditor implements Editor<Greeting> {

    final ValueBoxEditor<String> phraseEditor;
    final ValueBoxEditor<String> titleEditor;
    final ValueBoxEditor<String> nameEditor;
    final ValueBoxEditor<Integer> repeatEditor;

    GreetingEditor(
            TextBox phraseValueBox,
            TextBox titleValueBox,
            TextBox nameValueBox,
            IntegerBox repeatIntegerBox
    ) {
        this.phraseEditor = ValueBoxEditor.of(phraseValueBox);
        this.titleEditor = ValueBoxEditor.of(titleValueBox);
        this.nameEditor = ValueBoxEditor.of(nameValueBox);
        this.repeatEditor = ValueBoxEditor.of(repeatIntegerBox);
    }
}
