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
import services.GroupService;

public class GroupAboutAction extends Action{
	public ActionForward execute(final ActionMapping Mapping, ActionForm Form, final HttpServletRequest Request,
			final HttpServletResponse Response) {
		
		int ID_Group = Integer.parseInt(Request.getParameter("id"));

		GroupService g_s = new GroupService();
		
		Group g = g_s.GetGroup (ID_Group);
		List<Contact> l = g_s.getContacts(ID_Group);
		
		System.out.println("returning group " + g.getGroupName());
		
		Request.setAttribute("group", g);
		Request.setAttribute("ContactList", l);
		
		return Mapping.findForward("success");
		
	}
}
