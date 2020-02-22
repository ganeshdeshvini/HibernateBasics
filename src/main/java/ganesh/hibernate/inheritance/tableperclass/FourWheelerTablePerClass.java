package ganesh.hibernate.inheritance.tableperclass;

import javax.persistence.Entity;

@Entity
public class FourWheelerTablePerClass extends VehicleTablePerClass {
	private String steeringWheel;

	public FourWheelerTablePerClass(String name) {
		super(name);
	}

	public FourWheelerTablePerClass(String name, String steeringWheel) {
		this(name);
		this.steeringWheel = steeringWheel;
	}

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

}
