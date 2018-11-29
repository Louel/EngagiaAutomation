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
import java.util.List;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;

public class IC {

    AppiumDriver driver;
    String search = "Inventory Cou";
    String [] randomText = {"zczxczxc","12331231","Abbbccde","Abcde!@#","1a2b3c","A1B1C1", "random" , "somerandomtxt", "randomtxtsome" , "randomsometxt"};
    String prodName = "soDa";
    String pgName = "tAste";
    String mustCarryProd = "cOc";
    String [] prodShortName = {"Clover", "CHIPS AHOY", "LUCKY STRIKE RED" };
    String [] prodItemCode = {"51232232", "51232233", "51232234"};
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
        driver = new AppiumDriver(new URL("http://192.168.1.33:4723/wd/hub"), capabilities);
    }

    @Test
    public void testIC(){
        icLogInToVisit();
    }
    //Case Functions
    //Check Search by "Name"
    public void Case1(){
        //Click Search bar and search certain product by Name
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchName.sendKeys(prodName);
//        driver.hideKeyboard();
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
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
    public void Case2(){
        byShortName();
        clear();
    }
    //Check Search by "Item Code"
    public void Case3(){
        byItemCode();
        clear();
    }
    //Check Search by "Barcode"
    //Lumalabas un camera for bar code
    public void Case4(){
        byBarcode();
        clear();
    }
    //Check Search by "Description"
    public void Case5(){
        byDescription();
        clear();
    }
    //Check Search by "Brand"
    public void Case6(){
        byBrand();
        clear();
    }
    //Check Search by "Keywords"
    public void Case7(){
        byKeyword();
        clear();
    }
    //Check Search by "Principal"
    public void Case8(){
        byPrincipal();
        clear();
    }
    //Check filter "No Filter"
    public void Case9(){
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
    }
    //Check product filter "All Product"
    public void Case10(){
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
    }
    //Check product filter "Product Group"
    public void Case11(){
        for(int z=1; z<=7; z++) {
            if(z==1) {
                prodGroup();
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
                prodGroup();
                byShortName();
                clear();
            }
            else if(z==3){
                prodGroup();
                byItemCode();
                clear();
            }
            else if(z==4){
                prodGroup();
                byDescription();
                clear();
            }
            else if(z==5){
                prodGroup();
                byBrand();
                clear();
            }
            else if(z==6){
                prodGroup();
                byKeyword();
                clear();
            }
            else if(z==7){
                prodGroup();
                byPrincipal();
                clear();
            }
        }
    }
    //Check product filter "Must Carry Per Account Classification"
    public void Case12(){
        for(int z=1; z<=7; z++) {
            if(z==1) {
                mustCarry();
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
                mustCarry();
                byShortName();
                clear();
            }
            else if(z==3){
                mustCarry();
                byItemCode();
                clear();
            }
            else if(z==4){
                mustCarry();
                byDescription();
                clear();
            }
            else if(z==5){
                mustCarry();
                byBrand();
                clear();
            }
            else if(z==6){
                mustCarry();
                byKeyword();
                clear();
            }
            else if(z==7){
                mustCarry();
                byPrincipal();
                clear();
            }
        }

    }
    //Check product filter "Brand"
    public void Case13(){
        for(int z=1; z<=7; z++) {
            if(z==1) {
                brand();
                //Insert search here
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("Brand done");
                clear();
            }
            else if(z==2){
                brand();
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
                brand();
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
                brand();
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
                brand();
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
                brand();
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
                brand();
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

    }
    //Check product filter "Document Sequence"
    public void Case14(){
        for(int z=1; z<=7; z++) {
            if(z==1) {
                docuSequence();
                //Insert search here
                //Click Magnifying Glass Icon
                MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
                searchBtn.click();
                System.out.println("Document Sequence done");
                clear();
            }
            else if(z==2){
                docuSequence();
                byShortName();
                clear();
            }
            else if(z==3){
                docuSequence();
                byItemCode();
                clear();
            }
            else if(z==4){
                docuSequence();
                byDescription();
                clear();
            }
            else if(z==5){
                docuSequence();
                byBrand();
                clear();
            }
            else if(z==6){
                docuSequence();
                byKeyword();
                clear();
            }
            else if(z==7){
                docuSequence();
                byPrincipal();
                clear();
            }
        }

    }
    //Check product filter "Active Products"
    public void Case15(){
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

    }
    //Check product filter "Carried Products"
    public void Case16(){
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

    }
    //Check product filter "Not Carried Products"
    public void Case17(){
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

    }
    //Check Summary "Inventory Location"
    public void Case18(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement threeDots = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'fdc_menu')]");
        threeDots.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invenLoc = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'menu_source_warehouse')]");
        invenLoc.click();
    }
    //Check Summary "Add Inventory Location"
    public void Case19(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement threeDots = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'fdc_menu')]");
        threeDots.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invenLoc = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'menu_source_warehouse')]");
        invenLoc.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement addNewLoc = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='ADD NEW LOCATION']");
        addNewLoc.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement addNewInvenLoc = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@text='Enter new inventory location here']");
        addNewInvenLoc.sendKeys("Abcdefgh");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement saveBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='1' and @text='Save']");
        saveBtn.click();
    }
    //Check Summary "Preview"
    public void Case20(){
        preview();
    }
    //Check Summary "Clear"
    public void Case21(){
        beginningInven();
        transferIn();
        clear();
    }
    //TODO Check Summary "Finalize"
    public void Case22(){
        beginningInven();
        transferIn();
        finalMthd();
    }
    //Check Summary "Finalize and Copy to Field Execution"
    public void Case23(){
        beginningInven();
        clear();
    }
    public void Case24(){

    }
    //Functions
    public void SearcIC(){
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
    public void icLogInToVisit(){
        for (int x = 2; x <=2; x++) {
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            //CLick on drawer
            MobileElement sideBarBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
            sideBarBtn.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //click arrow down
            MobileElement loginVisitBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'image_visit_dropdown') and @index = '3']");
            loginVisitBtn.click();
            //branch list
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            //Time to load
            List<MobileElement> logBtn = (List<MobileElement>) driver.findElementsByClassName("android.widget.RelativeLayout");
            logBtn.get(x).click();
            System.out.println(x);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            MobileElement cntBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
            cntBtn.click();
            //click on Ok
            //should have wait here atleast 20 secs
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            MobileElement cntBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
            cntBtn1.click();
            //Search
            SearcIC();
            //Cases functions
//            Case1();
//            Case2();
//            Case3();
//            Case5();
//            Case6();
//            Case7();
//            Case8();
//            Case9();
//            Case10();
//            Case11();
//            Case12();
//            Case13();
//            Case14();
//            Case15();
//            Case16();
//            Case17();
//            Case18();
//            Case19();//Can't automate
//            Case20();
//            Case21();
            Case22();
//            Case23();
//            Case24();
            //LogOut
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement sideBarBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
            sideBarBtn1.click();
            //Scroll down vvvv
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'edit_text_search')]");
            boolean isDisplayed1 = element1.isDisplayed();
            if (isDisplayed1) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                TouchAction touchAction = new TouchAction(driver);
                touchAction.longPress(new PointOption().withCoordinates(160, 200)).moveTo(new PointOption().withCoordinates(160, 520)).release().perform();
            }
            //Scroll ^^^^^
            System.out.println("Branch " +x+ " done!");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement logOutBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'image_visit_dropdown') and @index = '3']");
            logOutBtn.click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement logOutBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'btn_visit_logout')]");
            logOutBtn1.click();
        }
    }
    public void checkByShortName(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckShortName = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Short Name']");
        clckShortName.click();
        MobileElement goBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Go']");
        goBtn.click();
        System.out.println("Searching by Short Name");
    }
    public void checkByItemCode(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckItemCode = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Item Code']");
        clckItemCode.click();
        MobileElement goBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Go']");
        goBtn.click();
        System.out.println("Searching by Item Code");
    }
    public void checkByBarcode(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckBarcode = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Barcode']");
        clckBarcode.click();
        MobileElement goBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Go']");
        goBtn.click();
        System.out.println("Searching by Barcode");
    }
    public void checkByDescription(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckDescription = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Description']");
        clckDescription.click();
        MobileElement goBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Go']");
        goBtn.click();
        System.out.println("Searching by Description");
    }
    public void checkByBrand(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckBrand = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Brand']");
        clckBrand.click();
        MobileElement goBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Go']");
        goBtn.click();
        System.out.println("Searching by Brand");
    }
    public void checkByKeyword(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckKeyword = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Keyword']");
        clckKeyword.click();
        MobileElement goBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Go']");
        goBtn.click();
        System.out.println("Searching by Keyword");
    }
    public void checkByPrincipal(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        MobileElement clckKeyword = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Principal']");
        clckKeyword.click();
        MobileElement goBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Go']");
        goBtn.click();
        System.out.println("Searching by Principal");
    }
    //For Cases functions
    public void byShortName(){
        checkByShortName();
        //Click Search bar and search certain product by Name
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchShortName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchShortName.sendKeys(prodShortName[rand(prodShortName.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
    }
    public void byItemCode(){
        checkByItemCode();
        //Click Search bar and search certain product by Item Code
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchItemCode = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchItemCode.sendKeys(prodItemCode[rand(prodItemCode.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
    }
    public void byBarcode(){
        checkByBarcode();
        //Click Search bar and search certain product by Barcode
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBarcode = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchBarcode.sendKeys(prodBarcode[rand(prodBarcode.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
    }
    public void byDescription(){
        checkByDescription();
        //Click Search bar and search certain product by Description
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchDescription = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchDescription.sendKeys(prodDescription[rand(prodDescription.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
    }
    public void byBrand(){
        checkByBrand();
        //Click Search bar and search certain product by Brand
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBrand = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchBrand.sendKeys(prodBrand[rand(prodBrand.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
    }
    public void byKeyword(){
        checkByKeyword();
        //Click Search bar and search certain product by Keywords
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchKeyword = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchKeyword.sendKeys(prodKeyword[rand(prodKeyword.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
    }
    public void byPrincipal(){
        checkByPrincipal();
        //Click Search bar and search certain product by Principal
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchPrincipal = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchPrincipal.sendKeys(prodPrincipal[rand(prodPrincipal.length-1)]);
        //Click Magnifying Glass Icon
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
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
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='No Filter']");
        noFilBtn.click();
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
            touchAction.press(new PointOption().withCoordinates(x, 500)).moveTo(new PointOption().withCoordinates(x, 100)).release().perform();
        }

    }
    public void allProd(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement prodFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Product Filter']");
        prodFilBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allProd = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='All Products']");
        allProd.click();
    }
    public void prodGroup(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement prodFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Product Filter']");
        prodFilBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement prodGrpFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Product Group']");
        prodGrpFil.click();
        MobileElement prodGrp = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='0']");
        prodGrp.click();
    }
    public void mustCarry(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement prodFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Product Filter']");
        prodFilBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement mustCarryFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Must Carry Per Account Classification']");
        mustCarryFilBtn.click();
        MobileElement mustCarry = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='0']");
        mustCarry.click();
    }
    public void brand(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement prodFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Product Filter']");
        prodFilBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement brandFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Brand']");
        brandFilBtn.click();
        MobileElement brand = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='0']");
        brand.click();
    }
    public void docuSequence(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement prodFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Product Filter']");
        prodFilBtn.click();
        //Filter by btn
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement docSeqFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Document Sequence']");
        docSeqFilBtn.click();
        MobileElement docSeq = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='0']");
        docSeq.click();
    }
    public void activeProd(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement prodFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Product Filter']");
        prodFilBtn.click();
        //Filter by btn
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement activeProdFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Active Products']");
        activeProdFilBtn.click();
    }
    public void carriedProd(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement prodFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Product Filter']");
        prodFilBtn.click();
        //Filter by btn
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement carriedProdFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Carried Products']");
        carriedProdFilBtn.click();
    }
    public void notCarriedProd(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        arrowBtn.click();
        //Swipe down
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement prodFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Product Filter']");
        prodFilBtn.click();
        //Filter by btn
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement notCarriedProdFilBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Not Carried Products']");
        notCarriedProdFilBtn.click();
    }
    public void clear(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement threeDots = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'fdc_menu')]");
        threeDots.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clrBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'txt_clear_all_btn') and @text='CLEAR']");
        clrBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement contBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Continue']");
        contBtn.click();
    }
    public void finalMthd(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement threeDots = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'fdc_menu')]");
        threeDots.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement fnlBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'txt_finalize_btn') and @text='FINALIZE']");
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
    public void preview(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement threeDots = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'fdc_menu')]");
        threeDots.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement previewBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'txt_preview_btn') and @text='PREVIEW']");
        previewBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement closeBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Close']");
        closeBtn.click();
        driver.navigate().back();
    }
    public void beginningInven(){
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
    public void randomNum(){
        switch(rand(10)){
            case 1: MobileElement clckNO1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_1') and @index = '0']"); clckNO1.click();
                break;
            case 2: MobileElement clckNO2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_2') and @index = '1']"); clckNO2.click();
                break;
            case 3: MobileElement clckNO3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_3') and @index = '2']"); clckNO3.click();
                break;
            case 4: MobileElement clckNO4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_4') and @index = '0']"); clckNO4.click();
                break;
            case 5: MobileElement clckNO5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_5') and @index = '1']"); clckNO5.click();
                break;
            case 6: MobileElement clckNO6 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_6') and @index = '2']"); clckNO6.click();
                break;
            case 7: MobileElement clckNO7 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_7') and @index = '0']"); clckNO7.click();
                break;
            case 8: MobileElement clckNO8 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_8') and @index = '1']"); clckNO8.click();
                break;
            case 9: MobileElement clckNO9 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_9') and @index = '2']"); clckNO9.click();
                break;
        }
    }
    private static int rand(int bound) {
        return (int) (Math.random() * bound);
    }

}
