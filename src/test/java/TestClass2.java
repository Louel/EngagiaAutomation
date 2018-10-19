
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;

public class TestClass2 {

    public static final String USERNAME = "qa5user1@louel.com";
    public static final String ACCESS_KEY = "Password1!";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    public static void main(String[] args) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Lenovo A7010a48");
        capabilities.setCapability("platformVersion", "5.1");
        capabilities.setCapability("app", "http://saucelabs.com/example_files/ContactManager.apk");
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("appiumVersion", "1.4.3");

       // WebDriver driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        WebDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        MobileElement userField = (MobileElement) driver.findElements(By.id("com.engagia.android:id/text_username"));
        //userField.sendKeys(validUser);
        userField.sendKeys("qa5user1@louel.com");

        MobileElement passField = (MobileElement) driver.findElements(By.id("com.engagia.android:id/text_password"));
        //passField.sendKeys(validPass);
        passField.sendKeys("Password1!");

        MobileElement agreeBtn  = (MobileElement) driver.findElements(By.id("com.engagia.android:id/chk_agreement"));
        agreeBtn.click();

        MobileElement loginBtn  = (MobileElement) driver.findElements(By.id("com.engagia.android:id/btn_login"));
        loginBtn.click();


        driver.quit();
    }
}