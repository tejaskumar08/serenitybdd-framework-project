package wesco;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Files;
import java.nio.file.Paths;

public class SimpleDomCapture {

    public static void main(String[] args) {

        try {
            // Set chromedriver path ONLY if not in PATH
            // System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");

            WebDriver driver = new ChromeDriver();

            driver.get("https://www.wesco.com/");
            Thread.sleep(3000); // allow page to load

            String dom = (String) ((JavascriptExecutor) driver)
                    .executeScript("return document.documentElement.outerHTML;");

            // Create folder
            Files.createDirectories(Paths.get("dom"));

            // Write DOM to file
            Files.write(Paths.get("dom/page.html"), dom.getBytes());

            System.out.println("✅ DOM captured successfully");

            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}