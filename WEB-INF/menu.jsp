<%@ page import="java.util.*,java.text.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>IFT287 - Syst&egrave;me de gestion de
	cin&eacute;math&egrave;que</title>
<meta HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1">
<meta NAME="author"
	CONTENT="Guillaume Harvey, Kevin Labrie, Mathieu Larocque, Vincent Philippon">
<meta NAME="description"
	CONTENT="page d'accueil syst�me de gestion de cin�math�que">
</head>
<body>
	<center>
		<h1>Syst&egrave;me de gestion de cin&eacute;math&egrave;que</h1>
		<form ACTION="Login" METHOD="POST">
			<br> <br> User Id : <input TYPE="TEXT" NAME="userIdBD" VALUE="postgres"> 
			<br> <br> Mot de passe : <input TYPE="TEXT" NAME="motDePasseBD" VALUE="ubuntu"> 
			<br> <br>	Serveur : 
			<select NAME="serveur">
				<option VALUE="postgres">postgres
			</select> 
			<br> <br> adresseIP : <input TYPE="TEXT" NAME="adresseIP"	VALUE="127.0.0.1"> 
			<br> <br> BD : <input	TYPE="TEXT" NAME="bd" VALUE="postgres"> 
			<br> <br>	<input TYPE="SUBMIT" VALUE="Soumettre">
		</form>
	</center>
	<br>
	<%-- inclusion d'une autre page pour l'affichage des messages d'erreur--%>
	<jsp:include page="/WEB-INF/messageErreur.jsp" />
	<br>
	<%-- affichage de la date et heure; --%>
	<%-- utile pour d�bogger et verifier si la page a �t� --%>
	<%-- par le fureteur --%>
	Date et heure normale de l'est:
	<%=DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,
                    Locale.CANADA_FRENCH).format(new java.util.Date())%>
</body>
</html>
