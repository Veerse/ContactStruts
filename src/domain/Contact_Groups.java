package domain;

public class Contact_Groups {
	
	private int ref_contact;
	private int ref_group;
	
	public Contact_Groups(){
	}
	
	public Contact_Groups(int ref_c, int ref_g){
		ref_contact = ref_c;
		ref_group = ref_g;
	}
	
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
