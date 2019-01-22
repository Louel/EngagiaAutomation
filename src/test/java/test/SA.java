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

public class SA {


    AppiumDriver driver;
    String search = "Stocks Audit";
    String prodName = "soDa";
    String [] prodShortName = {"Fruit", "MeGA" , "roYal" };
    String [] prodItemCode = {"51232166", "51232167", "51232219", "51232143"};
    String [] prodBarcode = {"51232167", "51232168", "10182017020", "51232198"};
    String [] prodDescription = {"Candy", "Soda", "Cracker", "Milk"};
    String [] prodBrand = {"MEGA SARDINES", "Cheezy Corn Crunch", "Jack N Jill"};
    String [] prodKeyword = {"Cola", "Piattos", "Coke", "buLb"};
    String [] prodPrincipal = {"MFC", "LESLIES CORP", "RC Cola Corp.", "URC"};
//    String searchByDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout" +
//            "/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout" +
//            "/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView";
    String searchByDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout" +
            "/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.ListView";
    String pendingProduct = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout";
    String actualInventDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.ScrollView" +
            "/android.widget.LinearLayout";

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Samsung Galaxy J1 (2016)");
//        capabilities.setCapability("deviceName","Lenovo A7010a48");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("platformVersion", "5.1.1");
//        capabilities.setCapability("platformVersion", "5.1");
        capabilities.setCapability("appPackage", "com.engagia.android");
        capabilities.setCapability("appActivity","com.engagia.android.activities.LoginActivity");
        capabilities.setCapability("noSign", true);
        capabilities.setCapability(FULL_RESET, false);
        capabilities.setCapability(NO_RESET, true);
        //Papalitan un Ip depende sa pc
        driver = new AppiumDriver(new URL("http://192.168.0.167:4723/wd/hub"), capabilities);
    }

    @Test
    public void testSA(){
//        Case1();
        SearchSA();
        Case2();
        Case3();
        Case4();
        Case5();
        Case6();
        Case7();
        Case8();
        Case9();
        Case10();
        Case11();


    }

    /**      C A S E S   */
    //Check Accessing Stocks Audit
    public void Case1(){
        System.out.println("Testing Case 1");
        SearchSA();
        //Loop
        //Navigate Home and Relaunching Engagia step (Step 6 and 7)
        driver.launchApp();
        //Close app (Step 8)
        driver.closeApp();
        //Open Engagia Again (Step 9)
        driver.launchApp();
        System.out.println("Case 1 Done");
    }
    //Check "Search by Name"
    public void Case2(){
        System.out.println("Testing Case 2");
        searchByName();
        System.out.println("Case 2 Done");
    }
    //Check "Search by Short Name"
    public void Case3(){
        System.out.println("Testing Case 3");
        searchByShortName();
        System.out.println("Case 3 Done");
    }
    //Check "Search by Item Code"
    public void Case4(){
        System.out.println("Testing Case 4");
        searchByItemCode();
        System.out.println("Case 4 Done");
    }
    //Check "Search by Barcode"
    public void Case5(){
        System.out.println("Testing Case 5");
        searchByBarcode();
        System.out.println("Case 5 Done");
    }
    //Check "Search by Description"
    public void Case6(){
        System.out.println("Testing Case 6");
        searchByDescription();
        System.out.println("Case 6 Done");
    }
    //Check "Search by Brand"
    public void Case7(){
        System.out.println("Testing Case 7");
        searchByBrand();
        System.out.println("Case 7 Done");
    }
    //Check "Search by Keywords"
    public void Case8(){
        System.out.println("Testing Case 8");
        searchByKeywords();
        System.out.println("Case 8 Done");
    }
    //Check Table View: "Actual Inventory"
    public void Case9(){
        System.out.println("Testing Case 9");
        MobileElement actualInvent1 = (MobileElement) driver.findElementByXPath(actualInventDrctry+"/android.widget.LinearLayout[1]" +
                "/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
        actualInvent1.click();
        //insert negative value
        MobileElement clckSubtract = (MobileElement) driver.findElementById("com.engagia.android:id/btn_subtract");
        clckSubtract.click();
        MobileElement calcuBtn1 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_1");
        calcuBtn1.click();
        MobileElement calcuClckOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
        calcuClckOk.click();
        MobileElement delBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_clr");
        delBtn.click();
        //insert positive value
        calcuBtn1.click();
        calcuClckOk.click();
        MobileElement actualInvent2 = (MobileElement) driver.findElementByXPath(actualInventDrctry+"/android.widget.LinearLayout[2]" +
                "/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
        actualInvent2.click();
        calcuBtn1.click();
        calcuClckOk.click();
        System.out.println("Case 9 Done");
    }
    //Check Summary button "Normal Count"
    public void Case10(){
        clear();
        System.out.println("Testing Case 10");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement showAction = (MobileElement) driver.findElementByAccessibilityId("Show action");
        showAction.click();
        MobileElement normalCount = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]");
        normalCount.click();
//        MobileElement userName = (MobileElement) driver.findElementById("com.engagia.android:id/etUsername");
//        userName.sendKeys("auditorAuto1@engagia.com");
//        MobileElement passWord = (MobileElement) driver.findElementById("com.engagia.android:id/etPassword");
//        passWord.sendKeys("Password1!");
//        driver.hideKeyboard();
//        MobileElement validateBtn = (MobileElement) driver.findElementById("android:id/button1");
//        validateBtn.click();
        MobileElement cancelBtn = (MobileElement) driver.findElementById("android:id/button2");
        cancelBtn.click();
        System.out.println("Case 10 Done");
    }
    //Check Default View Summary Menu: Compare
    public void Case11(){
        System.out.println("Testing Case 11");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement showAction = (MobileElement) driver.findElementByAccessibilityId("Show action");
        showAction.click();
        MobileElement compare = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]");
        compare.click();
        MobileElement loading = (MobileElement) driver.findElementById("android:id/body");
        boolean loadingDisplayed = loading.isDisplayed();
            if(loadingDisplayed){
                System.out.println("Product not match in inventory displayed...");
                MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
                okBtn.click();
            }
        driver.navigate().back();
        System.out.println("Case 11 Done");
    }


    /**      F U N C T I O N S   */
    public void SearchSA(){
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
        MobileElement clckRes = (MobileElement) driver.findElementByAccessibilityId("Stocks Audit");
        clckRes.click();
    }
    private void searchByName(){
        System.out.println("Searching by Name");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement showAction = (MobileElement) driver.findElementByAccessibilityId("Show action");
        boolean isDisplayed = showAction.isDisplayed();
            if(isDisplayed){
                MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
                arrowDown.click();
            }
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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement showAction = (MobileElement) driver.findElementByAccessibilityId("Show action");
        boolean isDisplayed = showAction.isDisplayed();
        if(isDisplayed){
            MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
            arrowDown.click();
        }
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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement showAction = (MobileElement) driver.findElementByAccessibilityId("Show action");
        boolean isDisplayed = showAction.isDisplayed();
        if(isDisplayed){
            MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
            arrowDown.click();
        }
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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement showAction = (MobileElement) driver.findElementByAccessibilityId("Show action");
        boolean isDisplayed = showAction.isDisplayed();
        if(isDisplayed){
            MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
            arrowDown.click();
        }
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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement showAction = (MobileElement) driver.findElementByAccessibilityId("Show action");
        boolean isDisplayed = showAction.isDisplayed();
        if(isDisplayed){
            MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
            arrowDown.click();
        }
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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement showAction = (MobileElement) driver.findElementByAccessibilityId("Show action");
        boolean isDisplayed = showAction.isDisplayed();
        if(isDisplayed){
            MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
            arrowDown.click();
        }
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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement showAction = (MobileElement) driver.findElementByAccessibilityId("Show action");
        boolean isDisplayed = showAction.isDisplayed();
        if(isDisplayed){
            MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
            arrowDown.click();
        }
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

    private void clear(){
        MobileElement showAction = (MobileElement) driver.findElementByAccessibilityId("Show action");
        showAction.click();
        MobileElement clrBtn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]");
        clrBtn.click();
        MobileElement contBtn = (MobileElement) driver.findElementById("android:id/button1");
        contBtn.click();

    }


    private static int rand(int bound) {
        return (int) (Math.random() * bound);
    }

}
