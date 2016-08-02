package zhy2002.gwt.client.injection;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.binder.GinScopedBindingBuilder;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import zhy2002.gwt.client.navigation.MasterPage;
import zhy2002.gwt.client.navigation.MasterPageImpl;
import zhy2002.gwt.client.page.GoodbyePresenter;
import zhy2002.gwt.client.page.HelloPresenter;


public class InjectorModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(MasterPage.class).to(MasterPageImpl.class);


    }
}
