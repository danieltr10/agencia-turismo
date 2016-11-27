package br.usp.pcs.mvc.Package.data;

import br.usp.pcs.mvc.Hotel.data.Hotel;
import br.usp.pcs.mvc.Package.Decorators.data.Attraction;
import br.usp.pcs.mvc.Package.Interfaces.IPackage;
import br.usp.pcs.mvc.Transport.data.Transport;
;
import java.util.ListIterator;

/**
 * Created by andreebr on 26/11/2016.
 */
public class Package implements IPackage {
    private String description;

    public Package(String descritption) {
        this.description = descritption;
    }


    @Override
    public String getDescription() {
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
    public Double getPrice() {
        return 0.0;
    }
}
