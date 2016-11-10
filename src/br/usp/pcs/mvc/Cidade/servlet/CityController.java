package br.usp.pcs.mvc.Cidade.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usp.pcs.mvc.Cidade.dao.CityDAO;

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
		
		pageRequested = (String) request.getParameter("page");
		
		if (pageRequested == null) {
			
			CityDAO dao = CityDAO.getInstance();
			request.setAttribute("cidades", dao.getAllCities());
			
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ListaDeCidades.jsp");
			requestDispatcher.forward(request, response);
			
		} else if (pageRequested.equals("details")) {
			
			int id = Integer.valueOf(request.getParameter("id"));

			CityDAO dao = CityDAO.getInstance();
			request.setAttribute("cidade", dao.getCityById(id));
			
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/DetalhesCidade.jsp");
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

}
