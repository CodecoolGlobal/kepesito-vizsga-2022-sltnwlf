import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

import java.util.concurrent.TimeUnit;
public abstract class TestBase {

    WebDriver driver;
    protected AlertPage alert;
    protected BasePage base;
    protected InputPage input;
    protected NameCardPage nameCard;
    protected SelectDayPage selectDay;
    protected TablePage table;

    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("−−incognito");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920, 1080");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://demo.seleniumeasy.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        alert = new AlertPage(driver);
        base = new BasePage(driver);
        input = new InputPage(driver);
        nameCard = new NameCardPage(driver);
        selectDay = new SelectDayPage(driver);
        table = new TablePage(driver);
    }

    @AfterEach
    public void dispose(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
