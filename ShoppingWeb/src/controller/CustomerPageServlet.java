package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Items;
import entities.UserDetails;
import model.GioHangModel;
import model.OrderDetailsModel;
import model.OrderHistoryModel;
import model.SanPhamModel;
import model.UserDetailsModel;

/**
 * Servlet implementation class CustomerPageServlet
 */
@WebServlet("/CustomerPageServlet")
public class CustomerPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GioHangModel gioHangModel = new GioHangModel();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerPageServlet() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("task");
		HttpSession session = request.getSession();
		if (action.compareTo("delete") == 0) {
			gioHangModel.removeItems(request.getParameter("masp"));
			session.setAttribute("listitems", gioHangModel.getListItems());
			session.setAttribute("customername", request.getParameter("customername"));
			String page = "Cart.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("task");
		HttpSession session = request.getSession();
		if (action.compareTo("home") == 0) {
			String page = "Customer.jsp";
			session.setAttribute("customername", request.getParameter("customername"));
			request.getRequestDispatcher(page).forward(request, response);
		} else if (action.compareTo("search") == 0) {
			String searchBox = request.getParameter("searchBox");
			System.out.println(searchBox);
		} else if (action.compareTo("cart") == 0) {
			session.setAttribute("listitems", gioHangModel.getListItems());
			session.setAttribute("customername", request.getParameter("customername"));
			String page = "Cart.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		} else if (action.compareTo("delete") == 0) {
		
		} else if (action.compareTo("details") == 0) {
			session.setAttribute("customername", request.getParameter("customername"));
			String page = "UserDetails.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		} else if (action.compareTo("buyNow") == 0) {
			
		} else if (action.compareTo("addCart") == 0) {
			String masp = request.getParameter("masp");
			String customerName = request.getParameter("customername");
			String message = gioHangModel.addItems(masp);
			if (message.compareTo("Add Item Thanh Cong") == 0) {
				String page = "Customer.jsp";
				session.setAttribute("customername", customerName);
				request.getRequestDispatcher(page).forward(request, response);
			}
		} else if (action.compareTo("pay") == 0) {
			UserDetailsModel userDetailsModel = new UserDetailsModel();
			OrderHistoryModel orderHistoryModel = new OrderHistoryModel();
			OrderDetailsModel orderDetailsModel = new OrderDetailsModel();

			String total = request.getParameter("total");
			int totalCost = Integer.parseInt(total);
			String customername = request.getParameter("customername");
			UserDetails userDetails = userDetailsModel.getUser(customername);
			int userDetailsId = userDetails.getUserDetailsId();
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			Date date = new Date();
			int day = date.getDate();
			int month = date.getMonth() + 1;
			int year = Integer.parseInt(df.format(date));
			date = new Date(month + "/" + day + "/" + year);
			orderHistoryModel.addOrderHistory(date, totalCost, userDetailsId);
			int latestID = orderHistoryModel.getLatestId();
			ArrayList<Items> list = gioHangModel.getListItems();
			for (Items item: list) {
				String masp = item.getSanPham().getMasp();
				int soLuong = item.getSoLuong();
				orderDetailsModel.addOrderDetails(masp, latestID, soLuong);
			}
			gioHangModel.removeAll();
			String page = "Receipt.jsp";
			session.setAttribute("total", totalCost);
			session.setAttribute("date", date);
			session.setAttribute("customername", customername);
			request.getRequestDispatcher(page).forward(request, response);
		} else if (action.compareTo("payNow") == 0) {
			UserDetailsModel userDetailsModel = new UserDetailsModel();			
			OrderHistoryModel orderHistoryModel = new OrderHistoryModel();
			OrderDetailsModel orderDetailsModel = new OrderDetailsModel();
			String total = request.getParameter("total");
			int totalCost = Integer.parseInt(total);
			String customername = request.getParameter("customername");
			UserDetails userDetails = userDetailsModel.getUser(customername);
			int userDetailsId = userDetails.getUserDetailsId();
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			Date date = new Date();
			int day = date.getDate();
			int month = date.getMonth() + 1;
			int year = Integer.parseInt(df.format(date));
			date = new Date(month + "/" + day + "/" + year);
			orderHistoryModel.addOrderHistory(date, totalCost, userDetailsId);
			int latestID = orderHistoryModel.getLatestId();
			orderDetailsModel.addOrderDetails(request.getParameter("masp"), latestID, 1);
			gioHangModel.removeAll();
			String page = "Receipt.jsp";
			session.setAttribute("total", totalCost);
			session.setAttribute("date", date);
			session.setAttribute("customername", customername);
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
