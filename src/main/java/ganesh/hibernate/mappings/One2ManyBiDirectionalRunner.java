package ganesh.hibernate.mappings;

import ganesh.hibernate.CRUD.dao.GenericDAO;
import ganesh.hibernate.mappings.entity.ONE2MANY.b_productreview.Product;
import ganesh.hibernate.mappings.entity.ONE2MANY.b_productreview.Review;

import java.util.List;

import static ganesh.hibernate.util.HibernateUtil.runWithinTransaction;
import static ganesh.hibernate.util.HibernateUtil.shutdown;

public class One2ManyBiDirectionalRunner {
//    public static void main(String[] args) {
//		createProduct();
//		createReview();
//		getProductWithReviews();
//        GenericDAO<Review> genericDAOReview = new GenericDAO<Review>(Review.class);
//        deleteReview(genericDAOReview);
//        shutdown();
//    }
//
//    private static void createProduct() {
//        runWithinTransaction((session) -> {
//            Product product = new Product("Netgear Router N201");
//            session.save(product);
//        });
//    }
//
//    private static void createReview() {
//        runWithinTransaction((session) -> {
//            int productId = 1;
//            Product product = session.get(Product.class, productId);
//            Review review = new Review("Some comment 1", 1);
//            product.addReview(review);
//            session.save(review);
//        });
//    }
//
//    private static void getProductWithReviews() {
//        runWithinTransaction((session) -> {
//            Product product = session.get(Product.class, 1);
//            List<Review> reviews = product.getReviews();
//            reviews.forEach(System.out::println);
//        });
//    }
//
//    private static void deleteReview(GenericDAO<Review> genericDAOReview) {
//        int courseId = 1;
//        Review review = genericDAOReview.findOne(courseId);
//        genericDAOReview.delete(review);
//        Review review2 = genericDAOReview.findOne(1);
//        System.out.println(review2 == null ? "null" : review2);
//    }

}
