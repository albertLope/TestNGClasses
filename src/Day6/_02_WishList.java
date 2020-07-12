package Day6;

import Day5._01_SearchFunctionality;
import Utils.BaseDriver;
import Utils.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _02_WishList extends BaseDriver {

    _01_SearchFunctionality _01_SearchFunctionality = new _01_SearchFunctionality();
    ReusableMethods reusableMethods = new ReusableMethods();

    @Test(priority = 1, groups = {"Smoke","Regression"})
    @Parameters("itemName")
    public void addToWishList(String itemName){

        _01_SearchFunctionality.searchFunc(driver,itemName);

        List<WebElement> wishIconList = driver.findElements(By.xpath("//button[@data-original-title='Add to Wish List']"));

        int randNumber = reusableMethods.RandomGenerator(wishIconList.size());
        wishIconList.get(randNumber).click();

        List<WebElement> nameList = driver.findElements(By.xpath("//div[@class='caption']/h4"));

        String wishItemName = nameList.get(randNumber).getText();

        reusableMethods.successMessageValidate(wait);

        driver.findElement(By.xpath("//span[contains(text(),'Wish List')]")).click();

        List<WebElement> tableNames = driver.findElements(By.xpath("//tbody//td[2]"));

        reusableMethods.ListContainsString(tableNames , wishItemName);

    }

    @Test(priority = 2 , groups = {"Smoke","Regression"})
    public void removeFromTheWishList(){

        driver.findElement(By.xpath("//span[contains(text(),'Wish List')]")).click();

        List<WebElement> removeIcon = driver.findElements(By.xpath("//a[@class='btn btn-danger']"));

        for (WebElement eachIcon:removeIcon){

            eachIcon.click();

            reusableMethods.successMessageValidate(wait);
        }
    }

}
