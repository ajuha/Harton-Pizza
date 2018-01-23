
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 Tämä controller vie käyttäjän surprise.jsp sivulle
 */
@WebServlet(urlPatterns={"/surprise"})
public class SurpriseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SurpriseController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/jsp/surprise.jsp").forward(request, response);
	}

}
