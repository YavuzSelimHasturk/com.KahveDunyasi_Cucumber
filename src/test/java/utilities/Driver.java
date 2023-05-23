package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static AppiumDriver<WebElement> appiumDriver;

    public static AppiumDriver getAppiumDriver() {
        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http:0.0.0.0:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (appiumDriver == null) {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.UDID, ConfigReader.getProperty("UDIDNumber"));

            caps.setCapability("appPackage","com.kahvedunyasi.app");
            caps.setCapability("appActivity","com.kahvedunyasi.app.activities.SplashActivity");

            if (ConfigReader.getProperty("platformName").equals("Android")) {

                appiumDriver = new AndroidDriver<>(appiumServerURL,caps);
                appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }else {

                throw new UnsupportedOperationException("Invalid Platform Name ");

            }
        }
        return appiumDriver;
    }

    public static void quitAppiumDriver() {
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}
