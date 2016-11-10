package br.usp.pcs.mvc.tests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.*;

import br.usp.pcs.mvc.Cidade.dao.CityDAO;
import br.usp.pcs.mvc.Cidade.data.City;
import org.junit.Assert;

@SuppressWarnings("deprecation")
public class CityDAOTest {
	
	static CityDAO cityDAO;
	
	@BeforeClass
	public static void setup() {
		cityDAO = CityDAO.getInstance();
	}
	
	@Test
	public void testGetCityById() {
		City cidadeTeste = cityDAO.getCityById(3);
		
		Assert.assertEquals("Rio de Janeiro", cidadeTeste.getName());
		Assert.assertEquals("Cidade Maravilhosa", cidadeTeste.getDescription());
		Assert.assertEquals("Brasil", cidadeTeste.getCountry());
		Assert.assertEquals("Rio de Janeiro", cidadeTeste.getProvince());
		Assert.assertEquals(22.9068, cidadeTeste.getLatitude(), 0);
		Assert.assertEquals(43.1729, cidadeTeste.getLongitude(), 0);

		
	}
	@Test 
	public void testGetAllCities() {
		List<City> cidades = cityDAO.getAllCities();
		Assert.assertEquals(4, cidades.size());
	
	}
	
	@Test
	public void testInstantiate() {
		Assert.assertEquals(cityDAO.hashCode(), CityDAO.getInstance().hashCode());
	}

}
