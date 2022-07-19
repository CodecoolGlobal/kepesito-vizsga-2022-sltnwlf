package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDayPage {

    WebDriver driver;
    private final By dropdown = By.xpath("//*[@id=\"select-demo\"]");
    private final By result = By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[2]");

    public SelectDayPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
    }
    public void selectDropdown(String day) {
        Select select = new Select(driver.findElement(dropdown));
        select.selectByValue(day);
    }
    public String getResultText() {
        String resultText = driver.findElement(result).getText();
        return resultText.replace("Day selected :- ","");

    }

}
