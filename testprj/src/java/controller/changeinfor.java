/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author FPT SHOP PCC Hai Hau
 */
@WebServlet(name = "changeinfor", urlPatterns = {"/changeinfor"})
public class changeinfor extends HttpServlet {

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
            out.println("<title>Servlet changeinfor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet changeinfor at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String authcode = (String)session.getAttribute("code");

        String code = (String)request.getParameter("code");

        if (!code.trim().equals(authcode.trim())) {
            out.print(out);

            request.getRequestDispatcher("checkcode").forward(request, response);
        }
        int type = Integer.parseInt((String) request.getParameter("type"));
        switch (type) {
            case 1:

                response.sendRedirect("changename");

//                int id  = Integer.parseInt((String)request.getParameter("ID"));
                break;
            case 2:

                response.sendRedirect("changeemail");

                break;
            case 3:
                response.sendRedirect("changeusername");

                break;
            case 33:
                request.getRequestDispatcher("forgotpass.jsp").forward(request, response);

                break;
            case 4:
                response.sendRedirect("changepass");

                break;
            case 22:
                UserDAO ud = new UserDAO();
                User u = (User) session.getAttribute("user");
                ud.updateUser(u.getId(), u.getName(), u.getUsername(), (String) session.getAttribute("email"));
                session.setAttribute("user", ud.getUser(u.getId()));
                response.sendRedirect("profile");

                break;

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
        PrintWriter out = response.getWriter();
        String pass = (String) request.getParameter("pass");
        String repass = (String) request.getParameter("repass");
        if (!pass.equals(repass)) {
            request.setAttribute("ms", "Nhập mật khẩu ngu!!!");
            request.getRequestDispatcher("forgotpass.jsp").forward(request, response);
        } else {
            UserDAO ud = new UserDAO();

            HttpSession ss = request.getSession();
            User u = (User) ss.getAttribute("tempuser");
            out.print(u);
            ud.updatePass(pass, u.getId());
            out.print(pass);
            out.print(ud.getUser(u.getId()));

            ss.setAttribute("tempuser", null);
            request.setAttribute("ms", "Mật khẩu đã được đổi");
            request.getRequestDispatcher("login").forward(request, response);

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
