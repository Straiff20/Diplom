import Data.ValidData;
import ForAPI.FieldsApiDTO;
import ForAPI.MethodsApi;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matcher;
import org.hamcrest.;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.

//TODO: сделать методы для запроса, чтобы тесты были меньше
public class APITest {
    @ParameterizedTest
    @CsvFileSource(resources = "/RequestDataApi.csv", numLinesToSkip = 1)
    void paymentApprovedCardTest() {
        FieldsApiDTO fieldsApiDTO = new FieldsApiDTO(ValidData.approvedCard().getCardNumber(),
                Integer.parseInt(ValidData.getRandomMonth()),
                Integer.parseInt(ValidData.getRandomYear()),
                ValidData.getRandomOwner(),
                Integer.parseInt(ValidData.getRandomCVCCode()));

        ValidatableResponse response = MethodsApi.payRequest(fieldsApiDTO, "/payment");
        response.statusCode(200);
        response.body("status", (ResponseAwareMatcher) response1 -> equalTo(ValidData.approvedCard().getStatus()));
        response.body("status", (ResponseAwareMatcher) response12 -> equalTo(QuerySQL.getStatusFromMySQL(response12.path("id"))));
    }

    @Test
    void paymentDeclineCardTest() {
        FieldsApiDTO fieldsApiDTO = new FieldsApiDTO(ValidData.declinedCard().getCardNumber(),
                Integer.parseInt(ValidData.getRandomMonth()),
                Integer.parseInt(ValidData.getRandomYear()),
                ValidData.getRandomOwner(),
                Integer.parseInt(ValidData.getRandomCVCCode()));

        ValidatableResponse response = MethodsApi.payRequest(fieldsApiDTO, "/credit");
        response.statusCode(200);
        response.body("status", (ResponseAwareMatcher) response1 -> equalTo(ValidData.declinedCard().getStatus()));
    }

}