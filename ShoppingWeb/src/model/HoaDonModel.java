package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connected.Connect;
import entities.HoaDon;

public class HoaDonModel {
	public ArrayList<HoaDon> getList() {
		ArrayList<HoaDon> list = new ArrayList<HoaDon>();
		try {
			if (Connect.connect()) {
				String sql = "select * from HOADON";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					HoaDon hoaDon = new HoaDon(rs);
					list.add(hoaDon);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return list;
	}
	
	public HoaDon getHoaDon(int mahd) {
		HoaDon hoaDon = null;
		try {
			if (Connect.connect()) {
				String sql = "select * from HOADON where mahd = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setInt(1, mahd);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					hoaDon = new HoaDon(rs);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return hoaDon;
	}
	
	public int getNewestHoaDonID() {
		int newId = 0;
		try {
			if (Connect.connect()) {
				String sql = "select max(mahd) from HOADON";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					newId = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return newId;
	}
	
	public String addHoaDon(String ngaydh) {
		String result = "";
		try {
			if (Connect.connect()) {
				String sql = "insert into HOADON values (?, ?)";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setInt(1, (getNewestHoaDonID() + 1));
				ps.setString(2, ngaydh);
				int i = ps.executeUpdate();
				if (i != 0) {
					result = "Add Hoa Don Thanh Cong";
				} else {
					result = "Add Hoa Don That Bai";
				}
			}
		} catch (SQLException e) {
			result = e.getMessage();
		} finally {
			Connect.close();
		}
		return result;
	}
	
	public String updateHoaDon(int mahd, String ngaydh) {
		String result = "";
		try {
			if (Connect.connect()) {
				String sql = "update HOADON set ngaydh = ? where mahd = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, ngaydh);
				ps.setInt(2, mahd);
				int i = ps.executeUpdate();
				if (i != 0) {
					result = "Update Hoa Don Thanh Cong";
				} else {
					result = "Update Hoa Don That Bai";
				}
			}
		} catch (SQLException e) {
			result = e.getMessage();
		} finally {
			Connect.close();
		}
		return result;
	}
	
	public String deleteHoaDon(int mahd) {
		String result = "";
		try {
			if (Connect.connect()) {
				String sql = "delete from HOADON where mahd = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setInt(1, mahd);
				int i = ps.executeUpdate();
				if (i != 0) {
					result = "Delete Hoa Don Thanh Cong";
				} else {
					result = "Delete Hoa Don That Bai";
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
		HoaDonModel hoaDonModel = new HoaDonModel();
		
		//getList() 
		/*ArrayList<HoaDon> list = hoaDonModel.getList();
		for (HoaDon hoaDon: list) {
			System.out.println(hoaDon);
		}*/
		
		//getHoaDon(int mahd) 
		/*HoaDon hoaDon = hoaDonModel.getHoaDon(2);
		System.out.println(hoaDon);*/
		
		//addHoaDon(int mahd, String ngaydh)
		/*String result = hoaDonModel.addHoaDon(2, "02/10/2010");
		System.out.println(result);*/
		
		//updateHoaDon(int mahd, String ngaydh) 
		/*String result = hoaDonModel.updateHoaDon(1, "04/01/2017");
		System.out.println(result);*/
		
		//deleteHoaDon(int mahd)
		/*String result = hoaDonModel.deleteHoaDon(1);
		System.out.println(result);*/
		
		//getNewestHoaDonID()
		int latestID = hoaDonModel.getNewestHoaDonID();
		System.out.println(latestID);
	}
}
