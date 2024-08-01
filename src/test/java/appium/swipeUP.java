package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;

public class swipeUP {
    @Test
    public void appium_swipeup() throws InterruptedException, MalformedURLException {
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
        Dimension size=driver.manage().window().getSize();
        int startx= size.getWidth()/2;
        int starty= size.getHeight()/2;
        int endx=startx;
        int endy= (int) (starty*0.25);
        PointerInput finger= new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence seq= new Sequence(finger,1);
        seq.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startx,starty))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger,Duration.ofSeconds(1)))
                .addAction(finger.createPointerMove(Duration.ofMillis(200),PointerInput.Origin.viewport(),endx,endy))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singleton(seq));
        driver.quit();
    }
}
