package tp6Servlet;

import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import tp6.GestionTp6;
import tp6.Tp6Exception;

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
            if(demande.equals("ajouterFilm")){
                System.out.println("Demande = ajouterFilm");
                // afficher le menu en appelant la page menu.jsp
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterFilm.jsp");
                dispatcher.forward(request, response);
            }
            else if(demande.equals("ajouterDescFilm")){
                    System.out.println("Demande = ajouterDescFilm");
                    // afficher le menu en appelant la page menu.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterDescFilm.jsp");
                    dispatcher.forward(request, response);
            }
            else if(demande.equals("ajouterPersonne")){
                    System.out.println("Demande = ajouterPersonne");
                    // afficher le menu en appelant la page menu.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterPersonne.jsp");
                    dispatcher.forward(request, response);
            }
            else if(demande.equals("ajouterActeurFilm")){
                    System.out.println("Demande = ajouterActeurFilm");
                    // afficher le menu en appelant la page menu.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterActeurFilm.jsp");
                    dispatcher.forward(request, response);
            }
            else if(demande.equals("ajouterSerie")){
                    System.out.println("Demande = ajouterSerie");
                    // afficher le menu en appelant la page menu.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterSerie.jsp");
                    dispatcher.forward(request, response);
            }
            else if(demande.equals("ajouterEpisode")){
                    System.out.println("Demande = ajouterEpisode");
                    // afficher le menu en appelant la page menu.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterEpisode.jsp");
                    dispatcher.forward(request, response);
            }
            else if(demande.equals("ajouterActeurSerie")){
                    System.out.println("Demande = ajouterActeurSerie");
                    // afficher le menu en appelant la page menu.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterActeurSerie.jsp");
                    dispatcher.forward(request, response);
            }
            else if(demande.equals("supprimerFilm")){
                    System.out.println("Demande = supprimerFilm");
                    // afficher le menu en appelant la page menu.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/supprimerFilm.jsp");
                    dispatcher.forward(request, response);
            }
            else if(demande.equals("supprimerPersonne")){
                    System.out.println("Demande = supprimerPersonne");
                    // afficher le menu en appelant la page menu.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/supprimerPersonne.jsp");
                    dispatcher.forward(request, response);
            }
            else if(demande.equals("listerActeurFilm")){
                    System.out.println("Demande = listerActeurFilm");
                    // afficher le menu en appelant la page menu.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listerActeurFilm.jsp");
                    dispatcher.forward(request, response);
            }
            else if(demande.equals("listerActeurSerie")){
                    System.out.println("Demande = listerActeurSerie");
                    // afficher le menu en appelant la page menu.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listerActeurSerie.jsp");
                    dispatcher.forward(request, response);
            }
            else if(demande.equals("listerSerieActeur")){
                    System.out.println("Demande = listerSerieActeur");
                    // afficher le menu en appelant la page menu.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listerSerieActeur.jsp");
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
