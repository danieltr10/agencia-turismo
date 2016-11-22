package br.usp.pcs.mvc.Cidade.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import br.usp.pcs.mvc.Cidade.data.City;
import br.usp.pcs.mvc.utils.CityMapper;


public class CityDAO{

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
	public List<City> getCitiesBetween(City cidadeOrigem, City cidadeDestino){
		LinkedList<City> cidades = new LinkedList<>();
		if (cidadeOrigem.getLatitude() > cidadeDestino.getLatitude()){
			if(cidadeOrigem.getLongitude() > cidadeDestino.getLongitude()){
				try {
					Connection connection = createConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM City C WHERE (C.Latitude BETWEEN "+cidadeDestino+ " AND " +cidadeOrigem+") AND (C.Longitude BETWEEN" +cidadeDestino+ " AND " +cidadeOrigem+ ")");
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
			}
			else{
				try {
					Connection connection = createConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM City C WHERE (C.Latitude BETWEEN "+cidadeDestino+ " AND " +cidadeOrigem+") AND (C.Longitude BETWEEN" +cidadeOrigem+ " AND " +cidadeDestino+ ")");
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
			}
		}
		else{
			if(cidadeOrigem.getLongitude() > cidadeDestino.getLongitude()){
				try {
					Connection connection = createConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM City C WHERE (C.Latitude BETWEEN "+cidadeOrigem+ " AND " +cidadeDestino+") AND (C.Longitude BETWEEN" +cidadeDestino+ " AND " +cidadeOrigem+ ")");
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
			}
			else{
				try {
					Connection connection = createConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM City C WHERE (C.Latitude BETWEEN "+cidadeOrigem+ " AND " +cidadeDestino+") AND (C.Longitude BETWEEN" +cidadeOrigem+ " AND " +cidadeDestino+ ")");
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
			}
		}
		
		return ordenarCidades(cidades, cidadeOrigem);
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

