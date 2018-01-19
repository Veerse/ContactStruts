package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class GroupCreateValidationForm extends ActionForm{

	private static final long serialVersionUID = 1L;
	
	private int groupID;
	private String groupName;

	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.groupName = null;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (getGroupName() == null || getGroupName().length() < 1) {
			errors.add("groupName", new ActionMessage("nom du groupe requis"));
		}
		return errors;
	}
	
}
