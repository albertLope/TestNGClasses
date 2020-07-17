package Day3;

import Utils.BaseDriver;
import Utils.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _02_AddressFunctionality extends BaseDriver {

    ReusableMethods reusableMethods = new ReusableMethods();

    @Test(groups = {"Smoke" , "Regression"})
    public void AddAddress(){

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        WebElement NewAddress = driver.findElement(By.linkText("New Address"));
        NewAddress.click();

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Origi");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Corner");
        driver.findElement(By.xpath("//input[@name='company']")).sendKeys("Liverpool");
        driver.findElement(By.xpath("//input[@name='address_1']")).sendKeys("Premier league");
        driver.findElement(By.xpath("//input[@name='address_2']")).sendKeys("Champion");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("England");
        driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("12345");
        WebElement country = driver.findElement(By.xpath("//select[@name='country_id']"));

        reusableMethods.chooseRandomFromDropdown(country);

        WebDriverWait wait = new WebDriverWait(driver , 10);

        By el = By.xpath("//select[@id='input-zone']/option");

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(el,3));

        WebElement regionState = driver.findElement(By.id("input-zone"));
        reusableMethods.chooseRandomFromDropdown(regionState);

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        reusableMethods.successMessageValidate(wait);

    }

    @Test(dependsOnMethods = {"AddAddress"} , groups = {"Regression"})
    public void editAddress(){


        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editButtons = driver.findElements(By.linkText("Edit"));
        editButtons.get(editButtons.size()-1).click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.clear();
        firstName.sendKeys("Steven");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.clear();
        lastName.sendKeys("Gerard");

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        reusableMethods.successMessageValidate(wait);
    }

    @Test(dependsOnMethods = {"editAddress"}  , groups = { "Regression"})
    public void deleteAddress(){

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> deleteButtons = driver.findElements(By.linkText("Delete"));
        deleteButtons.get(deleteButtons.size()-1).click();

        reusableMethods.successMessageValidate(wait);

    }

}
