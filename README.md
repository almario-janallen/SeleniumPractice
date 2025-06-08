# SeleniumPractice

Basic Java + Selenium project for automation practice.

## ✅ Day 1 – First Selenium Test

- ✔ Installed Java, Maven, IntelliJ, and ChromeDriver
- ✔ Created Maven project: `SeleniumPractice`
- ✔ Ran a basic Selenium test to open a browser and fetch the page title

### 🔗 Tech Stack
- Java 17+
- Maven
- Selenium 4.21.0
- ChromeDriver

### 💻 Code Sample
```java
System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://google.com");
System.out.println("Page title: " + driver.getTitle());
