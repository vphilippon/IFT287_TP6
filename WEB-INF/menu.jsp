<%@ page import="java.util.*,java.text.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>IFT287 - Menu</title>
<meta HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1">
<meta NAME="author"
	CONTENT="Guillaume Harvey, Kevin Labrie, Mathieu Larocque, Vincent Philippon">
<meta NAME="description" CONTENT="Menu">
</head>
<body>
	<center>
		<h1>Menu</h1>
		<form ACTION="menu" METHOD="POST">
			<input id="demande" TYPE="hidden" NAME="demande" VALUE="menu" /> 
                        <input TYPE="SUBMIT" VALUE="Ajouter un film" onclick="document.getElementById('demande').value = 'ajouterFilm';" />
                        <input TYPE="SUBMIT" VALUE="Ajouter une description a un film" onclick="document.getElementById('demande').value = 'ajouterDescFilm';" />
                        <input TYPE="SUBMIT" VALUE="Ajouter une personne" onclick="document.getElementById('demande').value = 'ajouterPersonne';" />
                        <input TYPE="SUBMIT" VALUE="Ajouter un acteur dans un film" onclick="document.getElementById('demande').value = 'ajouterActeurFilm';" />
                        <input TYPE="SUBMIT" VALUE="Ajouter une serie" onclick="document.getElementById('demande').value = 'ajouterSerie';" />
                        <input TYPE="SUBMIT" VALUE="Ajouter un un episode dans une serie" onclick="document.getElementById('demande').value = 'ajouterEpisode';" />
                        <input TYPE="SUBMIT" VALUE="Ajouter un acteur dans un episode d'une serie" onclick="document.getElementById('demande').value = 'ajouterActeurSerie';"> /
                        <input TYPE="SUBMIT" VALUE="Supprimer un film" onclick="document.getElementById('demande').value = 'supprimerFilm';" />
                        <input TYPE="SUBMIT" VALUE="Supprimer une personne" onclick="document.getElementById('demande').value = 'supprimerPersonne';" />
                        <input TYPE="SUBMIT" VALUE="Lister les acteurs d'un film" onclick="document.getElementById('demande').value = 'listerActeurFilm';" /> 
                        <input TYPE="SUBMIT" VALUE="Lister les acteurs d'une serie" onclick="document.getElementById('demande').value = 'listerActeurSerie';" />
                        <input TYPE="SUBMIT" VALUE="Lister les series contenant un acteur" onclick="document.getElementById('demande').value = 'listerSerieActeur';" />
		</form>
	</center>
	<br>
	<%-- inclusion d'une autre page pour l'affichage des messages d'erreur--%>
	<jsp:include page="/WEB-INF/messageErreur.jsp" />
	<br>
	<%-- affichage de la date et heure; --%>
	<%-- utile pour débogger et verifier si la page a été --%>
	<%-- par le fureteur --%>
	Date et heure normale de l'est:
	<%=DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,
                    Locale.CANADA_FRENCH).format(new java.util.Date())%>
</body>
</html>
