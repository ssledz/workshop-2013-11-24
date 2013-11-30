/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.softech.tutorial.jee.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ssledz
 */
@WebServlet(name = "ListUsersController", urlPatterns = {"/listusers"})
public class ListUsersController extends HttpServlet {

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

        List<User> users = (List<User>) request.getServletContext().getAttribute("users");
        
        if (users == null) {
            users = new LinkedList<>();
            request.getServletContext().setAttribute("users", users);
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListUsersController</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>UserName</th>");
            out.println("<th>FirstName</th>");
            out.println("<th>LastName</th>");
            out.println("<th>Email</th>");
            out.println("<th>Password</th>");
            out.println("");
            out.println("");
            out.println("</tr>");
            for (User u : users) {

                out.println("<tr>");
                out.println(String.format("<td>%s</td>", u.getUserName()));
                out.println(String.format("<td>%s</td>", u.getFirstName()));
                out.println(String.format("<td>%s</td>", u.getLastName()));
                out.println(String.format("<td>%s</td>", u.getEmail()));
                out.println(String.format("<td>%s</td>", u.getPassword()));
                out.println("</tr>");
            }
            out.println("</table>");

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
