package services;

import daos.Contact_GroupDAO;

public class Contact_GroupService {

	public void AddContact(int ref_contact, int ref_group) {
		Contact_GroupDAO cg_DAO = new Contact_GroupDAO();
		cg_DAO.AddContact(ref_contact, ref_group);
	}

	public void DeleteContact(int id) {
		Contact_GroupDAO cg_DAO = new Contact_GroupDAO();
		cg_DAO.DeleteContact(id);
	}

	public void DeleteContactFrom(int id_c, int id_g) {
		Contact_GroupDAO cg_DAO = new Contact_GroupDAO();
		cg_DAO.DeleteContactFrom(id_c, id_g);
		
	}
	
}
