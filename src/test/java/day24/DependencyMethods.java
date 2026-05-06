package day24;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods {

    @Test(priority=1)
    void openApp() {
        Assert.assertTrue(true);                //try to change true here & below any method as false
    }

    @Test(priority=2, dependsOnMethods = {"openApp"})
    void login() {
        Assert.assertTrue(true);
    }

    @Test(priority=3, dependsOnMethods = "login")
    void search() {
        Assert.assertTrue(false);
    }

    @Test(priority=4, dependsOnMethods = {"login", "search"})                 //can specify multiple methods here
    void advancedSearch() {
        Assert.assertTrue(true);
    }

    @Test(priority=5, dependsOnMethods = "login")
    void logout() {
        Assert.assertTrue(true);

    }


}
