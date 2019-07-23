package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connected.Connect;
import entities.OrderDetails;

public class OrderDetailsModel {
	public ArrayList<OrderDetails> getList() {
		ArrayList<OrderDetails> list = new ArrayList<OrderDetails>();
		try {
			if (Connect.connect()) {
				String sql = "select * from ORDERDETAILS";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					OrderDetails orderDetails = new OrderDetails(rs);
					list.add(orderDetails);
				}
			}
		} catch (SQLException e){
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return list;
	}
	
	public ArrayList<OrderDetails> getList(int orderID) {
		ArrayList<OrderDetails> list = new ArrayList<OrderDetails>();
		try {
			if (Connect.connect()) {
				String sql = "select * from ORDERDETAILS where orderid = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setInt(1, orderID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					OrderDetails orderDetails = new OrderDetails(rs);
					list.add(orderDetails);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return list;
	}
	
	public String addOrderDetails(String masp, int orderid, int soluong) {
		String message = "";
		try {
			if (Connect.connect()) {
				String sql = "insert into ORDERDETAILS values (?, ?, ?)";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, masp);
				ps.setInt(2, orderid);
				ps.setInt(3, soluong);
				int i = ps.executeUpdate();
				if (i != 0) {
					message = "Add OrderDetails Succeed";
				} else {
					message = "Add OrderDetails Fail";
				}
			}
		} catch (SQLException e) {
			message = e.getMessage();
		} finally {
			Connect.close();
		}
		return message;
	}
	
	public String updateOrderDetails(String masp, int orderid, int soluong) {
		String message = "";
		try {
			if (Connect.connect()) {
				String sql = "update ORDERDETAILS set masp = ?, soluong = ? where orderid = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, masp);
				ps.setInt(2, soluong);
				ps.setInt(3, orderid);
				int i = ps.executeUpdate();
				if (i != 0) {
					message = "Update OrderDetails Succeed";
				} else {
					message = "Update OrderDetails Fail";
				}
			}
		} catch (SQLException e) {
			message = e.getMessage();
		} finally {
			Connect.close();
		}
		return message;
	}
	
	public String deleteOrderDetails(String masp) {
		String message = "";
		try {
			if (Connect.connect()) {
				String sql = "delete from ORDERDETAILS where masp = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setString(1, masp);
				int i = ps.executeUpdate();
				if (i != 0) {
					message = "Delete OrderDetails Succeed";
				} else {
					message = "Delete OrderDetails Fail";
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
		OrderDetailsModel orderDetailsModel = new OrderDetailsModel();
		
		//getList()
		/*ArrayList<OrderDetails> list = orderDetailsModel.getList();
		for (OrderDetails detail : list) {
			System.out.println(detail);
		}*/
		
		//addOrderDetails(String masp, int orderid, int soluong)
		/*String message = orderDetailsModel.addOrderDetails("APL01", 2, 10);
		System.out.println(message);*/
		
		//updateOrderDetails(String masp, int orderid, int soluong)
		/*String message = orderDetailsModel.updateOrderDetails("APL02", 2, 100);
		System.out.println(message);*/
		
		//deleteOrderDetails(String masp)
		/*String message = orderDetailsModel.deleteOrderDetails("APL02");
		System.out.println(message);*/
	}
}
