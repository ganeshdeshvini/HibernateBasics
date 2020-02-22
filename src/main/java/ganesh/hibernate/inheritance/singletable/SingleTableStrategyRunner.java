package ganesh.hibernate.inheritance.singletable;

import ganesh.hibernate.util.HibernateUtil;

import static ganesh.hibernate.util.HibernateUtil.runWithinTransaction;
import static ganesh.hibernate.util.HibernateUtil.shutdown;

public class SingleTableStrategyRunner {
    public static void main(String[] args) {
        runWithinTransaction((session) -> {
            VehicleSingleTable vehicle = new VehicleSingleTable("Vehicle");
            TwoWheelerSingleTable bike = new TwoWheelerSingleTable("Bike", "2");
            FourWheelerSingleTable car = new FourWheelerSingleTable("Car", "4");

            session.save(vehicle);
            session.save(bike);
            session.save(car);
        });
        shutdown();
    }
}
