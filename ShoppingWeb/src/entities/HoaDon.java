package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.org.apache.xpath.internal.SourceTree;

public class HoaDon {
	private int mahd;
	private String ngaydh;
	
	public HoaDon() {
		this.mahd = 0;
		this.ngaydh = "";
	}
	
	public HoaDon(int mahd, String ngayhd) {
		this.mahd = mahd;
		this.ngaydh = ngayhd;
	}
	
	public HoaDon(ResultSet rs) {
		try {
			this.mahd = rs.getInt("mahd");
			this.ngaydh = rs.getString("ngaydh");
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

	public String getNgaydh() {
		return ngaydh;
	}

	public void setNgaydh(String ngaydh) {
		this.ngaydh = ngaydh;
	}

	@Override
	public String toString() {
		return "HoaDon [mahd=" + mahd + ", ngaydh=" + ngaydh + "]";
	}
	
	
}
