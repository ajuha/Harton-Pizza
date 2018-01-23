package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOPoikkeus;
import service.TilauslistaService;
import bean.TilausBean;

/**
T‰m‰ controller hakee TilauslistaDAOn kautta tietokannasta kaikki tilaukset
*/

@WebServlet("/TilauslistaController")
public class TilauslistaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TilauslistaController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<TilausBean> tilaukset;

		
		try {
			TilauslistaService tService = new TilauslistaService();
			// hakee tilaukset listaan kaikki tilaukset TilausListaService.java:sta
			tilaukset = tService.haeTilauslista();
		} catch(DAOPoikkeus e) {
			throw new ServletException(e);
		}
		request.setAttribute("tilaukset", tilaukset);
		
		//tilaukset l‰hetet‰‰n tilauslista.jsp sivun k‰ytett‰v‰ksi
		request.getRequestDispatcher("WEB-INF/jsp/tilauslista.jsp").forward(request, response);
	}

}
