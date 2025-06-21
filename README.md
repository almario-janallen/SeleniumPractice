# SeleniumPractice

Basic Java + Selenium project for automation practice.

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
