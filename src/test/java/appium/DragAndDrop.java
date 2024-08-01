package appium;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;


import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DragAndDrop {
    @Test(priority = 4, description = "drag and drop using touch action")
    public void appium_draganddrop() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:platformVersion", "9.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appPackage", "io.appium.android.apis");
        caps.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();
        TouchAction action = new TouchAction(driver);
        WebElement src = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement target = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(src))).moveTo(ElementOption.element(target)).release().perform();
        Thread.sleep(3000);
        driver.quit();

    }


}
