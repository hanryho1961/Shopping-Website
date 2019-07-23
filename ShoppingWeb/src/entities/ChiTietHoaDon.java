package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChiTietHoaDon {
	private int mahd;
	private String masp;
	private int soLuong;
	
	public ChiTietHoaDon() {
		this.mahd = 0;
		this.masp = "";
		this.soLuong = 0;
	}
	
	public ChiTietHoaDon(int mahd, String masp, int soLuong) {
		this.mahd = mahd;
		this.masp = masp;
		this.soLuong = soLuong;
	}
	
	public ChiTietHoaDon(ResultSet rs) {
		try {
			this.mahd = rs.getInt("mahd");
			this.masp = rs.getString("masp");
			this.soLuong = rs.getInt("soLuong");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public int getMahd() {
		return mahd;
	}

	public void setMahd(int mahd) {
		this.mahd = mahd;
	}

	public String getMasp() {
		return masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [mahd=" + mahd + ", masp=" + masp + ", soLuong=" + soLuong + "]";
	}
	
}
