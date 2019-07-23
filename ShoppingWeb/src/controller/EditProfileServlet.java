package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDetailsModel;
import model.UserModel;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
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
			String customername = request.getParameter("customername");
			page = "Customer.jsp";
			session.setAttribute("customername", customername);
			request.getRequestDispatcher(page).forward(request, response);
		} else if (action.compareTo("search") == 0) {
			String searchBox = request.getParameter("searchBox");
			System.out.println(searchBox);
		} else if (action.compareTo("details") == 0) {
			session.setAttribute("customername", request.getParameter("customername"));
			page = "UserDetails.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		} else if (action.compareTo("edit") == 0) {
			String customername = request.getParameter("customername");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String birthday = request.getParameter("birth");
			Date birth = new Date(birthday);
			String gender = request.getParameter("gender");
			String userid = String.valueOf(userModel.getUser(customername).getUserid());
			userDetailsModel.updateUserDetails(firstname, lastname, birth, gender, Integer.parseInt(userid));
			session.setAttribute("customername", request.getParameter("customername"));
			page = "UserDetails.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
