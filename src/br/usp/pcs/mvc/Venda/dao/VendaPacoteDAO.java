package br.usp.pcs.mvc.Venda.dao;

import br.usp.pcs.mvc.Package.Interfaces.IPackage;
import br.usp.pcs.mvc.Package.dao.PackageDAO;
import br.usp.pcs.mvc.Package.data.Package;
import br.usp.pcs.mvc.Venda.data.VendaPacote;
import br.usp.pcs.mvc.utils.Factory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaPacoteDAO {
    private static final VendaPacoteDAO instance = new VendaPacoteDAO();
    private Factory<VendaPacote> _vendaPacoteFactory;
    private PackageDAO _packageDAO;

    private VendaPacoteDAO() {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            _vendaPacoteFactory = new Factory<>(VendaPacote.class);
            _packageDAO = PackageDAO.getInstance();
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

    public boolean insertVendaPacote(int CPF, int packageID, String paymentType, int numeroPessoas) {
        try {

            Connection connection = createConnection();
            Statement statement = connection.createStatement();

            statement.executeQuery("INSERT INTO VendaPacote " +
                    "(CLIENTCPF, PACKAGEID, PAYMENT, NUMEROPESSOAS) " +
                    "VALUES ("+ CPF +", "+ packageID +", '"+ paymentType +"' , "+ numeroPessoas+")");

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<VendaPacote> getAllVendasPacote() {
        try {
            Connection connection = createConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM VendaRoute");

            List<VendaPacote> vendasLst = new ArrayList<>();

            while (resultSet.next()) {
                IPackage pacote = _packageDAO.getPackageById(resultSet.getInt("PACKAGEID"));
                VendaPacote venda = new VendaPacote(pacote);

                vendasLst.add(_vendaPacoteFactory.mapResult(resultSet, venda));


            }
            connection.close();
            return vendasLst;
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
