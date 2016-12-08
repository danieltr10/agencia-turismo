package br.usp.pcs.mvc.Cidade.servlet;

import br.usp.pcs.mvc.Cidade.dao.CityDAO;
import br.usp.pcs.mvc.Cidade.data.City;
import br.usp.pcs.mvc.Client.dao.ClientDAO;
import br.usp.pcs.mvc.Client.data.Client;
import br.usp.pcs.mvc.Package.Decorators.Hotel.dao.HotelDAO;
import br.usp.pcs.mvc.Package.Decorators.Hotel.data.Hotel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.usp.pcs.mvc.Package.Interfaces.IPackage;
import br.usp.pcs.mvc.Package.dao.PackageDAO;
import br.usp.pcs.mvc.Package.data.Package;
import br.usp.pcs.mvc.Route.dao.RouteDAO;
import br.usp.pcs.mvc.Route.data.Route;
import br.usp.pcs.mvc.Package.Decorators.Transport.dao.TransportDAO;
import br.usp.pcs.mvc.Package.Decorators.Transport.data.Transport;
import br.usp.pcs.mvc.Venda.dao.VendaPacoteDAO;

/**
 * Servlet implementation class CidadeController
 */
@WebServlet("/")
public class CityController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageRequested;

        pageRequested = request.getParameter("page");

        if (pageRequested == null) {

        } else if (pageRequested.equals("processarBotao")) {

            processaBotao(request, response);

        } else if (pageRequested.equals("listaCidades")) {

            listaCidades(request, response);

        } else if (pageRequested.equals("ProcessaCidades")) {

            processaCidades(request, response);

        } else if (pageRequested.equals("HoteisETransportes")) {

            hoteisETransportes(request, response);

        } else if (pageRequested.equals("FecharPedido")) {

            try {
                fecharPedido(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (pageRequested.equals("SelecionarCliente")) {

            selecionarCliente(request, response);

        } else if (pageRequested.equals("ResumoRoteiro")) {

            resumoRoteiro(request, response);

        }
        else if (pageRequested.equals("ConcluirVendaPacote")) {

            concluirVendaPacote(request, response);

        } else if (pageRequested.equals("CadastrarCidade")) {
            CityDAO cityDAO = CityDAO.getInstance();

            List<City> allCities = cityDAO.getAllCities();

            request.setAttribute("allCities", allCities);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/CadastrarCidade.jsp");
            requestDispatcher.forward(request, response);

        } else if (pageRequested.equals("RealizaCadastroCidade")) {
            CityDAO cityDAO = CityDAO.getInstance();


            cityDAO.insertCity(request.getParameter("name"), request.getParameter("description"), request.getParameter("province"), request.getParameter("country"), Double.parseDouble(request.getParameter("latitude")), Double.parseDouble(request.getParameter("longitude")), request.getParameter("url"));

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);

        } else if (pageRequested.equals("CadastraHotel")) {
            CityDAO cityDAO = CityDAO.getInstance();

            List<City> allCities = cityDAO.getAllCities();

            request.setAttribute("allCities", allCities);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/CadastrarHoteis.jsp");
            requestDispatcher.forward(request, response);
        } else if (pageRequested.equals("RealizaCadastro")) {
            HotelDAO hotelDAO = HotelDAO.getInstance();


            hotelDAO.insertHotel(request.getParameter("name"), Double.parseDouble(request.getParameter("price")), Integer.parseInt(request.getParameter("CityID")));

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);

        }
        else if (pageRequested.equals("CadastrarTransportes")) {
            TransportDAO transportDAO = TransportDAO.getInstance();

            List<Transport> allTransports = transportDAO.getAllTransports();

            request.setAttribute("allTransports", allTransports);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/CadastrarTransporte.jsp");
            requestDispatcher.forward(request, response);
        }else if (pageRequested.equals("RealizaCadastroTransporte")) {
            TransportDAO transportDAO = TransportDAO.getInstance();


            transportDAO.insertTransport(request.getParameter("tipo"), request.getParameter("company"), Double.parseDouble(request.getParameter("price")), Integer.parseInt(request.getParameter("originid")), Integer.parseInt(request.getParameter("destinationid")));

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);

        }else if (pageRequested.equals("CadastrarClientes")) {
            ClientDAO clientDAO = ClientDAO.getInstance();

            List<Client> allClients = clientDAO.getAllClients();

            request.setAttribute("allClients", allClients);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/CadastrarCliente.jsp");
            requestDispatcher.forward(request, response);
        }else if (pageRequested.equals("RealizaCadastroCliente")) {
            ClientDAO clientDAO = ClientDAO.getInstance();


            clientDAO.insertClient(request.getParameter("name"), Integer.parseInt(request.getParameter("cpf")), Integer.parseInt(request.getParameter("telefone")), Integer.parseInt(request.getParameter("id")));

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);

        }


    }

    private void concluirVendaPacote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("produto").equals("roteiro")) {
            RouteDAO routeDAO = RouteDAO.getInstance();
            routeDAO.insertVendaRoteiro(Integer.parseInt(request.getParameter("cpf")));
        } else {
            try {
                VendaPacoteDAO vendaPacoteDAO = VendaPacoteDAO.getInstance();
                int packageID = Integer.parseInt(request.getParameter("packageID"));
                int cpf = Integer.parseInt(request.getParameter("cpf"));
                String paymentType = request.getParameter("payment");

                int numeroPessoas = Integer.parseInt(request.getParameter("nPessoas"));
                vendaPacoteDAO.insertVendaPacote(cpf, packageID, paymentType, numeroPessoas);
            } catch (NullPointerException e) {

            }
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);
    }

    private void selecionarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientDAO clientDAO = ClientDAO.getInstance();

        List<Client> clients = clientDAO.getAllClients();
        request.setAttribute("clients", clients);

        String paymentType = request.getParameter("payment");
        request.setAttribute("payment", paymentType);
        int numeroPessoas = Integer.parseInt(request.getParameter("nPessoas"));
        request.setAttribute("nPessoas", numeroPessoas);

        request.setAttribute("produto", request.getParameter("produto"));

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/VincularPacoteCliente.jsp");
        requestDispatcher.forward(request, response);
    }

    private void resumoRoteiro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Route rota = new Route();

        CityDAO cityDAO = CityDAO.getInstance();
        HotelDAO hotelDAO = HotelDAO.getInstance();
        TransportDAO transportDAO = TransportDAO.getInstance();

        String[] cities = request.getParameterValues("Cidade");
        String[] hotels = request.getParameterValues("Hotel");
        String[] transports = request.getParameterValues("Transporte");
        ArrayList<City> chosenCities = new ArrayList<>();
        ArrayList<Hotel> chosenHotels = new ArrayList<>();
        ArrayList<Transport> chosenTransports = new ArrayList<>();

        for (String cityId : cities) {
            chosenCities.add(cityDAO.getCityById(Integer.valueOf(cityId)));
        }

        for (String hotelId : hotels) {
            chosenHotels.add(hotelDAO.getHotelById(Integer.valueOf(hotelId)));
        }

        for (String transportId : transports) {
            chosenTransports.add(transportDAO.getTransportById(Integer.valueOf(transportId)));
        }

        rota.setTransports(chosenTransports);
        rota.setHotels(chosenHotels);
        rota.setCities(chosenCities);

        request.setAttribute("rota", rota);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ResumoRoteiro.jsp");
        requestDispatcher.forward(request, response);
    }

    private void fecharPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        PackageDAO packageDAO = PackageDAO.getInstance();

        IPackage pacote = packageDAO.getPackageById(Integer.parseInt(request.getParameter("package")));
        request.setAttribute("package", pacote);

        boolean isHotTopic = packageDAO.isHotTopic(pacote.getPackageId());

        request.setAttribute("isHotTopic", isHotTopic);


        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/FecharPedido.jsp");
        requestDispatcher.forward(request, response);
    }

    private void hoteisETransportes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CityDAO cityDAO = CityDAO.getInstance();
        HotelDAO hotelDAO = HotelDAO.getInstance();
        TransportDAO transportDAO = TransportDAO.getInstance();

        String[] cities = request.getParameterValues("city");
        ArrayList<City> chosenCities = new ArrayList<>();

        ArrayList<ArrayList<Hotel>> citiesHotel = new ArrayList<>();
        for (String cityId : cities) {
            chosenCities.add(cityDAO.getCityById(Integer.valueOf(cityId)));

            citiesHotel.add(hotelDAO.getHoteisByCityId(Integer.valueOf(cityId)));
        }

        ArrayList<ArrayList<Transport>> citiesTransports = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            if (i == cities.length - 1) {
                citiesTransports.add(transportDAO.getTransports(Integer.valueOf(cities[i]), Integer.valueOf(cities[0])));
            } else {
                citiesTransports.add(transportDAO.getTransports(Integer.valueOf(cities[i]), Integer.valueOf(cities[i + 1])));
            }
        }

        request.setAttribute("hoteisPorCidade", citiesHotel);
        request.setAttribute("transportesPorCidade", citiesTransports);
        request.setAttribute("cidadesEscolhidas", chosenCities);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/SelectTransportHotel.jsp");
        requestDispatcher.forward(request, response);
    }

    private void processaCidades(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CityDAO dao = CityDAO.getInstance();
        int idOrigem = Integer.parseInt(request.getParameter("origem"));
        int idDestino = Integer.parseInt(request.getParameter("destino"));
        City origem = dao.getCityById(idOrigem);
        City destino = dao.getCityById(idDestino);

        request.setAttribute("listaCidades", getCitiesBetween(idOrigem, idDestino));
        request.setAttribute("cidadeOrigem", origem);
        request.setAttribute("cidadeDestino", destino);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ListaDeCidades.jsp");
        requestDispatcher.forward(request, response);
    }

    private void listaCidades(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));

        CityDAO dao = CityDAO.getInstance();
        request.setAttribute("cidade", dao.getCityById(id));

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ListaDeCidade.jsp");
        requestDispatcher.forward(request, response);
    }

    private void processaBotao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("criarRoteiro") != null) {

            CityDAO cityDAO = CityDAO.getInstance();

            List<City> allCities = cityDAO.getAllCities();

            request.setAttribute("cidades", allCities);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/SelectOrigemDestino.jsp");
            requestDispatcher.forward(request, response);

        } else if (request.getParameter("comprarPacote") != null) {

            PackageDAO packageDAO = PackageDAO.getInstance();

            List<IPackage> packages = packageDAO.getAll();

            request.setAttribute("listaPackages", packages);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/SelecionarPacote.jsp");
            requestDispatcher.forward(request, response);

        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    private List<City> getCitiesBetween(int idOrigin, int idDestiny) {
        CityDAO cityDAO = CityDAO.getInstance();

        return cityDAO.getCitiesBetween(cityDAO.getCityById(idOrigin), cityDAO.getCityById(idDestiny));

    }

}
