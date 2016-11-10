package br.usp.pcs.mvc.Transport.data;

import br.usp.pcs.mvc.Cidade.data.City;

public class Transport {

	private int id;
	private String type;
	private double price;
	private City originCity;
	private City destinationCity;
	private String company;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public City getOriginCity() {
		return originCity;
	}
	public void setOriginCity(City originCity) {
		this.originCity = originCity;
	}
	
	public City getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(City destinationCity) {
		this.destinationCity = destinationCity;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
}
