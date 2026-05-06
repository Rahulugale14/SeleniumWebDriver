package day23.annotationsExamples;

import org.testng.annotations.*;

public class AnnotationsDemo2 {

    @BeforeClass
    void login() {
        System.out.println("This is login...");
    }

    @Test(priority=1)
    void search() {
        System.out.println("This is search...");
    }

    @Test(priority=2)
    void advancedSearch() {
        System.out.println("This is advanced search...");
    }

    @AfterClass
    void logout() {
        System.out.println("This is logout...");
    }


}
