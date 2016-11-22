package br.usp.pcs.mvc.Cidade.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import br.usp.pcs.mvc.Cidade.data.City;
import br.usp.pcs.mvc.utils.CityMapper;;

public class CityDAO {

	private static final CityDAO instance = new CityDAO();

	private CityDAO() {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Connection createConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mariadb://143.107.102.14:3306/mdb003?user=t1g3&password=2RpJ?!");
	}

	public static CityDAO getInstance() {
		return instance;
	}
	
	public City getCityById(int id) {
		
		try {

			Connection connection = createConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM City WHERE ID = " + id);
			
			resultSet.next();
			City city = new City();
			city.setId(resultSet.getInt("ID"));
			city.setName(resultSet.getString("Name"));
			city.setDescription(resultSet.getString("Description"));
			city.setProvince(resultSet.getString("Province"));
			city.setCountry(resultSet.getString("Country"));
			city.setLatitude(resultSet.getDouble("Latitude"));
			city.setLongitude(resultSet.getDouble("Longitude"));
			return city;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new City();
		}

	}

	public List<City> getAllCities() {

		LinkedList<City> cidades = new LinkedList<>();

		try {

			Connection connection = createConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM City ORDER BY name ASC");

			while (resultSet.next()) {

				CityMapper cityMapper = new CityMapper();
				cidades.add(cityMapper.mapResultSetToCity(resultSet));
			}

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cidades;
	}

}

