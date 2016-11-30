package br.usp.pcs.mvc.Package.Decorators.Transport.data;

import br.usp.pcs.mvc.Package.Decorators.Attraction.data.Attraction;
import br.usp.pcs.mvc.Package.Decorators.Hotel.data.Hotel;
import br.usp.pcs.mvc.Package.Decorators.Interfaces.ITransport;
import br.usp.pcs.mvc.Package.Interfaces.IPackage;

import java.util.ArrayList;
import java.util.ListIterator;

public class Transport implements ITransport {

	private int id;
	private String type;
	private double price;
	private int originCityID;
	private int destinationCityID;
	private String company;
	private IPackage content;
	
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

	@Override
	public ListIterator<Hotel> getHotels() {
		return content.getHotels();
	}

	@Override
	public ListIterator<Transport> getTransports() {
        ListIterator<Transport> transports = content.getTransports();

        if (transports == null) {
            ArrayList<Transport> transportList = new ArrayList<>();
            transportList.add(this);
            return transportList.listIterator();
        } else {
            transports.add(this);
            return transports;
        }
	}

	@Override
	public ListIterator<Attraction> getAttractions() {
		return content.getAttractions();
	}

	@Override
	public Double getTotalPrice() {
		return content.getTotalPrice() + price;
	}
}
