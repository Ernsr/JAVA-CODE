package kz.bitlab.group32.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
//        System.out.println(session.getId());


        session.setAttribute("userName","Atabay Zakir");

        String data = (String) request.getSession().getAttribute("data");
        if (data == null) data = "No Data";
        request.setAttribute("data",data);

        request.getRequestDispatcher("/session.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String age = request.getParameter("age");

        String data = "YOU ARE" + name + " " + surname + " " + age;

        request.getSession().setAttribute("text_data",data);
        response.sendRedirect("/");

    }
}
