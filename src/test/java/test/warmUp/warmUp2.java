package test.warmUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class warmUp2 {
    WebDriver driver;
    @AfterMethod
    public void tearDown() throws  InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }

    //TC #2: Selecting state from State dropdown and verifyingresult
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/dropdown
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test
    public void selection() {
        // 3.Select Illinois
        // 4.Select Virginia
        // 5.Select California
        Select stateDropDown = new Select(driver.findElement(By.id("state")));
        stateDropDown.selectByVisibleText("Illinois");
        stateDropDown.selectByValue("VA");
        stateDropDown.selectByIndex(5);
        // 6.Verify final selected option is California.Use all Select options.(visible text, value, index)
        String actual = stateDropDown.getFirstSelectedOption().getText();
        String expectedState = "California";
        Assert.assertEquals(actual, expectedState);

    }
}