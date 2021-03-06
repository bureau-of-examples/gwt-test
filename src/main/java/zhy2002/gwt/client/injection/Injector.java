package zhy2002.gwt.client.injection;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import zhy2002.gwt.client.navigation.MasterPage;

@GinModules(InjectorModule.class)
public interface Injector extends Ginjector {

    Injector INSTANCE = GWT.create(Injector.class);

    MasterPage getMasterPage();

    EventBus getEventBus();

}
