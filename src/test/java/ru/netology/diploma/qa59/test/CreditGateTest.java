package ru.netology.diploma.qa59.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.diploma.qa59.data.SQLHelper;
import ru.netology.diploma.qa59.page.OfferPage;

import static org.junit.Assert.assertEquals;
import static ru.netology.diploma.qa59.data.DataHelper.*;
import static ru.netology.diploma.qa59.data.SQLHelper.*;

public class CreditGateTest {

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
    public void shouldPassPurchaseCrFstCard() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormSuccess(fstCardInfo);
        assertEquals("APPROVED", SQLHelper.getStatusCrRqst());
    }

    @Test
    public void shouldNotPassPurchaseCrSndCard() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var sndCardInfo = getSndCardInfo();
        creditGate.fillCardFormFail(sndCardInfo);
        assertEquals("DECLINED", getStatusCrRqst());
    }

    @Test
    public void shouldNotPassPurchaseCrFstCardNrFormat() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormFailCardNrFormat(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrFstCardMonthFormat() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormFailMonthFormat(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrFstCardYearFormat() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormFailYearFormat(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrFstCardNameCyrillic() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormFailNameCyrillic(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrFstCardNameJapan() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormFailNameJapan(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrFstCardNameLatOneLetter() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormFailNameLatOneLetter(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrFstCardNameSpecChar() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormFailNameSpecChar(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrFstCardNameDigits() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormFailNameDigits(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrFstCardNameSpace() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormFailNameSpace(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrFstCardCodeCvvFormat() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormFailCodeCvvFormat(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrInvalidCard() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var invalidCardInfo = getInvalidCardInfo();
        creditGate.fillCardFormFail(invalidCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrVoidCard() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var voidCardInfo = getVoidCardInfo();
        creditGate.fillCardFormFail(voidCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrFstCardMonthInvalid() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormFailMonthInvalid(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrFstCardYearInvalid() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormFailYearInvalid(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrFstCardNrEmpty() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormFailCardEmpty(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrFstCardMonthEmpty() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormFailMonthEmpty(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrFstCardYearEmpty() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormFailYearEmpty(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrFstCardNameEmpty() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormFailNameEmpty(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrFstCardCodeCvvEmpty() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormFailCodeCvvEmpty(fstCardInfo);
    }
}