package appium;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.remote.MobilePlatform;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class calculator {

    @Test(priority = 4,description = "calculator automation")
    public void appium_calculator() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:platformVersion", "9.0");
        caps.setCapability("appium:appPackage","com.android.calculator2");
        caps.setCapability("appium:appActivity","com.android.calculator2.Calculator");
        caps.setCapability("appium:automationName","UiAutomator2");
        URL url= new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url,caps);
        Thread.sleep(3000);
        WebElement five= driver.findElement(By.id("com.android.calculator2:id/digit_5"));
        five.click();
        WebElement multi=driver.findElement(By.id("com.android.calculator2:id/op_mul"));
        multi.click();
        WebElement svn= driver.findElement(By.id("com.android.calculator2:id/digit_7"));
        svn.click();
        WebElement eql=driver.findElement(By.id("com.android.calculator2:id/eq"));
        eql.click();
        Thread.sleep(2000);

        driver.quit();
    }


}
