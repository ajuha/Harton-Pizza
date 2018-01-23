package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOPoikkeus;
import service.PizzanTilausService;
import service.TilauslistaService;
import bean.PizzanTilausBean;

/**
T‰m‰ controller hakee PizzanTilausDAOn kautta kaikki pizzantilaukset ja l‰hett‰‰ ne pizzantilausxasiakas.jsp sivulle
*/
@WebServlet("/PizzanTilausController")
public class PizzanTilausController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PizzanTilausController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<PizzanTilausBean> pizzantilaukset;

		
		try {
			PizzanTilausService ptService = new PizzanTilausService();
			// hakee pizzantilaukset listaan kaikki pizzantilaukset TilausListaService.java:sta
			pizzantilaukset = ptService.haePizzanTilaus();
		} catch(DAOPoikkeus e) {
			throw new ServletException(e);
		}
		request.setAttribute("pizzantilaukset", pizzantilaukset);
		
		//pizzantilaukset l‰hetet‰‰n pizzantilausxasiakas.jsp sivun k‰ytett‰v‰ksi
		request.getRequestDispatcher("WEB-INF/jsp/pizzantilausxasiakas.jsp").forward(request, response);
	}

}
