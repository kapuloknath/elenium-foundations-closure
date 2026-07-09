# Selenium Foundations Closure Project

## Purpose

This project demonstrates my practical understanding of Selenium Foundations using Java, Maven, and Selenium WebDriver.

The project was created as part of my Selenium learning and portfolio development. It demonstrates browser session creation, basic browser commands, browser navigation, window management, multiple-window handling, and proper WebDriver session cleanup.

The repository also documents a common dynamic web application debugging scenario involving DOM replacement and `StaleElementReferenceException`.

## Concepts Demonstrated

- Creating a Chrome WebDriver session
- Opening a web application using `get()`
- Retrieving the page title using `getTitle()`
- Retrieving the current URL using `getCurrentUrl()`
- Retrieving the page source using `getPageSource()`
- Browser navigation using `navigate().to()`, `back()`, `forward()`, and `refresh()`
- Browser window management using `manage().window().maximize()`
- Retrieving and storing a window handle
- Opening a new browser window using `newWindow()`
- Working with multiple browser windows
- Using `close()` to close the current window
- Switching back to an existing browser window
- Using `quit()` to terminate the WebDriver session
- Understanding synchronization and dynamic DOM changes
- Understanding why stale element references occur
- Re-locating elements after DOM replacement

## Technologies Used

- Java 25
- Selenium WebDriver 4.34.0
- Apache Maven 3.9.11
- Google Chrome
- ChromeDriver managed through Selenium Manager
- Eclipse IDE

## Prerequisites

Before running this project, ensure that the following are installed:

- Java Development Kit (JDK)
- Apache Maven
- Google Chrome
- Git, if you want to clone and manage the repository

You can verify the Java and Maven installations using:

```bash
java -version
mvn -version
```

A separate manual ChromeDriver setup is not required when Selenium Manager can successfully resolve and provide a compatible ChromeDriver.

## Project Structure

```text
selenium-foundations-closure/
├── README.md
├── pom.xml
└── src/
    └── test/
        └── java/
            └── com/
                └── projectfreedom/
                    └── selenium/
                        └── BrowserCommandsClosure.java
```

### `pom.xml`

Contains the Maven project configuration and Selenium Java dependency.

### `src/test/java`

Contains the Selenium demonstration code.

### `BrowserCommandsClosure.java`

The main executable demonstration class.

It creates a Chrome WebDriver session, executes browser and navigation commands, demonstrates multiple-window handling, distinguishes `close()` from `quit()`, switches back to an existing window, and terminates the WebDriver session cleanly.

## Setup Instructions

1. Clone the repository:

```bash
git clone <repository-url>
```

2. Navigate to the project directory:

```bash
cd selenium-foundations-closure
```

3. Verify that Java and Maven are installed:

```bash
java -version
mvn -version
```

4. Resolve and compile the Maven project dependencies:

```bash
mvn clean test-compile
```

5. Open the project in Eclipse or another Java IDE that supports Maven projects.

6. Ensure Google Chrome is installed.

Selenium Manager will manage ChromeDriver when driver management is required and a compatible driver can be resolved.

## How to Run

### Run from Eclipse

1. Open `BrowserCommandsClosure.java`.

2. Right-click inside the Java editor.

3. Select:

```text
Run As → Java Application
```

4. Observe the browser automation workflow and console output.

## Expected Workflow

The program will:

1. Create a Chrome WebDriver session.
2. Open the Selenium website.
3. Print the page title.
4. Print the current URL.
5. Print the page-source length.
6. Navigate to the Selenium Documentation page.
7. Print the URL after navigation.
8. Execute `back()`, `forward()`, and `refresh()`.
9. Maximize the browser window.
10. Store the original window handle.
11. Open and switch to a second browser window.
12. Print the number of open windows.
13. Navigate the second window to the Selenium Downloads page.
14. Print the title of the second window.
15. Close only the second window using `close()`.
16. Switch back to the original window.
17. Print the title of the original window.
18. Terminate the WebDriver session using `quit()`.

## Sample Console Output

```text
Page Title: Selenium
Current URL: https://www.selenium.dev/
Page Source Length: 33047
Current URL After Navigation: https://www.selenium.dev/documentation/
Number of Open Windows: 2
Second Window Title: Downloads | Selenium
Original Window Title: The Selenium Browser Automation Project | Selenium
```

The exact page-source length may change when the Selenium website content changes.

## Browser Commands Demonstrated

| Command | Purpose |
|---|---|
| `get()` | Navigates the current WebDriver session to a URL |
| `getTitle()` | Retrieves the current page title |
| `getCurrentUrl()` | Retrieves the current URL |
| `getPageSource()` | Retrieves the page-source representation |
| `navigate().to()` | Navigates to a specified URL |
| `navigate().back()` | Navigates backward in browser history |
| `navigate().forward()` | Navigates forward in browser history |
| `navigate().refresh()` | Refreshes the current page |
| `manage().window().maximize()` | Maximizes the current browser window |
| `getWindowHandle()` | Retrieves the current window handle |
| `getWindowHandles()` | Retrieves all window handles in the current session |
| `newWindow()` | Creates and switches to a new window |
| `switchTo().window()` | Switches WebDriver to another existing window |
| `close()` | Closes the current browser window |
| `quit()` | Terminates the WebDriver session |

## Stale-Element Debugging Lesson

Dynamic web applications may asynchronously update or re-render parts of the page.

If Selenium locates an element before a DOM update and stores the resulting `WebElement` reference, that reference may become stale after the original DOM element is removed or replaced.

This may result in:

```text
StaleElementReferenceException
```

Waiting on the old stored `WebElement` does not automatically repair the stale reference.

The correct conceptual approach is:

```text
Perform Action
↓
Wait for the Required Updated Application State
↓
Locate the Element Again from the Current DOM
↓
Use the Newly Located Element
↓
Continue Execution
```

Example:

```java
driver.findElement(By.id("applyCoupon")).click();

WebDriverWait wait =
        new WebDriverWait(driver, Duration.ofSeconds(10));

WebElement updatedPriceElement = wait.until(
        ExpectedConditions.visibilityOfElementLocated(
                By.id("productPrice"))
);

String updatedPrice = updatedPriceElement.getText();

System.out.println(updatedPrice);
```

In a real test, visibility alone may not prove that the product price has changed.

A stronger synchronization condition should wait for the required application state, such as the expected updated price or a change from the original price.

## Key Learning Outcomes

Through this project, I practiced and demonstrated:

- Creating and terminating WebDriver sessions
- Using Selenium WebDriver browser commands
- Retrieving browser and page information
- Using browser navigation commands
- Managing browser windows
- Handling multiple browser windows
- Understanding the difference between `close()` and `quit()`
- Switching WebDriver between existing windows
- Understanding that dynamically updated DOM elements can invalidate stored `WebElement` references
- Understanding why waiting on an old stale reference does not repair it
- Using explicit waits with locators to re-locate elements from the current DOM
- Cleaning and organizing a Maven Selenium project for portfolio presentation

## Future Improvements

Future versions of this project may include:

- Selenium locators and WebElement interactions
- Explicit waits using real application scenarios
- TestNG integration
- Assertions and test-result verification
- Page Object Model implementation
- Test data management
- Logging and reporting
- Cross-browser execution
- Selenium Grid execution
- CI/CD integration