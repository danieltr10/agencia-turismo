package br.usp.pcs.mvc.utils;

import br.usp.pcs.mvc.Cidade.data.City;

import java.sql.ResultSet;

/**
 * Created by Daniel on 22/11/16.
 */
public class CityMapper {

    public City mapResultSetToCity (ResultSet resultSet) {

        City cidade = new City();
        try {
            cidade.setId(resultSet.getInt("ID"));
            cidade.setName(resultSet.getString("Name"));
            cidade.setDescription(resultSet.getString("Description"));
            cidade.setProvince(resultSet.getString("Province"));
            cidade.setCountry(resultSet.getString("Country"));
            cidade.setLatitude(resultSet.getDouble("Latitude"));
            cidade.setLongitude(resultSet.getDouble("Longitude"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cidade;
    }
}
