package kz.bitlab.group32.servlets;

import kz.bitlab.group32.db.DBManager;
import kz.bitlab.group32.db.Films;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (value = "/deletefilm")
public class DeleteFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = -1L;

        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (Exception e) {}

        Films film = DBManager.getFilm(id);

        if (film != null) {
            DBManager.deleteFilm(id);
        }

        resp.sendRedirect("/");
    }
}
