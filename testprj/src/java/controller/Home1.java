/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import static controller.product.isNumeric;
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
import model.Genre;
import model.User;

/**
 *
 * @author FPT SHOP PCC Hai Hau
 */
@WebServlet(name = "Home1", urlPatterns = {"/home"})
public class Home1 extends HttpServlet {

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
            out.println("<title>Servlet Home1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Home1 at " + request.getContextPath() + "</h1>");
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
        HttpSession ss = request.getSession();
        Genre_DAO gd = new Genre_DAO();
        ss.setAttribute("genre", gd.getAll());
        Movie_DAO md = new Movie_DAO();
        request.setAttribute("top10", md.getTop10());
        request.setAttribute("topVote", md.getTopVote());
        request.setAttribute("topView", md.getTopView());
        request.setAttribute("New", md.getNew());
        User u = (User) ss.getAttribute("user");
        if (u != null) {
            if (u.getRole().equalsIgnoreCase("user")) {
                Cookie[] cookies = request.getCookies();
                java.util.List<String> listc = new ArrayList<>();
                try {
                    String uid = "" + u.getId();
                    for (Cookie cooky : cookies) {
                        if (cooky.getName().equals(uid)) {
                            for (String c : cooky.getValue().split("-")) {
                                if (isNumeric(c)) {
                                    listc.add(c);
                                }
                            }
                            break;
                        }
                    }
                    request.setAttribute("listc", listc);
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                } catch (Exception e) {
                    request.setAttribute("listc", listc);
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                }

            } else {
                Cookie[] cookies = request.getCookies();
                java.util.List<String> listc = new ArrayList<>();
                try {
                    String uid = "" + u.getId();
                    for (Cookie cooky : cookies) {
                        if (cooky.getName().equals(uid)) {
                            for (String c : cooky.getValue().split("-")) {
                                if (isNumeric(c)) {
                                    listc.add(c);
                                }
                            }
                            break;
                        }
                    }
                    request.setAttribute("listc", listc);
                    request.getRequestDispatcher("homead.jsp").forward(request, response);
                } catch (Exception e) {
                    request.setAttribute("listc", listc);
                    request.getRequestDispatcher("homead.jsp").forward(request, response);
                }

            }

        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);

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

    public static void main(String[] args) {
        Genre_DAO gd = new Genre_DAO();
        for (Genre genre : gd.getAll()) {
            System.out.println(genre.getName());
        }
    }

}
