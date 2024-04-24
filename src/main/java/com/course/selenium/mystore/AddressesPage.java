package com.course.selenium.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressesPage {

    private WebDriver driver;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addAddress() {

        WebElement address = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[3]/a"));
        address.click();
    }
}
