package addendum.challenge.service;

import addendum.challenge.dao.IGenericDao;
import addendum.challenge.model.Beneficiary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiaryService implements IGenericService<Beneficiary> {
    private final IGenericDao<Beneficiary> beneficiaryDao;

    @Autowired
    public BeneficiaryService(@Qualifier("fakeBeneficiary") IGenericDao<Beneficiary> beneficiaryDao) {
        this.beneficiaryDao = beneficiaryDao;
    }

    @Override
    public int add(Beneficiary beneficiary) {
        return beneficiaryDao.add(beneficiary);
    }

    @Override
    public List<Beneficiary> getAll() {
        return beneficiaryDao.getAll();
    }

    @Override
    public Optional<Beneficiary> getById(Integer id) {
        return beneficiaryDao.getById(id);
    }

    @Override
    public int delete(Integer id) {
        return beneficiaryDao.delete(id);
    }

    @Override
    public int put(Integer id, Beneficiary beneficiary) {
        return beneficiaryDao.put(id, beneficiary);
    }
}
