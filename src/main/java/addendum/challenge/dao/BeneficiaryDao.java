package addendum.challenge.dao;

import addendum.challenge.model.Beneficiary;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public interface BeneficiaryDao {

    int addBeneficiary(Beneficiary beneficiary);

    List<Beneficiary> getAllBeneficiary();

    Optional<Beneficiary> getBeneficiaryById(Integer id);

    int deleteBeneficiary(Integer id);

    int putBeneficiary(Integer id, Beneficiary beneficiary);
}
