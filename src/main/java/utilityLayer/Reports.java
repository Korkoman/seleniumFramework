package utilityLayer;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import java.io.File;

public class Reports {

    static ExtentReports extent;

    public static ExtentReports setReports(String clase) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(new File(System.getProperty("user.dir") + "/test-output/" + clase + "/report.html"));
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }

}
