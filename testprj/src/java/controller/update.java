/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.Director_DAO;
import dal.Genre_DAO;
import dal.Movie_DAO;
import dal.Producer_DAO;
import dal.Stars_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Director;
import model.Movie;
import model.Producer;

/**
 *
 * @author FPT SHOP PCC Hai Hau
 */
@WebServlet(name = "update", urlPatterns = {"/update"})
public class update extends HttpServlet {

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
        int id = Integer.parseInt((String) request.getParameter("ID"));
        Movie_DAO md = new Movie_DAO();
        Movie mt = md.getMovieByid(id);
        mt.setPoster(mt.getPoster().substring(14));
        mt.setBackdrop(mt.getBackdrop().substring(16));
        Director_DAO dd = new Director_DAO();
        Director d = dd.getDirectorByID(mt.getDirectorid());
        Producer_DAO pd = new Producer_DAO();
        Producer p = pd.Producer(mt.getProducerid());
        try {
            if (request.getParameter("ms").contains("1")) {
                request.setAttribute("ms", "Director not Exist!!!");

            }
            if (request.getParameter("ms").contains("2")) {
                request.setAttribute("mss", "Producer not Exist!!!");

            }
        } catch (Exception e) {
        }
        Stars_DAO sd = new Stars_DAO();
        

        request.setAttribute("stars", sd.getAll());
        request.setAttribute("movie", mt);
        request.setAttribute("director", d.getFullname());
        request.setAttribute("producer", p.getName());

        request.getRequestDispatcher("update.jsp").forward(request, response);

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

        String title = (String) request.getParameter("title");
        String overview = (String) request.getParameter("overview");
        String poster = (String) request.getParameter("poster");
        String backdrop = (String) request.getParameter("backdrop");
        int runtime = Integer.parseInt((String) request.getParameter("runtime"));
        String video_link = (String) request.getParameter("video_link");
        String release_date = (String) request.getParameter("release_date");
        String[] genre = (String[]) request.getParameterValues("genre");
        String[] stars = (String[]) request.getParameterValues("stars");
        String genres = "";
        try {
            for (String g : genre) {
                genres += (g + ",");
            }
            genres = genres.substring(0, genres.length() - 1);

        } catch (Exception e) {
        }

        int id = Integer.parseInt((String) request.getParameter("ID"));

        String director = (String) request.getParameter("director");
        String producer = (String) request.getParameter("producer");
        Director_DAO dd = new Director_DAO();
        Director d = new Director();
        d = dd.getDirectorByName(director);
        Producer_DAO pd = new Producer_DAO();
        Producer p = new Producer();
        p = pd.Producer(producer);
        if (d.getId() == 0 && p.getId() == 0) {
            response.sendRedirect("update?ID=" + id + "&ms=12");

        }
        if (d.getId() == 0 && !(p.getId() == 0)) {
            response.sendRedirect("update?ID=" + id + "&ms=1");

        }
        if (!(d.getId() == 0) && (p.getId() == 0)) {
            response.sendRedirect("update?ID=" + id + "&ms=2");

        }

        Movie_DAO md = new Movie_DAO();
//        md.updateMovie(id, title, overview, poster, backdrop, runtime, runtime, release_date, title, title, director, id, id);
//        Genre_DAO gd = new Genre_DAO();
        gd.deleteMovieGenre(id);
        gd.addMovieGenre(id, genre);
        
        Stars_DAO sd = new Stars_DAO();
        sd.deleteMovieStar(id);
        sd.addMovieStar(id,stars);
        
        md.updateMovie(id, title, overview, poster, backdrop, runtime, release_date, video_link, genres, p.getId(), d.getId());
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

    public static void main(String[] args) {
        Director d = new Director();
        System.out.println(d.getId());
    }

}
