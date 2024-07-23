package ProjectEight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TripDAO {
    public boolean createTrip(int ownerId, String origin, String destination, String date) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO tripdetails (owner_id, origin, destination, date) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ownerId);
            stmt.setString(2, origin);
            stmt.setString(3, destination);
            stmt.setString(4, date);
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Trip> searchTrips(String origin, String destination, String date) {
        String sql = "SELECT * FROM tripdetails WHERE origin = ? AND destination = ? AND date = ?";
        List<Trip> trips = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, origin);
            stmt.setString(2, destination);
            stmt.setString(3, date);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Trip trip = new Trip();
                trip.setTripId(rs.getInt("trip_id"));
                trip.setOwnerId(rs.getInt("owner_id"));
                trip.setOrigin(rs.getString("origin"));
                trip.setDestination(rs.getString("destination"));
                trip.setDate(rs.getString("date"));
                trips.add(trip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trips;
    }

}
