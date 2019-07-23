package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connected.Connect;
import entities.User;

public class UserModel {
	public User getUser(String username) {
		User user = null;
		try {
			if (Connect.connect()) {
				String sql = "select * from [USER] where username = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					user = new User(rs);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return user;
	}
	
	public String login(String username, String password) {
		String message = "";
		try {
			if (Connect.connect()) {
				String sql = "select * from [USER] where username = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					if (rs.getString("password").compareTo(password) == 0) {
						message = "Login Succeed";
					} else {
						message = "Incorrect Password";
					}
				} else {
					message = "Username Doesn't Exist";
				}
			}
		} catch (SQLException e) {
			message = e.getMessage();
		} finally {
			Connect.close();
		}
		return message;
	}
	
	public String updatePassword(String username, String password) {
		String message = "";
		try {
			if (Connect.connect()) {
				String sql = "update [USER] set password = ? where username = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, password);
				ps.setString(2, username);
				int i = ps.executeUpdate();
				if (i != 0) {
					message = "Update Password Succeed";
				} else {
					message = "Update Password Fail";
				}
			}
		} catch (SQLException e) {
			message = e.getMessage();
		} finally {
			Connect.close();
		}
		return message;
	}
	
	public String getPassword (String username) {
		String password = "";
		try {
			if (Connect.connect()) {
				String sql = "select * from [USER] where username = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					password = rs.getString("password");
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return password;
	}
	
	public String getRole(String username) {
		String role = "";
		try {
			if (Connect.connect()) {
				String sql = "select r.role from [USER] u, ROLE r where u.username = ? and u.roleid=r.roleid";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					role = rs.getString("role");
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return role;
	}
	
	public int getLatestUserId() {
		int userId = -1;
		try {
			if (Connect.connect()) {
				String sql = "select max(userid) as latestid from [USER]";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					userId = rs.getInt("latestid");
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return userId;
	}
	
	public ArrayList<User> getList() {
		ArrayList<User> list = new ArrayList<User>();
		try {
			if (Connect.connect()) {
				String sql = "select * from [USER]";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					User user = new User(rs);
					list.add(user);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return list;
	}
	
	public User getUser(int userid) {
		User user = null;
		try {
			if (Connect.connect()) {
				String sql = "select * from [USER] where userid = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setInt(1, userid);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					user = new User(rs);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return user;
	}
	
	public String addUser(String username, String password, int roleid) {
		String message = "";
		try {
			if (Connect.connect()) {
				String sql = "insert into [USER] (username, password, roleid) values (?, ?, ?)";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setInt(3, roleid);
				int i = ps.executeUpdate();
				if (i != 0) {
					message = "Add User Thanh Cong";
				} else {
					message = "Add User That Bai";
				}
			}
		} catch (SQLException e) {
			message = e.getMessage();
		} finally {
			Connect.close();
		}
		return message;
	}
	
	public String updateUser(int userid, String username, String password, int roleid) {
		String message = "";
		try {
			if (Connect.connect()) {
				String sql = "update [USER] set username = ?, password = ?, roleid = ? where userid = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setInt(3, roleid);
				ps.setInt(4, userid);
				int i = ps.executeUpdate();
				if (i != 0) {
					message = "Update User Thanh Cong";
				} else {
					message = "Update User That Bai";
				}
			}
		} catch (SQLException e) {
			message = e.getMessage();
		} finally {
			Connect.close();
		}
		return message;
	}
	
	public String deleteUser(int userid) {
		String message = "";
		try {
			if (Connect.connect()) {
				String sql = "delete from [USER] where userid = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setInt(1, userid);
				int i = ps.executeUpdate();
				if (i != 0) {
					message = "Delete User Thanh Cong";
				} else {
					message = "Delete User THat Bai";
				}
			}
		} catch (SQLException e) {
			message = e.getMessage();
		} finally {
			Connect.close();
		}
		return message;
	}
	
	public static void main(String[] args) {
		UserModel userModel = new UserModel();
		
		//getList()
		/*ArrayList<User> list = userModel.getList();
		for (User user: list) {
			System.out.println(user);
		}*/
		
		//getUser(int userid) 
		/*User user = userModel.getUser("henryho1612");
		System.out.println(user);*/
		
		//addUser(String username, String password, int roleid) 
		/*String message = userModel.addUser("username", "password", 2);
		System.out.println(message);*/
		
		//updateUser(int userid, String username, String password, int roleid)
		/*String message = userModel.updateUser(3, "USERNAME", "PASSWORD", 2);
		System.out.println(message);*/
		
		
		//deleteUser(int userid)
		/*String message = userModel.deleteUser(3);
		System.out.println(message);*/
		
		//getRole(String username)
		/*String role = userModel.getRole("hanryho1612");
		System.out.println(role);*/
		
		//getLatestUserId()
		/*int i = userModel.getLatestUserId();
		System.out.println("Latest id: " + i);*/
		
		//getPassword(String username)
		/*String password = userModel.getPassword("henryho1612");
		System.out.println(password);*/
	}
}
