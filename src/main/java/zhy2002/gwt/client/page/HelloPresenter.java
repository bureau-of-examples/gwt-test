package zhy2002.gwt.client.page;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;
import zhy2002.gwt.client.navigation.GreetingPlace;

import javax.inject.Inject;


public class HelloPresenter extends AbstractActivity {

    @ImplementedBy(HelloViewImpl.class)
    interface HelloView extends IsWidget {
        void setUserName(String userName);
    }

    @Inject
    private HelloView view;
    private GreetingPlace greetingPlace;

    public HelloPresenter() {
    }

    public void init(GreetingPlace greetingPlace) {
        this.greetingPlace = greetingPlace;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view.setUserName(greetingPlace.getUserName());
        panel.setWidget(view.asWidget());
    }
}
