package ganesh.hibernate.cascade;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserOneToMany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToMany(cascade = CascadeType.PERSIST)
	private Set<VehicleManyToOne> vehicleManyToOneCollection = new HashSet<>();

	public UserOneToMany() {
	}

	public UserOneToMany(String name) {
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

	public Set<VehicleManyToOne> getVehicleManyToOneCollection() {
		return vehicleManyToOneCollection;
	}

	public void setVehicleManyToOneCollection(Set<VehicleManyToOne> vehicleManyToOneCollection) {
		this.vehicleManyToOneCollection = vehicleManyToOneCollection;
	}

	@Override
	public String toString() {
		return "OneToManyEntity [id=" + id + ", name=" + name + "]";
	}
}
