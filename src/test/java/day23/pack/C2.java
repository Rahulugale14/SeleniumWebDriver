package day23.pack;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C2 {

    @Test
    void xyz() {
        System.out.println("This is xyz from C2...");
    }

    //below after test and before test can be in C1/C2 classes
    @AfterTest
    void at() {
        System.out.println("This is AfterTest method...");
    }

}
