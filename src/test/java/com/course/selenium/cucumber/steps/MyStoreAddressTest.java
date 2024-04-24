package com.course.selenium.cucumber.steps;

import com.course.selenium.mystore.AddressesPage;
import com.course.selenium.mystore.DashboardPage;
import com.course.selenium.mystore.LoginPage;
import com.course.selenium.mystore.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MyStoreAddressTest {

    WebDriver driver;

    @Given("the user is on the main page")
    public void goToMainPage() {
        this.driver = new ChromeDriver();
        this.driver.get("https://mystore-testlab.coderslab.pl");
    }

    @And("the user logs in to their account")
    public void goToLoginPage() {
        String email = "rafal.czerwik@testgmail.com";
        String password = "Rafal12345";

        MainPage mainPage = new MainPage(this.driver);
        mainPage.goToLoginPage();

        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.logInUser(email, password);
    }

    @When("the user navigates from the dashboard page to the addresses page")
    public void goToAddressesPage() {
        DashboardPage dashboardPage = new DashboardPage(this.driver);
        dashboardPage.myAddress();

        AddressesPage addressesPage = new AddressesPage(this.driver);
        addressesPage.addAddress();
    }

    @And("adds the first address with {string} {string} {string} {string} {string}")
    public void addFirstAddress(String alias, String streetName, String city, String postalCode, String phone) {
        WebElement aliasNameInput = this.driver.findElement(By.xpath("//*[@id=\"field-alias\"]"));
        aliasNameInput.clear();
        aliasNameInput.sendKeys(alias);

        WebElement streetAddressInput = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/section/div[6]/div[1]/input"));
        streetAddressInput.clear();
        streetAddressInput.sendKeys(streetName);

        WebElement cityInput = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/section/div[8]/div[1]/input"));
        cityInput.clear();
        cityInput.sendKeys(city);

        WebElement postalCodeInput = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/section/div[9]/div[1]/input"));
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

        WebElement phoneNumberInput = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/section/div[11]/div[1]/input"));
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phone);

        WebElement saveAddressButton = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/footer/button"));
        saveAddressButton.click();
    }

    @Then("the address is added to the user's account")
    public void addedAddress() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.alertIsPresent());
//        Alert alert = driver.switchTo().alert();
//        alert.dismiss();

        String successAlert = "Address successfully added!";
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement successAlertMessage = this.driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/aside/div/article/ul/li"));
        assertEquals(successAlert, successAlertMessage.getText());
    }

    @And("the user checks if the provided data is correct")
    public void verifyAddress() {

        WebElement lastAddressElement = driver.findElement(By.xpath("(//div[@class='col-lg-4 col-md-6 col-sm-6']/article[@class='address'])[last()]"));
        String addressText = lastAddressElement.getText();
        System.out.println(addressText);

        if (
                addressText.contains("Main address") &&
                        addressText.contains("Rafal Michal Czerwik") &&
                        addressText.contains("Street test 1") &&
                addressText.contains("Krakow") &&
                        addressText.contains("01234") &&
                        addressText.contains("United Kingdom") &&
                        addressText.contains("123456789")
        ) {
            System.out.println("Adres jest poprawny.");
        } else {
            System.out.println("Adres jest niepoprawny.");
        }

        this.driver.quit();
    }
}
