/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gebruiker
 */
public class LoginController extends HttpServlet {

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
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
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

        String naam = request.getParameter("Email");
        String pass = request.getParameter("Pass");
        String voornaam = request.getParameter("voornaam");
        String tussenvoegsel = request.getParameter("tussenvoegsel");
        String achternaam = request.getParameter("achternaam");
        //LOGIN
        if (request.getParameter("btnLogin") != null) {
            Test.Login login = new Test.Login(naam, pass);
            try {
                if (login.Verbind()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("Name", naam);
                    session.setAttribute("Role", login.getRole());
                    response.setContentType("text/plain");
                    response.getWriter().write("success");
                    response.sendRedirect("index.jsp");
                } else {
                    response.setContentType("text/plain");
                    response.getWriter().write("unsuccess");
                }
            } catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Register met email en password User wordt aangemaakt op Database
        if (request.getParameter("btnRegister") != null) {
            naam = request.getParameter("username");
            pass = request.getParameter("password");
            int actief = 1;
            String error = "";

            Test.registreer reg = new Test.registreer(naam, pass, voornaam, tussenvoegsel, achternaam, actief);

            try {
                if (!reg.Verbind()) {
                    response.setContentType("text/plain");
                    response.getWriter().write("unsuccess");
                } else {
                    HttpSession session = request.getSession();
                    User user = new User();
                    user.seteMail(naam);
                    session.setAttribute("RegistUser", user);
                    request.getRequestDispatcher("Registreren_AdditionalInfo.jsp").forward(request, response);
                }
            } catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //Register modal met userinformatie
        if (request.getParameter("btnRegisterAddInfo") != null) {
            String eMail = request.getParameter("eMail");
            String tel = request.getParameter("telefoon");
            String straat = request.getParameter("straat");
            String huisnr = request.getParameter("huisnr");
            String postcode = request.getParameter("postcode");
            String stad = request.getParameter("stad");
            try {
                User reg = new User(eMail);
                if (reg.UserInfo(tel, straat, huisnr, postcode, stad)) {
                    response.setContentType("text/plain");
                    response.getWriter().write("success");
                } else {
                    response.setContentType("text/plain");
                    response.getWriter().write("unsuccess");
                }
            } catch (ClassNotFoundException | InstantiationException | SQLException | IllegalAccessException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
