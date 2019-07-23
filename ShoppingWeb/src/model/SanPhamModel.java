package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Part;

import connected.Connect;
import entities.SanPham;

public class SanPhamModel {
	private Part file;
	
	public SanPhamModel() {
		file = null;
	}
	
	public SanPhamModel(Part file) {
		this.file = file;
	}
	
	public ArrayList<SanPham> getList() {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		try {
			if (Connect.connect()) {
				String sql = "select * from SANPHAM";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					SanPham sanPham = new SanPham(rs);
					list.add(sanPham);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return list;
	}
	
	public ArrayList<SanPham> getList(String madm) {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		try {
			if (Connect.connect()) {
				String sql = "select * from SANPHAM where madm = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, madm);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					SanPham sanPham = new SanPham(rs);
					list.add(sanPham);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return list;
	}
	
	public SanPham getSanPham(String masp) {
		SanPham sanPham = null;
		try {
			if (Connect.connect()) {
				String sql = "select * from SANPHAM where masp = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, masp);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					sanPham = new SanPham(rs);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return sanPham;
	}
	
	public String addSanPham(String masp, String tensp, int gia, String hinh, String madm) {
		String result = "";
		try {
			if (Connect.connect()) {
				String sql = "insert into SANPHAM values (?, ?, ?, ?, ?)";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, masp);
				ps.setString(2, tensp);
				ps.setInt(3, gia);
				ps.setString(4, hinh);
				ps.setString(5, madm);
				int i = ps.executeUpdate();
				if (i != 0) {
					result = "Add San Pham Thanh Cong";
				} else {
					result = "Add San Pham That Bai";
				}
			}
		} catch (SQLException e) {
			result = e.getMessage();
		} finally {
			Connect.close();
		}
		return result;
	}
	
	public String updateSanPham(String masp, String tensp, int gia, String hinh, String madm) {
		String result = "";
		try {
			if (Connect.connect()) {
				String sql = "update SANPHAM set tensp = ?, gia = ?, hinh = ?, madm = ? where masp = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, tensp);
				ps.setInt(2, gia);
				ps.setString(3, hinh);
				ps.setString(4, madm);
				ps.setString(5, masp);
				int i = ps.executeUpdate();
				if (i != 0) {
					result = "Update San Pham Thanh Cong";
				} else {
					result = "Update San Pham That Bai";
				}
			}
		} catch (SQLException e) {
			result = e.getMessage();
		} finally {
			Connect.close();
		}
		return result;
	}
	
	public String deleteSanPham(String masp) {
		String result = "";
		try {
			if (Connect.connect()) {
				String sql = "delete from SANPHAM where masp = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, masp);
				int i = ps.executeUpdate();
				if (i != 0) {
					result = "Delete San Pham Thanh Cong";
				} else {
					result = "Delete San Pham That Bai";
				}
			}
		} catch (SQLException e) {
			result = e.getMessage();
		} finally {
			Connect.close();
		}
		return result;
	}
	
	/**
	 * Extra function for uploading to server
	 * @param filePart
	 * @return
	 */
	public String getFileName(Part filepart) {
		String filename="";
		String header = filepart.getHeader("Content-Disposition"); //System.out.println("header:" + header);
		int beginIndex = header.lastIndexOf("=");
		filename = header.substring(beginIndex+1);
		//remove "" quotes 2 dau chuoi
		Pattern p = Pattern.compile("\"([^\"]*)\""); Matcher m = p.matcher(filename);
		while (m.find())
		filename = m.group(1);
		//danh cho IE
		beginIndex = filename.lastIndexOf("\\"); filename = filename.substring(beginIndex+1); //System.out.println("filename:" + filename);
		return filename;	}
	
	/**
	 * Extra function for uploading to server
	 * @param uploadRootPath
	 */
	public void uploadFile(String uploadRootPath) {
		try {
			java.io.InputStream fis = file.getInputStream(); 
			byte[]data = new byte[fis.available()]; 
			if (data.length == 0) {
				System.out.println("EMPTY");
			}
			fis.read(data);
			FileOutputStream out = new FileOutputStream(new File( uploadRootPath + "/" + getFileName(file)));
			out.write(data);
			out.close(); 
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("That bai"); 
		}
		System.out.println("Thanh cong"); 
	}
			
	
	
	
	public static void main(String[] args) {
		SanPhamModel sanPhamModel = new SanPhamModel();
		
		//getList()
		/*ArrayList<SanPham> list = sanPhamModel.getList();
		for (SanPham sanPham : list) {
			System.out.println(sanPham);
		}*/
		
		//getSanPham(String masp);
		/*SanPham sanPham = sanPhamModel.getSanPHam("AS01");
		System.out.println(sanPham);*/
		
		//addSanPham(String masp, String tensp, int gia, String hinh, String madm)
		/*String result = sanPhamModel.addSanPham("masp", "tensp", 10, "hinh", "DM05");
		System.out.println(result);*/
		
		//updateSanPham(String masp, String tensp, int gia, String hinh, String madm)
		/*String result = sanPhamModel.updateSanPham("masp", "tensp", 1000, "hinh", "DM05");
		System.out.println(result);*/
		
		//deleteSanPham(String masp)
		/*String result = sanPhamModel.deleteSanPham("masp");
		System.out.println(result);*/
	}
}
