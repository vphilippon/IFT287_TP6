<%-- 
    Document   : listerSerieActeur
    Created on : 2013-04-10, 13:44:03
--%>

<%@page import="java.util.*,java.text.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IFT287 - Lister les series d'un acteur</title>
</head>
<body>
	<h1>Lister les series d'un acteur</h1>
	<br />
	<form method="post" action="ListerSerieActeur">
		<table>
			<tr>
				<td>Nom de l'acteur* :</td>
				<td><input type="text" name="nom" required /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="Afficher les series avec l'acteur" /></td>
			</tr>
		</table>
	</form>
	<form ACTION="Menu" METHOD="POST">
    <input TYPE="SUBMIT" VALUE="Retour">
  </form>
</body>
</html>
