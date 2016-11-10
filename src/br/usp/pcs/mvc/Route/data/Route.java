package br.usp.pcs.mvc.Route.data;

import java.util.ArrayList;

import br.usp.pcs.mvc.Cidade.data.City;
import br.usp.pcs.mvc.Transport.data.Transport;

public class Route {
	
	private ArrayList<City> cities; 
	private ArrayList<Transport> transports;
	private double price;
	
	public ArrayList<City> getCities() {
		return cities;
	}
	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}
	
	public ArrayList<Transport> getTransports() {
		return transports;
	}
	public void setTransports(ArrayList<Transport> transports) {
		this.transports = transports;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}