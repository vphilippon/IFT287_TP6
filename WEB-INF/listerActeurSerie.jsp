<%-- 
    Document   : listerActeurSerie
    Created on : 2013-04-10, 13:44:03
    Author     : guillaume
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IFT287 - Lister acteur serie</title>
    </head>
    <body>
        <h1>Lister acteur serie</h1>
        <br/>
        <table>
            <form method="post" action="listerActeurSerie">
                <tr>
                    <td>
                        Titre : 
                    </td>
                    <td>
                        <input type="text" name="titre" required/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Année de sortie :
                    </td>
                    <td>
                        <input type="text" name="anneeSortie" required/>
                    </td>
                </tr>
                <tr>
                    <input type="sumbit" value="Afficher la liste d'acteur"/>
                </tr>
            </form>
        </table>
        
    </body>
</html>
