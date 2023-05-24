package placelab.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import placelab.utilities.AuthenticationRequest;
import placelab.utilities.RandomGenerator;

import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginTestValidEmailInvalidPassword {
    private static final Logger LOGGER = Logger.getLogger("Login test");
    @Parameters("email")
    @Test( description = "This test verifies that user can't log in with valid email and invalid password.")
    public void testLoginValidEmailInvalidPassword( final String validEmail) {
        String randomPassword = RandomGenerator.generateRandomPassword();
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(validEmail,randomPassword);
        LOGGER.info("Submit authentication POST request");

        given()
                .baseUri("https://demo.placelab.com")
                .contentType("application/json")
                .body(authenticationRequest.requestBody.toString())

                .when()
                .post("/api/v2/sessions")

                .then()
                .statusCode(401)
                .contentType("application/json")
                .body("error", equalTo("Password mismatch."));

    }
}
