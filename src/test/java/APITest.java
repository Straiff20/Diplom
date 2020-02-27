import Data.FakerData;
import Data.ForApiDTO;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
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
    void paymentApprovedCardTest() {
        given()
                .spec(requestSpec)
                .body(new ForApiDTO("4444 4444 4444 4441",
                        Integer.parseInt(FakerData.getRandomMonth()),
                        Integer.parseInt(FakerData.getRandomYear()),
                        FakerData.getRandomOwner(),
                        Integer.parseInt(FakerData.getRandomCVCCode())))
                .when()
                .post("/payment")
                .then()
                .statusCode(200);
    }

    @Test
    void paymentDeclineCardTest() {
        given()
                .spec(requestSpec)
                .body(new ForApiDTO("4444 4444 4444 4442",
                        Integer.parseInt(FakerData.getRandomMonth()),
                        Integer.parseInt(FakerData.getRandomYear()),
                        FakerData.getRandomOwner(),
                        Integer.parseInt(FakerData.getRandomCVCCode())))
                .when()
                .post("/payment")
                .then()
                .statusCode(200);
    }

    @Test
    void creditApprovedCardTest() {
        given()
                .spec(requestSpec)
                .body(new ForApiDTO("4444 4444 4444 4441",
                        Integer.parseInt(FakerData.getRandomMonth()),
                        Integer.parseInt(FakerData.getRandomYear()),
                        FakerData.getRandomOwner(),
                        Integer.parseInt(FakerData.getRandomCVCCode())))
                .when()
                .post("/credit")
                .then()
                .statusCode(200);
    }

    @Test
    void creditDeclineCardTest() {
        given()
                .spec(requestSpec)
                .body(new ForApiDTO("4444 4444 4444 4442",
                        Integer.parseInt(FakerData.getRandomMonth()),
                        Integer.parseInt(FakerData.getRandomYear()),
                        FakerData.getRandomOwner(),
                        Integer.parseInt(FakerData.getRandomCVCCode())))
                .when()
                .post("/credit")
                .then()
                .statusCode(200);
    }

    @Test
    void paymentResponse500() {
        given()
                .spec(requestSpec)
                .body(new ForApiDTO("5555 5555 5555 5555",
                        Integer.parseInt(FakerData.getRandomMonth()),
                        Integer.parseInt(FakerData.getRandomYear()),
                        FakerData.getRandomOwner(),
                        Integer.parseInt(FakerData.getRandomCVCCode())))
                .when()
                .post("/payment")
                .then()
                .statusCode(500);
    }

    @Test
    void creditResponse500() {
        given()
                .spec(requestSpec)
                .body(new ForApiDTO("5555 5555 5555 5555",
                        Integer.parseInt(FakerData.getRandomMonth()),
                        Integer.parseInt(FakerData.getRandomYear()),
                        FakerData.getRandomOwner(),
                        Integer.parseInt(FakerData.getRandomCVCCode())))
                .when()
                .post("/credit")
                .then()
                .statusCode(500);
    }
}