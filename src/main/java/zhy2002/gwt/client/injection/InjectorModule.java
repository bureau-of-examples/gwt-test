package zhy2002.gwt.client.injection;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import zhy2002.gwt.client.navigation.MasterPage;
import zhy2002.gwt.client.navigation.MasterPageImpl;
import zhy2002.gwt.client.requestfactory.ExpensesRequestFactory;


public class InjectorModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(MasterPage.class).to(MasterPageImpl.class);
        bind(ExpensesRequestFactory.class).toProvider(ExpensesRequestFactoryProvider.class).in(Singleton.class);
    }
}
