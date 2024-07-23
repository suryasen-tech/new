package ProjectEight;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class CarOwnerLogin
 */
public class CarOwnerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarOwnerLogin() {
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
		
		// protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        // Retrieve username and password from the request
		        String username = request.getParameter("username");
		        String password = request.getParameter("password");

		        // Initialize CarOwnerDAO and attempt to login
		        CarOwnerDAO carOwnerDAO = new CarOwnerDAO();
		        CarOwner owner = carOwnerDAO.login(username, password);

		        // Check if the login was successful
		        if (owner != null) {
		            // Login successful, create a session and redirect to dashboard
		            HttpSession session = request.getSession();
		            session.setAttribute("carOwner", owner);
		            response.sendRedirect("carOwnerDashboard.jsp");
		        } else {
		            // Login failed, redirect to login page with error message
		            request.setAttribute("loginError", "Invalid username or password");
		            request.getRequestDispatcher("login.jsp").forward(request, response);
		        }
		    }
	

}
