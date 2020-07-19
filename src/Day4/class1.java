package Day4;

import org.testng.annotations.*;

public class class1 {

    @BeforeSuite
    public void bSuite(){
        System.out.println("This is a before suite in class1");
    }

    @BeforeTest
    public void bTest(){
        System.out.println("This is a before Test in class1");
    }

    @BeforeGroups
    public void bGroups(){
        System.out.println("This is a before Groups in class1");
    }

    @BeforeClass
    public void bClass(){
        System.out.println("This is a before Class in class1");
    }

    @BeforeMethod
    public void bMethod(){
        System.out.println("This is a before Method in class1");
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
        System.out.println("This is a After Method in class1");
    }

    @AfterClass
    public void AClass(){
        System.out.println("This is a After Class in class1");
    }

    @AfterGroups
    public void AGroups(){
        System.out.println("This is a After Groups in class1");
    }

    @AfterTest
    public void ATest(){
        System.out.println("This is a After Test in class1");
    }

    @AfterSuite
    public void aSuite(){
        System.out.println("This is a After suite in class1");
    }
}
