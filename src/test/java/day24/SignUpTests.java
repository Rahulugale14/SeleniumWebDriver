package day24;

import org.testng.annotations.Test;

//Regression Test

public class SignUpTests {

    @Test(priority = 1, groups = {"regression"})
    void signUpByEmail() {
        System.out.println("This is Signup By Email");
    }

    @Test(priority = 2, groups = {"regression"})
    void signUpByFacebook() {
        System.out.println("This is Signup By Facebook");
    }

    @Test(priority = 3, groups = {"regression"})
    void signUpByGoogle() {
        System.out.println("This is Signup By Google");
    }

}
