package tp6Servlet;

import java.util.List;
import java.util.LinkedList;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import tp6.GestionTp6;
import tp6.Tp6Exception;

@SuppressWarnings("serial")
public class ListerFilmActeur extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer etat = (Integer) request.getSession().getAttribute("etat");
        if (etat == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {
            try {
                String nomActeur = request.getParameter("nomActeur");

                // executer la transaction
                GestionTp6 tp6Interrogation = (GestionTp6) request.getSession().getAttribute(
                        "tp6Interrogation");
                synchronized (tp6Interrogation) {
                    request.setAttribute(
                            "listeAfficher",
                            tp6Interrogation.gestionPersonne.afficherFilmDeActeur(nomActeur));
                }
                request.setAttribute("entete", "Voici la liste des films de l'acteur "
                        + nomActeur + " :");
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
