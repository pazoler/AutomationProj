package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver = null;

        String browserType = "chrome";

        switch (browserType) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}
