package zhy2002.gwt.client.navigation;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;
import zhy2002.gwt.client.page.GoodbyePresenter;
import zhy2002.gwt.client.page.HelloPresenter;

public class AppActivityMapper implements ActivityMapper {

    @Inject
    private Provider<HelloPresenter> helloPresenterProvider;
    @Inject
    private Provider<GoodbyePresenter> goodbyePresenterProvider;

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof GreetingPlace) {
            GreetingPlace greetingPlace = (GreetingPlace) place;
            if ("hello".equals(greetingPlace.getGreeting())) {
                HelloPresenter helloPresenter = helloPresenterProvider.get();
                helloPresenter.init(greetingPlace);
                return helloPresenter;
            } else if ("goodbye".equals(greetingPlace.getGreeting())) {
                GoodbyePresenter goodbyePresenter = goodbyePresenterProvider.get();
                goodbyePresenter.init(greetingPlace);
                goodbyePresenter.init(greetingPlace);
                return goodbyePresenter;
            }
        }
        return null;
    }
}
