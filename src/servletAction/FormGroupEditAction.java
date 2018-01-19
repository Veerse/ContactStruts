package servletAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.GroupEditValidationForm;
import domain.Contact;
import services.ContactService;

public class FormGroupEditAction extends Action {
	public ActionForward execute(final ActionMapping Mapping, ActionForm Form, final HttpServletRequest Request,
			final HttpServletResponse Response) {

		GroupEditValidationForm f = (GroupEditValidationForm) Form;
		
		f.setGroupID(Request.getParameter("id"));
		
		return Mapping.findForward("success");
	}
}
