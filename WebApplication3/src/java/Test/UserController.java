/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jboss.weld.servlet.SessionHolder;

/**
 *
 * @author Gebruiker
 */
public class UserController extends HttpServlet {

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
            out.println("<title>Servlet UserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
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
        if (request.getParameter("eMail") != null) {
            String eMail = request.getParameter("eMail");
            try {
                HttpSession session = request.getSession();
                User user = getUserInfo(eMail);
                session.setAttribute("CurrentUser", user);
            } catch (ClassNotFoundException | InstantiationException | SQLException | IllegalAccessException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("CustomerInfoDetails.jsp").forward(request, response);
        }
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
        //UPDATE
        if (request.getParameter("btnSave") != null) {
            try {
                User user = (User) request.getSession().getAttribute("CurrentUser");
                user.setVoornaam(request.getParameter("fname"));
                user.setTussenvoegsel(request.getParameter("tname"));
                user.setAchternaam(request.getParameter("lname"));
                user.setStraat(request.getParameter("street"));
                user.setHuisnr(request.getParameter("housenumber"));
                user.setPostcode(request.getParameter("zipcode"));
                user.setStad(request.getParameter("city"));
                user.setTelefoon(request.getParameter("telnr"));
                user.UpdateUser();
                processRequest(request, response);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(request.getParameter("btnActive") != null){
            Verwijderaccount activeer = new Verwijderaccount(request.getParameter("eMail"));
            try {
                activeer.Zetstatusactief();
            } catch (Exception ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(request.getParameter("btnDisable") != null){
            Verwijderaccount disable = new Verwijderaccount(request.getParameter("eMail"));
            try {
                disable.Zetstatusnonactief();
            } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private User getUserInfo(String EMail) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        User user = new User(EMail);
        user.AdditionalInfo();
        return user;
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
