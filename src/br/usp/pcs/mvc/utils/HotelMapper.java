package br.usp.pcs.mvc.utils;

/**
 * Created by Mauricio on 11/24/16.
 */
import br.usp.pcs.mvc.Package.Decorators.Hotel.data.Hotel;

import java.sql.ResultSet;

public class HotelMapper {
    public Hotel mapResultSetToHotel (ResultSet resultSet){
        Hotel hotel = new Hotel();
        try{
            hotel.setId(resultSet.getInt("ID"));
            hotel.setName(resultSet.getString("Name"));
            hotel.setPrice(resultSet.getDouble("Price"));
            hotel.setCityID(resultSet.getInt("CityID"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return hotel;
    }
}
