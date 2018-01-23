package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PizzalistaService;
import bean.PizzaBean;
import dao.DAOPoikkeus;
/**
T‰m‰ controller poistaa yhden tuotteen ostoskorista ja p‰ivitt‰‰ kokonaishinnat ja pizzojenmaara muuttujat
*/
@WebServlet("/PoistaOstoskoristaController")
public class PoistaOstoskoristaController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
    public PoistaOstoskoristaController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// hakee klikatun pizzan kohdalta pizzan id:n
		String poistettavanPizzanIdStringina = request.getParameter("id");
		int poistettavanPizzanId;
		int pizzojenmaara = 0;
		
		double yhteishinta = 0;
		
		
		
		
		
		// haetaan ostoskorin tiedot
		List<PizzaBean> ostoskori = (List<PizzaBean>)request.getSession().getAttribute("ostoskori");
		// jos ostoskori taulukkoa ei ole niin luodaan uusi
		if (ostoskori == null) {
			ostoskori = new ArrayList<PizzaBean>();
		}
		
		

			// muutetaan pizzaid string muodosta int muotoon, jotta sen hakeminen tietokannasta onnistuisi
			poistettavanPizzanId = Integer.parseInt(poistettavanPizzanIdStringina);
			
			System.out.println(poistettavanPizzanId);
			
			
			//lis‰t‰‰n yhden pizzan tiedot ostoskoriin
			

			//p‰ivitet‰‰n ostoskorin tiedot sessioon
			
			
			//t‰m‰ for-lause tulostaa kaikki ostoskorin pizzat
			for(PizzaBean pizza : ostoskori) {
				if(pizza.getTunnus() == poistettavanPizzanId){
					ostoskori.remove(pizza);
					break;
				}
			}
			
			
			
			for(PizzaBean pizza : ostoskori) {
				yhteishinta = yhteishinta + pizza.getHinta();
				pizzojenmaara = pizzojenmaara + 1;
				
			}
			
			
			

			request.getSession().setAttribute("pizzojenmaara", pizzojenmaara);
			request.getSession().setAttribute("yhteishinta", yhteishinta);
			request.getSession().setAttribute("ostoskori", ostoskori);
		
		
		
		
    	// luodaan lista nimelt‰ pizzat
		
		//pizzalistan pizzat l‰hetet‰‰n pizzalista.jsp sivun k‰ytett‰v‰ksi
		request.getRequestDispatcher("WEB-INF/jsp/ostoskori.jsp").forward(request, response);
	}
	
}
    

