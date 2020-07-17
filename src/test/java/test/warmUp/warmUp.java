package test.warmUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class warmUp {
    public static void main(String[] args) {


        //TC
// #1: PracticeCybertek.com_ForgotPassword WebElement verification
// 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
// 2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");
// 3. Locate all the WebElements on the page using XPATH locator only (total of 6)
        // a. "Home" link
        driver.findElement(By.xpath("//a[@class='nav-link']"));

        // b. "Forgot password" header
        if(driver.findElement(By.xpath("//h2[.='Forgot Password']")).isDisplayed()){
            System.out.println();
        }
        // c. "E-mail" text
        driver.findElement(By.xpath("//label[@for='email']"));
        // d. E-mail input box
        driver.findElement(By.xpath("//input[@name='email']"));
        // e. "Retrieve password" button
        driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
        // f. "Powered by Cybertek School" text
        driver.findElement(By.xpath("//div[@style='text-align: center;']"));
// 4. Verify all WebElements are displayed.


    }

}
