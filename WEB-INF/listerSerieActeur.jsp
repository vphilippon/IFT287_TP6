<%-- 
    Document   : listerSerieActeur
    Created on : 2013-04-10, 13:44:03
--%>

<%@page import="java.util.*,java.text.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IFT287 - Lister acteur serie</title>
    </head>
    <body>
        <h1>Lister les series de l'acteur</h1>
        <br/>
        <form method="post" action="ListerSerieActeur">
            <table>
                    <tr>
                        <td>
                            Nom de l'acteur* : 
                        </td>
                        <td>
                            <input type="text" name="nom" required />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Afficher les series avec l'acteur"/>
                        </td>
                    </tr>
            </table>        
        </form>
        
        <%
          // affichage de la liste des messages d'erreur
          if (request.getAttribute("listeSerie") != null)
            {
        %>
            Liste des series :
            <span>
        <%
            ListIterator it = ((List) request.getAttribute("listeSerie")).listIterator();
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
