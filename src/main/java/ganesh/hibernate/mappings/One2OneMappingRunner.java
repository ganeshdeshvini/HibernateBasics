package ganesh.hibernate.mappings;

import ganesh.hibernate.CRUD.dao.GenericDAO;
import ganesh.hibernate.mappings.entity.ONE2ONE.Instructor;
import ganesh.hibernate.mappings.entity.ONE2ONE.InstructorDetail;

import static ganesh.hibernate.util.HibernateUtil.shutdown;

public class One2OneMappingRunner {
//    public static void main(String[] args) {
//        GenericDAO<Instructor> genericDAOInstructor = new GenericDAO<Instructor>(Instructor.class);
//        GenericDAO<InstructorDetail> genericDAOInstructorDetail = new GenericDAO<InstructorDetail>(InstructorDetail.class);
//        create(genericDAOInstructor);
//        delete(genericDAOInstructor);
//        bidirectionalFetchInstructorFromInstructorDetail(genericDAOInstructorDetail);
//        bidirectionalDeleteInstructorFromInstructorDetail(genericDAOInstructorDetail);
//        deleteOnlyInstructorDetail(genericDAOInstructorDetail);
//        shutdown();
//    }
//
//    private static void create(GenericDAO<Instructor> genericDAO) {
//        Instructor instructor = new Instructor("Ganesh", "Deshvini", "demO@demo.com");
//        InstructorDetail instructorDetail = new InstructorDetail("http://fake.youtube.com", "Cricket");
//        instructor.setInstructorDetail(instructorDetail);
//        genericDAO.save(instructor);
//    }
//
//    private static void delete(GenericDAO<Instructor> genericDAO) {
//        int instructorId = 4;
//        Instructor instructor = genericDAO.findOne(instructorId);
//        if (instructor != null) {
//            System.out.println("Found Instructor, now deleteing...");
//            genericDAO.delete(instructor);
//        }
//    }
//
//    private static void bidirectionalFetchInstructorFromInstructorDetail(GenericDAO<InstructorDetail> genericDAO) {
//        int instructorDetailId = 5;
//        InstructorDetail instructorDetail = genericDAO.findOne(instructorDetailId);
//        if (instructorDetail != null) {
//            System.out.println("Found InstructorDetail now finding Instructor...");
//            Instructor instructor = instructorDetail.getInstructor();
//            System.out.println(instructor);
//        } else {
//            System.out.println("Unable to find InstructorDetail");
//        }
//    }
//
//    private static void bidirectionalDeleteInstructorFromInstructorDetail(GenericDAO<InstructorDetail> genericDAO) {
//        int instructorDetailId = 5;
//        InstructorDetail instructorDetail = genericDAO.findOne(instructorDetailId);
//        if (instructorDetail != null) {
//            System.out.println("Found InstructorDetail now deleting Instructor with InstructorDetail...");
//            genericDAO.delete(instructorDetail);
//        } else {
//            System.out.println("Unable to find InstructorDetail");
//        }
//    }
//
//    private static void deleteOnlyInstructorDetail(GenericDAO<InstructorDetail> genericDAO) {
//        int instructorDetailId = 6;
//        InstructorDetail instructorDetail = genericDAO.findOne(instructorDetailId);
//        if (instructorDetail != null) {
//            System.out.println("Found InstructorDetail now deleting only InstructorDetail, so Instructor will remain as it is...");
//            instructorDetail.getInstructor().setInstructorDetail(null);
//            genericDAO.delete(instructorDetail);
//        } else {
//            System.out.println("Unable to find InstructorDetail");
//        }
//    }
}
