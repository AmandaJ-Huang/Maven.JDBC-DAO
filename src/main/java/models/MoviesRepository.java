package models;

import java.util.ArrayList;
import java.util.List;

public class MoviesRepository<T> implements Movies<T> {
    List<T> movieList = new ArrayList<>();

    @Override
    public T findById(int id) {
        return this.movieList.get(id);
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

    }
}
