package ru.netology.diploma.qa59.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static ru.netology.diploma.qa59.data.DataHelper.*;

public class OfferPage {

    private static final SelenideElement cardImage = $(".Order_cardImage__Q69ii");
    private static final SelenideElement appContainer = $("h2");
    private static final SelenideElement cardHeading = $("h3");
    private static final SelenideElement listItem1 = $(byText("Сказочный Восток"));
    private static final SelenideElement listItem2 = $(byText("33 360 миль на карту"));
    private static final SelenideElement listItem3 = $(byText("До 7% на остаток по счёту"));
    private static final SelenideElement purchaseDrButton = $$(".button").findBy((text("Купить")));
    private static final SelenideElement paymentHeaderDr = $$(".heading_size_m").findBy((text("Оплата по карте")));
    private static final SelenideElement purchaseCrButton = $$(".button__text").findBy((text("Купить в кредит")));
    private static final SelenideElement paymentHeaderCr = $$(".heading_size_m").findBy((text("Кредит по данным карты")));
    static final SelenideElement cardNrField = $(byAttribute("placeholder", "0000 0000 0000 0000"));
    static final SelenideElement cardMonthField = $(byAttribute("placeholder", "08"));
    private static final SelenideElement cardYearField = $(byAttribute("placeholder", "22"));
    private static final SelenideElement cardOwnerField = $(byAttribute("value", ""));
    private static final SelenideElement cardCvcCvvNr = $(byAttribute("placeholder", "999"));
    private static final SelenideElement continueButton = $$(".button").findBy((text("Продолжить")));
    private static final SelenideElement successNotificationTitle = $$(".notification__title").findBy((text("Успешно")));
    private static final SelenideElement successNotificationNote = $$(".notification__content").findBy((text("Операция одобрена Банком.")));
    private static final SelenideElement alertNoticeCardNrFormat = $$(".input__sub").findBy(text("Неверный формат"));
    private static final SelenideElement alertNoticeCardMonthFormat = $$(".input__sub").findBy(text("Неверный формат"));
    private static final SelenideElement alertNoticeCardYearFormat = $$(".input__sub").findBy(text("Неверный формат"));
    private static final SelenideElement alertNoticeCardCodeFormat = $$(".input__sub").findBy(text("Неверный формат"));
    private static final SelenideElement alertNoticeCardOwnerFormat = $$(".input__sub").findBy(text("Неверный формат"));
    private static final SelenideElement alertNoticeCardOwnerEmpty = $$(".input__sub").findBy(text("Поле обязательно для заполнения"));
    private static final SelenideElement alertNoticeCardMonthInvalid = $$(".input__sub").findBy(text("Неверно указан срок действия карты"));
    private static final SelenideElement alertNoticeCardYearInvalid = $$(".input__sub").findBy(text("Неверно указан срок действия карты"));
    private static final SelenideElement failNotificationTitle = $$(".notification__title").findBy((text("Ошибка")));
    private static final SelenideElement failNotificationNote = $$(".notification__content").findBy((text("Ошибка! Банк отказал в проведении операции.")));
    private static final SelenideElement iconClose = $(".icon_name_close");

    public void shouldLoadPage() {
        appContainer
                .shouldBe(visible)
                .shouldHave(Condition.exactText("Путешествие дня"));
        cardImage.isImage();
        cardHeading.shouldBe(visible)
                .shouldHave(Condition.exactText("Марракэш"));
        listItem1
                .shouldBe(visible)
                .shouldHave(Condition.exactText("Сказочный Восток"));
        listItem2
                .shouldBe(visible)
                .shouldHave(Condition.exactText("33 360 миль на карту"));
        listItem3
                .shouldBe(visible)
                .shouldHave(Condition.exactText("До 7% на остаток по счёту"));
    }

