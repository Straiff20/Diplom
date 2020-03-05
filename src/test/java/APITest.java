import Data.ValidData;
import ForAPI.FieldsApiDTO;
import ForAPI.MethodsApi;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.Matchers.equalTo;

public class APITest {
    @ParameterizedTest
    @CsvFileSource(resources = "/RequestDataApi.csv", numLinesToSkip = 1)
    void paymentApprovedCardTest(String number, int typeConnection, int statusCode, String status) throws Exception {
        FieldsApiDTO fieldsApiDTO = new FieldsApiDTO(number,
                Integer.parseInt(ValidData.getRandomMonth()),
                Integer.parseInt(ValidData.getRandomYear()),
                ValidData.getRandomOwner(),
                Integer.parseInt(ValidData.getRandomCVCCode()));

        ValidatableResponse response = MethodsApi.payRequest(fieldsApiDTO, typeConnection);
        response.statusCode(statusCode);
        response.body("status", (ResponseAwareMatcher) response1 -> equalTo(status));
//        response.body("status", (ResponseAwareMatcher) response12 -> equalTo(QuerySQL.getStatusFromMySQL(response12.path("id"))));
    }
}