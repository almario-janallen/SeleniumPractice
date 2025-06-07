import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSelenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        System.out.println("Page title: " + driver.getTitle());
//        driver.quit();
    }
}
