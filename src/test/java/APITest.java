import Data.DataInfo;
import ForAPI.FieldsApiDTO;
import ForAPI.MethodsApi;
import io.qameta.allure.Issue;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.Matchers.equalTo;

public class APITest {
    @BeforeEach
    @DisplayName("Clear base table")
    void cleanTable() throws Exception {
        SQLRequests.clearTables();
    }

    @Issue("4")
    @ParameterizedTest
    @CsvFileSource(resources = "/RequestDataApi.csv", numLinesToSkip = 1)
    void paymentApprovedCardTest(String number, int typeConnection, int statusCode, String status) throws Exception {
        FieldsApiDTO fieldsApiDTO = new FieldsApiDTO(number,
                Integer.parseInt(DataInfo.getRandomMonth()),
                Integer.parseInt(DataInfo.getRandomYear()),
                DataInfo.getRandomOwner(),
                Integer.parseInt(DataInfo.getRandomCvcCode()));

        ValidatableResponse response = MethodsApi.payRequest(fieldsApiDTO, typeConnection);
        response.statusCode(statusCode);
        response.body("status", (ResponseAwareMatcher) response1 -> equalTo(status));
    }
}