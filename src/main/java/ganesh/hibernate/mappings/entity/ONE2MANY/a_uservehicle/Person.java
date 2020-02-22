package ganesh.hibernate.mappings.entity.ONE2MANY.a_uservehicle;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToMany(mappedBy = "person")
//	@OneToMany
//	@JoinTable(name = "person_vehicle", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
	private List<Vehicle> vehicle = new ArrayList<>();

	public Person() {
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	public void convienceMethodToAddVehicleAndSetBidirectionalRelationship(Vehicle vehicle) {
		this.vehicle.add(vehicle);
		vehicle.setPerson(this);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

}
