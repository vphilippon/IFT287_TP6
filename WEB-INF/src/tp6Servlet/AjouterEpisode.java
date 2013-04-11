package tp6Servlet;

import java.util.List;
import java.util.LinkedList;
import java.sql.*;
import java.io.*;
import java.text.ParseException;
import javax.servlet.*;
import javax.servlet.http.*;

import tp6.FormatDate;
import tp6.GestionTp6;
import tp6.Tp6Exception;

@SuppressWarnings("serial")
public class AjouterEpisode extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer etat = (Integer) request.getSession().getAttribute("etat");
        if (etat == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {
            try {
                String titreEpisode = request.getParameter("titreEpisode");
                String titreSerie = request.getParameter("titreSerie");
                String dateSerie = request.getParameter("dateSerie");
                String noSaison = request.getParameter("noSaison");
                String noEpisode = request.getParameter("noEpisode");
                String description = request.getParameter("description");
                String dateEpisode = request.getParameter("dateEpisode");
                // conversion du parametre dateSortie en SQLDate
                Date dateS; // inialisation requise par compilateur Java
                try {
                    dateS = new Date(FormatDate.convertirDate(dateSerie).getTime());
                } catch (ParseException e) {
                    throw new Tp6Exception("Format de la date " + dateSerie
                            + " incorrect. AAAA-MM-JJ attendue.");
                }
                Date dateE; // inialisation requise par compilateur Java
                try {
                    dateE = new Date(FormatDate.convertirDate(dateEpisode).getTime());
                } catch (ParseException e) {
                    throw new Tp6Exception("Format de la date " + dateEpisode
                            + " incorrect. AAAA-MM-JJ attendue.");
                }
                int nSaison=0;//cause une erreur si non initialisé.
                try {
                    nSaison = Integer.parseInt(noSaison);
                } catch (NumberFormatException e) {
                    throw new Tp6Exception("Format de saison " + noSaison
                            + " incorrect. Entier attendu");
                }
                int nEpisode=0;//cause une erreur si non initialisé.
                try {
                    nEpisode = Integer.parseInt(noEpisode);
                } catch (NumberFormatException e) {
                    throw new Tp6Exception("Format d'épisode " + noEpisode
                            + " incorrect. Entier attendu");
                }
                // exécuter la transaction
                GestionTp6 tp6Update = (GestionTp6) request.getSession().getAttribute(
                        "tp6Update");
                synchronized (tp6Update) {
                    tp6Update.gestionSerie.ajoutEpisode(titreEpisode, titreSerie, dateS, nSaison, nEpisode, description, dateE);
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/menu.jsp");
                dispatcher.forward(request, response);
            } catch (Tp6Exception e) {
                List<String> listeMessageErreur = new LinkedList<String>();
                listeMessageErreur.add(e.toString());
                request.setAttribute("listeMessageErreur", listeMessageErreur);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/menu.jsp");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                        e.toString());
            }
        }
    }

    // Appel doPost
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // response.sendError(response.SC_INTERNAL_SERVER_ERROR, "Accès
        // invalide");
        doPost(request, response);
    }
} // class
