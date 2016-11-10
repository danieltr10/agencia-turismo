package br.usp.pcs.mvc.Route.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import br.usp.pcs.mvc.Cidade.dao.CityDAO;
import br.usp.pcs.mvc.Cidade.data.City;
import br.usp.pcs.mvc.Route.data.Route;

public class RouteDAO {
	private static final RouteDAO instance = new RouteDAO();

	private RouteDAO() {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Connection createConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mariadb://143.107.102.14:3306/mdb003?user=t1g3&password=2RpJ?!");
	}

	public static RouteDAO getInstance() {
		return instance;
	}
	
	public Route getRouteById(int routeId) {
		
		try {

			Connection connection = createConnection();
			Statement statement = connection.createStatement();

			ResultSet routeResult = statement.executeQuery("SELECT * FROM Route WHERE ID = " + routeId);
			
			routeResult.next();
			Route route = new Route();
			route.setId(routeResult.getInt("ID"));
			route.setPrice(routeResult.getDouble("Price"));
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM City INNER JOIN RouteCity WHERE RouteCity.RouteID = " + routeId + " & City.ID = RouteCity.CityID");
			
			resultSet.next();
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
				City cidade = new City();
				cidade.setId(resultSet.getInt("ID"));
				cidade.setName(resultSet.getString("Name"));
				cidade.setDescription(resultSet.getString("Description"));
				cidade.setProvince(resultSet.getString("Province"));
				cidade.setCountry(resultSet.getString("Country"));
				cidade.setLatitude(resultSet.getDouble("Latitude"));
				cidade.setLongitude(resultSet.getDouble("Longitude"));

				cidades.add(cidade);
			}

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cidades;
	}


}
