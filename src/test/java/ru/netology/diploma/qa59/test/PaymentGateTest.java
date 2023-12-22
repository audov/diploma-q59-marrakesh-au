package ru.netology.diploma.qa59.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.diploma.qa59.data.SQLHelper;
import ru.netology.diploma.qa59.page.OfferPage;

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
    }

    @Test
    public void shouldNotPassPurchaseDrSndCard() { // в баг-репорт
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var sndCardInfo = getSndCardInfo();
        paymentGate.fillCardFormFail(sndCardInfo);
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
    public void shouldNotPassPurchaseDrFstCardNameCyrillic() { // в баг-репорт
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailNameCyrillic(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardNameLatOneLetter() { // в баг-репорт
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailNameLatOneLetter(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardNameSymbols() { // в баг-репорт
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailNameSymbols(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardNameDigits() { // в баг-репорт
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        var fstCardInfo = getFstCardInfo();
        paymentGate.fillCardFormFailNameDigits(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseDrFstCardNameSpace() { // в баг-репорт
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

    @Test
    public void shouldReturnSQLDataWithoutCardNr() { // доработка
        OfferPage paymentGate = new OfferPage();
        paymentGate.getPurchaseDr();
        shouldPassPurchaseDrFstCard();
        SQLHelper.SQLCrRqst request = getSQLInfoCrRqst();
        SQLHelper.SQLOrder order = getSQLInfoOrder();
        SQLHelper.SQLPayment payment = getSQLInfoPayment();
        System.out.println(request);
        System.out.println(order);
        System.out.println(payment);
    }

//    @Test
//    public void shouldReturnAPIData() {
//        APIHelper.UICardInfo uiCardInfo = DataHelper.CardInfo.getFstCardInfo();
//        APIHelper.sendQueryToValidate(UICardInfo(DataHelper.getFstCardInfo()),200,"APPROVED");
//    }
}