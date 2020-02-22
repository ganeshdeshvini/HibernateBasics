package ganesh.hibernate.inheritance.tableperclass;

import static ganesh.hibernate.util.HibernateUtil.runWithinTransaction;
import static ganesh.hibernate.util.HibernateUtil.shutdown;

public class TablePerClassStrategyRunner {
    public static void main(String[] args) {
        runWithinTransaction((session) -> {
            VehicleTablePerClass vehicle = new VehicleTablePerClass("Vehicle");
            TwoWheelerTablePerClass bike = new TwoWheelerTablePerClass("Bike", "2");
            FourWheelerTablePerClass car = new FourWheelerTablePerClass("Car", "4");

            session.save(vehicle);
            session.save(bike);
            session.save(car);
        });
        shutdown();
    }
}
