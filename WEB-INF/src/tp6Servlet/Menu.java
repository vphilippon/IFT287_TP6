package tp6Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Classe pour login systeme de gestion de cinematheque
 * Inspire de l'exemple de Marc Frappier
 */

@SuppressWarnings("serial")
public class Menu extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String demande = request.getParameter("demande");
            if (demande.equals("ajouterFilm")) {
                System.out.println("Demande = ajouterFilm");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterFilm.jsp");
                dispatcher.forward(request, response);
            } else if (demande.equals("ajouterDescFilm")) {
                System.out.println("Demande = ajouterDescFilm");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterDescFilm.jsp");
                dispatcher.forward(request, response);
            } else if (demande.equals("ajouterPersonne")) {
                System.out.println("Demande = ajouterPersonne");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterPersonne.jsp");
                dispatcher.forward(request, response);
            } else if (demande.equals("ajouterActeurFilm")) {
                System.out.println("Demande = ajouterActeurFilm");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterActeurFilm.jsp");
                dispatcher.forward(request, response);
            } else if (demande.equals("ajouterSerie")) {
                System.out.println("Demande = ajouterSerie");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterSerie.jsp");
                dispatcher.forward(request, response);
            } else if (demande.equals("ajouterDescSerie")) {
                System.out.println("Demande = ajouterDescSerie");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterDescSerie.jsp");
                dispatcher.forward(request, response);
            } else if (demande.equals("ajouterEpisode")) {
                System.out.println("Demande = ajouterEpisode");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterEpisode.jsp");
                dispatcher.forward(request, response);
            } else if (demande.equals("AjouterActeurEpisode")) {
                System.out.println("Demande = AjouterActeurEpisode");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterActeurEpisode.jsp");
                dispatcher.forward(request, response);
            } else if (demande.equals("supprimerFilm")) {
                System.out.println("Demande = supprimerFilm");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/supprimerFilm.jsp");
                dispatcher.forward(request, response);
            } else if (demande.equals("supprimerPersonne")) {
                System.out.println("Demande = supprimerPersonne");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/supprimerPersonne.jsp");
                dispatcher.forward(request, response);
            } else if (demande.equals("listerActeurFilm")) {
                System.out.println("Demande = listerActeurFilm");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listerActeurFilm.jsp");
                dispatcher.forward(request, response);
            } else if (demande.equals("listerActeurSerie")) {
                System.out.println("Demande = listerActeurSerie");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listerActeurSerie.jsp");
                dispatcher.forward(request, response);
            } else if (demande.equals("listerSerieActeur")) {
                System.out.println("Demande = listerSerieActeur");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listerSerieActeur.jsp");
                dispatcher.forward(request, response);
            } else if (demande.equals("listerFilmActeur")) {
                System.out.println("Demande = listerFilmActeur");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listerFilmActeur.jsp");
                dispatcher.forward(request, response);
            } else if (demande.equals("listerRealisateur")) {
                System.out.println("Demande = listerRealisateur");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ListerRealisateur.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
        }
    }

    // doGet appel doPost
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

} // class
