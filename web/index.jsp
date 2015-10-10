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
<%
        Class.forName("com.mysql.jdbc.Driver");
        Connexion.setUrl("jdbc:mysql://localhost/databasewithjavaee?user=root&password=root");
        PersonneDao unePersonneDao = new PersonneDao( Connexion.getInstance() );
        PrintWriter cout = response.getWriter();        
        if(unePersonneDao != null ) {
            List<Personne> listeDesPersonnes = new LinkedList<Personne>();
            listeDesPersonnes = unePersonneDao.findAll();            
            out.println("<table>");
            for(int i=0; i < listeDesPersonnes.size(); i++) {
                //out.println("<tr>");
                cout.println("<tr><td>" + listeDesPersonnes.get(i).getId() + "</td>");
                cout.println("<td>" + listeDesPersonnes.get(i).getNom() + "</td>");
                cout.println("<td>" + listeDesPersonnes.get(i).getPrenom() + "</td>");
                cout.println("<td>" + listeDesPersonnes.get(i).getAge() + "</td>");
                cout.println("<td>" + listeDesPersonnes.get(i).getTaille() + "</td>");
                cout.println("<td>" + listeDesPersonnes.get(i).getIsAlive() + "</td></tr>");
                //out.println("</tr>");
            }
            out.println("</table>");
        } else {
            cout.println("<h3>L'affichage a échoué</h3>");
        }
%>               
    </body>
</html>