package addendum.challenge.service;

import addendum.challenge.dao.FakeBeneficiaryAccessService;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import addendum.challenge.model.Beneficiary;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QRCodeServiceTest {

    @Autowired
    private QRCodeService qrCodeService;

    @MockBean
    private FakeBeneficiaryAccessService fakeBeneficiaryAccessService;

    @Test
    public void getQRCodeTest() {
        when(fakeBeneficiaryAccessService.getBeneficiaryById(1))
                .thenReturn(Optional.of(new Beneficiary(1, UUID.fromString("0a25ceeb-1d43-42fe-bf20-19305049971f"), "Donatas")));
        String ExpectedUrl = "https://qrcode.tec-it.com/API/QRCode?data=%7B%22name%22%3ADonatas%22%2C%22unique_code%22%3A%220a25ceeb-1d43-42fe-bf20-19305049971f%22%7D";
        assertEquals(ExpectedUrl, qrCodeService.getQRCode(1).getUrl());
    }
}