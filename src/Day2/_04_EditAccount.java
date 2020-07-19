package Day2;

import Utils.BaseDriver;
import Utils.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _04_EditAccount extends BaseDriver {

    ReusableMethods reusableMethods = new ReusableMethods();

    @Test
    public void EditAccount(){

        AccountEdit("Steven" , "Gerard");
        AccountEdit("asd123" , "asd");

    }

    public void AccountEdit(String username , String lastname){
        WebElement editAccount = driver.findElement(By.linkText("Edit Account"));
        editAccount.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys(username);

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.clear();
        lastName.sendKeys(lastname);

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        reusableMethods.successMessageValidate(wait);

    }

}
