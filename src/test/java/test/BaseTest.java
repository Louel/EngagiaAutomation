package test;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;
import test.vaofTest.vaofTestAuto;

public class BaseTest {

    public WebDriverWait wait;
    public AppiumDriver driver;


    //    public void setup(String deviceName, String platformVersion) throws MalformedURLException
//    {
//        System.out.println(deviceName);
//        switch (deviceName) {
//            case "mobile":
//                System.out.println("Application is opening... ");
//                DesiredCapabilities capabilities = new DesiredCapabilities();
////                capabilities.setCapability("deviceName","Samsung Galaxy J1 (2016)");
//                capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
////                capabilities.setCapability("platformVersion", "5.1.1");
//                capabilities.setCapability("appPackage", "com.engagia.android");
////                capabilities.setCapability("appActivity","com.engagia.android.activities.MainActivity");
//                capabilities.setCapability("appActivity","com.engagia.android.activities.LoginActivity");
//                capabilities.setCapability("noSign", true);
//                capabilities.setCapability(FULL_RESET, false);
//                capabilities.setCapability(NO_RESET, true);
//                driver = new AppiumDriver(new URL("http://192.168.1.33:4723/wd/hub"), capabilities);
//                if(deviceName.equals("4200f378ce98c200"))
//                {
//                    capabilities.setCapability("udid", "4200f378ce98c200");
//                    driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4730/wd/hub"), capabilities);
//                }else if(deviceName.equals("QFJ9X18605G00840"))
//                {
//                    capabilities.setCapability("udid", "QFJ9X18605G00840");
//                    driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4731/wd/hub"), capabilities);
//                }
//                System.out.println("mobile will launch");
//                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//                break;
//            default:
//                System.out.println("Incorrect Platform...");
//                break;
//        }
//    }

    @BeforeMethod
    @Parameters({"deviceName", "platformVersion"})
    public void setUp(String deviceName, String platformVersion) throws MalformedURLException {

        System.out.println("TestNG Before");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("appPackage", "com.engagia.android");
        capabilities.setCapability("appActivity", "com.engagia.android.activities.LoginActivity");
        capabilities.setCapability("noSign", true);
        capabilities.setCapability(FULL_RESET, false);
        capabilities.setCapability(NO_RESET, true);

//        driver = new AppiumDriver(new URL("http://192.168.1.33:4444/wd/hub"), capabilities);
//        test.ThreadLocalDriver.setTLDriver(new AndroidDriver (new URL("http://127.0.0.1:4444/wd/hub"),capabilities));

        URL url = new URL("http://192.168.1.33:4444/wd/hub");

        ThreadLocalDriver.setTLDriver(new AndroidDriver(url , capabilities));
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 20);
        driver = new AppiumDriver(new URL("http://192.168.1.33:4444/wd/hub"), capabilities);

//        driver = new AppiumDriver(url , capabilities);
//        ThreadLocalDriver.setTLDriver((AndroidDriver) new AppiumDriver(url , capabilities));
//        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 20);

//        ThreadLocalDriver.setTLDriver((AndroidDriver) (driver = new AndroidDriver<MobileElement>(url , capabilities)));
//        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 20);
//        ThreadLocalDriver.setTLDriver((AndroidDriver) (driver = new AndroidDriver(url , capabilities)));
//        driver = new AppiumDriver(url  , capabilities);
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);



    }
//    @AfterMethod
//    public synchronized void teardown(){
//        ThreadLocalDriver.getTLDriver().quit();
//    }
}
