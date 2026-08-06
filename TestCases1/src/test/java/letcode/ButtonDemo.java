package letcode;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ButtonDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/button");

        // instruction 1
        driver.findElement(By.id("home")).click();
        Thread.sleep(2000); // pause program execution for 2s
        driver.navigate().back(); // go back
        Thread.sleep(2000);

        // instruction 2
        WebElement btnLocation = driver.findElement(By.id("position"));
        int x = btnLocation.getLocation().getX();
        int y = btnLocation.getLocation().getY();
        System.out.print("Location : ");
        System.out.println("x = " + x + " , y = " + y);

        // instruction 3
        WebElement colorBtn = driver.findElement(By.id("color"));
        String backgroundColor = colorBtn.getCssValue("background-color");
        System.out.println("Button's color : " + backgroundColor);

        // instruction 4
        WebElement sizeBtn = driver.findElement(By.id("property"));
        int height = sizeBtn.getSize().getHeight();
        int width = sizeBtn.getSize().getWidth();
        System.out.print("Dimension : ");
        System.out.println("height = " + height + " , width = " + width);

        // instruction 5
        WebElement disabledBtn = driver.findElement(By.id("isDisabled"));
        assertFalse(disabledBtn.isEnabled());

        // instruction 6
        System.out.println("start instruction 6");
        List<WebElement> btnToHolds = driver.findElements(By.xpath("//*[@id=\"isDisabled\"]"));
        Actions actions = new Actions(driver);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        actions.clickAndHold(btnToHolds.get(1)).pause(Duration.ofSeconds(5)).release().perform();
        System.out.println("hold button");
        System.out.println("end instruction 6");
        driver.quit();
    }
}
