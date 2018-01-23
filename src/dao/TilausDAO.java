package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.PizzaBean;

import bean.TilausBean;
/**
T‰m‰ luokka lis‰‰ saadut tiedot tilaustauluun ja samalla pizzantilaustauluun kaikki tilauksen pizzojen id:t
*/
public class TilausDAO {

	public void lisaaTilaus(TilausBean tilaus, ArrayList<PizzaBean> ostoskori, Connection yhteys)
			throws DAOPoikkeus {
		int tilausid;

		try {
			String sql = "INSERT INTO tilaus (etunimi, sukunimi, lahiosoite, postinro, postitmp, puh, lisatiedot, hinta, statusid) VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement lause = yhteys.prepareStatement(sql);
			
			//t‰ss‰ laitetaan tilausbeanin tiedot SQL-lauseen "?" kohtiin ja saadaan 
			lause.setString(1, tilaus.getEtunimi());
			lause.setString(2, tilaus.getSukunimi());
			lause.setString(3, tilaus.getLahiosoite());
			lause.setString(4, tilaus.getPostinro());
			lause.setString(5, tilaus.getPostitmp());
			lause.setString(6, tilaus.getPuhelinnro());
			lause.setString(7, tilaus.getLisatiedot());
			lause.setDouble(8, tilaus.getHinta());
			lause.setInt(9, 1);
			
			// suoritetaan lause
			lause.executeUpdate();
			
			System.out.println("Lis‰ttiin tietokantaan tilaus: "
					+ tilaus.toString());

			try (ResultSet generatedKeys = lause.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					tilausid = generatedKeys.getInt(1);
					System.out.println("ID ON " + tilausid);
					tilaus.setTilausId(tilausid);

				} else {
					throw new SQLException(
							"Creating user failed, no asiakasId obtained.");
				}
			}
			
			// for-looppi k‰y kaikki ostoskorissa olevat pizzat l‰pi ja lis‰ilee niiden ID:t sek‰ tilauksen idn pizzantilaus tauluun
			for (int i =0; i < ostoskori.size(); i++) {
				System.out.println("Lis‰t‰‰n pizzantilaus tauluun tilausid " + tilausid + " ja pizzaid " + ostoskori.get(i).getTunnus());
				sql = "INSERT INTO pizzantilaus (tilausid, pizzaid, statusid) VALUES (?,?,?)";
				lause = yhteys.prepareStatement(sql);
				lause.setInt(1, tilausid);
				lause.setInt(2, ostoskori.get(i).getTunnus());
				lause.setInt(3, 1);
				

				// suoritetaan lause niin monta kertaa, kuin pizzoja on tilattu.
				lause.executeUpdate();
			}


		} catch (Exception e) {
			// JOTAIN VIRHETTƒ TAPAHTUI
			throw new DAOPoikkeus(
					"Tilauksen lis‰ys kantaan aiheutti virheen: ", e);
		}
	}

}