package cst135n.w2.milestone2;


public class BaseContact {
	
	private int contactId;
	private String name;
	private String phone;
	private String listOfPhotos;
	private String location;
	
	public BaseContact(int contactId, String name, String phone, String listOfPhotos, String location) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.phone = phone;
		this.listOfPhotos = listOfPhotos;
		this.location = location;
	}

	@Override
	public String toString() {
		return "[contactId = " + contactId + ", name = " + name + ", phone = " + phone + ", listOfPhotos = "
				+ listOfPhotos + ", location = " + location + "]";
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
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
