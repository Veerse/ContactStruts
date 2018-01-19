package domain;

public class Address {
	
	private int AdressID;
	private String Address = null;
	private String City = null;
	private String zip = null;
	private String Country = null;

	public Address(int adressID, String address, String city, String zip, String country) {
		AdressID = adressID;
		Address = address;
		City = city;
		this.zip = zip;
		Country = country;
	}

	public Address(String address, String city, String zip, String country) {
		Address = address;
		City = city;
		this.zip = zip;
		Country = country;
	}
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
}
