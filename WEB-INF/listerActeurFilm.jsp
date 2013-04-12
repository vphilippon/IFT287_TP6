<%-- 
    Document   : listerActeurFilm
    Created on : 2013-04-10, 13:44:03
--%>

<%@page import="java.util.*,java.text.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IFT287 - Lister les acteurs d'un film</title>
</head>
<body>
	<h1>Lister les acteurs d'un film</h1>
	<br />
	<form method="post" action="ListerActeurFilm">
		<table>
			<tr>
				<td>Titre du film* :</td>
				<td><input type="text" name="titre" required /></td>
			</tr>
			<tr>
				<td>Année de sortie du film* :</td>
				<td><input type="text" name="anneeSortie" required /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="Afficher la liste des acteurs du film" /></td>
			</tr>
		</table>
	</form>
	<form ACTION="Menu" METHOD="POST">
    <input TYPE="SUBMIT" VALUE="Retour">
  </form>
</body>
</html>
