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

public class STR {

    AppiumDriver driver;
    String search = "Stock Transfer";
    String prodName = "soDa";
    String pgName = "tAste";
    String [] prodShortName = {"Clover", "LUCKY STRIKE RED" };
    String [] prodItemCode = {"51232144","88823412"};
    String [] prodBarcode = {"51232172", "10182017028", "51232224"};
    String [] prodDescription = {"Candy", "Soft Drink", "Cracker", "Milk"};
    String [] prodBrand = {"MEGA SARDINES", "Cheezy Corn Crunch", "Nacho Corn Chips", "Crispy  Patata"};
    String [] prodKeyword = {"Clover Bits", "Thin and Crispy Banana Chips", "Soft Drink", "Fita Biscuit"};
    String [] prodPrincipal = {"MFC", "LESLIES CORP", "RC Cola Corp.", "Granny Goose"};
    String searchByDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat" +
            "/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView" +
            "/android.widget.LinearLayout/android.widget.ListView";
    String filterByDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat" +
            "/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView" +
            "/android.widget.LinearLayout/android.widget.ListView[2]" +
            "/android.view.ViewGroup[1]";
    String filterDrctry = "//android.widget.FrameLayout[@index='0']/android.widget.FrameLayout[@index='0']" +
            "/android.widget.FrameLayout[@index='0']/android.widget.LinearLayout[@index='0']" +
            "/android.widget.FrameLayout[@index='0']/android.widget.FrameLayout[@index='0']" +
            "/android.widget.ScrollView[@index='0']/android.widget.LinearLayout[@index='0']";
    String product1 = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout" +
            "/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]" +
            "/android.widget.LinearLayout[1]/android.widget.TextView";
    String prodReq1 = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView";


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
    public void testIC(){
        SearchSTR();
//        Case1();
        //FILTER FUNCTIONS V SEARCH BY
//        Case2();
//        Case3();
//        Case4();
//        Case6();
//        Case7();
//        Case8();
//        Case9();
        //FILTER BY
//        Case10();
//        Case11();
//        Case12();
//        Case13();
//        Case14();
//        Case15();
//        Case16();
        Case19();
        Case20();


    }

