/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asror
 */
public class ShoppingCartAmount extends HttpServlet {

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
            out.println("<title>Servlet ShoppingCartAmount</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShoppingCartAmount at " + request.getContextPath() + "</h1>");
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
        
 Test.WinkelWagen winkelwagen = new Test.WinkelWagen();

        String amount = request.getParameter("amount");
        String fotocod = request.getParameter("fotocod");
        String soortprod = request.getParameter("Soort2");
        String soortkleur = request.getParameter("Type");
        Test.Photo photo = new Test.Photo();
        Test.ProductPage pp = new Test.ProductPage();
        int Xcor = 0;
        int Ycor = 0;
        int wamnt = 0;
        int hamnt = 0;

        String cropwaarde = request.getParameter("xcor");
        if (!cropwaarde.equals("null")) {
            Xcor = Integer.parseInt(request.getParameter("xcor"));
            Ycor = Integer.parseInt(request.getParameter("ycor"));
            wamnt = Integer.parseInt(request.getParameter("wamnt"));
            hamnt = Integer.parseInt(request.getParameter("hamnt"));
        }

        winkelwagen.ChangeItem(fotocod, Integer.parseInt(amount), soortprod, soortkleur, Xcor, Ycor, wamnt, hamnt);
    
        response.sendRedirect("Winkelwagen.jsp");
        
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
