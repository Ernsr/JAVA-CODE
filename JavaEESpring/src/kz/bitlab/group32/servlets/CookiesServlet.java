package kz.bitlab.group32.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/cookies")
public class CookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = (String) request.getSession().getAttribute("userName");
        System.out.println(userName);

        String cName = "No Name";
        String cSurname = "No Surname";
        String cAge = "0";
        String cCountry = "No Country";
        String cGender = "No Gender";
        String cCredit = "No Credit Card";

        Cookie cookie [] = request.getCookies();

        if (cookie != null) {
            for (Cookie c : cookie) {
                if (c.getName().equals("cookies_name")) {
                    cName = c.getValue();
                }
                if (c.getName().equals("cookies_surname")) {
                    cSurname = c.getValue();
                }
                if (c.getName().equals("cookies_age")) {
                    cAge = c.getValue();
                }
                if (c.getName().equals("cookies_country")) {
                    cCountry = c.getValue();
                }
                if (c.getName().equals("cookies_gender")) {
                    cGender = c.getValue();
                }
                if (c.getName().equals("cookies_credit")) {
                    cCredit = c.getValue();
                }
            }
        }
        request.setAttribute("cookies_name", "My name is " + cName);
        request.setAttribute("cookies_surname", " My surname is " + cSurname);
        request.setAttribute("cookies_age","My years old" + cAge);
        request.setAttribute("cookies_country", "Im form is " + cCountry);
        request.setAttribute("cookies_gender", "My gender " + cGender);
        request.setAttribute("cookies_credit","My Credit Card Number" + cCredit);

        request.getRequestDispatcher("/cookies.jsp").forward(request ,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("cookies_name");
        String surname = request.getParameter("cookies_surname");
        String age = request.getParameter("cookies_age");
        String country = request.getParameter("cookies_country");
        String gender = request.getParameter("cookies_gender");
        String credit = request.getParameter("cookies_credit");

        Cookie nameCookie = new Cookie("u_name",name);
        nameCookie.setMaxAge(3600*24*30);
        response.addCookie(nameCookie);

        Cookie surnameCookie = new Cookie("u_surname",surname);
        surnameCookie.setMaxAge(3600*24*30);
        response.addCookie(surnameCookie);

        Cookie ageCookie = new Cookie("u_age",age);
        ageCookie.setMaxAge(3600*24*30);
        response.addCookie(ageCookie);

        Cookie countryCookie = new Cookie("u_country",country);
        countryCookie.setMaxAge(3600*24*30);
        response.addCookie(countryCookie);

        Cookie genderCookie = new Cookie("u_gender",gender);
        genderCookie.setMaxAge(3600/24*30);
        response.addCookie(genderCookie);

        Cookie creditCookie = new Cookie("u_credit",credit);
        creditCookie.setMaxAge(3600*24*30);
        response.addCookie(creditCookie);

        response.sendRedirect("/cookies");

    }
}
