package addendum.challenge.api;

import addendum.challenge.model.Beneficiary;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public interface IGenericController<C> {
    @PostMapping
    public void add(@RequestBody C object);

    @GetMapping
    public List<C> getAll();

    @GetMapping(path = "{id}")
    public Optional<C> getById(@PathVariable("id") Integer id);

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Integer id);

    @PutMapping (path = "{id}")
    public void put(@PathVariable("id") Integer id, @RequestBody C object);
}
