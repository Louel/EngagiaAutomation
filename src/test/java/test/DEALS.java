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
import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;

public class DEALS {

    AppiumDriver driver;
    String search = "Dea";
    String branch = "ALFAMART MARIKINA 5";
    String [] deal = {"Deal 1","Deal 2","Deal 3","Deal 4","Deal 5"};
    String dealDrctry = "//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout" +
            "/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout";
    String deal1 = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout" +
            "/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]" +
            "/android.widget.LinearLayout/android.widget.TextView";
    String deal2 = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout" +
            "/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]" +
            "/android.widget.LinearLayout/android.widget.TextView";
    String deal3 ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout" +
            "/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]" +
            "/android.widget.LinearLayout/android.widget.TextView";
    String deal4 ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout" +
            "/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]" +
            "/android.widget.LinearLayout/android.widget.TextView";
    String deal5 ="hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout" +
            "/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]" +
            "/android.widget.LinearLayout/android.widget.TextView";
    String branchListDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout" +
            "/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView";


    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Samsung Galaxy J1 (2016)");
//        capabilities.setCapability("deviceName","MyPhone UNO");
//        capabilities.setCapability("deviceName","Moto C Plus");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("platformVersion", "5.1.1");
//        capabilities.setCapability("platformVersion", "6.0.1");
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
    public void testDeals(){
         dealsLogInToVisit();
    }
    //Cases
    public void Case40(){
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        MobileElement searchBar = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view') and @text='Search deals...']");
        searchBar.sendKeys(deal[rand(deal.length-1)]);
        //Click Search button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button') and @index='1']");
        searchBtn.click();
        //Click Result
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        MobileElement resultDeal = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='0']");
        resultDeal.click();
        driver.navigate().back();
    }
    public void Case41(){
        SearchDeals();
        //Click
        for (int z=1; z<=1; z++) {
            for (int x = 1; x <= 5; x++) {
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                if(x==1){
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    MobileElement clckDeal1 = (MobileElement) driver.findElementByXPath(deal1);
                    clckDeal1.click();
                    String formText = clckDeal1.getText();
                    System.out.println(formText);
                }
                else if (x==2){
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    MobileElement clckDeal2 = (MobileElement) driver.findElementByXPath(deal2);
                    clckDeal2.click();
                    String formText = clckDeal2.getText();
                    System.out.println(formText);
                }
                else if (x==3){
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    MobileElement clckDeal3 = (MobileElement) driver.findElementByXPath(deal3);
                    clckDeal3.click();
                    String formText = clckDeal3.getText();
                    System.out.println(formText);
                }
                else if (x==4){
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    MobileElement clckDeal4 = (MobileElement) driver.findElementByXPath(deal4);
                    clckDeal4.click();
                    String formText = clckDeal4.getText();
                    System.out.println(formText);
                }
                else if (x==5){
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    MobileElement clckDeal5 = (MobileElement) driver.findElementByXPath(deal5);
                    clckDeal5.click();
                    String formText = clckDeal5.getText();
                    System.out.println(formText);
                }
                if (z==1) {
                    //Click jump to vaof
                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                    MobileElement jumpVaof = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'btn_jump_vaof') and @index='0']");
                    jumpVaof.click();
                    System.out.println("Go to Vaof");
                }
/**
 * Para mag jump to baof
 */
//                else if (z==2){
//                    //Click jump to baof
//                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//                    MobileElement jumpBaof = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'btn_jump_baof') and @index='1']");
//                    jumpBaof.click();
//                    System.out.println("Go to Baof");
//                }
                System.out.println("Deals " + x + " done");
                //Enter minimum quantity
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                MobileElement minimumQuan = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'txt_multiplier') and @text='Minimum quantity of deals to apply']");
                minimumQuan.sendKeys("1");
                //ClickOk
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                MobileElement clckOK = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
                clckOK.click();
                driver.navigate().back();
                SearchDeals();
            }
        }
    }
    //Functions
    public void SearchDeals(){
        //click Hamburger Menu
        MobileElement HamburgerBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
        HamburgerBtn.click();
        //search van
        MobileElement searchField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'edit_text_search')]");
        searchField.sendKeys(search);
        //click search result
        MobileElement clckRes = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text_title')]");
        clckRes.click();
    }
    public void dealsLogInToVisit(){
        for (int x = 1; x <=1; x++) {
            //Click on Drawer
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement drawerOpen = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
            drawerOpen.click();
            //Click on Arrow down btn
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement clckArrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/image_visit_dropdown");
            clckArrowDown.click();
            //branch list
            //search branch here
            searchBranch();
            //Click on branch depends on index or int of the loop
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            MobileElement clckOnBranch = (MobileElement) driver.findElementByXPath(branchListDrctry + "/android.widget.RelativeLayout[" + x + "]");
            clckOnBranch.click();
            System.out.println(x);
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            MobileElement cntBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
//            cntBtn.click();
            //click on Ok
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
            okBtn.click();
            /**
             *
             * I N S E R T Functions and Cases H E R E
             *
             */
            SearchDeals();
            Case40();
            Case41();
            //Click on Drawer to logout to visit
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement drawerOpen2 = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
            drawerOpen2.click();
            swipeUp();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            clckArrowDown.click();
            //Log out
            MobileElement logoutBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_visit_logout");
            logoutBtn.click();
        }
    }
    public void searchBranch(){
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        MobileElement searchBar = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_search') and @text='Search branch']");
        searchBar.sendKeys(branch);
        driver.hideKeyboard();
    }

    private void swipeUp(){
        Dimension dim = driver.manage().window().getSize();
        int width = dim.getWidth();
        int height = dim.getHeight();
        int x = (int) (width * 0.10);
        int y1 = (int) (height * 0.35);
        int y2 = (int) (height * 0.75);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'edit_text_search')]");
        boolean isDisplayed2 = element1.isDisplayed();
        if (isDisplayed2) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.longPress(new PointOption().withCoordinates(x, y1)).moveTo(new PointOption().withCoordinates(x, y2)).release().perform();
        }
    }
    private static int rand(int bound) {
        return (int) (Math.random() * bound);
    }


}
