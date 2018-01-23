package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOPoikkeus;
import dao.TilausDAO;
import dao.Yhteys;
import bean.PizzaBean;
import bean.TilausBean;

/**
Tämä controller vie käyttäjän ostoskori sivulle
*/
@WebServlet(urlPatterns={"/ostoskori"})
public class NaytaOstoskori extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NaytaOstoskori() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

		//haetaan tilausbean sessiosta, jos sitä ei ole niin luodaan uusi
		TilausBean tilaus = (TilausBean)request.getSession().getAttribute("tilaus");
		if (tilaus == null) {
			tilaus = new TilausBean();
		}
		request.getSession().setAttribute("tilaus", tilaus);
		
	
		request.getRequestDispatcher("WEB-INF/jsp/ostoskori.jsp").forward(request, response);

	}

}
