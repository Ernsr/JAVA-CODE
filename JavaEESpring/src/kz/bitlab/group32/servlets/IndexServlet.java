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

@WebServlet(value = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Films> films = DBManager.getAllFilms();
        req.setAttribute("kinolar",films);

        ArrayList<Countries> countries = DBManager.getAllCountries();
        req.setAttribute("countries", countries);

        req.getRequestDispatcher("/index.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
