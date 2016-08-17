package zhy2002.gwt.client.page;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * A page used to edit a person.
 */
public class PersonPresenter extends AbstractActivity {


    @ImplementedBy(PersonViewImpl.class)
    interface PersonView extends IsWidget {
    }

    @Inject
    private PersonView view;

    public PersonPresenter() {
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        panel.setWidget(view.asWidget());
    }
}
