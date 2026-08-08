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

    @Test
    public void verifyNavigationTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

        // products link
        WebElement productsLink = driver.findElement(By.xpath("//a[@href='/products']"));
        productsLink.click();
        String expectedProductsTitlePage = "Automation Exercise - All Products";
        String actualProductsTitlePage = driver.getTitle();
        System.out.println("products : "+expectedProductsTitlePage);
        assertEquals(expectedProductsTitlePage,actualProductsTitlePage);

        // Cart link
        WebElement cartLink = driver.findElement(By.xpath("//a[@href='/view_cart']"));
        cartLink.click();
        String expectedCartTitlePage = "Automation Exercise - Checkout";
        String actualCartTitlePage = driver.getTitle();
        System.out.println("cart : "+expectedCartTitlePage);
        assertEquals(expectedCartTitlePage,actualCartTitlePage);


        // Auth link
        WebElement authLink = driver.findElement(By.xpath("//a[@href='/login']"));
        authLink.click();
        String expectedAuthTitlePage = "Automation Exercise - Signup / Login";
        String actualAuthTitlePage = driver.getTitle();
        System.out.println("auth : "+expectedAuthTitlePage);
        assertEquals(expectedAuthTitlePage,actualAuthTitlePage);

        // Test Cases link
        WebElement TCLink = driver.findElement(By.xpath("//a[@href='/test_cases']"));
        TCLink.click();
        String expectedTCTitlePage = "Automation Practice Website for UI Testing - Test Cases";
        String actualTCTitlePage = driver.getTitle();
        System.out.println("Test Cases : " + expectedTCTitlePage);
        assertEquals(expectedTCTitlePage,actualTCTitlePage);

        // API Testing link
        WebElement APITestLink = driver.findElement(By.xpath("//a[@href='/api_list']"));
        APITestLink.click();
        String expectedAPITestTitlePage = "Automation Practice for API Testing";
        String actualAPITestTitlePage = driver.getTitle();
        System.out.println("API Testing : " + expectedAPITestTitlePage);
        assertEquals(expectedAPITestTitlePage,actualAPITestTitlePage);


        // Contact us link
        WebElement contactLink = driver.findElement(By.xpath("//a[@href='/contact_us']"));
        contactLink.click();
        String expectedContactTitlePage = "Automation Exercise - Contact Us";
        String actualContactTitlePage = driver.getTitle();
        System.out.println("contact : "+expectedContactTitlePage);
        assertEquals(expectedContactTitlePage,actualContactTitlePage);

        // home link
        WebElement homeLink = driver.findElement(By.xpath("//a[@href='/']"));
        homeLink.click();
        String expectedHomeTitlePage = "Automation Exercise";
        String actualHomeTitlePage = driver.getTitle();
        System.out.println("home : "+expectedHomeTitlePage);
        assertEquals(expectedHomeTitlePage,actualHomeTitlePage);

        driver.quit();
    }
}
