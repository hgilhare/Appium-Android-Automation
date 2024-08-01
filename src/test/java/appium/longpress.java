package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class longpress {
    @Test
    public void appium_longpress() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:platformVersion", "9.0");
        caps.setCapability("appium:appPackage","com.google.android.dialer");
        caps.setCapability("appium:appActivity","com.google.android.apps.dialer.main.GoogleMainActivity");
        caps.setCapability("appium:automationName", "UiAutomator2");
        URL url= URI.create("http://127.0.0.1:4723/wd/hub").toURL();
        AndroidDriver driver= new AndroidDriver(url,caps);
        Thread.sleep(1000);
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
        WebElement delete= driver.findElement(By.id("com.google.android.dialer:id/deleteButton"));
        Point location=delete.getLocation();
        PointerInput finger= new PointerInput(PointerInput.Kind.TOUCH,"finger");

        Sequence seq= new Sequence(finger,1);
        seq.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),location.x, location.y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofSeconds(8),PointerInput.Origin.viewport(),location.x,location.y))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singleton(seq));
        driver.quit();





    }
}
