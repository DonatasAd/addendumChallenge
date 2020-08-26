package addendum.challenge.model;

import java.util.UUID;

public class Factory {
    public QRCode GetQRCode(String url)
    {
        return new QRCode(url);
    }

    public Beneficiary GetBeneficiary(Integer id, UUID uniqueCode, String name) {
        return new Beneficiary.BeneficiaryBuilder().id(id).uniqueCode(uniqueCode).name(name).build();
    }
}
