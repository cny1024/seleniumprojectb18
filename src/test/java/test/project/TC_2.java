package test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.WebDriverFactory;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

public class TC_2 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        driver.get("https://qa1.vytrack.com/user/login");
    }

    @Test
    public void CreateAndCancel() throws InterruptedException {
        WebElement username = driver.findElement(By.xpath("//input[@name='_username']"));
        username.sendKeys("storemanager69");
        WebElement password = driver.findElement(By.xpath("//input[@name='_password']"));
        password.sendKeys("UserUser123");
        WebElement login = driver.findElement(By.xpath("//button[@name='_submit']"));
        login.click();

        Thread.sleep(5000);

        Actions actions = new Actions(driver);
        WebElement fleetModule = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        actions.moveToElement(fleetModule).perform();

        WebElement vehicles = driver.findElement(By.xpath("(//div[@class='dropdown-menu-wrapper dropdown-menu-wrapper__scrollable'])[2]/ul/li[3]"));
        vehicles.click();

        Thread.sleep(5000);

        WebElement createCar = driver.findElement(By.xpath("//a[@title='Create Car']"));
        createCar.click();

        Thread.sleep(5000);
        WebElement cancel = driver.findElement(By.xpath("//a[@title='Cancel']"));
        cancel.click();

        Thread.sleep(5000);

        WebElement createCar2 = driver.findElement(By.xpath("//a[@title='Create Car']"));
        createCar2.click();

        Thread.sleep(5000);
        WebElement addVModel = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        addVModel.click();

        Thread.sleep(5000);
        WebElement Vmodel = driver.findElement(By.xpath("(//input[@tabindex='-1'])[7]"));
        Vmodel.click();

        Thread.sleep(5000);
        WebElement select = driver.findElement(By.xpath("//button[.='Select']"));
        select.click();

        Thread.sleep(5000);
        WebElement addVmake = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        addVmake.click();

        Thread.sleep(5000);
        WebElement Vmake = driver.findElement(By.xpath("(//input[@tabindex='-1'])[7]"));
        Vmake.click();

        Thread.sleep(5000);
        WebElement select2 = driver.findElement(By.xpath("//button[.='Select']"));
        select2.click();

        Thread.sleep(5000);
        WebElement submit = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        submit.click();

        Thread.sleep(5000);
        WebElement addEvent = driver.findElement(By.xpath("//a[@title='Add an event to this record']"));
        addEvent.click();

        Thread.sleep(5000);
        WebElement title = driver.findElement(By.xpath("//input[@name='oro_calendar_event_form[title]']"));
        title.sendKeys("naber");

        Thread.sleep(5000);
        WebElement SaveEvent = driver.findElement(By.xpath("//button[.='Save']"));
        SaveEvent.click();

        Thread.sleep(5000);
        WebElement edit = driver.findElement(By.xpath("//a[@title='Edit Car']"));
        edit.click();

        Thread.sleep(5000);
        WebElement submit2 = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        submit2.click();

        Thread.sleep(5000);
        WebElement delete = driver.findElement(By.xpath("//a[@title='Delete Car']"));
        delete.click();

        Thread.sleep(5000);
        WebElement yesDelete = driver.findElement(By.xpath("//a[.='Yes, Delete']"));
        yesDelete.click();
    }

}