package ganesh.hibernate.inheritance.tableperclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.JOINED)
public class VehicleTablePerClass {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;

	public VehicleTablePerClass() {
	}

	public VehicleTablePerClass(String name) {
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

	@Override
	public String toString() {
		return "VehicleTablePerClassStrategy [id=" + id + ", name=" + name + "]";
	}
}
