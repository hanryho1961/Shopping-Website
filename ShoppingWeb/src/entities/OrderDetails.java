package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetails {
	private String masp;
	private int orderid;
	private int soLuong;
	
	public OrderDetails() {
		this.masp = "";
		this.orderid = 0;
		this.soLuong = 0;
	}
	
	public OrderDetails(String masp, int orderid, int soLuong) {
		this.masp = masp;
		this.orderid = orderid;
		this.soLuong = soLuong;
	}
	
	public OrderDetails (ResultSet rs) {
		try {
			this.masp = rs.getString("masp");
			this.orderid = rs.getInt("orderid");
			this.soLuong = rs.getInt("soluong");
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

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "OrderDetails [masp=" + masp + ", orderid=" + orderid + "]";
	}
	
	
}
