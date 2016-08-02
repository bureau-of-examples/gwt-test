package zhy2002.gwt.client.navigation;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppPlaceController extends PlaceController {

    @Inject
    public AppPlaceController(EventBus eventBus) {
        super(eventBus);
    }
}
