package zhy2002.gwt.client.model;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import zhy2002.gwt.server.domain.Person;

/**
 * Client proxy for {@link zhy2002.gwt.server.domain.Person}.
 */
@ProxyFor(Person.class)
public interface PersonProxy extends EntityProxy {

    Long getId();

    void setId(Long id);

    Integer getVersion();

    void setVersion(Integer version);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    AddressProxy getAddress();

    void setAddress(AddressProxy address);
}
