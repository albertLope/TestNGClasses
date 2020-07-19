package Day8;

import Day5._02_SearchFunctionality;
import Day7_8_PagesObjectModel.WishListElements;
import Utils.BaseDriver;
import Utils.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _02_WishListWithPOM extends BaseDriver {

    _02_SearchFunctionality _01_SearchFunctionality = new _02_SearchFunctionality();
    ReusableMethods reusableMethods = new ReusableMethods();


    @Test(priority = 1, groups = {"Smoke","Regression"})
    @Parameters("itemName")
    public void addToWishList(String itemName){

        _01_SearchFunctionality.searchFunc(driver,itemName);

        WishListElements wishListElements = new WishListElements(driver);
        System.out.println( wishListElements.wishIconList.size()+ "<----------------------");
        int randNumber = reusableMethods.RandomGenerator( wishListElements.wishIconList.size());
        wishListElements.wishIconList.get(randNumber).click();

        List<WebElement> nameList = wishListElements.nameList;

        String wishItemName = nameList.get(randNumber).getText();

        reusableMethods.successMessageValidate(wait);

        wishListElements.WishList.click();

        List<WebElement> tableNames = wishListElements.tableNames;

        reusableMethods.ListContainsString(tableNames , wishItemName);

    }

    @Test(priority = 2 , groups = {"Smoke","Regression"})
    public void removeFromTheWishList(){
        WishListElements wishListElements = new WishListElements(driver);
        wishListElements.WishList.click();

        List<WebElement> removeIcon = wishListElements.removeIcon;

        for (WebElement eachIcon:removeIcon){

            eachIcon.click();

            reusableMethods.successMessageValidate(wait);
        }
    }

}
