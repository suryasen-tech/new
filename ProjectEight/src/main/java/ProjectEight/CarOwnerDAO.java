package ProjectEight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ProjectEight.CarOwner;
public class CarOwnerDAO {
	 public CarOwner login(String username, String password) {
	        CarOwner owner = null;
	        try (Connection conn = DatabaseConnection.getConnection()) {
	            String sql = "SELECT * FROM carowner WHERE username = ? AND password = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, username);
	            stmt.setString(2, password);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                owner = new CarOwner();
	                owner = new CarOwner();
	                owner.setOwnerId(rs.getInt("owner_id"));
	                owner.setUsername(rs.getString("username"));
	                owner.setPassword(rs.getString("password"));
	                owner.setName(rs.getString("name"));
	                owner.setEmail(rs.getString("email"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return owner;
	    }

	 public boolean registerCar(CarDetails carDetails) {
	        String sql = "INSERT INTO CarDetails (owner_id, car_model, car_number) VALUES (?, ?, ?)";

	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setInt(1, carDetails.getOwnerId());
	            stmt.setString(2, carDetails.getCarModel());
	            stmt.setString(3, carDetails.getCarNumber());

	            int rowsInserted = stmt.executeUpdate();
	            return rowsInserted > 0;

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

}
