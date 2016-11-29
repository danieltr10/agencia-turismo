package br.usp.pcs.mvc.Package.data;

import br.usp.pcs.mvc.Package.Decorators.Hotel.data.Hotel;
import br.usp.pcs.mvc.Package.Decorators.Attraction.data.Attraction;
import br.usp.pcs.mvc.Package.Interfaces.IPackage;
import br.usp.pcs.mvc.Transport.data.Transport;

import java.util.ListIterator;

public class Package implements IPackage {
    private int id;
    private String name;
    private String description;

    public Package(String descritption) {
        this.description = descritption;
    }


    @Override
    public ListIterator<Hotel> getHotels() {
        return null;
    }

    @Override
    public ListIterator<Transport> getTransports() {
        return null;
    }

    @Override
    public ListIterator<Attraction> getAttractions() {
        return null;
    }

    @Override
    public Double getTotalPrice() {
        return 0.0;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
