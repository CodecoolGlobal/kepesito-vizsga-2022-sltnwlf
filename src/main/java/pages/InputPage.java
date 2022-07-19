package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputPage {

    WebDriver driver;
    private final By inputA = By.xpath("//*[@id=\"sum1\"]");
    private final By inputB = By.xpath("//*[@id=\"sum2\"]");
    private final By getTotal = By.xpath("//*[@id=\"gettotal\"]/button");
    private final By result = By.xpath("//*[@id=\"displayvalue\"]");

    public InputPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
    }
    public void fillAllInputs(String a, String b) {
        driver.findElement(inputA).sendKeys(a);
        driver.findElement(inputB).sendKeys(b);
        driver.findElement(getTotal).click();
    }
    public String getResultText() {
        return driver.findElement(result).getText();
    }

}
