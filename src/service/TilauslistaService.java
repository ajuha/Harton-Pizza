package service;

import java.sql.Connection;
import java.util.List;

import dao.DAOPoikkeus;
import dao.PizzaDAO;
import dao.TilauslistaDAO;
import dao.Yhteys;
import bean.TilausBean;

/**
T�m� luokka luo yhteyden tietokantaan ja hakee my�s tilauksia TilauslistaDAOn kautta
*/

public class TilauslistaService {
	
	TilauslistaDAO tDAO = new TilauslistaDAO();
	
	// t�m� metodi hakee kaikki tilaus taulun tiedot
	public List<TilausBean> haeTilauslista() throws DAOPoikkeus {

		Connection yhteys = Yhteys.avaaYhteys();
		
		List<TilausBean> tilaukset = tDAO.haeKaikki(yhteys);
		
		Yhteys.suljeYhteys(yhteys);
		return tilaukset;
		
	}
	
}
