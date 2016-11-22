package br.usp.pcs.mvc.Route.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.usp.pcs.mvc.Cidade.data.City;
import br.usp.pcs.mvc.Route.data.Route;
import br.usp.pcs.mvc.Transport.data.Transport;
import br.usp.pcs.mvc.utils.CityMapper;

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
			
			// Getting Route Cities
			ResultSet routeCitiesResult = statement.executeQuery("SELECT C.* FROM City C INNER JOIN RouteCity RC WHERE RC.RouteID = " + routeId + " AND C.ID = RC.CityID");
			
			ArrayList<City> routeCitiesArray = new ArrayList<>();
			
			while (routeCitiesResult.next()) {
				CityMapper cityMapper = new CityMapper();
				routeCitiesArray.add(cityMapper.mapResultSetToCity(routeCitiesResult));
			}
			
			route.setCities(routeCitiesArray);

			// Getting Route Transports
			ResultSet routeTransportsResult = statement.executeQuery("SELECT T.* FROM Transport T INNER JOIN RouteTransport RT WHERE RT.RouteID = " + routeId + " AND T.ID = RT.TransportID");
			
			ArrayList<Transport> routeTransportsArray = new ArrayList<>();
			
			while (routeTransportsResult.next()) {
				Transport transport = new Transport();
				transport.setId(routeTransportsResult.getInt("ID"));
				transport.setOriginCityID(routeTransportsResult.getInt("OriginID"));
				transport.setDestinationCityID(routeTransportsResult.getInt("DestinationID"));
				transport.setCompany(routeTransportsResult.getString("Company"));
				transport.setPrice(routeTransportsResult.getDouble("Price"));
				transport.setType(routeTransportsResult.getString("Type"));
				routeTransportsArray.add(transport);
			}
			
			route.setTransports(routeTransportsArray);
			
			return route;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Route();
		}

	}

}
