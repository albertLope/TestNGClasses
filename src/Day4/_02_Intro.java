package Day4;

import org.testng.annotations.*;

public class _02_Intro {


    /*
        @BeforeSuite
            @BeforeTest
                @BeforeGroups
                    @BeforeClass
                        @BeforeMethod
                            @Test
                            @Test
                      @AfterMethod
                    @BeforeClass
                @BeforeGroups
            @BeforeTest
        @AfterSuite
    */


    @Test
    public void TestInIntro2_1(){
        System.out.println("This is TestInIntro2_1 ");
    }

    @Test
    public void TestInIntro2_2(){
        System.out.println("This is TestInIntro2_1 ");
    }


}
