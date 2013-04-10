<%-- 
    Document   : listerFilmActeur
    Created on : 2013-04-10, 14:20:45
    Author     : guillaume
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lister film acteur/h1>
        <br/>
        <form method="post" action="ListerFilmActeur">
            <table>
                <tr>
                    <td>
                        Nom de l'acteur* : 
                    </td>
                    <td>
                        <input type="text" name="nomActeur" required />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Lister les films de l'acteur" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
