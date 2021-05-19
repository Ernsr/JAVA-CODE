package kz.bitlab.group32.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (value = "/removecookies")
public class RemoveCookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie [] cookies = req.getCookies();
        if (cookies != null) {
             for (Cookie c : cookies) {
                 if (c.getName().equals("u_name")) {
                     c.setMaxAge(0);
                     resp.addCookie(c);
                 }
                 if (c.getName().equals("u_age")) {
                     c.setMaxAge(0);
                     resp.addCookie(c);
                 }
             }
             resp.sendRedirect("/");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
