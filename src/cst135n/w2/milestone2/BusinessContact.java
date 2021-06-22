package cst135n.w2.milestone2;

public class BusinessContact extends BaseContact {
	
	private String businessHours;
	private String websiteURL;
	
	public BusinessContact(int contactId, String name, String phone, String listOfPhotos, String location,
			String businessHours, String websiteURL) {
		super(contactId, name, phone, listOfPhotos, location);
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
