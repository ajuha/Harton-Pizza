package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOPoikkeus;
import dao.TilausDAO;
import dao.Yhteys;
import bean.PizzaBean;
import bean.TilausBean;

/**
 Tämä controller hakee jsp sivulta syötetyt tiedot ja hakee sessiosta ostoskorin sisällön. Sitten se  lähettää tiedot
 TilausDAO:lle joka lisää tilauksen tietokantaan
 */

@WebServlet("/laheta_tilaus")
public class LahetaTilausController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LahetaTilausController() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// ääkköset toimimaan
		request.setCharacterEncoding("UTF-8");
		
		// tehdään uusi ostoskori lista
		ArrayList<PizzaBean> ostoskori = new ArrayList<PizzaBean>();
		// haetaan sille sessiosta tiedot
		ostoskori = (ArrayList<PizzaBean>) request.getSession().getAttribute("ostoskori");
		

		
		double hinta = (double)request.getSession().getAttribute("yhteishinta");
		
		String etunimi = request.getParameter("etunimi");
		String sukunimi = request.getParameter("sukunimi");
		String lahiosoite = request.getParameter("lahiosoite");
		String postinumero = request.getParameter("postinumero");
		String postitmp = request.getParameter("postitmp");
		String puhelin = request.getParameter("puhelin");
		String lisatiedot = request.getParameter("lisatiedot");

		TilausBean tilaus = (TilausBean) request.getSession().getAttribute(
				"tilaus");

		tilaus.setEtunimi(etunimi);
		tilaus.setSukunimi(sukunimi);
		tilaus.setLahiosoite(lahiosoite);
		tilaus.setPostinro(postinumero);
		tilaus.setPostitmp(postitmp);
		tilaus.setPuhelinnro(puhelin);
		tilaus.setLisatiedot(lisatiedot);
		tilaus.setHinta(hinta);

		try {
			// luodaan yhteys tietokantaan
			Connection yhteys = Yhteys.avaaYhteys();
			TilausDAO tDao = new TilausDAO();
			// kutsutaan tilausDAO:ssa olevaa metodia lisaaTilaus, johon viedään tilauksen ja ostoskorin tiedot
			// TilausDAOssa lisätään nämä tiedot tietokantaan
			tDao.lisaaTilaus(tilaus, ostoskori, yhteys);
			Yhteys.suljeYhteys(yhteys);
		} catch (DAOPoikkeus e) {
			throw new ServletException(e);
		}

		request.getSession().invalidate();
		
		
		// ohjaa kiitos.jsp sivulle
		request.getRequestDispatcher("WEB-INF/jsp/kiitos.jsp").forward(request,
				response);
	
	}

	
	
}
