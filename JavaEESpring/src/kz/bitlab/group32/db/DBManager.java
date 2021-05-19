package kz.bitlab.group32.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

public class DBManager {

    private static Connection connection;

    static {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/group_32_db?serverTimezone=UTC", "root", "");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Films> getAllFilms() {

        ArrayList<Films> films = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT f.id, f.name, f.genre, f.duration, f.description, f.country_id, c.name as country_name, c.code FROM films f " +
                    "INNER JOIN countries c ON c.id = f.country_id " +
                    "ORDER BY f.name ASC");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                films.add(
                        new Films(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("duration"),
                                resultSet.getString("description"),
                                resultSet.getString("genre"),
                                new Countries(
                                        resultSet.getLong("country_id"),
                                        resultSet.getString("country_name"),
                                        resultSet.getString("code")
                                )
                        )
                );
            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return films;
    }


    public static ArrayList<Films> searchFilms(String key) {
        return null;
    }

    public static boolean addFilm(Films film) {

        int rows = 0;

        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO films(name, duration, description, genre, country_id) " + "VALUES (?,?,?,?,?) ");

            statement.setString(1, film.getName());
            statement.setInt(2, film.getDuration());
            statement.setString(3, film.getDescription());
            statement.setString(4, film.getGenre());
            statement.setLong(5, film.getCountry().getId());

            rows = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rows > 0;
    }

    public static Films getFilm(Long id) {

        Films film = null;

        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT f.id, f.name, f.genre, f.duration, f.description, f.country_id, c.name as country_name, c.code FROM films f " +
                    "INNER JOIN countries c ON c.id = f.country_id " +
                    "WHERE f.id = ?");

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                film = new Films(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("genre"),
                        new Countries(
                                resultSet.getLong("country_id"),
                                resultSet.getString("country_name"),
                                resultSet.getString("code")
                        )
                );

            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return film;
    }

    public static boolean savaFilm(Films film) {

        int rows = 0;

        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE films " +
                    "SET name = ?, description = ?,duration = ?, country_id = ?, genre = ? " +
                    "WHERE id = ?");

            statement.setString(1, film.getName());
            statement.setString(2, film.getDescription());
            statement.setInt(3, film.getDuration());
            statement.setLong(4, film.getCountry().getId());
            statement.setString(5, film.getGenre());
            statement.setLong(6, film.getId());

            rows = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rows > 0;
    }

    public static boolean deleteFilm(Long id) {

        int rows = 0;

        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM films WHERE id = ?");


            statement.setLong(1, id);

            rows = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rows > 0;
    }

    public static ArrayList<Countries> getAllCountries() {

        ArrayList<Countries> countries = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM countries ORDER BY name ASC ");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                countries.add(
                        new Countries(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getString("code")
                        )
                );
            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }


    public static Countries getCountry(Long id) {
        Countries country = null;

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM countries WHERE id = ?");
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                country = new Countries(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("code")
                );
                statement.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

    public static Users getUsers(String email){
        Users users = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            statement.setString(1,email);

            ResultSet resultSet = statement.executeQuery();


            if (resultSet.next()) {

                users = new Users(

                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name")

                );
                statement.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
