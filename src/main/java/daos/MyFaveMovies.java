package daos;

import java.util.ArrayList;
import java.util.List;

public class MyFaveMovies<T> implements Movies<T> {
    private List<T> movieList;
    private Integer id;
    private String title;
    private Integer year;
    private String genre;
    private Integer rating;

    public MyFaveMovies() {
        this(0, "Title", 1900, "Genre", 100);
    }

    public MyFaveMovies(int id, String title, Integer year, String genre, Integer rating) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
        this.movieList = new ArrayList<>();
    }

    @Override
    public T findById(int id) {
        return movieList.get(id);
    }

    @Override
    public List<T> findAll() {
        return this.movieList;
    }

    @Override
    public T update(T dto) {
        return null;
    }

    @Override
    public T create(T dto) {
        return null;
    }

    @Override
    public void delete(int id) {
        this.movieList.remove(id);
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getRating() {
        return this.rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
