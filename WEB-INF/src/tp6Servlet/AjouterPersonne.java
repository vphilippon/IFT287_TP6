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
public class AjouterPersonne extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer etat = (Integer) request.getSession().getAttribute("etat");
        if (etat == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {
            try {
                String nom = request.getParameter("nom");
                String dateNaissance = request.getParameter("dateNaissance");
                String lieuNaissance = request.getParameter("lieuNaissance");
                String sexe = request.getParameter("sexe");
                // conversion du parametre dureeFilm en entier
                int s = -1; // inialisation requise par compilateur Java
                try {
                    s = Integer.parseInt(sexe);
                } catch (NumberFormatException e) {
                    throw new Tp6Exception("Format du sexe " + sexe
                            + " incorrect. (0 = gars, 1 = fille)");
                }
                // conversion du parametre dateSortie en SQLDate
                Date date;
                try {
                    date = new Date(FormatDate.convertirDate(dateNaissance).getTime());
                } catch (ParseException e) {
                    throw new Tp6Exception("Format de la date " + dateNaissance
                            + " incorrect. AAAA-MM-JJ attendue.");
                }
                // exécuter la transaction
                GestionTp6 tp6Update = (GestionTp6) request.getSession().getAttribute(
                        "tp6Update");
                synchronized (tp6Update) {
                    tp6Update.gestionPersonne.ajoutPersonne(nom, date, lieuNaissance, s);
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
