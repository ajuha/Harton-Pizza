package service;

import java.sql.Connection;
import java.util.List;

import dao.DAOPoikkeus;
import dao.PizzaDAO;
import dao.Yhteys;
import bean.PizzaBean;

/**
Tämä luokka luo yhteyden tietokantaan ja hakee myös pizzoja pizzaDAOn kautta
*/

public class PizzalistaService {
	
	PizzaDAO pDAO = new PizzaDAO();
	// metodi hakee kaikki tietokannassa olevat pizzat
	public List<PizzaBean> haePizzalista() throws DAOPoikkeus {
		// avaa tietokantayhteyden
		Connection yhteys = Yhteys.avaaYhteys();
		// hakee PizzaDAO.javasta kaikki pizzat
		List<PizzaBean> pizzat = pDAO.haeKaikki(yhteys);
		
		Yhteys.suljeYhteys(yhteys);
		//palauttaa listan metodin kutsujalle
		return pizzat;
		
	}
	
	public PizzaBean haePizza(int id) throws DAOPoikkeus {

		Connection yhteys = Yhteys.avaaYhteys();
		// hakee PizzaDAO.javasta yhden pizzan id:n perusteella
		PizzaBean p = pDAO.haeYksiPizza(id, yhteys);
		
		Yhteys.suljeYhteys(yhteys);
		//palauttaa yhden pizzan metodin kutsujalle
		return p;
		
	}
	
	

}
