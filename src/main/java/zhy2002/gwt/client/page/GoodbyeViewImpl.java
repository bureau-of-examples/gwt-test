package zhy2002.gwt.client.page;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class GoodbyeViewImpl extends Composite implements GoodbyePresenter.GoodbyeView {

    interface GoodbyeViewImplUiBinder extends UiBinder<Widget, GoodbyeViewImpl> {}
    private static GoodbyeViewImplUiBinder uiBinder = GWT.create(GoodbyeViewImplUiBinder.class);

    @UiField
    Label userNameLabel;

    public GoodbyeViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setUserName(String userName) {
        userNameLabel.setText(userName);
    }

}
