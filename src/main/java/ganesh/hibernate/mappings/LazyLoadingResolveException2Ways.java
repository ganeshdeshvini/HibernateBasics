package ganesh.hibernate.mappings;

import ganesh.hibernate.mappings.entity.ONE2MANY.b_productreview.Product;
import ganesh.hibernate.mappings.entity.ONE2MANY.b_productreview.Review;
import ganesh.hibernate.util.HibernateUtil;
import org.hibernate.query.Query;

import static ganesh.hibernate.util.HibernateUtil.shutdown;

public class LazyLoadingResolveException2Ways {
//    public static void main(String[] args) {
//        fixLazyLoadExceptionUsingOption1LoadWhenInsideSession();
//        fixLazyLoadExceptionUsingOption2HQL();
////        shutdown();
//    }
//
//    private static void fixLazyLoadExceptionUsingOption2HQL() {
//        Product product = (Product) HibernateUtil.runWithinTransaction((session) -> {
//            int productId = 1;
//            String query = "select p from Product p " + " JOIN FETCH p.reviews " + " where p.id=:theProductId";
//            Query<Product> productQuery = session.createQuery(query, Product.class);
//            productQuery.setParameter("theProductId", productId);
//            Product productRetrieved = productQuery.getSingleResult();
//            System.out.println(productRetrieved.getReviews());
//
//            int reviewId = 2;
//            query = "select r from Review r " + " JOIN FETCH r.product " + " where r.id=:theReviewId";
//            Query<Review> reviewQuery = session.createQuery(query, Review.class);
//            reviewQuery.setParameter("theReviewId", reviewId);
//            Review review = reviewQuery.getSingleResult();
//            System.out.println(review.getProduct());
//            productQuery.setParameter("theProductId", productId);
//
//            return productRetrieved;
//        });
//
//        System.out.println("Closing the session");
//        System.out.println(product.getReviews());
//    }
//
//    @SuppressWarnings("unused")
//    private static void fixLazyLoadExceptionUsingOption1LoadWhenInsideSession() {
//        HibernateUtil.runWithinTransaction((session) -> {
//            Product newProduct = new Product("Product1");
//            newProduct.addReview(new Review("Comment", 1));
//            session.persist(newProduct);
//        });
//
//        Product product = (Product) HibernateUtil.runWithinTransaction((session) -> {
//            int productId = 1;
//            Product returnProduct = session.get(Product.class, productId);
//            returnProduct.getReviews();
//            return returnProduct;
//        });
//        System.out.println("Closed the session, but still able to retrieve the Reviews as this is already loaded in the memory");
//        System.out.println(product.getReviews());
//    }
}
