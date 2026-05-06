package day23.annotationsExamples;

import org.testng.annotations.*;

public class AllAnnotations {

    @BeforeSuite
    void bs()  {
        System.out.println("This is BeforeSuite method...");
    }

    @AfterSuite
    void as() {
        System.out.println("This is AfterSuite method...");
    }

    @BeforeTest
    void bt() {
        System.out.println("This is BeforeTest method...");
    }

    @AfterTest
    void at() {
        System.out.println("This is AfterTest method...");
    }

    @BeforeClass
    void bc() {
        System.out.println("This is BeforeClass method...");
    }

    @AfterClass
    void ac() {
        System.out.println("This is AfterClass method...");
    }

    @BeforeMethod
    void bm() {
        System.out.println("This is Before method...");
    }

    @AfterMethod
    void am() {
        System.out.println("This is After method...");
    }

    @Test(priority = 1)
    void t1() {
        System.out.println("This is Test method1...");
    }

    @Test(priority = 2)
    void t2() {
        System.out.println("This is Test method2...");
    }





}
