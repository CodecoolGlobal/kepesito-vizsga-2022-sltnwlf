package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPage {

    WebDriver driver;
    private final By launchModal = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[2]/a");
    private final By modal = By.xpath("//*[@class='modal fade in']");
    private final By modalText = By.xpath("//*[@id=\"myModal0\"]/div/div/div[3]");
    private final By modalClose = By.xpath("//*[@id=\"myModal0\"]/div/div/div[1]/button");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get("https://demo.seleniumeasy.com/bootstrap-modal-demo.html");
    }
    public void clickOnModal() {
        driver.findElement(launchModal).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(modal));
    }
    public String getModalText() {
        return driver.findElement(modalText).getText();
    }
    public void clickOnCloseButton() {
        driver.findElement(modalClose).click();
    }

}
