<%-- 
    Document   : listerActeurFilm
    Created on : 2013-04-10, 13:44:03
    Author     : larm1303
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IFT287 - Lister acteur film</title>
    </head>
    <body>
        <h1>Lister les acteurs du film</h1>
        <br/>
        <table>
            <form method="post" action="listerActeurSerie">
                <tr>
                    <td>
                        Titre du film : 
                    </td>
                    <td>
                        <input type="text" name="titre" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        Année de sortie du film :
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
            </form>
        </table>
        
    </body>
</html>
