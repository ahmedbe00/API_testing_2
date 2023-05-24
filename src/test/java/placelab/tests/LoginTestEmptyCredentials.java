package placelab.tests;

import org.testng.annotations.Test;
import placelab.utilities.AuthenticationRequest;
import java.util.logging.Logger;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginTestEmptyCredentials {
    private static final Logger LOGGER = Logger.getLogger("Login Test");


    @Test(priority = 4, description = "This test verifies that user can not log in with email and password fields empty.")
    public void testLoginEmptyCredentials() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("", "");
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
