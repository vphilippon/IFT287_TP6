package tp6Servlet;

import javax.servlet.*;
import java.util.*;

/**
 * Classe pour gestion des sessions
 * Inspire de l'exemple de Marc Frappier
 */

public class Tp6ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Contexte demarre:"
                + sce.getServletContext().getServletContextName());
        System.out.println("Voici les parametres du contexte tels que definis dans web.xml");
        Enumeration<String> initParams = sce.getServletContext().getInitParameterNames();
        while (initParams.hasMoreElements()) {
            String name = (String) initParams.nextElement();
            System.out.println(name + ":"
                    + sce.getServletContext().getInitParameter(name));
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Le contexte de l'application GestionTp6 vient d'etre detruit.");
    }
}
