package cst135n.w4.milestone4;

import java.io.Serializable;

public class Location implements Serializable {
	
	private int locationId;
	private int streetNumber;
	private String streetName;
	private String city;
	private String state;
	
	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", streetNumber=" + streetNumber + ", streetName=" + streetName
				+ ", city=" + city + ", state=" + state + "]";
	}

	public Location(int locationId, int streetNumber, String streetName, String city, String state) {
		
		super();
		this.locationId = locationId;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
	}
	
	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public int getStreetNumber() {
		return streetNumber;
	}
	
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
}
