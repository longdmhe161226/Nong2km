/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.cookie;

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
import java.util.List;
import model.User;

/**
 *
 * @author FPT SHOP PCC Hai Hau
 */
@WebServlet(name = "addfavorite", urlPatterns = {"/addfavorite"})
public class addfavorite extends HttpServlet {

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
            out.println("<title>Servlet addfavorite</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addfavorite at " + request.getContextPath() + "</h1>");
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
        String id = (String) request.getParameter("ID");
        PrintWriter out = response.getWriter();
        HttpSession ss = request.getSession();
        User u = (User) ss.getAttribute("user");
        Cookie[] cookies = request.getCookies();
        List<String> list = new ArrayList<>();
        String uid = "" + u.getId();
//        out.print(uid);

        for (Cookie cooky : cookies) {
            out.println(cooky.getName());
            if (cooky.getName().equals(uid)) {
                for (String c : cooky.getValue().split("-")) {
                    list.add(c);
                }
                break;
            }
        }
        out.println("83" + list);

        out.println(list.size());
        boolean bl = false;
        if (list.size() == 0) {

            list.add(id);
            out.println("88" + list);
        } else {
            for (String c : list) {
                if (checkExist(c, id)) {
                    out.println("93" + list);

                    list.remove(c);
                    bl = true;
                    break;

                }
            }
        }
        if (bl == false) {
            out.println("99" + list);

            list.add(id);
            out.println("99" + list);

        }
        out.println("104" + list);

        out.println(list);

        for (Cookie cooky : cookies) {
            if (checkExist(cooky.getName(), uid)) {

                cooky.setMaxAge(0);
                response.addCookie(cooky);

            }

        }

        String cookienew = "";

        List<String> listt = new ArrayList<>();
        
        for (String s : list) {
            if (!checkExist(s, listt)) {
                listt.add(s);
            }
        }

        for (String c : listt) {
            cookienew += (c + "-");
        }
        out.println(cookienew);

        Cookie cookie = new Cookie(uid, cookienew);
        cookie.setMaxAge(9999);
        response.addCookie(cookie);
        out.println(cookie.getName());
        out.println(cookie.getValue());

        if (request.getParameter("cate") != null && request.getParameter("cate") != "") {
            response.sendRedirect("list?cate=" + request.getParameter("cate"));

        }
        out.println("---=");

        if (request.getParameter("search") != null && request.getParameter("search") != "") {
            response.sendRedirect("search?search=" + request.getParameter("search"));

        }
        out.println("---=");

        if (request.getParameter("favorite").equals("1")) {
            response.sendRedirect("favorite");

        }

        out.println("---=");

        if (request.getParameter("home").equals("1")) {
            response.sendRedirect("home");

        }
        out.println("---=");

        if (request.getParameter("homead").equals("1")) {
            response.sendRedirect("homead");

        }
        out.println("---=");

        response.sendRedirect("product?ID=" + id);
//        request.getRequestDispatcher("product?ID=" + id).forward(request, response);
    }

    public static boolean checkExist(String cooky, String str) {

        if (cooky.equals(str)) {
            return true;
        }

        return false;
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
        String id = (String) request.getParameter("ID");
        PrintWriter out = response.getWriter();
        HttpSession ss = request.getSession();
        User u = (User) ss.getAttribute("user");
        Cookie[] cookies = request.getCookies();
        List<String> list = new ArrayList<>();
        String uid = "" + u.getId();
        for (Cookie cooky : cookies) {
            if (cooky.getName().equals(uid)) {
                for (String c : cooky.getValue().split("-")) {
                    list.add(c);
                }
                break;
            }
        }

        for (String c : list) {
            if (checkExist(c, id)) {

                list.remove(c);

            }

            if (!checkExist(c, id)) {

                list.add(id);
            }
        }

        for (Cookie cooky : cookies) {
            if (checkExist(cooky.getName(), uid)) {

                cooky.setMaxAge(0);
                response.addCookie(cooky);

            }

        }

        String cookienew = "";

        for (String c : list) {
            cookienew += (c + "-");
        }

        Cookie cookie = new Cookie(uid, cookienew);
        cookie.setMaxAge(9999);
        response.addCookie(cookie);

        if (request.getParameter("cate") != null && request.getParameter("cate") != "") {
            response.sendRedirect("list?cate=" + request.getParameter("cate"));

        }
        if (request.getParameter("search") != null && request.getParameter("search") != "") {
            response.sendRedirect("search?search=" + request.getParameter("search"));

        }
        response.sendRedirect("product?ID=" + id);
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

    private boolean checkExist(String s, List<String> listt) {
       
        for (String str : listt) {
            if (s.equals(str)) {
                return true;
            }
        }
        return false;
        
    }
    public static void main(String[] args) {
        String str ="37-";

        List<String> list = new ArrayList<>();
        System.out.println(list.size());

        for (String s : str.split("-")) {
            list.add(s);
        }
        System.out.println(list.size());
    }

}
