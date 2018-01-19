package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Contact;
import domain.Group;

public class GroupDAO {
	
	private String driver = "com.mysql.jdbc.Driver"; 
	private String url = "jdbc:mysql://localhost/jee";
	private String uid = "root";
	private String passwd = "root";
	private Connection cx;
	private PreparedStatement stmt;

	public String CreateGroup (Group g) {
		try {Class.forName(driver);
		}catch (ClassNotFoundException e1) {e1.printStackTrace();}
		
		try {
			cx = DriverManager.getConnection(url, uid, passwd);
			stmt = cx.prepareStatement("INSERT INTO groups (GROUP_NAME) VALUES (?)");
			System.out.println("Adding a new group to the base");
			stmt.setObject (1, g.getGroupName());

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

	public List<Group> GetGroups() {
		// Driver initialisation
				try {Class.forName("com.mysql.jdbc.Driver");
				}catch (ClassNotFoundException e1) {e1.printStackTrace();}

				List<Group> GroupList = new ArrayList<Group>();
				
				try{
					cx = DriverManager.getConnection(url , uid, passwd);
					stmt = cx.prepareStatement("SELECT * FROM groups");
					
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()){
						int id = rs.getInt("ID_GROUP");
						String nom = rs.getString("GROUP_NAME");
						
						GroupList.add(new Group(id, nom));
					}
				}catch(Exception e){throw new RuntimeException(e);
				}finally{}
				
				System.out.println("Returning groups");
				
				return GroupList;
	}

	public void DeleteGroup(int id) {
		try {Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e1) {e1.printStackTrace();}
		
		// Request
		try {
			cx = DriverManager.getConnection(url, uid, passwd);
			stmt = cx.prepareStatement("DELETE FROM groups WHERE ID_GROUP = ?");
			stmt.setObject (1, id);
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

	public Group GetGroup(int iD_Group) {
		// Driver initialisation
		try {Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e1) {e1.printStackTrace();}

		Group g = new Group();
		
		try{
			cx = DriverManager.getConnection(url , uid, passwd);
			stmt = cx.prepareStatement("SELECT * FROM groups WHERE ID_GROUP = ?");
			stmt.setObject(1, iD_Group);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				g.setGroupID(rs.getInt("ID_GROUP"));
				g.setGroupName(rs.getString("GROUP_NAME"));
			}
		}catch(Exception e){throw new RuntimeException(e);
		}finally{}
		
		System.out.println("Returning contact whose id is " + g.getGroupID());
		
		return g;
	}

	public void UpdateGroup(Group g) {
		try {Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e1) {e1.printStackTrace();}
		
		// Request
		try {
			cx = DriverManager.getConnection(url, uid, passwd);
			stmt = cx.prepareStatement("UPDATE groups SET GROUP_NAME = ? WHERE ID_GROUP = ?");
			stmt.setObject(1, g.getGroupName());
			stmt.setObject(2, g.getGroupID());
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

	public List<Contact> getContacts(int iD_Group) {
		// Driver initialisation
		try {Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e1) {e1.printStackTrace();}

		List<Contact> ContactList = new ArrayList<Contact>();
		
		try{
			cx = DriverManager.getConnection(url , uid, passwd);
			
			String request = "SELECT * FROM contact "
					+ "INNER JOIN contact_groups ON contact.ID_CONTACT = contact_groups.REF_CONTACT "
					+ "INNER JOIN groups ON contact_groups.REF_GROUP=groups.ID_GROUP "
					+ "WHERE groups.ID_GROUP = ?";
			
			stmt = cx.prepareStatement(request);
			
			stmt.setObject(1, iD_Group);
			
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
	
}
