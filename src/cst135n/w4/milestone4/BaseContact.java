package cst135n.w4.milestone4;

import java.io.Serializable;

public class BaseContact implements Serializable {
	
	private int contactId;
	private String name;
	private String phone;
	private String listOfPhotos; 
	private String location;      
	
	private Location locationClass;
	private Photo photoClass;
	
	public BaseContact(int contactId, String name, String phone, String listOfPhotos, String location, Location locationClass, Photo photoClass) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.phone = phone;
		this.listOfPhotos = listOfPhotos;
		this.location = location;
		this.locationClass = locationClass;
		this.photoClass = photoClass;
		
	}

	@Override
	public String toString() {
		return "[contactId = " + contactId + ", name = " + name + ", phone = " + phone + ", listOfPhotos = "
				+ listOfPhotos + ", location = " + location + ", location = " + locationClass.toString() + ", photos = " + photoClass.toString() + "]";
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public Location getLocationClass() {
		return locationClass;
	}

	public void setLocationClass(Location locationClass) {
		this.locationClass = locationClass;
	}

	public Photo getPhotoClass() {
		return photoClass;
	}

	public void setPhotoClass(Photo photoClass) {
		this.photoClass = photoClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getListOfPhotos() {
		return listOfPhotos;
	}

	public void setListOfPhotos(String listOfPhotos) {
		this.listOfPhotos = listOfPhotos;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;

	}
}