    //CASES
    //Check Accessing Stock Transfer Request
    public void Case1(){
        SearchSTR();
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
        byName();
        clear();
        System.out.println("Case 2 Done");
//        //Condition where if prod is displayed or not
//        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Text Note is Required']");
//        boolean isDisplayed1 = snackBar.isDisplayed();
//        if (isDisplayed1) {
//            System.out.println("Snack bar text displayed: Text Note is Required");
//        } else if (!isDisplayed1) {
//            System.out.println("Failed: Snack bar text does not displayed");
//        }
    }
    //Check "Search by Short Name"
    public void Case3(){
        System.out.println("Testing Case 3");
        byShortName();
        clear();
        System.out.println("Case 3 Done");
    }
    //Check Search by "Item Code"
    public void Case4(){
        System.out.println("Testing Case 4");
        byItemCode();
        clear();
        System.out.println("Case 4 Done");
    }
    //Check Search by "Barcode"
    public void Case5(){
        System.out.println("Testing Case 5");
        byBarcode();
        clear();
        System.out.println("Case 5 Done");
    }
    //Check Search by "Description"
    public void Case6(){
        System.out.println("Testing Case 6");
        byDescription();
        clear();
        System.out.println("Case 6 Done");
    }
    //Check Search by "Brand"
    public void Case7(){
        System.out.println("Testing Case 7");
        byBrand();
        clear();
        System.out.println("Case 7 Done");
    }
    //Check Search by "Keywords"
    public void Case8(){
        System.out.println("Testing Case 8");
        byKeyword();
        clear();
        System.out.println("Case 8 Done");
    }
    //Check Search by "Principal"
    public void Case9(){
        System.out.println("Testing Case 9");
        byPrincipal();
        clear();
        System.out.println("Case 9 Done");
    }
    //Check filter "No Filter"
    public void Case10(){
        System.out.println("Testing Case 10");
        for(int z=1; z<=7; z++) {
            noFilter();
            if(z==2){
                byShortName();
            }
            else if(z==3){
                byItemCode();
            }
            else if(z==4){
                byDescription();
            }
            else if(z==5){
                byBrand();
            }
            else if(z==6){
                byKeyword();
            }
            else if(z==7){
                byPrincipal();
            }
            clear();
        }
        System.out.println("Case 10 Done");
    }
    //Check product filter "All Product"
    public void Case11(){
        System.out.println("Testing Case 11");
        for(int z=1; z<=7; z++) {
            allProd();
            if(z==1) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchName.sendKeys(prodName);
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("All product done");
            }
            else if(z==2){
                byShortName();
            }
            else if(z==3){
                byItemCode();
            }
            else if(z==4){
                byDescription();
            }
            else if(z==5){
                byBrand();
            }
            else if(z==6){
                byKeyword();
            }
            else if(z==7){
                byPrincipal();
            }
            clear();
        }
        System.out.println("Case 11 Done");
    }
    //Check product filter "Product Group"
    public void Case12(){
        System.out.println("Testing Case 12");
        for(int z=1; z<=7; z++) {
            prodGroup();
            if(z==1) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchName.sendKeys(pgName);
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("Product Group done");
            }
            else if(z==2){
                byShortName();
            }
            else if(z==3){
                byItemCode();
            }
            else if(z==4){
                byDescription();
            }
            else if(z==5){
                byBrand();
            }
            else if(z==6){
                byKeyword();
            }
            else if(z==7){
                byPrincipal();
            }
            clear();
        }
        System.out.println("Case 12 Done");
    }
    //Check Product Filter "Brand"
    public void Case13(){
        System.out.println("Testing Case 13");
        for(int z=1; z<=7; z++) {
            brand();
            if(z==1) {
                //Insert search here
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("Brand done");
            }
            else if(z==2){
                //Click Search bar and search certain product by Name
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchShortName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchShortName.sendKeys("Adartrel");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
            }
            else if(z==3){
                checkByItemCode();
                //Click Search bar and search certain product by Item Code
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchItemCode = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchItemCode.sendKeys("51232166");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
            }
            else if(z==4){
                checkByDescription();
                //Click Search bar and search certain product by Description
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchDescription = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchDescription.sendKeys("Tablet");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
            }
            else if(z==5){
                checkByBrand();
                //Click Search bar and search certain product by Brand
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchBrand = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchBrand.sendKeys("Adartrel");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
            }
            else if(z==6){
                checkByKeyword();
                //Click Search bar and search certain product by Keywords
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchKeyword = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchKeyword.sendKeys("Adartrel");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
            }
            else if(z==7){
                checkByPrincipal();
                //Click Search bar and search certain product by Principal
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchPrincipal = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchPrincipal.sendKeys("GlaxoSmithKline");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
            }
            clear();
        }
        System.out.println("Case 13 Done");
    }
    //Check Product Filter "Document Sequence"
    public void Case14(){
        System.out.println("Testing Case 14");
        for(int z=1; z<=7; z++) {
            docuSequence();
            if(z==1) {
                //Insert search here
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("Document Sequence done");
            }
            else if(z==2){
                byShortName();
            }
            else if(z==3){
                byItemCode();
            }
            else if(z==4){
                byDescription();
            }
            else if(z==5){
                byBrand();
            }
            else if(z==6){
                byKeyword();
            }
            else if(z==7){
                byPrincipal();
            }
            clear();
        }
        System.out.println("Case 14 Done");
    }
    //Check Information Filter "All Products"
    public void Case15(){
        System.out.println("Testing Case 15");
        for(int z=1; z<=7; z++) {
            AllProd();
            if(z==1) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchName.sendKeys(prodName);
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("All product done");
            }
            else if(z==2){
                byShortName();
            }
            else if(z==3){
                byItemCode();
            }
            else if(z==4){
                byDescription();
            }
            else if(z==5){
                byBrand();
            }
            else if(z==6){
                byKeyword();
            }
            else if(z==7){
                byPrincipal();
            }
            clear();
        }
        System.out.println("Case 15 Done");
    }
    //Check Information Filter "With Inventory"
    public void Case16(){
        System.out.println("Testing Case 16");
        for(int z=1; z<=7; z++) {
            withInvent();
            if(z==1) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchName.sendKeys(prodName);
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("All product done");
            }
            else if(z==2){
                byShortName();
            }
            else if(z==3){
                byItemCode();
            }
            else if(z==4){
                byDescription();
            }
            else if(z==5){
                byBrand();
            }
            else if(z==6){
                byKeyword();
            }
            else if(z==7){
                byPrincipal();
            }
            clear();
        }
        System.out.println("Case 16 Done");
    }
    //Check Information Filter "Without Inventory"
    public void Case17(){
        System.out.println("Testing Case 17");
        for(int z=1; z<=7; z++) {
            withOutInvent();
            if(z==1) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchName.sendKeys(prodName);
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("All product done");
            }
            else if(z==2){
                byShortName();
            }
            else if(z==3){
                byItemCode();
            }
            else if(z==4){
                byDescription();
            }
            else if(z==5){
                byBrand();
            }
            else if(z==6){
                byKeyword();
            }
            else if(z==7){
                byPrincipal();
            }
            clear();
        }
        System.out.println("(SKIP)Case 17 Done");
    }
    //Check Information Filter "With Suggested Load"
    public void Case18(){
        System.out.println("Testing Case 18");
        System.out.println("(SKIP)Case 18 Done");
    }
    //Check Table view "Product Information"
    public void Case19(){
        System.out.println("Testing Case 19");
        MobileElement prod1 = (MobileElement) driver.findElementByXPath(product1);
        prod1.click();
        //Right Arrow
        MobileElement rightArrw = (MobileElement) driver.findElementById("com.engagia.android:id/pager_next");
        rightArrw.click();
        //Left
        MobileElement leftArrw = (MobileElement) driver.findElementById("com.engagia.android:id/pager_previous");
        leftArrw.click();
        System.out.println("Case 19 Done");
        driver.navigate().back();
    }
    //Check Table view "Request/Return Quantity"
    public void Case20(){
        swipeRight();
        swipeRight();
        MobileElement el1 = (MobileElement) driver.findElementByXPath(prodReq1);
        el1.click();
        //todo CLICK OK

    }

    //FUNCTIONS
    public void SearchSTR(){
        //click Hamburger Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement HamburgerBtn = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
        HamburgerBtn.click();
        //search van
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/edit_text_search");
        searchField.sendKeys(search);
        //click search result
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckRes = (MobileElement) driver.findElementByAccessibilityId("Stock Transfer Request");
        clckRes.click();
    }
    //        S E A R C H  B Y
    //[1]
    public void checkByName(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowBtn.click();
        MobileElement clckShortName = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[1]");
        clckShortName.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        System.out.println("Searching by Name");
    }
    //[2]
    public void checkByShortName(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowBtn.click();
        MobileElement clckShortName = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[2]");
        clckShortName.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        System.out.println("Searching by Short Name");
    }
    //[3]
    public void checkByItemCode(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckItemCode = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[3]");
        clckItemCode.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        System.out.println("Searching by Item Code");
    }
    //[4]
    public void checkByBarcode(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckBarcode = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[4]");
        clckBarcode.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        System.out.println("Searching by Barcode");
    }
    //[5]
    public void checkByDescription(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckDescription = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[5]");
        clckDescription.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        System.out.println("Searching by Description");
    }
    //[6]
    public void checkByBrand(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckBrand = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[6]");
        clckBrand.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        System.out.println("Searching by Brand");
    }
    //[7]
    public void checkByKeyword(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckKeyword = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[7]");
        clckKeyword.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        System.out.println("Searching by Keyword");
    }
    //[8]
    public void checkByPrincipal(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckPrincipal = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[8]");
        clckPrincipal.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        System.out.println("Searching by Principal");
    }
    //For cases functions
    public void byName(){
        checkByName();
        //Click Search bar and search certain product by Name
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchShortName = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchShortName.sendKeys(prodName);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
    }
    public void byShortName(){
        checkByShortName();
        //Click Search bar and search certain product by Name
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchShortName = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchShortName.sendKeys(prodShortName[rand(prodShortName.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
    }
    public void byItemCode(){
        checkByItemCode();
        //Click Search bar and search certain product by Item Code
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchItemCode = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchItemCode.sendKeys(prodItemCode[rand(prodItemCode.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
    }
    public void byBarcode(){
        checkByBarcode();
        //Click Search bar and search certain product by Barcode
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBarcode = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchBarcode.sendKeys(prodBarcode[rand(prodBarcode.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
    }
    public void byDescription(){
        checkByDescription();
        //Click Search bar and search certain product by Description
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchDescription = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchDescription.sendKeys(prodDescription[rand(prodDescription.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
    }
    public void byBrand(){
        checkByBrand();
        //Click Search bar and search certain product by Brand
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBrand = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchBrand.sendKeys(prodBrand[rand(prodBrand.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
    }
    public void byKeyword(){
        checkByKeyword();
        //Click Search bar and search certain product by Keywords
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchKeyword = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchKeyword.sendKeys(prodKeyword[rand(prodKeyword.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
    }
    public void byPrincipal(){
        checkByPrincipal();
        //Click Search bar and search certain product by Principal
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchPrincipal = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchPrincipal.sendKeys(prodPrincipal[rand(prodPrincipal.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
    }
    //        F I L T E R  B Y
    public void noFilter(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        MobileElement noFilBtn = (MobileElement) driver.findElementByXPath(filterByDrctry);
        MobileElement noFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'list_row_checked_textview') and @text='No Filter']");
        noFilBtn.click();
    }
    public void prodFilter(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement title = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'filter_by_label') and @text = 'Filter By']");
        boolean isDisplayed1 = title.isDisplayed();
        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement prodFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'list_row_checked_textview') and @text='Product Filter']");
            prodFilBtn.click();
        }
    }
    public void allProd(){
        prodFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allProd = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='All Products']");
        allProd.click();
    }
    public void prodGroup(){
        prodFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement prodGrpFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Product Group']");
        prodGrpFil.click();
        MobileElement prodGrp = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='0']");
        prodGrp.click();
    }
    public void brand(){
        prodFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement brandFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Brand']");
        brandFilBtn.click();
        MobileElement brand = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='0']");
        brand.click();
    }
    public void docuSequence(){
        prodFilter();
        //Filter by btn
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement docSeqFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Document Sequence']");
        docSeqFilBtn.click();
        MobileElement docSeq = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='0']");
        docSeq.click();
    }
    public void infoFilter(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement title = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'filter_by_label') and @text = 'Filter By']");
        boolean isDisplayed1 = title.isDisplayed();
        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement prodFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'list_row_checked_textview') and @text='Information Filter']");
            prodFilBtn.click();
        }
    }
    public void AllProd(){
        infoFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allProd = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='All Products']");
        allProd.click();
    }
    public void withInvent(){
        infoFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allProd = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='With inventory']");
        allProd.click();
    }
    public void withOutInvent(){
        infoFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allProd = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='With inventory']");
        allProd.click();
    }



    public void swipeDown(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Dimension dim = driver.manage().window().getSize();
            int width = dim.getWidth();
            //Para nasa gilid un pag scroll walang tatamaan textfield
            int x = (int) (width * 0.25);
            TouchAction touchAction = new TouchAction(driver);
            //try this
            touchAction.longPress(new PointOption().withCoordinates(x, 500)).moveTo(new PointOption().withCoordinates(x, 100)).release().perform();
        }

    }
    public void swipeRight(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Dimension dim = driver.manage().window().getSize();
            int width = dim.getWidth();
            //Para nasa gilid un pag scroll walang tatamaan textfield
            int x1 = (int) (width * 0.99);
            int x2 = (int) (width * 0.75);
            TouchAction touchAction = new TouchAction(driver);
            //try this
            touchAction.longPress(new PointOption().withCoordinates(x1, 300)).moveTo(new PointOption().withCoordinates(x2, 300)).release().perform();
        }
    }
    public void strSummaryMenu(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement threeDots = (MobileElement) driver.findElementByAccessibilityId("Show action");
        threeDots.click();

    }
    public void clear(){
        strSummaryMenu();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clrBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'txt_clear_all_btn') and @text='CLEAR']");
        clrBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement contBtn = (MobileElement) driver.findElementById("android:id/button1");
        contBtn.click();
    }


    private static int rand(int bound) {
        return (int) (Math.random() * bound);
    }
}
