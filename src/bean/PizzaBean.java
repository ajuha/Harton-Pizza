package bean;

import java.util.Scanner;


/** PizzaBean class luo Getterit, Setterit ja toStringit pizzoille */



public class PizzaBean {


	


	private int tunnus;
	private String nimi;
	private String sisalto;
	private double hinta;

	//parametriton konstruktori
	public PizzaBean(){

		tunnus = 0;
		nimi = "";
		sisalto = null;
		hinta = 0.0;
	}
	
	//parametrillinen konstruktori
	public PizzaBean(int tunnus, String nimi, String sisalto,double hinta) {
		this.tunnus = tunnus;
		this.nimi = nimi;
		this.sisalto = sisalto;
		this.hinta = hinta;

	}
	
	public int getTunnus() {
		return tunnus;
	}
	
	public void setTunnus(int tunnus) {
		this.tunnus = tunnus;
	}
	
	public String getNimi() {
		return nimi;
	}
	
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public String getSisalto() {
		return sisalto;
	}
	
	public void setSisalto(String sisalto) {
		this.sisalto = sisalto;
	}
	
	public double getHinta() {
		return hinta;
	}
	
	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	
	@Override
	public String toString() {
		return "[id: " + tunnus
		         + ", nimi: " + nimi + ", sisalto: " + sisalto + ", hinta: "
		         + hinta + "]";
	}


}
