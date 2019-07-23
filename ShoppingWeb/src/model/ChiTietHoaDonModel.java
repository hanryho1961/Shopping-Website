package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import connected.Connect;
import entities.ChiTietHoaDon;

public class ChiTietHoaDonModel {
	public ArrayList<ChiTietHoaDon> getList() {
		ArrayList<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		try {
			if (Connect.connect()) {
				String sql = "select * from CHITIETHOADON";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					ChiTietHoaDon chiTiet = new ChiTietHoaDon(rs);
					list.add(chiTiet);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return list;
	}
	
	public HashMap<String, Integer> getFromHD(int mahd) {
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		try {
			if (Connect.connect()) {
				String sql = "select * from CHITIETHOADON where mahd = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setInt(1, mahd);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String masp = rs.getString("masp");
					Integer soLuong = rs.getInt("soLuong");
					list.put(masp, soLuong);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return list;
	}
	
	public HashMap<Integer, Integer> getFromSP(String masp) {
		HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
		try {
			if (Connect.connect()) {
				String sql = "select * from CHITIETHOADON where masp = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, masp);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Integer mahd = rs.getInt("mahd");
					Integer soLuong = rs.getInt("soLuong");
					list.put(mahd, soLuong);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return list;
	}
	
	public int totalBanSanPham(String masp) {
		int i = 0;
		try {
			if (Connect.connect()) {
				String sql = "select * from CHITIETHOADON where masp = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, masp);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					i += rs.getInt("soLuong");
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return i;
	}
	
	public int totalSanPhamMua(int mahd) {
		int i = 0;
		try {
			if (Connect.connect()) {
				String sql = "select * from CHITIETHOADON where mahd = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setInt(1, mahd);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					i += rs.getInt("soLuong");
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return i;
	}
	
	public String addChiTietHoaDon(int mahd, String masp, int soLuong) {
		String result = "";
		try {
			if (Connect.connect()) {
				String sql = "insert into CHITIETHOADON values (?, ?, ?)";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setInt(1, mahd);
				ps.setString(2, masp);
				ps.setInt(3, soLuong);
				int i = ps.executeUpdate();
				if (i != 0) {
					result = "Add ChiTietHoaDon Thanh Cong";
				} else {
					result = "Add ChiTietHoaDon That Bai";
				}
			}
		} catch (SQLException e) {
			result = e.getMessage();
		} finally {
			Connect.close();
		}
		return result;
	}
	
	public String updateChiTietHoaDon(int mahd, String masp, int soLuong) {
		String result = "";
		try {
			if (Connect.connect()) {
				String sql = "update CHITIETHOADON set soLuong = ? where mahd = ? and masp = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setInt(1, soLuong);
				ps.setInt(2, mahd);
				ps.setString(3, masp);
				int i = ps.executeUpdate();
				if (i != 0) {
					result = "Update ChiTietHoaDon Thanh Cong";
				} else {
					result = "Update ChiTietHoaDon That Bai";
				}
			}
		} catch (SQLException e) {
			result = e.getMessage();
		} finally {
			Connect.close();
		}
		return result;
	}
	
	public String deleteChiTietHoaDon(int mahd, String masp) {
		String result = "";
		try {
			if (Connect.connect()) {
				String sql = "delete from CHITIETHOADON where mahd = ? and masp = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setInt(1, mahd);
				ps.setString(2, masp);
				int i = ps.executeUpdate();
				if (i != 0) {
					result = "Delete ChiTietHoaDon Thanh Cong";
				} else {
					result = "Delete ChiTietHoaDon That Bai";
				}
			}
		} catch (SQLException e) {
			result = e.getMessage();
		} finally {
			Connect.close();
		}
		return result;
	}
	
	public static void main(String [] args) {
		ChiTietHoaDonModel chiTietHoaDonModel = new ChiTietHoaDonModel();
		
		//getList()
		/*ArrayList<ChiTietHoaDon> list = chiTietHoaDonModel.getList();
		for (ChiTietHoaDon chiTiet: list) {
			System.out.println(chiTiet);
		}*/
		
		//getFromHD(int mahd)
		/*HashMap<String, Integer> list = chiTietHoaDonModel.getFromHD(1);
		for (Map.Entry<String, Integer> entry : list.entrySet()) {
			System.out.print(entry.getKey() + "\t");
			System.out.println(entry.getValue());
		}*/
		
		//getFromSP(String masp) 
		/*HashMap<Integer, Integer> list = chiTietHoaDonModel.getFromSP("APL01");
		for (Map.Entry<Integer, Integer> entry : list.entrySet()) {
			System.out.print(entry.getKey() + "\t");
			System.out.println(entry.getValue());
		}*/
		
		//totalBanSanPham(String masp)
		/*int i = chiTietHoaDonModel.totalBanSanPham("APL01");
		System.out.println(i);*/
		
		//totalSanPhamMua(int mahd)
		/*int i = chiTietHoaDonModel.totalSanPhamMua(1);
		System.out.println(i);*/
		
		//addChiTietHoaDon(int mahd, String masp, int soLuong)
		/*String result = chiTietHoaDonModel.addChiTietHoaDon(1, "APL01", 10);
		System.out.println(result);*/
		
		//updateChiTietHoaDon(int mahd, String masp, int soLuong)
		/*String result = chiTietHoaDonModel.updateChiTietHoaDon(1, "APL01", 100);
		System.out.println(result);*/
		
		//deleteChiTietHoaDon(int mahd, String masp)
		/*String result = chiTietHoaDonModel.deleteChiTietHoaDon(2, "APL01");
		System.out.println(result);*/

	}
}
