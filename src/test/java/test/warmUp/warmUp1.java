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

import java.util.Arrays;

public class warmUp1 {

        WebDriver driver;

        @AfterMethod
        public void tearDown() throws  InterruptedException{
            Thread.sleep(2000);
            driver.close();
        }


        //TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values

        @BeforeMethod
                public void setUp(){
            // 1.Open Chrome browser
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // 2.Go to http://practice.cybertekschool.com/dropdown
            driver.get("http://practice.cybertekschool.com/dropdown");
        }
        @Test
        public void test_default_value_verification() {
            // 3.Verify “Simple dropdown” default selected value is correctExpected: “Please select an option”

            Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));


            String actualDefaultOfSimpleDrodown = simpleDropdown.getFirstSelectedOption().getText();
            String expectedDefaultOfSimpleDrodown = "Please select an option";

            Assert.assertEquals(actualDefaultOfSimpleDrodown, expectedDefaultOfSimpleDrodown);


            // 4.Verify“State selection” default selected value is correctExpected: “Select a State”

            Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
            String actualDefOfStateDD = stateDropdown.getFirstSelectedOption().getText();
            String expectedDefOfStateDD = "Select a State";

            Assert.assertEquals(actualDefOfStateDD, expectedDefOfStateDD);





        }

    }
