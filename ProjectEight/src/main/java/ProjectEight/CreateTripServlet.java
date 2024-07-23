package ProjectEight;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CreateTripServlet
 */
public class CreateTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTripServlet() {
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
		//doGet(request, response);
		 int ownerId = Integer.parseInt(request.getParameter("ownerId"));
	        String origin = request.getParameter("origin");
	        String destination = request.getParameter("destination");
	        String date = request.getParameter("date");

	        TripDAO tripDAO = new TripDAO();
	        boolean isTripCreated = tripDAO.createTrip(ownerId, origin, destination, date);

	        if (isTripCreated) {
	            response.getWriter().write("<div>Trip successfully created! Wait for your co-traveller.</div>");
	        } else {
	            response.getWriter().write("<div>Failed to create trip. Try again.</div>");
	        }
	}

}
