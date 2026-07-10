# Selenium Automation Portfolio

## Purpose

This repository demonstrates my practical understanding of Selenium WebDriver using Java and Maven.

The project is developed incrementally as part of my Selenium learning, automation testing preparation, and QA portfolio development.

The repository currently contains practical implementations covering Selenium Foundations and Selenium Locators.

The projects demonstrate browser session creation, browser commands, navigation, window management, multiple-window handling, WebDriver session cleanup, Selenium locator strategies, CSS selectors, XPath, scoped element searches, explicit waits, dynamic DOM behavior, and stale-element debugging.

## Modules Completed

- Selenium Foundations
- Selenium Locators

## Technologies Used

- Java 25
- Selenium WebDriver 4.34.0
- Apache Maven 3.9.11
- Google Chrome
- ChromeDriver managed through Selenium Manager
- Eclipse IDE
- Git and GitHub

## Prerequisites

Before running this project, ensure that the following are installed:

- Java Development Kit (JDK)
- Apache Maven
- Google Chrome
- Git, if you want to clone and manage the repository

Verify the Java and Maven installations using:

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
                        ├── BrowserCommandsClosure.java
                        └── LocatorsClosure.java
```

### `pom.xml`

Contains the Maven project configuration and Selenium Java dependency.

### `src/test/java`

Contains the Selenium automation demonstration programs.

### `BrowserCommandsClosure.java`

Demonstrates Selenium Foundations, including browser session creation, browser commands, navigation, window management, multiple-window handling, switching between windows, and WebDriver session cleanup.

### `LocatorsClosure.java`

Demonstrates Selenium locator strategies through an end-to-end automation workflow on the SauceDemo application.

The program uses multiple locator strategies, scoped element searches, CSS Selector, XPath, explicit waits, product-container identification, and dynamic page interaction.

---

# Selenium Foundations Module

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
- Using `close()` to close the current browser window
- Switching back to an existing browser window
- Using `quit()` to terminate the complete WebDriver session
- Understanding synchronization and dynamic DOM changes
- Understanding why stale element references occur
- Re-locating elements after DOM replacement

## Browser Commands Workflow

The `BrowserCommandsClosure.java` program:

1. Creates a Chrome WebDriver session.
2. Opens the Selenium website.
3. Prints the page title.
4. Prints the current URL.
5. Prints the page-source length.
6. Navigates to the Selenium Documentation page.
7. Prints the URL after navigation.
8. Executes `back()`, `forward()`, and `refresh()`.
9. Maximizes the browser window.
10. Stores the original window handle.
11. Opens and switches to a second browser window.
12. Prints the number of open windows.
13. Navigates the second window to the Selenium Downloads page.
14. Prints the title of the second window.
15. Closes only the second window using `close()`.
16. Switches back to the original window.
17. Prints the title of the original window.
18. Terminates the WebDriver session using `quit()`.

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
| `newWindow()` | Creates and switches to a new browser window |
| `switchTo().window()` | Switches WebDriver to another existing window |
| `close()` | Closes the current browser window |
| `quit()` | Terminates the complete WebDriver session |

## Foundations Execution Evidence

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

---

# Selenium Locators Module

## Locator Strategies Covered

The following Selenium locator strategies were studied and applied:

- `By.id()`
- `By.name()`
- `By.className()`
- `By.tagName()`
- `By.linkText()`
- `By.partialLinkText()`
- `By.cssSelector()`
- `By.xpath()`

## CSS Selector Concepts Covered

- Tag selectors
- ID selectors
- Class selectors
- Attribute selectors
- Combining tag, class, and attributes
- Multiple-class selectors
- Attribute exact match
- Attribute starts-with selector `^=`
- Attribute ends-with selector `$=`
- Attribute contains selector `*=`
- Descendant relationship
- Direct-child relationship
- Adjacent-sibling relationship
- General-sibling relationship
- `:nth-child()`
- `:nth-of-type()`
- Comma selectors for multiple matches
- Stable locator selection

## XPath Concepts Covered

- Absolute vs relative XPath
- Attribute-based XPath
- Wildcard `*`
- Multiple conditions using `and`
- Multiple conditions using `or`
- `contains()`
- `starts-with()`
- Exact text matching
- Partial text matching
- `normalize-space()`
- XPath indexing
- Direct-child selection
- Descendant selection
- `parent` axis
- `ancestor` axis
- `following-sibling` axis
- `preceding-sibling` axis
- `following` axis
- Locating a container based on descendant text
- Locating elements inside a specific container

## Additional Locator Concepts Covered

- `findElement()` behavior
- `findElements()` behavior
- Working with `List<WebElement>`
- Zero-match behavior of `findElement()`
- Zero-match behavior of `findElements()`
- Multiple matching elements
- Stable vs brittle locators
- Dynamic attributes
- Choosing CSS Selector vs XPath
- Searching within another `WebElement`
- Search context
- Frame context
- `parentFrame()`
- `defaultContent()`
- Shadow DOM search context
- Shadow hosts and shadow roots
- Synchronization vs locator correctness
- `NoSuchElementException`
- `InvalidSelectorException`
- `StaleElementReferenceException`

## Locators Automated Workflow

The `LocatorsClosure.java` program:

1. Creates a Chrome WebDriver session.
2. Opens the SauceDemo application.
3. Maximizes the browser window.
4. Locates the username using `By.id()`.
5. Locates the password using `By.name()`.
6. Locates the Login button using `By.className()`.
7. Retrieves and prints the Login button value.
8. Collects all login-page input elements using `findElements()` and `By.tagName()`.
9. Prints the number of input elements.
10. Locates the username using a CSS attribute selector.
11. Retrieves and prints the username placeholder.
12. Locates the password using a relative XPath.
13. Retrieves and prints the password placeholder.
14. Locates the login container as a `WebElement`.
15. Searches only inside the login container for the Login button.
16. Clicks the scoped Login button.
17. Uses an explicit wait for the inventory page.
18. Collects all product cards using a CSS class selector.
19. Prints the inventory product count.
20. Locates the Sauce Labs Backpack product container using XPath based on descendant text.
21. Stores the product container as a `WebElement`.
22. Searches only inside the product container for the Add to Cart button.
23. Adds the product to the shopping cart.
24. Waits for the shopping-cart badge.
25. Retrieves and prints the shopping-cart badge value.
26. Terminates the WebDriver session using `quit()`.

## Locator Strategies Demonstrated in Code

| Strategy | Example Use |
|---|---|
| `By.id()` | Locating the username field |
| `By.name()` | Locating the password and scoped Login button |
| `By.className()` | Locating the Login button, login container, and shopping-cart badge |
| `By.tagName()` | Collecting all login-page input elements |
| `By.cssSelector()` | Locating username and inventory product cards |
| `By.xpath()` | Locating password and product container |
| `findElements()` | Collecting login inputs and inventory products |
| `WebElement.findElement()` | Searching inside the login container and product card |

## Locators Execution Evidence

```text
Submit Button Value: Login
Input Tag Count: 3
Username Placeholder: Username
Password Placeholder: Password
Inventory Product Count: 6
Cart Badge Count: 1
```

## Stale-Element Debugging Lesson

Dynamic web applications may asynchronously update, replace, or re-render parts of the DOM.

If Selenium locates an element and stores the resulting `WebElement` reference, that reference may become stale when the original DOM element is removed or replaced.

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

For example, if a product card is located before a page refresh or DOM re-render, the old stored product-card reference should not be reused.

The application should wait for the required page state and locate the product card again from the current DOM before interacting with elements inside it.

## Key Learning Outcomes

Through these modules, I practiced and demonstrated:

- Creating and terminating WebDriver sessions
- Using Selenium WebDriver browser commands
- Retrieving browser and page information
- Using browser navigation commands
- Managing multiple browser windows
- Understanding the difference between `close()` and `quit()`
- Using all eight Selenium locator strategies
- Understanding `findElement()` and `findElements()` behavior
- Writing CSS selectors
- Writing relative XPath expressions
- Choosing stable and maintainable locators
- Understanding DOM relationships
- Locating containers based on descendant text
- Performing scoped searches using `WebElement.findElement()`
- Working with `List<WebElement>`
- Using explicit waits with `WebDriverWait` and `ExpectedConditions`
- Understanding search contexts
- Understanding frames and Shadow DOM boundaries
- Distinguishing locator failures from synchronization problems
- Understanding `NoSuchElementException`
- Understanding `InvalidSelectorException`
- Understanding `StaleElementReferenceException`
- Re-locating elements after DOM replacement or re-rendering
- Cleaning and organizing Selenium Maven projects for portfolio presentation
- Publishing Selenium automation evidence to GitHub

## Setup Instructions

1. Clone the repository:

```bash
git clone <repository-url>
```

2. Navigate to the project directory:

```bash
cd selenium-foundations-closure
```

3. Verify Java and Maven:

```bash
java -version
mvn -version
```

4. Resolve and compile Maven dependencies:

```bash
mvn clean test-compile
```

5. Open the project in Eclipse or another Java IDE that supports Maven projects.

6. Ensure Google Chrome is installed.

Selenium Manager will manage ChromeDriver when driver management is required and a compatible driver can be resolved.

## How to Run

### Run Selenium Foundations

Open:

```text
BrowserCommandsClosure.java
```

Run as:

```text
Run As → Java Application
```

### Run Selenium Locators Closure

Open:

```text
LocatorsClosure.java
```

Run as:

```text
Run As → Java Application
```

Observe the browser automation workflow and console output.

## Future Improvements

Future versions of this project may include:

- TestNG integration
- Assertions and test-result verification
- Page Object Model implementation
- Test data management
- Logging and reporting
- Cross-browser execution
- Selenium Grid execution
- CI/CD integration