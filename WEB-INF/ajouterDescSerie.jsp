<%-- 
    Document   : ajouterDescSerie
    Created on : 2013-04-10, 13:10:57
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IFT287 - Ajouter description a une serie</title>
</head>
<body>
	<h1>Ajouter la description a une série</h1>
	<br />
	<form method="post" action="AjouterDescSerie">
		<table>
			<tr>
				<td>Titre* :</td>
				<td><input type="text" name="titre" required /></td>
			</tr>
			<tr>
				<td>Date sortie* :</td>
				<td><input type="text" name="dateSortie" required /></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><textarea name="description"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="Ajouter la description a la serie" /></td>
			</tr>
		</table>
	</form>
	<form ACTION="Menu" METHOD="POST">
    <input TYPE="SUBMIT" VALUE="Retour">
  </form>
</body>
</html>