package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import services.GroupService;

public class GroupDeleteAction extends Action {

	public ActionForward execute(final ActionMapping Mapping, ActionForm Form, final HttpServletRequest Request,
			final HttpServletResponse Response) {
		
		int id = Integer.parseInt(Request.getParameter("id"));
		
		GroupService g_s = new GroupService();
		System.out.println("Deleting group whose id is " + id);
		
		g_s.DeleteGroup(id);
		
		return Mapping.findForward("success");
		
	}
	
}
