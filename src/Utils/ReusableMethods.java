package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReusableMethods extends BaseDriver{

    public List<String> webElementListToStringList(List<WebElement> myElementList){

        List<String> strList = new ArrayList<>();

        for(WebElement eachElement:myElementList){
            strList.add(eachElement.getText());
        }

        return strList;

    }


    public void compareToList(List<String> l1  , List<String> l2 ){

        for(int i = 0 ; i <l1.size();i++){

            Assert.assertEquals(l1.get(i) , l2.get(i));
        }

    }

    public int RandomGenerator(int max){
        Random rnd = new Random();

        return rnd.nextInt(max);
    }

    public void successMessageValidate(WebDriverWait wait){
        String success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']"))) .getText();

        Assert.assertTrue(success.contains("uccess"));
    }

    public void ListContainsString(List<WebElement>  l1 , String expectedString){

        boolean b1 = false;
        for(WebElement eachName:l1){

            if(eachName.getText().contains(expectedString)){
                b1=true;
            }
        }

        Assert.assertTrue(b1,expectedString+" wished item should be in the list but it is not");
    }


}
