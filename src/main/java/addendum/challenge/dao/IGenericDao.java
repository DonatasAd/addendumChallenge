package addendum.challenge.dao;

import addendum.challenge.model.Beneficiary;

import java.util.List;
import java.util.Optional;

public interface IGenericDao<C> {
    int add(C object);

    List<C> getAll();

    Optional<C> getById(Integer id);

    int delete(Integer id);

    int put(Integer id, C object);
}
