package addendum.challenge.service;

import addendum.challenge.dao.BeneficiaryDao;
import addendum.challenge.model.Beneficiary;
import addendum.challenge.model.QRCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Optional;

@Service
public class QRCodeService {

    private final BeneficiaryDao beneficiaryDao;

    @Autowired
    public QRCodeService(@Qualifier("fakeBeneficiary") BeneficiaryDao beneficiaryDao) {
        this.beneficiaryDao = beneficiaryDao;
    }

    public QRCode getQRCode(Integer id) {
        Optional<Beneficiary> beneficiary = beneficiaryDao.getBeneficiaryById(id);
        if(beneficiary.isEmpty()){
            return null;
        }
        String encodedString = "";
        try {
            String beneficiaryJson = beneficiary.get().toJson();
            encodedString = URLEncoder.encode(beneficiaryJson, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new QRCode("https://qrcode.tec-it.com/API/QRCode?data=" + encodedString);
    }
}
