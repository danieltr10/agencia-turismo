package br.usp.pcs.mvc.utils;

import br.usp.pcs.mvc.Package.Decorators.Transport.data.Transport;

import java.sql.ResultSet;
/**
 * Created by Mauricio on 11/24/16.
 */
public class TransportMapper {
    public Transport mapResultSetToTransport(ResultSet resultSet){
        Transport transport = new Transport();
        try {
            transport.setId(resultSet.getInt("ID"));
            transport.setType(resultSet.getString("Type"));
            transport.setCompany(resultSet.getString("Company"));
            transport.setDestinationID(resultSet.getInt("DestinationID"));
            transport.setOriginID(resultSet.getInt("OriginID"));
            transport.setPrice(resultSet.getDouble("Price"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return transport;
    }

}
