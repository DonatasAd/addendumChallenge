package addendum.challenge.dao;

import addendum.challenge.model.Beneficiary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Repository("fakeBeneficiary")
public class FakeBeneficiaryAccessService implements BeneficiaryDao {

    private  static List<Beneficiary> DB = new ArrayList<>();
    private static final AtomicInteger count = new AtomicInteger(0);

    @Override
    public int addBeneficiary(Beneficiary beneficiary) {
        UUID unique_code = UUID.randomUUID();
        Integer id = count.incrementAndGet();
        DB.add(new Beneficiary(id,unique_code,beneficiary.getName()));
        return 1;
    }

    @Override
    public List<Beneficiary> getAllBeneficiary() {
        return DB;
    }

    @Override
    public Optional<Beneficiary> getBeneficiaryById(Integer id) {
        return DB.stream()
                .filter(beneficiary -> beneficiary.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteBeneficiary(Integer id) {
        Optional<Beneficiary> beneficiaryMaybe = getBeneficiaryById(id);
        if( beneficiaryMaybe.isEmpty()){
            return 0;
        }
        DB.remove(beneficiaryMaybe.get());
        return 1;
    }

    @Override
    public int putBeneficiary(Integer id, Beneficiary beneficiary) {
        return getBeneficiaryById(id).map(b -> {
            int indexOfBeneficiaryToUpdate = DB.indexOf(b);
            if(indexOfBeneficiaryToUpdate >= 0) {
                Beneficiary updatedBeneficiary= new Beneficiary(b.getId(), b.getUnique_code(), beneficiary.getName());
                DB.set(indexOfBeneficiaryToUpdate, updatedBeneficiary);
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
