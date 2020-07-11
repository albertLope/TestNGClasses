package Day2;

import Utils.BaseDriver;
import Utils.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class _01_ValidateMenu extends BaseDriver {

    ReusableMethods reusableMethods = new ReusableMethods();

    @Test
    public void menuValidation(){

        List<WebElement> menuActualItems = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li"));

        List<String> menuActualStrItems = new ArrayList<>();

        List<String> menuExpectedList = new ArrayList<>();
        menuExpectedList.add("Desktops");
        menuExpectedList.add("Laptops & Notebooks");
        menuExpectedList.add("Components");
        menuExpectedList.add("Tablets");
        menuExpectedList.add("Software");
        menuExpectedList.add("Phones & PDAs");
        menuExpectedList.add("Cameras");
        menuExpectedList.add("MP3 Players");

        menuActualStrItems =reusableMethods.webElementListToStringList(menuActualItems);

        reusableMethods.compareToList(menuExpectedList , menuActualStrItems);

    }
}
