package daos;

import domain.Contact;
import domain.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

import java.sql.*;

import javax.sql.DataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class ContactDAO {
	
	private String driver = "com.mysql.jdbc.Driver"; 
	private String url = "jdbc:mysql://localhost/jee";
	private String uid = "root";
	private String passwd = "root";
	private Connection cx;
	private PreparedStatement stmt;

	public String CreateContact(Contact contact) {

		// Driver initialisation
		try {Class.forName(driver);
		}catch (ClassNotFoundException e1) {e1.printStackTrace();}
		
		// Request
		try {
			cx = DriverManager.getConnection(url, uid, passwd);
			stmt = cx.prepareStatement("INSERT INTO contact (FIRSTNAME, LASTNAME, EMAIL) VALUES (?, ?, ?)");
			System.out.println("Adding " + contact.getFirstName() + " to the database");
			stmt.setObject (1, contact.getFirstName());
			stmt.setObject (2, contact.getLastName());
			stmt.setObject (3, contact.getEmail());

			stmt.executeUpdate();
			
			return null;
		}
		catch (SQLException e){throw new RuntimeException(e);
		}finally{
			try{
				if (stmt != null) stmt.close();
				if (cx != null) cx.close();
			}catch (Exception e){throw new RuntimeException(e);}
		}
	}
	


	public List<Contact> GetContacts(){
		
		// Driver initialisation
		try {Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e1) {e1.printStackTrace();}

		List<Contact> ContactList = new ArrayList<Contact>();
		
		try{
			cx = DriverManager.getConnection(url , uid, passwd);
			stmt = cx.prepareStatement("SELECT * FROM contact");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("ID_CONTACT");
				String nom = rs.getString("FIRSTNAME");
				String prenom = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				
				ContactList.add(new Contact(id, nom, prenom, email));
			}
		}catch(Exception e){throw new RuntimeException(e);
		}finally{}
		
		System.out.println("Returning contacts");
		
		return ContactList;
	}


	public Contact GetContact(int iD_Contact) {
		// Driver initialisation
		try {Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e1) {e1.printStackTrace();}

		Contact c = new Contact();
		
		try{
			cx = DriverManager.getConnection(url , uid, passwd);
			stmt = cx.prepareStatement("SELECT * FROM contact WHERE ID_CONTACT = " + iD_Contact);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				c.setId(rs.getInt("ID_CONTACT"));
				c.setFirstName(rs.getString("FIRSTNAME"));
				c.setLastName(rs.getString("LASTNAME"));
				c.setEmail(rs.getString("EMAIL"));
			}
		}catch(Exception e){throw new RuntimeException(e);
		}finally{}
		
		System.out.println("Returning contact whose id is " + iD_Contact);
		
		return c;
	}



	public void deleteContact(int iD_Contact) {
		
		try {Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e1) {e1.printStackTrace();}
		
		// Request
		try {
			cx = DriverManager.getConnection(url, uid, passwd);
			stmt = cx.prepareStatement("DELETE FROM contact WHERE ID_Contact = ?");
			stmt.setObject (1, iD_Contact);
			stmt.executeUpdate();
		}
		catch (SQLException e){throw new RuntimeException(e);
		}finally{
			try{
				if (stmt != null) stmt.close();
				if (cx != null) cx.close();
			}catch (Exception e){throw new RuntimeException(e);}
		}
	}



	public void UpdateContact(Contact c) {
		try {Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e1) {e1.printStackTrace();}
		
		// Request
		try {
			cx = DriverManager.getConnection(url, uid, passwd);
			stmt = cx.prepareStatement("UPDATE contact SET FIRSTNAME = ?, LASTNAME = ?, EMAIL = ? WHERE ID_CONTACT = ?");
			stmt.setObject(1, c.getFirstName());
			stmt.setObject(2, c.getLastName());
			stmt.setObject(3, c.getEmail());
			stmt.setObject(4, c.getId());
			System.out.println("updating...");
			stmt.executeUpdate();
		}
		catch (SQLException e){throw new RuntimeException(e);
		}finally{
			try{
				if (stmt != null) stmt.close();
				if (cx != null) cx.close();
			}catch (Exception e){throw new RuntimeException(e);}
		}
	}

	public List<Group> getGroups(int iD_Contact) {
		// Driver initialisation
		try {Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e1) {e1.printStackTrace();}

		List<Group> ContactList = new ArrayList<Group>();
		
		try{
			cx = DriverManager.getConnection(url , uid, passwd);
			
			String request = "SELECT * FROM contact "
					+ "INNER JOIN contact_groups ON contact.ID_CONTACT = contact_groups.REF_CONTACT "
					+ "INNER JOIN groups ON contact_groups.REF_GROUP=groups.ID_GROUP "
					+ "WHERE contact.ID_Contact = ?";
			
			stmt = cx.prepareStatement(request);
			
			stmt.setObject(1, iD_Contact);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("ID_GROUP");
				String nom = rs.getString("GROUP_NAME");
				
				ContactList.add(new Group(id, nom));
			}
		}catch(Exception e){throw new RuntimeException(e);
		}finally{}
		
		System.out.println("Returning contacts");
		
		return ContactList;
	}
	
}
