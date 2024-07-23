package ProjectEight;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class CoTravellerLogin
 */
public class CoTravellerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoTravellerLogin() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		  String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        // Initialize CarOwnerDAO and attempt to login
	        CotravellerDAO cotravellerDAO = new CotravellerDAO();
	        CoTraveller traveller = cotravellerDAO.login(username, password);

	        // Check if the login was successful
	        if (traveller != null) {
	            // Login successful, create a session and redirect to dashboard
	            HttpSession session = request.getSession();
	            session.setAttribute("CoTraveller", traveller);
	            response.sendRedirect("coTravellerDashboard.jsp");
	        } else {
	            // Login failed, redirect to login page with error message
	            request.setAttribute("loginError", "Invalid username or password");
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	        }
	    }
		
	

}
