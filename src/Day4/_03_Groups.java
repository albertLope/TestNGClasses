package Day4;

import org.testng.annotations.Test;

public class _03_Groups {



    @Test(groups = "Regression")
    public void test1(){

        System.out.println("Test1");

    }

    @Test(groups = {"Smoke" , "Regression"})
    public void test2(){

        System.out.println("Test2");

    }

}
