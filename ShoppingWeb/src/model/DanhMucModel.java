package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connected.Connect;
import entities.DanhMuc;

public class DanhMucModel {	
	public ArrayList<DanhMuc> getList() {
		ArrayList<DanhMuc> list = new ArrayList<DanhMuc>();
		try {
			if (Connect.connect()) {
				String sql = "select * from DANHMUC";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					DanhMuc danhMuc = new DanhMuc(rs);
					list.add(danhMuc);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return list;
	}
	
	public DanhMuc getDanhMuc(String madm) {
		DanhMuc danhMuc = null;
		try {
			if (Connect.connect()) {
				String sql = "select * from DANHMUC where madm = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, madm);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					danhMuc = new DanhMuc(rs);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return danhMuc;
	}
	
	public String addDanhMuc(String madm, String tendm) {
		String result = "";
		try {
			if (Connect.connect()) {
				String sql = "insert into DANHMUC values (?, ?)";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, madm);
				ps.setString(2, tendm);
				int i = ps.executeUpdate();
				if (i != 0) {
					result = "Add Danh Muc Thanh Cong";
				} else {
					result = "Add Danh Muc That Bai";
				}
			}
		} catch (SQLException e) {
			result = e.getMessage();
		} finally {
			Connect.close();
		}
		return result;
	}
	
	public String updateDanhMuc(String madm, String tendm) {
		String result = "";
		try {
			if (Connect.connect()) {
				String sql = "update DANHMUC set tendm = ? where madm = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, tendm);
				ps.setString(2, madm);
				int i = ps.executeUpdate();
				if (i != 0) {
					result = "Update Danh Muc Thanh Cong";
				} else {
					result = "Update Danh Muc That Bai";
				}
			}
		} catch (SQLException e) {
			result = e.getMessage();
		} finally {
			Connect.close();
		}
		return result;
	}
	
	public String deleteDanhMuc(String madm) {
		String result = "";
		try {
			if (Connect.connect()) {
				String sql = "delete from DANHMUC where madm = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, madm);
				int i = ps.executeUpdate();
				if (i != 0) {
					result = "Delete Danh Muc Thanh Cong";
				} else {
					result = "Delete Danh Muc That Bai";
				}
			}
		} catch (SQLException e) {
			result = e.getMessage();
		} finally {
			Connect.close();
		}
		return result;
	}
	
	public static void main(String[] args) {
		DanhMucModel danhMucModel = new DanhMucModel();
		
		//getList()
		/*ArrayList<DanhMuc> list = danhMucModel.getList();
		for (DanhMuc danhMuc : list) {
			System.out.println(danhMuc);
		}*/
		
		//getDanhMuc(String madm) 
		/*DanhMuc danhMuc = danhMucModel.getDanhMuc("DM03");
		System.out.println(danhMuc);*/
		
		//addDanhMuc(String madm, String tendm)
		/*String result = danhMucModel.addDanhMuc("DM06", "Nokia");
		System.out.println(result);*/
		
		//updateDanhMuc(String madm, String tendm)
		/*String result = danhMucModel.updateDanhMuc("DM06", "LG");
		System.out.println(result);*/
		
		//deleteDanhMuc(String madm)
		/*String result = danhMucModel.deleteDanhMuc("DM06");
		System.out.println(result);*/
	}
}
