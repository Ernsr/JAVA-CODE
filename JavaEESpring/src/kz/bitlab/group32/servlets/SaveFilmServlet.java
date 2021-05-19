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

@WebServlet(value = "/savefilm")
public class SaveFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("film_name");
        String desc = req.getParameter("film_description");
        Long countryId = Long.parseLong(req.getParameter("film_country"));
        int duration = Integer.parseInt(req.getParameter("film_duration"));
        String genre = req.getParameter("film_genre");

        Long id = -1L;

        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (Exception e) {
        }

        Films film = DBManager.getFilm(id);

        if (film != null) {

            Countries checkCountry = DBManager.getCountry(countryId);

            if (checkCountry!= null) {

                film.setName(name);
                film.setDescription(desc);
                film.setDuration(duration);
                film.setGenre(genre);
                film.setCountry(checkCountry);

                DBManager.savaFilm(film);
            }

            resp.sendRedirect("/details?id=" + id);


        } else {
            resp.sendRedirect("/");
        }
    }
}
