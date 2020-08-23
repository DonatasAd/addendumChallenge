package addendum.challenge.api;

import addendum.challenge.model.Beneficiary;
import addendum.challenge.service.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/beneficiary")
@RestController
public class BeneficiaryController {

    private final BeneficiaryService beneficiaryService;

    @Autowired
    public BeneficiaryController(BeneficiaryService beneficiaryService) {
        this.beneficiaryService = beneficiaryService;
    }

    @PostMapping
    public void addBeneficiary(@RequestBody Beneficiary beneficiary){
        beneficiaryService.addBeneficiary(beneficiary);
    }

    @GetMapping
    public List<Beneficiary> getAllBeneficiary(){
        return beneficiaryService.getAllBeneficiary();
    }

    @GetMapping(path = "{id}")
    public Optional<Beneficiary> getBeneficiaryById(@PathVariable("id") Integer id){
        return beneficiaryService.getBeneficiaryById(id);
    }

    @DeleteMapping (path = "{id}")
    public void deleteBeneficiary(@PathVariable("id") Integer id) {
        beneficiaryService.deleteBeneficiary(id);
    }

    @PutMapping (path = "{id}")
    public void putBeneficiary(@PathVariable("id") Integer id, @RequestBody Beneficiary beneficiary) {
        beneficiaryService.putBeneficiary(id, beneficiary);
    }
}
