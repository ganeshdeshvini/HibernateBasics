package ganesh.hibernate.CRUD;

import ganesh.hibernate.CRUD.entity.User;

import java.util.ArrayList;
import java.util.List;

import static ganesh.hibernate.util.HibernateUtil.*;

public class CRUDRunner {
    static List<Long> generatedIds = new ArrayList<>();

    public static void main(String[] args) {
        createUser();
        readUser();
//        updateUser();
//        deleteUser();
        shutdown();
    }

    private static void createUser() {
        runWithinTransaction((session) -> {
            generatedIds.add((Long) session.save(new User("Ganesh")));
            generatedIds.add((Long) session.save(new User("Radhika")));
            generatedIds.add((Long) session.save(new User("Laxmi")));
        }, "CREATE");
    }

    private static void readUser() {
        runWithoutTransaction((session) -> {
            User user = session.get(User.class, generatedIds.get(0));
            System.out.println(user);
        }, "READ");
    }

    private static void updateUser() {
        runWithinTransaction((session) -> {
            User user = session.get(User.class, generatedIds.get(1));
            user.setDescription("updated description");
            System.out.println(user);
        }, "UPDATE");
    }

    private static void deleteUser() {
        runWithinTransaction((session) -> {
            User user = session.get(User.class, generatedIds.get(2));
            session.delete(user);
        }, "DELETE");
    }
}
