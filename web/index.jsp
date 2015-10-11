<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="com.samnang.entites.Personne"%>
<%@page import="com.samnang.jdbc.dao.implementation.PersonneDao"%>
<%@page import="com.samnang.jdbc.Connexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> index.jsp </title>
    </head>
    <body>
        <h1>Affichage des données</h1>
        <a href="./insererUnEnregistrement.jsp">Ajouter une pesonne</a><br/>
        <a href="./chercherUnePersonne.jsp">Chercher une personne</a><br/>
        <a href="">Mettre à jour une personne</a><br/>
        <a href="">Supprimer une personne</a><br/>
        <jsp:include page="/retrievePeople"/>               
    </body>
</html>