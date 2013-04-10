package tp6Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Date;
import java.text.ParseException;
import java.util.StringTokenizer;

import tp6.*;
import tp6.GestionTp6.*;
import tp6.Tp6Exception;

/**
 *
 * @author guillaume
 */
public class AjouterFilm {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                HttpSession session = request.getSession();
                GestionTp6 update = (GestionTp6)session.getAttribute("tp6Update");
                
		String titre = request.getParameter("titre");
		String dateSortie = request.getParameter("dateSortie");
		String description = request.getParameter("description");
		String duree = request.getParameter("duree");
		String realisateur = request.getParameter("realisateur");
                Date dt;
                try {
                dt = new Date(FormatDate.convertirDate(dateSortie).getTime());
            } catch (ParseException e) {
                System.out.println("Date en format YYYY-MM-DD attendue à la place  de \"" +
                  dateSortie + "\"");
            }
                update.gestionFilm.ajoutFilm(titre,dt,realisateur);//(titre,dateSortie,description,duree,realisateur);
                
	}

	// Dans les formulaire, on utilise la méthode POST
	// donc, si le servlet est appelé avec la méthode GET
	// on retourne un page d'erreur, afin de ne pas permettre
	// à l'utilisateur d'appeler un servler directement
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendError(response.SC_INTERNAL_SERVER_ERROR, "Accès
		// invalide");
		doPost(request, response);
	}
} // class