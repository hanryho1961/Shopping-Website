package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDetailsModel;
import model.UserModel;

/**
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserServlet() {
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
		UserModel userModel = new UserModel();
		UserDetailsModel userDetailsModel = new UserDetailsModel();
		String action = request.getParameter("task");
		HttpSession session = request.getSession();
		String page = "";
		if (action.compareTo("home") == 0) {
	 		page = "HomePage.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		} else if (action.compareTo("search") == 0) {
			String searchBox = request.getParameter("searchBox");
			System.out.println(searchBox);
		} else if (action.compareTo("cart") == 0) {
			page = "LoginPage.jsp";
			session.setAttribute("message", "");
			request.getRequestDispatcher(page).forward(request, response);
		} else if (action.compareTo("login") == 0) {
			page = "LoginPage.jsp";
			session.setAttribute("message", "");
			request.getRequestDispatcher(page).forward(request, response);
		} else if (action.compareTo("register") == 0) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String dateOfBirth = request.getParameter("dateofbirth");
			String gender = request.getParameter("gender");
			if (username.isEmpty() || password.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || 
					dateOfBirth.isEmpty() || gender.isEmpty()) {
				page = "NewUser.jsp";
				request.getRequestDispatcher(page).forward(request, response);
			}
			java.util.Date date = new java.util.Date(dateOfBirth);
			String message = userModel.addUser(username, password, 2);
			if (message.compareTo("Add User Thanh Cong") == 0) {
				int userid = userModel.getLatestUserId();
				message = userDetailsModel.addUserDetails(firstname, lastname, date, gender, userid);
				if (message.compareTo("Add UserDetails Succeed") == 0) {
					page = "Customer.jsp";
					session.setAttribute("customername", username);
					request.getRequestDispatcher(page).forward(request, response);
				}
			}
		}

	}
}
