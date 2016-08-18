package zhy2002.gwt.client.page;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.*;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import zhy2002.gwt.client.model.EmployeeProxy;
import zhy2002.gwt.client.model.Message;

import java.util.List;

public class EmployeeViewImpl extends Composite implements EmployeePresenter.EmployeeView {

    interface EmployeeViewImplUiBinder extends UiBinder<Widget, EmployeeViewImpl> {
    }

    private static EmployeeViewImplUiBinder uiBinder = GWT.create(EmployeeViewImplUiBinder.class);

    public EmployeeViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField
    Button getEmployeeCount;

    @UiField
    Button showEmployees;

    @UiField
    Button getPerson;

    @UiField
    FlexTable employeeList;

    @UiField
    InlineLabel messageLabel;

    @UiField
    InlineLabel byLabel;

    @UiField
    InlineLabel timeLabel;

    public Button getGetEmployeeCountButton() {
        return getEmployeeCount;
    }

    public Button getShowEmployeesButton() {
        return showEmployees;
    }

    public Button getGetPersonButton() {
        return getPerson;
    }

    public void updateEmployees(List<EmployeeProxy> employeeProxyList) {
        employeeList.clear();
        employeeList.setText(0, 0, "Name");
        for (int i = 0; i < employeeProxyList.size(); i++) {
            employeeList.setText(i + 1, 0, employeeProxyList.get(i).getDisplayName());
        }
    }

    @UiHandler("getMessage")
    void handleGetMessageClicked(ClickEvent e) {
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, "json/test1.json");

        try {
            builder.sendRequest(null, new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    if (200 == response.getStatusCode()) {
                        showMessage(JsonUtils.<Message>safeEval(response.getText()));
                    } else {
                        Window.alert("Error:" + response.getStatusText());
                    }
                }

                @Override
                public void onError(Request request, Throwable exception) {
                    Window.alert("Error:" + exception.getMessage());
                }
            });
        } catch (RequestException ex) {
            throw new RuntimeException(ex);
        }

    }

    private void showMessage(Message message) {
        messageLabel.setText(message.getMessage());
        byLabel.setText(message.getBy());
        timeLabel.setText(message.getTime());
    }
}
