package day24;

import org.testng.annotations.Test;

//Functional Test - includes Sanity + Regression tests

public class PaymentTests {

    @Test(priority = 1, groups = {"sanity", "regression", "functional"})
    void paymentInRupees() {
        System.out.println("Payment In Rupees");
    }

    @Test(priority = 2, groups = {"sanity", "regression", "functional"})
    void paymentInDollars() {
        System.out.println("Payment In Dollars");
    }


}
