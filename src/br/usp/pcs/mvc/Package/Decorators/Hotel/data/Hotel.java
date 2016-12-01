package br.usp.pcs.mvc.Package.Decorators.Hotel.data;

import br.usp.pcs.mvc.Package.Decorators.Attraction.data.Attraction;
import br.usp.pcs.mvc.Package.Decorators.Interfaces.Content;
import br.usp.pcs.mvc.Package.Decorators.Transport.data.Transport;
import br.usp.pcs.mvc.Package.Interfaces.IPackage;

import java.util.ArrayList;
import java.util.ListIterator;

public class Hotel extends Content {

    private int id;
    private String name;
    private Double price;
    private int cityID;

    public Hotel() {
    }

    public Hotel(IPackage content) {
        super(content);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    @Override
    public ListIterator<Hotel> getHotels() {
        ListIterator<Hotel> hotels = content.getHotels();

        if (hotels == null) {
            ArrayList<Hotel> hotelList = new ArrayList<>();
            hotelList.add(this);
            return hotelList.listIterator();
        } else {
            hotels.add(this);
            hotels.previous();
            return hotels;
        }
    }

    @Override
    public ListIterator<Transport> getTransports() {
        return content.getTransports();
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
