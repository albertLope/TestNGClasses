package Day7;

import Day5._02_SearchFunctionality;
import Utils.BaseDriver;
import Utils.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _01_PlaceOrder extends BaseDriver {

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

        WebElement checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-payment-address")));
        checkout.click();

        WebElement contunie1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-shipping-address")));
        contunie1.click();

        WebElement contunie2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("collapse-shipping-address")));
        contunie2.click();

        WebElement contunie3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-shipping-method")));
        contunie3.click();

        WebElement checkBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
        checkBox.click();

        WebElement continue4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-payment-method")));
        continue4.click();

        WebElement confirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-confirm")));
        confirmButton.click();


        wait.until(ExpectedConditions.urlContains("success"));

        String placedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/h1"))).getText();

        Assert.assertEquals(placedText , "Your order has been placed!");

    }

}
