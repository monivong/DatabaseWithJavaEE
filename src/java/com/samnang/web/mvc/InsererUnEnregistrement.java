package com.samnang.web.mvc;

import com.samnang.entites.Personne;
import com.samnang.jdbc.Connexion;
import com.samnang.jdbc.dao.implementation.PersonneDao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsererUnEnregistrement extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nom = request.getParameter("nom");
        if( nom.trim() == null || nom.trim().equals("") ) {
            request.setAttribute("message", "Problème avec « nom »...");
            this.getServletContext().getRequestDispatcher("/insererUnEnregistrement.jsp");
        }
        String prenom = request.getParameter("prenom");
        if( prenom.trim() == null || prenom.trim().equals("") ) {
            request.setAttribute("message", "Problème avec « prenom »...");
            this.getServletContext().getRequestDispatcher("/insererUnEnregistrement.jsp");
        }
        int age = Integer.parseInt( request.getParameter("age") );
        double taille = Double.parseDouble( request.getParameter("taille") );        
        /*boolean isAlive = false;
        if( Boolean.parseBoolean( request.getParameter("isAlive") ) ) { 
            isAlive = Boolean.parseBoolean( request.getParameter("isAlive") );
        } else {
            request.setAttribute("message", "Problème avec « isAlive »");
            this.getServletContext().getRequestDispatcher("/insererUnEnregistrement.jsp").forward(request, response);
        }*/
        boolean isAlive = false;
        if( Integer.parseInt( request.getParameter("isAlive") ) == 1 )
            isAlive = true;
        else if( Integer.parseInt( request.getParameter("isAlive") ) == 0 )
            isAlive = false;
        else {
            request.setAttribute("message", "Problème avec « isAlive »");
            this.getServletContext().getRequestDispatcher("/insererUnEnregistrement.jsp").forward(request, response);
        }
        Personne unePersonne = new Personne();
        unePersonne.setNom(nom);
        unePersonne.setPrenom(prenom);
        unePersonne.setAge(age);
        unePersonne.setTaille(taille);
        unePersonne.setIsAlive(isAlive);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsererUnEnregistrement.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connexion.setUrl("jdbc:mysql://localhost/databasewithjavaee?user=root&password=root");
        PersonneDao temp = new PersonneDao( Connexion.getInstance() );
        if( temp.create( unePersonne ) ) {
            request.setAttribute("message", "L'ajout de " + unePersonne.getNom() + " a réussi !");
            this.getServletContext().getRequestDispatcher("/insererUnEnregistrement.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "La personne n'a pas pu être créée...");
            this.getServletContext().getRequestDispatcher("/insererUnEnregistrement.jsp");
        }            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
