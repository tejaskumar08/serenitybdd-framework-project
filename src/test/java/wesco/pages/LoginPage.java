package wesco.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {
    @FindBy(xpath = ".//a[@href='/us/en/products.html']")
    public WebElementFacade productsLink;

    @FindBy(xpath = ".//a[@href='/us/en/solutions.html']")
    public WebElementFacade solutionsLink;
 
    @FindBy(xpath = "//span//a[@href='/us/en/industries.html']")
    public WebElementFacade industriesLink;

    @FindBy(xpath = "//span//a[@href='/us/en/services.html']")
    public WebElementFacade softwareAndServicesLink;

    @FindBy(xpath = "//span//a[@href='/us/en/brands.html']")
    public WebElementFacade brandsLink;

    @FindBy(xpath = "//span//a[@href='/us/en/knowledge-hub.html']")
    public WebElementFacade knowledgeHubLink;

    @FindBy(xpath = "//span//a[@href='/us/en/our-company.html']")
    public WebElementFacade ourCompanyLink;

    @FindBy(xpath = ".//h1")
    public WebElementFacade productsHeader;

    @FindBy(id = "FirstName")
    public WebElementFacade customerFirstName;

    //Sauce-demo locators
    @FindBy(id = "user-name")
    public WebElementFacade userName;

    @FindBy(id = "password")
    public WebElementFacade password;

    @FindBy(xpath = ".//div[@class='app_logo']")
    public WebElementFacade homePageLogo;

    @FindBy(id = "react-burger-menu-btn")
    public WebElementFacade leftHamburgerMenu;

    @FindBy(id ="logout_sidebar_link")
    public WebElementFacade sideBarLogoutBtn;


}