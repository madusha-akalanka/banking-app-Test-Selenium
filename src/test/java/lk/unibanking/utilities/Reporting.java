package lk.unibanking.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extentReports;

    public ExtentTest extentTest;

    @Override
    public void onStart(ITestContext testContext) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String reportName = "Test-Report" + timestamp + ".html";
        File dir = new File("reports");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, reportName);


        sparkReporter = new ExtentSparkReporter(file);

        sparkReporter.config().setDocumentTitle("Banking System Test Project");
        sparkReporter.config().setReportName("Functional Test Automation Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("HostName", "localhost");
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Executed By", "Madusha");
        extentReports.setSystemInfo("OS", "Linux");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        extentTest = extentReports.createTest(tr.getName());
        extentTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

    }

    @Override
    public void onTestFailure(ITestResult tr) {
        extentTest = extentReports.createTest(tr.getName());
        extentTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

        String ssPath = "screenshot/" + tr.getName() + ".png";
        File file = new File(ssPath);

        if (file.exists()) {
            try {
                extentTest.fail("ScreenShot is Below: " + extentTest.addScreenCaptureFromPath(ssPath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


    @Override
    public void onTestSkipped(ITestResult tr) {
        extentTest = extentReports.createTest(tr.getName());
        extentTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));


    }

    @Override
    public void onFinish(ITestContext testContext) {
        extentReports.flush();
    }
}
