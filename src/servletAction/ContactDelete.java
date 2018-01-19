package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import services.ContactService;

public class ContactDelete extends Action{
	
	public ActionForward execute(final ActionMapping Mapping, ActionForm Form, final HttpServletRequest Request,
			final HttpServletResponse Response) {
		
		int id = Integer.parseInt(Request.getParameter("id"));
		
		ContactService c_s = new ContactService();
		System.out.println("Deleting contact whose id is " + id);
		
		c_s.deleteContact(id);
		
		return Mapping.findForward("success");
		
	}
	
}
