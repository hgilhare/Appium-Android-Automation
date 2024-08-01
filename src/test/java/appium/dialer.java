package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class dialer {


    @Test(priority = 1,description = "dialer automation")
    public void appium_dialer() throws InterruptedException, MalformedURLException {

        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("appium:deviceName","emulator-5554");
        caps.setCapability("appium:platformVersion","9.0");
        caps.setCapability("appium:appPackage","com.google.android.dialer");
        caps.setCapability("appium:appActivity","com.google.android.apps.dialer.main.GoogleMainActivity");
        caps.setCapability("appium:automationName","UiAutomator2");



        URL url= URI.create("http://127.0.0.1:4723/wd/hub").toURL();
        AndroidDriver driver= new AndroidDriver(url,caps);
        Thread.sleep(3000);
        driver.findElement(By.id("com.google.android.dialer:id/fab")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("com.google.android.dialer:id/eight")).click();
        driver.findElement(By.id("com.google.android.dialer:id/seven")).click();
        driver.findElement(By.id("com.google.android.dialer:id/one")).click();
        driver.findElement(By.id("com.google.android.dialer:id/eight")).click();
        driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
        driver.findElement(By.id("com.google.android.dialer:id/one")).click();
        driver.findElement(By.id("com.google.android.dialer:id/three")).click();
        driver.findElement(By.id("com.google.android.dialer:id/nine")).click();
        driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
        driver.findElement(By.id("com.google.android.dialer:id/four")).click();
        driver.findElement(By.id("com.google.android.dialer:id/dialpad_floating_action_button")).click();
        Thread.sleep(3000);



        driver.quit();
    }

}
