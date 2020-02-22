package ganesh.hibernate.cascade;

import static ganesh.hibernate.util.HibernateUtil.runWithinTransaction;
import static ganesh.hibernate.util.HibernateUtil.shutdown;

public class PersistExample {
    public static void main(String[] args) {
        runWithinTransaction((session) -> {
            UserOneToMany user = new UserOneToMany("User1");
            VehicleManyToOne vehicle1 = new VehicleManyToOne("Vehicle1");
            VehicleManyToOne vehicle2 = new VehicleManyToOne("Vehicle2");
            user.getVehicleManyToOneCollection().add(vehicle1);
            user.getVehicleManyToOneCollection().add(vehicle2);
            session.persist(user);
        });
        shutdown();
    }

}
