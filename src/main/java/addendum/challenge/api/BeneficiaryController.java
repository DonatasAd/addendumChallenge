package addendum.challenge.api;

import addendum.challenge.model.Beneficiary;
import addendum.challenge.service.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/beneficiary")
@RestController
public class BeneficiaryController implements IGenericController<Beneficiary> {

    private final BeneficiaryService beneficiaryService;

    @Autowired
    public BeneficiaryController(BeneficiaryService beneficiaryService) {
        this.beneficiaryService = beneficiaryService;
    }

    @Override
    public void add(Beneficiary beneficiary) {
        beneficiaryService.add(beneficiary);
    }

    @Override
    public List<Beneficiary> getAll() {
        return beneficiaryService.getAll();
    }

    @Override
    public Optional<Beneficiary> getById(Integer id) {
        return beneficiaryService.getById(id);
    }

    @Override
    public void delete(Integer id) {
        beneficiaryService.delete(id);
    }

    @Override
    public void put(Integer id, Beneficiary beneficiary) {
        beneficiaryService.put(id, beneficiary);
    }
}
