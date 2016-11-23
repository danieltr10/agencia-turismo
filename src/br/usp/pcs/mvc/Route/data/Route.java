package br.usp.pcs.mvc.Route.data;

import java.util.ArrayList;

import br.usp.pcs.mvc.Cidade.data.City;
import br.usp.pcs.mvc.Hotel.data.Hotel;
import br.usp.pcs.mvc.Transport.data.Transport;

public class Route {
	
	private int id;
	private ArrayList<City> cities; 
	private ArrayList<Transport> transports;
	private ArrayList<Hotel> hotels;
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public ArrayList<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(ArrayList<Hotel> hotels) {
		this.hotels = hotels;
	}
}
