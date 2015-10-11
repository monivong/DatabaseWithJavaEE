<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> chercherUnePersonne.jsp </title>
        <script type="text/javascript">
            window.onload = function() {
                document.getElementById("btnId").onclick = function() {
                    window.location.href = "./controleurFrontal?action=chercherUnePersonneParId&id=" + document.getElementById("id").value;
                } 
                document.getElementById("btnNom").onclick = function() {
                    window.location.href = "./controleurFrontal?action=chercherUnePersonneParNom&nom=" + document.getElementById("nom").value;
                }
            };
        </script>
    </head>
    <body>
<%
        if( request.getAttribute("chercherUnePersonneParId") != null ) {
            out.println("<h3>" + request.getAttribute("chercherUnePersonneParId") + "</h3>");
        }
        if( request.getAttribute("chercherUnePersonneParNom") != null) {
            out.println("<h3>" + request.getAttribute("chercherUnePersonneParNom") + "</h3>");
        }
        if( request.getAttribute("message") != null ) {
            out.println("<h3>" + request.getAttribute("message") + "</h3>");
        }
%>        
        <table border="1px solid black">
            <tr>
                <td>Chercher par ID : </td>
                <td><input type="number" id="id"/></td>
                <td><input type="button" id="btnId"/></td>
            </tr>
            <tr>
                <td>Chercher par NOM : </td>
                <td><input type="text" id="nom"/></td>
                <td><input type="button" id="btnNom"/></td>
            </tr>
            <tr>
                <td>Chercher par PRÉNOM : </td>
                <td><input type="text" name="prenom"/></td>
                <td><input type="button" id="btnPrenom"/></td>
            </tr>
            <tr>
                <td>Chercher par Âge : </td>
                <td><input type="number" name="age"/></td>
                <td><input type="button" id="btnAge"/></td>                
            </tr>
            <tr>
                <td>Chercher par TAILLE : </td>
                <td><input type="number" name="taille"/></td>
                <td><input type="button" id="btnTaille"/></td>
            </tr>
            <tr>
                <td>Chercher par ISALIVE : </td>
                <td><input type="text" name="isAlive"/></td>
                <td><input type="button" id="btnIsAlive"/></td>
            </tr>
        </table>
        <a href="./index.jsp">Retourner à la page d'accueil</a>
    </body>
</html>
