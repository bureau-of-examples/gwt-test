package zhy2002.gwt.client.page;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class PersonViewImpl extends Composite implements PersonPresenter.PersonView {

    interface PersonViewImplUiBinder extends UiBinder<Widget, PersonViewImpl> {
    }

    private static PersonViewImplUiBinder uiBinder = GWT.create(PersonViewImplUiBinder.class);

    public PersonViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
