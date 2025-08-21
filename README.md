# SeleniumPractice

A structured learning project focused on mastering Java and Selenium for test automation.
This repository contains daily progress on foundational Java concepts, Selenium WebDriver automation, and real-world QA testing scenarios.

### 🚀 What you'll find here:
- Java basics, control structures, OOP, collections, and file I/O
- Selenium automation using WebDriver, locators, waits, POM, and TestNG
- QA-focused mini-projects (e.g., login tests, result logging, test case management)
- Daily journal entries, code snippets, and progress logs
- Modular code with reusable utilities and meaningful folder structure

### 🔗 Tech Stack
- Java 17+
- Maven
- Selenium 4.21.0
- ChromeDriver
- IntelliJ IDEA

## Progress Milestones

### ✅ Day 1: Environment Setup & First Selenium Test
- Installed JDK, Maven, IntelliJ IDEA, ChromeDriver
- Created Maven project and ran a basic Selenium test to open a browser and fetch page title

### ✅ Days 2-3: Java Basics & Control Structures
- Practiced variables, data types, operators, loops, and conditionals with example programs

### ✅ Day 4: Object-Oriented Programming (OOP)
- Created classes and objects
- Implemented methods, constructors, and basic interactions with object properties

### ✅ Day 5: Inheritance and Polymorphism
- Created a base Vehicle class and extended it with a Car subclass
- Used super to call the superclass constructor and override methods
- Demonstrated runtime polymorphism using a Vehicle array containing different object types
- Practiced method overriding and object-oriented design principles

### ✅ Day 6: Collections & Exception Handling
- Learned how to use ArrayList and the differences between arrays and ArrayList
- Practiced removing elements and handling reindexing
- Introduced exception handling using try-catch-finally
- Created and used custom exceptions for realistic QA scenarios

### ✅ Day 7: File I/O with QA Context
- Read test case results from a file using BufferedReader
- Wrote a test summary report and logged errors using BufferedWriter
- Integrated custom exceptions for input validation (e.g., InvalidTestResultException)

### ✅ Day 8-9: Selenium Setup & Locators
- Configured Selenium WebDriver with Java and Maven
- Ran a test that opens a browser, visits a site, and prints the page title
- Practiced basic test execution flow and browser teardown
- Practiced locating elements using id, name, className, and tagName 
- Automated login on saucedemo.com

### ✅ Day 10: XPath & CSS Selectors

- Practiced locating elements using XPath and CSS
- Used exact and **partial match** techniques:
    - `contains()`, `starts-with()` in XPath
    - `^=`, `$=`, `*=` in CSS Selectors

### ✅ Day 11: QA Login Test Suite with Result Logging
- Created a structured test framework for verifying login scenarios on SauceDemo
- Used Selenium WebDriver to automate login inputs and validation
- Implemented LoginData class for test case structure
- Added PageFunctions utility class for browser handling
- Wrote TestLogger class to generate timestamped test reports
- Verified success via URL match and failure via error message content

### ✅ Day 12: Waits in Selenium
- Explored different wait strategies: Implicit Wait, Explicit Wait, and Fluent Wait
- Applied waits to handle dynamic page loading and element interaction timing issues
- Used WebDriverWait and ExpectedConditions to wait for visibility, clickability, and presence of elements
- Implemented Fluent Wait with polling intervals and ignored exceptions
- Enhanced test stability by reducing NoSuchElementException and ElementNotInteractableException occurrences

### ✅ Day 13: Working with Forms
- Automated interactions with various form elements: dropdowns, radio buttons, checkboxes, text fields, and password inputs
- Retrieved and validated selected options and states of form elements
- Tested disabled and readonly fields for expected behavior when using sendKeys()
- Worked with color pickers, date pickers, and range sliders for input validation
- Applied Selenium actions to change element values and verify the updated states

### ✅ Day 14: SauceDemo Login Automation – Positive & Negative Tests
- Automated login scenarios on SauceDemo covering both valid and invalid credentials
- Implemented a single-class Java + Selenium solution with a reusable login() helper method
- Positive test: validated successful login via URL containing /inventory.html
- Negative test: validated error message display for invalid login attempts
- Added step-by-step console logging for traceability of test actions
- Ensured browser closes safely with try-finally to handle exceptions
- Prepared code for future migration to TestNG framework and possible data-driven testing

### ✅ Day 15: Alerts, Frames, and Windows
- Automated handling of JavaScript alerts (accept, dismiss, and prompt with input)
- Used explicit waits to manage delayed alerts safely
- Practiced switching into and out of iframes to interact with embedded elements
- Implemented multiple window handling: opened new tabs and windows, switched context, closed child windows, and returned to parent
- Skipped DemoQA’s “New Window Message” due to DOM limitations

### ✅ Day 16: Advanced User Actions
- Practiced mouse hover using moveToElement() for menus and submenus
- Performed drag-and-drop using dragAndDrop() and alternative chaining with clickAndHold() → moveToElement() → release()
- Automated right-click (contextClick) and double-click interactions
- Simulated keyboard actions using keyDown(), sendKeys(), and keyUp()
- Understood that all chained actions must be finalized with .perform()
- Applied skills on demo websites: DemoQA (menu hover) and Herokuapp (drag-and-drop)

### ✅ Day 17: JavaScriptExecutor – Scroll & Click Mini-Project
- Learned to cast WebDriver to JavascriptExecutor to execute JavaScript commands
- Practiced scrolling techniques: by pixels (window.scrollBy) and scrolling into view of specific elements (scrollIntoView(true))
- Highlighted elements dynamically for debugging using JS styles
- Clicked elements using JavaScript when Selenium .click() was unreliable
- Handled alert popups triggered after JS actions (e.g., Add to Cart on DemoBlaze)
- Built a mini-project: scrolled to a product on DemoBlaze, opened it, clicked Add to Cart using JS, and verified navigation to the cart

### ✅ Day 18: Page Object Model (POM)
- Created LoginPage and InventoryPage classes with reusable locators and actions
- Refactored LoginTest to use POM structure for better readability and maintainability
- Added post-login validations: URL check and Products page header
- Used JavaScriptExecutor to highlight elements for debugging

## How to Run

1. Clone this repo
2. Ensure ChromeDriver is installed and its path is correctly set (system environment or project config)
3. Use Maven to build the project
4. Run Java classes with `main()` methods for each practice topic (e.g., OOP, File I/O, Selenium tests)


## Next Steps
- 🔍 Advanced WebDriver commands and locator strategies
- ⏱ Handling waits (implicit, explicit), user interactions, and alerts
- 🧪 Creating structured test frameworks with TestNG
- 🚧 Real-world QA automation projects (e.g., DemoBlaze, SauceDemo)

---

Happy coding! 🚀
