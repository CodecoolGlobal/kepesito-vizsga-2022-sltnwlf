package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class NameCardPage {

    WebDriver driver;
    private final By nameCards = By.xpath("//*[@class=\"searchable-container\"]/div");
    private final By relativeName = By.xpath(".//h4");

    public NameCardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get("https://demo.seleniumeasy.com/data-list-filter-demo.html");
    }
    public List<String> getNames() {
        List<WebElement> namesList = driver.findElements(nameCards);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < namesList.size(); i++) {
            String names = namesList.get(i).findElement(relativeName).getText();
            names = names.replace("Name: ","");
            result.add(names);
        }
        return result;
    }

}
