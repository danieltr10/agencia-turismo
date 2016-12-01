package br.usp.pcs.mvc.Package.Decorators.Transport.data;

import br.usp.pcs.mvc.Package.Decorators.Attraction.data.Attraction;
import br.usp.pcs.mvc.Package.Decorators.Hotel.data.Hotel;
import br.usp.pcs.mvc.Package.Decorators.Interfaces.Content;
import br.usp.pcs.mvc.Package.Interfaces.IPackage;

import java.util.ArrayList;
import java.util.ListIterator;

public class Transport extends Content {

	private int id;
	private String type;
	private Double price;
	private int originID;
	private int destinationID;
	private String company;

	public Transport() {
	}

	public Transport(IPackage content) {
		super(content);
	}

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
	
	public int getDestinationID() {
		return destinationID;
	}
	
	public void setDestinationID(int destinationID) {
		this.destinationID = destinationID;
	}
	public int getOriginID() {
		return originID;
	}
	
	public void setOriginID(int originID) {
		this.originID = originID;
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
            transports.previous();
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
