package zhy2002.uinode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by john.zhang on 10/20/2016.
 */
public enum AustraliaStateEnum {

    NSW() {
        @Override
        public List<String> getSuburbs() {
            return Arrays.asList("Wollongong", "Sydney", "Sutherland", "Bulli");
        }
    },
    QLD() {
        @Override
        public List<String> getSuburbs() {
            return Arrays.asList("Gold Coast", "Brisbane", "Canes");
        }
    },
    VIC() {
        @Override
        public List<String> getSuburbs() {
            return Arrays.asList("Wagawaga", "Taronga", "Hulonwa");
        }
    };

    public abstract List<String> getSuburbs();

}
