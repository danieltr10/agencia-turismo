package br.usp.pcs.mvc.Route.data;

import java.util.ArrayList;

import br.usp.pcs.mvc.Cidade.data.City;
import br.usp.pcs.mvc.Package.Decorators.Hotel.data.Hotel;
import br.usp.pcs.mvc.Package.Decorators.Transport.data.Transport;

public class Route {
	
	private int id;
    private String name;
	private ArrayList<City> cities;
	private ArrayList<Transport> transports;
	private ArrayList<Hotel> hotels;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
