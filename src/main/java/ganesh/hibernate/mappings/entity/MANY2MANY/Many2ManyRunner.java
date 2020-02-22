package ganesh.hibernate.mappings.entity.MANY2MANY;

import org.hibernate.Session;

import java.util.function.Consumer;

import static ganesh.hibernate.util.HibernateUtil.runWithinTransaction;
import static ganesh.hibernate.util.HibernateUtil.shutdown;

public class Many2ManyRunner {
    public static void main(String[] args) {
        runWithinTransaction(createTeacherStudent());
        runWithinTransaction(removeStudent());
        shutdown();
    }

    private static Consumer<Session> createTeacherStudent() {
        return (session) -> {
            Subject java = new Subject("JAVA");
            Subject sql = new Subject("SQL");

            Teacher ganesh = new Teacher("Ganesh");
            Teacher radhika = new Teacher("Radhika");

            ganesh.addSubjectConveienceMethod(java);
            ganesh.addSubjectConveienceMethod(sql);
            radhika.addSubjectConveienceMethod(sql);

            session.save(java);
            session.save(sql);
            session.save(ganesh);
            session.save(radhika);
        };
    }

    private static Consumer<Session> removeStudent() {
        return (session) -> {
            Subject java = new Subject("JAVA");
            Teacher teacher = session.get(Teacher.class, 1);
            teacher.removeSubjectConveienceMethod(java);
        };
    }
}
