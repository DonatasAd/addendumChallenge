package addendum.challenge.dao;

import addendum.challenge.model.Beneficiary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Repository("fakeBeneficiary")
public class FakeBeneficiaryAccessService implements IGenericDao<Beneficiary> {

    private  static List<Beneficiary> DB = new ArrayList<>();
    private static final AtomicInteger count = new AtomicInteger(0);

    @Override
    public int add(Beneficiary beneficiary) {
        UUID uniqueCode = UUID.randomUUID();
        Integer id = count.incrementAndGet();
        String name = beneficiary.getName();
        DB.add(new Beneficiary.BeneficiaryBuilder().id(id).uniqueCode(uniqueCode).name(name).build());
        return 1;
    }

    @Override
    public List getAll() {
        return DB;
    }

    @Override
    public Optional<Beneficiary> getById(Integer id) {
        return DB.stream()
                .filter(beneficiary -> beneficiary.getId().equals(id))
                .findFirst();
    }

    @Override
    public int delete(Integer id) {
        Optional<Beneficiary> beneficiaryMaybe = getById(id);
        if( beneficiaryMaybe.isEmpty()){
            return 0;
        }
        DB.remove(beneficiaryMaybe.get());
        return 1;
    }

    @Override
    public int put(Integer id, Beneficiary beneficiary) {
        return getById(id).map(b -> {
            int indexOfBeneficiaryToUpdate = DB.indexOf(b);
            if(indexOfBeneficiaryToUpdate >= 0) {
                Beneficiary updatedBeneficiary = new Beneficiary.
                        BeneficiaryBuilder()
                        .id(b.getId())
                        .uniqueCode(b.getUniqueCode())
                        .name(beneficiary.getName())
                        .build();
                DB.set(indexOfBeneficiaryToUpdate, updatedBeneficiary);
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
