package zhy2002.gwt.client.injection;

import com.google.gwt.core.client.GWT;
import com.google.inject.Provider;
import zhy2002.gwt.client.requestfactory.ExpensesRequestFactory;

class ExpensesRequestFactoryProvider implements Provider<ExpensesRequestFactory> {
    @Override
    public ExpensesRequestFactory get() {
        return GWT.create(ExpensesRequestFactory.class);
    }
}
