<%-- 
    Document   : supprimerPersonne
    Created on : 2013-04-10, 13:35:10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IFT287 - Supprimer une personne</title>
</head>
<body>
	<h1>Supprimer une personne</h1>
	<br />
	<form method="post" action="SupprimerPersonne">
		<table>
			<tr>
				<td>Nom* :</td>
				<td><input type="text" name="nom" required /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Supprimer la personne" /></td>
			</tr>
		</table>
	</form>
	<form ACTION="Menu" METHOD="POST">
    <input TYPE="SUBMIT" VALUE="Retour">
  </form>
</body>
</html>
