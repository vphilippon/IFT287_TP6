<%@ page import="java.util.*,java.text.*" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>IFT287 - Syst�me de gestion de biblioth�que MAH BOI!</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1">
<META NAME="author" CONTENT="Marc Frappier">
<META NAME="description"
CONTENT="page d'accueil syst�me de gestion de bilbioth�que.">
</HEAD>
<BODY>
<CENTER>
<H1>Syst�me de gestion de biblioth�que</H1>
<FORM ACTION="Login" METHOD="POST">
    <BR>
    <BR>
    User Id : <INPUT TYPE="TEXT" NAME="userIdBD" VALUE="postgres">
    <BR>
    <BR>
    Mot de passe : <INPUT TYPE="TEXT" NAME="motDePasseBD" VALUE="ubuntu">
    <BR>
    <BR>
    Serveur : <SELECT NAME="serveur">
                <OPTION VALUE="postgres">postgres
              </SELECT>
    <BR>
    <BR>
    adresseIP : <INPUT TYPE="TEXT" NAME="adresseIP"  VALUE="127.0.0.1">

    <BR>
    <BR>
    BD : <INPUT TYPE="TEXT" NAME="bd"  VALUE="postgres">
<BR>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Soumettre">
</FORM>
</CENTER>
<BR>
<%-- inclusion d'une autre page pour l'affichage des messages d'erreur--%>
<jsp:include page="/WEB-INF/messageErreur.jsp" />
<BR>
<%-- affichage de la date et heure; --%>
<%-- utile pour d�bogger et verifier si la page a �t� --%>
<%-- par le fureteur --%>
Date et heure normale de l'est: <%= DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.CANADA_FRENCH).format(new java.util.Date()) %>
</BODY>
</HTML>
