package br.usp.pcs.mvc.Cidade.servlet;

import br.usp.pcs.mvc.Cidade.dao.CityDAO;
import br.usp.pcs.mvc.Cidade.data.City;
import br.usp.pcs.mvc.Hotel.dao.HotelDAO;
import br.usp.pcs.mvc.Hotel.data.Hotel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.usp.pcs.mvc.Cidade.dao.CityDAO;
import br.usp.pcs.mvc.Cidade.data.City;
import br.usp.pcs.mvc.Route.dao.RouteDAO;
import br.usp.pcs.mvc.Route.data.Route;
import br.usp.pcs.mvc.Transport.dao.TransportDAO;
import br.usp.pcs.mvc.Transport.data.Transport;

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

            if (request.getParameter("criarRoteiro") != null) {

                CityDAO cityDAO = CityDAO.getInstance();
                request.setAttribute("cidades", cityDAO.getAllCities());

                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/SelectOrigemDestino.jsp");
                requestDispatcher.forward(request, response);

            } else if (request.getParameter("comprarPacote") != null) {

                RouteDAO routeDAO = RouteDAO.getInstance();

                ArrayList<Route> rotas = routeDAO.getAllRoutes();

                request.setAttribute("listaRotas", rotas);

                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/SelecionarPacote.jsp");
                requestDispatcher.forward(request, response);

            }

        } else if (pageRequested.equals("listaCidades")) {

            int id = Integer.valueOf(request.getParameter("id"));

            CityDAO dao = CityDAO.getInstance();
            request.setAttribute("cidade", dao.getCityById(id));

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ListaDeCidade.jsp");
            requestDispatcher.forward(request, response);


        } else if (pageRequested.equals("ProcessaCidades")) {
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

        } else if (pageRequested.equals("HoteisETransportes")) {

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

        } else if (pageRequested.equals("FecharPedido")) {

            RouteDAO routeDAO = RouteDAO.getInstance();
            Route route = routeDAO.getRouteById(Integer.parseInt(request.getParameter("rota")));
            request.setAttribute("rota", route);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/FecharPedido.jsp");
            requestDispatcher.forward(request, response);
        } else if (pageRequested.equals("CadastraHotel")) {
            CityDAO cityDAO = CityDAO.getInstance();

            ArrayList<City> allCities = cityDAO.getAll();

            request.setAttribute("allCities", allCities);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/CadastrarHoteis.jsp");
            requestDispatcher.forward(request, response);

        } else if (pageRequested.equals("CadastrarCidade")) {
            CityDAO cityDAO = CityDAO.getInstance();

            ArrayList<City> allCities = cityDAO.getAll();

            request.setAttribute("allCities", allCities);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/CadastrarCidade.jsp");
            requestDispatcher.forward(request, response);

        }

        else if (pageRequested.equals("RealizaCadastro")) {
            HotelDAO hotelDAO = HotelDAO.getInstance();



            hotelDAO.insertHotel(request.getParameter("name"), Double.parseDouble(request.getParameter("price")), Integer.parseInt(request.getParameter("CityID")));

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request,response);

        }
        else if (pageRequested.equals("RealizaCadastroCidade")) {
            CityDAO cityDAO = CityDAO.getInstance();



            cityDAO.insertCity(request.getParameter("name"), request.getParameter("description"),request.getParameter("province"), request.getParameter("country"), Double.parseDouble(request.getParameter("latitude")), Double.parseDouble(request.getParameter("longitude")), request.getParameter("imagemUrl"));

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request,response);

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
