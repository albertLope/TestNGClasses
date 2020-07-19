package Day5;

import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _01_Footer_StartHere extends BaseDriver {

    /*
        In case if we need extra tests then we can start using these

     */
    @Test
    @Parameters({"enquiry" })
    public void contactUs(String enquiry){

        driver.findElement(By.linkText("Contact Us")).click();

        driver.findElement(By.id("input-enquiry")).sendKeys(enquiry);

        driver.findElement(By.xpath("//input[@value='Submit']")).click();

        String successMessage = driver.findElement(By.xpath("//div[@id='content']/p")).getText();

        Assert.assertTrue(successMessage.contains("successfully "));

    }

    @Test
    public void specials(){

        driver.findElement(By.linkText("Specials")).click();

        List<WebElement> oldAmount = driver.findElements(By.xpath("//span[@class='price-old']"));

        List<WebElement> items = driver.findElements(By.xpath("//div[@class='image']"));

        Assert.assertTrue(oldAmount.size()==items.size());

    }

    @Test(enabled = false)
    public void Information(){

        List<WebElement>  informationList = driver.findElements(By.xpath("//h5[text()='Information']/parent::div//a"));

        for(int i =0 ; i<informationList.size() ; i++){

            informationList = driver.findElements(By.xpath("//h5[text()='Information']/parent::div//a"));

            String eachInfo = informationList.get(i).getText();

            informationList.get(i).click();

            String h1Text = driver.findElement(By.tagName("h1")).getText();

            Assert.assertEquals(eachInfo,h1Text);

            driver.navigate().back();
        }

    }
}
