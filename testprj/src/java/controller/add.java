/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.Genre_DAO;
import dal.Movie_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Movie;

/**
 *
 * @author FPT SHOP PCC Hai Hau
 */
@WebServlet(name = "add", urlPatterns = {"/add"})
public class add extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet add</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet add at " + request.getContextPath() + "</h1>");
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
        Genre_DAO gd = new Genre_DAO();
        request.setAttribute("genre", gd.getAll());
        request.getRequestDispatcher("add.jsp").forward(request, response);

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
        Genre_DAO gd = new Genre_DAO();
        request.setAttribute("genre", gd.getAll());
        
        String title = (String)request.getParameter("title");
        String overview = (String)request.getParameter("overview");
        String poster = (String)request.getParameter("poster");
        String backdrop = (String)request.getParameter("backdrop");
        int runtime = Integer.parseInt((String)request.getParameter("runtime"));
        String video_link = (String)request.getParameter("video_link");
        String release_date = (String)request.getParameter("release_date");
        String[] genre = (String[])request.getParameterValues("genre");
        String genres="";
        for (String g : genre) {
           genres+=(g+",");
        }
        genres=genres.substring(0, genres.length()-1);
        Movie_DAO md = new Movie_DAO();
        Movie m = new Movie(0, title, overview, poster, backdrop, 0, 0, 0, runtime, release_date, "", video_link, "", genres);
        md.addMovie(m);
        response.sendRedirect("listad");
//        request.getRequestDispatcher("listad").forward(request, response);
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
