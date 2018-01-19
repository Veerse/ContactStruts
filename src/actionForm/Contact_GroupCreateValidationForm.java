package actionForm;

import org.apache.struts.action.ActionForm;

public class Contact_GroupCreateValidationForm extends ActionForm{

	private static final long serialVersionUID = 1L;
	
	private int ref_contact;
	private int ref_group;
	
	public int getRef_contact() {
		return ref_contact;
	}

	public void setRef_contact(int ref_contact) {
		this.ref_contact = ref_contact;
	}

	public int getRef_group() {
		return ref_group;
	}

	public void setRef_group(int ref_group) {
		this.ref_group = ref_group;
	}
}
