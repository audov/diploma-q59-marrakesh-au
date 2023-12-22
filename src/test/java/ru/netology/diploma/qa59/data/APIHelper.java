package ru.netology.diploma.qa59.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;
import lombok.Value;

import static io.restassured.RestAssured.given;

public class APIHelper {

    private static final RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static ResponseBodyExtractionOptions sendQueryToValidate(UICardInfo uiCardInfo, Integer statusCode, String bodyMessage) {

        return given()
                .spec(requestSpecification)
                .body(uiCardInfo)
                .when()
                .post("api/v1/pay")
                .then()
                .statusCode(statusCode)
                .extract()
                .body();
    }

    @Value
    public static class APICardInfo {
        Integer APICardStatus;
        String APICardBody;
    }

    public static class UICardInfo {
        public String cardNrField;
        public String cardOwnerField;
        public String cardMonthField;
        public String cardYearField;
        public String cardCvcCvvNr;

        public UICardInfo(String cardNrField, String cardMonthField, String cardYearField, String cardOwnerField, String cardCvcCvvNr) {
            this.cardNrField = cardNrField;
            this.cardOwnerField = cardOwnerField;
            this.cardMonthField = cardMonthField;
            this.cardYearField = cardYearField;
            this.cardCvcCvvNr = cardCvcCvvNr;
        }
    }
}