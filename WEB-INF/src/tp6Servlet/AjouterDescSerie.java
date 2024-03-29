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
public class AjouterDescSerie extends HttpServlet {

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

                // conversion du parametre dateSortie en SQLDate
                Date date; // inialisation requise par compilateur Java
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
                    tp6Update.gestionSerie.ajoutDescSerie(titre, date, description);
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
