package domain;

public class Group {

	private int groupID;
	private String groupName;
	
	public Group(String groupName){
		this.groupName = groupName;
	}

	public Group(int id, String nom) {
		groupName = nom;
		groupID = id;
	}

	public Group() {
	}

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
	
}
