package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Contact_GroupDAO {

	private String driver = "com.mysql.jdbc.Driver"; 
	private String url = "jdbc:mysql://localhost/jee";
	private String uid = "root";
	private String passwd = "root";
	private Connection cx;
	private PreparedStatement stmt;
	
	public void AddContact(int ref_contact, int ref_group) {
		// Driver initialisation
				try {Class.forName(driver);
				}catch (ClassNotFoundException e1) {e1.printStackTrace();}
				
				// Request
				try {
					cx = DriverManager.getConnection(url, uid, passwd);
					stmt = cx.prepareStatement("INSERT INTO contact_groups (REF_CONTACT, REF_GROUP) VALUES (?, ?)");
					stmt.setObject (1, ref_contact);
					stmt.setObject (2, ref_group);

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

	public void DeleteContact(int id) {
		try {Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e1) {e1.printStackTrace();}
		
		// Request
		try {
			cx = DriverManager.getConnection(url, uid, passwd);
			stmt = cx.prepareStatement("DELETE FROM contact_groups WHERE REF_CONTACT = ?");
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

	public void DeleteGroupe(int id) {
		try {Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e1) {e1.printStackTrace();}
		
		// Request
		try {
			cx = DriverManager.getConnection(url, uid, passwd);
			stmt = cx.prepareStatement("DELETE FROM contact_groups WHERE REF_GROUP = ?");
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

	public void DeleteContactFrom(int id_c, int id_g) {
		try {Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e1) {e1.printStackTrace();}
		
		// Request
		try {
			cx = DriverManager.getConnection(url, uid, passwd);
			stmt = cx.prepareStatement("DELETE FROM contact_groups WHERE REF_CONTACT = ? AND REF_GROUP = ?");
			stmt.setObject (1, id_c);
			stmt.setObject (2, id_g);
			
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

}
