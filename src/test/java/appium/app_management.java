package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class app_management {
    @Test
    public void appium_app_management() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:platformVersion", "9.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        URL url= new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver= new AndroidDriver(url,caps);
        driver.installApp("C:\\Users\\lenovo\\IdeaProjects\\appium-mobile-automation\\src\\test\\java\\apkfiles\\ApiDemos-debug.apk");
        Assert.assertTrue(driver.isAppInstalled("io.appium.android.apis"));
        driver.activateApp("io.appium.android.apis");
        driver.removeApp("io.appium.android.apis");


    }
}
