package Day5;

import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _02_SearchFunctionality extends BaseDriver {


    @Test(groups = {"Smoke"} , enabled = false)
    @Parameters("itemName")
    public void SearchFunction(String itemName ){
        searchFunc(driver , itemName);
    }

        public void searchFunc(WebDriver driver , String itemName){
            System.out.println(itemName + "<--- item name ");

            driver.findElement(By.xpath("//input[@name='search']")).sendKeys(itemName);

            driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

            List<WebElement> itemNames = driver.findElements(By.tagName("h4"));

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for(WebElement each:itemNames){
                Assert.assertTrue(each.getText().contains(itemName));
            }

        }

}
