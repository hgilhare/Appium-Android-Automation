package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class drawing {
    @Test
    public void appium_drawing() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:platformVersion", "9.0");
        caps.setCapability("appium:appPackage","com.saucelabs.mydemoapp.rn");
        caps.setCapability("appium:appActivity","com.saucelabs.mydemoapp.rn.MainActivity");
        caps.setCapability("appium:automationName", "UiAutomator2");
        URL url= URI.create("http://127.0.0.1:4723/wd/hub").toURL();
        AndroidDriver driver= new AndroidDriver(url,caps);

        driver.findElement(By.className("android.widget.ImageView")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item drawing\"]")).click();
        Thread.sleep(2000);
        WebElement board= driver.findElement(By.xpath("//android.view.View[@resource-id=\"signature-pad\"]/android.view.View[1]/android.widget.Image[3]"));

        Dimension size= board.getSize();
        Point location=board.getLocation();

        int startx= location.x+(size.width)/2;
        int starty= location.y+100;
        int endx=startx;
        int endy=starty+ (size.height/2);

        PointerInput finger= new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence seq= new Sequence(finger,1);
        seq.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),startx,starty));
                seq.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                        seq.addAction(new Pause(finger,Duration.ofMillis(1200)));
                                seq.addAction(finger.createPointerMove(Duration.ofSeconds(2),PointerInput.Origin.viewport(),endx,endy));
                                        seq.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

                                        driver.perform(Collections.singleton(seq));
    }
}
