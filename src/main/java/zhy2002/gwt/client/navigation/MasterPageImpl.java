package zhy2002.gwt.client.navigation;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import javax.inject.Singleton;

@Singleton
public class MasterPageImpl extends Composite implements MasterPage {

    interface MasterPageImplUiBinder extends UiBinder<Widget, MasterPageImpl> {
    }

    private static MasterPageImplUiBinder uiBinder = GWT.create(MasterPageImplUiBinder.class);

    @UiField
    SimplePanel viewContainer;

    @Inject
    private EventBus eventBus;
    @Inject
    private AppPlaceController placeController;
    @Inject
    AppActivityMapper appActivityMapper;

    public MasterPageImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityManager activityManager = new ActivityManager(appActivityMapper, eventBus);
        if (viewContainer == null)
            throw new RuntimeException("oh no");
        activityManager.setDisplay(viewContainer);

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        Place defaultPlace = new GreetingPlace("hello", "john");
        historyHandler.register(placeController, eventBus, defaultPlace);

        // Goes to the place represented on URL else default place
        historyHandler.handleCurrentHistory();

    }

    @UiHandler("page1Link")
    void handlePage1LinkClick(ClickEvent e) {
        placeController.goTo(new GreetingPlace("hello", "John"));
    }

    @UiHandler("page2Link")
    void handlePage2LinkClick(ClickEvent e) {
        placeController.goTo(new GreetingPlace("goodbye", "John"));
    }

    @UiHandler("page3Link")
    void handlePage3LinkClick(ClickEvent e) {
        placeController.goTo(new PagePlace("employee"));
    }
}
