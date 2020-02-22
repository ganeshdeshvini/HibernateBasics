package ganesh.hibernate.mappings.entity.ONE2MANY.a_uservehicle;

import static ganesh.hibernate.util.HibernateUtil.runWithinTransaction;
import static ganesh.hibernate.util.HibernateUtil.shutdown;

public class One2ManyRunner {
    public static void main(String[] args) {
        Vehicle omni = new Vehicle("Omni");
        Vehicle nano = new Vehicle("Nano");
        Person person = new Person("Ganesh");
        person.convienceMethodToAddVehicleAndSetBidirectionalRelationship(omni);
        person.convienceMethodToAddVehicleAndSetBidirectionalRelationship(nano);

        runWithinTransaction((session) -> {
            session.save(person);
            session.save(omni);
            session.save(nano);
        });

        runWithinTransaction((session) -> {
            Vehicle vehicle = session.get(Vehicle.class, 1);
            System.out.println(vehicle.getPerson());
        });
        shutdown();
    }
}
