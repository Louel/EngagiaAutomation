package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class IC {

    AppiumDriver driver;
    String search = "Inventory Cou";
    String [] randomText = {"zczxczxc","12331231","Abbbccde","Abcde!@#","1a2b3c","A1B1C1", "random" , "somerandomtxt", "randomtxtsome" , "randomsometxt"};
    String prodName = "soDa";
    String pgName = "tAste";
    String mustCarryProd = "cOc";
    String branch = "ALFAMART MARIKINA 1";
    String [] prodShortName = {"Clover", "LUCKY STRIKE RED" };
    String [] prodItemCode = {"51232144","88823412"};
    String [] prodBarcode = {"51232172", "10182017028", "51232224"};
    String [] prodDescription = {"Candy", "Soft Drink", "Cracker", "Milk"};
    String [] prodBrand = {"MEGA SARDINES", "Cheezy Corn Crunch", "Nacho Corn Chips", "Crispy  Patata"};
    String [] prodKeyword = {"Clover Bits", "Thin and Crispy Banana Chips", "Soft Drink", "Fita Biscuit"};
    String [] prodPrincipal = {"MFC", "LESLIES CORP", "RC Cola Corp.", "Granny Goose"};
    String invenDrctryTbl = "//android.widget.FrameLayout[@index='0']/" +
            "android.widget.LinearLayout[@index='0']/" +
            "android.widget.FrameLayout[@index='0']/" +
            "android.widget.LinearLayout[@index='0']/" +
            "android.widget.FrameLayout[@index='0']/" +
            "android.support.v4.widget.DrawerLayout[@index='0']/" +
            "android.widget.LinearLayout[@index='0']/" +
            "android.widget.FrameLayout[@index='1']/" +
            "android.widget.LinearLayout[@index='0']/" +
            "android.widget.FrameLayout[@index='1']/" +
            "android.widget.LinearLayout[@index='0']/";
    String branchListDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout" +
            "/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView";
    String searchByDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView";
    String filterByDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView[2]";
    String productFilterByDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.ListView";


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
        icLogInToVisit();
    }
    //Case Functions
    //Check Search by "Name"
    public void Case2(){
        System.out.println("Testing Case 1");
        //Click Search bar and search certain product by Name
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchName = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchName.sendKeys(prodName);
//        driver.hideKeyboard();
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
        System.out.println("Case 1 Done");
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
        System.out.println("Testing Case 2");
        byShortName();
        clear();
        System.out.println("Case 2 Done");
    }
    //Check Search by "Item Code"
    public void Case4(){
        System.out.println("Testing Case 3");
        byItemCode();
        clear();
        System.out.println("Case 3 Done");
    }
    //Check Search by "Barcode"
    //Lumalabas un camera for bar code
    public void Case5(){
        System.out.println("Testing Case 4");
        byBarcode();
        clear();
        System.out.println("Case 4 Done");
    }
    //Check Search by "Description"
    public void Case6(){
        System.out.println("Testing Case 5");
        byDescription();
        clear();
        System.out.println("Case 5 Done");
    }
    //Check Search by "Brand"
    public void Case7(){
        System.out.println("Testing Case 6");
        byBrand();
        clear();
        System.out.println("Case 6 Done");
    }
    //Check Search by "Keywords"
    public void Case8(){
        System.out.println("Testing Case 7");
        byKeyword();
        clear();
        System.out.println("Case 7 Done");
    }
    //Check Search by "Principal"
    public void Case9(){
        System.out.println("Testing Case 8");
        byPrincipal();
        clear();
        System.out.println("Case 8 Done");
    }
    //Check filter "No Filter"
    public void Case10(){
        System.out.println("Testing Case 9");
        for(int z=1; z<=7; z++) {
            if(z==1) {
                noFilter();
                clear();
            }
            else if(z==2){
                noFilter();
                byShortName();
                clear();
            }
            else if(z==3){
                noFilter();
                byItemCode();
                clear();
            }
            else if(z==4){
                noFilter();
                byDescription();
                clear();
            }
            else if(z==5){
                noFilter();
                byBrand();
                clear();
            }
            else if(z==6){
                noFilter();
                byKeyword();
                clear();
            }
            else if(z==7){
                noFilter();
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
        System.out.println("Case 9 Done");
    }
    //Check product filter "All Product"
    public void Case11(){
        System.out.println("Testing Case 10");
        for(int z=1; z<=7; z++) {
            if(z==1) {
                allProd();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchName.sendKeys(prodName);
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("All product done");
                clear();
            }
            else if(z==2){
                allProd();
                byShortName();
                clear();
            }
            else if(z==3){
                allProd();
                byItemCode();
                clear();
            }
            else if(z==4){
                allProd();
                byDescription();
                clear();
            }
            else if(z==5){
                allProd();
                byBrand();
                clear();
            }
            else if(z==6){
                allProd();
                byKeyword();
                clear();
            }
            else if(z==7){
                allProd();
                byPrincipal();
                clear();
            }
        }
        System.out.println("Case 10 Done");
    }
    //Check product filter "Product Group"
    public void Case12(){
        System.out.println("Testing Case 11");
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
        System.out.println("Case 11 Done");
    }
    //Check product filter "Must Carry Per Account Classification"
    public void Case13(){
        System.out.println("Testing Case 12");
        for(int z=1; z<=7; z++) {
            mustCarry();
            if(z==1) {
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
    //Check product filter "Brand"
    public void Case14(){
        System.out.println("Testing Case 13");
        for(int z=1; z<=7; z++) {
            brand();
            if(z==1) {
                //Insert search here
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("Brand done");
                clear();
            }
            else if(z==2){
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
        System.out.println("Case 13 Done");
    }
    //Check product filter "Document Sequence"
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
    //Check product filter "Active Products"
    public void Case16(){
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
    //Check product filter "Carried Products" MAY BUG DITO DI NAKIKITA MGA CARRIED PRODUCT
    public void Case17(){
        System.out.println("Testing Case 16");
        for(int z=1; z<=7; z++) {
            if(z==1) {
                carriedProd();
                //Insert search here
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("Carried Products done");
                clear();
            }
            else if(z==2){
                carriedProd();
                byShortName();
                clear();
            }
            else if(z==3){
                carriedProd();
                byItemCode();
                clear();
            }
            else if(z==4){
                activeProd();
                byDescription();
                clear();
            }
            else if(z==5){
                carriedProd();
                byBrand();
                clear();
            }
            else if(z==6){
                carriedProd();
                byKeyword();
                clear();
            }
            else if(z==7){
                carriedProd();
                byPrincipal();
                clear();
            }
        }
        System.out.println("Case 16 Done");
    }
    //Check product filter "Not Carried Products" MAY BUG DITO DI NAKIKITA UN NOT CARRIED PRODUCT
    public void Case18(){
        System.out.println("Testing Case 17");
        for(int z=1; z<=7; z++) {
            if(z==1) {
                notCarriedProd();
                //Insert search here
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("Not Carried Products done");
                clear();
            }
            else if(z==2){
                notCarriedProd();
                checkByShortName();
                //Click Search bar and search certain product by Name
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchShortName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchShortName.sendKeys("Red hot");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                clear();
            }
            else if(z==3){
                notCarriedProd();
                checkByItemCode();
                //Click Search bar and search certain product by Item Code
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchItemCode = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchItemCode.sendKeys("CHZZY15436324");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                clear();
            }
            else if(z==4){
                notCarriedProd();
                checkByDescription();
                //Click Search bar and search certain product by Description
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchDescription = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchDescription.sendKeys("chEezy");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                clear();
            }
            else if(z==5){
                notCarriedProd();
                checkByBrand();
                //Click Search bar and search certain product by Brand
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchBrand = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchBrand.sendKeys("CHEEZY");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                clear();
            }
            else if(z==6){
                notCarriedProd();
                checkByKeyword();
                //Click Search bar and search certain product by Keywords
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchKeyword = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchKeyword.sendKeys("CHIPS");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                clear();
            }
            else if(z==7){
                notCarriedProd();
                checkByPrincipal();
                //Click Search bar and search certain product by Principal
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchPrincipal = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchPrincipal.sendKeys("Leslie");
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                clear();
            }
        }
        System.out.println("Case 17 Done");
    }
    //Check "Summary Menu"
    public void Case19(){
        System.out.println("Testing Case 19");
        fdcSummaryMenu();
        driver.navigate().back();
        System.out.println("Case 19 Done");
    }
    //Check Summary "Inventory Location"
    public void Case20(){
        System.out.println("Testing Case 20");
        fdcSummaryMenu();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invenLoc = (MobileElement) driver.findElementById("com.engagia.android:id/menu_source_warehouse");
        invenLoc.click();
        driver.navigate().back();
        System.out.println("Case 20 Done");
    }
    //Check Summary "Add Inventory Location"
    public void Case21(){
        System.out.println("Testing Case 21");
        fdcSummaryMenu();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invenLoc = (MobileElement) driver.findElementById("com.engagia.android:id/menu_source_warehouse");
        invenLoc.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement addNewLoc = (MobileElement) driver.findElementById("android:id/button1");
        addNewLoc.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement addNewInvenLoc = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@text='Enter new inventory location here']");
        addNewInvenLoc.sendKeys("Abcdefgh");
        driver.hideKeyboard();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement saveBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='1' and @text='Save']");
        saveBtn.click();
        driver.navigate().back();
        System.out.println("Case 21 Done");
    }
    //Check Summary "Preview" Dapat sa pag tapos ng Finalize to. 3rd
    public void Case22(){
        System.out.println("Testing Case 22");
        preview();
        System.out.println("Case 22 Done");
    }
    //Check Summary "Clear" Bago mag finalize dapat ilagay to 1st
    public void Case23(){
        System.out.println("Testing Case 23");
        beginningInven();
        transferIn();
        clear();
        System.out.println("Case 23 Done");
    }
    //Check Summary "Finalize" Dapat sa last part to kasi may order 2nd
    public void Case24(){
        System.out.println("Testing Case 24");
        beginningInven();
        finalMthd();
        System.out.println("Case 24 Done");
    }
    //Check Summary "Finalize and Copy to Field Execution" sa last part din dapat to kasi may ordering din
    public void Case25(){
        System.out.println("Testing Case 23");
        beginningInven();
        for(int z=1; z<=2; z++){
            if(z==1){
                fdcSummaryMenu();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement fnlBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'txt_finalize_and_copy_to_field_execution') and @text='Finalize and Copy to Field Execution']");
                fnlBtn.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement cnclBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='Cancel']");
                cnclBtn.click();
                driver.navigate().back();
            }
            else if(z==2){
                finalizeCopy();
            }
        }
        System.out.println("Case 23 Done");
    }
    //Check Summary "Inventory Count Summary"
    public void Case26(){
        System.out.println("Testing Case 24");
//        SearcIC();
        inventoryCountSummary();
        System.out.println("Case 24 Done");
    }
    //Check table "Product Name"
    public void Case27(){
        System.out.println("Testing Case 43");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        MobileElement prod1 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']");
        prod1.click();
        driver.navigate().back();
    }
    //Check table "Unit" column
    public void Case28(){
        System.out.println("Testing Case 50");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            MobileElement unit = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.TextView[@index='1']");
            unit.click();

        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement element2 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        boolean isDisplayed2 = element2.isDisplayed();
        if (isDisplayed2) {
            MobileElement unit = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.TextView[@index='1']");
            unit.click();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement element3 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        boolean isDisplayed3 = element3.isDisplayed();
        if (isDisplayed3) {
            MobileElement unit = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.TextView[@index='1']");
            unit.click();
        }
    }
    //Check table "Beginning Inventory" column
    public void Case29(){
        System.out.println("Testing Case 25");
        beginningInven();
        System.out.println("Case 25 Done");
    }
    //Check table "Transfer In" column
    public void Case30(){
        System.out.println("Testing Case 26");
        swipeRight();
        transferIn();
        System.out.println("Case 26 Done");
    }
    //Check table "Transfer Out" column
    public void Case31(){
        System.out.println("Testing Case 27");
        swipeRight();
        transferOut();
        System.out.println("Case 27 Done");
    }
    //Check table "Stock Availability" column
    public void Case32(){
        System.out.println("Testing Case 28");
        swipeRight();
        for(int z=1; z<=3; z++){
            stockAvailability();
        }
        System.out.println("Case 28 Done");
    }
    //Check table "Stock Weight" column
    public void Case33(){
        System.out.println("Testing Case 29");
        swipeRight();
        for(int z=1; z<=3; z++){
            stockWeight();
        }
        clear();
        System.out.println("Case 29 Done");
    }
    //Check table expiry date "Action" column
    public void Case34(){
        System.out.println("Testing Case 30");
        swipeLeft();
        beginningInven();
        for(int z=1; z<=5; z++) {
            swipeRight();
        }
        addExpiryProd();
        System.out.println("Case 30 Done");
    }
    //Check table expiry date "View" column
    public void Case35(){
        System.out.println("Testing Case 31");
        swipeRight();
        viewExpiryProd(); //May bug pa to
        System.out.println("Case 31 Done");
    }
    //Check table manufactured date "Action" column
    public void Case36(){
        System.out.println("Testing Case 32");
        swipeRight();
        addManufactDate();
        System.out.println("Case 32 Done");
    }
    //Check table manufactured date "View" column
    public void Case37(){
        System.out.println("Testing Case 33");
        swipeRight();
        viewManufactDate();
        clear();
        System.out.println("Case 33 Done");
    }
    //Check filter "Information Filter" w/ ADD STOCK TRANSACTION
    public void Case38(){
        System.out.println("Testing Case 34");
//        addWithStock();
//        clear();
//        finalMthd();
        infoFilter();
        driver.navigate().back();
        driver.navigate().back();
        System.out.println("Case 34 Done");
    }
    //Check information filter "All Products"
    public void Case39(){
        System.out.println("Testing Case 35");
        SearcIC();
        for(int z=1; z<=7; z++) {
            infoFilterAllProd();
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
        System.out.println("Case 35 Done");
    }
    //Check information filter "Stock Availability: No Stock"
    public void Case40(){
        System.out.println("Testing Case 36");
        for(int z=1; z<=7; z++) {
            infoFilterNoStock();
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
        System.out.println("Case 36 Done");
    }
    //Check information filter "Stock Availability: With Stock"
    public void Case41(){
        System.out.println("Testing Case 37");
        for(int z=1; z<=7; z++) {
            if(z==1) {
                infoFilterWithStock();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchName.sendKeys(prodName);
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("All product done");
                clear();
            }
            else if(z==2){
                infoFilterWithStock();
                byShortName();
                clear();
            }
            else if(z==3){
                infoFilterWithStock();
                byItemCode();
                clear();
            }
            else if(z==4){
                infoFilterWithStock();
                byDescription();
                clear();
            }
            else if(z==5){
                infoFilterWithStock();
                byBrand();
                clear();
            }
            else if(z==6){
                infoFilterWithStock();
                byKeyword();
                clear();
            }
            else if(z==7){
                infoFilterWithStock();
                byPrincipal();
                clear();
            }
        }
        System.out.println("Case 37 Done");
    }
    //Check information filter "Stock Weight: Low"
    public void Case42(){
        System.out.println("Testing Case 38");
        for(int z=1; z<=7; z++) {
            if(z==1) {
                infoFilterStockWeightLow();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchName.sendKeys(prodName);
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("All product done");
                clear();
            }
            else if(z==2){
                infoFilterStockWeightLow();
                byShortName();
                clear();
            }
            else if(z==3){
                infoFilterStockWeightLow();
                byItemCode();
                clear();
            }
            else if(z==4){
                infoFilterStockWeightLow();
                byDescription();
                clear();
            }
            else if(z==5){
                infoFilterStockWeightLow();
                byBrand();
                clear();
            }
            else if(z==6){
                infoFilterStockWeightLow();
                byKeyword();
                clear();
            }
            else if(z==7){
                infoFilterStockWeightLow();
                byPrincipal();
                clear();
            }
        }
        System.out.println("Case 38 Done");
    }
    //Check information filter "Stock Weight: Medium"
    public void Case43(){
        System.out.println("Testing Case 39");
        for(int z=1; z<=7; z++) {
            if(z==1) {
                infoFilterStockWeightMed();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchName.sendKeys(prodName);
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("All product done");
                clear();
            }
            else if(z==2){
                infoFilterStockWeightMed();
                byShortName();
                clear();
            }
            else if(z==3){
                infoFilterStockWeightMed();
                byItemCode();
                clear();
            }
            else if(z==4){
                infoFilterStockWeightMed();
                byDescription();
                clear();
            }
            else if(z==5){
                infoFilterStockWeightMed();
                byBrand();
                clear();
            }
            else if(z==6){
                infoFilterStockWeightMed();
                byKeyword();
                clear();
            }
            else if(z==7){
                infoFilterStockWeightMed();
                byPrincipal();
                clear();
            }
        }
        System.out.println("Case 39 Done");
    }
    //Check information filter "Stock Weight: High"
    public void Case44(){
        System.out.println("Testing Case 40");
        for(int z=1; z<=7; z++) {
            if(z==1) {
                infoFilterStockWeightHi();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
                searchName.sendKeys(prodName);
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("All product done");
                clear();
            }
            else if(z==2){
                infoFilterStockWeightHi();
                byShortName();
                clear();
            }
            else if(z==3){
                infoFilterStockWeightHi();
                byItemCode();
                clear();
            }
            else if(z==4){
                infoFilterStockWeightHi();
                byDescription();
                clear();
            }
            else if(z==5){
                infoFilterStockWeightHi();
                byBrand();
                clear();
            }
            else if(z==6){
                infoFilterStockWeightHi();
                byKeyword();
                clear();
            }
            else if(z==7){
                infoFilterStockWeightHi();
                byPrincipal();
                clear();
            }
        }
        System.out.println("Case 40 Done");
    }
    //Check Previous data inputted by "Date" Magkaiba ng calendar un device?
    public void Case45(){
        System.out.println("Testing Case 46");
        MobileElement dateInventTrans = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']");
        dateInventTrans.click();
        MobileElement dateLeft = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'prev')]");
        dateLeft.click();
        MobileElement dayNumber = (MobileElement) driver.findElementByXPath("//android.view.View[@text='1' and @index='0']");
        dayNumber.click();
        driver.navigate().back();
    }
    //Check "Table View" (For viewing checking only.. ?)
    public void Case46(){

    }


    //Check "Product Summary"
    public void Case47(){
        System.out.println("Testing Case 44");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        MobileElement prod1 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']");
        prod1.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        MobileElement arrowRight = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'ic_pager_next')]");
        arrowRight.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        MobileElement arrowLeft = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'ic_pager_previous')]");
        arrowLeft.click();
        driver.navigate().back();
    }


    //Functions
    public void SearcIC(){
        //click Hamburger Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement HamburgerBtn = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
        HamburgerBtn.click();
        //search Inventory Count
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/edit_text_search");
        searchField.sendKeys(search);
        //click search result
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckRes = (MobileElement) driver.findElementByAccessibilityId("Inventory Count");
        clckRes.click();
    }
    public void icLogInToVisit(){
        for (int x = 4; x <=4; x++) {
            //Click on Drawer
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement drawerOpen = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
            drawerOpen.click();
            //Click on Arrow down btn
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement clckArrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/image_visit_dropdown");
            clckArrowDown.click();
            searchBranch();
            //Click on branch depends on index or int of the loop
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            MobileElement clckOnBranch = (MobileElement) driver.findElementByXPath(branchListDrctry + "/android.widget.RelativeLayout[" + x + "]");
            clckOnBranch.click();
            System.out.println(x);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement confirmBtn = (MobileElement) driver.findElementById("android:id/button1");
            confirmBtn.click();
            //click on Ok
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
            okBtn.click();

            //Search
            SearcIC();
            //Cases functions

//            Case2();
//            Case3();
//            Case4();
//            Case6();
//            Case7();
//            Case8();
//            Case9();
//            //FILTER
//            Case10();
//            Case11();
//            Case12();
//            Case13();
//            Case14();
//            Case15();
//            Case16();
//////            Case17(); May bug dito d nakikita mga carried products na uploaded sa EMS
//////            Case18();//MAY BUG  YATA? POTA Iba yun output ng EMS sa APP ng Not Carried Proudcts
//            Case19();
//            Case20();
//            Case21();
//            Case26();
//            Case27();
////            //Transaction functions
//            Case28();
//            Case29();
//            Case30();
//            Case31();
//            Case32();
//            Case33();
//            Case34();
//            Case35();
//            Case36();
//            Case37();

            Case23();// Bago mag finalize dapat to 1st
            Case24();// Dapat sa last part to kasi may order 2nd
//            Case25();
            SearcIC();
            Case22();// Pagtapos dapat to ng finalize para makikita mga summary. 3rd
            //INSERT TRANSACTION HERE WITH LOW MED HIGH W/ STOCK
//            //FILTER ULIT? need gumawa ng  transaction na may low med high no stock and w/ stock
            Case38();
            Case39();
            Case40();;// need ng walang stock product
            Case41();
            Case42();
            Case43();
            Case44();
            //Click on Drawer to logout to visit
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement drawerOpen2 = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
            drawerOpen2.click();
            swipeUp();
            System.out.println("Branch " +x+ " done!");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            clckArrowDown.click();
            //Log out
            MobileElement logoutBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_visit_logout");
            logoutBtn.click();
        }
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
    //For Cases functions
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
    public void shortNameNoFilter(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckShortName = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Short Name']");
        clckShortName.click();
        System.out.println("Searching by Short Name");
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='No Filter']");
        noFilBtn.click();
        //Click Search bar and search certain product by Name
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchShortName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchShortName.sendKeys(prodShortName[rand(prodShortName.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
    }
    public void itemCodeNoFilter(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckItemCode = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Item Code']");
        clckItemCode.click();
        System.out.println("Searching by Item Code");
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='No Filter']");
        noFilBtn.click();
        //Click Search bar and search certain product by Item Code
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchItemCode = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchItemCode.sendKeys(prodItemCode[rand(prodItemCode.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
    }
    public void barcodeNoFilter(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckBarcode = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Barcode']");
        clckBarcode.click();
        System.out.println("Searching by Barcode");
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='No Filter']");
        noFilBtn.click();
        //Click Search bar and search certain product by Barcode
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBarcode = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchBarcode.sendKeys(prodBarcode[rand(prodBarcode.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
    }
    public void descriptionNoFilter(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckDescription = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Description']");
        clckDescription.click();
        System.out.println("Searching by Description");
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='No Filter']");
        noFilBtn.click();
        //Click Search bar and search certain product by Description
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchDescription = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchDescription.sendKeys(prodDescription[rand(prodDescription.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
    }
    public void brandNoFilter(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckBrand = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Brand']");
        clckBrand.click();
        System.out.println("Searching by Brand");
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='No Filter']");
        noFilBtn.click();
        //Click Search bar and search certain product by Brand
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBrand = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchBrand.sendKeys(prodBrand[rand(prodBrand.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
    }
    public void keywordNoFilter(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckKeyword = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Keyword']");
        clckKeyword.click();
        System.out.println("Searching by Keyword");
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='No Filter']");
        noFilBtn.click();
        //Click Search bar and search certain product by Keywords
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchKeyword = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchKeyword.sendKeys(prodKeyword[rand(prodKeyword.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
    }
    public void principalNoFilter(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckKeyword = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Principal']");
        clckKeyword.click();
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='No Filter']");
        noFilBtn.click();
        System.out.println("Searching by Principal");
        //Click Search bar and search certain product by Principal
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchPrincipal = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchPrincipal.sendKeys(prodPrincipal[rand(prodPrincipal.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
    }
    public void noFilter(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowBtn.click();
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noFilBtn = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.CheckedTextView[1]");
        noFilBtn.click();
        System.out.println("Filter by No Filter");
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
            MobileElement prodFilBtn = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.CheckedTextView[2]");
            prodFilBtn.click();
        }
        System.out.println("Filter by Product Filter");
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
        mustCarry.click();
        System.out.println("Product Filter by Must Carry");
    }
    public void brand(){
        productFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement brandFilBtn = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[4]");
        brandFilBtn.click();
        MobileElement brand = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='0']");
        brand.click();
        System.out.println("Product Filter by Brand");
    }
    public void docuSequence(){
        productFilter();
        //Filter by btn
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement docSeqFilBtn = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[5]");
        docSeqFilBtn.click();
        MobileElement docSeq = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='0']");
        docSeq.click();
        System.out.println("Product Filter by Document Sequence");
    }
    public void activeProd(){
        productFilter();
        //Filter by btn
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement activeProdFilBtn = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[6]");
        activeProdFilBtn.click();
        System.out.println("Product Filter by Active Product");
    }
    public void carriedProd(){
        productFilter();
        //Filter by btn
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement carriedProdFilBtn = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[7]");
        carriedProdFilBtn.click();
        System.out.println("Product Filter by Carried Product");
    }
    public void notCarriedProd(){
        productFilter();
        //Filter by btn
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement notCarriedProdFilBtn = (MobileElement) driver.findElementByXPath(productFilterByDrctry+"/android.widget.TextView[8]");
        notCarriedProdFilBtn.click();
        System.out.println("Product Filter by Not Carried Product");
    }
    public void infoFilter(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowBtn.click();
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement infoFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.ListView[2]/android.widget.CheckedTextView[3]");
        infoFilBtn.click();
        System.out.println("Filter by Information Filter");
    }
    public void infoFilterAllProd(){
        infoFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allProd = (MobileElement) driver.findElementByXPath("//android.widget.TextView[1]");
        allProd.click();
        System.out.println("Info Filter by All products");
    }
    public void infoFilterNoStock(){
        infoFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allProd = (MobileElement) driver.findElementByXPath("//android.widget.TextView[2]");
        allProd.click();
        System.out.println("Info Filter by No Stock");
    }
    public void infoFilterWithStock(){
        infoFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allProd = (MobileElement) driver.findElementByXPath("//android.widget.TextView[3]");
        allProd.click();
        System.out.println("Info Filter by With Stock");
    }
    public void infoFilterStockWeightLow(){
        infoFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allProd = (MobileElement) driver.findElementByXPath("//android.widget.TextView[4]");
        allProd.click();
        System.out.println("Info Filter by Stock Weight Low");
    }
    public void infoFilterStockWeightMed(){
        infoFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allProd = (MobileElement) driver.findElementByXPath("//android.widget.TextView[5]");
        allProd.click();
        System.out.println("Info Filter by Stock Weight Med");
    }
    public void infoFilterStockWeightHi(){
        infoFilter();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allProd = (MobileElement) driver.findElementByXPath("//android.widget.TextView[6]");
        allProd.click();
        System.out.println("Info Filter by Stock Weight High");
    }
    public void clear(){
        fdcSummaryMenu();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clrBtn = (MobileElement) driver.findElementById("com.engagia.android:id/txt_clear_all_btn");
        clrBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement contBtn = (MobileElement) driver.findElementById("android:id/button1");
        contBtn.click();
    }
    public void finalMthd(){
        fdcSummaryMenu();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement fnlBtn = (MobileElement) driver.findElementById("com.engagia.android:id/txt_finalize_btn");
        fnlBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement contBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Continue']");
        contBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement okBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
        okBtn.click();
        //Pwedeng palitan ng NO OR UPLOAD ALL VV
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement yesBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Yes']");
        yesBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement closeBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Close']");
        closeBtn.click();
    }
    //Finalize and Copy to Field Execution
    public void finalizeCopy(){
        fdcSummaryMenu();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement fnlBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'txt_finalize_and_copy_to_field_execution') and @text='Finalize and Copy to Field Execution']");
        fnlBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement contBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Continue']");
        contBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement formField = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'spinner_form') and @index='0']");
        formField.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement formFieldChoice = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='1']");
        formFieldChoice.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement proGrpField = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'spinner_product_group') and @index='1']");
        proGrpField.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement proGrpFieldChoice = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='1']");
        proGrpFieldChoice.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement elemField = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'spinner_element') and @index='2']");
        elemField.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement elemFieldChoice = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='1']");
        elemFieldChoice.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement radioBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[contains(@resource-id,'rb_product_with_inventory_count') and @index='4']");
        radioBtn1.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement radioBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[contains(@resource-id,'rb_product_without_inventory_count') and @index='5']");
        radioBtn2.click();
        //Save
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement saveBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'menu_save') and @text='SAVE']");
        saveBtn.click();
        //YEs
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement yesBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Yes']");
        yesBtn1.click();
        //Ok
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement okBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
        okBtn.click();
        //Pwedeng palitan ng NO OR UPLOAD ALL VV
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement yesBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Yes']");
        yesBtn2.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement closeBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Close']");
        closeBtn.click();
    }
    public void preview(){
        fdcSummaryMenu();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement previewBtn = (MobileElement) driver.findElementById("com.engagia.android:id/txt_preview_btn");
        previewBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement closeBtn = (MobileElement) driver.findElementById("android:id/button1");
        closeBtn.click();
        driver.navigate().back();
    }
    public void inventoryCountSummary(){
        fdcSummaryMenu();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement previewBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text_view_ic_summary') and @text='Inventory Count Summary']");
        previewBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement icSumRow = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView[@index='1']");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(icSumRow)).withDuration(Duration.ofMillis(1000))).release().perform();
        MobileElement icSumProd = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView[@index='1']");
        boolean isDisplayed1 =  icSumProd.isDisplayed();
        if(isDisplayed1){
            driver.navigate().back();
            System.out.println("IC Summary Products displayed");
        }
        driver.navigate().back();
        driver.navigate().back();
    }
    public void fdcSummaryMenu(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement threeDots = (MobileElement) driver.findElementByAccessibilityId("Fdc_menu");
        threeDots.click();
    }
    public void beginningInven(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Product 1
        //Enter Value on Order Inventory
        MobileElement invenPC1 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']");
        invenPC1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Enter random numbers
        randomNum();
        System.out.println("Inventory pc 1 done");
        //Click ok
        MobileElement clckOk1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk1.click();
        //Box
        //Enter Value on Order Inventory
        MobileElement invenBox1 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']");
        invenBox1.click();
        //Enter value
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Enter random numbers
        randomNum();
        System.out.println("Inventory box 1 done");
        //Click ok
        MobileElement clckOk2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk2.click();
        //Product 2
        //Enter Value on Order Inventory
        MobileElement invenPC2 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']");
        invenPC2.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Enter random numbers
        randomNum();
        System.out.println("Inventory pc 2 done");
        //Click ok
        MobileElement clckOk3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk3.click();
        //Box
        //Enter Value on Order Inventory
        MobileElement invenBox2 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']");
        invenBox2.click();
        //Enter value here
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Enter random numbers
        randomNum();
        System.out.println("Inventory box 2 done");
        //Click ok
        MobileElement clckOk4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk4.click();
    }
    public void transferIn(){
        //FIRST PRODUCT!
        //PER PC
        //Enter Value on Trade Inventory
        MobileElement transferInPC1 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='0']");
        transferInPC1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Enter random numbers
        randomNum();
        System.out.println("Transfer In pc 1 done");
        //Click ok
        MobileElement clckOk1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk1.click();
        //PER BOX
        //Enter Value on Trade Inventory
        MobileElement transferInBox1 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='1']");
        transferInBox1.click();
        //Enter value here
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Enter random numbers
        randomNum();
        System.out.println("Transfer In box 1 done");
        //Click ok
        MobileElement clckOk2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk2.click();
        //SECOND PRODUCT!
        //PER PC
        //Enter Value on Trade Inventory
        MobileElement transferInPC2 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='0']");
        transferInPC2.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Enter random numbers
        randomNum();
        System.out.println("Transfer In pc 2 done");
        //Click ok
        MobileElement clckOk3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk3.click();
        //PER BOX
        //Enter Value on Trade Inventory
        MobileElement transferInBox2 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='1']");
        transferInBox2.click();
        //Enter value here
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Enter random numbers
        randomNum();
        System.out.println("Transfer In box 2 done");
        //Click ok
        MobileElement clckOk4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk4.click();
    }
    public void transferOut(){
        //FIRST PRODUCT!
        //PER PC
        //Enter Value on Transfer Out
        MobileElement transferOutPC1 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='0']");
        transferOutPC1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Enter random numbers
        randomNum();
        System.out.println("Transfer Out pc 1 done");
        //Click ok
        MobileElement clckOk1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk1.click();
        //PER BOX
        //Enter Value on Transfer Out
        MobileElement transferOutBox1 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='1']");
        transferOutBox1.click();
        //Enter value here
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Enter random numbers
        randomNum();
        System.out.println("Transfer Out box 1 done");
        //Click ok
        MobileElement clckOk2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk2.click();
        //SECOND PRODUCT!
        //PER PC
        //Enter Value on Transfer Out
        MobileElement transferOutPC2 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='0']");
        transferOutPC2.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Enter random numbers
        randomNum();
        System.out.println("Transfer In pc 2 done");
        //Click ok
        MobileElement clckOk3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk3.click();
        //PER BOX
        //Enter Value on Transfer Out
        MobileElement transferOutBox2 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='1']");
        transferOutBox2.click();
        //Enter value here
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Enter random numbers
        randomNum();
        System.out.println("Transfer In box 2 done");
        //Click ok
        MobileElement clckOk4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk4.click();
    }
    public void stockAvailability(){
        MobileElement stockAvail1 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='3']");
        stockAvail1.click();
        MobileElement stockAvail2 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='3']");
        stockAvail2.click();
    }
    public void stockWeight(){
        MobileElement stockWeight1 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='4']");
        stockWeight1.click();
        MobileElement stockWeight2 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='4']");
        stockWeight2.click();
    }
    public void addExpiryProd(){
        //PER PC
        //Click Add Expiry
        MobileElement addExpProdPC1 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='5']" +
                "/android.widget.LinearLayout[@index='0']");
        addExpProdPC1.click();
        System.out.println("Click Add Expiry on PC");
        MobileElement monthDownBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='0']"+
                "/android.widget.Button[@index = '2']");
        monthDownBtn1.click();
        MobileElement dayDownBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='1']"+
                "/android.widget.Button[@index = '2']");
        dayDownBtn1.click();
        MobileElement yearDownBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='2']"+
                "/android.widget.Button[@index = '2']");
        yearDownBtn1.click();
        //Click on TextField
        MobileElement addField1 = (MobileElement) driver.findElementById("com.engagia.android:id/text_inventory");
        addField1.click();
        //Enter one
        MobileElement clckNO1 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_1");
        clckNO1.click();
        //Click ok
        MobileElement clckOk1 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
        clckOk1.click();
        MobileElement goBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index = '1' and @text='Go']");
        goBtn1.click();
        //PER BOX
        //Click Add Expiry
        MobileElement addExpProdBox1 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='5']" +
                "/android.widget.LinearLayout[@index='1']");
        addExpProdBox1.click();
        System.out.println("Click Add Expiry on Box");
        MobileElement monthDownBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='0']"+
                "/android.widget.Button[@index = '2']");
        monthDownBtn2.click();
        MobileElement dayDownBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='1']"+
                "/android.widget.Button[@index = '2']");
        dayDownBtn2.click();
        MobileElement yearDownBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='2']"+
                "/android.widget.Button[@index = '2']");
        yearDownBtn2.click();
        //Click on TextField
        MobileElement addField2 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index = '0']");
        addField2.click();
        //Enter one
        MobileElement clckNO2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_1') and @index = '0']");
        clckNO2.click();
        //Click ok
        MobileElement clckOk2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk2.click();
        MobileElement goBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index = '1' and @text='Go']");
        goBtn2.click();
        //PER PC
        //Click Add Expiry
        MobileElement addExpProdPC2 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='5']" +
                "/android.widget.LinearLayout[@index='0']");
        addExpProdPC2.click();
        System.out.println("Click Add Expiry on PC");
        MobileElement monthDownBtn3 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='0']"+
                "/android.widget.Button[@index = '2']");
        monthDownBtn3.click();
        MobileElement dayDownBtn3 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='1']"+
                "/android.widget.Button[@index = '2']");
        dayDownBtn3.click();
        MobileElement yearDownBtn3 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='2']"+
                "/android.widget.Button[@index = '2']");
        yearDownBtn3.click();
        //Click on TextField
        MobileElement addField3 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index = '0']");
        addField3.click();
        //Enter one
        MobileElement clckNO3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_1') and @index = '0']");
        clckNO3.click();
        //Click ok
        MobileElement clckOk3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk3.click();
        MobileElement goBtn3 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index = '1' and @text='Go']");
        goBtn3.click();
        //PER BOX
        //Click Add Expiry
        MobileElement addExpProdBox2 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='5']" +
                "/android.widget.LinearLayout[@index='1']");
        addExpProdBox2.click();
        System.out.println("Click Add Expiry on Box");
        MobileElement monthDownBtn4 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='0']"+
                "/android.widget.Button[@index = '2']");
        monthDownBtn4.click();
        MobileElement dayDownBtn4 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='1']"+
                "/android.widget.Button[@index = '2']");
        dayDownBtn4.click();
        MobileElement yearDownBtn4 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='2']"+
                "/android.widget.Button[@index = '2']");
        yearDownBtn4.click();
        //Click on TextField
        MobileElement addField4 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index = '0']");
        addField4.click();
        //Enter one
        MobileElement clckNO4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_1') and @index = '0']");
        clckNO4.click();
        //Click ok
        MobileElement clckOk4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk4.click();
        MobileElement goBtn4 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index = '1' and @text='Go']");
        goBtn4.click();
    }
    public void viewExpiryProd(){
        MobileElement viewExpPro1 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='6']");
        viewExpPro1.click();
