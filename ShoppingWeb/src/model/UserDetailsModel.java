package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import connected.Connect;
import entities.UserDetails;

public class UserDetailsModel {
	public UserDetails getUser(String username) {
		UserDetails userDetails = null;
		try {
			if (Connect.connect()) {
				String sql = "select d.* from [USER] u, [USERDETAILS] d where u.userid = d.userid and u.username = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					userDetails = new UserDetails(rs);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return userDetails;
	}
	
	public ArrayList<UserDetails> getList() {
		ArrayList<UserDetails> list = new ArrayList<UserDetails>();
		try {
			if(Connect.connect()) {
				String sql = "select * from USERDETAILS";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					UserDetails user = new UserDetails(rs);
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
	
	public UserDetails getUserDetails(int userid) {
		UserDetails user = null;
		try {
			if (Connect.connect()) {
				String sql = "select * from USERDETAILS where userid = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setInt(1, userid);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					user = new UserDetails(rs);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return user;
	}
	
	public String addUserDetails(String firstname, String lastname, Date dateOfBirth, String gender, int userid) {
		String message = "";
		try {
			if (Connect.connect()) {
				String sql = "insert into USERDETAILS (userfirstname, userlastname, dateofbirth, gender, userid) values (?, ?, ?, ?, ?)";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, firstname);
				ps.setString(2, lastname);
				ps.setDate(3,  new java.sql.Date(dateOfBirth.getTime()));
				ps.setString(4, gender);
				ps.setInt(5, userid);
				int i = ps.executeUpdate();
				if (i != 0) {
					message = "Add UserDetails Succeed";
				} else {
					message = "Add UserDetails Fail";
				}
			}
		} catch (SQLException e) {
			message = e.getMessage();
		} finally {
			Connect.close();
		}
		return message;
	}
	
	public String updateUserDetails(String firstname, String lastname, Date dateOfBirth, String gender, int userid) {
		String message = "";
		try {
			if (Connect.connect()) {
				String sql = "update USERDETAILS set userfirstname = ?, userlastname = ?, dateofbirth = ?, gender = ? where userid = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, firstname);
				ps.setString(2, lastname);
				ps.setDate(3,  new java.sql.Date(dateOfBirth.getTime()));
				ps.setString(4, gender);
				ps.setInt(5, userid);
				int i = ps.executeUpdate();
				if (i != 0) {
					message = "Update UserDetails Succeed";
				} else {
					message = "Update UserDetails Fail";
				}
			}
		} catch (SQLException e) {
			message = e.getMessage();
		} finally {
			Connect.close();
		}
		return message;
	}
	
	public String deleteUserDetails(int userDetailsId) {
		String message = "";
		try {
			if (Connect.connect()) {
				String sql = "delete from USERDETAILS where userdetailsid = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setInt(1, userDetailsId);
				int i = ps.executeUpdate();
				if (i != 0) {
					message = "Update UserDetails Succeed";
				} else {
					message = "Update UserDetails Fail";
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
		UserDetailsModel userDetailModel = new UserDetailsModel();
		
		//getList
		/*ArrayList<UserDetails> list = userDetailModel.getList();
		for (UserDetails ud: list) {
			System.out.println(ud);
		}*/
		
		//getUserDetails(int userid) 
		/*UserDetails user = userDetailModel.getUserDetails(1);
		System.out.println(user.getDate());*/
		
		//addUserDetails(String firstname, String lastname, Date dateOfBirth, String gender, int userid)
		/*String message = userDetailModel.addUserDetails("firstname", "lastname", new Date("04/20/1968"), "Male", 1);
		System.out.println(message);*/
		
		//updateUserDetails(String firstname, String lastname, Date dateOfBirth, String gender, int userid)
		/*String message = userDetailModel.updateUserDetails("Xuan Hoa", "Ho", new Date("04/9/1999"), "Male", 1);
		System.out.println(message);*/
		
		//deleteUserDetails(int userDetailsId) 
		/*String message = userDetailModel.deleteUserDetails(4);
		System.out.println(message);*/
		
		//getUser(String username)
		/*UserDetails userDetails= userDetailModel.getUser("henryho1612");
		System.out.println(userDetails);*/
	}
}
