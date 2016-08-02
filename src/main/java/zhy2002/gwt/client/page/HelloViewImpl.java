package zhy2002.gwt.client.page;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class HelloViewImpl extends Composite implements HelloPresenter.HelloView {

    interface HelloViewImplUiBinder extends UiBinder<Widget, HelloViewImpl> {}
    private static HelloViewImplUiBinder uiBinder = GWT.create(HelloViewImplUiBinder.class);

    @UiField
    Label userNameLabel;

    public HelloViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setUserName(String userName){
        userNameLabel.setText(userName);
    }
}
