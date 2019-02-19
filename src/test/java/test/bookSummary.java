package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class bookSummary extends BAOF{
    AppiumDriver driver;

    String search = "Booking Summary";
    String accountNameDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout";

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Samsung Galaxy J1 (2016)");
//        capabilities.setCapability("deviceName","HUAWEI");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("appPackage", "com.engagia.android");
        capabilities.setCapability("appActivity","com.engagia.android.activities.LoginActivity");
        capabilities.setCapability("noSign", true);
        capabilities.setCapability(FULL_RESET, false);
        capabilities.setCapability(NO_RESET, true);
        //Papalitan un Ip depende sa pc
        driver = new AppiumDriver(new URL("http://192.168.0.167:4723/wd/hub"), capabilities);
    }
    @Test
    public void testBAOF(){
        SearchBAOF();
        Case1();
    }

    //Cases

    //Check "Date from/Date to"
    public void Case1(){
        System.out.println("Testing Case 1");
        selectDate();
        System.out.println("Case 1 Done");
    }
    //Check "Total with tax"
    public void Case2(){
        System.out.println("Testing Case 2");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement totalWithTax = (MobileElement) driver.findElementById("com.engagia.android:id/txt_total_with_tax");
        String TotalWithTaxValue = totalWithTax.getText();
        System.out.println("Total with tax = "+TotalWithTaxValue);
        System.out.println("Case 2 Done");
    }
    //Check table view"Account Name"
    public void Case3(){
        System.out.println("Testing Case 3");
        for(int z=1; z <=2; z++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement accountName = (MobileElement) driver.findElementByXPath(accountNameDrctry + "/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView");
            TouchAction touchAction = new TouchAction(driver);
            touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(accountName)).withDuration(Duration.ofMillis(1200))).release().perform();
            MobileElement reOrder = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]");
            reOrder.click();
            MobileElement engagiaMessage = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
            boolean engagiaMessageDisplayed = engagiaMessage.isDisplayed();
            if (engagiaMessageDisplayed) {
                MobileElement message = (MobileElement) driver.findElementById("android:id/message");
                String messageText = message.getText();
                System.out.println("A prompt appear with message: " + messageText);
                if(z==1) {
                    MobileElement noBtn = (MobileElement) driver.findElementById("android:id/button2");
                    noBtn.click();
                }else if(z==2){
                    MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
                    yesBtn.click();
                }
            }
        }
        System.out.println("Case 3 Done");
    }
    //Check table view "Account Code"
    public void Case4(){

    }

    //Functions
    public void SearchBAOF(){
        //click Hamburger Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement HamburgerBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
        HamburgerBtn.click();
        System.out.println("Seaching test.BAOF");
        //search test.BAOF
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/edit_text_search");
        searchField.sendKeys(search);
        //click search result
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckRes = (MobileElement) driver.findElementByAccessibilityId("Booking Summary");
        clckRes.click();
    }
    public void selectDate(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement dateFrom_dateTo = (MobileElement) driver.findElementById("com.engagia.android:id/txt_date_from_date_to");
        dateFrom_dateTo.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement dateFrom = (MobileElement) driver.findElementByAccessibilityId("01 February 2019");
        dateFrom.click();
        MobileElement dateFromOkBtn = (MobileElement) driver.findElementById("android:id/button1");
        dateFromOkBtn.click();
        MobileElement dateTo = (MobileElement) driver.findElementByAccessibilityId("28 February 2019");
        dateTo.click();
        MobileElement dateToOkBtn = (MobileElement) driver.findElementById("android:id/button1");
        dateToOkBtn.click();
    }

}
