package elementstatus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class WebElementStatus {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/checkbox");

        WebElement homeElm = driver.findElement(By.xpath("//span[@class='rc-tree-title']"));
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div/div/span[3]"));

        // [1] isDisplayed()
        boolean isDisplayed = homeElm.isDisplayed();
        System.out.println(" [1] isDisplayed : " + isDisplayed);
        assertTrue(isDisplayed);

        // [2] isEnabled()
        boolean isEnabled = checkbox.isEnabled();
        System.out.println(" [2] isEnabled : " + isEnabled);
        assertTrue(isEnabled);

        // [3] isSelected()
        boolean isSelected = checkbox.isSelected();
        System.out.println(" [3] isSelected : "+isSelected);
        assertFalse(isSelected);

        driver.close();
    }
}
