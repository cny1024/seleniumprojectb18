package test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.WebDriverFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class TC_6 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        driver.get("https://qa2.vytrack.com/user/login");
    }

    @Test
    public void test_case_6() throws InterruptedException {
        WebElement username = driver.findElement(By.xpath("//input[@name='_username']"));
        username.sendKeys("storemanager69");
        WebElement password = driver.findElement(By.xpath("//input[@name='_password']"));
        password.sendKeys("UserUser123");
        WebElement login = driver.findElement(By.xpath("//button[@name='_submit']"));
        login.click();

        Thread.sleep(3000);

        Actions actions = new Actions(driver);
        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        actions.moveToElement(fleet).perform();
        Thread.sleep(3000);

        WebElement vehicleCosts = driver.findElement(By.xpath("(//div[@class='dropdown-menu-wrapper dropdown-menu-wrapper__placeholder'])[2]//ul//li[5]"));
        vehicleCosts.click();

        Thread.sleep(3000);

        WebElement createVehicleCosts = driver.findElement(By.xpath("//a[@title='Create Vehicle Costs']"));
        createVehicleCosts.click();

        Thread.sleep(3000);

        WebElement cancel = driver.findElement(By.xpath("//a[@title='Cancel']"));
        cancel.click();

        Thread.sleep(3000);
        WebElement createVehicleCosts2 = driver.findElement(By.xpath("//a[@title='Create Vehicle Costs']"));
        createVehicleCosts2.click();
        Thread.sleep(3000);

        WebElement saveAndClose = driver.findElement(By.xpath("//button[@type='submit']"));
        saveAndClose.click();

        Thread.sleep(3000);

        WebElement moreActions = driver.findElement(By.xpath("//a[@class='btn dropdown-toggle']"));
        moreActions.click();
        Thread.sleep(5000);


   WebElement addAttachment = driver.findElement(By.xpath("//a[@title='Add attachment']"));
       addAttachment.click();
       Thread.sleep(3000);

        WebElement addNote = driver.findElement(By.xpath("//a[@title='Add note']"));
        addNote.click();
        Thread.sleep(5000);

        WebElement addNoteBlank = driver.findElement(By.xpath("//body[@id='tinymce']"));
        driver.switchTo().frame("tinymce");
        addNoteBlank.sendKeys("Merhaba!");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        WebElement add = driver.findElement(By.xpath("//button[@type='submit']"));
        add.click();
        Thread.sleep(3000);

        WebElement addEvent = driver.findElement(By.xpath("//a[@title='Add an event to this record']"));
        addEvent.click();
        Thread.sleep(3000);
        WebElement title = driver.findElement(By.xpath("//input[@name='oro_calendar_event_form[title]']"));
        title.sendKeys("Baslik");
        Thread.sleep(3000);
        WebElement save = driver.findElement(By.xpath("//button[@type='submit']"));
        save.click();


        WebElement chooseFile = driver.findElement(By.name("oro_attachment[file][file]"));


        chooseFile.sendKeys("C:\\Users\\burhan\\Desktop\\kedi.jpg");


        WebElement save2 = driver.findElement(By.xpath("//button[@type='submit']"));
        save2.click();



        WebElement edit = driver.findElement(By.xpath("//a[@title='Edit Vehicle Costs']"));
        edit.click();

        Thread.sleep(3000);

        WebElement saveAndClose2 = driver.findElement(By.xpath("//button[@type='submit']"));
        saveAndClose2.click();

        Thread.sleep(3000);

        WebElement delete = driver.findElement(By.xpath("//a[@title='Delete Vehicle Costs']"));
        delete.click();

        Thread.sleep(3000);
        WebElement yesDelete = driver.findElement(By.xpath("//a[.='Yes, Delete']"));
        yesDelete.click();

        Thread.sleep(3000);

        WebElement reset = driver.findElement(By.xpath("//a[@title='Reset']"));
        reset.click();

    }
}
