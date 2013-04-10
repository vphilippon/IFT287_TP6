<%-- 
    Document   : ajouterPersonne
    Created on : 2013-04-10, 12:54:10
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IFT287 - Ajouter Personne</title>
    </head>
    <body>
        <h1>Ajouter personne</h1>
        <br/>
        <form method="post" action="AjouterPersonne">
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
                    <td>
                        Date naissance* :
                    </td>
                    <td>
                        <input type="text" name="dateNaissance" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        Lieu naissance : 
                    </td>
                    <td>
                        <input type="text" name="lieuNaissance" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Sexe* :
                    </td>
                    <td>
                        <input type="text" name="sexe" required />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Ajouter la personne" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
