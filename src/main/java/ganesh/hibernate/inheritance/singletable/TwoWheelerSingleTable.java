package ganesh.hibernate.inheritance.singletable;

import javax.persistence.Entity;

@Entity
public class TwoWheelerSingleTable extends VehicleSingleTable {
	private String steeringHandle;

	public TwoWheelerSingleTable(String name) {
		super(name);
	}

	public TwoWheelerSingleTable(String name, String steeringHandle) {
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
