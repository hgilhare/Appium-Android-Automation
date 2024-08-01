package appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class scrolldown {
    @Test(priority = 3, description = "scroll down till switches")
    public void appium_scrolldown() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:platformVersion", "9.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appPackage", "io.appium.android.apis");
        caps.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
        URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
        AndroidDriver driver = new AndroidDriver(url, caps);
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
        Thread.sleep(1000);
        String MobElementToScroll = "Switches";
        WebElement SwitchElement = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + MobElementToScroll + "\"))"));
        SwitchElement.click();
        WebElement switchBTN = driver.findElement(By.id("io.appium.android.apis:id/monitored_switch"));
        switchBTN.click();
        Assert.assertTrue(switchBTN.isEnabled());
    }
}
