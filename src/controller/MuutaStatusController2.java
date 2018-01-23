package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOPoikkeus;
import dao.PizzanTilausDAO;
import dao.TilausDAO;
import dao.TilauslistaDAO;
import dao.Yhteys;
import bean.PizzaBean;
import bean.PizzanTilausBean;
import bean.TilausBean;
import service.PizzalistaService;
import service.PizzanTilausService;
import service.TilauslistaService;

/**
T‰m‰ Controller muuttaa tilauksen statuksen. tilausid ja statusid otetaan jsp sivulta
ja se l‰hetet‰‰n TilausDAOon joka muuttaa statuksen. Controller l‰hett‰‰ sivun lopuksi samalle jsp sivulle
*/
@WebServlet("/MuutaStatusController2")
public class MuutaStatusController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MuutaStatusController2() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// hakee klikatun pizzan kohdalta pizzan id:n
		String tilausidString = request.getParameter("id");
		String statusidString = request.getParameter("statusid");
		int tilausid;
		int statusid;
		
		tilausid = Integer.parseInt(tilausidString);
		statusid = Integer.parseInt(statusidString);
		
		
		
		try {
			// luodaan yhteys tietokantaan
			Connection yhteys = Yhteys.avaaYhteys();
			TilauslistaDAO tDao = new TilauslistaDAO();
			// kutsutaan tilausDAO:ssa olevaa metodia lisaaTilaus, johon vied‰‰n tilauksen ja ostoskorin tiedot
			// TilausDAOssa lis‰t‰‰n n‰m‰ tiedot tietokantaan
			tDao.vaihdaStatus(tilausid, statusid, yhteys);
			Yhteys.suljeYhteys(yhteys);
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		
	
	
			
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


