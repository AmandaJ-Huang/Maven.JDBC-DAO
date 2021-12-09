package models;

public class MoviesBuilder {
    private Integer id;
    private String title;
    private Integer year;
    private String genre;
    private Integer rating;

    public MoviesBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public MoviesBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public MoviesBuilder setYear(Integer year) {
        this.year = year;
        return this;
    }

    public MoviesBuilder setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public MoviesBuilder setRating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public Movies createMovies() {
        return new Movies(title, year, genre, rating);
    }
}
