package com.projectfreedom.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocatorsClosure {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open website
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // Enter login credentials
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        // Login button
        WebElement loginButton = driver.findElement(By.className("submit-button"));
        System.out.println("Submit Button Value: " + loginButton.getAttribute("value"));

        // Count input fields
        List<WebElement> inputTags = driver.findElements(By.tagName("input"));
        System.out.println("Input Tag Count: " + inputTags.size());

        // Print placeholders
        String usernamePlaceholder = driver.findElement(By.cssSelector("input[data-test='username']"))
                                           .getAttribute("placeholder");
        System.out.println("Username Placeholder: " + usernamePlaceholder);

        String passwordPlaceholder = driver.findElement(By.id("password"))
                                           .getAttribute("placeholder");
        System.out.println("Password Placeholder: " + passwordPlaceholder);

        // Locate login container and click Login
        WebElement loginContainer = driver.findElement(By.className("login_wrapper-inner"));
        loginContainer.findElement(By.name("login-button")).click();

        // Wait for inventory page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));

        // Count products
        List<WebElement> inventoryItems = driver.findElements(By.className("inventory_item"));
        System.out.println("Inventory Product Count: " + inventoryItems.size());

        // Locate Sauce Labs Backpack product card
        WebElement productCard = driver.findElement(
                By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']")
        );

        // Click Add to Cart
        productCard.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Wait for cart badge and print count
        WebElement cartBadge = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("shopping_cart_badge"))
        );

        System.out.println("Cart Badge: " + cartBadge.getText());

        // Close browser
        driver.quit();
    }
}