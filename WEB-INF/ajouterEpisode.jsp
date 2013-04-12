<%-- 
    Document   : ajouterEpisode
    Created on : 2013-04-10, 13:10:57
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IFT287 - Ajouter un episode</title>
</head>
<body>
	<h1>Ajouter un episode</h1>
	<br />
	<form method="post" action="AjouterEpisode">
		<table>
			<tr>
				<td>Titre de l'&eacute;pisode* :</td>
				<td><input type="text" name="titreEpisode" required /></td>
			</tr>
			<tr>
				<td>Titre de la s&eacute;rie* :</td>
				<td><input type="text" name="titreSerie" required /></td>
			</tr>
			<tr>
				<td>Date serie* :</td>
				<td><input type="text" name="dateSerie" required /></td>
			</tr>
			<tr>
				<td>Num&eacute;ro de la saison* :</td>
				<td><input type="text" name="noSaison" required /></td>
			</tr>
			<tr>
				<td>Num&eacute;ro de l'&eacute;pisode* :</td>
				<td><input type="text" name="noEpisode" required /></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><textarea name="description"></textarea></td>
			</tr>
			<tr>
				<td>Date de l'&eacute;pisode* :</td>
				<td><input type="text" name="dateEpisode" required /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="Ajouter l'&eacute;pisode" /></td>
			</tr>
		</table>
	</form>
	<form ACTION="Menu" METHOD="POST">
    <input TYPE="SUBMIT" VALUE="Retour">
  </form>
</body>
</html>