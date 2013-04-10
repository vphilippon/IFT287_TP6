package tp6Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Classe pour test systeme de gestion de cinematheque
 * Inspire de l'exemple de Marc Frappier
 */

@SuppressWarnings("serial")
public class Test extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String submit1 = request.getParameter("submit1");
		System.out.println("Valeur de submit 1 = " + submit1);
		String submit2 = request.getParameter("submit2");
		System.out.println("Valeur de submit 2 = " + submit2);
	}

	// Dans les formulaire, on utilise la methode POST
	// donc, si le servlet est appele avec la methode GET
	// on retourne un page d'erreur, afin de ne pas permettre
	// a l'utilisateur d'appeler un servler directement
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

} // class
