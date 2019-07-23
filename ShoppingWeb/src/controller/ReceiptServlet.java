package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReceiptServlet
 */
@WebServlet("/ReceiptServlet")
public class ReceiptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptServlet() {
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
		} else if (action.compareTo("details") == 0) {
			session.setAttribute("customername", request.getParameter("customername"));
			page = "UserDetails.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
