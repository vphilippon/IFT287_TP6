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
public class ListerActeurSerie extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer etat = (Integer) request.getSession().getAttribute("etat");
        if (etat == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {
            try {
                String titre = request.getParameter("titre");
                String anneeSortie = request.getParameter("anneeSortie");

                Date date;
                try {
                    date = new Date(FormatDate.convertirDate(anneeSortie).getTime());
                } catch (ParseException e) {
                    throw new Tp6Exception("Format de la date " + anneeSortie
                            + " incorrect. AAAA-MM-JJ attendue.");
                }
                // executer la transaction
                GestionTp6 tp6Interrogation = (GestionTp6) request.getSession().getAttribute(
                        "tp6Interrogation");
                synchronized (tp6Interrogation) {
                    request.setAttribute("listeAfficher",
                            tp6Interrogation.gestionSerie.afficherActeursSerie(titre,
                                    date));
                }
                request.setAttribute("entete", "Voici la liste des acteurs de la série "
                        + titre + " paru le " + date + " :");
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
}
