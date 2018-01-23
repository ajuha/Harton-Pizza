package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOPoikkeus;
import bean.PizzaBean;
import bean.TilausBean;
import service.PizzalistaService;

/**
T‰m‰ controller lis‰‰ pizzoja ostoskori listaan joka toimii sessiossa. Samalla se laskee pizzojen yhteishintoja ja lukum‰‰ri‰
ja laittaa nekin sessioon.
*/
@WebServlet("/LisaaOstoskoriinController")
public class LisaaOstoskoriinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LisaaOstoskoriinController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// hakee klikatun pizzan kohdalta pizzan id:n
		String lisattavanPizzanIdStringina = request.getParameter("id");
		int lisattavanPizzanId;
		
		
		int pizzojenmaara = 0;
		double yhteishinta = 0;
		
		
		
		// haetaan ostoskorin tiedot
		List<PizzaBean> ostoskori = (List<PizzaBean>)request.getSession().getAttribute("ostoskori");
		// jos ostoskori taulukkoa ei ole niin luodaan uusi
		if (ostoskori == null) {
			ostoskori = new ArrayList<PizzaBean>();
		}
		
		
		
		try {
			// muutetaan pizzaid string muodosta int muotoon, jotta sen hakeminen tietokannasta onnistuisi
			lisattavanPizzanId = Integer.parseInt(lisattavanPizzanIdStringina);
			
			PizzalistaService service = new PizzalistaService();
			// vied‰‰n lis‰tt‰v‰n pizzan ID PizzalistaServiceen joka hakee pizzan tiedot ID:n perusteella
			PizzaBean p = service.haePizza(lisattavanPizzanId);
			
			
			//lis‰t‰‰n yhden pizzan tiedot ostoskoriin
			ostoskori.add(p);

			//p‰ivitet‰‰n ostoskorin tiedot sessioon
			request.getSession().setAttribute("ostoskori", ostoskori);
			
			//t‰m‰ for-lause tulostaa kaikki ostoskorin pizzat
			for(PizzaBean pizza : ostoskori) {
				System.out.println(pizza.getNimi());
				yhteishinta = yhteishinta + pizza.getHinta();
				pizzojenmaara = pizzojenmaara + 1;
			}
			System.out.println(yhteishinta);
		} catch(DAOPoikkeus e) {
			System.out.println("ERROR: Ostoskoriin yritettiin lis‰t‰ pizza, jonka id ei ole kokonaisluku. (ID:" + lisattavanPizzanIdStringina + ")");
			request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
		}
		
		
    	// luodaan lista nimelt‰ pizzat
		List<PizzaBean> pizzat;

		
		try {
			PizzalistaService pService = new PizzalistaService();
			// l‰hetet‰‰n PizzalistaServicen metodille haePizzalista pizzat lista, johon laitetaan kaikki pizzat
			pizzat = pService.haePizzalista();
		} catch(DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		
		request.getSession().setAttribute("pizzojenmaara", pizzojenmaara);
		request.getSession().setAttribute("yhteishinta", yhteishinta);
		request.setAttribute("pizzat", pizzat);
		//pizzalistan pizzat l‰hetet‰‰n pizzalista.jsp sivun k‰ytett‰v‰ksi
		request.getRequestDispatcher("WEB-INF/jsp/pizzalista.jsp").forward(request, response);
	}
		
		
		
		
		
		
	}


