package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class radiobtnANDcheckbox {


    @Test(priority = 2, description = "radio button and checkbox")
    public void appium_radiobtn() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:platformVersion", "9.0");
        caps.setCapability("appium:appPackage", "io.appium.android.apis");
        caps.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
        caps.setCapability("appium:automationName", "UiAutomator2");

        URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
        AndroidDriver driver = new AndroidDriver(url, caps);
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Controls\"]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Light Theme\"]")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("Himanshu");
        Thread.sleep(2000);
        driver.findElement(By.id("io.appium.android.apis:id/check1")).click();
        driver.findElement(By.id("io.appium.android.apis:id/check2")).click();
        driver.findElement(By.id("io.appium.android.apis:id/radio1")).click();
        driver.findElement(By.id("io.appium.android.apis:id/radio2")).click();

        Thread.sleep(3000);

        driver.quit();
    }
}
