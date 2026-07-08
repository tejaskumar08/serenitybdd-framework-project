package wesco.api;

import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class GetUserApiTest {

    @Test
    public void getUserByIdApi(){
        SerenityRest
                .given()
                .baseUri("https://jsonplaceholder.typicode.com/")
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("id", notNullValue())
                .body("name", equalTo("Leanne Graham"));
        System.out.println("Api Test passed");
    }
}
