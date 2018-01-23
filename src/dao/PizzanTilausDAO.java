package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.PizzaBean;
import bean.PizzanTilausBean;
import bean.TilausBean;
import dao.DAOPoikkeus;
/**
T‰m‰ luokka hakee tietokannasta yhden tai kaikki pizzantilaukset ja l‰hett‰‰ tiedot metodin kutsujalle
*/

public class PizzanTilausDAO {

	// t‰m‰ metodi hakee pizzantilaus kannan rivit
	public List<PizzanTilausBean> haeKaikki(Connection yhteys) throws DAOPoikkeus{		
		
		ArrayList<PizzanTilausBean> pizzantilaukset = new ArrayList<PizzanTilausBean>();
		
		
		
		
		
	
		
		
		try {
			
			//suoritetaan haku
			String sql = "select pt.id, pt.tilausid, pt.pizzaid, pt.statusid from pizzantilaus pt;";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			
			
			//k‰yd‰‰n hakutulokset l‰pi
			while(tulokset.next()) {
				int id = tulokset.getInt("pt.id");
				int tilausid = tulokset.getInt("pt.tilausid");
				int pizzaid = tulokset.getInt("pt.pizzaid");
				int statusid = tulokset.getInt("statusid");
				
				//lis‰t‰‰n pizzantilaukset listaan
				PizzanTilausBean pt = new PizzanTilausBean(id, tilausid, pizzaid, statusid);
				pizzantilaukset.add(pt);
			}
			
		} catch(Exception e) {
			// virheit‰ tapahtui
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}
		
		
		
		return pizzantilaukset;
	}
	
	public void vaihdaStatus(int id, int statusid, Connection yhteys) throws DAOPoikkeus {
		
		System.out.println(statusid);
		System.out.println(id);
		try {
			String sql="";
			//suoritetaan haku
			if (statusid==1)
			{
				sql = "UPDATE pizzantilaus SET statusid = 2 WHERE id=?";
			}
			else if (statusid==2)
			{
				sql = "UPDATE pizzantilaus SET statusid = 3 WHERE id=?";	
			}
			else if (statusid==3){
				sql = "UPDATE pizzantilaus SET statusid = 1 WHERE id=?";
			}
			PreparedStatement lause = yhteys.prepareStatement(sql);
			lause.setInt(1, id);

			lause.executeUpdate();
			
			
		} catch(Exception e) {
			// virheit‰ tapahtui
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}
		


	}
	
	
	

	
	}
