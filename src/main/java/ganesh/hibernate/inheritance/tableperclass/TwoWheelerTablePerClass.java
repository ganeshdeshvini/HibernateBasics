package ganesh.hibernate.inheritance.tableperclass;

import javax.persistence.Entity;

@Entity
public class TwoWheelerTablePerClass extends VehicleTablePerClass {
	private String steeringHandle;

	public TwoWheelerTablePerClass(String name) {
		super(name);
	}

	public TwoWheelerTablePerClass(String name, String steeringHandle) {
		this(name);
		this.steeringHandle = steeringHandle;
	}

	public String getSteeringWheel() {
		return steeringHandle;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringHandle = steeringWheel;
	}
}
