package ganesh.hibernate.annotations;

import ganesh.hibernate.CRUD.dao.GenericDAO;
import ganesh.hibernate.CRUD.entity.Address;
import ganesh.hibernate.CRUD.entity.User;

import java.util.Arrays;
import java.util.Date;

import static ganesh.hibernate.util.HibernateUtil.shutdown;

@SuppressWarnings("unused")
public class UserRunner {

    public static void main(String[] args) {
        UserRunner studentRunner = new UserRunner();
        GenericDAO<User> genericDAOUserDetails = new GenericDAO<User>(User.class);
//		createUserWithEmbeddedAddressExample(genericDAOUserDetails);
//		createUserWithElementCollectionExample(genericDAOUserDetails);
        createUserWithElementCollectionJoinTableExample(genericDAOUserDetails);
        shutdown();
    }

    private static void createUserWithEmbeddedAddressExample(GenericDAO<User> genericDAOUserDetails) {
        Address homeAddress = new Address("homestreet", "homecity", "homestate", "homepincode");
        Address officeAddress = new Address("street", "city", "state", "pincode");
        User user = new User("Ganesh", new Date(), "dummy description");
//		user.setHomeAddress(homeAddress);
//		user.setOfficeAddress(officeAddress);
        genericDAOUserDetails.save(user);
    }

    private static void createUserWithElementCollectionExample(GenericDAO<User> genericDAOUserDetails) {
        User user = new User("Ganesh", new Date(), "dummy description");
        user.setHobbies(Arrays.asList("Cricket", "Books"));
        genericDAOUserDetails.save(user);
    }

    private static void createUserWithElementCollectionJoinTableExample(GenericDAO<User> genericDAOUserDetails) {
        User user = new User("Ganesh", new Date(), "dummy description");
        Address officeAddress = new Address("street", "city", "state", "pincode");
        user.getUserAddresses().add(officeAddress);
        genericDAOUserDetails.save(user);
    }
}
