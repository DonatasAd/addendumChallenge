package addendum.challenge.service;

import addendum.challenge.dao.FakeBeneficiaryAccessService;
import addendum.challenge.model.Beneficiary;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class BeneficiaryServiceTest {

    private Beneficiary mockBeneficiary = new Beneficiary(1, UUID.fromString("0a25ceeb-1d43-42fe-bf20-19305049971f"), "Donatas");
    @Autowired
    private BeneficiaryService beneficiaryService;

    @MockBean
    private FakeBeneficiaryAccessService fakeBeneficiaryAccessService;

    @Test
    void addBeneficiary() {

        when(fakeBeneficiaryAccessService
                .addBeneficiary(mockBeneficiary))
                .thenReturn(1);
        assertEquals(1, beneficiaryService.addBeneficiary(mockBeneficiary));
    }

    @Test
    void getBeneficiaryById() {
        when(fakeBeneficiaryAccessService.getBeneficiaryById(1))
                .thenReturn(Optional.of(mockBeneficiary));
        assertEquals(mockBeneficiary, beneficiaryService.getBeneficiaryById(1).get());
    }

    @Test
    void deleteBeneficiary() {
        when(fakeBeneficiaryAccessService.deleteBeneficiary(1))
                .thenReturn(1);
        assertEquals(1, beneficiaryService.deleteBeneficiary(1));
    }

    @Test
    void putBeneficiary() {
        when(fakeBeneficiaryAccessService.putBeneficiary(1,mockBeneficiary))
                .thenReturn(1);
        assertEquals(1, beneficiaryService.putBeneficiary(1,mockBeneficiary));
    }
}