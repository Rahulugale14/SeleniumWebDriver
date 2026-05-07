package day26;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

    public class ExtentReportManager implements ITestListener {

        ExtentSparkReporter sparkReporter;
        ExtentReports extent;
        ExtentTest test;


        // =========================================
        // ON START
        // =========================================
        @Override
        public void onStart(ITestContext context) {

            // Report location
            String reportPath = System.getProperty("user.dir")
                    + "/extent-reports/ExtentReport.html";

            // Spark Reporter
            sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");

            // Document Title
            sparkReporter.config().setDocumentTitle("Automation Report");

            // Report Name
            sparkReporter.config().setReportName("Functional Testing");

            // Theme Name
            sparkReporter.config().setTheme(Theme.STANDARD);

            // Main Extent Object
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // System Information
            extent.setSystemInfo("Computer Name", "localhost");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Tester Name", "Rahul");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        }


        // =========================================
        // TEST START
        // =========================================
        /*@Override
        public void onTestStart(ITestResult result) {

            test = extent.createTest(result.getName());
            test.log(Status.INFO,
                    "Test Started: " + result.getName());
        }

         */


        // =========================================
        // TEST SUCCESS
        // =========================================
        @Override
        public void onTestSuccess(ITestResult result) {

            test = extent.createTest(result.getName());
            test.log(Status.PASS,
                    "Test Passed: " + result.getName());
        }


        // =========================================
        // TEST FAILURE
        // =========================================
        @Override
        public void onTestFailure(ITestResult result) {

            test = extent.createTest(result.getName());
            test.log(Status.FAIL,
                    "Test Failed: " + result.getName());

            test.log(Status.FAIL,
                    "Test Failed cause is: " + result.getThrowable());
        }


        // =========================================
        // TEST SKIPPED
        // =========================================
        @Override
        public void onTestSkipped(ITestResult result) {

            test = extent.createTest(result.getName());
            test.log(Status.SKIP,
                    "Test Skipped: " + result.getName());
        }


        // =========================================
        // PARTIAL SUCCESS
        // =========================================
        /*@Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

            test = extent.createTest(result.getName());
            test.log(Status.WARNING,
                    "Test Partially Passed: " + result.getName());
        }

         */


        // =========================================
        // TEST FAILED WITH TIMEOUT
        // =========================================
        /*@Override
        public void onTestFailedWithTimeout(ITestResult result) {

            test = extent.createTest(result.getName());
            test.log(Status.FAIL,
                    "Test Failed Due To Timeout: " + result.getName());
        }

         */


        // =========================================
        // ON FINISH
        // =========================================
        @Override
        public void onFinish(ITestContext context) {

            extent.flush();

            System.out.println("Extent Report Generated Successfully");
        }

    }

