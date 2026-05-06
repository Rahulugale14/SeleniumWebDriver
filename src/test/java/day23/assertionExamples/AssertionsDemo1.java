package day23.assertionExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo1 {

    @Test
    void testTitle() {

        String expTitle = "OpenCart";
        String actTitle = "CloseCart";


        //below condition statement (if else loop) will show above method as passed everytime. to overcome this we use assertions as shown below
        /*
        if (expTitle.equals(actTitle)) {
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }
        */

        Assert.assertEquals(expTitle, actTitle);
    }
}
