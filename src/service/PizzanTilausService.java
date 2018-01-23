package service;

import java.sql.Connection;
import java.util.List;

import dao.DAOPoikkeus;
import dao.PizzaDAO;
import dao.PizzanTilausDAO;
import dao.TilauslistaDAO;
import dao.Yhteys;
import bean.PizzanTilausBean;

/**
T�m� luokka luo yhteyden tietokantaan ja hakee my�s pizzantilauksia PizzanTilausDAOn kautta
*/

public class PizzanTilausService {
	
	PizzanTilausDAO ptDAO = new PizzanTilausDAO();
	
	// t�m� metodi hakee kaikki pizzantilaus taulun tiedot
	public List<PizzanTilausBean> haePizzanTilaus() throws DAOPoikkeus {

		Connection yhteys = Yhteys.avaaYhteys();
		
		List<PizzanTilausBean> pizzantilaukset = ptDAO.haeKaikki(yhteys);
		
		Yhteys.suljeYhteys(yhteys);
		return pizzantilaukset;
		
	}
		

}
