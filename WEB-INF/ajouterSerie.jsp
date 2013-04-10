<%-- 
    Document   : ajouterSerie
    Created on : 2013-04-10, 13:35:10
    Author     : guillaume
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IFT287 - Ajouter Serie</title>
    </head>
    <body>
        <h1>Ajouter Serie</h1>
        <br/>
        <form method="post" action="AjouterSerie">
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
                    <td>
                        Réalisateur* : 
                    </td>
                    <td>
                        <input type="text" name="realisateur" required />
                    </td>
                </tr>
                 <tr>
                    <td>
                        Description :
                    </td>
                    <td>
                        <input type="text" name="description" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Nombre de saison :
                    </td>
                    <td>
                        <input type="text" name="nbSaison" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Ajouter la série" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
