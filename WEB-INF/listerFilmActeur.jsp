<%-- 
    Document   : listerFilmActeur
    Created on : 2013-04-10, 14:20:45
--%>

<%@page import="java.util.*,java.text.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IFT287 - Lister les films d'un acteur</title>
</head>
<body>
	<h1>Lister les films d'un acteur</h1>
	<br />
	<form method="post" action="ListerFilmActeur">
		<table>
			<tr>
				<td>Nom de l'acteur* :</td>
				<td><input type="text" name="nomActeur" required /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="Lister les films de l'acteur" /></td>
			</tr>
		</table>
	</form>
	<form ACTION="Menu" METHOD="POST">
    <input TYPE="SUBMIT" VALUE="Retour">
  </form>
</body>
</html>