//        MobileElement removeBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index = '0']"+
//                "/android.widget.ImageButton[@index='2']");
        MobileElement removeBtn1B = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.ImageButton");
        removeBtn1B.click();
        MobileElement removeBtn1A = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.ImageButton");
        removeBtn1A.click();
        MobileElement viewExpPro2 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='6']");
        viewExpPro2.click();
//        MobileElement removeBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index = '0']"+
//                "/android.widget.ImageButton[@index='2']");
//        removeBtn2.click();
        MobileElement removeBtn2B = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.ImageButton");
        removeBtn2B.click();
        MobileElement removeBtn2A = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.ImageButton");
        removeBtn2A.click();

    }
    public void addManufactDate(){
        //PER PC
        //Click Add Manucatured Date
        MobileElement transferOutPC1 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='7']" +
                "/android.widget.LinearLayout[@index='0']");
        transferOutPC1.click();
        System.out.println("Click Add Manucatured Date on PC");
        MobileElement monthUpBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[1]/android.widget.Button[1]");
        monthUpBtn1.click();
        MobileElement dayUpBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[2]/android.widget.Button[1]");
        dayUpBtn1.click();
        MobileElement yearUpBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[3]/android.widget.Button[1]");
        yearUpBtn1.click();
        //Click on TextField
        MobileElement addField1 = (MobileElement) driver.findElementById("com.engagia.android:id/text_inventory");
        addField1.click();
        //Enter one
        MobileElement clckNO1 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_1");
        clckNO1.click();
        //Click ok
        MobileElement clckOk1 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
        clckOk1.click();
        MobileElement goBtn1 = (MobileElement) driver.findElementById("android:id/button1");
        goBtn1.click();
        //PER BOX
        //Click Add Expiry
        MobileElement transferOutBox1 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='7']" +
                "/android.widget.LinearLayout[@index='1']");
        transferOutBox1.click();
        System.out.println("Click Add Manucatured Date on Box");
        MobileElement monthUpBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[1]/android.widget.Button[1]");
        monthUpBtn2.click();
        MobileElement dayUpBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[2]/android.widget.Button[1]");
        dayUpBtn2.click();
        MobileElement yearUpBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[3]/android.widget.Button[1]");
        yearUpBtn2.click();
        //Click on TextField
        MobileElement addField2 = (MobileElement) driver.findElementById("com.engagia.android:id/text_inventory");
        addField2.click();
        //Enter one
        MobileElement clckNO2 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_1");
        clckNO2.click();
        //Click ok
        MobileElement clckOk2 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
        clckOk2.click();
        MobileElement goBtn2 = (MobileElement) driver.findElementById("android:id/button1");
        goBtn2.click();
        //PER PC
        //Click Add Expiry
        MobileElement transferOutPC2 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='7']" +
                "/android.widget.LinearLayout[@index='0']");
        transferOutPC2.click();
        System.out.println("Click Add Manucatured Date on PC");
        MobileElement monthDownBtn3 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='0']"+
                "/android.widget.Button[@index = '2']");
        monthDownBtn3.click();
        MobileElement dayDownBtn3 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='1']"+
                "/android.widget.Button[@index = '2']");
        dayDownBtn3.click();
        MobileElement yearDownBtn3 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='2']"+
                "/android.widget.Button[@index = '2']");
        yearDownBtn3.click();
        //Click on TextField
        MobileElement addField3 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index = '0']");
        addField3.click();
        //Enter one
        MobileElement clckNO3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_1') and @index = '0']");
        clckNO3.click();
        //Click ok
        MobileElement clckOk3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk3.click();
        MobileElement goBtn3 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index = '1' and @text='Go']");
        goBtn3.click();
        //PER BOX
        //Click Add Expiry
        MobileElement transferOutBox2 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='7']" +
                "/android.widget.LinearLayout[@index='1']");
        transferOutBox2.click();
        System.out.println("Click Add Manucatured Date on Box");
        MobileElement monthDownBtn4 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='0']"+
                "/android.widget.Button[@index = '2']");
        monthDownBtn4.click();
        MobileElement dayDownBtn4 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='1']"+
                "/android.widget.Button[@index = '2']");
        dayDownBtn4.click();
        MobileElement yearDownBtn4 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='2']"+
                "/android.widget.Button[@index = '2']");
        yearDownBtn4.click();
        //Click on TextField
        MobileElement addField4 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index = '0']");
        addField4.click();
        //Enter one
        MobileElement clckNO4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_1') and @index = '0']");
        clckNO4.click();
        //Click ok
        MobileElement clckOk4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk4.click();
        MobileElement goBtn4 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index = '1' and @text='Go']");
        goBtn4.click();
    }
    public void viewManufactDate(){
        MobileElement stockWeight1 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='8']");
        stockWeight1.click();
        MobileElement removeBtn1B = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.ImageButton");
        removeBtn1B.click();
        MobileElement removeBtn1A = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.ImageButton");
        removeBtn1A.click();
        MobileElement stockWeight2 = (MobileElement) driver.findElementByXPath(invenDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='8']");
        stockWeight2.click();
        MobileElement removeBtn2B = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.ImageButton");
        removeBtn2B.click();
        MobileElement removeBtn2A = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.ImageButton");
        removeBtn2A.click();
    }
    public void addWithStock(){
        for(int z = 1; z<=6; z++) {
            if(z==1 || z==4) {
                swipeLeft();
                //low weight
                beginningInven();
                swipeRight();
                transferIn();
                swipeRight();
                transferOut();
                //isDisplayed Script for Case29 updated IC SCRIPT
//                swipeRight();
//                MobileElement noStockTxt = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text = 'With Stock']");
//                boolean isDisplayed1 = noStockTxt.isDisplayed();
//                if (isDisplayed1) {
//                    System.out.println("With Stock Displayed");
//                }
//                swipeRight();
                swipeRight();
                swipeRight();
                stockWeight();
                swipeRight();
                addExpiryProd();
                swipeRight();
                swipeRight();
                addManufactDate();
                //Nxt page
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                try {
                    MobileElement page = (MobileElement) driver.findElementById("com.engagia.android:id/custom_table_next_pagination"); //trying this
                    if (page != null) {
                        //NXT PAGE
                        MobileElement nxtPage = (MobileElement) driver.findElementById("com.engagia.android:id/custom_table_next_pagination");
                        nxtPage.click();
                        System.out.println("Next Page");
                    } else {
                        System.out.println("STAPH");
                        break;
                    }
                }
                catch (NoSuchElementException e){
                    System.out.println("Save");
                    break;
                }
            }
            else if(z==2 || z==5){
                //swipe left
                swipeLeft();
                //medium weight
                beginningInven();
                swipeRight();
                transferIn();
                swipeRight();
                transferOut();
                swipeRight();
                swipeRight();
                for(int y = 1; y <=3; y++) {
                    stockWeight();
                }
                swipeRight();
                addExpiryProd();
                swipeRight();
                swipeRight();
                addManufactDate();
                //Nxt Page
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                try {
                    MobileElement page = (MobileElement) driver.findElementById("com.engagia.android:id/custom_table_next_pagination");
                    if (page != null) {
                        //NXT PAGE
                        MobileElement nxtPage = (MobileElement) driver.findElementById("com.engagia.android:id/custom_table_next_pagination");
                        nxtPage.click();
                        System.out.println("Next Page");
                    } else {
                        System.out.println("STAPH");
                        break;
                    }
                }
                catch (NoSuchElementException e){
                    System.out.println("Save");
                    break;
                }
            }
            else if(z==3 || z==6){
                //Swipe Left
                swipeLeft();
                //high weight
                beginningInven();
                swipeRight();
                transferIn();
                swipeRight();
                transferOut();
                swipeRight();
                swipeRight();
                for(int y = 1; y <=3; y++) {
                    stockWeight();
                }
                swipeRight();
                addExpiryProd();
                swipeRight();
                swipeRight();
                addManufactDate();
                //Nxt Page
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                try {
                    MobileElement page = (MobileElement) driver.findElementById("com.engagia.android:id/custom_table_next_pagination");
                    if (page != null) {
                        //NXT PAGE
                        MobileElement nxtPage = (MobileElement) driver.findElementById("com.engagia.android:id/custom_table_next_pagination");
                        nxtPage.click();
                        System.out.println("Next Page");
                    } else {
                        System.out.println("STAPH");
                        break;
                    }
                }
                catch (NoSuchElementException e){
                    System.out.println("Save");
                    break;
                }
            }
        }
    }
    public void addWithoutStock(){
        for (int x = 1; x <= 4; x++) {
            swipeRight();
        }
        stockAvailability();
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
    public void swipeLeft(){
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
            touchAction.press(new PointOption().withCoordinates(x2, 300)).moveTo(new PointOption().withCoordinates(x1, 300)).release().perform();
        }
    }
    public void randomNum(){
        switch(rand(9 ) + 1){
            case 1: MobileElement clckNO1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_1') and @index = '0']"); clckNO1.click();
                System.out.println("Entered value: 1");
                break;
            case 2: MobileElement clckNO2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_2') and @index = '1']"); clckNO2.click();
                System.out.println("Entered value: 2");
                break;
            case 3: MobileElement clckNO3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_3') and @index = '2']"); clckNO3.click();
                System.out.println("Entered value: 3");
                break;
            case 4: MobileElement clckNO4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_4') and @index = '0']"); clckNO4.click();
                System.out.println("Entered value: 4");
                break;
            case 5: MobileElement clckNO5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_5') and @index = '1']"); clckNO5.click();
                System.out.println("Entered value: 5");
                break;
            case 6: MobileElement clckNO6 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_6') and @index = '2']"); clckNO6.click();
                System.out.println("Entered value: 6");
                break;
            case 7: MobileElement clckNO7 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_7') and @index = '0']"); clckNO7.click();
                System.out.println("Entered value: 7");
                break;
            case 8: MobileElement clckNO8 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_8') and @index = '1']"); clckNO8.click();
                System.out.println("Entered value: 8");
                break;
            case 9: MobileElement clckNO9 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_9') and @index = '2']"); clckNO9.click();
                System.out.println("Entered value: 9");
                break;
        }
    }
    private static int rand(int bound) {
        return (int) (Math.random() * bound);
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
    public void searchBranch(){
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        MobileElement searchBar = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_search') and @text='Search branch']");
        searchBar.sendKeys(branch);
        driver.hideKeyboard();
    }
}
