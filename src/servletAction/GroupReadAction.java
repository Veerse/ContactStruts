package servletAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import domain.Contact;
import domain.Group;
import services.ContactService;
import services.Contact_GroupService;
import services.GroupService;

public class GroupReadAction extends Action {
	public ActionForward execute(final ActionMapping Mapping, ActionForm Form, final HttpServletRequest Request,
			final HttpServletResponse Response) {

		final GroupService g_service = new GroupService ();
		
		// see how many contacts on groups
		final Contact_GroupService cg_service = new Contact_GroupService ();
		
		// retrieve list of contacts
		final ContactService c_service = new ContactService ();
		
		
		List<Group> l = g_service.GetGroups();
		List<Contact> l_c = c_service.GetContacts();
		
		Request.setAttribute("GroupList", l);
		Request.setAttribute("ContactList", l_c);
		
		return Mapping.findForward("success");

	}
}
