package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TablePage {

    WebDriver driver;
    private final By next = By.xpath("//*[@id=\"example_next\"]");
    private final By buttons = By.xpath("//*[@id=\"example_paginate\"]/span/a");
    private final By names = By.xpath("//*[@id='example']//td[1]");
    int lines = 0;

    public TablePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
    }
    public void clickOnNext(){
        driver.findElement(next).click();
    }
    public void writeNamesToFile() throws IOException {
        List<WebElement> btnList = driver.findElements(buttons);
        FileWriter myWriter = new FileWriter("names.txt", false);
        for (int i = 0; i < btnList.size(); i++) {
            List<WebElement> nameList = driver.findElements(names);
            for (int j = 0; j < nameList.size(); j++) {
                String name = nameList.get(j).getText();
                myWriter.write(name + "\n");
            }
            clickOnNext();
        }
        myWriter.close();
    }
    public int lineCounter(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while (reader.readLine() != null)
                lines++;
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lines;
    }

}
