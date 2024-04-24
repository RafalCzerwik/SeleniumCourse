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

        WebElement addNewAddress = this.driver.findElement(By.cssSelector("#content > div.addresses-footer > a"));
        addNewAddress.click();
    }
}
