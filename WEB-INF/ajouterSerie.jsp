<%-- 
    Document   : ajouterSerie
    Created on : 2013-04-10, 13:35:10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IFT287 - Ajouter une serie</title>
</head>
<body>
	<h1>Ajouter une serie</h1>
	<br />
	<form method="post" action="AjouterSerie">
		<table>
			<tr>
				<td>Titre* :</td>
				<td><input type="text" name="titre" required /></td>
			</tr>
			<tr>
				<td>Année de sortie* :</td>
				<td><input type="text" name="anneeSortie" required /></td>
			</tr>
			<tr>
				<td>Réalisateur* :</td>
				<td><input type="text" name="realisateur" required /></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td>Nombre de saison :</td>
				<td><input type="text" name="nbSaison" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Ajouter la série" />
				</td>
			</tr>
		</table>
	</form>
	<form ACTION="Menu" METHOD="POST">
    <input TYPE="SUBMIT" VALUE="Retour">
  </form>
</body>
</html>
