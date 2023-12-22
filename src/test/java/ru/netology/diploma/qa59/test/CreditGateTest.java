package ru.netology.diploma.qa59.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.diploma.qa59.page.OfferPage;

import static ru.netology.diploma.qa59.data.DataHelper.getFstCardInfo;
import static ru.netology.diploma.qa59.data.DataHelper.getSndCardInfo;

public class CreditGateTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "firefox";
    }

    @BeforeEach
    void setup() {
        Selenide.open("http://localhost:8080");
    }

    @Test
    public void shouldPassPurchaseCrFstCard() {
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var fstCardInfo = getFstCardInfo();
        creditGate.fillCardFormSuccess(fstCardInfo);
    }

    @Test
    public void shouldNotPassPurchaseCrSndCard() { // в баг-репорт
        OfferPage creditGate = new OfferPage();
        creditGate.getPurchaseCr();
        var sndCardInfo = getSndCardInfo();
        creditGate.fillCardFormFail(sndCardInfo);
    }
}
