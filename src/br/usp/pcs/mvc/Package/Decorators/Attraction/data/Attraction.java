package br.usp.pcs.mvc.Package.Decorators.Attraction.data;

import br.usp.pcs.mvc.Package.Decorators.Hotel.data.Hotel;
import br.usp.pcs.mvc.Package.Decorators.Interfaces.Content;
import br.usp.pcs.mvc.Package.Decorators.Transport.data.Transport;
import br.usp.pcs.mvc.Package.Interfaces.IPackage;

import java.util.ArrayList;
import java.util.ListIterator;

public class Attraction extends Content {

    private int id;
    private String name;
    private Double price;
    private String description;

    public Attraction() {
    }

    public Attraction(IPackage content) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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
            attractions.previous();
            return attractions;
        }
    }

    @Override
    public Double getTotalPrice() {
        return content.getTotalPrice() + price;
    }

}
