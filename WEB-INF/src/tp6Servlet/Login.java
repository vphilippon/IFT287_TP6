package tp6Servlet;

import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import tp6.GestionTp6;
import tp6.Tp6Exception;

/*
 * Projet : Tp6
 *
 * Membres :
 * - Guillaume Harvey 12 059 595
 * - Kevin Labrie 12 113 777
 * - Vincent Philippon 12 098 838
 * - Mathieu Larocque 10 129 032
 * 
 */

/**
 * Classe pour login systeme de gestion de cinematheque
 * Inspire de l'exemple de Marc Frappier
 */

@SuppressWarnings("serial")
public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("etat") != null) {
                System.out.println("GestionTp6: session deja cree; id=" + session.getId());
                session.invalidate();
                session = request.getSession();
                System.out.println("GestionTp6: session invalidee");
            }

            // lecture des parametres du formulaire login.jsp
            String userId = request.getParameter("userIdBD");
            String motDePasse = request.getParameter("motDePasseBD");
            String serveur = request.getParameter("serveur");
            String adresseIP = request.getParameter("adresseIP");
            String bd = "//" + adresseIP + "/" + request.getParameter("bd");

            /*
             * Ouvrir une connexion avec la BD et creer les gestionnaires et
             * stocker dans la session. 
             */
            System.out.println("Adresse : " + adresseIP);
            System.out.println("Login: session id=" + session.getId());
            GestionTp6 tp6Interrogation = new GestionTp6(serveur, bd, userId, motDePasse);
            tp6Interrogation.cx.setIsolationReadCommited();
            session.setAttribute("tp6Interrogation", tp6Interrogation);
            GestionTp6 tp6Update = new GestionTp6(serveur, bd, userId, motDePasse);
            session.setAttribute("tp6Update", tp6Update);

            // afficher le menu en appelant la page menu.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/menu.jsp");
            dispatcher.forward(request, response);
            session.setAttribute("etat", new Integer(Tp6Constantes.CONNECTE));
        } catch (SQLException e) {
            List<String> listeMessageErreur = new LinkedList<String>();
            listeMessageErreur.add("Erreur de connexion au serveur");
            listeMessageErreur.add(e.toString());
            request.setAttribute("listeMessageErreur", listeMessageErreur);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            e.printStackTrace();
        } catch (Tp6Exception e) {
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
