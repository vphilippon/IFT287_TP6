<%-- 
    Document   : ajouterActeurFilm
    Created on : 2013-04-10, 13:10:57
    Author     : larm1303
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IFT287 - Ajouter acteur film</title>
    </head>
    <body>
        <h1>Ajouter acteur film</h1>
        <br/>
        <form method="post" action="ajouterFilm">
        <table>
            <tr>
                <td>
                    Titre du film* :
                </td>
                <td>
                    <input type="text" name="titre" />
                </td>
            </tr>
            <tr>
                <td>
                    Date sortie du film* :
                </td>
                <td>
                    <input type="text" name="dateSortie" />
                </td>
            </tr>
            <tr>
                <td>
                    nom de l'acteur* :
                </td>
                <td>
                    <input type="text" name="nom" />
                </td>
            </tr>   
            <tr>
                <td colspan="2">
                    <input type="submit" value="Ajouter l'acteur au film" />
                </td>
            </tr>
        </table>
        </form>
    </body>
</html>