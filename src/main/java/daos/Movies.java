package daos;

import java.util.List;

public interface Movies<T> {

    T findById(int id);
    List<T> findAll();
    T update(T dto);
    T create(T dto);
    void delete(int id);
}