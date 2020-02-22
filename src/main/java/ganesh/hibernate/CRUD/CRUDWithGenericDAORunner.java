package ganesh.hibernate.CRUD;

import ganesh.hibernate.CRUD.dao.GenericDAO;
import ganesh.hibernate.CRUD.entity.Student;
import ganesh.hibernate.util.HibernateUtil;

import java.util.List;

import static ganesh.hibernate.util.HibernateUtil.runWithinTransaction;
import static ganesh.hibernate.util.HibernateUtil.shutdown;

@SuppressWarnings("unused")
public class CRUDWithGenericDAORunner {

    public static void main(String[] args) {
        CRUDWithGenericDAORunner studentRunner = new CRUDWithGenericDAORunner();
        GenericDAO<Student> genericDAOStudent = new GenericDAO<Student>(Student.class);

        studentRunner.createStudent(genericDAOStudent);
		studentRunner.retrieveStudent(genericDAOStudent);
		studentRunner.findAllStudents(genericDAOStudent);
		String query = "from Student where firstName LIKE '%Ganesh%'";
		studentRunner.findAllStudents(genericDAOStudent, query);
        studentRunner.updateSingle();
		studentRunner.updateAllStudent(genericDAOStudent);
		studentRunner.deleteSingle(genericDAOStudent);
		studentRunner.deleteMultiple(genericDAOStudent);
        shutdown();
    }

    // C
    private void createStudent(GenericDAO<Student> genericDAOStudent) {
        Student studentToBeSaved = new Student("Radhika", "Deshvini", "d@d.com");
        genericDAOStudent.save(studentToBeSaved);
    }

    // R
    private Student retrieveStudent(GenericDAO<Student> genericDAOStudent) {
        return genericDAOStudent.findOne(1);
    }

    private List<Student> findAllStudents(GenericDAO<Student> genericDAOStudent) {
        List<Student> students = genericDAOStudent.findAll();
        display(students);
        return students;
    }

    private List<Student> findAllStudents(GenericDAO<Student> genericDAOStudent, String query) {
        List<Student> students = genericDAOStudent.findAll(query);
        display(students);
        return students;
    }

    private void display(List<Student> students) {
        students.forEach(System.out::println);
    }

    // U
    private void updateSingle() {
        int studentId = 2;
        runWithinTransaction((session) -> {
            Student student = session.get(Student.class, studentId);
            student.setEmail(student.getEmail() + " - Updated");
        });
    }

    private void updateAllStudent(GenericDAO<Student> genericDAOStudent) {
        String query = "update Student set email='demo@demo.com'";
        genericDAOStudent.update(query);
    }

    // D
    private void deleteSingle(GenericDAO<Student> genericDAOStudent) {
        int studentId = 2;
        Student student = genericDAOStudent.findOne(studentId);
        genericDAOStudent.delete(student);
    }

    private void deleteMultiple(GenericDAO<Student> genericDAOStudent) {
        int studentId = 3;
        String query = "delete from Student where id= " + studentId;
        genericDAOStudent.update(query);
    }
}
