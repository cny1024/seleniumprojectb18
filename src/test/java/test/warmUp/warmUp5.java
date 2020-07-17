package test.warmUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class warmUp5 {
    //TC #5: Selecting value from non-select dropdown
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/dropdown
    WebDriver driver;

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    //TC #3: Selecting date on dropdown and verifying
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
    public void tesst() {
        // 3.Click to non-select dropdown
        WebElement nonSelect = (driver.findElement(By.xpath("//a[@href='#']")));
        nonSelect.click();

        // 4.Select Facebook from dropdown
        WebElement selectFace = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));
        selectFace.click();

        // 5.Verify title is “Facebook -Log In or Sign Up”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";
        Assert.assertEquals(actualTitle,expectedTitle);

    }
}