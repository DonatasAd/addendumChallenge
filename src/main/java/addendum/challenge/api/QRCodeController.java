package addendum.challenge.api;

import addendum.challenge.model.QRCode;
import addendum.challenge.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/qrcode")
@RestController
public class QRCodeController {

    private final QRCodeService qrCodeService;

    @Autowired
    public QRCodeController(QRCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @GetMapping(path = "{id}")
    public QRCode getQRCodeById(@PathVariable("id") Integer id)
    {
        return qrCodeService.getQRCode(id);
    }
}
