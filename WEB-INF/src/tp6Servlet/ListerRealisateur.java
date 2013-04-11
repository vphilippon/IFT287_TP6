package tp6Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import tp6.GestionTp6;

@SuppressWarnings("serial")
public class ListerRealisateur extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer etat = (Integer) request.getSession().getAttribute("etat");
        if (etat == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {
            try {
                // executer la transaction
                GestionTp6 tp6Interrogation = (GestionTp6) request.getSession().getAttribute(
                        "tp6Interrogation");
                synchronized (tp6Interrogation) {
                    request.setAttribute("listeAfficher",
                            tp6Interrogation.gestionPersonne.afficherRealisateur());
                }
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
