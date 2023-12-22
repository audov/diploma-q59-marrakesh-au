package ru.netology.diploma.qa59.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {

    private static final Faker faker = new Faker(new Locale("en"));

    public static CardInfo getFstCardInfo() {
        return new CardInfo("4444 4444 4444 4441", "APPROVED");
    }

    public static CardInfo getSndCardInfo() {
        return new CardInfo("4444 4444 4444 4442", "DECLINED");
    }

    public static CardInfo getInvalidCardInfo() {
        return new CardInfo("4444 4444 4444 4443", "DECLINED");
    }

    public static String getRandomCardValidCode() {
        return faker.number().digits(3);
    }

    public static String getRandomSurnameName(String locale) {
        Faker faker = new Faker(new Locale((locale)));
        return faker.name().fullName();
    }

    public static String generateValidDate(String pattern) {
        int addMonths = faker.number().numberBetween(0, 60);
        return LocalDate.now().plusMonths(addMonths).format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String generateInvalidDate(String pattern) {
        int addMonths = faker.number().numberBetween(61, 100);
        return LocalDate.now().plusMonths(addMonths).format(DateTimeFormatter.ofPattern(pattern));
    }

    public static int generateInvalidMonth() {
        int invalidMonth = faker.number().numberBetween(13, 99);
        return invalidMonth;
    }

    public static String generateValidMonth(String pattern) {
        //int addDays = (int) faker.number().randomNumber();
        int addMonth = faker.number().numberBetween(0, 12);
        pattern = "MM";
        return LocalDate.now().plusMonths(addMonth).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Value
    public static class CardInfo {
        String cardNr;
        String cardStatus;
    }
}



