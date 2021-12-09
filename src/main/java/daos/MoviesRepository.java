package daos;

import models.Movies;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoviesRepository implements MoviesDAO<Movies> {
    Connection connection = ConnectionFactory.getConnection();

    @Override
    public Movies findById(int id) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM movies WHERE id=" + id);

            if (rs.next()) {
                return extractMoviesFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Movies extractMoviesFromResultSet(ResultSet rs) throws SQLException {
        Movies movies = new Movies();

        movies.setId(rs.getInt("ID"));
        movies.setTitle(rs.getString("Title"));
        movies.setYear(rs.getInt("Year"));
        movies.setGenre(rs.getString("Genre"));
        movies.setRating(rs.getInt("RTRating"));

        return movies;
    }

    @Override
    public List<Movies> findAll() {
        List<Movies> movieSet = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM movies");

            while (rs.next()) {
                Movies movies = extractMoviesFromResultSet(rs);
                movieSet.add(movies);
            }
            return movieSet;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Movies update(Movies movies) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE movies SET title=?, year=?, genre=?, rtrating=? WHERE id=?");
            ps.setString(1, movies.getTitle());
            ps.setInt(2, movies.getYear());
            ps.setString(3, movies.getGenre());
            ps.setInt(4, movies.getRating());

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return movies;
    }

    @Override
    public Movies create(Movies movies) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO movies VALUES(DEFAULT, ?, ?, ?, ?)");
            ps.setString(1, movies.getTitle());
            ps.setInt(2, movies.getYear());
            ps.setString(3, movies.getGenre());
            ps.setInt(4, movies.getRating());
            int i = ps.executeUpdate();

            if (i == 1) {
                System.out.println("created movie");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {

        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM movies WHERE id=" + id);

            if (i == 1) {
                System.out.println("deleted movie");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
