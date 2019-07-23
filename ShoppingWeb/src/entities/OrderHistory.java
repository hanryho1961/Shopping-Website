package entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrderHistory {
	private int orderId; 
	private Date dateOrder;
	private int cost;
	private int userDetailsId;
	
	public OrderHistory() {
		this.orderId = 0;
		this.dateOrder = null;
		this.cost = 0;
		this.userDetailsId = 0;
	}

	public OrderHistory(int orderId, Date dateOrder, int cost, int userDetailsId) {
		this.orderId = orderId;
		this.dateOrder = dateOrder;
		this.cost = cost;
		this.userDetailsId = userDetailsId;
	}
	
	public OrderHistory(ResultSet rs) {
		try {
			this.orderId = rs.getInt("orderid");
			java.sql.Date date = rs.getDate("dateorder");
			this.dateOrder = new Date(date.getTime());
			this.cost = rs.getInt("cost");
			this.userDetailsId = rs.getInt("userdetailsid");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getUserDetailsId() {
		return userDetailsId;
	}

	public void setUserDetailsId(int userDetailsId) {
		this.userDetailsId = userDetailsId;
	}

	@Override
	public String toString() {
		return "OrderHistory [orderId=" + orderId + ", dateOrder=" + dateOrder + ", cost=" + cost + ", userDetailsId="
				+ userDetailsId + "]";
	}
	
	
}
