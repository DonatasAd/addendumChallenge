package addendum.challenge.service;

import addendum.challenge.dao.IGenericDao;
import addendum.challenge.model.Beneficiary;
import addendum.challenge.model.QRCode;
import addendum.challenge.model.QRCodeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;

@Service
public class QRCodeService implements IGenericService<QRCode> {

    private final IGenericDao<Beneficiary> beneficiaryDao;

    @Autowired
    public QRCodeService(@Qualifier("fakeBeneficiary") IGenericDao<Beneficiary> beneficiaryDao) {
        this.beneficiaryDao = beneficiaryDao;
    }

    @Override
    public int add(QRCode object) {
        return 0;
    }

    @Override
    public List<QRCode> getAll() {
        return null;
    }

    @Override
    public Optional<QRCode> getById(Integer id) {
        Optional<Beneficiary> beneficiary = beneficiaryDao.getById(id);
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
        QRCodeFactory factory = new QRCodeFactory();
        QRCode code = factory.GetQRCode("https://qrcode.tec-it.com/API/QRCode?data=" + encodedString);
        return Optional.of(code);
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public int put(Integer id, QRCode object) {
        return 0;
    }
}
