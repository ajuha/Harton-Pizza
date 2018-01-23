package dao;
/**
T‰m‰n luokan metodeja k‰ytet‰‰n DAOissa, aina kun tulee jokin tietokantapoikkeus.
*/
public class DAOPoikkeus extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOPoikkeus() {
		super("Tietokantapoikkeus");
	}

	
	public DAOPoikkeus(String viesti) {
		super(viesti);
	}

	public DAOPoikkeus(Throwable aiheuttaja) {
		super(aiheuttaja);
	}
	// palauttaa virheilmoituksen ja kertoo aiheuttajan
	public DAOPoikkeus(String viesti, Throwable aiheuttaja) {
		super(viesti, aiheuttaja);
	}

}