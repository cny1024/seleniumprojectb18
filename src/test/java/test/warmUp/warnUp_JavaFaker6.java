package test.warmUp;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class warnUp_JavaFaker6 {
    //TC#6: Cybertek registration form confirmationNote: Use JavaFaker when possible.
    // 1.Open browser
    // 2.Go to website: http://practice.cybertekschool.com/registration_form
    WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/registration_form");
    }
    @Test
    public void  registration(){
        // 3.Enter first name
        // 4.Enter last name
        // 5.Enter username
        // 6.Enter email address
        // 7.Enter password
        // 8.Enter phone number
        // 9.Select a gender from radio buttons
        // 10.Enter date of birth
        // 11.Select Department/Office
        // 12.Select Job Title
        // 13.Select programming language from checkboxes
        // 14.Clickto sign up button
        // 15.Verify success message “You’ve successfully completed registration.”is displayed.

        Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("cny1024");

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.internet().password());

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys(faker.phoneNumber().phoneNumber().replace(".","-"));

        WebElement genderMale = driver.findElement(By.xpath("//input[@name='gender']"));
        genderMale.click();

        WebElement dateOfBirth = driver.findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirth.sendKeys("11/07/1994");

        Select department=new Select(driver.findElement(By.xpath("//select[@name='department']")));
        department.selectByValue("DE");

        Select jobTitle=new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByIndex(3);

        WebElement progLanguages=driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        progLanguages.click();

        WebElement signUp = driver.findElement(By.id("wooden_spoon"));
        signUp.click();

        WebElement successMessage = driver.findElement(By.xpath("//div//p"));
        Assert.assertTrue(successMessage.isDisplayed());








    }

}
