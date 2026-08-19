package letcodein;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.AssertJUnit.assertFalse;

public class InputDemo {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/edit");

        // Enter Full Name
        driver.findElement(By.id("fullName")).sendKeys("Asmae Aouassar");

        // Append text and press keyboard tab
        driver.findElement(By.id("join")).sendKeys(" Teacher");
        driver.findElement(By.id("join")).sendKeys(Keys.TAB);

        // get what is inside the box
        String retrievedText = driver.findElement(By.id("getMe")).getAttribute("value");
        System.out.println("retrieved Text : "+retrievedText);

        // clear text
        driver.findElement(By.id("clearMe")).clear();

        // confirm edit field is disabled
        boolean isEditFieldEnabled = driver.findElement(By.id("noEdit")).isEnabled();
        assertFalse(isEditFieldEnabled);

        // confirm text is readonly
        String readOnlyValue = driver.findElement(By.id("dontwrite")).getAttribute("readonly");
        if(readOnlyValue.equals("true")){
            System.out.println("This Input is readonly");
        }else{
            System.out.println("This Input is NOT readonly");
        }
    }
}
