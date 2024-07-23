package ProjectEight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CotravellerDAO {
	public CoTraveller login (String username, String password) {
		CoTraveller traveller = null;
		 try (Connection conn = DatabaseConnection.getConnection()) {
	            String sql = "SELECT * FROM CoTraveller WHERE username = ? AND password = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, username);
	            stmt.setString(2, password);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	            	traveller = new CoTraveller();
	            	traveller = new CoTraveller();
	            	traveller.setCotravellerId(rs.getInt("cotraveller_id"));
	            	traveller.setUsername(rs.getString("username"));
	            	traveller.setPassword(rs.getString("password"));
	            	traveller.setName(rs.getString("name"));
	            	traveller.setEmail(rs.getString("email"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return traveller;
		
	}

}
