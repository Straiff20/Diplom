package API;

import Data.FakerData;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class APITest {
    private static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(9999)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @Test
    void creditCardSuccessTest() {
        given()
                .spec(requestSpec)
                .body(new CreditCardDTO("4444 4444 4444 4441", FakerData.getRandomMonth(), FakerData.getRandomYear(), FakerData.getRandomOwner(), FakerData.getRandomCVCCode()))
                .when()
                .post("/credit")
                .then()
                .statusCode(200); // код 200 OK
    }
}