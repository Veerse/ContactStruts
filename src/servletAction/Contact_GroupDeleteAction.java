package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import services.Contact_GroupService;

public class Contact_GroupDeleteAction extends Action {
	public ActionForward execute(final ActionMapping Mapping, ActionForm Form, final HttpServletRequest Request,
			final HttpServletResponse Response) {
		
		int id_c = Integer.parseInt(Request.getParameter("id_contact"));
		int id_g = Integer.parseInt(Request.getParameter("id_group"));
		
		Contact_GroupService cg_s = new Contact_GroupService();
		
		System.out.println("Deleting contact whose id is " + id_c + " from " + id_g);
		
		cg_s.DeleteContactFrom(id_c, id_g);
		
		return Mapping.findForward("success");
		
	}
}
