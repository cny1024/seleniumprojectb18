package test.warmUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class warmUp4 {

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

    // 3.Select all the options from multiple select dropdown.
    // 4.Print out all selected values.
    @Test
    public void SelectAllOptions() throws InterruptedException {
        Select select = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        Thread.sleep(2000);
        List<WebElement> list = select.getOptions();
        Thread.sleep(2000);
        for (WebElement each : list) {
            select.selectByVisibleText(each.getText());
            System.out.println(each.getText());
        }

// 5.Deselect all values
        select.deselectAll();
    }
}