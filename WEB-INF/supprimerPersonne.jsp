<%-- 
    Document   : supprimerPersonne
    Created on : 2013-04-10, 13:35:10
    Author     : guillaume
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IFT287 - Supprimer Personne</title>
    </head>
    <body>
        <h1>Supprimer personne</h1>
        <br/>
        <form method="post" action="supprimerPersonne">
            <table>
                <tr>
                    <td>
                        Nom* : 
                    </td>
                    <td>

                        <input type="text" name="nom" required />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Supprimer la personne" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
