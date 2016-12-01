package br.usp.pcs.mvc.Package.dao;

import br.usp.pcs.mvc.Package.Decorators.Attraction.data.Attraction;
import br.usp.pcs.mvc.Package.Decorators.Hotel.data.Hotel;
import br.usp.pcs.mvc.Package.Decorators.Transport.data.Transport;
import br.usp.pcs.mvc.Package.Interfaces.IPackage;
import br.usp.pcs.mvc.Package.data.Package;
import br.usp.pcs.mvc.utils.Factory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PackageDAO {
    private static final PackageDAO instance = new PackageDAO();
    private Factory<Package> packageFactory;
    private Factory<Hotel> hotelFactory;
    private Factory<Transport> transportFactory;
    private Factory<Attraction> attractionFactory;

    private PackageDAO() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            packageFactory = new Factory<>(Package.class);
            hotelFactory = new Factory<>(Hotel.class);
            transportFactory = new Factory<>(Transport.class);
            attractionFactory = new Factory<>(Attraction.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mariadb://143.107.102.14:3306/mdb003?user=t1g3&password=2RpJ?!");
    }

    public static PackageDAO getInstance() {
        return instance;
    }

    public List<IPackage> getAll() {
        try {
            Connection connection = createConnection();
            Statement statement = connection.createStatement();

            ResultSet packageResult = statement.executeQuery("SELECT * FROM Package");

            ArrayList<IPackage> packages = new ArrayList<>();

            while (packageResult.next()) {
                packages.add(packageFactory.mapNewResult(packageResult));
            }

            connection.close();

            return packages;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<IPackage> getAllPackages() {
        try {
            Connection connection = createConnection();
            Statement statement = connection.createStatement();

            ResultSet packageResult = statement.executeQuery("SELECT * FROM Package");

            ArrayList<IPackage> packages = new ArrayList<>();
            IPackage content;

            while (packageResult.next()) {
                content = packageFactory.mapNewResult(packageResult);

                ResultSet hotelsResult = statement.executeQuery("SELECT Hotel.* " +
                        "FROM PackageHotel, Hotel " +
                        "WHERE HOTELID = ID AND " +
                        "PACKAGEID =" + content.getPackageId());


                while (hotelsResult.next()) {
                    content = hotelFactory.mapResult(hotelsResult, new Hotel(content));
                }

                ResultSet transportResult = statement.executeQuery("SELECT Transport.* " +
                        "FROM PackageTransport, Transport " +
                        "WHERE TRANSPORTID = ID AND " +
                        "PACKAGEID =" + content.getPackageId());

                while (transportResult.next()) {
                    content = transportFactory.mapResult(transportResult, new Transport(content));
                }

                ResultSet attractionsResult = statement.executeQuery("SELECT Attraction.* " +
                        "FROM PackageAttraction, Attraction " +
                        "WHERE ATTRACTIONID = ID AND " +
                        "PACKAGEID =" + content.getPackageId());

                while (attractionsResult.next()) {
                    content = attractionFactory.mapResult(attractionsResult, new Attraction(content));
                }

                packages.add(content);
            }

            connection.close();

            return packages;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public IPackage getPackageById(int id) {
        try {
            Connection connection = createConnection();
            Statement statement = connection.createStatement();

            ResultSet packageResult = statement.executeQuery("SELECT * FROM Package WHERE ID = " + id);

            packageResult.next();

            IPackage content = packageFactory.mapNewResult(packageResult);

            ResultSet hotelsResult = statement.executeQuery("SELECT Hotel.* " +
                    "FROM PackageHotel, Hotel " +
                    "WHERE HOTELID = ID AND " +
                    "PACKAGEID =" + content.getPackageId());


            while (hotelsResult.next()) {
                content = hotelFactory.mapResult(hotelsResult, new Hotel(content));
            }

            ResultSet transportResult = statement.executeQuery("SELECT Transport.* " +
                    "FROM PackageTransport, Transport " +
                    "WHERE TRANSPORTID = ID AND " +
                    "PACKAGEID =" + content.getPackageId());

            while (transportResult.next()) {
                content = transportFactory.mapResult(transportResult, new Transport(content));
            }

            ResultSet attractionsResult = statement.executeQuery("SELECT Attraction.* " +
                    "FROM PackageAttraction, Attraction " +
                    "WHERE ATTRACTIONID = ID AND " +
                    "PACKAGEID =" + content.getPackageId());

            while (attractionsResult.next()) {
                content = attractionFactory.mapResult(attractionsResult, new Attraction(content));
            }

            return content;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
