package cst135n.w4.milestone4;

import java.io.Serializable;

public class BusinessContact extends BaseContact implements Serializable {
	
	private String businessHours;
	private String websiteURL;
	
	public BusinessContact(int contactId, String name, String phone, String listOfPhotos, String location,
			String businessHours, String websiteURL, Location locationClass, Photo photoClass) {
		super(contactId, name, phone, listOfPhotos, location, locationClass, photoClass);
		this.businessHours = businessHours;
		this.websiteURL = websiteURL;
	}

	@Override
	public String toString() {
		return "Business Contact " + super.toString() + ", businessHours = " + businessHours + ", websiteURL = " + websiteURL + "]";
	}

	public String getBusinessHours() {
		return businessHours;
	}

	public void setBusinessHours(String businessHours) {
		this.businessHours = businessHours;
	}

	public String getWebsiteURL() {
		return websiteURL;
	}

	public void setWebsiteURL(String websiteURL) {
		this.websiteURL = websiteURL;
	}
	
}
