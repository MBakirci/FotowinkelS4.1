/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asror
 */
public class ShoppingCart extends HttpServlet {
    
private RequestDispatcher rd;

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
            out.println("<title>Servlet ShoppingCart</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShoppingCart at " + request.getContextPath() + "</h1>");
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
        if (request.getParameter("typeID") != null) {
            winkelwagen.DeleteItem(request.getParameter("typeID"));
        } else if (request.getParameter("btnBewerkt") != null) {
            winkelwagen.ChangeItem(request.getParameter("naam1"), Integer.parseInt(request.getParameter("details1")));
        } else if (request.getParameter("addtocart") != null) {
            winkelwagen.AddItem(request.getParameter("fotoimage"), 1, "Normaal", "Afdruk", 4.95, request.getParameter("fotoimage"), 0.0 , 0.0, 0.0, 0.0 );
        } else {
            String waarde = request.getParameter("Soort2");
            String waarde2 = request.getParameter("Type");

            String QString = request.getParameter("fotoimage").toString();
            Test.Photo photo = new Test.Photo();
            String link = "";
            Test.ProductPage pp = new Test.ProductPage();
            ArrayList<Double> typePrices = new ArrayList<Double>();
            ArrayList<String> typeNames = new ArrayList<String>();
            String basePrice = "";
            ArrayList<String> colorNames = new ArrayList<String>();
            ArrayList<Double> colorPrices = new ArrayList<Double>();

            if (!QString.equals("") && !QString.equals(null)) {
                try {
                 
                    typePrices = pp.getTypePrice(); //Get current type prices
                    typeNames = pp.getTypeName();
                    basePrice = pp.getBasePrice(QString);
                    colorNames = pp.getColorName();
                    colorPrices = pp.getColorPrice();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(ShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            Double Xcor = 0.0;
            Double Ycor = 0.0;
            Double wamnt = 0.0;
            Double hamnt = 0.0;
                   
            String cropwaarde = request.getParameter("xcor");
            if(!cropwaarde.equals("null"))
            {
            Xcor = Double.parseDouble(request.getParameter("xcor"));
            Ycor = Double.parseDouble(request.getParameter("ycor"));
            wamnt = Double.parseDouble(request.getParameter("wamnt"));
            hamnt = Double.parseDouble(request.getParameter("hamnt"));
            }
            String soortprod = typeNames.get(Integer.parseInt(waarde));
            String soortkleur = colorNames.get(Integer.parseInt(waarde2));
            Double prijskleur = colorPrices.get(Integer.parseInt(waarde2));
           Double prijsprod = typePrices.get(Integer.parseInt(waarde));
          winkelwagen.AddItem(request.getParameter("fotoimage"),  Integer.parseInt(request.getParameter("aantalitems")), soortkleur, soortprod, prijskleur + prijsprod, request.getParameter("fotoimage"), Xcor, Ycor, wamnt, hamnt);
        }

        if (request.getParameter("addtocart") != null) {
            String cat = request.getParameter("cat");
        response.sendRedirect("PhotogalleryCatPhotosCustomer.jsp?cat="+cat+ "");
        } else {
        response.sendRedirect("Winkelwagen.jsp");
        }
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
