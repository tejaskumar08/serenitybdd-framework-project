package wesco.helpers;

import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DomCaptureHelper {


    public static void captureOnce() {
        try {
            WebDriver driver = ThucydidesWebDriverSupport.getDriver();

            String dom = (String) ((JavascriptExecutor) driver)
                    .executeScript("return document.documentElement.outerHTML;");

            Files.createDirectories(Paths.get("dom"));
            Files.write(Paths.get("dom/serenity-page.html"), dom.getBytes());

            System.out.println("✅ Serenity DOM captured");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
