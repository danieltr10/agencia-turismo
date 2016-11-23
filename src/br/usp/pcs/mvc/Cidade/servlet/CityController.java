package br.usp.pcs.mvc.Cidade.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.mvc.Cidade.dao.CityDAO;
import br.usp.pcs.mvc.Cidade.data.City;

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

                CityDAO dao = CityDAO.getInstance();
                request.setAttribute("cidades", dao.getAllCities());

                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/SelectOrigemDestino.jsp");
                requestDispatcher.forward(request, response);

            } else if (request.getParameter("comprarPacote") != null) {
                // Invoke SecondServlet's job here.
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

			String[] cities = request.getParameterValues("city");
            ArrayList<City> chosenCities = new ArrayList<>();

            for (String cityId: cities) {
                chosenCities.add(cityDAO.getCityById(Integer.valueOf(cityId)));

            }
            request.setAttribute("cidadesEscolhidas", chosenCities);

			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/HoteisETransportes.jsp");
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
