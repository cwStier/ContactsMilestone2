package cst135n.w4.milestone4;

import java.io.Serializable;

public class PersonContact extends BaseContact implements Serializable {

	private String dateOfBirth;
	private String description;
	
	public PersonContact(int contactId, String name, String phone, String listOfPhotos, String location,
			String dateOfBirth, String description, Location locationClass, Photo photoClass) {
		super(contactId, name, phone, listOfPhotos, location, locationClass, photoClass);
		this.dateOfBirth = dateOfBirth;
		this.description = description;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Person Contact " + super.toString() + ", dateOfBirth = " + dateOfBirth + ", description = " + description + "]";
	}


}
