package services;

import java.util.List;

import daos.ContactDAO;
import domain.Contact;
import domain.Group;

public class ContactService {
	
	public String CreateContact (Contact c){
		ContactDAO DAO = new ContactDAO ();
		return DAO.CreateContact(c);
	}
	
	public List<Contact> GetContacts (){
		ContactDAO DAO = new ContactDAO ();
		return DAO.GetContacts();
	}

	public Contact getContact(int iD_Contact) {
		ContactDAO DAO = new ContactDAO ();
		return DAO.GetContact(iD_Contact);
	}

	public void deleteContact(int id) {
		ContactDAO DAO = new ContactDAO ();
		DAO.deleteContact(id);
		
		Contact_GroupService c_gService = new Contact_GroupService();
		c_gService.DeleteContact(id);
		
	}

	public void UpdateContact(Contact c) {
		ContactDAO DAO = new ContactDAO ();
		DAO.UpdateContact (c);
	}

	public List<Group> getGroups(int iD_Contact) {
		ContactDAO DAO = new ContactDAO ();
		return DAO.getGroups(iD_Contact);
	}
	
}