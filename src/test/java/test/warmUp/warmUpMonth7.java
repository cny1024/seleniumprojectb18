package test.warmUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class warmUpMonth7 {
    WebDriver driver;

//TC#7: Cybertek “month”dropdown default value
// 1.Open browser
// 2.Go to website: http://practice.cybertekschool.com/dropdowns
// 3.Verify default value is always showing the current monthoExpected: If currently in June, should show June selected.
    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
    }
    @Test
    public void testt(){
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        String actual = monthDropdown.getFirstSelectedOption().getText();
        String expected = "June";
        Assert.assertEquals(actual,expected);

    }
}