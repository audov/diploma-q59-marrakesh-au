package ru.netology.diploma.qa59.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import ru.netology.diploma.qa59.data.SQLHelper;
import ru.netology.diploma.qa59.page.OfferPage;

import static org.junit.Assert.assertEquals;
import static ru.netology.diploma.qa59.data.DataHelper.*;
import static ru.netology.diploma.qa59.data.SQLHelper.*;

public class PaymentGateTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "firefox";
    }

    @BeforeEach
    void setup() {
        Selenide.open("http://localhost:8080");
    }

    @AfterEach
    void cleanDB() {
        SQLHelper.cleanDatabase();
    }

    @Test
    public void shouldLoadPage() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.shouldLoadPage();
    }

    @Test
    public void shouldPassPurchaseDrFstCard() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormSuccess(fstCardInfo);
        assertEquals("APPROVED", SQLHelper.getStatusPayment());
    }

    @Test
    public void shouldNotPassPurchaseDrSndCard() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var sndCardInfo = getSndCardInfo();
        paymentGate.fillCardFormFail(sndCardInfo);
        assertEquals("DECLINED", SQLHelper.getStatusPayment());
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardNrFormat() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailCardNrFormat(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardMonthFormat() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailMonthFormat(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardYearFormat() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailYearFormat(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardNameCyrillic() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailNameCyrillic(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardNameJapan() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailNameJapan(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardNameLatOneLetter() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailNameLatOneLetter(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardNameSpecChar() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailNameSpecChar(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardNameDigits() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailNameDigits(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardNameSpace() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailNameSpace(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardCodeCvvFormat() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailCodeCvvFormat(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrInvalidCard() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var invalidCardInfo = getInvalidCardInfo();
        paymentGate.fillCardFormFail(invalidCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardMonthInvalid() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailMonthInvalid(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardYearInvalid() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailYearInvalid(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardNrEmpty() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailCardEmpty(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardMonthEmpty() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailMonthEmpty(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardYearEmpty() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailYearEmpty(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardNameEmpty() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailNameEmpty(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardCodeCvvEmpty() {
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailCodeCvvEmpty(fstCardInfo);
    }
}