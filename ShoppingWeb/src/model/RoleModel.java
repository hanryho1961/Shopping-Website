package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connected.Connect;
import entities.Role;

public class RoleModel {
	public ArrayList<Role> getList() {
		ArrayList<Role> list = new ArrayList<Role>();
		try {
			if (Connect.connect()) {
				String sql = "select * from ROLE";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Role role = new Role(rs);
					list.add(role);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return list;
	}
	
	public Role getRole(int roleid) {
		Role role = null;
		try {
			if (Connect.connect()) {
				String sql = "select * from ROLE where roleid = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setInt(1, roleid);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					role = new Role(rs);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return role;
	}
	
	public String addRole(String role) {
		String message = "";
		try {
			 if (Connect.connect()) {
				 String sql = "insert into ROLE (role) values (?)";
				 PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				 ps.setString(1, role);
				 int i = ps.executeUpdate();
				 if (i != 0) {
					 message = "Add Role Thanh Cong";
				 } else {
					 message = "Add Role That Bai";
				 }
			 }
		} catch (SQLException e) {
			message = e.getMessage();
		} finally {
			Connect.close();
		}
		return message;
	}
	
	public String update(int roleid, String role) {
		String message = "";
		try {
			if (Connect.connect()) {
				String sql = "update ROLE set role = ? where roleid = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, role);
				ps.setInt(2, roleid);
				int i = ps.executeUpdate();
				if (i != 0) {
					message = "Update Role Thanh Cong";
				} else {
					message = "Update Role That Bai";
				}
			}
		} catch (SQLException e) {
			message = e.getMessage();
		} finally {
			Connect.close();
		}
		return message;
	}
	
	public String delete (int roleid) {
		String message = "";
		try {
			 if (Connect.connect()) {
				 String sql = "delete from ROLE where roleid = ?";
				 PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				 ps.setInt(1, roleid);
				 int i = ps.executeUpdate();
				 if (i != 0) {
					 message = "Delete Role Thanh Cong";
				 } else {
					 message = "Delete Role That Bai";
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
		RoleModel roleModel = new RoleModel();
		
		//getList()
		/*ArrayList<Role> list = roleModel.getList();
		for (Role role: list) {
			System.out.println(role);
		}*/
		
		//getRole(int roleid) 
		/*Role role = roleModel.getRole(1);
		System.out.println(role);*/
		
		//addRole(String role) 
		/*String message = roleModel.addRole("designer");
		System.out.println(message);*/
		
		//update(int roleid, String role)
		/*String message = roleModel.update(3, "VIP");
		System.out.println(message);*/
		
		//delete(int roleid) 
		/*String message = roleModel.delete(3);
		System.out.println(message);*/
	}
}
