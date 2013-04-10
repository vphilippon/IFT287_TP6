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
        <table>
            <form method="post" action="ajouterPersonne">
                <tr>
                    <td>
                        Nom : 
                    </td>
                    <td>

                        <input type="text" name="nom" required/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Date naissance :
                    </td>
                    <td>
                        <input type="text" name="dateNaissance" required/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Lieu naissance : 
                    </td>
                    <td>
                        <input type="text" name="lieuNaissance"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Sexe :
                    </td>
                    <td>
                        <input type="text" name="sexe" required/>
                    </td>
                </tr>
                <tr>
                    <input type="sumbit" value="Ajouter la personne"/>
                </tr>
            </form>
        </table>
        
    </body>
</html>
