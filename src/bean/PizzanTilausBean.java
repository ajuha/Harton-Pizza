package bean;

/** PizzanTilausBean class luo Getterit, Setterit ja toStringit pizzantilauksille */


public class PizzanTilausBean {

	private int id;
	private int tilausid;
	private int pizzaid;
	private int statusid;



	public PizzanTilausBean() {
		id = 0;
		tilausid = 0;
		pizzaid = 0;
		statusid = 0;
	}

	public PizzanTilausBean(int id, int tilausid, int pizzaid, int statusid) {
		super();
		this.id = id;
		this.tilausid = tilausid;
		this.pizzaid = pizzaid;
		this.statusid = statusid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTilausid() {
		return tilausid;
	}

	public void setTilausid(int tilausid) {
		this.tilausid = tilausid;
	}

	public int getPizzaid() {
		return pizzaid;
	}

	public void setPizzaid(int pizzaid) {
		this.pizzaid = pizzaid;
	}
	
	public int getStatusid() {
		return statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}

}
