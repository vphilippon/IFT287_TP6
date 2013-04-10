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
            System.out.println("BLAH");
            if(demande.equals("ajouterFilm")){
                System.out.println("Demande = ajouterFilm");
                // afficher le menu en appelant la page menu.jsp
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterFilm.jsp");
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
