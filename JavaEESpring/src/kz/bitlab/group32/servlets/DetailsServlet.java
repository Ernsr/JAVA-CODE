package kz.bitlab.group32.servlets;

import kz.bitlab.group32.db.Countries;
import kz.bitlab.group32.db.DBManager;
import kz.bitlab.group32.db.Films;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/details")
public class DetailsServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = -1L;

        try {

            id = Long.parseLong(req.getParameter("id"));

        } catch (Exception e) {
        }

        Films film = DBManager.getFilm(id);
        req.setAttribute("film",film);

        ArrayList<Countries> countries = DBManager.getAllCountries();
        req.setAttribute("countries",countries);

        req.getRequestDispatcher("/details.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
