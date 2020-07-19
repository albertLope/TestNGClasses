package Day7_8_PagesObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WishListElements {

    public WishListElements(WebDriver driver){
        PageFactory.initElements( driver , this );
    }

    @FindAll({
            @FindBy(xpath = "//button[@data-original-title='Add to Wish List']")})
    public List<WebElement> wishIconList;

    @FindAll({
            @FindBy(xpath = "//div[@class='caption']/h4")})
    public List<WebElement> nameList;

    @FindBy(xpath = "//span[contains(text(),'Wish List')]")
    public WebElement WishList;

    @FindAll({
            @FindBy(xpath = "//tbody//td[2]")})
    public List<WebElement> tableNames;

    @FindAll({
            @FindBy(xpath = "//a[@class='btn btn-danger']")})
    public List<WebElement> removeIcon;
}
