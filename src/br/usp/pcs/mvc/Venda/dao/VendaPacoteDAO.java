package br.usp.pcs.mvc.Venda.dao;

import br.usp.pcs.mvc.Venda.data.VendaPacote;
import br.usp.pcs.mvc.utils.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class VendaPacoteDAO {
    private static final VendaPacoteDAO instance = new VendaPacoteDAO();
    private Factory<VendaPacote> _vendaPacoteFactory;

    private VendaPacoteDAO() {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            _vendaPacoteFactory = new Factory<>(VendaPacote.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mariadb://143.107.102.14:3306/mdb003?user=t1g3&password=2RpJ?!");
    }

    public static VendaPacoteDAO getInstance() {
        return instance;
    }

    public boolean insertVendaPacote(int CPF, int packageID) {
        try {

            Connection connection = createConnection();
            Statement statement = connection.createStatement();

            statement.executeQuery("INSERT INTO VendaPacote " +
                    "(CLIENTCPF, PACKAGEID) " +
                    "VALUES ("+ CPF +", "+ packageID +")");

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
