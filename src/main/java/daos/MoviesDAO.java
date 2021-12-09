package daos;

import java.util.List;

public interface MoviesDAO<T> {

    T findById(int id);
    List<T> findAll();
    T update(T movies);
    T create(T movies);
    void delete(int id);
}
