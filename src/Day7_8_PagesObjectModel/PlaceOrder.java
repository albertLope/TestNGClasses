package Day7_8_PagesObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrder {
    public PlaceOrder(WebDriver driver){
        PageFactory.initElements( driver , this );
    }

    @FindBy(xpath = "//span[text()='Shopping Cart']")
    public WebElement shoppingCart;

    @FindBy(id = "button-payment-address")
    public WebElement checkout;

    @FindBy(id = "button-shipping-address")
    public WebElement contunie1;

    @FindBy(id = "collapse-shipping-address")
    public WebElement contunie2;

    @FindBy(id = "button-shipping-method")
    public WebElement contunie3;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBox;

    @FindBy(id = "button-payment-method")
    public WebElement continue4;

    @FindBy(id = "button-confirm")
    public WebElement confirmButton;

    @FindBy (xpath = "//div[@id='content']/h1")
    public WebElement placedMessage;

}
