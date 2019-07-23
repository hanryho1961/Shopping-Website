package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageServlet() {
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
	 	if (action.compareTo("home") == 0) {
	 		String page = "HomePage.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		} else if (action.compareTo("search") == 0) {
			String searchBox = request.getParameter("searchBox");
			System.out.println(searchBox);
		} else if (action.compareTo("cart") == 0) {
			String page = "LoginPage.jsp";
			session.setAttribute("message", "");
			request.getRequestDispatcher(page).forward(request, response);
		} else if (action.compareTo("login") == 0) {
			String page = "LoginPage.jsp";
			session.setAttribute("message", "");
			request.getRequestDispatcher(page).forward(request, response);
		} else if (action.compareTo("buyNow") == 0) {
			String page = "LoginPage.jsp";
			session.setAttribute("message", "");
			request.getRequestDispatcher(page).forward(request, response);
		} else if (action.compareTo("addCart") == 0) {
			String page = "LoginPage.jsp";
			session.setAttribute("message", "");
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
