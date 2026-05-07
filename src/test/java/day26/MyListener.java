package day26;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    //this method executes only once before execution of all test methods
    public void onStart(ITestContext context) {
        System.out.println("Test execution is started");
    }

    //this executes depends on the number of methods we have
    public void onTestStart(ITestResult result) {
        System.out.println("Test started");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed");

    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed");

    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped");

    }

    //this will also execute only once & will execute when all test methods execution is completed
    public void onFinish(ITestContext context) {
        System.out.println("Test execution is completed");

    }



}
