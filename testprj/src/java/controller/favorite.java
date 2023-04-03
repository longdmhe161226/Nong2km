/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import static controller.cookie.addfavorite.checkExist;
import static controller.search.isNumeric;
import dal.Genre_DAO;
import dal.Movie_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Movie;
import model.User;

/**
 *
 * @author FPT SHOP PCC Hai Hau
 */
@WebServlet(name = "favorite", urlPatterns = {"/favorite"})
public class favorite extends HttpServlet {

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
            out.println("<title>Servlet favorite</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet favorite at " + request.getContextPath() + "</h1>");
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
        Movie_DAO md = new Movie_DAO();
        Genre_DAO gd = new Genre_DAO();
        request.setAttribute("genre", gd.getAll());

        HttpSession ss = request.getSession();
        User u = (User) ss.getAttribute("user");
        Cookie[] cookies = request.getCookies();
        java.util.List<Movie> listc = new ArrayList<>();
        String uid = "" + u.getId();
        for (Cookie cooky : cookies) {
            if (cooky.getName().equals(uid)) {
                for (String cc : cooky.getValue().split("-")) {
                    if (isNumeric(cc)) {
                        listc.add(md.getMovieByid(Integer.parseInt(cc)));

                    }
                }
                break;
            }
        }
        request.setAttribute("movies", listc);
        request.getRequestDispatcher("favorite.jsp").forward(request, response);
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
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
