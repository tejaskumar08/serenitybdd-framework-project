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

public class WebPageUtils extends PageObject{
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

    public static void waitWithTimeUntilElementVisible(WebElementFacade ele, long time){
        try{
            Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(Serenity.getDriver())
                    .withTimeout(Duration.ofSeconds(time))
                    .pollingEvery(Duration.ofMillis(1000))
                    .ignoring(Exception.class);
            fluentWait.until(ExpectedConditions.visibilityOf(ele));
            logger.info("Element is visible");
        }
        catch(Exception e){
            logger.error("Element not visible -"+e.getLocalizedMessage());
        }
    }

    public static void waitUntilElementVisibleAndClickable(WebElementFacade ele){
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
    public static void waitForElementAndClick(WebElementFacade ele){
        try{
            Wait<WebDriver> fluentWait = new FluentWait<>(Serenity.getDriver())
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofMillis(1000))
                    .ignoring(Exception.class);
            fluentWait.until(ExpectedConditions.visibilityOf(ele));
            ele.click();
            logger.info("Waited and clicked on element");
        }catch(Exception e){
            logger.error("Element not clicked -"+e.getLocalizedMessage());
        }
    }

    public static void waitUntilElementDisappear(WebElementFacade ele){
        try{
            Wait<WebDriver> fluentWait = new FluentWait<>(Serenity.getDriver())
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofMillis(1000))
                    .ignoring(Exception.class);
            fluentWait.until(ExpectedConditions.invisibilityOf(ele));
            logger.info("Element disappeared");
        }catch (Exception e){
            logger.error("Element could not disappear - "+e.getLocalizedMessage());
        }
    }

    public static void checkElement(WebElementFacade ele){
        try{
            if(!ele.isSelected()){
                ele.select();
                logger.info("Element checked");
            }else{
                logger.info("Element already checked");
            }
        }catch(Exception e){
            logger.error("Element not checked-"+e.getLocalizedMessage());
        }
    }

    public static void uncheckElement(WebElementFacade ele){
        try{
            if(ele.isSelected()){
                ele.deselect();
                logger.info("Element unchecked");
            }else{
                logger.info("Element already unchecked");
            }
        }catch (Exception e){
            logger.error("Element could not be unchecked -"+e.getLocalizedMessage());
        }
    }

    public static boolean isElementEnabled(WebElementFacade ele){
        try{
            if(ele.isEnabled()){
                logger.info("Element is enabled");
                return true;
            }else{
                logger.info("Element is not enabled");
                return false;
            }
        }catch(Exception e){
            logger.error("Could not check element enabled -"+e.getLocalizedMessage());
            throw new RuntimeException();
        }
    }

}
