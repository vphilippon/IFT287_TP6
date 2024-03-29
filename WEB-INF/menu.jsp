<%@ page import="java.util.*,java.text.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>IFT287 - Menu</title>
<meta HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
<meta NAME="author"
	CONTENT="Guillaume Harvey, Kevin Labrie, Mathieu Larocque, Vincent Philippon">
<meta NAME="description" CONTENT="Menu">
</head>
<body>
	<center>
		<h1>Menu</h1>
		<form ACTION="Menu" METHOD="POST">
			<input id="demande" TYPE="hidden" NAME="demande" VALUE="menu" /> 
			<input TYPE="SUBMIT" VALUE="Ajouter un film"
				onclick="document.getElementById('demande').value = 'ajouterFilm';" /><br />
			<input TYPE="SUBMIT" VALUE="Ajouter une description a un film"
				onclick="document.getElementById('demande').value = 'ajouterDescFilm';" /><br />
			<input TYPE="SUBMIT" VALUE="Ajouter une personne"
				onclick="document.getElementById('demande').value = 'ajouterPersonne';" /><br />
			<input TYPE="SUBMIT" VALUE="Ajouter un acteur dans un film"
				onclick="document.getElementById('demande').value = 'ajouterActeurFilm';" /><br />
			<input TYPE="SUBMIT" VALUE="Ajouter une serie"
				onclick="document.getElementById('demande').value = 'ajouterSerie';" /><br />
			<input TYPE="SUBMIT" VALUE="Ajouter une description a une serie"
				onclick="document.getElementById('demande').value = 'ajouterDescSerie';" /><br />
			<input TYPE="SUBMIT" VALUE="Ajouter un episode dans une serie"
				onclick="document.getElementById('demande').value = 'ajouterEpisode';" /><br />
			<input TYPE="SUBMIT" VALUE="Ajouter un acteur dans un episode"
				onclick="document.getElementById('demande').value = 'AjouterActeurEpisode';" /><br />
			<input TYPE="SUBMIT" VALUE="Supprimer un film"
				onclick="document.getElementById('demande').value = 'supprimerFilm';" /><br />
			<input TYPE="SUBMIT" VALUE="Supprimer une personne"
				onclick="document.getElementById('demande').value = 'supprimerPersonne';" /><br />
			<input TYPE="SUBMIT" VALUE="Lister les realisateurs"
				onclick="document.getElementById('demande').value = 'listerRealisateur';" /><br />
			<input TYPE="SUBMIT" VALUE="Lister les acteurs d'un film"
				onclick="document.getElementById('demande').value = 'listerActeurFilm';" /><br /> 
			<input TYPE="SUBMIT" VALUE="Lister les films d'un acteur"
				onclick="document.getElementById('demande').value = 'listerFilmActeur';" /><br />
			<input TYPE="SUBMIT" VALUE="Lister les acteurs d'une serie"
				onclick="document.getElementById('demande').value = 'listerActeurSerie';" /><br />
			<input TYPE="SUBMIT" VALUE="Lister les series d'un acteur"
				onclick="document.getElementById('demande').value = 'listerSerieActeur';" /><br />
		</form>
	</center>
	<br />
	<%-- inclusion d'une autre page pour l'affichage des "Lister"--%>
	<jsp:include page="/WEB-INF/lister.jsp" />
	<%-- inclusion d'une autre page pour l'affichage des messages d'erreur--%>
	<jsp:include page="/WEB-INF/messageErreur.jsp" />
	<br />
	<%-- affichage de la date et heure; --%>
	<%-- utile pour débogger et verifier si la page a été --%>
	<%-- par le fureteur --%>
	Date et heure normale de l'est:
	<%=DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,
                    Locale.CANADA_FRENCH).format(new java.util.Date())%>
</body>
</html>
