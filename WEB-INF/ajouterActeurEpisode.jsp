<%-- 
    Document   : ajouterActeurEpisode
    Created on : 2013-04-10, 13:51:25
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IFT287 - Ajouter un acteur a un episode</title>
</head>
<body>
	<h1>Ajouter un acteur a un episode</h1>
	<br />
	<form method="post" action="AjouterActeurEpisode">
		<table>
			<tr>
				<td>Nom de l'acteur* :</td>
				<td><input type="text" name="nomActeur" required /></td>
			</tr>
			<tr>
				<td>Role de l'acteur :</td>
				<td><input type="text" name="roleActeur" /></td>
			</tr>
			<tr>
				<td>Titre de la série* :</td>
				<td><input type="text" name="titreSerie" required /></td>
			</tr>
			<tr>
				<td>Numéro de la saison* :</td>
				<td><input type="text" name="numeroSaison" required /></td>
			</tr>
			<tr>
				<td>Date de sortie de la série* :</td>
				<td><input type="text" name="dateSortieSerie" required /></td>
			</tr>
			<tr>
				<td>Numéro de l'épisode* :</td>
				<td><input type="text" name="numeroEpisode" required /></td>
			</tr>
			<tr>
			<tr>
				<td colspan="2"><input type="submit" value="Ajouter l'acteur à l'episode" /></td>
			</tr>
		</table>
	</form>
	<form ACTION="Menu" METHOD="POST">
    <input TYPE="SUBMIT" VALUE="Retour">
  </form>
</body>
</html>
