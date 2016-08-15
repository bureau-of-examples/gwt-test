package zhy2002.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import zhy2002.gwt.client.injection.Injector;
import zhy2002.gwt.client.navigation.MasterPageImpl;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtTest implements EntryPoint {

    /**
     * This is the entry point method.
     */
    @Override
    public void onModuleLoad() {
        MasterPageImpl masterPage = Injector.INSTANCE.getMasterPage();
        RootPanel.get("appContainer").add(masterPage);
    }
}
