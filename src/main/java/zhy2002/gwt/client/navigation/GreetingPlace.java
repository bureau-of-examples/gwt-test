package zhy2002.gwt.client.navigation;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;


public class GreetingPlace extends Place {

    private String userName;
    private String greeting;

    public GreetingPlace(String greeting, String userName) {
        this.userName = userName;
        this.greeting = greeting;
    }

    public String getUserName() {
        return userName;
    }

    public String getGreeting() {
        return greeting;
    }

    public static class Tokenizer implements PlaceTokenizer<GreetingPlace> {
        @Override
        public String getToken(GreetingPlace place) {
            return place.getGreeting() + "-" + place.getUserName();
        }

        @Override
        public GreetingPlace getPlace(String token) {
            String[] parts = token.split("-");
            return new GreetingPlace(parts[0], parts[1]);
        }
    }

}
