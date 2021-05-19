package kz.bitlab.group32.servlets;

import kz.bitlab.group32.db.Countries;
import kz.bitlab.group32.db.DBManager;
import kz.bitlab.group32.db.Films;
import kz.bitlab.group32.db.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/addfilm")
public class AddFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Users currentUser = (Users)req.getSession().getAttribute("CURRENT_USER");

        if (currentUser != null) {


            ArrayList<Countries> countries = DBManager.getAllCountries();
            req.setAttribute("countries", countries);

            req.getRequestDispatcher("/addfilm.jsp").forward(req, resp);

        } else {

            resp.sendRedirect("/login");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("film_name");
        String desc = req.getParameter("film_description");
        Long countryId = Long.parseLong(req.getParameter("film_country"));
        int duration = Integer.parseInt(req.getParameter("film_duration"));
        String genre = req.getParameter("film_genre");

        Countries checkCountry = DBManager.getCountry(countryId);

        if (checkCountry!= null) {


        Films f = new Films();
        f.setName(name);
        f.setGenre(genre);
        f.setDuration(duration);
        f.setDescription(desc);
        f.setCountry(checkCountry);
        DBManager.addFilm(f);

    }
        resp.sendRedirect("/");
    }
}