    public void getPurchaseDr() {
        purchaseDrButton.click();
        paymentHeaderDr
                .shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void getPurchaseCr() {
        purchaseCrButton.click();
        paymentHeaderCr
                .shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void fillCardFormSuccess(CardInfo cardInfo) {
        cardNrField.setValue(cardInfo.getCardNr());
        cardMonthField.setValue(generateValidDate("MM"));
        cardYearField.setValue(generateValidDate("yy"));
        cardOwnerField.setValue(getRandomSurnameName("en"));
        cardCvcCvvNr.setValue(getRandomCardValidCode());
        continueButton.click();
        successNotificationTitle
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Успешно"));
        successNotificationNote
                .shouldHave(Condition.exactText("Операция одобрена Банком."));
        iconClose.click();
    }

    public void fillCardFormFail(CardInfo cardInfo) {
        cardNrField.setValue(cardInfo.getCardNr());
        cardMonthField.setValue(generateValidDate("MM"));
        cardYearField.setValue(generateValidDate("yy"));
        cardOwnerField.setValue(getRandomSurnameName("en"));
        cardCvcCvvNr.setValue(getRandomCardValidCode());
        continueButton.click();
        failNotificationTitle
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Ошибка"));
        failNotificationNote
                .shouldHave(Condition.exactText("Ошибка! Банк отказал в проведении операции."));
    }

    public void fillCardFormFailCardNrFormat(CardInfo cardInfo) {
        cardNrField.setValue(cardInfo.getCardNr().substring(1, 15));
        cardMonthField.setValue(generateValidDate("MM"));
        cardYearField.setValue(generateValidDate("yy"));
        cardOwnerField.setValue(getRandomSurnameName("en"));
        cardCvcCvvNr.setValue(getRandomCardValidCode());
        continueButton.click();
        alertNoticeCardNrFormat
                .shouldHave(Condition.exactText("Неверный формат"));
    }

    public void fillCardFormFailMonthFormat(CardInfo cardInfo) {
        cardNrField.setValue(cardInfo.getCardNr());
        cardMonthField.setValue(generateValidDate("MM").substring(1, 1));
        cardYearField.setValue(generateValidDate("yy"));
        cardOwnerField.setValue(getRandomSurnameName("en"));
        cardCvcCvvNr.setValue(getRandomCardValidCode());
        continueButton.click();
        alertNoticeCardMonthFormat
                .shouldHave(Condition.exactText("Неверный формат"));
    }

    public void fillCardFormFailYearFormat(CardInfo cardInfo) {
        cardNrField.setValue(cardInfo.getCardNr());
        cardMonthField.setValue(generateValidDate("MM"));
        cardYearField.setValue(generateValidDate("yy").substring(1, 1));
        cardOwnerField.setValue(getRandomSurnameName("en"));
        cardCvcCvvNr.setValue(getRandomCardValidCode());
        continueButton.click();
        alertNoticeCardYearFormat
                .shouldHave(Condition.exactText("Неверный формат"));
    }

    public void fillCardFormFailCodeCvvFormat(CardInfo cardInfo) {
        cardNrField.setValue(cardInfo.getCardNr());
        cardMonthField.setValue(generateValidDate("MM"));
        cardYearField.setValue(generateValidDate("yy"));
        cardOwnerField.setValue(getRandomSurnameName("en"));
        cardYearField.setValue(generateValidDate("yy"));
        continueButton.click();
        alertNoticeCardCodeFormat
                .shouldHave(Condition.exactText("Неверный формат"));
    }

    public void fillCardFormFailNameCyrillic(CardInfo cardInfo) {
        cardNrField.setValue(cardInfo.getCardNr());
        cardMonthField.setValue(generateValidDate("MM"));
        cardYearField.setValue(generateValidDate("yy"));
        cardOwnerField.setValue(getRandomSurnameName("ru"));
        cardCvcCvvNr.setValue(getRandomCardValidCode());
        continueButton.click();
        alertNoticeCardOwnerFormat
                .shouldHave(Condition.exactText("Неверный формат"));
    }

    public void fillCardFormFailNameJapan(CardInfo cardInfo) {
        cardNrField.setValue(cardInfo.getCardNr());
        cardMonthField.setValue(generateValidDate("MM"));
        cardYearField.setValue(generateValidDate("yy"));
        cardOwnerField.setValue(getRandomSurnameName("ja"));
        cardCvcCvvNr.setValue(getRandomCardValidCode());
        continueButton.click();
        alertNoticeCardOwnerFormat
                .shouldHave(Condition.exactText("Неверный формат"));
    }

    public void fillCardFormFailNameLatOneLetter(CardInfo cardInfo) {
        cardNrField.setValue(cardInfo.getCardNr());
        cardMonthField.setValue(generateValidDate("MM"));
        cardYearField.setValue(generateValidDate("yy"));
        cardOwnerField.setValue(getRandomSurnameName("en").substring(1, 2));
        cardCvcCvvNr.setValue(getRandomCardValidCode());
        continueButton.click();
        alertNoticeCardOwnerFormat
                .shouldHave(Condition.exactText("Неверный формат"));
    }

    public void fillCardFormFailNameSpecChar(CardInfo cardInfo) {
        cardNrField.setValue(cardInfo.getCardNr());
        cardMonthField.setValue(generateValidDate("MM"));
        cardYearField.setValue(generateValidDate("yy"));
        cardOwnerField.setValue(generateSpecChar());
        cardCvcCvvNr.setValue(getRandomCardValidCode());
        continueButton.click();
        alertNoticeCardOwnerFormat
                .shouldHave(Condition.exactText("Неверный формат"));
    }

    public void fillCardFormFailNameDigits(CardInfo cardInfo) {
        cardNrField.setValue(cardInfo.getCardNr());
        cardMonthField.setValue(generateValidDate("MM"));
        cardYearField.setValue(generateValidDate("yy"));
        cardOwnerField.setValue(getRandomCardValidCode());
        cardCvcCvvNr.setValue(getRandomCardValidCode());
        continueButton.click();
        alertNoticeCardOwnerFormat
                .shouldHave(Condition.exactText("Неверный формат"));
    }

    public void fillCardFormFailNameSpace(CardInfo cardInfo) {
        cardNrField.setValue(cardInfo.getCardNr());
        cardMonthField.setValue(generateValidDate("MM"));
        cardYearField.setValue(generateValidDate("yy"));
        cardOwnerField.setValue(" ");
        cardCvcCvvNr.setValue(getRandomCardValidCode());
        continueButton.click();
        alertNoticeCardOwnerFormat
                .shouldHave(Condition.exactText("Неверный формат"));
    }

    public void fillCardFormFailMonthInvalid(CardInfo cardInfo) {
        cardNrField.setValue(cardInfo.getCardNr());
        cardMonthField.setValue(String.valueOf(generateInvalidMonth()));
        cardYearField.setValue(generateValidDate("yy"));
        cardOwnerField.setValue(getRandomSurnameName("en"));
        cardCvcCvvNr.setValue(getRandomCardValidCode());
        continueButton.click();
        alertNoticeCardMonthInvalid
                .shouldHave(Condition.exactText("Неверно указан срок действия карты"));
    }

    public void fillCardFormFailYearInvalid(CardInfo cardInfo) {
        cardNrField.setValue(cardInfo.getCardNr());
        cardMonthField.setValue(generateInvalidDate("MM"));
        cardYearField.setValue(generateInvalidDate("yy"));
        cardOwnerField.setValue(getRandomSurnameName("en"));
        cardCvcCvvNr.setValue(getRandomCardValidCode());
        continueButton.click();
        alertNoticeCardYearInvalid
                .shouldHave(Condition.exactText("Неверно указан срок действия карты"));
    }

    public void fillCardFormFailCardEmpty(CardInfo cardInfo) {
        cardNrField.setValue("");
        cardMonthField.setValue(generateValidDate("MM"));
        cardYearField.setValue(generateValidDate("yy"));
        cardOwnerField.setValue(getRandomSurnameName("en"));
        cardCvcCvvNr.setValue(getRandomCardValidCode());
        continueButton.click();
        alertNoticeCardOwnerEmpty
                .shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void fillCardFormFailMonthEmpty(CardInfo cardInfo) {
        cardNrField.setValue(cardInfo.getCardNr());
        cardMonthField.setValue("");
        cardYearField.setValue(generateValidDate("yy"));
        cardOwnerField.setValue(getRandomSurnameName("en"));
        cardCvcCvvNr.setValue(getRandomCardValidCode());
        continueButton.click();
        alertNoticeCardOwnerEmpty
                .shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void fillCardFormFailYearEmpty(CardInfo cardInfo) {
        cardNrField.setValue(cardInfo.getCardNr());
        cardMonthField.setValue(generateValidDate("MM"));
        cardYearField.setValue("");
        cardOwnerField.setValue(getRandomSurnameName("en"));
        cardCvcCvvNr.setValue(getRandomCardValidCode());
        continueButton.click();
        alertNoticeCardOwnerEmpty
                .shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void fillCardFormFailNameEmpty(CardInfo cardInfo) {
        cardNrField.setValue(cardInfo.getCardNr());
        cardMonthField.setValue(generateValidDate("MM"));
        cardYearField.setValue(generateValidDate("yy"));
        cardOwnerField.setValue(getRandomSurnameName("en").substring(1, 1));
        cardCvcCvvNr.setValue(getRandomCardValidCode());
        continueButton.click();
        alertNoticeCardOwnerEmpty
                .shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void fillCardFormFailCodeCvvEmpty(CardInfo cardInfo) {
        cardNrField.setValue(cardInfo.getCardNr());
        cardMonthField.setValue(generateValidDate("MM"));
        cardYearField.setValue(generateValidDate("yy"));
        cardOwnerField.setValue(getRandomSurnameName("en"));
        cardCvcCvvNr.setValue("");
        continueButton.click();
        alertNoticeCardOwnerEmpty
                .shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }
}