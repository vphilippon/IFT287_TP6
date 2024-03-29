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
public class AjouterActeurEpisode extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer etat = (Integer) request.getSession().getAttribute("etat");
        if (etat == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {
            try {
                String nomActeur = request.getParameter("nomActeur");
                String roleActeur = request.getParameter("roleActeur");
                String titreSerie = request.getParameter("titreSerie");
                String numeroSaison = request.getParameter("numeroSaison");
                String dateSortieSerie = request.getParameter("dateSortieSerie");
                String numeroEpisode = request.getParameter("numeroEpisode");
                // conversion du parametre dateSortie en SQLDate
                Date dateS;
                try {
                    dateS = new Date(FormatDate.convertirDate(dateSortieSerie).getTime());
                } catch (ParseException e) {
                    throw new Tp6Exception("Format de la date " + dateSortieSerie
                            + " incorrect. AAAA-MM-JJ attendue.");
                }
                int nSaison = 0;
                try {
                    nSaison = Integer.parseInt(numeroSaison);
                } catch (NumberFormatException e) {
                    throw new Tp6Exception("Format de saison " + numeroSaison
                            + " incorrect. Entier attendu");
                }
                int nEpisode = 0;
                try {
                    nEpisode = Integer.parseInt(numeroEpisode);
                } catch (NumberFormatException e) {
                    throw new Tp6Exception("Format d'épisode " + numeroEpisode
                            + " incorrect. Entier attendu");
                }
                // executer la transaction
                GestionTp6 tp6Update = (GestionTp6) request.getSession().getAttribute(
                        "tp6Update");
                synchronized (tp6Update) {
                    tp6Update.gestionSerie.ajoutRoleAEpisode(titreSerie, dateS, nSaison,
                            nEpisode, nomActeur, roleActeur);
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
        doPost(request, response);
    }
} // class
