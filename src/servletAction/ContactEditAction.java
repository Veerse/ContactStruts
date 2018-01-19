package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.ContactEditValidationForm;
import domain.Contact;
import services.ContactService;


public class ContactEditAction extends Action {
	public ActionForward execute(final ActionMapping Mapping, ActionForm Form, final HttpServletRequest Request,
			final HttpServletResponse Response) {
			
		final ContactEditValidationForm lForm = (ContactEditValidationForm) Form;
		
		Contact c = new Contact(Integer.parseInt(lForm.getId()), lForm.getLastName(), lForm.getFirstName(), lForm.getEmail());
		
		System.out.println("Updating " + c.getId() + c.getEmail());
		
		ContactService c_s = new ContactService();
		
		c_s.UpdateContact(c);
				
		return Mapping.findForward("success");

	}
}
