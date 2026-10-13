package tn.esprit.projet.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet.services.CrudService;

import java.util.List;
import java.util.Optional;

public abstract class CrudServiceImpl<T, ID, R extends JpaRepository<T, ID>> implements CrudService<T, ID> {
    protected final R repository;

    protected CrudServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<T> update(ID id, T data) {
        return repository.findById(id).map(existing -> {
            applyUpdates(existing, data);
            return repository.save(existing);
        });
    }

    @Override
    public boolean deleteById(ID id) {
        return repository.findById(id).map(existing -> {
            repository.delete(existing);
            return true;
        }).orElse(false);
    }

    protected abstract void applyUpdates(T existing, T data);
}
