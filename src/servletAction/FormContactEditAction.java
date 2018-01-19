package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.ContactEditValidationForm;

public class FormContactEditAction extends Action {
	
	public ActionForward execute(final ActionMapping Mapping, ActionForm Form, final HttpServletRequest Request,
			final HttpServletResponse Response) {
		
		ContactEditValidationForm f = (ContactEditValidationForm) Form;
		
		f.setId(Request.getParameter("id"));
		
		return Mapping.findForward("success");
	}
	
}
