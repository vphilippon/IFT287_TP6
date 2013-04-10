<%-- 
    Document   : ajouterFilm
    Created on : 2013-04-10, 13:10:57
    Author     : larm1303
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IFT287 - Ajouter film</title>
    </head>
    <body>
        <h1>Ajouter film</h1>
        <br/>
        <form method="post" action="AjouterFilm">
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
                    Date sortie* :
                </td>
                <td>
                    <input type="text" name="dateSortie" required />
                </td>
            </tr>
            <tr>
                <td>
                    Description :
                </td>
                <td>
                    <textarea name="description"></textarea>
                </td>
            </tr>            
            <tr>
                <td>
                    durée :
                </td>
                <td>
                    <input type="number" name="duree" />
                </td>
            </tr>
            <tr>
                <td>
                    R&eacute;alisateur* : 
                </td>
                <td>
                    <input type="text" name="realisateur" required />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Ajouter le film" />
                </td>
            </tr>
        </table>
        </form>
    </body>
</html>