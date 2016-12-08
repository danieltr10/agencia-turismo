package br.usp.pcs.mvc.Cidade.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import br.usp.pcs.mvc.Cidade.data.City;
import br.usp.pcs.mvc.utils.CityMapper;
import br.usp.pcs.mvc.utils.Factory;


public class CityDAO{

	private static final CityDAO instance = new CityDAO();
    private Factory<City> _cityFactory;

	private CityDAO() {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
            _cityFactory = new Factory<City>(City.class);
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


	public boolean insertCity(String name, String description, String province, String country, double latitude, double longitude, String url) {
		try {
			Connection connection = createConnection();
			Statement statement = connection.createStatement();

			statement.executeQuery("INSERT INTO `mdb003`.`City` (`Name`, `Description`, `Province`, `Country`, `Latitude`, `Longitude`, `ImageUrl`) VALUES ('"+ name +"' , '"+ description +"', ' "+ province +"', '"+ country+"', '"+ latitude +"', '"+ longitude +"', '"+ url +"')");

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public City getCityById(int id) {
		
		try {

			Connection connection = createConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM City WHERE ID = " + id);
			resultSet.next();

			CityMapper cityMapper = new CityMapper();
			return cityMapper.mapResultSetToCity(resultSet);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new City();
		}

	}
	public List<City> getCitiesBetween(City cidadeOrigem, City cidadeDestino){
		LinkedList<City> cidades = new LinkedList<>();
		if (cidadeOrigem.getLatitude() > cidadeDestino.getLatitude()){
			if(cidadeOrigem.getLongitude() > cidadeDestino.getLongitude()){
				try {
					Connection connection = createConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM City C WHERE (C.Latitude BETWEEN " + cidadeDestino.getLatitude() + " AND " + cidadeOrigem.getLatitude() + ") AND (C.Longitude BETWEEN" + cidadeDestino.getLongitude() + " AND " + cidadeOrigem.getLongitude() + ")");
                    while (resultSet.next()) {
                        if (resultSet.getInt("ID") != cidadeOrigem.getId() && resultSet.getInt("ID") != cidadeDestino.getId()) {
                            CityMapper cityMapper = new CityMapper();
                            cidades.add(cityMapper.mapResultSetToCity(resultSet));
                        }
                    }
                    connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				try {
					Connection connection = createConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM City C WHERE (C.Latitude BETWEEN " + cidadeDestino.getLatitude() + " AND " + cidadeOrigem.getLatitude() + ") AND (C.Longitude BETWEEN" + cidadeOrigem.getLongitude() + " AND " + cidadeDestino.getLongitude() + ")");
                    while (resultSet.next()) {
                        if (resultSet.getInt("ID") != cidadeOrigem.getId() && resultSet.getInt("ID") != cidadeDestino.getId()) {
                            CityMapper cityMapper = new CityMapper();
                            cidades.add(cityMapper.mapResultSetToCity(resultSet));
                        }
                    }
                    connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			if(cidadeOrigem.getLongitude() > cidadeDestino.getLongitude()){
				try {
					Connection connection = createConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM City C WHERE (C.Latitude BETWEEN " + cidadeOrigem.getLatitude() + " AND " + cidadeDestino.getLatitude() + ") AND (C.Longitude BETWEEN" + cidadeDestino.getLongitude() + " AND " + cidadeOrigem.getLongitude() + ")");
                    while (resultSet.next()) {
                        if (resultSet.getInt("ID") != cidadeOrigem.getId() && resultSet.getInt("ID") != cidadeDestino.getId()) {
                            CityMapper cityMapper = new CityMapper();
                            cidades.add(cityMapper.mapResultSetToCity(resultSet));
                        }
                    }
                    connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				try {
					Connection connection = createConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM City C WHERE (C.Latitude BETWEEN " + cidadeOrigem.getLatitude() + " AND " + cidadeDestino.getLatitude() + ") AND (C.Longitude BETWEEN" + cidadeOrigem.getLongitude() + " AND " + cidadeDestino.getLongitude() + ")");
                    while (resultSet.next()) {
                        if (resultSet.getInt("ID") != cidadeOrigem.getId() && resultSet.getInt("ID") != cidadeDestino.getId()) {
                            CityMapper cityMapper = new CityMapper();
                            cidades.add(cityMapper.mapResultSetToCity(resultSet));
                        }
                    }
                    connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		setDistacia(cidades, cidadeOrigem);
		return ordenarCidades(cidades, cidadeOrigem);
	}

	private void setDistacia (List<City> cidades, City cidadeOrigem){
		for (City cidade : cidades){
			cidade.setDistanciaOrigem(Math.pow(Math.pow(cidadeOrigem.getLatitude() - cidade.getLatitude(),2) + Math.pow(cidadeOrigem.getLongitude() - cidade.getLongitude(),2),0.5));
		}
	}

	private List<City> ordenarCidades(List<City> cidades, City cidadeOrigem){

		Collections.sort(cidades, Comparator.comparing(City::getDistanciaOrigem));
		
		return cidades;
		
	}

	public List<City> getAllCities() {

		LinkedList<City> cidades = new LinkedList<>();

		try {

			Connection connection = createConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM City ORDER BY name ASC");

			while (resultSet.next()) {

				cidades.add(_cityFactory.mapNewResult(resultSet));

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

		return cidades;
	}

	
	 

}

