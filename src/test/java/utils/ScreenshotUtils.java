package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;

public class ScreenshotUtils {

    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("screenshots/" + fileName + ".png");
            Files.createDirectories(dest.getParentFile().toPath()); // create folder if it doesn't exist
            Files.copy(src.toPath(), dest.toPath());
            System.out.println("✅ Screenshot saved: " + dest.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
