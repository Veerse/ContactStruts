package servletAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import domain.Contact;
import services.ContactService;

public class ContactReadAction extends Action {

	public ActionForward execute(final ActionMapping Mapping, ActionForm Form, final HttpServletRequest Request,
			final HttpServletResponse Response) {

		final ContactService c_service = new ContactService();

		List<Contact> l = c_service.GetContacts();

		Request.setAttribute("ContactList", l);
		
		return Mapping.findForward("success");

	}

}
