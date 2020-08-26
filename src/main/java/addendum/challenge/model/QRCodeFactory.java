package addendum.challenge.model;

public class QRCodeFactory {
    public QRCode GetQRCode(String url)
    {
        return new QRCode(url);
    }
}
