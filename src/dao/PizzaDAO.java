package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.PizzaBean;
import dao.DAOPoikkeus;
/**
T‰m‰ luokka hakee tietokannasta kaikki pizzat, tai vain yhden pizzan ja l‰hett‰‰ tiedot metodin kutsujalle
*/
public class PizzaDAO {

	// t‰m‰ metodi hakee kaikki pizzat tietokannasta
	public List<PizzaBean> haeKaikki(Connection yhteys) throws DAOPoikkeus{		
		
		ArrayList<PizzaBean> pizzat = new ArrayList<PizzaBean>();
		
		try {
			
			//suoritetaan haku
			String sql = "select p.pizzaid, p.nimi, p.sisalto, p.hinta from pizzat p;";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			//k‰yd‰‰n hakutulokset l‰pi
			while(tulokset.next()) {
				int tunnus = tulokset.getInt("p.pizzaid");
				String nimi = tulokset.getString("p.nimi");
				String sisalto = tulokset.getString("p.sisalto");
				double hinta = tulokset.getDouble("p.hinta");
				
				
				//lis‰t‰‰n pizza listaan, toistetaan t‰t‰ niin monta kertaa kuin pizzoja on tietokannassa.
				PizzaBean p = new PizzaBean(tunnus, nimi, sisalto, hinta);
				pizzat.add(p);
			}
			
		} catch(Exception e) {
			// virheit‰ tapahtui
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}
		
		System.out.println("HAETTIIN TIETOKANNASTA PIZZAT: " + pizzat.toString());
		
		return pizzat;
	}
	// t‰m‰ metodi hakee vain yhden pizzan
	public PizzaBean haeYksiPizza(int pizzaid, Connection yhteys) throws DAOPoikkeus {
		PizzaBean p = null;
		
		try {
			
			//suoritetaan haku
			String sql = "select p.pizzaid, p.nimi, p.sisalto, p.hinta from pizzat p where p.pizzaid = ?;";
			PreparedStatement haku = yhteys.prepareStatement(sql);
			haku.setInt(1, pizzaid);
			ResultSet tulokset = haku.executeQuery();
			
			//k‰yd‰‰n hakutulokset l‰pi
			if(tulokset.next()) {
				int tunnus = tulokset.getInt("p.pizzaid");
				String nimi = tulokset.getString("p.nimi");
				String sisalto = tulokset.getString("p.sisalto");
				double hinta = tulokset.getDouble("p.hinta");
				
				// lis‰t‰‰n vain yhden pizzan tiedot listaan
				p = new PizzaBean(tunnus, nimi, sisalto, hinta);
			}
			
		} catch(Exception e) {
			// virheit‰ tapahtui
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}
		
		System.out.println("HAETTIIN TIETOKANNASTA PIZZA: " + p.toString());
		
		return p;
	}
}