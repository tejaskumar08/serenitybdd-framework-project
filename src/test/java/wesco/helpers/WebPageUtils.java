package wesco.helpers;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import static net.serenitybdd.core.Serenity.getDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WebPageUtils extends PageObject {
    private static final Log logger = LogFactory.getLog(WebPageUtils.class);

    public static void clickOnElement(WebElementFacade element){
        try{
            element.waitUntilClickable().click();
            logger.info("Clicked on element");
        }catch(Exception e){
            logger.error("Exception on action-click-"+e.getLocalizedMessage());
        }
    }

    public static void enterInputData(WebElementFacade ele, String data){
        try{
            ele.waitUntilPresent().type(data);
            logger.info("Entered data on element");
        }catch(Exception e){
            logger.error("Exception on action-type-"+e.getLocalizedMessage());
        }
    }

    public static void waitUntilElementVisible(WebElementFacade ele){
        try{
            Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(Serenity.getDriver())
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofMillis(1000))
                    .ignoring(Exception.class);
            fluentWait.until(ExpectedConditions.visibilityOf(ele));
            logger.info("Element is visible");
        }
        catch(Exception e){
            logger.error("Element not visible -"+e.getLocalizedMessage());
        }
    }

    public void waitUntilElementVisibleAndClickable(WebElementFacade ele){
        try{
            Wait<WebDriver> fluentWait = new FluentWait<>(Serenity.getDriver())
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofMillis(1000))
                    .ignoring(NoSuchElementException.class);
            fluentWait.until(ExpectedConditions.visibilityOf(ele));
            fluentWait.until(ExpectedConditions.elementToBeClickable(ele));
        }catch(Exception e){
            logger.error("Element not ready for clickable -"+e.getLocalizedMessage());
        }
    }
}
