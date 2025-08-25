package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import tests.BaseTest;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("🚀 STARTING TEST: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("✅ PASSED: " + result.getName());
        captureScreenshot(result, "success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("❌ FAILED: " + result.getName(), result.getThrowable());
        captureScreenshot(result, "failure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("⚠️ SKIPPED: " + result.getName());
        captureScreenshot(result, "skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("=== Test Suite Started: " + context.getName() + " ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("=== Test Suite Finished: " + context.getName() + " ===");
    }

    private void captureScreenshot(ITestResult result, String status) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        if (driver != null) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, result.getName(),status);
            logger.info("📸 Screenshot saved at: " + screenshotPath);
        }
    }
}
