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

import com.sun.media.sound.SoftTuning;

import entities.OrderHistory;
import entities.UserDetails;
import model.OrderHistoryModel;
import model.UserDetailsModel;
import model.UserModel;

/**
 * Servlet implementation class UserDetailsServlet
 */
@WebServlet("/UserDetailsServlet")
public class UserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("task");
		HttpSession session = request.getSession();
		String page = "";
		
		if (action.compareTo("home") == 0) {
			String customername = request.getParameter("customername");
			page = "Customer.jsp";
			session.setAttribute("customername", customername);
			request.getRequestDispatcher(page).forward(request, response);
		} else if (action.compareTo("search") == 0) {
			String searchBox = request.getParameter("searchBox");
			System.out.println(searchBox);
		} else if (action.compareTo("newpassword") == 0) {
			String customername = request.getParameter("customername");
			page = "NewPassword.jsp";
			session.setAttribute("message", "");
			session.setAttribute("customername", customername);
			request.getRequestDispatcher(page).forward(request, response);
		} else if (action.compareTo("edit") == 0) {
			String customername = request.getParameter("customername");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String dateOfBirth = request.getParameter("birth");
			String gender = request.getParameter("gender");
			page = "EditProfile.jsp";
			session.setAttribute("customername", customername);
			session.setAttribute("firstname", firstname);
			session.setAttribute("lastname", lastname);
			session.setAttribute("dateofbirth", dateOfBirth);
			session.setAttribute("gender", gender);
			request.getRequestDispatcher(page).forward(request, response);	
		} else if (action.compareTo("history") == 0) {
			String customername = request.getParameter("customername");
			UserDetailsModel userDetailsModel = new UserDetailsModel();
			UserDetails userDetail = userDetailsModel.getUser(customername);
			int userDetailsId = userDetail.getUserDetailsId();
			
			OrderHistoryModel orderHistoryModel = new OrderHistoryModel();
			ArrayList<OrderHistory> list = orderHistoryModel.getUserList(userDetailsId);
			page = "OrderHistory.jsp";
			session.setAttribute("list", list);
			session.setAttribute("customername", customername);
			request.getRequestDispatcher(page).forward(request, response);
			
		}
	}

}
