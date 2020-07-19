package Day6._02_DataProvider;

import com.sun.org.apache.xpath.internal.operations.String;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _03_multiParameterDataProvider {

    @Test(dataProvider = "credentialsProvider")
    void testCase1(String login, String password) {
        System.out.println("The login is: " + login);
        System.out.println("The password is: " + password);
    }

    @DataProvider(name = "credentialsProvider")
    public Object[][] data() {
        return new Object[][]{
                {"Cedric", "password1"},
                {"Anna", "password2"},
        };
    }

    @Test(dataProvider = "dataProvider")
    void testCase2(String name, Integer age) {
        System.out.println(name + " is " + age + " year old!");
    }

    @DataProvider(name = "dataProvider")
    public Object[][] data2() {
        return new Object[][]{
                {"cedric", 23},
                {"anne", 21},
        };
    }
}
