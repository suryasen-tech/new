package ProjectEight;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import ProjectEight.CarOwnerDAO;
/**
 * Servlet implementation class CarOwnerServlet
 */

public class CarOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarOwnerServlet() {
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
		 try {
	            String ownerIdStr = request.getParameter("ownerId");
	            String carModel = request.getParameter("car_model");
	            String carNumber = request.getParameter("car_number");

	            // Check for null or empty values
	            if (ownerIdStr == null || ownerIdStr.trim().isEmpty() || 
	                carModel == null || carModel.trim().isEmpty() || 
	                carNumber == null || carNumber.trim().isEmpty()) {
	                
	                response.getWriter().write("<div>Missing required parameters.</div>");
	                return;
	            }

	            int ownerId;
	            try {
	                ownerId = Integer.parseInt(ownerIdStr);
	            } catch (NumberFormatException e) {
	                response.getWriter().write("<div>Invalid ownerId format.</div>");
	                return;
	            }

	            // Create CarDetails object and set its fields
	            CarDetails carDetails = new CarDetails();
	            carDetails.setOwnerId(ownerId);
	            carDetails.setCarModel(carModel);
	            carDetails.setCarNumber(carNumber);

	            // Use CarOwnerDAO to register the car
	            CarOwnerDAO carOwnerDAO = new CarOwnerDAO();
	            boolean isRegistered = carOwnerDAO.registerCar(carDetails);

	            if (isRegistered) {
	                response.getWriter().write("<div>Car successfully registered!</div>");
	            } else {
	                response.getWriter().write("<div>Failed to register car. Try again.</div>");
	            }

	        } catch (Exception e) {
	            response.getWriter().write("<div>Internal server error: " + e.getMessage() + "</div>");
	            e.printStackTrace();
	        }
	    }

}
