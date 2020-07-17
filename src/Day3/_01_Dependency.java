package Day3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {

    @Test(dependsOnMethods = {"method1"})
    public void method2(){

        System.out.println("method2");

    }

    @Test
    public void method1(){

        System.out.println("method1");

        Assert.assertEquals("asd" , "123");

    }

}
