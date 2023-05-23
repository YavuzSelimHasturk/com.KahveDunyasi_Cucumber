package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ReusableMethods {


    public static void clickOnPage(String pageName) throws InterruptedException {
        Thread.sleep(3000);
        List<MobileElement> pages = Driver.getAppiumDriver().findElementsByClassName("android.widget.TextView");
        for (MobileElement page : pages) {
            if (page.getText().equals(pageName)) {
                page.click();
                break; // sayfayi buldugunda looptan cikmasi icin
            } else {
                scrollWithUiScrollable(pageName);
                break;
            }
        }
    }

    //ikinci alternatif bir method
    public static void clickOnPage1(String pageName) throws InterruptedException {
        Thread.sleep(4000);
        List<MobileElement> pages = Driver.getAppiumDriver().findElementsByXPath("//android.widget.TextView[@text='" + pageName + "']");
        if (pages.size() > 0) {
            pages.get(0).click();
        } else scrollWithUiScrollable(pageName);
    }


    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver driver = (AndroidDriver) Driver.getAppiumDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))");
        driver.findElementByXPath("//*[@text='" + elementText + "']").click();

    }

    public static void longPressOnElement(MobileElement mobileElement) {
        TouchAction touchAction = new TouchAction(Driver.getAppiumDriver());
        touchAction.longPress(ElementOption.element(mobileElement)).release().perform();
    }

    public static void clickOnPageIOS(String text) {
        List<MobileElement> pages = Driver.getAppiumDriver().findElementsByXPath("//XCUIElementTypeStaticText[@name='" + text + "']");
        if (pages.get(0).isDisplayed()) {
            pages.get(0).click();
        } else {
            scrollAndClickOnIOS(text);
        }


    }

    public static void scrollAndClickOnIOS(String text) {
        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        scrollObject.put("value", text);
        Driver.getAppiumDriver().executeScript("mobile: scroll", scrollObject);

        Driver.getAppiumDriver().findElementByXPath("//XCUIElementTypeStaticText[@name='" + text + "']").click();
    }

    public static void wait(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getAppiumDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public static void touchAction(int a,int b,int c,int d) {

        TouchAction action = new TouchAction<>(Driver.getAppiumDriver());
        action.press(PointOption.point(a, b))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(c, d)).release().perform();
    }
    public static void touchActionClick(int a,int b) {

        TouchAction action = new TouchAction<>(Driver.getAppiumDriver());
        action.press(PointOption.point(a, b))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
              .release().perform();
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getAppiumDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
