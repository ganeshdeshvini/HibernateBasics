package ganesh.hibernate.mappings;

import ganesh.hibernate.CRUD.entity.Student;
import ganesh.hibernate.mappings.entity.ONE2MANY.c_coursereview.Course;

import static ganesh.hibernate.util.HibernateUtil.runWithinTransaction;
import static ganesh.hibernate.util.HibernateUtil.shutdown;

public class Many2ManyRunner {
    public static void main(String[] args) {
		createCourseWithStudents();
		getStudentsForCourse();
		deleteCourseWithoutDeletingStudents();
        deleteStudentWithoutDeletingCourse();
        shutdown();
    }

    private static void getStudentsForCourse() {
        runWithinTransaction((session) -> {
            int courseId = 7;
            Course course = session.get(Course.class, courseId);
            System.out.println(course);
            System.out.println(course.getStudents());
        });
        System.out.println("Done!!!");
    }

    private static void createCourseWithStudents() {
        runWithinTransaction((session) -> {
            Course course = new Course("Spring + Hibernate");
            session.save(course);
            System.out.println("Course saved: " + course);
            Student student = new Student("Student - 1", "Deshvini", "demo@demo.com");
            Student student2 = new Student("Student - 2", "Deshvini2", "demo2@demo.com");

            course.addStudent(student);
            course.addStudent(student2);

            session.save(student);
            session.save(student2);
        });
        System.out.println("Done!!!");
    }

    private static void deleteCourseWithoutDeletingStudents() {
        runWithinTransaction((session) -> {
            int courseId = 8;
            Course course = session.get(Course.class, courseId);
            session.delete(course);
            System.out.println("Course deleted: ");
        });
        System.out.println("Done!!!");
    }

    private static void deleteStudentWithoutDeletingCourse() {
        runWithinTransaction((session) -> {
            int studentId = 14;
            Student student = session.get(Student.class, studentId);
            session.delete(student);
            System.out.println("Student deleted: ");
        });
        System.out.println("Done!!!");
    }
}
