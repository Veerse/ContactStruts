package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;
import actionForm.ContactCreateValidationForm;
import domain.Contact;
import services.ContactService;

public class ContactCreateAction extends Action {

	public ActionForward execute(final ActionMapping Mapping, ActionForm Form, final HttpServletRequest Request,
			final HttpServletResponse Response) {

		// Call the validation form
		final ContactCreateValidationForm lForm = (ContactCreateValidationForm) Form;

		// Retrieve contact infos and create the bean
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String email = lForm.getEmail();
		Contact c = new Contact(firstName, lastName, email);
		
		final String address = lForm.getAddress();
		final String city = lForm.getCity();
		final String zip = lForm.getZip();
		final String country = lForm.getCountry();

		// Add the contact
		final ContactService c_service = new ContactService();
		String err = c_service.CreateContact(c);

		lForm.reset(Mapping, Request);

		// Check for errors
		if (err == null)
			return Mapping.findForward("success");
		else
			return Mapping.findForward("error");

	}
}
