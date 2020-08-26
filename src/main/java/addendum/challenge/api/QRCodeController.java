package addendum.challenge.api;

import addendum.challenge.dao.IGenericDao;
import addendum.challenge.model.QRCode;
import addendum.challenge.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/qrcode")
@RestController
public class QRCodeController implements IGenericController<QRCode> {

    private final QRCodeService qrCodeService;

    @Autowired
    public QRCodeController(QRCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @Override
    public void add(QRCode object) {

    }

    @Override
    public List<QRCode> getAll() {
        return null;
    }

    @Override
    public Optional<QRCode> getById(Integer id) {
        return qrCodeService.getById(id);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void put(Integer id, QRCode object) {

    }
}
