package ganesh.hibernate.mappings;

import ganesh.hibernate.mappings.entity.ONE2MANY.c_coursereview.Course;
import ganesh.hibernate.mappings.entity.ONE2MANY.c_coursereview.CourseReview;

import static ganesh.hibernate.util.HibernateUtil.runWithinTransaction;

public class One2ManyUniDirectionalRunner {
//    public static void main(String[] args) {
//        deleteCourseWhichWillAutomaticallyDeleteReviewsDueToCascadeTypeALL();
//    }
//
//    private static void createCourse() {
//        runWithinTransaction((session) -> {
//            Course course = new Course("Hibernate");
//            course.addCourseReview(new CourseReview("Good"));
//            course.addCourseReview(new CourseReview("Best"));
//        });
//    }
//
//    private static void deleteCourseWhichWillAutomaticallyDeleteReviewsDueToCascadeTypeALL() {
//        runWithinTransaction((session) -> {
//            int courseId = 4;
//            Course course = session.get(Course.class, courseId);
//            session.delete(course);
//        });
//    }
}
