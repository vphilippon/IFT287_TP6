<%-- 
    Document   : supprimerPersonne
    Created on : 2013-04-10, 13:35:10
    Author     : Guilh
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
        <table>
            <form method="post" action="supprimerPersonne">
                <tr>
                    <td>
                        Nom : 
                    </td>
                    <td>

                        <input type="text" name="nom" required/>
                    </td>
                </tr>
                <tr>
                    <input type="sumbit" value="Supprimer la personne"/>
                </tr>
            </form>
        </table>
        
    </body>
</html>
