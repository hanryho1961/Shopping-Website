package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SanPham {
	private String masp;
	private String tensp;
	private int gia;
	private String hinh;
	private String madm;
	
	public SanPham() {
		this.masp = "";
		this.tensp = "";
		this.gia = 0;
		this.hinh = "";
		this.madm = "";
	}
	
	public SanPham(String masp, String tensp, int gia, String hinh, String madm) {
		this.masp = masp;
		this.tensp = tensp;
		this.gia = gia;
		this.hinh = hinh;
		this.madm = madm;
	}
	
	public SanPham(ResultSet rs) {
		try {
			this.masp = rs.getString("masp");
			this.tensp = rs.getString("tensp");
			this.gia = rs.getInt("gia");
			this.hinh = rs.getString("hinh");
			this.madm = rs.getString("madm");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public String getMasp() {
		return masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public String getMadm() {
		return madm;
	}

	public void setMadm(String madm) {
		this.madm = madm;
	}

	@Override
	public String toString() {
		return "SanPham [masp=" + masp + ", tensp=" + tensp + ", gia=" + gia + ", hinh=" + hinh + ", madm=" + madm
				+ "]";
	}
	
	
}
