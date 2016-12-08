package br.usp.pcs.mvc.Package.Decorators.Hotel.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.usp.pcs.mvc.Package.Decorators.Hotel.data.Hotel;
import br.usp.pcs.mvc.utils.HotelMapper;

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

	public boolean insertHotel(String name, double price, int cityID) {
        try {
            Connection connection = createConnection();
            Statement statement = connection.createStatement();

            statement.executeQuery("INSERT INTO `mdb003`.`Hotel` (`Name`, `Price`, `CityID`) VALUES ('"+ name +"', '"+ price +"', '"+ cityID +"')");

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}

	public static HotelDAO getInstance() {
		return instance;
	}

	public Hotel getHotelById(int id) {

		try {

			Connection connection = createConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM Hotel WHERE ID = " + id);
			resultSet.next();

			HotelMapper hotelMapper = new HotelMapper();
			return hotelMapper.mapResultSetToHotel(resultSet);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Hotel();
		}

	}
	
	public ArrayList<Hotel> getHoteisByCityId(int CityID) {

		try {

			Connection connection = createConnection();
			Statement statement = connection.createStatement();

			ArrayList<Hotel> hoteis= new ArrayList<>();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM Hotel H WHERE H.CityID = " + CityID);
			while (resultSet.next()) {

				Hotel hotel = new Hotel();
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

	public void incrementHotelSales(int id) {

		try {

			Connection connection = createConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("UPDATE Hotel SET NUMEROVENDAS = NUMEROVENDAS + 1 WHERE ID = " + id);
			resultSet.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
