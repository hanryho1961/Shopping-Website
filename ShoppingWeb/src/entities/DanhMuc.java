package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DanhMuc {
	private String madm;
	private String tendm;
	
	public DanhMuc() {
		this.madm = "";
		this.tendm = "";
	}
	
	public DanhMuc(String madm, String tendm) {
		this.madm = madm;
		this.tendm = tendm;
	}
	
	public DanhMuc(ResultSet rs) {
		try {
			this.madm = rs.getString("madm");
			this.tendm = rs.getString("tendm");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public String getMadm() {
		return madm;
	}

	public void setMadm(String madm) {
		this.madm = madm;
	}

	public String getTendm() {
		return tendm;
	}

	public void setTendm(String tendm) {
		this.tendm = tendm;
	}

	@Override
	public String toString() {
		return "DanhMuc [madm=" + madm + ", tendm=" + tendm + "]";
	}
	
	
}
