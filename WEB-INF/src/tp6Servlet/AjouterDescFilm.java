package tp6Servlet;

import java.util.List;
import java.util.LinkedList;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import tp6.FormatDate;
import tp6.GestionTp6;
import tp6.Tp6Exception;

@SuppressWarnings("serial")
public class AjouterDescFilm extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer etat = (Integer) request.getSession().getAttribute("etat");
        if (etat == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {
            try {
                String titre = request.getParameter("titre");
                String dateSortie = request.getParameter("dateSortie");
                String description = request.getParameter("description");
                String duree = request.getParameter("duree");

                // conversion du parametre dureeFilm en entier
                int dureeFilm;
                try {
                    dureeFilm = Integer.parseInt(duree);
                } catch (NumberFormatException e) {
                    throw new Tp6Exception("Format de la duree " + duree + " incorrect.");
                }
                // conversion du parametre dateSortie en SQLDate
                Date date;
                try {
                    date = new Date(FormatDate.convertirDate(dateSortie).getTime());
                } catch (NumberFormatException e) {
                    throw new Tp6Exception("Format de la date " + dateSortie
                            + " incorrect.");
                }
                // exécuter la transaction
                GestionTp6 tp6Update = (GestionTp6) request.getSession().getAttribute(
                        "tp6Update");
                synchronized (tp6Update) {
                    tp6Update.gestionFilm.ajoutDescFilm(titre, date, description,
                            dureeFilm);
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

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
} // class
