package services;

import java.util.List;

import daos.Contact_GroupDAO;
import daos.GroupDAO;
import domain.Contact;
import domain.Group;

public class GroupService {

	public String CreateGroup(Group g) {
		GroupDAO g_DAO = new GroupDAO();
		g_DAO.CreateGroup(g);
		return null;
	}

	public List<Group> GetGroups() {
		GroupDAO g_DAO = new GroupDAO();
		return g_DAO.GetGroups();
	}

	public void DeleteGroup(int id) {
		GroupDAO g_DAO = new GroupDAO();
		g_DAO.DeleteGroup (id);
		
		Contact_GroupDAO c_gDAO = new Contact_GroupDAO();
		c_gDAO.DeleteGroupe(id);
	}

	public Group GetGroup(int iD_Group) {
		GroupDAO g_DAO = new GroupDAO();
		return g_DAO.GetGroup(iD_Group);
	}

	public void UpdateGroup(Group g) {
		GroupDAO g_DAO = new GroupDAO();
		g_DAO.UpdateGroup(g);
	}

	public List<Contact> getContacts(int iD_Group) {
		GroupDAO g_DAO = new GroupDAO();
		return g_DAO.getContacts(iD_Group);
	}


}
