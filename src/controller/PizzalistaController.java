package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOPoikkeus;
import service.PizzalistaService;
import bean.PizzaBean;


/**
T‰m‰ controller hakee tietokannasta pizzalistaDaosta kaikki pizzat ja l‰hett‰‰ tiedot pizzalista.jsp sivulle
*/
@WebServlet("/PizzalistaController")
public class PizzalistaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PizzalistaController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	// luodaan lista nimelt‰ pizzat
		List<PizzaBean> pizzat;

		
		try {
			PizzalistaService pService = new PizzalistaService();
			// l‰hetet‰‰n PizzalistaServicen metodille haePizzalista pizzat lista, johon laitetaan kaikki pizzat
			pizzat = pService.haePizzalista();
		} catch(DAOPoikkeus e) {
			throw new ServletException(e);
		}
		
		request.setAttribute("pizzat", pizzat);
		//pizzalistan pizzat l‰hetet‰‰n pizzalista.jsp sivun k‰ytett‰v‰ksi
		request.getRequestDispatcher("WEB-INF/jsp/pizzalista.jsp").forward(request, response);
	}

}
