package com.samnang.web.mvc;

import com.samnang.entites.Personne;
import com.samnang.jdbc.Connexion;
import com.samnang.jdbc.dao.implementation.PersonneDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindAll extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FindAll.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connexion.setUrl("jdbc:mysql://localhost/databasewithjavaee?user=root&password=root");
            PersonneDao unePersonneDao = new PersonneDao( Connexion.getInstance() );
            PrintWriter cout = response.getWriter();        
            if(unePersonneDao != null ) {
                List<Personne> listeDesPersonnes = new LinkedList<Personne>();
                listeDesPersonnes = unePersonneDao.findAll();            
                out.println("<table border=\"1px solid black\">");
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
