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

public class PLAN {

    AppiumDriver driver;
    String search = "Plan";
    /**
     * 1. Sales tab         = /android.support.v7.app.ActionBar.Tab[1]
     * 2. Schedule          = /android.support.v7.app.ActionBar.Tab[2]
     * 3. Subordinate Plan  = /android.support.v7.app.ActionBar.Tab[3]
     *
     * */
    String tabDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout" +
            "/android.widget.HorizontalScrollView/android.widget.LinearLayout";
    String timeFrameDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView";

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Samsung Galaxy J1 (2016)");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("appPackage", "com.engagia.android");
        capabilities.setCapability("appActivity","com.engagia.android.activities.LoginActivity");
        capabilities.setCapability("noSign", true);
        capabilities.setCapability(FULL_RESET, false);
        capabilities.setCapability(NO_RESET, true);
        //Papalitan un Ip depende sa pc
        driver = new AppiumDriver(new URL("http://192.168.0.167:4723/wd/hub"), capabilities);
    }
    @Test
    public void testPlan(){
        SearchPlan();
        planTransaction();
    }

    //Functions
    public void SearchPlan(){
        //click Hamburger Menu
        MobileElement HamburgerBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
        HamburgerBtn.click();
        System.out.println("Seaching Note and tasks");
        //search Note and Tasks
        MobileElement searchField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'edit_text_search')]");
        searchField.sendKeys(search);
        //click search result
        MobileElement clckRes = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text_title')]");
        clckRes.click();
    }
    private void planTransaction(){
        //Sales tab start here
        salesTab();
        //Insert swipe down here
        swipeDown();
        swipeDown();
        swipeDown();
        swipeUp();
        swipeUp();
        swipeUp();
        //Schedule tab start here
        scheduleTab();
        //Subordinate tab start here
        subordinatePlan();
    }
    private void salesTab(){
        //Sales tab
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement selectSales = (MobileElement) driver.findElementByXPath(tabDrctry+"/android.support.v7.app.ActionBar.Tab[1]");
        selectSales.click();
        //Sales Timeframe
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement salesTimeFrame = (MobileElement) driver.findElementById("com.engagia.android:id/plan_sales_timeframe_spinner");
        salesTimeFrame.click();
        //Click Today
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement today = (MobileElement) driver.findElementByXPath(timeFrameDrctry+"/android.widget.TextView[2]");
        today.click();
    }
    private void scheduleTab(){
        //Schedule tab
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement selectSchedule = (MobileElement) driver.findElementByXPath(tabDrctry+"/android.support.v7.app.ActionBar.Tab[2]");
        selectSchedule.click();
        //Schedule Timeframe
        MobileElement schedTimeFrame = (MobileElement) driver.findElementById("com.engagia.android:id/plan_schedule_time_frame_spinner");
        schedTimeFrame.click();
        //Click this week
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement thisWeek = (MobileElement) driver.findElementByXPath(timeFrameDrctry+"/android.widget.TextView[3]");
        thisWeek.click();
        //Search
        MobileElement searchBtn = (MobileElement) driver.findElementByAccessibilityId("Search");
        searchBtn.click();
        MobileElement searchField = (MobileElement) driver.findElementById("android:id/search_src_text");
        searchField.sendKeys("alfamart");
        driver.hideKeyboard();

    }
    private void subordinatePlan(){
        //Schedule tab
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement selectSchedule = (MobileElement) driver.findElementByXPath(tabDrctry+"/android.support.v7.app.ActionBar.Tab[3]");
        selectSchedule.click();
        //Timeframe
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement subordinateTimeFrame = (MobileElement) driver.findElementById("com.engagia.android:id/plan_subordinate_time_frame_spinner");
        subordinateTimeFrame.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement selectMonth = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout" +
                "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
        selectMonth.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement subordinate = (MobileElement) driver.findElementById("com.engagia.android:id/plan_subordinate_name_spinner");
        subordinate.click();
        MobileElement selectTeam = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout" +
                "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
        selectTeam.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/tv_subordinate_sales_label");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            swipeDown();
            swipeDown();
            swipeDown();
            swipeDown();
            swipeDown();
            swipeDown();
            swipeDown();
            swipeDown();
            swipeUpFast();
        }
    }
    public void swipeDown(){
//        for (int z = 0; z<3; z++) {
            Dimension dim = driver.manage().window().getSize();
            int width = dim.getWidth();
            int height = dim.getHeight();
            //Para nasa gilid un pag scroll walang tatamaan textfield
            int x = (int) (width * 0.15);
            int y1 = (int) (height * 0.97);
            int y2 = (int) (height * 0.40);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.longPress(new PointOption().withCoordinates(x, y1)).moveTo(new PointOption().withCoordinates(x, y2)).release().perform();
//        }
    }

    public void swipeUp(){
        Dimension dim = driver.manage().window().getSize();
        int width = dim.getWidth();
        int height = dim.getHeight();
        //Para nasa gilid un pag scroll walang tatamaan textfield
        int x = (int) (width * 0.99);
        int y1 = (int) (height * 0.40);
        int y2 = (int) (height * 0.99);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(new PointOption().withCoordinates(x, y1)).moveTo(new PointOption().withCoordinates(x, y2)).release().perform();

    }
    public void swipeUpFast(){
        Dimension dim = driver.manage().window().getSize();
        int width = dim.getWidth();
        int height = dim.getHeight();
        //Para nasa gilid un pag scroll walang tatamaan textfield
        int x = (int) (width * 0.15);
        int y1 = (int) (height * 0.45);
        int y2 = (int) (height * 0.99);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(new PointOption().withCoordinates(x, y1)).moveTo(new PointOption().withCoordinates(x, y2)).release().perform();

    }
}
