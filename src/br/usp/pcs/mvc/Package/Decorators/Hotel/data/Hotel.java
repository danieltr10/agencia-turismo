package br.usp.pcs.mvc.Package.Decorators.Hotel.data;

import br.usp.pcs.mvc.Package.Decorators.Attraction.data.Attraction;
import br.usp.pcs.mvc.Package.Decorators.Interfaces.IHotel;
import br.usp.pcs.mvc.Package.Interfaces.IPackage;
import br.usp.pcs.mvc.Transport.data.Transport;

import java.util.ArrayList;
import java.util.ListIterator;

public class Hotel implements IHotel {

    private int id;
    private String name;
    private double price;
    private int cityID;
    private IPackage content;

    public Hotel() {

    }

    public Hotel(IPackage content) {
        this.content = content;
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
