package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class GroupEditValidationForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	
	private String groupID;
	private String groupName; 
	
	public String getGroupID() {
		return groupID;
	}
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.groupID = null;
		this.groupName = null;
	}

	// Validation test
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (getGroupName() == null || getGroupName().length() < 1) {
			errors.add("groupName", new ActionMessage("forms.contact.firstname.required"));
		}
	
		return errors;
	}
	
}
