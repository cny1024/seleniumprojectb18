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

public class warmUp3 {
    WebDriver driver;
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }
    //TC #3: Selecting date on dropdown and verifying
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/dropdown
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
    }
    // 3.Select “December 1st, 1921” and verify it is selected.
    // Select year using: visible textSelect month using : value attribute
    // Select day using: index number
    @Test
    public void testt(){
        Select yearDrodown = new Select(driver.findElement(By.id("year")));
        yearDrodown.selectByVisibleText("1921");
        Select monthDropdown = new Select(driver.findElement(By.id("month")));
        monthDropdown.selectByValue("11");
        Select dayDropdown = new Select(driver.findElement(By.id("day")));
        dayDropdown.selectByIndex(0);

        String actualYear = yearDrodown.getFirstSelectedOption().getText();
        String expectedYeat = "1921";
        Assert.assertEquals(actualYear,expectedYeat);

        String actualMonth =  monthDropdown.getFirstSelectedOption().getText();
        String exoectedMonth = "December";
        Assert.assertEquals(actualMonth,exoectedMonth);

        String actualDay = dayDropdown.getFirstSelectedOption().getText();
        String expectedDay = "1";
        Assert.assertEquals(actualDay,expectedDay);


    }
}
