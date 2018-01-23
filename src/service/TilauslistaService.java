package service;

import java.sql.Connection;
import java.util.List;

import dao.DAOPoikkeus;
import dao.PizzaDAO;
import dao.TilauslistaDAO;
import dao.Yhteys;
import bean.TilausBean;

/**
Tämä luokka luo yhteyden tietokantaan ja hakee myös tilauksia TilauslistaDAOn kautta
*/

public class TilauslistaService {
	
	TilauslistaDAO tDAO = new TilauslistaDAO();
	
	// tämä metodi hakee kaikki tilaus taulun tiedot
	public List<TilausBean> haeTilauslista() throws DAOPoikkeus {

		Connection yhteys = Yhteys.avaaYhteys();
		
		List<TilausBean> tilaukset = tDAO.haeKaikki(yhteys);
		
		Yhteys.suljeYhteys(yhteys);
		return tilaukset;
		
	}
	
}
