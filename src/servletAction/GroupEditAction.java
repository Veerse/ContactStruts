package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.GroupEditValidationForm;
import domain.Group;

import services.GroupService;

public class GroupEditAction extends Action {
	public ActionForward execute(final ActionMapping Mapping, ActionForm Form, final HttpServletRequest Request,
			final HttpServletResponse Response) {
			
		final GroupEditValidationForm lForm = (GroupEditValidationForm) Form;
		
		Group g = new Group(Integer.parseInt(lForm.getGroupID()), lForm.getGroupName());
		
		System.out.println("Updating group whose id is " + g.getGroupID() + ", new name : " + g.getGroupName());
		
		GroupService g_s = new GroupService();
		
		g_s.UpdateGroup(g);
				
		return Mapping.findForward("success");

	}
}
