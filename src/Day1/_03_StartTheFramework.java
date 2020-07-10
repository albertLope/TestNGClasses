package Day1;

import Utils.Hooks;
import Utils.HooksForFirstClass;
import org.testng.annotations.Test;

public class _03_StartTheFramework extends HooksForFirstClass {

    @Test
    public void test1(){

        String URL = driver.getCurrentUrl();

        System.out.println("In the first method "+URL);

    }

    @Test
    public void test2(){

        String URL = driver.getCurrentUrl();

        System.out.println("In the second method "+URL);

    }
}
