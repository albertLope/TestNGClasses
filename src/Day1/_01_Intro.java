package Day1;

import Utils.Hooks;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _01_Intro {


    /*
        First create a before method Tests and after method

        TestNG is running alphabetically

        Then add a priority to run the zzz first

     */

    @BeforeMethod
    public void beforeMethod(){

        System.out.println("Before Method");
    }

    @Test(priority = 1)
    public void zzz(){

        System.out.println("Test1");

    }

    @Test(priority = 2)
    public void aaa(){

        System.out.println("Test2");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method");
    }


}
