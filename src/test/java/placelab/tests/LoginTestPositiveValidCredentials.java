package placelab.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import placelab.utilities.AuthenticationRequest;

import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsNull.notNullValue;

public class LoginTestPositiveValidCredentials {
    private static final Logger LOGGER = Logger.getLogger("Login Test");
    @Parameters({"email", "password"})
    @Test( description = "This test verifies that user can log in with valid email and password.")
    public void testLoginValidCredentials(final String validEmail, final String validPassword) {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(validEmail, validPassword);
        LOGGER.info("Submit authentication POST request");

        given()
                .baseUri("https://demo.placelab.com")
                .contentType("application/json")
                .body(authenticationRequest.requestBody.toString())

                .when()
                .post("/api/v2/sessions")

                .then()
                .statusCode(201)
                .contentType("application/json")
                .body("api_token", notNullValue());
    }
}
