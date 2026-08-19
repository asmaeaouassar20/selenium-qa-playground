package letcodein;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DropdownsDemo {
    public static void main(String[] args)  {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/dropdowns");
        String pageTitle = "Dropdowns | LetCode with Koushik";
        System.out.println("Title : "+pageTitle);

        // instruction 1 : select in dropdown
        WebElement fruitsDropDown = driver.findElement(By.id("fruits"));
        Select selectBTN = new Select(fruitsDropDown);
        selectBTN.selectByVisibleText("Apple");
        WebElement resultSpaceUI = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/section/div/div[1]/div/div[1]/div[2]/p"));
        String expectedText = "You have selected Apple";
        String actualText = resultSpaceUI.getText();
        assertEquals(expectedText,actualText);

        // Ce dropdown n'est pas multi select
        assertFalse(selectBTN.isMultiple());


        // instruction 2 : multi selection dropdown
        WebElement multiSelectDropDown = driver.findElement(By.id("superheros"));
        selectBTN = new Select(multiSelectDropDown);
        assertTrue(selectBTN.isMultiple());

        selectBTN.selectByVisibleText("Batman");
        selectBTN.selectByVisibleText("Daredevil");
        selectBTN.selectByVisibleText("Elektra");

        String expectedResult = "You have selected Batman, Daredevil, Elektra";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/section/div/div[1]/div/div[2]/div[2]/p")).getText();

        assertEquals(expectedResult,actualResult);
        System.out.println("RESULT OF MULTISELECTION : "+actualResult);



        // instruction 3 : select and print
        WebElement programmingLangSelectBTN = driver.findElement(By.id("lang"));
        selectBTN = new Select(programmingLangSelectBTN);

        // list of options
        List<WebElement> options = selectBTN.getOptions();

        // nbr of options
        int nbrOptions = options.size();

        // select last option
        selectBTN.selectByIndex(nbrOptions-1);
        actualResult = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/section/div/div[1]/div/div[3]/div[2]/p")).getText();
        expectedResult = "You have selected C#";
        assertEquals(expectedResult,actualResult);

        // display  in console
        System.out.println("--- List of " + options.size() + " options : --- ");
        for (WebElement option : options){
            System.out.println(option.getText());
        }
        System.out.println("\nlast option : " + options.get(nbrOptions-1).getText());


        // instruction 4 : select by value
        WebElement selectByValueDropDown = driver.findElement(By.id("country"));
        selectBTN = new Select(selectByValueDropDown);
        selectBTN.selectByValue("India");
        expectedResult="Selected Value: India";
        actualResult = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/section/div/div[1]/div/div[4]/div[2]/p")).getText();
        assertEquals(expectedResult,actualResult);

        // display the selected value
        System.out.println("Selected Country : " + selectBTN.getFirstSelectedOption().getText());

        driver.quit();
    }
}
