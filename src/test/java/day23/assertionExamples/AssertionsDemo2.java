package day23.assertionExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo2 {

    @Test
    void testTitle() {

        String expTitle = "OpenCart";
        String actTitle = "CloseCart";


        if (expTitle.equals(actTitle)) {
            System.out.println("Test Passed");
            Assert.assertTrue(true);
        }
        else {
            System.out.println("Test Failed");
            Assert.assertTrue(false);
        }


    }
}
