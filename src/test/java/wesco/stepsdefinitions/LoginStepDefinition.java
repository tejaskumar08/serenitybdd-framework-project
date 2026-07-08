package wesco.stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import wesco.helpers.LoginPageHelper;

public class LoginStepDefinition {
    @Steps
    LoginPageHelper loginPageHelper;

    @Given("the user open browser")
    public void userOpensWebBrowser(){
        loginPageHelper.launchBrowser();
        loginPageHelper.maximizeWindow();
    }

    @When("user verify each section in home page")
    public void verifyUserIsInHomePage(){
        loginPageHelper.loginIntoSauceDemoApplication();
    }

    @Then("the user will be products page")
    public void verifyUserLandedBackInLoginPage(){
        loginPageHelper.logoutFromSauceDemoApplication();
    }

}
