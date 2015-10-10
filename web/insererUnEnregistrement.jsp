<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>insererUnEnregistrement.jsp</title>
    </head>
    <body>
<%
        if( request.getAttribute("message") != null ) {
            out.println("<h3>" + request.getAttribute("message") + "</h3>");
        }
%>        
        <form action="./controleurFrontal" method="get">
            <table border="1px solid black" collapsed="collapsed">
                <tr>
                    <td>nom : </td>
                    <td><input type="text" name="nom"/></td>                    
                </tr>
                <tr>
                    <td>prenom : </td>
                    <td><input type="text" name="prenom"/></td>                    
                </tr>
                <tr>
                    <td>age : </td>
                    <td><input type="number" name="age"/></td>
                </tr>
                <tr>
                    <td>taille : </td>
                    <td><input type="number" name="taille"/></td>
                </tr>
                <tr>
                    <td>is alive : </td>
                    <td><input type="text" name="isAlive"/></td>
                </tr>
                <tr>                     
                    <td colspan="2"><input type="submit" value="Ajouter" width="100%"/></td>
                    <input type="hidden" name="action" value="insererUnEnregistrement"/>
                </tr>            
            </table>
        </form>
        <a href="./index.jsp">Retourner à la page d'accueil</a>
    </body>
</html>
