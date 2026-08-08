package manip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class NavigationTest {
    @Test
    public void verifyRedirectionToYtbLink(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

        WebElement youtubeLink = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[7]/a"));
        youtubeLink.click();

        String expectedTitle = "AutomationExercise - YouTube";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle,actualTitle);

        List<WebElement> ytbTitleElms = driver.findElements(By.xpath("//*[@id=\"page-header\"]/yt-page-header-renderer/yt-page-header-view-model/div/div[1]/div/yt-dynamic-text-view-model/h1/span"));
        assertEquals(1,ytbTitleElms.size());
    }
}
