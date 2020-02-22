package ganesh.hibernate.caching;

import ganesh.hibernate.hql.Employee;
import org.hibernate.query.Query;

import static ganesh.hibernate.util.HibernateUtil.runWithinTransaction;
import static ganesh.hibernate.util.HibernateUtil.shutdown;

public class CachingRunner {
    /**
     * @param args
     */
    public static void main(String[] args) {
        insertDummyData();
//		firstLevelCacheDemo();
//		secondLevelCacheDemo();
        queryCacheDemo();
        shutdown();
    }

    private static void firstLevelCacheDemo() {
        runWithinTransaction((session) -> {
            Employee employee = session.get(Employee.class, 1);
            Employee employee2 = session.get(Employee.class, 1);
            System.out.println(employee);
            System.out.println(
                    "Calling session.get() same ID again" + "but this time Hibernate doesn't do query/select database again" + "because this is First Level cache which is in the session");
            System.out.println(employee2);

        }, "Caching Demo");
    }

    private static void secondLevelCacheDemo() {
        runWithinTransaction((session) -> {
            Employee employee = session.get(Employee.class, 1);
        }, "Second Level Caching => Inside Session - 1");

        runWithinTransaction((session) -> {
            Employee employee = session.get(Employee.class, 1);
        }, "Second Level Caching => Inside Session - 2");
    }

    private static void queryCacheDemo() {
        runWithinTransaction((session) -> {
            Query query = session.createQuery("from Employee emp where emp.id=1");
            query.setCacheable(true);
            System.out.println(query.getSingleResult());
        }, "Query Caching => Inside Session - 1");

        runWithinTransaction((session) -> {
            Query query = session.createQuery("from Employee emp where emp.id=1");
            query.setCacheable(true);
            System.out.println(query.getSingleResult());
        }, "Query Caching => Inside Session - 2");
    }

    private static void insertDummyData() {
        runWithinTransaction((session) -> {
            session.save(new Employee("Ganesh"));
            session.save(new Employee("Radhika"));
        }, "Creating EMployee");
    }
}
