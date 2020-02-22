package ganesh.hibernate.CRUD.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table
@DynamicUpdate
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;

	// this field will not be mapped to any column in the database as this is
	// Transient
	private transient String fieldWhichWillNotBeMappedToDatabaseTable;

	@Temporal(TemporalType.DATE)
	private Date joinedDate;

	@Lob
	private String description;

//	private Address officeAddress;
//
//	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "home_street")),
//			@AttributeOverride(name = "city", column = @Column(name = "home_city")),
//			@AttributeOverride(name = "state", column = @Column(name = "home_state")),
//			@AttributeOverride(name = "pincode", column = @Column(name = "home_pincode")) })
//	private Address homeAddress;

	@ElementCollection
	private List<String> hobbies;

	@ElementCollection
	@JoinTable(name = "user_address", joinColumns = @JoinColumn(name = "user_id"))
	private List<Address> userAddresses;

	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public User(String name, Date joinedDate, String description) {
		this.name = name;
		this.joinedDate = joinedDate;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFieldWhichWillNotBeMappedToDatabaseTable() {
		return fieldWhichWillNotBeMappedToDatabaseTable;
	}

	public void setFieldWhichWillNotBeMappedToDatabaseTable(String fieldWhichWillNotBeMappedToDatabaseTable) {
		this.fieldWhichWillNotBeMappedToDatabaseTable = fieldWhichWillNotBeMappedToDatabaseTable;
	}

//	public Address getHomeAddress() {
//		return homeAddress;
//	}
//
//	public void setHomeAddress(Address homeAddress) {
//		this.homeAddress = homeAddress;
//	}
//
//	public Address getOfficeAddress() {
//		return officeAddress;
//	}
//
//	public void setOfficeAddress(Address officeAddress) {
//		this.officeAddress = officeAddress;
//	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public List<Address> getUserAddresses() {
		return userAddresses == null ? new ArrayList<>() : userAddresses;
	}

	public void setUserAddresses(List<Address> userAddresses) {
		this.userAddresses = userAddresses;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
