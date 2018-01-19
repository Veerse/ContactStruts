package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.GroupCreateValidationForm;
import domain.Group;
import services.GroupService;


public class GroupCreateAction extends Action {

	public ActionForward execute(final ActionMapping Mapping, ActionForm Form, final HttpServletRequest Request, final HttpServletResponse Response) {
		
		// Call the validation form
		final GroupCreateValidationForm f = (GroupCreateValidationForm)Form;
		
		// Retrieve group infos and create the bean
		final String GroupName = f.getGroupName();
		Group g = new Group(GroupName);
		
		// Add the group
		final GroupService g_service = new GroupService();
		String err = g_service.CreateGroup (g);

		f.reset(Mapping, Request);
		
		// Check for errors
		if(err == null) return Mapping.findForward("success");
		else return Mapping.findForward("error");
		
	}
}
