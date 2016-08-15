package zhy2002.gwt.client.navigation;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Place object for normal pages.
 */
public class PagePlace extends Place {

    private String pageName;

    public PagePlace(String pageName) {
        this.pageName = pageName;
    }

    public String getPageName() {
        return pageName;
    }

    public static class Tokenizer implements PlaceTokenizer<PagePlace> {
        @Override
        public String getToken(PagePlace place) {
            return place.getPageName();
        }

        @Override
        public PagePlace getPlace(String token) {
            return new PagePlace(token);
        }
    }
}
