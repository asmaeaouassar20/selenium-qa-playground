package register;

// Test Case Register Functionality 001

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

import static org.testng.AssertJUnit.*;


public class AuthenticationTest {
    @Test
    public void registerAccount(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/signup");

        System.out.println("**** Before signup ****");
        System.out.println("--- Page title ---");
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println("--- Current URL ---");
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);

        WebElement inputName = driver.findElement(By.xpath("//input[@name=\"name\"]"));
        inputName.sendKeys("asmae");

        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        Date date = new Date(); // utiliser le timestamp pour générer une adresse email
        String generatedEmail = date.toString().replace(" ", "_").replace(":","_")+"@gmail.com";
        emailInput.sendKeys(generatedEmail);
        System.out.println(" ==> Email utilisé : "+generatedEmail);

        WebElement signupBtn = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        signupBtn.click();

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("asmae");

        WebElement selectBDElmDay = driver.findElement(By.xpath("//*[@id=\"days\"]"));
        selectBDElmDay.click();

        WebElement dayOption3=driver.findElement(By.xpath("//option[text()=\"3\"]"));
        dayOption3.click();

        WebElement  selectBDElmMonth= driver.findElement(By.xpath("//*[@id=\"months\"]"));
        selectBDElmMonth.click();

        WebElement monthOption5 = driver.findElement(By.xpath("//option[text()=\"May\"]"));
        monthOption5.click();

        WebElement selectBDElmYear = driver.findElement(By.xpath("//*[@id=\"years\"]"));
        selectBDElmYear.click();

        WebElement yearOption2003 = driver.findElement(By.xpath("//option[text()=\"2003\"]"));
        yearOption2003.click();

        WebElement firstNameInput = driver.findElement(By.id("first_name"));
        firstNameInput.sendKeys("Asmae");

        WebElement lastNameInput = driver.findElement(By.id("last_name"));
        lastNameInput.sendKeys("Aouassar");

        WebElement companyInput = driver.findElement(By.id("company"));
        companyInput.sendKeys("SQLI");

        WebElement address1Input = driver.findElement(By.id("address1"));
        address1Input.sendKeys("this is my address 1");

        WebElement selectCountry = driver.findElement(By.id("country"));
        selectCountry.click();

        WebElement canadaCountryOption = driver.findElement(By.xpath("//option[text()='Canada']"));
        canadaCountryOption.click();

        WebElement stateInput=driver.findElement(By.id("state"));
        stateInput.sendKeys("State example");

        WebElement cityInput = driver.findElement(By.id("city"));
        cityInput.sendKeys("City Exammple");

        WebElement zipCodeInput = driver.findElement(By.id("zipcode"));
        zipCodeInput.sendKeys("30050");

        WebElement mobileNumberInput = driver.findElement(By.id("mobile_number"));
        mobileNumberInput.sendKeys("0688000000");

        WebElement createAccountBTN = driver.findElement(By.xpath("//button[text()='Create Account']"));
        createAccountBTN.click();

        // vérifier la création de compte
        WebElement welcomeMsgParagraph = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/p[1]"));

        boolean isWelcomeMsg1Displayed = welcomeMsgParagraph.isDisplayed();
        System.out.println("isMsg1Displayed ? : "+isWelcomeMsg1Displayed);

        String msg = welcomeMsgParagraph.getText();
        assertTrue(msg.contains("Congratulations! Your new account has been successfully created!"));

        WebElement  welcomeMsgParagraph2= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/p[2]"));

        boolean isWelcomeMsg2Displayed = welcomeMsgParagraph2.isDisplayed();
        System.out.println("isMsg2Displayed ? : "+ isWelcomeMsg2Displayed);

        String msg2 = welcomeMsgParagraph2.getText();
        assertTrue(msg2.contains("You can now take advantage of member privileges to enhance your online"));

        System.out.println("**** After signup ****");
        System.out.println("--- Page title ---");
        title = driver.getTitle();
        System.out.println(title);
        System.out.println("--- Current URL ---");
        currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);

        String expectedURL = "https://automationexercise.com/account_created";
        System.out.println("Expected URL : "+expectedURL);

        WebElement continueButtonElement = driver.findElement(By.xpath("//a[text()='Continue']"));
        continueButtonElement.click();

        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Automation Exercise";

        /*
        if(actualPageTitle.equals(expectedPageTitle)){
            System.out.println("User has successfully navigated to expected page");
        }else{
            System.out.println("User has not navigated to expected page. Hence Failed");
        }*/

        // exemple d'utilisation de testNG
        assertTrue(actualPageTitle.equals(expectedPageTitle));
        // or
        assertEquals(actualPageTitle,expectedPageTitle);

        driver.quit();

    }

    @Test
    public void login(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/login");

        WebElement emailLoginInput = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"));
        emailLoginInput.sendKeys("jilali@gmail.com");

        WebElement passwordLoginInput = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"));
        passwordLoginInput.sendKeys("jilali");

        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
        loginBtn.click();

        String  expectedTitle= "Automation Exercise";
        assertEquals(expectedTitle , driver.getTitle());

        // vérifier l'existence du lien de déconnexion
        List<WebElement> logoutLinks = driver.findElements(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        assertFalse(logoutLinks.isEmpty());

        driver.quit();
    }
}
