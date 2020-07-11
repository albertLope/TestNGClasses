package Day1;

import org.testng.annotations.*;

public class _01_Intro {


    /*

        Download TestNG jar file

        First create a before method Tests and after method

        TestNG is running alphabetically

        Then add a priority to run the zzz first

     */

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @Test(priority = 1)
    public void TestZ(){
        System.out.println("test zzz");
    }

    @Test(priority = 2)
    public void TestA(){
        System.out.println("Test2");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

}
