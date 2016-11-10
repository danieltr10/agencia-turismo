package br.usp.pcs.mvc.Transport.data;

import br.usp.pcs.mvc.Cidade.data.City;

public class Transport {

	private int id;
	private String type;
	private double price;
	private int originCityID;
	private int destinationCityID;
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
	
	public int getDestinationCityID() {
		return destinationCityID;
	}
	
	public void setDestinationCityID(int destinationCityID) {
		this.destinationCityID = destinationCityID;
	}
	public int getOriginCityID() {
		return originCityID;
	}
	
	public void setOriginCityID(int originCityID) {
		this.originCityID = originCityID;
	}
	
}
