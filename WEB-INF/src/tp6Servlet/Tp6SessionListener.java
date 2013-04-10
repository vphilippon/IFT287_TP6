package tp6Servlet;

import javax.servlet.http.*;

import tp6.GestionTp6;

import java.sql.*;

/**
 * Classe pour gestion des sessions
 * Inspire de l'exemple de Marc Frappier
 */

public class Tp6SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session Tp6 cree : " + se.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Tp6SessionListener " + se.getSession().getId());
        GestionTp6 tp6Interrogation = (GestionTp6) se.getSession().getAttribute(
                "tp6Interrogation");
        if (tp6Interrogation != null) {
            System.out.println("connexion =" + tp6Interrogation.cx);
            try {
                tp6Interrogation.fermer();
            } catch (SQLException e) {
                System.out.println("Impossible de fermer la connexion");
                e.printStackTrace();
            }
        } else
            System.out.println("cinematheque (tp6) inaccessible.");
        GestionTp6 tp6Update = (GestionTp6) se.getSession().getAttribute("tp6Update");
        if (tp6Update != null) {
            System.out.println("connexion =" + tp6Update.cx);
            try {
                tp6Update.fermer();
            } catch (SQLException e) {
                System.out.println("Impossible de fermer la connexion");
                e.printStackTrace();
            }
        } else
            System.out.println("cinematheque (tp6) inaccessible.");
    }
}
