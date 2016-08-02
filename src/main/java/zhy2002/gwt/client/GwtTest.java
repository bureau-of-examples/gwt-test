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
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    //private static final String SERVER_ERROR = "An error occurred while "
    //        + "attempting to contact the server. Please check your network "
    //        + "connection and try again.";

    /**
     * Create a remote service proxy to talk to the server-side Greeting service.
     */
    //private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);


    //private final Messages messages = GWT.create(Messages.class);

    /**
     * This is the entry point method.
     */
    @Override
    public void onModuleLoad() {
        MasterPageImpl masterPage = Injector.INSTANCE.getMasterPage();
        RootPanel.get("appContainer").add(masterPage);
    }
}