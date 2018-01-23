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
import dao.Yhteys;
import bean.PizzaBean;
import bean.PizzanTilausBean;
import bean.TilausBean;
import service.PizzalistaService;
import service.PizzanTilausService;

/**
T‰m‰ Controller muuttaa yhden pizzan statuksen. pizzantilausid ja statusid otetaan jsp sivulta
ja se l‰hetet‰‰n PizzanTilausDAOon joka muuttaa statuksen. Controller l‰hett‰‰ sivun lopuksi samalle sivulle
*/
@WebServlet("/MuutaStatusController")
public class MuutaStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MuutaStatusController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// hakee klikatun pizzan kohdalta pizzan id:n
		String pizzantilausidString = request.getParameter("id");
		String statusidString = request.getParameter("statusid");
		int pizzantilausid;
		int statusid;
		
		pizzantilausid = Integer.parseInt(pizzantilausidString);
		statusid = Integer.parseInt(statusidString);
		
		
		
		try {
			// luodaan yhteys tietokantaan
			Connection yhteys = Yhteys.avaaYhteys();
			PizzanTilausDAO ptDao = new PizzanTilausDAO();
			// kutsutaan tilausDAO:ssa olevaa metodia lisaaTilaus, johon vied‰‰n tilauksen ja ostoskorin tiedot
			// TilausDAOssa lis‰t‰‰n n‰m‰ tiedot tietokantaan
			ptDao.vaihdaStatus(pizzantilausid, statusid, yhteys);
			Yhteys.suljeYhteys(yhteys);
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		
	
List<PizzanTilausBean> pizzantilaukset;

		
		try {
			PizzanTilausService ptService = new PizzanTilausService();
			// hakee pizzantilaukset listaan kaikki pizzantilaukset TilausListaService.java:sta
			pizzantilaukset = ptService.haePizzanTilaus();
		} catch(DAOPoikkeus e) {
			throw new ServletException(e);
		}
		request.setAttribute("pizzantilaukset", pizzantilaukset);
		
		//pizzantilaukset l‰hetet‰‰n pizzantilausxasiakas.jsp sivun k‰ytett‰v‰ksi
		request.getRequestDispatcher("WEB-INF/jsp/pizzantilausxasiakas.jsp").forward(request, response);
		
		
		
		
		
	}
		
		
		
		
		
		
	}


