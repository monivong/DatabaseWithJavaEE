package com.samnang.web.mvc;

import com.samnang.entites.Personne;
import com.samnang.jdbc.Connexion;
import com.samnang.jdbc.dao.implementation.PersonneDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChercherUnePersonneParNom extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");       
        String nom = request.getParameter("nom");
        if( nom == null || nom.trim().equals("") ) {
            request.setAttribute("message", "Erreur ! Le nom est invalide...");
            this.getServletContext().getRequestDispatcher("/chercherUnePersonne.jsp");
        }
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FindAll.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connexion.setUrl("jdbc:mysql://localhost/databasewithjavaee?user=root&password=root");
            PersonneDao unePersonneDao = new PersonneDao( Connexion.getInstance() );
            Personne unePersonne = unePersonneDao.readByName(nom);
            if(unePersonne != null ) {
                request.setAttribute("chercherUnePersonneParNom", unePersonne);
                this.getServletContext().getRequestDispatcher("/chercherUnePersonne.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Erreur ! Il n'existe personne avec le nom [" + nom + "]");
                this.getServletContext().getRequestDispatcher("/chercherUnePersonne.jsp").forward(request, response);
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
