package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;

public class OP {

    AppiumDriver driver;
    String search = "Operational Process";
    String checkBoxDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView";
    String jumpToDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView";

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Samsung Galaxy J1 (2016)");
//        capabilities.setCapability("deviceName","HUAWEI");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("platformVersion", "5.1.1");
//        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("appPackage", "com.engagia.android");
        capabilities.setCapability("appActivity","com.engagia.android.activities.LoginActivity");
        capabilities.setCapability("noSign", true);
        capabilities.setCapability(FULL_RESET, false);
        capabilities.setCapability(NO_RESET, true);
        //Papalitan un Ip depende sa pc
        driver = new AppiumDriver(new URL("http://192.168.0.167:4723/wd/hub"), capabilities);
    }

    @Test
    public void testOP(){
        SearchOP();
//        Case2();
//        Case3(); FORCE CLOSE FROM ACCOUNTS TO ANY FUNCTIONS JUMP TO
        Case4();
    }
    //Cases
    //Check Accessing Operational Process
    private void Case1(){

    }
    //Check Checkbox Functionality
    private void Case2(){
        for(int z=1; z<=2; z++) {
            for (int x = 1; x <= 2; x++) {
                MobileElement checkBox = (MobileElement) driver.findElementByXPath(checkBoxDrctry + "/android.widget.LinearLayout[" + x + "]/android.widget.LinearLayout[1]/android.widget.CheckBox");
                checkBox.click();
            }
        }
    }
    //Check Jump to Accounts Functionality (FORCE CLOSE ACCOUNT TO ANY FUNCTIONS)
    private void Case3(){

        MobileElement jumpToAccounts = (MobileElement) driver.findElementByXPath(jumpToDrctry+"/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView");
        jumpToAccounts.click();
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/custom_table_next_pagination");
        boolean element1isDisplayed = element1.isDisplayed();
        if(element1isDisplayed) {
            driver.navigate();
        }
    }
    //Check Jump to Account Receivables
    private void Case4(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement jumpToAR = (MobileElement) driver.findElementByXPath(jumpToDrctry+"/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView");
        jumpToAR.click();
//        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView");
//        el1.click();
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        boolean element1isDisplayed = element1.isDisplayed();
        if(element1isDisplayed) {
            driver.navigate().back();
        }

    }


    //Functions
    private void SearchOP(){
        //click Hamburger Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement HamburgerBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
        HamburgerBtn.click();
        System.out.println("Seaching Operational Process");
        //search test.BAOF
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/edit_text_search");
        searchField.sendKeys(search);
        //click search result
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckRes = (MobileElement) driver.findElementByAccessibilityId("Operational Process");
        clckRes.click();
    }
    public void swipeDown(){
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
//        boolean isDisplayed1 = element1.isDisplayed();
//        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Dimension dim = driver.manage().window().getSize();
            int width = dim.getWidth();
            //Para nasa gilid un pag scroll walang tatamaan textfield
            int x = (int) (width * 0.99);
            TouchAction touchAction = new TouchAction(driver);
            //try this
            touchAction.longPress(new PointOption().withCoordinates(x, 600)).moveTo(new PointOption().withCoordinates(x, 200)).release().perform();
//        }

    }


}
