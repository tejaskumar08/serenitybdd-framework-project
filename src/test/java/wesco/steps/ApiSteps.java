package wesco.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

public class ApiSteps {
    @Step("Call Get User Api with id {1}")
    public void getUserById(int id){
        SerenityRest.
                given()
                .relaxedHTTPSValidation()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/users/"+id);
    }

    @Step("Verify response status {1}")
    public void verifyStatusCode(int status){
        SerenityRest
                .then()
                .statusCode(status);
    }

    @Step("Verify user id {1} in response")
    public void verifyUserId(int userId){
        SerenityRest
                .then()
                .body("id", equalTo(userId))
                .body("id", notNullValue())
                .body("name", equalTo("Leanne Graham"));
    }

    @Step("Call Get Posts api with id {1}")
    public void getPostsById(int id){
        SerenityRest
                .given()
                .relaxedHTTPSValidation()
                .baseUri("https://json-placeholder.mock.beeceptor.com")
                .when()
                .get("posts/"+id);
    }

    @Step("Get posts api response body validation")
    public void verifyResponseBody(int id, String desc){
        SerenityRest
                .then()
                .body("id", equalTo(id))
                .body("title", containsString(desc.trim()))
                .body("body", containsString(desc.trim()));
    }
}
