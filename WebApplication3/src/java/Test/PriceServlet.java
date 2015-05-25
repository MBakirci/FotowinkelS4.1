/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gebruiker
 */
public class PriceServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PriceServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PriceServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

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
        if (request.getParameter("typeID") != null) {
            String a = request.getParameter("typeID");

            String sql = "DELETE FROM FW_TYPE WHERE ID = ?";
            Test.Databaseconnector connection = new Test.Databaseconnector();
            try {
                if (connection.verbindmetDatabase()) {
                    PreparedStatement state = null;
                    state = connection.conn.prepareStatement(sql);
                    state.setString(1, a);
                    state.executeQuery();
                    //
                    response.sendRedirect("Price.jsp");

                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PriceServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(PriceServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(PriceServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(request.getParameter("btnBewerk") != null) {
             PriceSettings opp = new PriceSettings();
             String sa = request.getParameter("id1");
                if(sa.equals("")){
                    sa = null;
                }

                if (sa != null ) {
                    opp.setTypeNaam(request.getParameter("naam1"));
                    opp.setTypeDetails(request.getParameter("details1"));
                    opp.setPrijs(Double.parseDouble(request.getParameter("prijs1")));
                    opp.setTypeID(Integer.parseInt(request.getParameter("id1")));
                    int a = Integer.parseInt(request.getParameter("id1"));
                 try {
                     opp.EditProductType(a);
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(PriceServlet.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (InstantiationException ex) {
                     Logger.getLogger(PriceServlet.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (IllegalAccessException ex) {
                     Logger.getLogger(PriceServlet.class.getName()).log(Level.SEVERE, null, ex);
                 }
                    response.sendRedirect("Price.jsp");
                } else {
                    opp.setTypeNaam(request.getParameter("naam1"));
                    opp.setTypeDetails(request.getParameter("details1"));
                    opp.setPrijs(Double.parseDouble(request.getParameter("prijs1")));
                 try {
                     opp.AddProductType();
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(PriceServlet.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (InstantiationException ex) {
                     Logger.getLogger(PriceServlet.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (IllegalAccessException ex) {
                     Logger.getLogger(PriceServlet.class.getName()).log(Level.SEVERE, null, ex);
                 }
                    response.sendRedirect("Price.jsp");
                }
            
        }
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
