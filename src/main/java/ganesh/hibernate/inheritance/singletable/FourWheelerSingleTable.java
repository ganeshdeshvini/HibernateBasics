package ganesh.hibernate.inheritance.singletable;

import javax.persistence.Entity;

@Entity
public class FourWheelerSingleTable extends VehicleSingleTable {
	private String steeringWheel;

	public FourWheelerSingleTable(String name) {
		super(name);
	}

	public FourWheelerSingleTable(String name, String steeringWheel) {
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
