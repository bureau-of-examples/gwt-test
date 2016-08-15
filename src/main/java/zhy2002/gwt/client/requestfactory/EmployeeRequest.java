package zhy2002.gwt.client.requestfactory;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import zhy2002.gwt.client.model.EmployeeProxy;
import zhy2002.gwt.server.domain.Employee;

import java.util.List;

/**
 * Employee related requests.
 */
@Service(Employee.class)
public interface EmployeeRequest extends RequestContext {

    Request<Long> countEmployees();

    Request<List<EmployeeProxy>> findAllEmployees();
}
