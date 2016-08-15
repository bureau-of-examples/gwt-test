package zhy2002.gwt.client.model;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;
import zhy2002.gwt.server.domain.Address;

/**
 * Client proxy for {@link AddressProxy}.
 */
@ProxyFor(Address.class)
public interface AddressProxy extends ValueProxy {

    String getStreet1();

    void setStreet1(String value);

    String getStreet2();

    void setStreet2(String value);

    String getCity();

    void setCity(String value);

    String getSt();

    void setSt(String value);

    String getZip();

    void setZip(String value);
}
