package zhy2002.gwt.server.requestfactory;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;
import zhy2002.gwt.server.domain.Address;
import zhy2002.gwt.server.domain.Person;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Person service locator.
 */
public class PersonServiceLocator implements ServiceLocator {

    public static final PersonServiceImpl PERSON_SERVICE = new PersonServiceImpl();

    @Override
    public Object getInstance(Class<?> clazz) {
        return PERSON_SERVICE;
    }

    public static class PersonServiceImpl {
        private static final Map<Long, Person> people = new ConcurrentHashMap<>();
        private static final AtomicLong idSequence = new AtomicLong(0);

        static {
            Person first = new Person();
            first.setId(idSequence.incrementAndGet());
            first.setFirstName("Jon");
            first.setLastName("Snow");
            first.setAddress(new Address());
            first.getAddress().setCity("Castle Black");
            people.put(first.getId(), first);
        }

        public Person testMethod(Long id) {
            return people.get(id);
        }

        public Person savePerson(Person person) {
            if (person.getId() == null) {
                person.setId(idSequence.incrementAndGet());
            }
            people.put(person.getId(), person);
            return person;
        }
    }
}


