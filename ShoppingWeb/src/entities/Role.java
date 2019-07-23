package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Role {
	private int roleid;
	private String role;
	
	public Role() {
		this.roleid = 0;
		this.role = "";
	}
	
	public Role(int roleid, String role) {
		this.roleid = roleid;
		this.role = role;
	}
	
	public Role(ResultSet rs) {
		try {
			this.roleid = rs.getInt("roleid");
			this.role = rs.getString("role");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", role=" + role + "]";
	}
	
	
}
