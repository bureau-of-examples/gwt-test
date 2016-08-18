package zhy2002.gwt.client.requestfactory;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import zhy2002.gwt.client.model.PersonProxy;
import zhy2002.gwt.server.requestfactory.PersonServiceLocator;

/**
 * Create person related requests.
 */
@Service(value = PersonServiceLocator.PersonServiceImpl.class, locator = PersonServiceLocator.class)
public interface PersonRequestContext extends RequestContext {

    Request<PersonProxy> testMethod(Long id);

    Request<Void> savePerson(PersonProxy personProxy);
}
