package com.course.selenium.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logInUser(String email, String password) {

        WebElement emailInput = this.driver.findElement(By.id("field-email"));
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement passwordInput = this.driver.findElement(By.id("field-password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement signInButton = this.driver.findElement(By.id("submit-login"));
        signInButton.click();

        WebElement addressesButton = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/a[2]"));
        addressesButton.click();
    }
}
