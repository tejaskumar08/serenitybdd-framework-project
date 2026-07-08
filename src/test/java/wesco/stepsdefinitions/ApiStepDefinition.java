package wesco.stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import wesco.steps.ApiSteps;

public class ApiStepDefinition {

    @Steps
    ApiSteps apiStepsObj;

    @Given("the user calls the Get User api with id {int}")
    public void callGetUserApi(int id){
        apiStepsObj.getUserById(id);
    }

    @Then("the response should be {int}")
    public void verifyApiStatusCode(int status){
        apiStepsObj.verifyStatusCode(status);
    }

    @Then("the response should contain user id {int}")
    public void verifyUserId(int userId){
        apiStepsObj.verifyUserId(userId);
    }

    @Given("the user calls Get Posts Api with id {int}")
    public void callGetPostsApi(int id){
        apiStepsObj.getPostsById(id);
    }

    @Then("the response body should contain {int} and {string}")
    public void verifyResponseBody(int id, String desc){
        apiStepsObj.verifyResponseBody(id, desc);
    }
}
