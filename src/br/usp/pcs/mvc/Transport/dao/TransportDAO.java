package br.usp.pcs.mvc.Transport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import br.usp.pcs.mvc.Transport.data.Transport;

public class TransportDAO {
	private static final TransportDAO instance = new TransportDAO();

	private TransportDAO() {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Connection createConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mariadb://143.107.102.14:3306/mdb003?user=t1g3&password=2RpJ?!");
	}

	public static TransportDAO getInstance() {
		return instance;
	}
	
	public Transport getTransportd(int City1, int City2) {
		
		try {

			Connection connection = createConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM TRANSPORT WHERE OriginCityId = " + City1 + "AND DestinationCityId = " + City2 );
			Transport transport = new Transport();
			transport.setId(resultSet.getInt("ID"));
			transport.setType(resultSet.getString("Type"));
			transport.setCompany(resultSet.getString("Company"));
			transport.setDestinationCityID(resultSet.getInt("DestinationCityId"));
			transport.setOriginCityID(resultSet.getInt("OriginCityId"));
			transport.setPrice(resultSet.getDouble("Price"));
			resultSet.next();
			return transport;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Transport();
		}

	}

}
