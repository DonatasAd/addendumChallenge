package addendum.challenge.service;

import addendum.challenge.model.Beneficiary;

import java.util.List;
import java.util.Optional;

public interface IGenericService<C> {

    public int add(C object);

    public List<C> getAll();

    public Optional<C> getById(Integer id);

    public int delete(Integer id);

    public int put(Integer id, C object);
}
