package zhy2002.gwt.server.requestfactory;

import com.google.web.bindery.requestfactory.shared.Locator;
import zhy2002.gwt.server.domain.Person;

/**
 * Locator for person domain object.
 */
public class PersonLocator extends Locator<Person, Long> {

    @Override
    public Person create(Class<? extends Person> clazz) {
        return new Person();
    }

    //used by the default implementation of isAlive.
    //this is called unnecessarily when you handle findById type of requests.
    @Override
    public Person find(Class<? extends Person> clazz, Long id) {
        return PersonServiceLocator.PERSON_SERVICE.testMethod(id);
    }

    @Override
    public Class<Person> getDomainType() {
        return Person.class;
    }

    @Override
    public Long getId(Person domainObject) {
        return domainObject.getId();
    }

    @Override
    public Class<Long> getIdType() {
        return Long.class;
    }

    @Override
    public Object getVersion(Person domainObject) {
        return domainObject.getVersion();
    }
}
