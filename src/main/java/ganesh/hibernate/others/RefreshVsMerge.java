package ganesh.hibernate.others;

import static ganesh.hibernate.util.HibernateUtil.runWithinTransaction;
import static ganesh.hibernate.util.HibernateUtil.shutdown;

public class RefreshVsMerge {
    public static void main(String[] args) {
        refreshExample();
//		mergeExample();
        shutdown();
    }

    private static void mergeExample() {
        EmployeeLite employeeLite = (EmployeeLite) runWithinTransaction((session) -> {
            String originalName = "Ganesh";
            EmployeeLite employeeLiteNew = new EmployeeLite(originalName);
            session.save(employeeLiteNew);
            return employeeLiteNew;
        });

        runWithinTransaction((session) -> {
            String updatedName = "Suresh";
            employeeLite.setName(updatedName);
            session.merge(employeeLite);
            employeeLite.getName().equals("Suresh");
        });
    }

    private static void refreshExample() {
        EmployeeLite employeeLite = (EmployeeLite) runWithinTransaction((session) -> {
            String originalName = "Ganesh";
            EmployeeLite employeeLiteNew = new EmployeeLite(originalName);
            session.save(employeeLiteNew);
            return employeeLiteNew;
        });
        runWithinTransaction((session) -> {
            String updatedName = "Suresh";
            employeeLite.setName(updatedName);
            session.refresh(employeeLite);
            employeeLite.getName().equals("Ganesh");
        });
    }
}
