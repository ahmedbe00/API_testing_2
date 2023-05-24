package placelab.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import placelab.utilities.AuthenticationRequest;
import placelab.utilities.RandomGenerator;

import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class LoginTestValidPasswordInvalidEmail {
    private static final Logger LOGGER = Logger.getLogger("Login test");
    @Parameters("password")
    @Test( description = "This test verifies that user can't log in with valid password and invalid email.")
    public void testLoginValidPasswordInvalidEmail( final String validPassword) {
        String randomEmail = RandomGenerator.generateRandomEmail();
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(randomEmail,validPassword);
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
//mvn clean verify -Dtest="placelab.tests.LoginTestValidPasswordInvalidEmail" -Dpassword=19211987Ahb5e! -Demail="ahmedberbic2000@gmail.com"