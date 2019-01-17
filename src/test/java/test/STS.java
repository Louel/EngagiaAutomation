package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class STS {

    AppiumDriver driver;
    String search = "Stock Transfer Summary";
    String pendingProduct = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout";
    // AQ1PC /android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView
    // AQ1BOX /android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView
    String  actualQntyDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout";

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("deviceName","Samsung Galaxy J1 (2016)");
        capabilities.setCapability("deviceName","Lenovo A7010a48");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("platformVersion", "5.1");
        capabilities.setCapability("appPackage", "com.engagia.android");
        capabilities.setCapability("appActivity","com.engagia.android.activities.LoginActivity");
        capabilities.setCapability("noSign", true);
        capabilities.setCapability(FULL_RESET, false);
        capabilities.setCapability(NO_RESET, true);
        //Papalitan un Ip depende sa pc
        driver = new AppiumDriver(new URL("http://192.168.0.167:4723/wd/hub"), capabilities);
    }

    @Test
    public void testIC(){
        SearchSTS();
        transaction();
    }


    //Functions

    public void transaction(){
        for(int z = 1; z<=3; z++) {
            if(z==1) {
                MobileElement pendingProd = (MobileElement) driver.findElementByXPath(pendingProduct+"/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView");
                TouchAction touchAction = new TouchAction(driver);
                touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(pendingProd)).withDuration(Duration.ofMillis(1000))).release().perform();
                MobileElement viewRequest = (MobileElement) driver.findElementById("com.engagia.android:id/title");
                viewRequest.click();
                swipeRight();
            }
            else if(z==2){
                MobileElement pendingProd = (MobileElement) driver.findElementByXPath(pendingProduct+"/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView");
                TouchAction touchAction = new TouchAction(driver);
                touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(pendingProd)).withDuration(Duration.ofMillis(1000))).release().perform();
                MobileElement viewRequest = (MobileElement) driver.findElementById("com.engagia.android:id/title");
                viewRequest.click();
                swipeRight();
            }
            else if(z==3){
                MobileElement pendingProd = (MobileElement) driver.findElementByXPath(pendingProduct+"/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView");
                TouchAction touchAction = new TouchAction(driver);
                touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(pendingProd)).withDuration(Duration.ofMillis(1000))).release().perform();
                MobileElement viewRequest = (MobileElement) driver.findElementById("com.engagia.android:id/title");
                viewRequest.click();
                swipeRight();
            }

//        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
//        el3.click();
            //PC PROD 1
            MobileElement actualQuanPC1 = (MobileElement) driver.findElementByXPath(actualQntyDrctry + "/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
            actualQuanPC1.click();
            MobileElement clckNO9 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_9");
            clckNO9.click();
            MobileElement clckNO8 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_8");
            clckNO8.click();
            MobileElement calcuClckOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
            calcuClckOk.click();
            //BOX PROD 1
            MobileElement actualQuanBox1 = (MobileElement) driver.findElementByXPath(actualQntyDrctry + "/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView");
            actualQuanBox1.click();
            clckNO9.click();
            clckNO8.click();
            calcuClckOk.click();
            //PC PROD 2
            MobileElement actualQuanPC2 = (MobileElement) driver.findElementByXPath(actualQntyDrctry + "/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
            actualQuanPC2.click();
            clckNO9.click();
            clckNO8.click();
            calcuClckOk.click();
            //BOX PROD 2
            MobileElement actualQuanBox2 = (MobileElement) driver.findElementByXPath(actualQntyDrctry + "/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView");
            actualQuanBox2.click();
            clckNO9.click();
            clckNO8.click();
            calcuClckOk.click();

            MobileElement approveBtn = (MobileElement) driver.findElementById("com.engagia.android:id/view_request_approved_menu");
            approveBtn.click();
            MobileElement clckConfirm = (MobileElement) driver.findElementById("android:id/button1");
            clckConfirm.click();
            MobileElement clckOkBtn = (MobileElement) driver.findElementById("android:id/button1");
            clckOkBtn.click();
            System.out.println("Next Product" + z);
        }
    }
    public void swipeRight(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Dimension dim = driver.manage().window().getSize();
            int width = dim.getWidth();
            //Para nasa gilid un pag scroll walang tatamaan textfield
            int x1 = (int) (width * 0.80);
            int x2 = (int) (width * 0.35);
            TouchAction touchAction = new TouchAction(driver);
            //try this
            touchAction.longPress(new PointOption().withCoordinates(x1, 700)).moveTo(new PointOption().withCoordinates(x2, 700)).release().perform();
        }
    }
    public void SearchSTS(){
        //click Hamburger Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement HamburgerBtn = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
        HamburgerBtn.click();
        //search str
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/edit_text_search");
        searchField.sendKeys(search);
        //click search result
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckRes = (MobileElement) driver.findElementByAccessibilityId("Stock Transfer Summary");
        clckRes.click();
    }
}
