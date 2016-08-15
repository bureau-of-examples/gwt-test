package zhy2002.gwt.client.page;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class EmployeeViewImpl extends Composite implements EmployeePresenter.EmployeeView {

    interface EmployeeViewImplUiBinder extends UiBinder<Widget, EmployeeViewImpl> {
    }

    private static EmployeeViewImplUiBinder uiBinder = GWT.create(EmployeeViewImplUiBinder.class);

    public EmployeeViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField
    Button getEmployeeCount;

    public Button getGetEmployeeCountButton() {
        return getEmployeeCount;
    }


}
