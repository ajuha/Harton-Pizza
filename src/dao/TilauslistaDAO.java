package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.TilausBean;
import dao.DAOPoikkeus;
/**
Tämä luokka hakee kaikki tilaukset. Tässä luokassa vaihdetaan myös tilauksen status
*/
public class TilauslistaDAO {

	//Hakee pizzat kannasta 
	public List<TilausBean> haeKaikki(Connection yhteys) throws DAOPoikkeus{		
		
		ArrayList<TilausBean> tilaukset = new ArrayList<TilausBean>();
		
		try {
			
			//haetaan tilaus taulusta kaikki tiedot
			String sql = "select t.tilausid, t.etunimi, t.sukunimi, t.lahiosoite, t.postinro, t.postitmp, t.puh, t.lisatiedot, t.hinta, t.statusid from tilaus t;";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			//käydään hakutulokset läpi
			while(tulokset.next()) {
				int tilausid = tulokset.getInt("t.tilausid");
				String etunimi = tulokset.getString("t.etunimi");
				String sukunimi = tulokset.getString("t.sukunimi");
				String lahiosoite = tulokset.getString("t.lahiosoite");
				String postinro = tulokset.getString("t.postinro");
				String postitmp = tulokset.getString("t.postitmp");
				String puh = tulokset.getString("t.puh");
				String lisatiedot = tulokset.getString("t.lisatiedot");
				double hinta = tulokset.getDouble("t.hinta");
				int statusid = tulokset.getInt("t.statusid");
				
				
				
				
				// lisätään kaikki tilaukset tilaukset listaan
				TilausBean t = new TilausBean(tilausid, etunimi, sukunimi, lahiosoite, postinro, postitmp, puh, lisatiedot, hinta, statusid);
				tilaukset.add(t);
			}
			
		} catch(Exception e) {
			// virheitä tapahtui
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}
		
		System.out.println("HAETTIIN TIETOKANNASTA PIZZAT: " + tilaukset.toString());
		
		return tilaukset;
	}
	
public void vaihdaStatus(int tilausid, int statusid, Connection yhteys) throws DAOPoikkeus {
		
		System.out.println(statusid);
		System.out.println(tilausid);
		try {
			String sql="";
			//suoritetaan haku
			if (statusid==1)
			{
				sql = "UPDATE tilaus SET statusid = 2 WHERE tilausid=?";
			}
			else if (statusid==2)
			{
				sql = "UPDATE tilaus SET statusid = 3 WHERE tilausid=?";	
			}
			else if (statusid==3){
				sql = "UPDATE tilaus SET statusid = 1 WHERE tilausid=?";
			}
			PreparedStatement lause = yhteys.prepareStatement(sql);
			lause.setInt(1, tilausid);

			lause.executeUpdate();
			
			
		} catch(Exception e) {
			// virheitä tapahtui
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}
		


	}
}