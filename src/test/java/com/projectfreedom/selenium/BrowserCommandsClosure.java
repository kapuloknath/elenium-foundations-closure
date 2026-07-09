package com.projectfreedom.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommandsClosure {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/");

        String originalWindowHandle = driver.getWindowHandle();

        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Source Length: " + driver.getPageSource().length());

        driver.navigate().to("https://www.selenium.dev/documentation/");

        System.out.println("Current URL After Navigation: "
                + driver.getCurrentUrl());

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        driver.manage().window().maximize();

        driver.switchTo().newWindow(WindowType.WINDOW);

        System.out.println("Number of Open Windows: "
                + driver.getWindowHandles().size());

        driver.navigate().to("https://www.selenium.dev/downloads/");

        System.out.println("Second Window Title: " + driver.getTitle());

        driver.close();

        driver.switchTo().window(originalWindowHandle);

        System.out.println("Original Window Title: " + driver.getTitle());

        driver.quit();
    }
}