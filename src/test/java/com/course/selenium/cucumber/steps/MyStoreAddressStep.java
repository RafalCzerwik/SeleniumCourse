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

import static org.junit.Assert.assertEquals;

public class MyStoreAddressStep {

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
        String successAlert = "Address successfully added!";

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        WebElement successAlertMessage = this.driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article"));
        assertEquals(successAlert, successAlertMessage.getText());
    }

    @And("the user checks if the provided data is correct")
    public void verifyAddress() {
        WebElement addressAlias = this.driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[1]"));
        assertEquals("Main address", addressAlias.getText());

        WebElement addressLine = this.driver.findElement(By.xpath("//*[@id=\"address-10917\"]/div[1]/address/text()[3]"));
        assertEquals("Street test 1", addressLine.getText());

        WebElement city = this.driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[4]"));
        assertEquals("Krakow", city.getText());

        WebElement postalCode = this.driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[5]"));
        assertEquals("01234", postalCode.getText());

        WebElement phoneNumber = this.driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[7]"));
        assertEquals("123456789", phoneNumber.getText());

//        this.driver.quit();
    }
}
