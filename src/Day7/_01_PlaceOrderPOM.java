package Day7;

import Day5._02_SearchFunctionality;
import Day7_8_PagesObjectModel.PlaceOrder;
import Utils.BaseDriver;
import Utils.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _01_PlaceOrderPOM extends BaseDriver {

    _02_SearchFunctionality _01_SearchFunctionality = new _02_SearchFunctionality();
    ReusableMethods reusableMethods = new ReusableMethods();

    public void AddToCart(String itemName){

        System.out.println(itemName + "<--- item name ");

        _01_SearchFunctionality.searchFunc(driver,itemName);

        List<WebElement> itemList = driver.findElements(By.xpath("//div[@class='image']/a"));

        itemList.get(reusableMethods.RandomGenerator(itemList.size())).click();

        driver.findElement(By.xpath("//button[@id='button-cart']")).click();

        reusableMethods.successMessageValidate(wait);

    }

    @Test
    @Parameters("itemName")
    public void ProceedToCheckout(String itemName){
        AddToCart(itemName);

        driver.findElement(By.xpath("//span[text()='Shopping Cart']")).click();

        driver.findElement(By.linkText("Checkout")).click();

        PlaceOrder class1Pages = new PlaceOrder(driver);

        class1Pages.checkout.click();

        wait.until(ExpectedConditions.visibilityOf(class1Pages.contunie1)).click();
        wait.until(ExpectedConditions.visibilityOf(class1Pages.contunie2)).click();
        wait.until(ExpectedConditions.visibilityOf(class1Pages.contunie3)).click();
        wait.until(ExpectedConditions.visibilityOf(class1Pages.checkBox)).click();
        wait.until(ExpectedConditions.visibilityOf(class1Pages.continue4)).click();
        wait.until(ExpectedConditions.visibilityOf(class1Pages.confirmButton)).click();

        wait.until(ExpectedConditions.urlContains("success"));

        String placedText =  wait.until(ExpectedConditions.visibilityOf(class1Pages.placedMessage)).getText();

        Assert.assertEquals(placedText , "Your order has been placed!");

    }

}
