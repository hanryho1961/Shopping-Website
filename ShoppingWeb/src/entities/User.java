package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	private int userid;
	private String username;
	private String password;
	private int roleid;
	
	public User() {
		userid = 0;
		username = "";
		password = "";
		roleid = 0;
	}
	
	public User(int userid, String username, String password, int roleid) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.roleid = roleid;
	}
	
	public User(ResultSet rs) {
		try {
			this.userid = rs.getInt("userid");
			this.username = rs.getString("username");
			this.password = rs.getString("password");
			this.roleid = rs.getInt("roleid");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", roleid=" + roleid
				+ "]";
	}
	
	
}
