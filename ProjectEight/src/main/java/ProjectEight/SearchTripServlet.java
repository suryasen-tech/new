package ProjectEight;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import ProjectEight.TripDAO;
/**
 * Servlet implementation class SearchTripServlet
 */
public class SearchTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTripServlet() {
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
		
		 String origin = request.getParameter("origin");
	        String destination = request.getParameter("destination");
	        String date = request.getParameter("date");

	        TripDAO tripDAO = new TripDAO();
	        List<Trip> trips = tripDAO.searchTrips(origin, destination, date);

	        if (trips.size() > 0) {
	            for (Trip trip : trips) {
	                response.getWriter().write("<div>Trip found: " + trip.getOrigin() + " to " + trip.getDestination() +
	                        " on " + trip.getDate() + " by Owner ID: " + trip.getOwnerId() + "</div>");
	            }
	        } else {
	            response.getWriter().write("<div>No trips found matching your criteria.</div>");
	        }
	}

}
