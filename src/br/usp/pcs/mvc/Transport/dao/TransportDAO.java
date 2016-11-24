package br.usp.pcs.mvc.Transport.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.usp.pcs.mvc.Transport.data.Transport;
import br.usp.pcs.mvc.utils.TransportMapper;

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
	
	public ArrayList<Transport> getTransports(int originID, int destinationID) {
		
		try {

			Connection connection = createConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM Transport WHERE OriginID = " + originID + " AND DestinationID = " + destinationID );

            ArrayList<Transport> transports = new ArrayList<>();

            while (resultSet.next()) {
                TransportMapper transportMapper = new TransportMapper();
                transports.add(transportMapper.mapResultSetToTransport(resultSet));
            }
			return transports;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<>();
		}

	}

}
