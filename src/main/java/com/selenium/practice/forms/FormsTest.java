package com.selenium.practice.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class FormsTest {

    public static void main(String[] args) {
        // 🔧 Setup WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // 🌐 Navigate to a demo form page
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");

            // ✅ Interact with a Dropdown (Select)
            WebElement dropdown = driver.findElement(By.name("my-select"));
            Select select = new Select(dropdown);

            // Step 1: Get and print the initially selected option
            WebElement initiallySelected = select.getFirstSelectedOption();
            System.out.println("Initially selected: " + initiallySelected.getText());

            // Step 2: Select a different option
            select.selectByVisibleText("Two");  // or use selectByValue("2") if available

            // Step 3: Get and print the newly selected option
            WebElement newlySelected = select.getFirstSelectedOption();
            System.out.println("Newly selected: " + newlySelected.getText());


            // ✅ Interact with a Checkbox
            WebElement checkbox1 = driver.findElement(By.id("my-check-1"));
            WebElement checkbox2 = driver.findElement(By.id("my-check-2"));

            ArrayList<WebElement> checkboxes = new ArrayList<>();
            checkboxes.add(checkbox1);
            checkboxes.add(checkbox2);

            // Step 1: Check initial state of two checkboxes
            System.out.println("Initial Status of Textboxes:");
            for (WebElement checkbox : checkboxes) {
                WebElement label = checkbox.findElement(By.xpath(".."));
                String labelText = label.getText();
                System.out.println(labelText + " is selected? " + checkbox.isSelected());
            }

            // Step 2: Change state (toggle it)
            checkbox2.click();  // This will toggle the checkbox

            // Step 3: Check new state
            System.out.println("Final Status of Textboxes:");
            for (WebElement checkbox : checkboxes) {
                WebElement label = checkbox.findElement(By.xpath(".."));
                String labelText = label.getText();
                System.out.println(labelText + " is selected? " + checkbox.isSelected());
            }

            // ✅ Interact with a Radio Button
            WebElement radio1 = driver.findElement(By.id("my-radio-1"));
            WebElement radio2 = driver.findElement(By.id("my-radio-2"));

            ArrayList<WebElement> radioboxes = new ArrayList<>();
            radioboxes.add(radio1);
            radioboxes.add(radio2);
            System.out.println("Initial Status of Textboxes:");
            for (WebElement radiobox : radioboxes) {
                WebElement label = radiobox.findElement(By.xpath(".."));
                String labelText = label.getText();
                System.out.println(labelText + " is selected? " + radiobox.isSelected());
            }

            radio2.click();
            System.out.println("Final Status of Textboxes:");
            for (WebElement radiobox : radioboxes) {
                WebElement label = radiobox.findElement(By.xpath(".."));
                String labelText = label.getText();
                System.out.println(labelText + " is selected? " + radiobox.isSelected());
            }
            System.out.println();

            // ✅ Interact with Text boxes
            //Text Field
            WebElement textInput = driver.findElement(By.id("my-text-id")); //
            textInput.clear();
            textInput.sendKeys("Test Input");
            String text = textInput.getAttribute("value");
            System.out.println("Text entered: " + text);

            //Password Field
            WebElement password = driver.findElement(By.name("my-password"));
            password.clear();
            password.sendKeys("testPassword");
            String enteredPassword = password.getAttribute("value");
            System.out.println("Password entered: " + enteredPassword);

            //Text Area
            WebElement textArea = driver.findElement(By.name("my-textarea"));
            textArea.clear();
            textArea.sendKeys("test Text Area");
            String enteredTextArea = textArea.getAttribute("value");
            System.out.println("TextArea entered: " + enteredTextArea);

            //Disabled Input
            WebElement disabledInput = driver.findElement(By.name("my-disabled"));
            boolean isDisabled = !disabledInput.isEnabled();  // results to !(False) =>  True
            System.out.println("Is field disabled? " + isDisabled);

            //Readonly Input
            WebElement readOnlyInput = driver.findElement(By.name("my-readonly"));
            // Check if readonly using attribute
            String readonlyAttr = readOnlyInput.getAttribute("readonly");
            boolean isReadonly = readonlyAttr != null;
            System.out.println("Is field readonly? " + isReadonly);

            // Try to send keys
            try {
                readOnlyInput.sendKeys("Trying to type");
                System.out.println("SendKeys executed without error.");
            } catch (Exception e) {
                System.out.println("Could not type in readonly field: " + e.getMessage());
            }


            // ✅ Interact with Color picker
            WebElement colorPicker = driver.findElement(By.name("my-colors"));
            // Set color to red
            colorPicker.sendKeys("#ff0000");

            // Verify color value
            String selectedColor = colorPicker.getAttribute("value");
            System.out.println("Selected color: " + selectedColor);

            // ✅ Interact with Date picker
            WebElement datePicker = driver.findElement(By.name("my-date"));

            // Set date to 2025-08-12
            datePicker.sendKeys("08-12-2025");
            datePicker.sendKeys(Keys.TAB);

            // Verify date value
            String selectedDate = datePicker.getAttribute("value");
            System.out.println("Selected date: " + selectedDate);


            WebElement rangeSlider = driver.findElement(By.name("my-range"));

            Actions actions = new Actions(driver);
            actions.clickAndHold(rangeSlider)
                    .moveByOffset(80, 0)  // move slider right by 30 pixels
                    .release()
                    .perform();

            // Verify new value
            String value = rangeSlider.getAttribute("value");
            System.out.println("Slider value after drag: " + value);

            // ✅ Submit the form
            WebElement submitBtn = driver.findElement(By.tagName("button"));
            submitBtn.click();


        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    public static void checkboxIsSelected(WebElement checkbox) {
        if(checkbox.isSelected()) {
            System.out.println(checkbox.getText());
        }
    }
}
