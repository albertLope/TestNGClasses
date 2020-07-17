package Day2;

import Utils.BaseDriver;
import Utils.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Subscribe extends BaseDriver {

    ReusableMethods reusableMethods = new ReusableMethods();

    @Test(groups = "Smoke")
    public void testSubscribe1(){

        handleTheSubscribe();

        handleTheSubscribe();
    }

    public void handleTheSubscribe(){

        WebElement subscribe = driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter"));
        subscribe.click();

        String choose = driver.findElement(By.xpath("//input[@checked='checked']/parent::label")).getText();

        if(choose.contains("No")){
            driver.findElement(By.xpath("(//label[@class='radio-inline'])[1]/input")).click();
        }else{
            driver.findElement(By.xpath("(//label[@class='radio-inline'])[2]/input")).click();
        }

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        reusableMethods.successMessageValidate2(driver);
    }

}
