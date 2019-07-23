package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import connected.Connect;
import entities.OrderHistory;

public class OrderHistoryModel {
	public ArrayList<OrderHistory> getList() {
		ArrayList<OrderHistory> list = new ArrayList<OrderHistory>();
		try {
			if (Connect.connect()) {
				String sql = "select * from ORDERHISTORY";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					OrderHistory orderHistory = new OrderHistory(rs);
					list.add(orderHistory);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return list;
	}
	
	public ArrayList<OrderHistory> getUserList(int userDetailsId) {
		ArrayList<OrderHistory> list = new ArrayList<OrderHistory>();
		try {
			if (Connect.connect()) {
				String sql = "select * from ORDERHISTORY where userdetailsid = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setInt(1, userDetailsId);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					OrderHistory orderHistory = new OrderHistory(rs);
					list.add(orderHistory);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return list;
	}
	
	public int getLatestId() {
		int latestId = 0;
		try {
			if (Connect.connect()) {
				String sql = "select max(orderid) as latest from ORDERHISTORY";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					latestId = rs.getInt("latest");
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Connect.close();
		}
		return latestId;
	}
	
	public String addOrderHistory(Date dateOrder, int cost, int userDetailsId) {
		String message = "";
		try {
			if (Connect.connect()) {
				String sql = "insert into ORDERHISTORY (dateorder, cost, userdetailsid) values (?, ?, ?)";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setDate(1, new java.sql.Date(dateOrder.getTime()));
				ps.setInt(2, cost);
				ps.setInt(3, userDetailsId);
				int i = ps.executeUpdate();
				if (i != 0) {
					message = "Add OrderHistory Succeed";
				} else {
					message = "Add OrderHistory Fail";
				}
			}
		} catch (SQLException e) {
			message = e.getMessage();
		} finally {
			Connect.close();
		}
		return message;
	}
	
	public String updateOrderHistory(int orderid, Date dateOrder, int cost, int userDetailsId) {
		String message = "";
		try {
			if (Connect.connect()) {
				String sql = "update ORDERHISTORY set dateorder = ?, cost = ?, userdetailsid = ? where orderid = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setDate(1, new java.sql.Date(dateOrder.getTime()));
				ps.setInt(2, cost);
				ps.setInt(3, userDetailsId);
				ps.setInt(4, orderid);
				int i = ps.executeUpdate();
				if (i != 0) {
					message = "Update OrderHistory Succeed";
				} else {
					message = "Update OrderHistory Fail";
				}
			}
		} catch (SQLException e) {
			message = e.getMessage();
		} finally {
			Connect.close();
		}
		return message;
	}
	
	public String deleteOrderHistory(int orderid) {
		String message = "";
		try {
			if (Connect.connect()) {
				String sql = "delete from ORDERHISTORY where orderid = ?";
				PreparedStatement ps = Connect.getConnection().prepareStatement(sql);
				ps.setInt(1, orderid);
				int i = ps.executeUpdate();
				if (i != 0) {
					message = "Delete OrderHistory Succeed";
				} else {
					message = "Delete OrderHistory Fail";
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
		OrderHistoryModel orderHistoryModel = new OrderHistoryModel();
		
		//getList()
		/*ArrayList<OrderHistory> list = orderHistoryModel.getList();
		for (OrderHistory order: list) {
			System.out.println(order);
		}*/
		
		//addOrderHistory(Date dateOrder, int cost, int userDetailsId)
		/*String message = orderHistoryModel.addOrderHistory(new Date("6/23/2019"), 12, 2);
		System.out.println(message);*/
		
		//updateOrderHistory(int orderid, Date dateOrder, int cost, int userDetailsId)
		/*String message = orderHistoryModel.updateOrderHistory(1, new Date("6/23/2019"), 100, 2);
		System.out.println(message);*/
		
		//deleteOrderHistory(int orderid) 
		/*String message = orderHistoryModel.deleteOrderHistory(2);
		System.out.println(message);*/
	}
}
