/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.softech.tutorial.jee.workshop;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterators;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ssledz
 */
@WebServlet(name = "WelcomeServlet", urlPatterns = {"/welcome"}, initParams = {
    @WebInitParam(name = "email", value = "slawomir.sledz@gmail.com")})
public class WelcomeServlet extends HttpServlet {

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
            out.println("<title>Servlet WelcomeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WelcomeServlet at " + request.getContextPath() + "</h1>");
            out.println(new Date());
            out.println("</br>" + getServletConfig().getInitParameter("email"));

            out.println("</br>");

            String param1 = request.getParameter("param1");
            String[] params1 = request.getParameterValues("param1");
            String param2 = request.getParameter("param2");

            out.println("<ul>");
            out.println("<li>param1=" + param1 + "</li>");
            out.println("<li>param2=" + param2 + "</li>");

            out.println("</ul>");

            out.println("<h1>Request parameters</h1>");
            out.println("<ul>");
            for (Enumeration<String> e = request.getParameterNames(); e.hasMoreElements();) {
                String paramName = e.nextElement();
                out.println("<li>" + paramName + "=" + request.getParameter(paramName) + "</li>");
            }

            out.println("</ul>");

            out.println("<h1>Request parameters by Map</h1>");
            out.println("<ul>");
            for (Map.Entry<String, String[]> e : request.getParameterMap().entrySet()) {

//                out.println("<li>" + e.getKey() + "=");
//                out.println(Joiner.on(", ").join(e.getValue()));
//                out.println("</li>");
                out.println(String.format("<li>%s = %s</li>", e.getKey(), Joiner.on(", ").join(e.getValue())));

            }

            out.println("</ul>");

            out.println("<h1>Request headers</h1>");
            out.println("<ul>");

            for (Enumeration<String> e = request.getHeaderNames(); e.hasMoreElements();) {
                String paramName = e.nextElement();
                out.println(String.format("<li>%s: [%s]</li>", paramName,
                        Joiner.on(", ").join(Iterators.forEnumeration(request.getHeaders(paramName)))));
            }
            
            out.println("</ul>");

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
