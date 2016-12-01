package br.usp.pcs.mvc.Package.data;

import br.usp.pcs.mvc.Package.Decorators.Hotel.data.Hotel;
import br.usp.pcs.mvc.Package.Decorators.Attraction.data.Attraction;
import br.usp.pcs.mvc.Package.Interfaces.IPackage;
import br.usp.pcs.mvc.Package.Decorators.Transport.data.Transport;

import java.util.ListIterator;

public class Package implements IPackage {
    private int id;
    private String name;
    private String description;

    @Override
    public int getPackageId() {
        return id;
    }

    @Override
    public String getPackageName() {
        return name;
    }

    @Override
    public String getPackageDescription() {
        return description;
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

}
