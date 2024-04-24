package com.course.selenium.cucumber.steps;

import com.course.selenium.mystore.DashboardPage;
import com.course.selenium.mystore.LoginPage;
import com.course.selenium.mystore.MainPage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyClothesTest {

    WebDriver driver;

    @Given("a logged-in user with email {word} and password {word} is on the homepage")
    public void loggedUserOnHomePage(String email, String password) {
        this.driver = new ChromeDriver();
        this.driver.get("https://mystore-testlab.coderslab.pl");

        MainPage mainPage = new MainPage(this.driver);
        mainPage.goToLoginPage();

        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.logInUser(email, password);

        DashboardPage dashboardPage = new DashboardPage(this.driver);
        dashboardPage.goBackToMainPage();
    }
}
