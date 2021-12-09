import daos.MoviesRepository;
import models.Movies;
import models.MoviesBuilder;

public class AppRunner {
    public static void main(String[] args) {
        MoviesRepository moviesRepository = new MoviesRepository();

        // new movies
        Movies grandBudapest = new MoviesBuilder()
                .setTitle("The Grand Budapest Hotel")
                .setRating(92)
                .setGenre("Comedy")
                .setYear(2014)
                .createMovies();

        Movies knivesOut = new MoviesBuilder()
                .setTitle("Knives Out")
                .setRating(97)
                .setGenre("Crime")
                .setYear(2019)
                .createMovies();

        // running CRUD operation against MoviesRepositoryDAO
        Movies gb = moviesRepository.create(grandBudapest);
        Movies kO = moviesRepository.create(knivesOut);

        // should return all movies
        System.out.println(moviesRepository.findAll());

        // should return Spider-Man
        System.out.println(moviesRepository.findById(3));

        // should remove knivesOut
//        moviesRepository.delete(7);

        // should update Ratatouille

    }


}
