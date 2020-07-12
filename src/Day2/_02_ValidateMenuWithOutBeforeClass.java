package Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class _02_ValidateMenuWithOutBeforeClass {

    @Test
    public void menuValidation() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Selenium dependency\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://opencart.abstracta.us/index.php?route=common/home");

        WebElement myAccount = driver.findElement(By.xpath("//a[@title='My Account']"));
        myAccount.click();

        WebElement login = driver.findElement(By.xpath("//a[text()='Login']"));
        login.click();

        Thread.sleep(2000);

        driver.findElement(By.id("details-button")).click();

        driver.findElement(By.id("proceed-link")).click();

        WebElement EmailAddress = driver.findElement(By.id("input-email"));
        EmailAddress.sendKeys("asd@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("123qweasd");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        Thread.sleep(3000);

        List<WebElement> menuActualItems = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li"));

        List<String> menuActualStrItems =new ArrayList<>();

        List<String> menuExpectedList = new ArrayList<>();
        menuExpectedList.add("Desktops");
        menuExpectedList.add("Laptops & Notebooks");
        menuExpectedList.add("Components");
        menuExpectedList.add("Tablets");
        menuExpectedList.add("Software");
        menuExpectedList.add("Phones & PDAs");
        menuExpectedList.add("Cameras");
        menuExpectedList.add("MP3 Players");

        for(int i = 0 ; i<menuActualItems.size(); i++){
            menuActualStrItems.add(menuActualItems.get(i).getText());
            System.out.println(menuActualItems.get(i).getText());
        }
        for(int i = 0 ; i < menuActualItems.size() ; i++){
            Assert.assertEquals(menuActualStrItems.get(i) , menuExpectedList.get(i));
        }

        driver.quit();
    }

}
