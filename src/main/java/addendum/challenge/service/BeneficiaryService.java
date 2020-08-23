package addendum.challenge.service;

import addendum.challenge.dao.BeneficiaryDao;
import addendum.challenge.model.Beneficiary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiaryService {

    private final BeneficiaryDao beneficiaryDao;

    @Autowired
    public BeneficiaryService(@Qualifier("fakeBeneficiary") BeneficiaryDao beneficiaryDao) {
        this.beneficiaryDao = beneficiaryDao;
    }

    public int addBeneficiary(Beneficiary beneficiary) {
        return beneficiaryDao.addBeneficiary(beneficiary);
    }

    public List<Beneficiary> getAllBeneficiary(){
        return beneficiaryDao.getAllBeneficiary();
    }

    public Optional<Beneficiary> getBeneficiaryById(Integer id) {
        return beneficiaryDao.getBeneficiaryById(id);
    }

    public int deleteBeneficiary(Integer id) {
        return beneficiaryDao.deleteBeneficiary(id);
    }

    public int putBeneficiary(Integer id, Beneficiary beneficiary) {
        return beneficiaryDao.putBeneficiary(id, beneficiary);
    }
}
