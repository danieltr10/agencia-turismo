package br.usp.pcs.mvc.Client.dao;

import br.usp.pcs.mvc.Client.data.Client;
import br.usp.pcs.mvc.utils.Factory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    private static final ClientDAO instance = new ClientDAO();
    private Factory<Client> _clientFactory;

    private ClientDAO() {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            _clientFactory = new Factory<>(Client.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mariadb://143.107.102.14:3306/mdb003?user=t1g3&password=2RpJ?!");
    }

    public static ClientDAO getInstance() {
        return instance;
    }

    public boolean insertClient(String name,int cpf,int telefone, int id) {
        try {
            Connection connection = createConnection();
            Statement statement = connection.createStatement();

            statement.executeQuery("INSERT INTO `mdb003`.`Pessoa` (`Name`, `Cpf`, `Telefone`, `Type`) VALUES ('"+ name +"' , '"+ cpf +"', ' "+ telefone +"', '"+ id+"')");

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Client> getAllClients() {
        try {

            Connection connection = createConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Pessoa WHERE Pessoa.TYPE = 1");

            ArrayList<Client> clients = new ArrayList<>();

            while (resultSet.next()) {
                clients.add(_clientFactory.mapNewResult(resultSet));
            }

            return clients;

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

}
