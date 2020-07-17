package Day4;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class _03_Groups {


    @BeforeGroups(groups = "Regression")
    public void beforeGroup(){
        System.out.println("beforeGroup");
    }

    @Test(groups = "Regression")
    public void test1(){
        System.out.println("Test1 Regression");
    }

    @Test(groups = "Regression")
    public void test2(){
        System.out.println("Test2 Regression");
    }

    @Test(groups = {"Regression"})
    public void test3(){
        System.out.println("Test3 Smoke");
    }

    @Test(groups = {"Smoke"})
    public void test4(){

        System.out.println("Test4 Smoke");

    }

}
