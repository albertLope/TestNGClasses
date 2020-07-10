package Day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Assertions {

    @Test
    public void testEquals(){

//        assertEquals verifying actual and expected texts are Equal

        String s1 = new String("Ali");
        String s2 = new String("Ali");

        Assert.assertEquals(s1, s2);
    }

    @Test
    public void testSame(){

//        assertEquals verifying actual and expected texts are Equal

      String s1 = new String("Ali");
      String s2 = new String("Ali");

        Assert.assertSame(s1, s2); // this will throw error


        /*
            Assert Equals is working as .equals in the java
            Assert Same is working as == in the java

            Interview question
                What is the difference between .equals vs ==

                .equals is checking is the value is equal or not
                == checks if both objects point to the same memory location whereas .equals() checking to the comparison of values in the objects.

         */
    }


    String s1;
    @Test
    public void Null(){

        Assert.assertNull(s1); // talk about not null as well
    }




}
