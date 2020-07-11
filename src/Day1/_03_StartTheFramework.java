package Day1;

import Utils.HooksForFirstClass;
import org.testng.annotations.Test;

public class _03_StartTheFramework extends HooksForFirstClass {

    @Test(priority = 1)
    public void test1(){

        String URL = driver.getCurrentUrl();

        System.out.println("In the first method "+URL);

    }

    @Test(priority = 2)
    public void test2(){

        String URL = driver.getCurrentUrl();

        System.out.println("In the second method "+URL);

    }
}
