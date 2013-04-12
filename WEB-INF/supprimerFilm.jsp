<%-- 
    Document   : supprimerFilm
    Created on : 2013-04-10, 13:10:57
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IFT287 - Supprimer un film</title>
</head>
<body>
	<h1>Supprimer un film</h1>
	<br />
	<form method="post" action="SupprimerFilm">
		<table>
			<tr>
				<td>Titre* :</td>
				<td><input type="text" name="titre" required /></td>
			</tr>
			<tr>
				<td>Date de sortie* :</td>
				<td><input type="text" name="dateSortie" required /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Supprimer le film" />
				</td>
			</tr>
		</table>
	</form>
	<form ACTION="Menu" METHOD="POST">
    <input TYPE="SUBMIT" VALUE="Retour">
  </form>
</body>
</html>