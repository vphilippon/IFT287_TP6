<%-- 
    Document   : ajouterActeurEpisode
    Created on : 2013-04-10, 13:51:25
    Author     : guillaume
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IFT287 - Ajouter acteur film</title>
    </head>
    <body>
        <h1>Ajouter acteur episode</h1>
        <br/>
        <form method="post" action="AjouterActeurEpisode">
        <table>
            <tr>
                <td>
                    Titre de la série* :
                </td>
                <td>
                    <input type="text" name="titre" required />
                </td>
            </tr>
            <tr>
                <td>
                    Date sortie du film* :
                </td>
                <td>
                    <input type="text" name="dateSortie" required />
                </td>
            </tr>
            <tr>
                <td>
                    nom de l'acteur* :
                </td>
                <td>
                    <input type="text" name="nom" required />
                </td>
            </tr>   
            <tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Ajouter l'acteur au film" />
                    </td>
                </td>
            </tr>
        </table>
        </form>
    </body>
</html>
