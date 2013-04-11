<%-- 
    Document   : listerActeurSerie
    Created on : 2013-04-10, 13:44:03
    Author     : guillaume
--%>

<%@page import="java.util.*,java.text.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IFT287 - Lister acteur serie</title>
    </head>
    <body>
        <h1>Lister acteur serie</h1>
        <br/>
        <form method="post" action="ListerActeurSerie">
            <table>
                <tr>
                    <td>
                        Titre* : 
                    </td>
                    <td>
                        <input type="text" name="titre" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        Année de sortie* :
                    </td>
                    <td>
                        <input type="text" name="anneeSortie" required />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Afficher la liste d'acteur" />
                    </td>
                </tr>
            </table>
        </form>  
                
        <%
          // affichage de la liste des messages d'erreur
          if (request.getAttribute("listeActeur") != null)
            {
        %>
            Liste des acteurs :
            <span>
        <%
            ListIterator it = ((List) request.getAttribute("listeActeur")).listIterator();
            while (it.hasNext())
              {
        %>
              <BR>
              <%= it.next() %>
        <%
              }
        %>
            </span>
        <%
            }
        %>

    </body>
</html>
