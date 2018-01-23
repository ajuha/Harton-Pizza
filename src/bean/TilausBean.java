package bean;


/** TilausaBean class luo Getterit, Setterit ja toStringit asiakkaille */
public class TilausBean {
	
	private int tilausId;
	private String etunimi;
	private String sukunimi;
	private String lahiosoite;
	private String postinro;
	private String postitmp;
	private String puhelinnro;
	private String lisatiedot;
	private double hinta;
	private int statusid;
	
	//parametriton konstruktori
	public TilausBean(){

		tilausId = 0;
		etunimi = "";
		sukunimi = "";
		lahiosoite = "";
		postinro = "";
		postitmp = "";
		puhelinnro = "";
		lisatiedot = "";
		hinta = 0.0;
		statusid = 0;
		
	}
	
	//parametrillinen konstruktori
	public TilausBean(int tilausId, String etunimi, String sukunimi, String lahiosoite, String postinro, String postitmp, String puhelinnro, String lisatiedot, double hinta, int statusid) {
		this.tilausId = tilausId;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.lahiosoite = lahiosoite;
		this.postinro = postinro;
		this.postitmp = postitmp;
		this.puhelinnro = puhelinnro;
		this.lisatiedot = lisatiedot;
		this.hinta = hinta;
		this.statusid = statusid;
	
	}
	
	
	
	
	


	public String getPostitmp() {
		return postitmp;
	}

	public void setPostitmp(String postitmp) {
		this.postitmp = postitmp;
	}

	public String getLisatiedot() {
		return lisatiedot;
	}

	public void setLisatiedot(String lisatiedot) {
		this.lisatiedot = lisatiedot;
	}

	public int getTilausId() {
		return tilausId;
	}

	public void setTilausId(int tilausId) {
		this.tilausId = tilausId;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getLahiosoite() {
		return lahiosoite;
	}

	public void setLahiosoite(String lahiosoite) {
		this.lahiosoite = lahiosoite;
	}

	public String getPostinro() {
		return postinro;
	}

	public void setPostinro(String postinro) {
		this.postinro = postinro;
	}

	public String getPuhelinnro() {
		return puhelinnro;
	}

	public void setPuhelinnro(String puhelinnro) {
		this.puhelinnro = puhelinnro;
	}
	
	public int getStatusid() {
		return statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}
	
	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	

	@Override
	public String toString() {
		return "TilausBean [tilausId=" + tilausId + ", etunimi=" + etunimi
				+ ", sukunimi=" + sukunimi + ", lahiosoite=" + lahiosoite
				+ ", postinro=" + postinro + ", postitmp=" + postitmp
				+ ", puhelinnro=" + puhelinnro + ", lisatiedot=" + lisatiedot
				+ ", pizzaId=" + "]";
	}
	
	
	
	

}
