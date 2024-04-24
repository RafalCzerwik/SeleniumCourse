package com.course.selenium.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void myAddress() {

        WebElement address = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/a[2]"));
        address.click();
    }
}
