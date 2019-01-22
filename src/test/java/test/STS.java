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


/**
 * IMPORTANT NOTE BEFORE RUNNING THIS AUTOMATION
 * MAKE SURE STR AND STS IS SET UP BEFORE STARTING THE AUTOMATION
 * SETUP:
 * 1.ATLEAST 2 TRANSACTION (STR) FROM qaAuto2@engagia.com (manually set up)
 * 2.RUN STR TRANSACTION WITH qaAuto1@engagia.com(COUNTS OF TRANSACTION DEPENDS ON LOOP)
 */
public class STS {

    AppiumDriver driver;
    String search = "Stock Transfer Summary";
    String prodName = "soDa";
    String [] prodShortName = {"Fruit", "MeGA" , "roYal" };
    String [] prodItemCode = {"51232166", "51232167", "51232219", "51232143"};
    String [] prodBarcode = {"51232167", "51232168", "10182017020", "51232198"};
    String [] prodDescription = {"Candy", "Soda", "Cracker", "Milk"};
    String [] prodBrand = {"MEGA SARDINES", "Cheezy Corn Crunch", "Jack N Jill"};
    String [] prodKeyword = {"Cola", "Piattos", "Coke", "buLb"};
    String [] prodPrincipal = {"MFC", "LESLIES CORP", "RC Cola Corp.", "URC"};
    String pendingProduct = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout";
    // AQ1PC /android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView
    // AQ1BOX /android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView
    String  actualQntyDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout";
    String searchByDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout" +
            "/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout" +
            "/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView";
    String prodNameDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout" +
            "/android.widget.ScrollView/android.widget.LinearLayout";
    String uomDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView" +
            "/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout";
    //1st prod pc  /android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView
    //1st prod box /android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView
    //2nd prod pc  /android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView
    //2nd prod box /android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView
    String qtyReqRetDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView" +
            "/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout";
    String statsDtlsDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View/android.widget.FrameLayout" +
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
    public void testSTS(){
        SearchSTS();
        Case2();
        Case3();
////        Case4(); //May force close dito d ma replicate pag ginawa sa manual
        Case5();
        Case6();
        Case7();
        Case8();
        Case9();
        //SearchBy Modules 10 - 18
        Case10();
        Case11();
        Case12();
        Case13();
        Case14();
        Case15();
        Case16();
        Case17();
        Case18();
        Case19();
        Case20();
        Case21();
        Case22();
        Case23();
//        transaction();


    }

