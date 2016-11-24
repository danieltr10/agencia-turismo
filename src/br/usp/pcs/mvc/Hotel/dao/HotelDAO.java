package br.usp.pcs.mvc.Hotel.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import br.usp.pcs.mvc.Hotel.data.Hotel;
public class HotelDAO {
	private static final HotelDAO instance = new HotelDAO();

	private HotelDAO() {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Connection createConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mariadb://143.107.102.14:3306/mdb003?user=t1g3&password=2RpJ?!");
	}

	public static HotelDAO getInstance() {
		return instance;
	}
	
	public ArrayList<Hotel> getHoteisByCityId(int CityID) {

		try {

			Connection connection = createConnection();
			Statement statement = connection.createStatement();
			Hotel hotel = new Hotel();
			ArrayList<Hotel> hoteis= new ArrayList<>();

			ResultSet resultSet = statement.executeQuery("SELECT H.* FROM Hotel H WHERE H.CityID = " + CityID);
			while (resultSet.next()) {

				hotel.setId(resultSet.getInt("ID"));
				hotel.setName(resultSet.getString("Name"));
				hotel.setPrice(resultSet.getDouble("Price"));
				hotel.setCityID(resultSet.getInt("CityID"));
				hoteis.add(hotel);
			}
			return hoteis;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            return null;
		}

	}
}
