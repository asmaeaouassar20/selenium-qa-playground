package manip;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class AlertJavaScriptTest {
    @Test
    public void verifyJavaScriptTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle,expectedTitle);

        // --- alert button ---
        WebElement buttonAlertJS = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        buttonAlertJS.click();
        // wait alert to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent()); // attend qu’une alerte soit présente, puis la stocke dans la variable alert.
        String actualTextAlert = alert.getText();
        String expectedTextAlert = "I am a JS Alert";
        assertEquals(actualTextAlert,expectedTextAlert);
        // click on "ok"
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        WebElement resultBlock = driver.findElement(By.id("result"));
        String actualResultContent = resultBlock.getText();
        String expectedResultContent = "You successfully clicked an alert";
        assertEquals(actualResultContent,expectedResultContent);

        // --- confirm button ---
        WebElement confirmButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        confirmButton.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        alert = wait.until(ExpectedConditions.alertIsPresent());
        actualTextAlert = alert.getText();
        expectedTextAlert = "I am a JS Confirm";
        assertEquals(actualTextAlert,expectedTextAlert);
        Thread.sleep(3000);
        alert.accept();

        // dismiss alert confirmation
        confirmButton.click();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        alert = wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(3000);
        alert.dismiss();
        expectedResultContent = "You clicked: Cancel";
        actualResultContent = resultBlock.getText();
        assertEquals(actualResultContent,expectedResultContent);

        // prompt alert
        WebElement btnPrompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        btnPrompt.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        alert = wait.until(ExpectedConditions.alertIsPresent());
        actualTextAlert = alert.getText();
        expectedTextAlert = "I am a JS prompt";
        assertEquals(actualTextAlert,expectedTextAlert);
        Thread.sleep(3000);
        alert.sendKeys("I wanna be a good engineer like Jilali");
        Thread.sleep(3000);
        alert.accept();
        expectedResultContent = "You entered: I wanna be a good engineer like Jilali";
        actualResultContent = resultBlock.getText();
        assertEquals(actualResultContent,expectedResultContent);

        // dismiss prompt alert
        Thread.sleep(3000);
        btnPrompt.click();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        alert = wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(3000);
        alert.dismiss();
        expectedResultContent="You entered: null";
        actualResultContent = resultBlock.getText();
        assertEquals(actualResultContent,expectedResultContent);
    }
}