    //Cases
    //Check Accessing Stock Transfer Summary
    public void Case1(){
        System.out.println("Testing Case 1");
        SearchSTS();
        //Loop
        //Navigate Home and Relaunching Engagia step (Step 6 and 7)
        driver.launchApp();
        //Close app (Step 8)
        driver.closeApp();
        //Open Engagia Again (Step 9)
        driver.launchApp();
        System.out.println("Case 1 Done");
    }
    //Check "Search by No Filter"
    public void Case2(){
        System.out.println("Testing Case 2");
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        MobileElement srchByNoFltr = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[1]");
        srchByNoFltr.click();
        MobileElement cnclBtn = (MobileElement) driver.findElementById("android:id/button2");
        cnclBtn.click();
        arrowDown.click();
        srchByNoFltr.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        System.out.println("Case 2 Done");
    }
    //Check "Search by Status"
    public void Case3(){
        System.out.println("Testing Case 3");
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        MobileElement srchByStats = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[2]");
        srchByStats.click();
        MobileElement cnclBtn = (MobileElement) driver.findElementById("android:id/button2");
        cnclBtn.click();
        arrowDown.click();
        srchByStats.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        //Pending , Cancelled and Approved/Transferred
        MobileElement srchBar = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        srchBar.sendKeys("Pending");
        MobileElement srchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        srchBtn.click();
        srchBar.sendKeys("Cancelled");
        srchBtn.click();
        MobileElement dissmissed = (MobileElement) driver.findElementById("android:id/button2");
        dissmissed.click();
        srchBar.sendKeys("Approved");
        srchBtn.click();
//        MobileElement dissmissed = (MobileElement) driver.findElementById("android:id/button2");
        dissmissed.click();
        System.out.println("Case 3 Done");
    }
    //Check "Search by Date Requested" FORCE CLOSE
    public void Case4(){
        System.out.println("Testing Case 4");
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        MobileElement srchByDateReq = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[3]");
        srchByDateReq.click();
        MobileElement cnclBtn = (MobileElement) driver.findElementById("android:id/button2");
        cnclBtn.click();
        arrowDown.click();
        srchByDateReq.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        MobileElement srchBar = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        srchBar.click();
        //Pick Date and Cancel
        MobileElement dateFrom = (MobileElement) driver.findElementByAccessibilityId("16 January 2019");
        dateFrom.click();
        MobileElement cancelBtn = (MobileElement) driver.findElementById("android:id/button2");
        cancelBtn.click();
        //Pick Date From and Pick date to then cancel
        srchBar.click();
        dateFrom.click();
        MobileElement OkBtn = (MobileElement) driver.findElementById("android:id/button1");
        OkBtn.click();
//        MobileElement dateTo = (MobileElement) driver.findElementByAccessibilityId("18 January 2019 selected");
//        dateTo.click();
        cancelBtn.click();
        //Pick Date From and Pick Date To then ok
        srchBar.click();
        dateFrom.click();
        OkBtn.click();
//        dateTo.click();
        OkBtn.click();
        MobileElement srchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        srchBtn.click();
        System.out.println("Case 4 Done");
    }
    //Check "Search by Requested by"
    public void Case5(){
        System.out.println("Testing Case 5");
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        MobileElement srchByReqBy = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[4]");
        srchByReqBy.click();
        MobileElement cnclBtn = (MobileElement) driver.findElementById("android:id/button2");
        cnclBtn.click();
        arrowDown.click();
        srchByReqBy.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        MobileElement srchBar = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        srchBar.sendKeys("qaAuto1@engagia.com");
        MobileElement srchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        srchBtn.click();
        System.out.println("Case 5 Done");
    }
    //Check "Search by Warehouse From"
    public void Case6(){
        System.out.println("Testing Case 6");
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        MobileElement srchByWrhouseFrom = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[5]");
        srchByWrhouseFrom.click();
        MobileElement cnclBtn = (MobileElement) driver.findElementById("android:id/button2");
        cnclBtn.click();
        arrowDown.click();
        srchByWrhouseFrom.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        MobileElement srchBar = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        srchBar.sendKeys("haws2");
        MobileElement srchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        srchBtn.click();
        System.out.println("Case 6 Done");
    }
    //Check "Search by Warehouse To"
    public void Case7(){
        System.out.println("Testing Case 7");
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        MobileElement srchByWrhouseTo = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[6]");
        srchByWrhouseTo.click();
        MobileElement cnclBtn = (MobileElement) driver.findElementById("android:id/button2");
        cnclBtn.click();
        arrowDown.click();
        srchByWrhouseTo.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        MobileElement srchBar = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        srchBar.sendKeys("haws1");
        MobileElement srchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        srchBtn.click();
        System.out.println("Case 7 Done");
    }
    //Check Main View
    public void Case8(){
        System.out.println("Testing Case 8");
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        MobileElement srchByNoFltr = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[1]");
        srchByNoFltr.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        swipeRight();
        swipeRight();
        System.out.println("Case 8 Done");
    }
    //Check Table View "Status" BUG PAG KA DISAPPROVE AYAW MAG BACK SA MAIN VIEW
    public void Case9(){
        System.out.println("Testing Case 9");
        MobileElement pendingProd = (MobileElement) driver.findElementByXPath(pendingProduct+"/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(pendingProd)).withDuration(Duration.ofMillis(1000))).release().perform();
        MobileElement viewRequest = (MobileElement) driver.findElementById("com.engagia.android:id/title");
        viewRequest.click();
        MobileElement disapproveReq = (MobileElement) driver.findElementById("com.engagia.android:id/view_request_disapprove_menu");
        disapproveReq.click();
        MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
        yesBtn.click();
        driver.navigate().back();
        swipeRight();
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(pendingProd)).withDuration(Duration.ofMillis(1000))).release().perform();
        MobileElement delRequest = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]");
        delRequest.click();
        System.out.println("Case 9 Done");
    }
    //Check Request Window
    public void Case10(){
        System.out.println("Testing Case 10");
        viewRequest1();
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/view_request_approved_menu");
        MobileElement element2 = (MobileElement) driver.findElementById("com.engagia.android:id/view_request_disapprove_menu");
        boolean isDisplayed1 = element1.isDisplayed();
        boolean isDisplayed2 = element2.isDisplayed();
        if (isDisplayed1 && isDisplayed2) {
            System.out.println("Case 10 Done");
            driver.navigate().back();
        }

    }
    //Check Request Window: Search by "Name"
    public void Case11(){
        System.out.println("Testing Case 11");
        viewRequest1();
        searchByName();
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 11 Done");
            driver.navigate().back();
        }


    }
    //Check Request Window: Search by "Short Name"
    public void Case12(){
        System.out.println("Testing Case 12");
        viewRequest1();
        searchByShortName();
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 12 Done");
            driver.navigate().back();
        }

    }
    //Check Request Window: Search by "Item Code"
    public void Case13(){
        System.out.println("Testing Case 13");
        viewRequest1();
        searchByItemCode();
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 13 Done");
            driver.navigate().back();
        }

    }
    //Check Request Window: Search by "Barcode"
    public void Case14(){
        System.out.println("Testing Case 14");
        viewRequest1();
        searchByBarcode();
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 14 Done");
            driver.navigate().back();
        }
    }
    //Check Request Window: Search by "Description"
    public void Case15(){
        System.out.println("Testing Case 15");
        viewRequest1();
        searchByDescription();
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 15 Done");
            driver.navigate().back();
        }

    }
    //Check Request Window: Search by "Brand"
    public void Case16(){
        System.out.println("Testing Case 16");
        viewRequest1();
        searchByBrand();
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 16 Done");
            driver.navigate().back();
        }

    }
    //Check Request Window: Search by "Keywords"
    public void Case17(){
        System.out.println("Testing Case 17");
        viewRequest1();
        searchByKeywords();
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 17 Done");
            driver.navigate().back();
        }

    }
    //Check Request Window: Search by "Principal"
    public void Case18(){
        System.out.println("Testing Case 18");
        viewRequest1();
        searchByPrincipal();
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 18 Done");
            driver.navigate().back();
        }

    }
    //Check Request Window: Product Information
    public void Case19(){
        System.out.println("Testing Case 19");
        viewRequest1();
        MobileElement prodName1 = (MobileElement) driver.findElementByXPath(prodNameDrctry+"/android.widget.LinearLayout[1]" +
                "/android.widget.LinearLayout[1]/android.widget.TextView");
        prodName1.click();
        driver.navigate().back();
        MobileElement prodName2 = (MobileElement) driver.findElementByXPath(prodNameDrctry+"/android.widget.LinearLayout[2]" +
                "/android.widget.LinearLayout[1]/android.widget.TextView");
        prodName2.click();
        driver.navigate().back();

        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 19 Done");
            driver.navigate().back();
        }
    }
    //Check Request Window: Unit
    public void Case20(){
        System.out.println("Testing Case 20");
        viewRequest1();
        MobileElement uom = (MobileElement) driver.findElementByXPath(uomDrctry+"/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView");
        uom.click();

        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 20 Done");
            driver.navigate().back();
        }

    }
    //Check Request Window: Request/Return Quantity
    public void Case21(){
        System.out.println("Testing Case 21");
        TouchAction touchAction = new TouchAction(driver);
        viewRequest1();
        swipeRight();
        MobileElement qtyProdPc1 = (MobileElement) driver.findElementByXPath(qtyReqRetDrctry+"/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView");
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(qtyProdPc1)).withDuration(Duration.ofMillis(1000))).release().perform();
        MobileElement qtyProdBox1 = (MobileElement) driver.findElementByXPath(qtyReqRetDrctry+"/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView");
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(qtyProdBox1)).withDuration(Duration.ofMillis(1000))).release().perform();
        MobileElement qtyProdPc2 = (MobileElement) driver.findElementByXPath(qtyReqRetDrctry+"/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView");
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(qtyProdPc2)).withDuration(Duration.ofMillis(1000))).release().perform();
        MobileElement qtyProdBox2 = (MobileElement) driver.findElementByXPath(qtyReqRetDrctry+"/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView");
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(qtyProdBox2)).withDuration(Duration.ofMillis(1000))).release().perform();
        //PC PROD 1
        MobileElement actualQuanPC1 = (MobileElement) driver.findElementByXPath(actualQntyDrctry + "/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
        actualQuanPC1.click();
        MobileElement delBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_clr");
        delBtn.click();
        MobileElement clckNO8 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_8");
        clckNO8.click();
        MobileElement calcuClckOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
        calcuClckOk.click();
        //BOX PROD 1
        MobileElement actualQuanBox1 = (MobileElement) driver.findElementByXPath(actualQntyDrctry + "/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView");
        actualQuanBox1.click();
        delBtn.click();
        clckNO8.click();
        calcuClckOk.click();
        //PC PROD 2
        MobileElement actualQuanPC2 = (MobileElement) driver.findElementByXPath(actualQntyDrctry + "/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
        actualQuanPC2.click();
        delBtn.click();
        clckNO8.click();
        calcuClckOk.click();
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 21 Done");
            driver.navigate().back();
        }


    }
    //Check Request Window: Actual Quantity
    public void Case22(){
        System.out.println("Testing Case 22");
        System.out.println("Searching this user request...");
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        MobileElement srchByReqBy = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[4]");
        srchByReqBy.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        MobileElement srchBar = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        srchBar.sendKeys("qaAuto2@engagia.com");
        MobileElement srchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        srchBtn.click();
        viewRequest1();
        swipeRight();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement actualQuanPC1 = (MobileElement) driver.findElementByXPath(actualQntyDrctry + "/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
        actualQuanPC1.click();
        MobileElement alertTitle1 = (MobileElement) driver.findElementById("com.engagia.android:id/alertTitle");
        MobileElement message1 = (MobileElement) driver.findElementById("android:id/message");
        boolean alertTitleDisplayed1 = alertTitle1.isDisplayed();
        boolean messageDisplayed1 = message1.isDisplayed();
        if (alertTitleDisplayed1 && messageDisplayed1) {
            MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
            okBtn.click();
            System.out.println("Done searching for this user request!");
            driver.navigate().back();
        }
        arrowDown.click();
        MobileElement srchByNoFltr = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[1]");
        srchByNoFltr.click();
        goBtn.click();
        viewRequest1();
        swipeRight();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement actualQuanPC1A = (MobileElement) driver.findElementByXPath(actualQntyDrctry + "/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
        actualQuanPC1A.click();
        //Negative value
        MobileElement clckSubtract = (MobileElement) driver.findElementById("com.engagia.android:id/btn_subtract");
        clckSubtract.click();
        MobileElement calcuBtn1 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_1");
        calcuBtn1.click();
        MobileElement calcuClckOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
        calcuClckOk.click();
        MobileElement alertTitle2 = (MobileElement) driver.findElementById("com.engagia.android:id/alertTitle");
        MobileElement message2 = (MobileElement) driver.findElementById("android:id/message");
        boolean alertTitleDisplayed2 = alertTitle2.isDisplayed();
        boolean messageDisplayed2 = message2.isDisplayed();
        if (alertTitleDisplayed2 && messageDisplayed2) {
            System.out.println("Alert Message 'Please input positive whole numbers only' Displayed");
            MobileElement clckOK = (MobileElement) driver.findElementById("android:id/button1");
            clckOK.click();
        }
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 22 Done");
            driver.navigate().back();
        }
    }
    //Check Request Window: Approve/Disapprove/Cancel
    public void Case23(){
        System.out.println("Testing Case 23");
        viewRequest1();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement approveBtn = (MobileElement) driver.findElementById("com.engagia.android:id/view_request_approved_menu");
        approveBtn.click();
        MobileElement alertTitle1 = (MobileElement) driver.findElementById("com.engagia.android:id/alertTitle");
        MobileElement message1 = (MobileElement) driver.findElementById("android:id/message");
        boolean alertTitleDisplayed1 = alertTitle1.isDisplayed();
        boolean messageDisplayed1 = message1.isDisplayed();
        if (alertTitleDisplayed1 && messageDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button2");
            okBtn.click();
        }
        swipeRight();
        MobileElement actualQuanPC1 = (MobileElement) driver.findElementByXPath(actualQntyDrctry + "/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
        actualQuanPC1.click();
        MobileElement clckNO9 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_9");
        clckNO9.click();
        MobileElement clckNO8 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_8");
        clckNO8.click();
        MobileElement calcuClckOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
        calcuClckOk.click();
        approveBtn.click();
        MobileElement cancelBtn = (MobileElement) driver.findElementById("android:id/button2");
        cancelBtn.click();
        approveBtn.click();
        MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
        yesBtn.click();
        MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
        okBtn.click();
        viewRequest1();
        MobileElement disapproveBtn = (MobileElement) driver.findElementById("com.engagia.android:id/view_request_disapprove_menu");
        disapproveBtn.click();
        cancelBtn.click();
        disapproveBtn.click();
        yesBtn.click();

        driver.navigate().back();
        deleteRequest();
        cancelReqFromOwn();
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 23 Done");
            driver.navigate().back();
        }
    }
    //Check Table View "Status Details"
    public void Case24(){
        statusDtlsView1();
    }
    public void Case26(){

    }


    //Functions
    private void searchByName(){
        System.out.println("Searching by Name");
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        MobileElement selName = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[1]");
        selName.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        //Insert search item code here
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchShortName = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchShortName.sendKeys(prodName);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
    }
    private void searchByShortName(){
        System.out.println("Searching by Short Name");
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        MobileElement selShortName = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[2]");
        selShortName.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        //Insert search item code here
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchShortName = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchShortName.sendKeys(prodShortName[rand(prodShortName.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
    }
    private void searchByItemCode(){
        System.out.println("Searching by Item Code");
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        MobileElement selItemCode = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[3]");
        selItemCode.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        //Insert search item code here
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchItemCode = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchItemCode.sendKeys(prodItemCode[rand(prodItemCode.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
    }
    private void searchByBarcode(){
        System.out.println("Searching by Barcode");
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        MobileElement selBarcode = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[4]");
        selBarcode.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        //Insert search item code here
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBarcode = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchBarcode.sendKeys(prodBarcode[rand(prodBarcode.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
    }
    private void searchByDescription(){
        System.out.println("Searching by Description");
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        MobileElement selDescription = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[5]");
        selDescription.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        //Insert search item code here
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchDescription = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchDescription.sendKeys(prodDescription[rand(prodDescription.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
    }
    private void searchByBrand(){
        System.out.println("Searching by Brand");
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        MobileElement selBrand = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[6]");
        selBrand.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        //Insert search item code here
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBrand = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchBrand.sendKeys(prodBrand[rand(prodBrand.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
    }
    private void searchByKeywords(){
        System.out.println("Searching by Keywords");
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        MobileElement selKeywords = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[7]");
        selKeywords.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        //Insert search item code here
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchKeyword = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchKeyword.sendKeys(prodKeyword[rand(prodKeyword.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
    }
    private void searchByPrincipal(){
        System.out.println("Searching by Principal");
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        MobileElement selPrincipal = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[8]");
        selPrincipal.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        //Insert search item code here
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchPrincipal = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchPrincipal.sendKeys(prodPrincipal[rand(prodPrincipal.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
    }

    public void cancelReqFromOwn(){
        /** CANCEL (From other warehouse to your warehouse)  */
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement srchByReqBy = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[4]");
        srchByReqBy.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement srchBar = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        srchBar.sendKeys("qaAuto2@engagia.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement srchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        srchBtn.click();
        viewRequest1();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancelReq = (MobileElement) driver.findElementById("com.engagia.android:id/view_request_cancel_menu");
        cancelReq.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancelBtn = (MobileElement) driver.findElementById("android:id/button2");
        cancelBtn.click();
        cancelReq.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
        yesBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
        okBtn.click();
    }
    public void deleteRequest(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement pendingProd = (MobileElement) driver.findElementByXPath(pendingProduct+"/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(pendingProd)).withDuration(Duration.ofMillis(1200))).release().perform();
        MobileElement delRequest = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]");
        delRequest.click();
    }
    public void statusDtlsView1(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement statsDetails = (MobileElement) driver.findElementByXPath(statsDtlsDrctry+"/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(statsDetails)).withDuration(Duration.ofMillis(1200))).release().perform();
        driver.navigate().back();
    }

    public void viewRequest1(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement pendingProd = (MobileElement) driver.findElementByXPath(pendingProduct+"/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(pendingProd)).withDuration(Duration.ofMillis(1200))).release().perform();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement viewRequest = (MobileElement) driver.findElementById("com.engagia.android:id/title");
        viewRequest.click();
    }
    public void viewRequest2(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement pendingProd = (MobileElement) driver.findElementByXPath(pendingProduct+"/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(pendingProd)).withDuration(Duration.ofMillis(1200))).release().perform();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement viewRequest = (MobileElement) driver.findElementById("com.engagia.android:id/title");
        viewRequest.click();
    }
    public void viewRequest3(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement pendingProd = (MobileElement) driver.findElementByXPath(pendingProduct+"/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(pendingProd)).withDuration(Duration.ofMillis(1200))).release().perform();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement viewRequest = (MobileElement) driver.findElementById("com.engagia.android:id/title");
        viewRequest.click();
    }

    public void transaction(){
        for(int z = 1; z<=3; z++) {
            if(z==1) {
                viewRequest1();
                swipeRight();
            }
            else if(z==2){
                viewRequest2();
                swipeRight();
            }
            else if(z==3){
                viewRequest3();
                swipeRight();
            }
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
            int height = dim.getHeight();
            //Para nasa gilid un pag scroll walang tatamaan textfield
            int x1 = (int) (width * 0.80);
            int x2 = (int) (width * 0.35);
            int y = (int) (height * 0.25);
            TouchAction touchAction = new TouchAction(driver);
            //try this 700 dati un y
            touchAction.longPress(new PointOption().withCoordinates(x1, y)).moveTo(new PointOption().withCoordinates(x2, y)).release().perform();
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

    private static int rand(int bound) {
        return (int) (Math.random() * bound);
    }
}
