package wesco.helpers;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wesco.pages.LoginPage;


public class LoginPageHelper extends PageObject {
    LoginPage loginPage;
    private static final Logger logger = LoggerFactory.getLogger(LoginPageHelper.class);

    public void launchBrowser(){
        openUrl(ConfigLoader.getUrl());
    }

    public void maximizeWindow() {
        getDriver().manage().window().maximize(); // maximize browser
    }

    public void verifyProductsPage(){
        loginPage.productsLink.shouldBeVisible();
        WebPageUtils.enterInputData(loginPage.customerFirstName, "TestingFname");
    }

    public void clickProductsPage(){
        loginPage.productsLink.shouldBeVisible();
        loginPage.productsLink.waitUntilVisible();
        loginPage.productsLink.click();
//        WebPageUtils.waitUntilElementVisible(loginPage.productsLink);
//        WebPageUtils.clickOnElement(loginPage.productsLink);

    }

    public void loginIntoSauceDemoApplication(){
        loginPage.userName.waitUntilVisible();
        loginPage.userName.type(ConfigLoader.getUsername());
        loginPage.password.typeAndEnter(ConfigLoader.getPassword());
        if(loginPage.homePageLogo.isDisplayed()){
            Assert.assertTrue(true);
            logger.info("User successfully logged into application");
        }
    }

    public void logoutFromSauceDemoApplication(){
        WebPageUtils.clickOnElement(loginPage.leftHamburgerMenu);
        WebPageUtils.waitUntilElementVisibleAndClickable(loginPage.sideBarLogoutBtn);
        loginPage.sideBarLogoutBtn.click();
        Assert.assertTrue("User could not logout from application",loginPage.userName.isDisplayed());
    }

}
