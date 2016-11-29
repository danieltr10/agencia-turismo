package br.usp.pcs.mvc.Package.Decorators.Attraction.data;

import br.usp.pcs.mvc.Package.Decorators.Hotel.data.Hotel;
import br.usp.pcs.mvc.Package.Decorators.Interfaces.IAttraction;
import br.usp.pcs.mvc.Package.Interfaces.IPackage;
import br.usp.pcs.mvc.Transport.data.Transport;

import java.util.ArrayList;
import java.util.ListIterator;

public class Attraction implements IAttraction {
    private IPackage content;
    private Double price;
    private String description;

    public Attraction(IPackage content, Double price, String description) {
        this.content = content;
        this.price = price;
        this.description = description;
    }

    @Override
    public ListIterator<Hotel> getHotels() {
        return content.getHotels();
    }

    @Override
    public ListIterator<Transport> getTransports() {
        return content.getTransports();
    }

    @Override
    public ListIterator<Attraction> getAttractions() {
        ListIterator<Attraction> attractions = content.getAttractions();

        if (attractions == null) {
            ArrayList<Attraction> attList = new ArrayList<>();
            attList.add(this);
            return attList.listIterator();
        } else {
            attractions.add(this);
            return attractions;
        }
    }

    @Override
    public Double getTotalPrice() {
        return content.getTotalPrice() + price;
    }
}
