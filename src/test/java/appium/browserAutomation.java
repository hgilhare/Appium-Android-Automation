package appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class browserAutomation {
    @Test
    public void appium_browserAutomation() throws MalformedURLException {
        //command for chrome driver version compatibility- Appium --allow-insecure chromedriver_autodownload
        //for android 13 appactivity and apppackage - com.android.chrome/com.google.android.apps.chrome.Main
        //for element inspect - chrome://inspect/#devices
        UiAutomator2Options options= new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setPlatformVersion("9.0");
        options.withBrowserName("chrome");
        URL url= new URL("http://127.0.0.1:4723/");
        AndroidDriver driver=new AndroidDriver(url,options);
        driver.get("https://www.tartanhq.com/");

    }
}
