package ganesh.hibernate.util;

import ganesh.hibernate.CRUD.entity.Student;
import ganesh.hibernate.CRUD.entity.User;
import ganesh.hibernate.cascade.UserOneToMany;
import ganesh.hibernate.cascade.VehicleManyToOne;
import ganesh.hibernate.hql.Employee;
import ganesh.hibernate.inheritance.singletable.FourWheelerSingleTable;
import ganesh.hibernate.inheritance.singletable.TwoWheelerSingleTable;
import ganesh.hibernate.inheritance.singletable.VehicleSingleTable;
import ganesh.hibernate.inheritance.tableperclass.FourWheelerTablePerClass;
import ganesh.hibernate.inheritance.tableperclass.TwoWheelerTablePerClass;
import ganesh.hibernate.inheritance.tableperclass.VehicleTablePerClass;
import ganesh.hibernate.mappings.entity.MANY2MANY.Subject;
import ganesh.hibernate.mappings.entity.MANY2MANY.Teacher;
import ganesh.hibernate.mappings.entity.ONE2MANY.a_uservehicle.Person;
import ganesh.hibernate.mappings.entity.ONE2MANY.a_uservehicle.Vehicle;
import ganesh.hibernate.mappings.entity.ONE2MANY.b_productreview.Product;
import ganesh.hibernate.mappings.entity.ONE2MANY.b_productreview.Review;
import ganesh.hibernate.mappings.entity.ONE2MANY.c_coursereview.Course;
import ganesh.hibernate.mappings.entity.ONE2MANY.c_coursereview.CourseReview;
import ganesh.hibernate.mappings.entity.ONE2ONE.Instructor;
import ganesh.hibernate.mappings.entity.ONE2ONE.InstructorDetail;
import ganesh.hibernate.optimisticlocking.BankAccount;
import ganesh.hibernate.others.EmployeeLite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.function.Consumer;
import java.util.function.Function;

public class HibernateUtil {
    //@formatter:off
    public static SessionFactory sessionFactory = buildSessionFactory();


    private HibernateUtil() {
    }

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure()
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Instructor.class)
                    .addAnnotatedClass(InstructorDetail.class)
                    .addAnnotatedClass(Product.class)
                    .addAnnotatedClass(Review.class)
                    .addAnnotatedClass(CourseReview.class)
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Person.class)
                    .addAnnotatedClass(Vehicle.class)
                    .addAnnotatedClass(Teacher.class)
                    .addAnnotatedClass(Subject.class)
                    .addAnnotatedClass(UserOneToMany.class)
                    .addAnnotatedClass(VehicleManyToOne.class)
                    .addAnnotatedClass(VehicleSingleTable.class)
                    .addAnnotatedClass(TwoWheelerSingleTable.class)
                    .addAnnotatedClass(FourWheelerSingleTable.class)
                    .addAnnotatedClass(VehicleTablePerClass.class)
                    .addAnnotatedClass(TwoWheelerTablePerClass.class)
                    .addAnnotatedClass(FourWheelerTablePerClass.class)
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(EmployeeLite.class)
                    .addAnnotatedClass(BankAccount.class)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();

            //uncomment below for reading it from properties file
            // Create the SessionFactory from hibernate.cfg.xml
//            return new AnnotationConfiguration().configure(
//                    new File("hibernate.cgf.xml")).buildSessionFactory();
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }

    }

//	@formatter:on

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        sessionFactory.close();
    }

    public static Object runWithinTransaction(Function<Session, Object> callback, String message) {
        Session session = getSession();
        session.beginTransaction();
        //
        System.out.println("--------" + message + "----------------------");
        Object object = callback.apply(session);
        //
        session.getTransaction().commit();
        session.close();
        return object;
    }

    public static Object runWithinTransaction(Function<Session, Object> callback) {
        return runWithinTransaction(callback, "START");
    }

    public static void runWithinTransaction(Consumer<Session> callback) {
        runWithinTransaction(callback, "START");
    }

    public static void runWithinTransaction(Consumer<Session> callback, String message) {
        Session session = getSession();
        session.beginTransaction();
        //
        System.out.println("--------" + message + "----------------------");
        callback.accept(session);
        //
        session.getTransaction().commit();
        session.close();
    }

    public static Object runWithoutTransaction(Function<Session, Object> callback, String message) {
        Session session = getSession();
        System.out.println("--------" + message + "----------------------");
        Object object = callback.apply(session);
        session.close();
        return object;
    }

    public static Object runWithoutTransaction(Function<Session, Object> callback) {
        return runWithoutTransaction(callback, "START");
    }

    public static void runWithoutTransaction(Consumer<Session> callback, String message) {
        Session session = getSession();
        System.out.println("--------" + message + "----------------------");
        callback.accept(session);
        session.close();
    }

    public static void runWithoutTransaction(Consumer<Session> callback) {
        runWithoutTransaction(callback, "START");
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }
}
