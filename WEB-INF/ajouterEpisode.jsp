<%-- 
    Document   : ajouterEpisode
    Created on : 2013-04-10, 13:10:57
    Author     : larm1303
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IFT287 - Ajouter Episode</title>
    </head>
    <body>
        <h1>Ajouter Episode</h1>
        <br/>
        <form method="post" action="ajouterEpisode">
        <table>
            <tr>
                <td>
                    Titre de l'&eacute;pisode* :
                </td>
                <td>
                    <input type="text" name="titreEpisode" />
                </td>
            </tr>
            <tr>
                <td>
                    Titre de la s&eacute;rie* :
                </td>
                <td>
                    <input type="text" name="titreSerie" />
                </td>
            </tr>
            <tr>
                <td>
                    Date serie* :
                </td>
                <td>
                    <input type="text" name="dateSerie" />
                </td>
            </tr>
            <tr>
                <td>
                    Num&eacute;ro de la saison* :
                </td>
                <td>
                    <input type="text" name="noSaison" />
                </td>
            </tr>
            <tr>
                <td>
                    Num&eacute;ro de l'&eacute;pisode* :
                </td>
                <td>
                    <input type="text" name="noEpisode" />
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
                    Date de l'&eacute;pisode* :
                </td>
                <td>
                    <input type="text" name="dateEpisode" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Ajouter l'&eacute;pisode" />
                </td>
            </tr>
        </table>
        </form>
    </body>
</html>