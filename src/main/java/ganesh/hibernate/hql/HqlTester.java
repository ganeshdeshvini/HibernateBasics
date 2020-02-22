package ganesh.hibernate.hql;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

import static ganesh.hibernate.util.HibernateUtil.runWithinTransaction;
import static ganesh.hibernate.util.HibernateUtil.shutdown;

public class HqlTester {
    public static void main(String[] args) {
        createDummyEmployees();
//		createQueryDemoWithPagination();
        demoNamedQuery();
        demoNamedNativeQuery();
        demoCriteriaQuery();
        shutdown();
    }

    private static void createDummyEmployees() {
        runWithinTransaction((session) -> {
            for (int i = 1; i <= 10; i++) {
                session.save(new Employee("employee-" + i));
            }
            return;
        });
    }

    private static void createQueryDemoWithPagination() {
        runWithinTransaction((session) -> {
            String userId = "5";
            String name = "employee-6";
            String query = "select u from Employee u";
            String query2 = "select name from Employee where id > :id and name=:name";
            Query<Employee> selectQuery = session.createQuery(query2);
            selectQuery.setParameter("id", new Integer(userId));
            selectQuery.setParameter("name", name);

            // for Pagination limit & offset
            selectQuery.setFirstResult(1);
            selectQuery.setMaxResults(5);

            List<Employee> results = selectQuery.getResultList();
            System.out.println(results);
            return;
        });
    }

    private static void demoNamedQuery() {
        runWithinTransaction((session) -> {
            Query namedQuery = session.getNamedQuery("Employee.byId");
            namedQuery.setParameter("id", 4);
            System.out.println(namedQuery.getResultList());
        }, "NAMEDQUERY");
    }

    private static void demoNamedNativeQuery() {
        runWithinTransaction((session) -> {
            Query namedQuery = session.getNamedQuery("Employee.byName");
            namedQuery.setParameter("name", "employee-6");
            System.out.println(namedQuery.getResultList());
        }, "NAMEDNATIVEQUERY");
    }

    private static void demoCriteriaQuery() {
        runWithinTransaction((session) -> {
            Criteria criteria = session.createCriteria(Employee.class);
            criteria.add(Restrictions.eq("name", "employee-7"));
            System.out.println(criteria.list());
        }, "CRITERIAQUERY");
    }
}
