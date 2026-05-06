package day24;

import org.testng.annotations.Test;

//sanity test

public class LoginTests {

    @Test(priority = 1, groups = {"sanity"})
    void loginByEmail() {
        System.out.println("This is Login By Email");
    }

    @Test(priority = 2, groups = {"sanity"})
    void loginByFacebook() {
        System.out.println("This is Login By Facebook");
    }

    @Test(priority = 3, groups = {"sanity"})
    void loginByGoogle() {
        System.out.println("This is Login By Google");
    }

}
