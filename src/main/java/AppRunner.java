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

        Movies ratatouille = moviesRepository.findById(4);
        ratatouille.setGenre("Family");

        // running CRUD operation against MoviesRepositoryDAO
//        Movies gb = moviesRepository.create(grandBudapest);
//        Movies kO = moviesRepository.create(knivesOut);

        // should return Spider-Man - yes
//        System.out.println(moviesRepository.findById(3));

        // should remove knivesOut - yes
//        moviesRepository.delete(7);

        // should update - YEP

        moviesRepository.update(ratatouille);

        // should return all movies - yes
        System.out.println(moviesRepository.findAll());
    }
}
