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

public class ContactAbout extends Action {
	
	public ActionForward execute(final ActionMapping Mapping, ActionForm Form, final HttpServletRequest Request,
			final HttpServletResponse Response) {
		
		int ID_Contact = Integer.parseInt(Request.getParameter("id"));

		ContactService c_s = new ContactService();
		Contact c = c_s.getContact (ID_Contact);
		List<Group> l = c_s.getGroups(ID_Contact);
		
		Request.setAttribute("contact", c);
		Request.setAttribute("GroupList", l);
		
		return Mapping.findForward("success");
		
	}
	
}
