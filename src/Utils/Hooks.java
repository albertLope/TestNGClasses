package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Hooks {

    protected WebDriver driver;

    @BeforeMethod
    public void BeforeClass(){

        System.setProperty("webdriver.chrome.driver", "D:\\Selenium dependency\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://opencart.abstracta.us/index.php?route=common/home");


        WebElement myAccount = driver.findElement(By.xpath("//a[@title='My Account']"));
        myAccount.click();

        WebElement login = driver.findElement(By.xpath("//a[text()='Login']"));
        login.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("details-button")).click();

        driver.findElement(By.id("proceed-link")).click();

        WebElement EmailAddress = driver.findElement(By.id("input-email"));
        EmailAddress.sendKeys("asd@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("123qweasd");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

    }

    @AfterMethod
    public void afterMethod(){
//        driver.quit();
    }
}
