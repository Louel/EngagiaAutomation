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

public class TIM {
    AppiumDriver driver;
    String search = "Trade Inventory";
    String prodName = "soDa";
    String pgName = "tAste";
    String mustCarryProd = "cOc";
    String [] prodShortName = {"Clover", "LUCKY STRIKE RED" };
    String [] prodItemCode = {"51232144","88823412"};
    String [] prodBarcode = {"51232172", "10182017028", "51232224"};
    String [] prodDescription = {"Candy", "Soft Drink", "Cracker", "Milk"};
    String [] prodBrand = {"MEGA SARDINES", "Cheezy Corn Crunch", "Nacho Corn Chips", "Crispy  Patata"};
    String [] prodKeyword = {"Clover Bits", "Thin and Crispy Banana Chips", "Soft Drink", "Fita Biscuit"};
    String [] prodPrincipal = {"MFC", "LESLIES CORP", "RC Cola Corp.", "Granny Goose"};
    String branchListDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout" +
            "/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView";
    String searchByDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout" +
            "/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView";
    String filterByDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout" +
            "/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView[2]";
    String productFilterByDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout" +
            "/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView";
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
    public void testTIM(){
        //Log in to visit
        loginToVisit();
    }
    //Cases

    //Check Search by "Name"
    public void Case2(){
        System.out.println("Testing Case 2");
        //Click Search bar and search certain product by Name
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchName = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchName.sendKeys(prodName);
//        driver.hideKeyboard();
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
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
    //Check Search by "Short Name"
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
    //Check APP: Trade Inventory Management - filter "No Filter"
    public void Case10(){
        System.out.println("Testing Case 10");
        for(int z=1; z<=7; z++) {
            noFilter();
            if(z==1) {
                byName();
                clear();
            }
            else if(z==2){
                byShortName();
                clear();
            }
            else if(z==3){
                byItemCode();
                clear();
            }
            else if(z==4){
                byDescription();
                clear();
            }
            else if(z==5){
                byBrand();
                clear();
            }
            else if(z==6){
                byKeyword();
                clear();
            }
            else if(z==7){
                byPrincipal();
                clear();
            }
        }
 //        for (int z = 1; z <=7; z++) {
//            if(z==1) {
//                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//                MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
//                arrowBtn.click();
//                //Swipe down
//                swipeDown();
//                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//                MobileElement noFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='No Filter']");
//                noFilBtn.click();
//            }
//            else if(z==2){
//                shortNameNoFilter();
//            }
//            else if(z==3){
//                itemCodeNoFilter();
//            }
//            //            else if(z==3){
////                barcode();
////                //Swipe down
////                swipeDown();
////                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
////                MobileElement noFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='No Filter']");
////                noFilBtn.click();
////            }
//            else if(z==4){
//                descriptionNoFilter();
//            }
//            else if(z==5){
//                brandNoFilter();
//            }
//            else if(z==6){
//                keywordNoFilter();
//            }
//            else if(z==7){
//                principalNoFilter();
//            }
//        }
        System.out.println("Case 10 Done");
    }
    //Check APP: Trade Inventory Management - filter "Product Filter"
    public void Case11(){
        System.out.println("Testing Case 11");
        productFilter();
        driver.navigate().back();
        driver.navigate().back();
        System.out.println("Case 11 Done");
    }
    //Check APP: Trade Inventory Management - filter "Product Filter: All Products"
    public void Case12(){
        System.out.println("Testing Case 12");
        for(int z=1; z<=7; z++) {
            allProd();
            if(z==1) {
                byName();
                clear();
            }
            else if(z==2){
                byShortName();
                clear();
            }
            else if(z==3){
                byItemCode();
                clear();
            }
            else if(z==4){
                byDescription();
                clear();
            }
            else if(z==5){
                byBrand();
                clear();
            }
            else if(z==6){
                byKeyword();
                clear();
            }
            else if(z==7){
                byPrincipal();
                clear();
            }
        }
        System.out.println("Case 12 Done");
    }
    //Check APP: Trade Inventory Management - filter "Product Filter: Product Group"
    public void Case13(){
        System.out.println("Testing Case 13");
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
                clear();
            }
            else if(z==2){
                byShortName();
                clear();
            }
            else if(z==3){
                byItemCode();
                clear();
            }
            else if(z==4){
                byDescription();
                clear();
            }
            else if(z==5){
                byBrand();
                clear();
            }
            else if(z==6){
                byKeyword();
                clear();
            }
            else if(z==7){
                byPrincipal();
                clear();
            }
        }
        System.out.println("Case 12 Done");
    }
    //Check APP: Trade Inventory Management - filter "Product Filter: Must Carry Per Account Classification"
    public void Case14(){
        System.out.println("Testing Case 14");
        for(int z=1; z<=7; z++) {
            mustCarry();
            if(z==1) {
                checkByName();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchName.sendKeys(mustCarryProd);
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("Must Carry done");
                clear();
            }
            else if(z==2){
                checkByShortName();
                //Click Search bar and search certain product by Name
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchShortName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchShortName.sendKeys("Adartrel");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                clear();
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
                clear();
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
                clear();
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
                clear();
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
                clear();
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
                clear();
            }
        }
        System.out.println("Case 14 Done");
    }
    //Check APP: Trade Inventory Management - filter "Product Filter: Universal Retail Category"
    public void Case15(){
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
    //Check APP: Trade Inventory Management - filter "Product Filter: Brand"
    public void Case16(){
        System.out.println("Testing Case 16");
        for(int z=1; z<=7; z++) {
            brand();
            if(z==1) {
                checkByName();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchName.sendKeys("Adartrel");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("Brand done");
                clear();
            }
            else if(z==2){
                checkByShortName();
                //Click Search bar and search certain product by Name
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchShortName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchShortName.sendKeys("Adartrel");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                clear();
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
                clear();
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
                clear();
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
                clear();
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
                clear();
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
                clear();
            }
        }
        System.out.println("Case 16 Done");
    }
    //Check APP: Trade Inventory Management - filter "Product Filter: Product With Historical Sales"
    public void Case17(){
        System.out.println("Testing Case 15");
        for(int z=1; z<=7; z++) {
            if(z==1) {
                activeProd();
                //Insert search here
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("Active Products done");
                clear();
            }
            else if(z==2){
                activeProd();
                byShortName();
                clear();
            }
            else if(z==3){
                activeProd();
                byItemCode();
                clear();
            }
            else if(z==4){
                activeProd();
                byDescription();
                clear();
            }
            else if(z==5){
                activeProd();
                byBrand();
                clear();
            }
            else if(z==6){
                activeProd();
                byKeyword();
                clear();
            }
            else if(z==7){
                activeProd();
                byPrincipal();
                clear();
            }
        }
        System.out.println("Case 15 Done");
    }
    //Check APP: Trade Inventory Management - filter "Product Filter: Must Carry + Product With Historical Sales"
    public void Case18(){

    }
    //Check APP: Trade Inventory Management - filter "Product Filter: Document Sequence"
    public void Case19(){
        System.out.println("Testing Case 19");
        for(int z=1; z<=7; z++) {
            docuSequence();
            if(z==1) {
                byName();
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
        System.out.println("Case 19 Done");
    }
    //Check APP: Trade Inventory Management - filter "Product Filter: Active Products"
    public void Case20(){
        System.out.println("Testing Case 20");
        for(int z=1; z<=7; z++) {
            activeProd();
            if(z==1) {
                byName();
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
        System.out.println("Case 20 Done");
    }
    //Check APP: Trade Inventory Management - filter "Product Filter: Carried Products"PRODUCT
    public void Case21(){
        System.out.println("Testing Case 21");
        for(int z=1; z<=7; z++) {
            carriedProd();
            if(z==1) {
                byName();
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
        System.out.println("Case 21 Done");
    }
    //Check product filter "Not Carried Products" MAY BUG DITO DI NAKIKITA UN NOT CARRIED PRODUCT
    public void Case22(){
        System.out.println("Testing Case 22");
        for(int z=1; z<=7; z++) {
            notCarriedProd();
            if(z==1) {
                //Insert search here
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("Not Carried Products done");
            }
            else if(z==2){
                checkByShortName();
                //Click Search bar and search certain product by Name
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchShortName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchShortName.sendKeys("Red hot");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
            }
            else if(z==3){
                checkByItemCode();
                //Click Search bar and search certain product by Item Code
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchItemCode = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchItemCode.sendKeys("CHZZY15436324");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
            }
            else if(z==4){
                checkByDescription();
                //Click Search bar and search certain product by Description
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchDescription = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchDescription.sendKeys("chEezy");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
            }
            else if(z==5){
                checkByBrand();
                //Click Search bar and search certain product by Brand
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchBrand = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchBrand.sendKeys("CHEEZY");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
            }
            else if(z==6){
                checkByKeyword();
                //Click Search bar and search certain product by Keywords
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchKeyword = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchKeyword.sendKeys("CHIPS");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
            }
            else if(z==7){
                checkByPrincipal();
                //Click Search bar and search certain product by Principal
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchPrincipal = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchPrincipal.sendKeys("Leslie");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
            }
            clear();
        }
        System.out.println("Case 22 Done");
    }
    //Check APP: Trade Inventory Management - filter "Information Filter"
    public void Case23(){
        infoFilter();
        driver.navigate().back();
        driver.navigate().back();
        System.out.println("Case 34 Done");
    }
    //Check APP: Trade Inventory Management - filter "Information Filter: All Products"
    public void Case24(){
        System.out.println("Testing Case 24");
        for(int z=1; z<=7; z++) {
            infoFilterAllProd();
            if(z==1) {
                byName();
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
        System.out.println("Case 24 Done");
    }
    //Check APP: Trade Inventory Management - filter "Information Filter: Inventory > 0"
    public void Case25a(){
        System.out.println("Testing Case 25");
        for(int z=1; z<=7; z++) {
            infoFilterInventoryGreaterThanZero();
            if(z==1) {
                byName();
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
        System.out.println("Case 25 Done");
    }
    //TODO Check APP: Trade Inventory Management - filter "Information Filter: Current inventory on days < Order to delivery leadtime"
    public void Case25(){
        System.out.println("Testing Case 24");
        for(int z=1; z<=7; z++) {
            infoFilterCurrentInvent();
            if(z==1) {
                byName();
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
        System.out.println("Case 24 Done");
    }
    //Check APP: Trade Inventory Management - filter "Information Filter: Estimated inventory level by next OGV in units <= 0"
    public void Case26(){
        System.out.println("Testing Case 24");
        for(int z=1; z<=7; z++) {
            infoFilterEstimatedInventory();
            if(z==1) {
                byName();
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
        System.out.println("Case 24 Done");
    }
    //Functions
    public void loginToVisit(){
        for(int x=1; x<=1; x++){
            //Click on Drawer
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement drawerOpen = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
            drawerOpen.click();
            //Click on Arrow down btn
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement clckArrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/image_visit_dropdown");
            clckArrowDown.click();
            //Click on branch depends on index or int of the loop
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement clckOnBranch = (MobileElement) driver.findElementByXPath(branchListDrctry + "/android.widget.RelativeLayout[" + x + "]");
            clckOnBranch.click();
            //IF BRANCH IS NOT SCHEDULED A PROMPT WILL APPEAR
//            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//            MobileElement contBtn = (MobileElement) driver.findElementById("android:id/button1");
//            contBtn.click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement confirmBtn = (MobileElement) driver.findElementById("android:id/button1");
            confirmBtn.click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
            okBtn.click();
            //INSERT CASES OR FUNCTION HERE
            SearchTIM();
//            Case1();
//            Case2();
//            Case3();
//            Case4();
//            Case6();
//            Case7();
//            Case8();
//            Case9();
            //FILTER
//            Case10();
//            Case11();
//            Case12();
//            Case13(); Force close
//            Case14();
//            Case15(); //Is not available
//            Case16();
//            Case19();
//            Case20();
//            Case21();
//            Case22(); bugshit
            Case23();
            Case24();




            //Click on Drawer to logout to visit
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement drawerOpen2 = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
            drawerOpen2.click();
            //Insert swipe up to arrow
            swipeUp();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            clckArrowDown.click();
            //Log out
            MobileElement logoutBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_visit_logout");
            logoutBtn.click();
        }
    }
    public void SearchTIM(){
        //click Hamburger Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement HamburgerBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
        HamburgerBtn.click();
        System.out.println("Seaching TIM");
        //search test.BAOF
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/edit_text_search");
        searchField.sendKeys(search);
        //click search result
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckRes = (MobileElement) driver.findElementByAccessibilityId("Trade Inventory Management");
        clckRes.click();
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
    public void swipeRight(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Dimension dim = driver.manage().window().getSize();
            int width = dim.getWidth();
            int height = dim.getHeight();
            //Para nasa gilid un pag scroll walang tatamaan textfield
            int x1 = (int) (width * 0.99);
            int x2 = (int) (width * 0.72);
            int y = (int) (height * 0.30);
            TouchAction touchAction = new TouchAction(driver);
            //try this 300
            touchAction.longPress(new PointOption().withCoordinates(x1, y)).moveTo(new PointOption().withCoordinates(x2, y)).release().perform();
        }
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
    public void checkByItemCode(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowBtn.click();
        MobileElement clckItemCode = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[3]");
        clckItemCode.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        System.out.println("Searching by Item Code");
    }
    public void checkByBarcode(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowBtn.click();
        MobileElement clckBarcode = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[4]");
        clckBarcode.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        System.out.println("Searching by Barcode");
    }
    public void checkByDescription(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowBtn.click();
        MobileElement clckDescription = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[5]");
        clckDescription.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        System.out.println("Searching by Description");
    }
    public void checkByBrand(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowBtn.click();
        MobileElement clckBrand = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[6]");
        clckBrand.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        System.out.println("Searching by Brand");
    }
    public void checkByKeyword(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowBtn.click();
        MobileElement clckKeyword = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[7]");
        clckKeyword.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        System.out.println("Searching by Keyword");
    }
    public void checkByPrincipal(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowBtn.click();
        MobileElement clckPrincipal = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.CheckedTextView[8]");
        clckPrincipal.click();
        MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
        goBtn.click();
        System.out.println("Searching by Principal");
    }
    public void infoFilter(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowBtn.click();
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement title = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_label");
        boolean isDisplayed1 = title.isDisplayed();
        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement infoFilBtn = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.view.ViewGroup[3]/android.widget.CheckedTextView");
            String infoFilBtnText = infoFilBtn.getText();
            infoFilBtn.click();
            System.out.println("Filter by "+infoFilBtnText);
        }

    }
    public void infoFilterAllProd(){
        infoFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allProd = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[1]");
        String allProdText = allProd.getText();
        allProd.click();
        System.out.println("Info Filter by "+allProdText);
    }
    public void infoFilterInventoryGreaterThanZero(){
        infoFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement inventGreaterThanZero = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[2]");
        String inventGreaterThanZeroText = inventGreaterThanZero.getText();
        inventGreaterThanZero.click();
        System.out.println("Info Filter by "+inventGreaterThanZeroText);
    }
    public void infoFilterInventoryEqualZero(){
        infoFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement inventEqualZero = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[3]");
        String inventEqualZeroText = inventEqualZero.getText();
        inventEqualZero.click();
        System.out.println("Info Filter by "+inventEqualZeroText);
    }
    public void infoFilterCurrentInvent(){
        infoFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement currentInvent = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[4]");
        String currentInventText = currentInvent.getText();
        currentInvent.click();
        System.out.println("Info Filter by "+currentInventText);
    }
    public void infoFilterEstimatedInventory(){
        infoFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement estimatedInventory = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[5]");
        String estimatedInventoryText = estimatedInventory.getText();
        estimatedInventory.click();
        System.out.println("Info Filter by "+estimatedInventoryText);
    }
    public void infoFilterDailyOfftake(){
        infoFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement dailyOfftake = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[6]");
        String dailyOfftakeText = dailyOfftake.getText();
        dailyOfftake.click();
        System.out.println("Info Filter by "+dailyOfftakeText);
    }
    public void infoFilterWeeklyOfftake(){
        infoFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement weeklyOfftake = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[7]");
        String weeklyOfftakeText = weeklyOfftake.getText();
        weeklyOfftake.click();
        System.out.println("Info Filter by "+weeklyOfftakeText);
    }
    public void infoFilterSuggestedOrder(){
        infoFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement suggestedOrder = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[8]");
        String suggestedOrderText = suggestedOrder.getText();
        suggestedOrder.click();
        System.out.println("Info Filter by "+suggestedOrderText);
    }
    private void clear(){
        timSummaryMenu();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clrBtn = (MobileElement) driver.findElementById("com.engagia.android:id/txt_clear_all_btn");
        clrBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement contBtn = (MobileElement) driver.findElementById("android:id/button1");
        contBtn.click();
    }
    public void noFilter(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowBtn.click();
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ///android.view.View[1]/android.widget.CheckedTextView FOR ANDROID VERSION 5.1
        //android.view.ViewGroup[1]/android.widget.CheckedTextView FOR ANDROID VERSION 7
        MobileElement noFilBtn = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.view.ViewGroup[1 ]/android.widget.CheckedTextView");
        noFilBtn.click();
        System.out.println("Filter by No Filter");
    }
    public void productFilter(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowBtn.click();
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement title = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_label");
        boolean isDisplayed1 = title.isDisplayed();
        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement prodFilBtn = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.view.ViewGroup[2]/android.widget.CheckedTextView");
            String prodFilBtnText = prodFilBtn.getText();
            prodFilBtn.click();
            System.out.println("Filter by "+prodFilBtnText);
        }
    }
    public void allProd(){
        productFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allProd = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[1]");
        allProd.click();
        System.out.println("Product Filter by All Products");
    }
    public void prodGroup(){
        productFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement prodGrpFil = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[2]");
        prodGrpFil.click();
        MobileElement prodGrp = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='0']");
        prodGrp.click();
        System.out.println("Product Filter by Product Group");
    }
    public void mustCarry(){
        productFilter();
//        MobileElement prodFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[@index='1' and @text='Product Filter']");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement mustCarryFilBtn = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[3]");
        mustCarryFilBtn.click();
        MobileElement mustCarry = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='0']");
        String mustCarryText = mustCarry.getText();
        mustCarry.click();
        System.out.println(mustCarryText);
    }
    public void brand(){
        productFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement brandFilBtn = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[4]");
        brandFilBtn.click();
        MobileElement brand = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='0']");
        String brandText = brand.getText();
        brand.click();
        System.out.println(brandText);
    }
    public void docuSequence(){
        productFilter();
        //Filter by btn
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement docSeqFilBtn = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[8]");
        docSeqFilBtn.click();
        MobileElement docSeq = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='0']");
        String docSeqText = docSeq.getText();
        docSeq.click();
        System.out.println(docSeqText);
    }
    public void activeProd(){
        productFilter();
        //Filter by btn
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement activeProdFilBtn = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[9]");
        activeProdFilBtn.click();
        System.out.println("Product Filter by Active Product");
    }
    public void carriedProd(){
        productFilter();
        //Filter by btn
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement carriedProdFilBtn = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[10]");
        carriedProdFilBtn.click();
        System.out.println("Product Filter by Carried Product");
    }
    public void notCarriedProd(){
        productFilter();
        //Filter by btn
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement notCarriedProdFilBtn = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[11]");
        notCarriedProdFilBtn.click();
        System.out.println("Product Filter by Not Carried Product");
    }
    public void timSummaryMenu(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement threeDots = (MobileElement) driver.findElementByAccessibilityId("Show action");
        threeDots.click();
    }
    private static int rand(int bound) {
        return (int) (Math.random() * bound);
    }
    //For Cases functions
    public void byName(){
        checkByName();
        //Click Search bar and search certain product by Name
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchName = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchName.sendKeys(prodName);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
        System.out.println("Search by Name");
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
        System.out.println("Search by Short Name");
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
        System.out.println("Search by Short Name");
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
        System.out.println("Search by Barcode");
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
        System.out.println("Search by Description");
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
        System.out.println("Search by Brand");
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
        System.out.println("Search by Keyword");
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
        System.out.println("Search by Principal");
    }

}
