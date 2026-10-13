package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    T save(T entity);
    Optional<T> update(ID id, T data);
    boolean deleteById(ID id);
}
