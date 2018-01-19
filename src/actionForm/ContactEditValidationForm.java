package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ContactEditValidationForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	
	private String id = null;
	private String firstName = null;
	private String lastName = null;
	private String email = null;

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
