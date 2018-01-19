package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.Contact_GroupCreateValidationForm;
import services.Contact_GroupService;

public class Contact_GroupCreateAction extends Action {
	
	public ActionForward execute(final ActionMapping Mapping, ActionForm Form, final HttpServletRequest Request,
			final HttpServletResponse Response) {

		final Contact_GroupCreateValidationForm lForm = (Contact_GroupCreateValidationForm) Form;
		
		System.out.println("Adding id " + lForm.getRef_contact() + " to " + lForm.getRef_group());
		
		Contact_GroupService cg_service = new Contact_GroupService();
		
		cg_service.AddContact(lForm.getRef_contact(), lForm.getRef_group());
		
		return Mapping.findForward("success");

	}
	
}
