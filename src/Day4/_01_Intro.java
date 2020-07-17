package Day4;

import org.testng.annotations.*;

public class _01_Intro {


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
  /*  BeforeSuite
'         BeforeTest
     '   '   BeforeClass
'   '   '        BeforeMethod
        '   '   '   '   myTestMethod1
'   '   '        AfterMethod
    '   '   '   BeforeMethod
        '   '   '   '   myTestMethod2
'       '   '   AfterMethod
    '   '   AfterClass
'      AfterTest
    AfterSuite
   */

    @BeforeSuite
    public void bSuite(){
        System.out.println("This is a before suite");
    }

    @BeforeTest
    public void bTest(){
        System.out.println("This is a before Test");
    }

    @BeforeGroups
    public void bGroups(){
        System.out.println("This is a before Groups");
    }

    @BeforeClass
    public void bClass(){
        System.out.println("This is a before Class");
    }

    @BeforeMethod
    public void bMethod(){
        System.out.println("This is a before Method");
    }

    @Test
    public void TestInIntro1(){
        System.out.println("This is test 1 ");
    }

    @Test
    public void TestInIntro2(){
        System.out.println("This is test 2 ");
    }

    @AfterMethod
    public void AMethod(){
        System.out.println("This is a After Method");
    }

    @AfterClass
    public void AClass(){
        System.out.println("This is a After Class");
    }

    @AfterGroups
    public void AGroups(){
        System.out.println("This is a After Groups");
    }

    @AfterTest
    public void ATest(){
        System.out.println("This is a After Test");
    }

    @AfterSuite
    public void aSuite(){
        System.out.println("This is a After suite");
    }
}
