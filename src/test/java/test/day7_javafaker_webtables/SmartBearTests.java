package test.day7_javafaker_webtables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTests {
    WebDriver driver;
    @AfterMethod
    public void closee() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    @BeforeMethod
    public void setUp(){
        //TC #1: Smartbear software link verification
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        SmartBearUtilities.login(driver);


    }
    @Test
    public void smartBear_login_Test(){

        //6. Print out count of all the links on landing page
         List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
        System.out.println("Number of the links: "+allLinks.size());
        int expectedNumberOfLinks = 6;
        int actualNumberOfLinks = allLinks.size();
        Assert.assertEquals(expectedNumberOfLinks,actualNumberOfLinks);

        //7. Print out each link text on this page
        for (WebElement EachLink : allLinks){
            System.out.println(EachLink.getText());
        }
    }

    @Test
    public void  smartbear_order_placing_test() throws InterruptedException {
        //TC#2: Smartbear software order placing
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        //3. Enter username: "Tester"
        //4. Enter password: "test"
        //5. Click on Login button
        //6. Click on Order
        WebElement orderButton = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        orderButton.click();
        //7. Select familyAlbum from product, set quantity to 2
        Select productDropdown = new Select(driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        productDropdown.selectByVisibleText("FamilyAlbum");
        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        Thread.sleep(1000);
        quantity.sendKeys(Keys.BACK_SPACE);
        quantity.sendKeys("2");
        //8. Click to "Calculate" button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@type='submit']"));
        calculateButton.click();
        //9. Fill address Info with JavaFaker

        WebElement inputCustomerName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement inputStreet = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement inputCity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement inputState = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement inputZip = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        Faker faker = new Faker();
        //• Generate: name,
        inputCustomerName.sendKeys(faker.name().fullName());
        // street,
        inputStreet.sendKeys(faker.address().streetAddress());
        // city,
        inputCity.sendKeys(faker.address().city());
        // state,
        inputState.sendKeys(faker.address().state());
        // zip code
        inputZip.sendKeys(faker.address().zipCode().replaceAll("-",""));


        //10. Click on "visa" radio button
        WebElement visaButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaButton.click();
        //11. Generate card number using JavaFaker
        WebElement cardNum = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        cardNum.sendKeys(faker.finance().creditCard().replaceAll("-",""));
        WebElement expDate = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expDate.sendKeys("11/23");
        //12. Click on "Process"
        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();
        //13.Verify success message "New order has been successfully added."
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));//strong is enough
        //String actualMessage = successMessage.getText();
       // String expectedMessage = "New order has been successfully added.";
        //Assert.assertEquals(actualMessage,expectedMessage);
        Assert.assertTrue(successMessage.isDisplayed());


    }


}
