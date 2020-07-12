package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class BaseDriver {

    protected WebDriver driver;
    protected WebDriverWait wait ;

    @BeforeMethod(groups = {"Smoke","Regression"})
    @Parameters("browser")
    public void BeforeClass(String browser){

        if(browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\Selenium dependency\\drivers\\chromedriver.exe");

            driver = new ChromeDriver();

        }else if(browser.equals("firefox")){

//            https://github.com/mozilla/geckodriver/releases
            System.setProperty("webdriver.gecko.driver", "D:\\Selenium dependency\\drivers\\geckodriver.exe");

            driver = new FirefoxDriver();

        }

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver,10);
        driver.get("http://opencart.abstracta.us/index.php?route=common/home");

        WebElement myAccount = driver.findElement(By.xpath("//a[@title='My Account']"));
        myAccount.click();

        WebElement login = driver.findElement(By.xpath("//a[text()='Login']"));
        login.click();

        try{

            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("details-button")))).click();

            driver.findElement(By.id("proceed-link")).click();
        }catch (Exception e ){
            System.out.println("Fucking firefox");
        }

        WebElement EmailAddress = driver.findElement(By.id("input-email"));
        EmailAddress.sendKeys("asd@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("123qweasd");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
