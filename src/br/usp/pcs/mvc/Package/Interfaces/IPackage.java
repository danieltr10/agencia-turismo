package br.usp.pcs.mvc.Package.Interfaces;

import br.usp.pcs.mvc.Package.Decorators.Hotel.data.Hotel;
import br.usp.pcs.mvc.Package.Decorators.Attraction.data.Attraction;
import br.usp.pcs.mvc.Package.Decorators.Transport.data.Transport;

import java.util.ListIterator;

public interface IPackage {

    int getPackageId();
    String getPackageName();
    String getPackageDescription();
    ListIterator<Hotel> getHotels();
    ListIterator<Transport> getTransports();
    ListIterator<Attraction> getAttractions();
    Double getTotalPrice();
    int getNumeroVendas();
}

