package br.usp.pcs.mvc.Package.Decorators.Transport.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.usp.pcs.mvc.Cidade.data.City;
import br.usp.pcs.mvc.Package.Decorators.Transport.data.Transport;
import br.usp.pcs.mvc.utils.Factory;
import br.usp.pcs.mvc.utils.TransportMapper;

public class TransportDAO {
	private static final TransportDAO instance = new TransportDAO();
	private Factory<Transport> _transportFactory;
	private TransportDAO() {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			_transportFactory = new Factory<Transport>(Transport.class);
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

    public Transport getTransportById(int id) {

        try {

            Connection connection = createConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Transport WHERE ID = " + id);
            resultSet.next();

            TransportMapper transportMapper = new TransportMapper();
            return transportMapper.mapResultSetToTransport(resultSet);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new Transport();
        }

    }

	public boolean insertTransport(String tipo, String company, double price, int originid, int destinationid) {
		try {
			Connection connection = createConnection();
			Statement statement = connection.createStatement();

			statement.executeQuery("INSERT INTO `mdb003`.`Transport` (`Type`, `Price`, `OriginId`, `DestinationId`, `Company`) VALUES ('"+ tipo +"' , '"+ price +"', ' "+ originid +"', '"+ destinationid+"', '"+ company +"')");

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
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
	public List<Transport> getAllTransports() {

		LinkedList<Transport> transportes = new LinkedList<>();

		try {

			Connection connection = createConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM Transport ORDER BY name ASC");

			while (resultSet.next()) {

				transportes.add(_transportFactory.mapNewResult(resultSet));

			}

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}

		return transportes;
	}

}
