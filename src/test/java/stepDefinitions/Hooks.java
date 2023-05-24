package stepDefinitions;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    @AfterStep
    public void tearDown(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {
            // naming the screenshot with the current date to avoid duplication
            String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            // TakesScreenshot is an interface of selenium that takes the screenshot
            TakesScreenshot ts = (TakesScreenshot) Driver.getAppiumDriver();

            File source = ts.getScreenshotAs(OutputType.FILE);
            // full path to the screenshot location
            String target = System.getProperty("user.dir") + "/target/Screenshots/" + "MobileSS" + date + ".png";
            File finalDestination = new File(target);
            // save the screenshot to the path given
            FileUtils.copyFile(source, finalDestination);
        }
    }
/*
    @Before
    public void setup(String ipAddress, int port) {
        ipAddress = "0.0.0.0";
        port = 4723 ;

        AppiumDriverLocalService service;
        service = new AppiumServiceBuilder()
                .withAppiumJS(
                        new File("C:\\Program Files\\Appium Server GUI\\resources\\app\\node_modules\\appium\\lib")) // change this location from yours
                .withIPAddress(ipAddress).usingPort(port).build(); // ipAddress : "127.0.0.1" port : 4723


        service.start();
      //  return service;
    }
*/
}
