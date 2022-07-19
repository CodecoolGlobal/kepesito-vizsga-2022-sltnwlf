package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;
    private final By popupClose = By.xpath("//*[@id=\"at-cv-lightbox-close\"]");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void popupKiller() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(popupClose));
        driver.findElement(popupClose).click();
    }

}
