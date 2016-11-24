package br.usp.pcs.mvc.Route.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.usp.pcs.mvc.Cidade.data.City;
import br.usp.pcs.mvc.Hotel.data.Hotel;
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

			// Getting Route Hotels
			ResultSet routeHotelsResult = statement.executeQuery("SELECT H.* FROM Hotel H INNER JOIN RouteHotel RH WHERE RH.RouteID = " + routeId + " AND H.ID = RH.HotelID");

			ArrayList<Hotel> routeHotelsArray = new ArrayList<>();

			while (routeHotelsResult.next()) {
				Hotel hotel = new Hotel();
				hotel.setId(routeHotelsResult.getInt("ID"));
				hotel.setCityID(routeHotelsResult.getInt("CityID"));
				hotel.setName(routeHotelsResult.getString("Name"));
				hotel.setPrice(routeHotelsResult.getDouble("Price"));
				routeHotelsArray.add(hotel);
			}

			route.setHotels(routeHotelsArray);


			return route;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Route();
		}

	}

	public ArrayList<Route> getAllRoutes() {
        try {

            Connection connection = createConnection();
            Statement statement = connection.createStatement();

            ResultSet routeResults = statement.executeQuery("SELECT * FROM Route");

            ArrayList<Route> routes = new ArrayList<>();


            while (routeResults.next()) {
                Route route = new Route();
                route.setId(routeResults.getInt("ID"));
                route.setName(routeResults.getString("Name"));

                routes.add(route);
            }

            return routes;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
