
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Tämä Controller avaa index.jsp:n
 */
@WebServlet(urlPatterns={"/etusivu"})
public class EtusivuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EtusivuController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//avaa etusivun
		
		request.getSession().getAttribute("pizzojenmaara");
		request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
	}

}
