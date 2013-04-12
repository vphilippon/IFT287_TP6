<%@ page import="java.util.*,java.text.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
  // affichage de la liste des messages d'erreur
  if (request.getAttribute("listeAfficher") != null) {
%>
    <%= request.getAttribute("entete") %>
<%
    ListIterator it = ((List) request.getAttribute("listeAfficher")).listIterator();
    while (it.hasNext()) {
%>
      <br />
      <%= it.next() %>
<%
    }
  }
%>
