package br.usp.pcs.mvc.Package.Decorators.Attraction.data;

import br.usp.pcs.mvc.Package.Decorators.Hotel.data.Hotel;
import br.usp.pcs.mvc.Package.Decorators.Interfaces.IAttraction;
import br.usp.pcs.mvc.Package.Interfaces.IPackage;
import br.usp.pcs.mvc.Package.Decorators.Transport.data.Transport;

import java.util.ArrayList;
import java.util.ListIterator;

public class Attraction implements IAttraction {

    private String Id;
    private String name;
    private Double price;
    private String description;
    private IPackage content;

    public Attraction() {
    }

    public Attraction(IPackage content) {
        this.content = content;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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
            return attractions;
        }
    }

    @Override
    public Double getTotalPrice() {
        return content.getTotalPrice() + price;
    }

}
