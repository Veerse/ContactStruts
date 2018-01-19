package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ContactCreateValidationForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	//Contact properties
	private String firstName = null;
	private String lastName = null;
	private String email = null;

	//Adress properties
	private String Address = null;
	private String City = null;
	private String zip = null;
	private String Country = null;
	
	// Getters and setters for ADDRESS
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

	// Getters and setters for CONTACT
	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setEmail(String string) {
		email = string;
	}

	public void setFirstName(String string) {
		firstName = string;
	}

	public void setLastName(String string) {
		lastName = string;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.firstName = null;
		this.lastName = null;
		this.email = null;
		this.Address = null;
	}

	// Validation test
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (getFirstName() == null || getFirstName().length() < 1) {
			errors.add("first name", new ActionMessage("forms.contact.firstname.required"));
		}
		if (getLastName() == null || getLastName().length() < 1) {
			errors.add("last name", new ActionMessage("forms.contact.lastname.required"));
		}
		if (getEmail() == null || getEmail().length() < 1) {
			errors.add("email", new ActionMessage("forms.contact.email.required"));
		}
		return errors;
	}
}
