package br.usp.pcs.mvc.Package.Interfaces;

import br.usp.pcs.mvc.Hotel.data.Hotel;
import br.usp.pcs.mvc.Package.Decorators.data.Attraction;
import br.usp.pcs.mvc.Transport.data.Transport;

import java.util.ListIterator;

public interface IPackage {

    String getDescription();
    ListIterator<Hotel> getHotels();
    ListIterator<Transport> getTransports();
    ListIterator<Attraction> getAttractions();
    Double getPrice();
}
