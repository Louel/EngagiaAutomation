package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;

public class VAOF {

    AppiumDriver driver;


    String search = "Van Account Order Form";
    String search1 = "VAOF Summary";
    String branch = "ALFAMART MARIKINA 9";
    String[] products = {"cOKe", "oke" , "ke" , "rc", "len", "anlen", "cheezy" , "Nova" , "ova"};
    String[] productNames = {"Anlene", "lene" , "lack" , "Ahoy" , "lover", "soda", "banana" , "Tos" , "Mentos"};
    String[] productShortNames = {"Coke" , "oke" , "beEr" , "RC"};
    String[] productCode = {"51232143" , "51232208" , "535353" , "545454" , "565656" , "686868" , "829382"};
    String[] productBarCode = {"10182017015" , "100000216" , "10182017010" , "10182017031" , "1018201704" , "131213" , "242424"};
    String[] productDescrip = {"Soda", "Cracker" , "Biscuit" , "Milk" , "Candy" , "Chocolate"};
    String[] productBrand = {"MEGA SARDINES", "Clover Chips" , "Exo Candy" , "Mentos" , "Coca-Cola" , "Moutain Dew"};
    String[] productKeyword = {"Coke", "Sprite" , "Beer" , "Crispy Fishbol Flavor" , "Soft Drink" , "Piattos"};
    String[] ranNum = {"11112", "11113" , "22221" , "22224" , "33331" , "44442"};
    String[] customerName = {"Tony Stark", "Mario" , "Luigi" , "Peter Parker"};
    String[] customerCont = {"123456789", "112233445" , "159357258" , "134679875"};
    String branchListDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout" +
            "/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView";
    String orderDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout";
    String productDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout";
    String unitDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
    String vaofDrctryTbl = "//android.widget.FrameLayout[@index='0']/" +
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

    String vaofDrctryByPC = "//android.widget.FrameLayout[@index='0']/" +
            "android.widget.LinearLayout[@index='0']/" +
            "android.widget.FrameLayout[@index='0']/" +
            "android.widget.LinearLayout[@index='0']/" +
            "android.widget.FrameLayout[@index='0']/" +
            "android.support.v4.widget.DrawerLayout[@index='0']/" +
            "android.widget.LinearLayout[@index='0']/" +
            "android.widget.FrameLayout[@index='1']/" +
            "android.widget.LinearLayout[@index='0']/" +
            "android.widget.FrameLayout[@index='2']/" +
            "android.widget.LinearLayout[@index='0']/";

    String vaofDrctryTbl2 = "//android.widget.FrameLayout[@index='0']/" +
            "android.widget.LinearLayout[@index='0']/" +
            "android.widget.FrameLayout[@index='0']/" +
            "android.widget.LinearLayout[@index='0']/" +
            "android.widget.FrameLayout[@index='0']/" +
            "android.support.v4.widget.DrawerLayout[@index='0']/" +
            "android.widget.LinearLayout[@index='0']/" +
            "android.widget.FrameLayout[@index='1']/" +
            "android.widget.LinearLayout[@index='0']/" +
            "android.widget.FrameLayout[@index='2']/" +
            "android.widget.LinearLayout[@index='0']/";

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Samsung Galaxy J1 (2016)");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("platformVersion", "5.1.1");
//        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("appPackage", "com.engagia.android");
        capabilities.setCapability("appActivity","com.engagia.android.activities.LoginActivity");
        capabilities.setCapability("noSign", true);
        capabilities.setCapability(FULL_RESET, false);
        capabilities.setCapability(NO_RESET, true);
//        driver = new AppiumDriver(new URL("http://192.168.1.33:4723/wd/hub"), capabilities);
        driver = new AppiumDriver(new URL("http://192.168.0.167:4723/wd/hub"), capabilities);

    }

    @Test
    public void testVAOF(){
        vaofLogInToVisit();
    }

    //Check App: "Search by Name"
    public void Case2(){
        System.out.println("Testing Case 2");
        //Search By Name
        searchByName();
        //Search a product Name
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchField.sendKeys(productNames[rand(productNames.length-1)]);
        //Click on search button
        MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        clckSearch.click();
        searchField.sendKeys("abcdefg123");
        clckSearch.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
        boolean noProdFoundDisplayed = noProdFound.isDisplayed();
        if (noProdFoundDisplayed) {
            System.out.println("No Products Found");
            System.out.println("Case 2 Pass");
        }
    }
    //Check App: "Search by Short Name"
    public void Case3(){
        System.out.println("Testing Case 3");
        //Search By Short Name
        searchByShortName();
        //Search a product Short Name
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchField.sendKeys(productShortNames[rand(productShortNames.length-1)]);
        //Click on search button
        MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        clckSearch.click();
        searchField.sendKeys("abcdefg123");
        clckSearch.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
        boolean noProdFoundDisplayed = noProdFound.isDisplayed();
        if (noProdFoundDisplayed) {
            System.out.println("No Products Found");
            System.out.println("Case 3 Pass");
        }
    }
    //Check App: "Search by Code"
    public void Case4(){
        System.out.println("Testing Case 4");
        //Search By Code
        searchByCode();
        //Search a product Code
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchField.sendKeys(productCode[rand(productCode.length-1)]);
        //Click on search button
        MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        clckSearch.click();
        searchField.sendKeys("abcdefg123");
        clckSearch.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
        boolean noProdFoundDisplayed = noProdFound.isDisplayed();
        if (noProdFoundDisplayed) {
            System.out.println("No Products Found");
            System.out.println("Case 4 Pass");
        }
    }
    //Check App: "Search by Barcode"
    public void Case5(){
        System.out.println("Testing Case 5");
        //Search By Barcode
        searchByBarcode();
        //Search a product Barcode
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchField.sendKeys(productBarCode[rand(productBarCode.length-1)]);
        //Click on search button
        MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        clckSearch.click();
        searchField.sendKeys("abcdefg123");
        clckSearch.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
        boolean noProdFoundDisplayed = noProdFound.isDisplayed();
        if (noProdFoundDisplayed) {
            System.out.println("No Products Found");
            System.out.println("Case 5 Pass");
        }
    }
    //Check App: "Search by Description"
    public void Case6(){
        System.out.println("Testing Case 6");
        //Search By Description
        searchByDescription();
        //Search a product Description
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchField.sendKeys(productDescrip[rand(productDescrip.length-1)]);
        //Click on search button
        MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        clckSearch.click();
        searchField.sendKeys("abcdefg123");
        clckSearch.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
        boolean noProdFoundDisplayed = noProdFound.isDisplayed();
        if (noProdFoundDisplayed) {
            System.out.println("No Products Found");
            System.out.println("Case 6 Pass");
        }
    }
    //Check App: "Search by Brand"
    public void Case7(){
        System.out.println("Testing Case 7");
        //Search By Brand
        searchByBrand();
        //Search a product Brand
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchField.sendKeys(productBrand[rand(productBrand.length-1)]);
        //Click on search button
        MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        clckSearch.click();
        searchField.sendKeys("abcdefg123");
        clckSearch.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
        boolean noProdFoundDisplayed = noProdFound.isDisplayed();
        if (noProdFoundDisplayed) {
            System.out.println("No Products Found");
            System.out.println("Case 7 Pass");
        }
    }
    //Check App: "Search by Keyword"
    public void Case8(){
        System.out.println("Testing Case 8");
        //Search By Keyword
        searchByKeyword();
        //Search a product Keyword
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
        //Click on search button
        MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        clckSearch.click();
        searchField.sendKeys("abcdefg123");
        clckSearch.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
        boolean noProdFoundDisplayed = noProdFound.isDisplayed();
        if (noProdFoundDisplayed) {
            System.out.println("No Products Found");
            clear();
            System.out.println("Case 8 Pass");
        }
    }
    //Check App: Product Filter by "All Product"
    public void Case9(){
        System.out.println("Testing Case 9");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        //Search By Keyword
        for(int z=1; z<=8; z++){
            prodFilterByAllProd();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productNames[rand(productNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productShortNames[rand(productShortNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productCode[rand(productCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBarCode[rand(productBarCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productDescrip[rand(productDescrip.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBrand[rand(productBrand.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 9 Pass");
                    clear();
                }
            }
        }
    }
    //Check App: Product Filter by "Product Group"
    public void Case10(){
        System.out.println("Testing Case 10");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            prodFilterByProdGroup();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productNames[rand(productNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productShortNames[rand(productShortNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productCode[rand(productCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBarCode[rand(productBarCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productDescrip[rand(productDescrip.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBrand[rand(productBrand.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 10 Pass");
                    clear();
                }
            }
        }
    }
    //Check App: Product Filter by "Must carry per Account Classification"
    public void Case11(){
        System.out.println("Testing Case 11");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            prodFilterByMustCarry();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productNames[rand(productNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productShortNames[rand(productShortNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productCode[rand(productCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBarCode[rand(productBarCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productDescrip[rand(productDescrip.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBrand[rand(productBrand.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 10 Pass");
                    clear();
                }
            }
        }
    }
    //Check App: Product Filter by "Brand"
    public void Case12(){
        System.out.println("Testing Case 12");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            prodFilterByBrand();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Potato Chips Wave Cut");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Wave cut");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("123456789");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("666112225");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Salty Snacks");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Jack n Jill");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Piattos");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 12 Pass");
                    clear();
                }
            }
        }
    }
    //Check App: Product Filter by "Product with Historical Sales"
    public void Case13(){
        System.out.println("Testing Case 13");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=16; z++){
            if(z==1) {
                prodFilterByHistoricalSalesVolume();
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Potato Chips Wave Cut");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                prodFilterByHistoricalSalesVolume();
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Wave cut");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                prodFilterByHistoricalSalesVolume();
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("123456789");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                prodFilterByHistoricalSalesVolume();
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("666112225");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                prodFilterByHistoricalSalesVolume();
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Salty Snacks");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                prodFilterByHistoricalSalesVolume();
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Jack n Jill");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                prodFilterByHistoricalSalesVolume();
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Piattos");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                prodFilterByHistoricalSalesVolume();
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 13 Pass Volume");
                    clear();
                }
            }
            else if(z==9) {
                prodFilterByHistoricalSalesValue();
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Potato Chips Wave Cut");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==10){
                prodFilterByHistoricalSalesValue();
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Wave cut");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==11){
                prodFilterByHistoricalSalesValue();
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("123456789");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==12){
                prodFilterByHistoricalSalesValue();
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("666112225");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==13){
                prodFilterByHistoricalSalesValue();
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Salty Snacks");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==14){
                prodFilterByHistoricalSalesValue();
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Jack n Jill");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==15){
                prodFilterByHistoricalSalesValue();
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Piattos");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==16){
                prodFilterByHistoricalSalesValue();
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 13 Pass Value");
                    clear();
                }
            }
        }
    }
    //Check app: Product Filter by "Must carry + Products with Historical Sales"
    public void Case14(){
        System.out.println("Testing Case 14");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=16; z++){
            if(z==1) {
                prodFilterByMustCarryHistoricalSalesVolume();
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Potato Chips Wave Cut");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                prodFilterByMustCarryHistoricalSalesVolume();
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Wave cut");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                prodFilterByMustCarryHistoricalSalesVolume();
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("123456789");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                prodFilterByMustCarryHistoricalSalesVolume();
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("666112225");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                prodFilterByMustCarryHistoricalSalesVolume();
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Salty Snacks");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                prodFilterByMustCarryHistoricalSalesVolume();
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Jack n Jill");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                prodFilterByMustCarryHistoricalSalesVolume();
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Piattos");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                prodFilterByMustCarryHistoricalSalesVolume();
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 14 Pass Volume");
                    clear();
                }
            }
            else if(z==9) {
                prodFilterByMustCarryHistoricalSalesValue();
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Potato Chips Wave Cut");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==10){
                prodFilterByMustCarryHistoricalSalesValue();
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Wave cut");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==11){
                prodFilterByMustCarryHistoricalSalesValue();
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("123456789");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==12){
                prodFilterByMustCarryHistoricalSalesValue();
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("666112225");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==13){
                prodFilterByMustCarryHistoricalSalesValue();
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Salty Snacks");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==14){
                prodFilterByMustCarryHistoricalSalesValue();
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Jack n Jill");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==15){
                prodFilterByMustCarryHistoricalSalesValue();
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Piattos");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==16){
                prodFilterByMustCarryHistoricalSalesValue();
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 14 Pass Value");
                    clear();
                }
            }
        }
    }
    //Check app: Product Filter by "Document Sequence"
    public void Case15(){
        System.out.println("Testing Case 15");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            prodFilterByDocuSequence();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productNames[rand(productNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productShortNames[rand(productShortNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productCode[rand(productCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBarCode[rand(productBarCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productDescrip[rand(productDescrip.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBrand[rand(productBrand.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 15 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Product Filter by "Deals"
    public void Case16(){
        System.out.println("Testing Case 16");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            prodFilterByDeal();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Mentos");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Mentos Rainbow");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("51232215");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("51232215");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Candy");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Royal");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Royal");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 16 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Product Filter by "Active Products"
    public void Case17(){
        System.out.println("Testing Case 17");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            prodFilterByActiveProd();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productNames[rand(productNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productShortNames[rand(productShortNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productCode[rand(productCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBarCode[rand(productBarCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productDescrip[rand(productDescrip.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBrand[rand(productBrand.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 17 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Product Filter by "Carried Products"
    public void Case18(){
        System.out.println("Testing Case 18");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            prodFilterByCarriedProd();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productNames[rand(productNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productShortNames[rand(productShortNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productCode[rand(productCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBarCode[rand(productBarCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productDescrip[rand(productDescrip.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBrand[rand(productBrand.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 18 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Product Filter by "Not Carried Products" may bug dito sa not carried ibang product yung lumalabas compare sa nilagay sa EMS
    public void Case19(){
        System.out.println("Testing Case 19");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            prodFilterByNotCarriedProd();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Bot Product");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Prod 9");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("20180911");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("20180911");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Soft Drink");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("BOT PRODUCT ");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 19 Pass");
                    clear();
                }
            }
        }
    }
    /**
     * INFORMATION FILTER SHOULD BE AT THE LAST PART AFTER ORDERING/PUTTING STOCKS
     */
    //Check app: Information Filter by "None"
    public void Case20(){
        System.out.println("Testing Case 20");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByNone();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productNames[rand(productNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productShortNames[rand(productShortNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productCode[rand(productCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBarCode[rand(productBarCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productDescrip[rand(productDescrip.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBrand[rand(productBrand.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 20 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Information Filter by "Products with inputs"
    public void Case21(){
        System.out.println("Testing Case 21");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByProductsWithInputs();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productNames[rand(productNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productShortNames[rand(productShortNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productCode[rand(productCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBarCode[rand(productBarCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productDescrip[rand(productDescrip.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBrand[rand(productBrand.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 21 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Information Filter by "Products without Stock"
    public void Case22(){
        System.out.println("Testing Case 22");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByProductsWithoutStock();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productNames[rand(productNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productShortNames[rand(productShortNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productCode[rand(productCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBarCode[rand(productBarCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productDescrip[rand(productDescrip.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBrand[rand(productBrand.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 22 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Information Filter by "Products with Stock"
    public void Case23(){
        System.out.println("Testing Case 23");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByProductsWithStock();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productNames[rand(productNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productShortNames[rand(productShortNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productCode[rand(productCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBarCode[rand(productBarCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productDescrip[rand(productDescrip.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBrand[rand(productBrand.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 23 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Information Filter by "Returnable"
    public void Case24(){
        System.out.println("Testing Case 24");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByReturnable();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Coca-Cola");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Coke");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("51232195");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("51232196");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("COla");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Coca-Cola");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Cola");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 24 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Information Filter by "6,3,1 > 0"
    public void Case25(){
        System.out.println("Testing Case 25");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterBy631();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productNames[rand(productNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productShortNames[rand(productShortNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productCode[rand(productCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBarCode[rand(productBarCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productDescrip[rand(productDescrip.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBrand[rand(productBrand.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 25 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Information Filter by "Products with Order"
    public void Case26(){
        System.out.println("Testing Case 26");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByProductsWithOrder();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productNames[rand(productNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productShortNames[rand(productShortNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productCode[rand(productCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBarCode[rand(productBarCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productDescrip[rand(productDescrip.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBrand[rand(productBrand.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 26 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Information Filter by "Stock Availability = No Stock"
    public void Case27(){
        System.out.println("Testing Case 27");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByStocksAvailNoStock();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productNames[rand(productNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productShortNames[rand(productShortNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productCode[rand(productCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBarCode[rand(productBarCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productDescrip[rand(productDescrip.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBrand[rand(productBrand.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 27 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Information Filter by "Stock Availability = With Stock"
    public void Case28(){
        System.out.println("Testing Case 28");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByStocksAvailWithStock();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productNames[rand(productNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productShortNames[rand(productShortNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productCode[rand(productCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBarCode[rand(productBarCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productDescrip[rand(productDescrip.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBrand[rand(productBrand.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 28 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Information Filter by "Stock Weight = Low"
    public void Case29(){
        System.out.println("Testing Case 29");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByStockWeightLow();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productNames[rand(productNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productShortNames[rand(productShortNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productCode[rand(productCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBarCode[rand(productBarCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productDescrip[rand(productDescrip.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBrand[rand(productBrand.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 29 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Information Filter by "Stock Weight = Medium"
    public void Case30(){
        System.out.println("Testing Case 30");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByStockWeightMed();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productNames[rand(productNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productShortNames[rand(productShortNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productCode[rand(productCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBarCode[rand(productBarCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productDescrip[rand(productDescrip.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBrand[rand(productBrand.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 30 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Information Filter by "Stock Weight = High"
    public void Case31(){
        System.out.println("Testing Case 31");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByStockWeightHigh();
            if(z==1) {
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productNames[rand(productNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productShortNames[rand(productShortNames.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productCode[rand(productCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBarCode[rand(productBarCode.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productDescrip[rand(productDescrip.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productBrand[rand(productBrand.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys(productKeyword[rand(productKeyword.length-1)]);
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==8){
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    System.out.println("Case 31 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: "Summary Menu"
    public void Case32(){
        System.out.println("Testing Case 32");
        MobileElement SummaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
        SummaryMenu.click();
        MobileElement preview = (MobileElement) driver.findElementById("com.engagia.android:id/btn_preview");
        preview.click();
        driver.navigate().back();
        MobileElement transactionList = (MobileElement) driver.findElementById("com.engagia.android:id/btn_trnsctn_list");
        transactionList.click();
        driver.navigate().back();
        MobileElement clear = (MobileElement) driver.findElementById("com.engagia.android:id/btn_clear");
        clear.click();
        driver.navigate().back();
        MobileElement finalize = (MobileElement) driver.findElementById("com.engagia.android:id/btn_finalize");
        finalize.click();
        driver.navigate().back();
        System.out.println("Case 32 Pass");
    }
    //Check app: Summary Menu "Clear All"
    public void Case33(){
        System.out.println("Testing Case 33");
        clear();
        System.out.println("Case 33 Pass");
    }
    //Check app: Summary Menu "Preview"
    public void Case34(){
        System.out.println("Testing Case 34");
        preview();
        System.out.println("Case 34 Pass");
    }
    //Check app: Summary Menu "Finalize" step 11
    public void Case35(){
        System.out.println("Testing Case 35");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement summaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
        summaryMenu.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement finalize = (MobileElement) driver.findElementById("com.engagia.android:id/btn_finalize");
        finalize.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement snackbarMessage = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
        boolean noProdFoundDisplayed = snackbarMessage.isDisplayed();
        if (noProdFoundDisplayed) {
            System.out.println("Snack bar message displayed");
            driver.navigate().back();
        }
        orderPC();
        orderBox();
        summaryMenu.click();
        finalize.click();
        driver.navigate().back();
        finalize.click();
        for (int x = 1; x <= 6; x++) {
            System.out.println("Loop x: "+x);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement btnSave = (MobileElement) driver.findElementById("com.engagia.android:id/btn_save");
            btnSave.click();
            if (x == 2 || x == 5) {
                finalizeOrderInput();
            }
            else if (x == 3) {
                MobileElement noBtn = (MobileElement) driver.findElementById("android:id/button2");
                noBtn.click();
            }
            else if (x == 4) {
                MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
                yesBtn.click();
                MobileElement noBtn = (MobileElement) driver.findElementById("android:id/button2");
                noBtn.click();
                MobileElement backBtn = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
                backBtn.click();
                yesBtn.click();
                orderPC();
                orderBox();
                summaryMenu.click();
                finalize.click();
            }
            else if (x == 6) {
                MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
                yesBtn.click();
                yesBtn.click();
                //INSERT APPLY PAYMENT METHOD HERE
                applyPayment();
                finalizeOrder();
            }
        }
        System.out.println("Case 35 Pass");
    }
    //Check app: Finalize: "Print"
    public void Case36(){
        System.out.println("Testing Case 36");
        orderPC();
        orderBox();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement summaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
        summaryMenu.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement finalize = (MobileElement) driver.findElementById("com.engagia.android:id/btn_finalize");
        finalize.click();
        MobileElement printBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_print");
        printBtn.click();
        MobileElement poNumber = (MobileElement) driver.findElementById("com.engagia.android:id/input_po_number");
        poNumber.sendKeys("123456");
        MobileElement salesInvoiceNumber = (MobileElement) driver.findElementById("com.engagia.android:id/input_si_number");
        salesInvoiceNumber.sendKeys("654321");
        MobileElement custName = (MobileElement) driver.findElementById("com.engagia.android:id/input_customer_name");
        custName.sendKeys("John Roe");
        MobileElement contactDetails = (MobileElement) driver.findElementById("com.engagia.android:id/input_contact_detail");
        contactDetails.sendKeys("0917 XXX XXXX");
        driver.hideKeyboard();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement btnSave = (MobileElement) driver.findElementById("com.engagia.android:id/btn_save");
        btnSave.click();
        MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
        yesBtn.click();
        MobileElement noBtn = (MobileElement) driver.findElementById("android:id/button2");
        noBtn.click();
        printBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement printBackBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_back");
        printBackBtn.click();
        printBtn.click();
        //STEP 11
    }
    //Check app: Summary Menu "Transaction List & Window"
    public void Case37(){
        System.out.println("Testing Case 37");
        for(int z=1; z<=3; z++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement summaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
            summaryMenu.click();
            MobileElement transaction = (MobileElement) driver.findElementById("com.engagia.android:id/btn_trnsctn_list");
            transaction.click();
            if(z==1) {
                System.out.println("Cancel Transaction");
                //C A N C E L   T R A N S A C T I O N
                for(int x = 1; x <= 2; x++) {
                    MobileElement selTransaction = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]");
                    selTransaction.click();
                    MobileElement cancelTransaction = (MobileElement) driver.findElementById("android:id/button2");
                    cancelTransaction.click();
                    MobileElement selVanTransac = (MobileElement) driver.findElementById("com.engagia.android:id/chk_van_transaction");
                    selVanTransac.click();
                    MobileElement continueBtn = (MobileElement) driver.findElementById("android:id/button1");
                    continueBtn.click();
                    if (x == 1) {
                        MobileElement noBtn = (MobileElement) driver.findElementById("android:id/button2");
                        noBtn.click();
                    } else if (x == 2) {
                        MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
                        yesBtn.click();
                        MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button1");
                        dismissBtn.click();
                    }
                }
            }
            else if(z==2) {
                System.out.println("Adjust Transaction");
                //A D J U S T   T R A N S A C T I O N
                for(int w = 1; w<=2; w++){
                    MobileElement selTransaction = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]");
                    selTransaction.click();
                    MobileElement adjustTransaction = (MobileElement) driver.findElementById("android:id/button1");
                    adjustTransaction.click();
                    if (w==1){
                        MobileElement cancelBtn = (MobileElement) driver.findElementById("android:id/button2");
                        cancelBtn.click();
                    } else if (w==2){
                        MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
                        okBtn.click();
                        deleteOrderPC();
                        orderPC();
                        summaryMenu.click();
                        MobileElement finalizeEditBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_finalize");
                        finalizeEditBtn.click();
                        MobileElement reasonForAdjustingField = (MobileElement) driver.findElementById("com.engagia.android:id/input_edit_reason");
                        reasonForAdjustingField.sendKeys("Gusto ko lang");
                        driver.hideKeyboard();
                        MobileElement saveBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_save");
                        saveBtn.click();
                        MobileElement noBtn = (MobileElement) driver.findElementById("android:id/button2");
                        noBtn.click();
                        saveBtn.click();
                        MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
                        yesBtn.click();
                        //COLLECT THE PAYMENT IF YES AND IF NO
                        System.out.println("Collect payment Yes");
                        MobileElement collectYes = (MobileElement) driver.findElementById("android:id/button1");
                        collectYes.click();
                        applyPayment();
                        finalizeOrder();
                    }
                }
            }
            else if (z==3){
                MobileElement selTransaction = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]");
                selTransaction.click();
                MobileElement adjustTransaction = (MobileElement) driver.findElementById("android:id/button1");
                adjustTransaction.click();
                MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
                okBtn.click();
                deleteOrderPC();
                orderPC();
                summaryMenu.click();
                MobileElement finalizeEditBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_finalize");
                finalizeEditBtn.click();
                MobileElement reasonForAdjustingField = (MobileElement) driver.findElementById("com.engagia.android:id/input_edit_reason");
                reasonForAdjustingField.sendKeys("Gusto ko lang");
                driver.hideKeyboard();
                MobileElement saveBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_save");
                saveBtn.click();
                MobileElement noBtn = (MobileElement) driver.findElementById("android:id/button2");
                noBtn.click();
                saveBtn.click();
                MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
                yesBtn.click();
                System.out.println("Collect payment No");
                MobileElement collectNo = (MobileElement) driver.findElementById("android:id/button2");
                collectNo.click();
                MobileElement backBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_back");
                backBtn.click();
                MobileElement clearYes = (MobileElement) driver.findElementById("android:id/button1");
                clearYes.click();
            }
        }

        System.out.println("Case 37 Pass");

    }
    //Check app: Summary Menu "Salesman Discount
    public void Case38(){

    }
    //Check "Product Summary"
    public void Case39(){
        System.out.println("Testing Case 39");
        viewProductSummary();
        System.out.println("Case 39 Pass");
    }
    //Check app: "Product" Column May EMS na kasama to
    public void Case40(){
        System.out.println("Testing Case 40");

        System.out.println("Case 40 Pass");
    }
    //Check app: "Unit" Column
    public void Case41(){
        System.out.println("Testing Case 41");
        //1st click
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            MobileElement unit = (MobileElement) driver.findElementByXPath(unitDrctry);
            unit.click();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement element2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_uom_filtered') and @text='Uom filtered by smallest']");
        boolean isDisplayed2 = element2.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Uom filtered by Smallest is Displayed");
            MobileElement unit = (MobileElement) driver.findElementByXPath(unitDrctry);
            unit.click();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement element3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_uom_filtered') and @text='Uom filtered by biggest']");
        boolean isDisplayed3 = element3.isDisplayed();
        if (isDisplayed3) {
            System.out.println("Uom filtered by Biggest is Displayed");
            MobileElement unit = (MobileElement) driver.findElementByXPath(unitDrctry);
            unit.click();
        }
        System.out.println("Case 41 Pass");
    }
    //Check app: "Order" Column
    public void Case42(){
        System.out.println("Testing Case 42");
        orderNegativePC();
        orderNegativeBox();
        orderPC();
        orderBox();
        deleteOrderPC();
        deleteOrderBox();
        orderPC();
        orderBox();
        for(int z = 1; z<=3; z++) {
            //1st Product per PC
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            MobileElement orderPC1 = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout["+z+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView");
            orderPC1.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            for(int x = 1; x<=7; x++) {
                MobileElement btnNo9 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_9");
                btnNo9.click();
            }
            MobileElement btnOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
            btnOk.click();
            System.out.println("Order PC "+z+" done");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
            boolean isDisplayed1 = element1.isDisplayed();
            if (isDisplayed1) {
                System.out.println("Not enough inventory");
            }
        }
        System.out.println("Case 42 Pass");
    }
    //Check app: "Trade Inventory" Column
    public void Case43(){
        System.out.println("Testing Case 43");
        tradeNegativeInventoryPC();
        tradeInventoryPC();
        deleteTradeInventoryPC();
        tradeInventoryPC();
        System.out.println("Case 43 Pass");
    }
    //Check app: "Inventory" Column
    public void Case44(){
        System.out.println("Testing Case 44");
        swipeRight();
        inventory();
        inventory();
        System.out.println("Case 44 Pass");
    }
    //Check app: "Return From Trade" Column
    public void Case45(){
        System.out.println("Testing Case 45");
        swipeRight();
        returnFromTradeNoReturnable();
        System.out.println("Case 45 Pass");
    }
    //Check "Inventory by UOM" Column
    public void Case46(){
        swipeRight();
    }
    //Check app: "Stock Availability" Column
    public void Case47(){
        System.out.println("Testing Case 47");
        swipeRight();
        stockAvail();
        stockAvail();
        stockAvail();
        System.out.println("Case 48 Pass");
    }
    //Check app: "Stock Weight" Column
    public void Case48(){
        System.out.println("Testing Case 48");
        swipeRight();
        stockWeight();
        stockWeight();
        stockWeight();
        System.out.println("Case 48 Pass");
    }
    //Check App: Product Filter by "Must carry per Account Classification"  * N O T   L O G G E D  I N  TO  V I S I T *
    public void Case11_outOfVisit(){
        System.out.println("Testing Case 11");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        System.out.println("Product Filter By Must Carry");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Must Carry
        MobileElement mustCarry = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_must_carry");
        mustCarry.click();
        driver.navigate().back();
        driver.navigate().back();
        System.out.println("Case 11 Pass");
        clear();
    }
    //Check App: Product Filter by "Product with Historical Sales"  * N O T   L O G G E D  I N  TO  V I S I T *
    public void Case13_outOfVisit(){
        System.out.println("Testing Case 13");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        System.out.println("Product Filter By Historical Sales Sort By Volume");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Historical Sales
        MobileElement historicalSales = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_w_historical_sales");
        historicalSales.click();
        driver.navigate().back();
        driver.navigate().back();
        System.out.println("Case 13 Pass");
        clear();
    }
    //Check app: Product Filter by "Must carry + Products with Historical Sales"  * N O T   L O G G E D  I N  TO  V I S I T *
    public void Case14_outOfVisit(){
        System.out.println("Testing Case 14");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        System.out.println("Product Filter By Must Carry + Historical Sales Sort By Volume");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Must Carry + Historical Sales
        MobileElement historicalSales = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_must_carry_w_historical_sales");
        historicalSales.click();
        driver.navigate().back();
        driver.navigate().back();
        System.out.println("Case 14 Pass");
        clear();
    }
    //Check app: Product Filter by "Active Products"   * N O T   L O G G E D  I N  TO  V I S I T *
    public void Case17_outOfVisit(){
        System.out.println("Testing Case 17");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Active Products
        MobileElement activeProd = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_active");
        activeProd.click();
        driver.navigate().back();
        driver.navigate().back();
        System.out.println("Case 17 Pass");
        clear();
    }
    //Check app: Product Filter by "Carried Products"   * N O T   L O G G E D  I N  TO  V I S I T *
    public void Case18_outOfVisit(){
        System.out.println("Testing Case 18");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Carried Products
        MobileElement carriedProd = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_carried");
        carriedProd.click();
        driver.navigate().back();
        driver.navigate().back();
        System.out.println("Case 18 Pass");
        clear();
    }
    //Check app: Product Filter by "Not Carried Products"   * N O T   L O G G E D  I N  TO  V I S I T *
    public void Case19_outOfVisit(){
        System.out.println("Testing Case 19");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Not Carried Products
        MobileElement notCarriedProd = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_not_carried");
        notCarriedProd.click();
        driver.navigate().back();
        driver.navigate().back();
        System.out.println("Case 19 Pass");
        clear();
    }
    //Check app: "Summary Menu"   * N O T   L O G G E D  I N  TO  V I S I T *
    public void Case32_outOfVisit(){
        System.out.println("Testing Case 32");
        MobileElement SummaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
        SummaryMenu.click();
        MobileElement preview = (MobileElement) driver.findElementById("com.engagia.android:id/btn_preview");
        preview.click();
        MobileElement transactionList = (MobileElement) driver.findElementById("com.engagia.android:id/btn_trnsctn_list");
        transactionList.click();
        MobileElement clear = (MobileElement) driver.findElementById("com.engagia.android:id/btn_clear");
        clear.click();
        driver.navigate().back();
        MobileElement finalize = (MobileElement) driver.findElementById("com.engagia.android:id/btn_finalize");
        finalize.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement snackbarMessage = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
        boolean noProdFoundDisplayed = snackbarMessage.isDisplayed();
        if (noProdFoundDisplayed) {
            System.out.println("Snack bar message displayed");
            driver.navigate().back();
            System.out.println("Case 32 Pass");
        }
    }
    //Check app: Summary Menu "Preview"   * N O T   L O G G E D  I N  TO  V I S I T *
    public void Case34_outOfVisit(){
        System.out.println("Testing Case 34");
        //Click triple Dots
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckDots = (MobileElement) driver.findElementByAccessibilityId("Show action");
        clckDots.click();
        //Click preview
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement preview = (MobileElement) driver.findElementById("com.engagia.android:id/btn_preview");
        preview.click();
        driver.navigate().back();
        System.out.println("Case 34 Pass");
    }
    //Check app: Summary Menu "Finalize"
    public void Case35_outOfVisit(){
        System.out.println("Testing Case 35");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement summaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
        summaryMenu.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement finalize = (MobileElement) driver.findElementById("com.engagia.android:id/btn_finalize");
        finalize.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement snackbarMessage = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
        boolean noProdFoundDisplayed = snackbarMessage.isDisplayed();
        if (noProdFoundDisplayed) {
            System.out.println("Snack bar message displayed");
            driver.navigate().back();
            System.out.println("Case 35 Pass");
        }
    }
    //Check app: Summary Menu "Transaction List & Window"
    public void Case37_outOfVisit(){
        System.out.println("Testing Case 37");
        //Click order pc and box
        orderPC_outOfVisit();
        orderBox_outOfVisit();
        //Swipping to Return from Trade
        swipeRight();
        swipeRight();
        returnFromTrade_outOfVisit();
        swipeRight();
        swipeRight();
        stockAvail();
        swipeRight();
        stockWeight();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement summaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
        summaryMenu.click();
        MobileElement transaction = (MobileElement) driver.findElementById("com.engagia.android:id/btn_trnsctn_list");
        transaction.click();
        driver.navigate().back();
        clear();
        System.out.println("Case 37 Pass");
    }
    //Check app: "Order" Column
    public void Case42_outOfVisit(){
        System.out.println("Testing Case 42");
        orderPC_outOfVisit();
        orderBox_outOfVisit();
        System.out.println("Case 42 Pass");
    }
    //Check app: "Order" Column
    public void Case43_outOfVisit(){
        System.out.println("Testing Case 43");
        tradeInventoryPC_outOfVisit();
        System.out.println("Case 43 Pass");
    }



    //Check Summary Menu "Clear All"
    public void Case32a(){
        System.out.println("Testing Case 32");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clear();
//        //CANCEL BTN
//        MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button2')]");
//        clckCancel.click();
        System.out.println("Case 32 Pass");
    }
    //Check Summary Menu "Transaction List" !!NEED TO ORDER FIRST!! MAKE AN ORDER SCRIPT
    public void Case33a(){
        System.out.println("Testing Case 33");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click triple Dots
        MobileElement clckDots = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls') and @index = '0']");
        clckDots.click();
        //Click TransactionList
        MobileElement clckTrnsctn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'btn_trnsctn_list')]");
        clckTrnsctn.click();
        driver.navigate().back();
        driver.navigate().back();
        System.out.println("Case 33 Pass");
    }
    // Check Transaction List "Window"
    //adjust scripting
    public void Case34a(){
        System.out.println("Testing Case 34");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click triple Dots
        MobileElement clckDots1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls') and @index = '0']");
        clckDots1.click();
        //Click TransactionList
        MobileElement clckTrnsctn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'btn_trnsctn_list')]");
        clckTrnsctn.click();
        //Click TransactionList
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        MobileElement SelectTrnsctn = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.RecyclerView[@index='0']/android.widget.LinearLayout[@index='0']");
        SelectTrnsctn.click();
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //SELECT ACTION Adjust
        MobileElement clckAdjust = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        clckAdjust.click();
//        //SELECT ACTION Cancel
//        MobileElement clckCancel1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2']");
//        clckCancel1.click();
        //When Adjust is selected
        //Ok
        MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        clckOk.click();
        //Insert Adjust Script
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Enter Value on Trade Inventory
//        MobileElement tradeField = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
//                "/android.widget.HorizontalScrollView[@index='1']" +
//                "/android.widget.LinearLayout[@index='0']" +
//                "/android.widget.ScrollView[@index='1']" +
//                "/android.widget.LinearLayout[@index='0']" +
//                "/android.widget.LinearLayout[@index='0']" +
//                "/android.widget.LinearLayout[@index='1']" +
//                "/android.widget.LinearLayout[@index='0']");
//        tradeField.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(new PointOption().withCoordinates(390, 410)).perform();
        }

        //Value to be enter 25
        MobileElement clckNO6 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_2') and @index = '1']");
        clckNO6.click();
        MobileElement clckNO0 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_5') and @index = '1']");
        clckNO0.click();
        //Click ok
        MobileElement clckOk1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk1.click();
        //Three dot
        MobileElement clckDots2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls') and @index = '0']");
        clckDots2.click();
        //Final edit
        MobileElement finalEdit = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'btn_finalize') and @index = '1']");
        finalEdit.click();
        //cntact detail
        MobileElement cntctField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_contact_detail')]");
        cntctField.sendKeys(customerCont[rand(customerCont.length-1)]);
        driver.hideKeyboard();
        //reason field
        MobileElement rsnField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_edit_reason')]");
        rsnField.sendKeys("Just want to adjust");
        driver.hideKeyboard();
        //click save
        MobileElement saveBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'btn_save') and @index = '2']");
        saveBtn1.click();
        //save
        MobileElement saveBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1') and @index = '1']");
        saveBtn2.click();
        //Transaction no
        MobileElement cnclBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button2') and @index = '0']");
        cnclBtn1.click();
        driver.navigate().back();
        //
        MobileElement yesBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1') and @index = '1']");
        yesBtn1.click();

//        //Cancel
//        MobileElement clckCancel2 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2']");
//        clckCancel2.click();
        System.out.println("Case 34 Pass");

    }
    //Check Summary Menu "Finalize"
    public void Case35a(){
        System.out.println("Testing Case 35");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        orderTransac();
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click triple Dots
        MobileElement clckDots = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls') and @index = '0']");
        clckDots.click();
        //Click Finalize
        MobileElement clckTrnsctn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'btn_finalize')]");
        clckTrnsctn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Enter P.O Number
        MobileElement POnuFIELD = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_po_number')]");
        POnuFIELD.sendKeys(ranNum[rand(ranNum.length-1)]);
        //Enter Sales Invoice Number
        MobileElement INField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_si_number')]");
        INField.sendKeys(ranNum[rand(ranNum.length-1)]);
        //Enter Customer Name
        MobileElement custField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_customer_name')]");
        custField.sendKeys(customerName[rand(customerName.length-1)]);
        //Enter Customer Name
        MobileElement cntctField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_contact_detail')]");
        cntctField.sendKeys(customerCont[rand(customerCont.length-1)]);
        //Hide keyboard
        driver.hideKeyboard();
        //Click save
        MobileElement saveBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'btn_save')]");
        saveBtn.click();
        //Click yes
        MobileElement yesBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        yesBtn1.click();
        //Click no
        MobileElement noBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2')]");
        noBtn.click();
        //Click arrow
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        arrowBtn.click();
        //Click yes
        MobileElement yesBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        yesBtn2.click();
        System.out.println("Case 35 Pass");
    }
    // Check Finalise: "Print" !!!!!THIS NEED PRINTER!!!!!!! manual testing
    public void Case36a(){
        System.out.println("Testing Case 36");
        orderTransac();
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click triple Dots
        MobileElement clckDots = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls') and @index = '0']");
        clckDots.click();
        //Click Finalize
        MobileElement clckTrnsctn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'btn_finalize')]");
        clckTrnsctn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Enter P.O Number
        MobileElement POnuFIELD = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_po_number')]");
        POnuFIELD.sendKeys(ranNum[rand(ranNum.length-1)]);
        //Enter Sales Invoice Number
        MobileElement INField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_si_number')]");
        INField.sendKeys(ranNum[rand(ranNum.length-1)]);
        //Enter Customer Name
        MobileElement custField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_customer_name')]");
        custField.sendKeys(customerName[rand(customerName.length-1)]);
        //Enter Customer Name
        MobileElement cntctField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_contact_detail')]");
        cntctField.sendKeys(customerCont[rand(customerCont.length-1)]);
        //Hide keyboard
        driver.hideKeyboard();
        //Click save
        MobileElement saveBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'btn_save')]");
        saveBtn.click();
        //Click yes
        MobileElement yesBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        yesBtn1.click();
        //Click no
        MobileElement noBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2')]");
        noBtn1.click();
        //Click print
        MobileElement printBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'btn_print')]");
        printBtn.click();
        //Select Printer
        MobileElement selPrintBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'btn_select_printer')]");
        selPrintBtn.click();
        //Yes bluetooth
        MobileElement yesBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        yesBtn2.click();
        //wait for atleast 5 to 10 secs to look for bluetooth devices
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //If there is no paired bluetooth device found
        MobileElement bluBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2')]");
        bluBtn.click();
        driver.navigate().back();
        //Click arrow
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        arrowBtn.click();
        //Click yes
        MobileElement yesBtn3 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        yesBtn3.click();
        System.out.println("Case 36 Pass");
    }
    //Check "Product" Column
    public void Case37a(){
        System.out.println("Testing Case 37");
        //Click on product1 column
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckProd1 = (MobileElement) driver.findElementByXPath( vaofDrctryTbl+
                "android.widget.LinearLayout[@index='0']/" +
                "android.widget.ScrollView[@index='1']/" +
                "android.widget.LinearLayout[@index='0']/" +
                "android.widget.LinearLayout[@index='0']/" +
                "android.widget.LinearLayout[@index='0']");
        clckProd1.click();
        driver.navigate().back();
        //Click on product2 column
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckProd2 = (MobileElement) driver.findElementByXPath( vaofDrctryTbl+
                "android.widget.LinearLayout[@index='0']/" +
                "android.widget.ScrollView[@index='1']/" +
                "android.widget.LinearLayout[@index='0']/" +
                "android.widget.LinearLayout[@index='1']/" +
                "android.widget.LinearLayout[@index='0']");
        clckProd2.click();
        driver.navigate().back();
        //Click on product3 column
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckProd3 = (MobileElement) driver.findElementByXPath( vaofDrctryTbl+
                "android.widget.LinearLayout[@index='0']/" +
                "android.widget.ScrollView[@index='1']/" +
                "android.widget.LinearLayout[@index='0']/" +
                "android.widget.LinearLayout[@index='2']/" +
                "android.widget.LinearLayout[@index='0']");
        clckProd3.click();
        driver.navigate().back();
        System.out.println("Case 37 Pass");

    }
    //Check "Unit" Column
    public void Case38a(){
        System.out.println("Testing Case 38");
        //1st click
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
//            TouchAction touchAction = new TouchAction(driver);
//            touchAction.tap(new PointOption().withCoordinates(200, 250)).perform();
            MobileElement unit = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.TextView[@index='1']");
            unit.click();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement element2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_uom_filtered') and @text='Uom filtered by smallest']");
        boolean isDisplayed2 = element2.isDisplayed();
        if (isDisplayed2) {
//            TouchAction touchAction = new TouchAction(driver);
//            touchAction.tap(new PointOption().withCoordinates(200, 300)).perform();
            MobileElement unit = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.TextView[@index='1']");
            unit.click();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement element3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_uom_filtered') and @text='Uom filtered by biggest']");
        boolean isDisplayed3 = element3.isDisplayed();
        if (isDisplayed3) {
//            TouchAction touchAction = new TouchAction(driver);
//            touchAction.tap(new PointOption().withCoordinates(200, 300)).perform();
            MobileElement unit = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.TextView[@index='1']");
            unit.click();
        }
        System.out.println("Case 38 Pass");

    }
    //Check "Order" Column
    public void Case39a(){
        System.out.println("Testing Case 39");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Click order column without entering first on Trade Inventory
//        MobileElement orderField = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
//                "/android.widget.HorizontalScrollView[@index='1']" +
//                "/android.widget.LinearLayout[@index='0']" +
//                "/android.widget.ScrollView[@index='1']" +
//                "/android.widget.LinearLayout[@index='0']" +
//                "/android.widget.LinearLayout[@index='0']" +
//                "/android.widget.LinearLayout[@index='0']" +
//                "/android.widget.LinearLayout[@index='0']");
//        orderField.click();
//        //need an ok button
//        MobileElement clckOk1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1') and @index = '0']");
//        clckOk1.click();
        //orderTransac(); //todo samsung error
//        orderPC();
        //not enough... inventory..
//        invalidOrderTransac();
        //need
        System.out.println("Case 39 Pass");

    }
    //Check "Inventory by UOM" Column walang laman sa script sa DOVOP
    public void Case40a(){

    }
    //Check "Inventory" Column
    public void Case41a(){
        System.out.println("Testing Case 41");
        //NEED TIME TO LOAD
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //swipe right to left
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.longPress(new PointOption().withCoordinates(460, 390)).moveTo(new PointOption().withCoordinates(220, 390)).release().perform();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Enter Value on Inventory Col
        MobileElement inventoryField = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='2']" );
        inventoryField.click();
        MobileElement inventoryField1 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='2']" );
        inventoryField1.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Enter Value on Inventory Col
        MobileElement inventoryField2 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='2']" );
        inventoryField2.click();
        MobileElement inventoryField3 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='2']" );
        inventoryField3.click();
        //Insert clear
        clear();
        System.out.println("Case 41 Pass");

    }
    //Check "Stock Availability" Column need swipe
    public void Case42a(){
        System.out.println("Testing Case 42");
        //NEED TIME TO LOAD LOL
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //swipe right to left
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            for(int j = 0; j<2 ; j++) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                TouchAction touchAction = new TouchAction(driver);
                touchAction.longPress(new PointOption().withCoordinates(460, 390)).moveTo(new PointOption().withCoordinates(170, 390)).release().perform();
            }
        }
        //Clck Stock Availability
        MobileElement stckField = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='5']");
        stckField.click();
        System.out.println("Case 42 Pass");
    }
    //Check "Stock Weight" Column need swipe
    public void Case43a(){
        System.out.println("Testing Case 43");
        //NEED TIME TO LOAD LOL
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            for(int j = 0; j<3 ; j++) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                TouchAction touchAction = new TouchAction(driver);
                touchAction.longPress(new PointOption().withCoordinates(460, 390)).moveTo(new PointOption().withCoordinates(190, 390)).release().perform();
            }
        }
        //Clck Stock Weight
        MobileElement stckWField1 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='6']");
        stckWField1.click();
        MobileElement stckWField2 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='6']");
        stckWField2.click();
        MobileElement stckWField3 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='6']");
        stckWField3.click();
        System.out.println("Case 43 Pass");

    }
    //Check "Return From Trade" Column need swipe
    public void Case44a(){
        System.out.println("Testing Case 44");
        //NEED TIME TO LOAD
        //swipe right to left
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.longPress(new PointOption().withCoordinates(460, 390)).moveTo(new PointOption().withCoordinates(220, 390)).release().perform();
        }
        //Enter Value on Trade Inventory
//        TouchAction touchAction = new TouchAction(driver);
//        touchAction.longPress(new PointOption().withCoordinates(240, 390)).moveTo(new PointOption().withCoordinates(460, 390)).release().perform();
        MobileElement rfTradeField = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='3']" +
                "/android.widget.LinearLayout[@index='0']");
        rfTradeField.click();
        //Click on ok
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement okBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        okBtn.click();
        System.out.println("Case 44 Pass");
    }
    /**
     //Check "LO" Column empty????
     public void Case45(){
     }
     //Check "Last Trade Inventory" Column EMPTY!???
     public void Case46(){
     }
     //Check "LO + LTI" Column
     public void Case47(){
     }
     **/ //walang laman sa doovop
    //Check "Trade Inventory" Column
    public void Case48a(){
        for (int b=0; b<2; b++){
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.longPress(new PointOption().withCoordinates(240, 390)).moveTo(new PointOption().withCoordinates(460, 390)).release().perform();
        }
        orderTransac();
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click triple Dots
        MobileElement clckDots = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls') and @index = '0']");
        clckDots.click();
        //Click Finalize
        MobileElement clckTrnsctn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'btn_finalize')]");
        clckTrnsctn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Enter P.O Number
        MobileElement POnuFIELD = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_po_number')]");
        POnuFIELD.sendKeys(ranNum[rand(ranNum.length-1)]);
        //Enter Sales Invoice Number
        MobileElement INField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_si_number')]");
        INField.sendKeys(ranNum[rand(ranNum.length-1)]);
        //Enter Customer Name
        MobileElement custField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_customer_name')]");
        custField.sendKeys(customerName[rand(customerName.length-1)]);
        //Enter Customer Name
        MobileElement cntctField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_contact_detail')]");
        cntctField.sendKeys(customerCont[rand(customerCont.length-1)]);
        //Hide keyboard
        driver.hideKeyboard();
        //Click save
        MobileElement saveBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'btn_save')]");
        saveBtn.click();
        //Click yes
        MobileElement yesBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        yesBtn1.click();
        //Click no
        MobileElement noBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2')]");
        noBtn.click();
        //Click arrow
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        arrowBtn.click();
        //Click yes
        MobileElement yesBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        yesBtn2.click();
        System.out.println("Order COMPLETE!");
        System.out.println("Case 48 Pass");
    }
    //VAOF SUMMARY NO PRODUCT NAME ????
    public void Case49a(){
        SearchVanSum();

    }

    //FUNCTIONS
    public void vaofLogInToVisit(){
        for (int x = 1; x <=1; x++) {
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
            //click on Ok
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
            okBtn.click();

            //Cases
            SearchVan();
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
            Case24();
            Case25();
            Case26();
            Case27();
            Case28();
            Case29();
            Case30();
            Case31();
            Case32();
            Case33();
            Case34();
            Case35();
            Case37();
            Case39();
            Case41();
            Case42();
            Case43();
            Case44();
            Case45();
            Case46();
            Case47();
            Case48();
            clear();
            //Log out to visit
            completeOrderTransactionWithPayment();
            completeOrderTransactionWithOutPayment();
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
    //Search By Functions
    private void searchByName(){
        System.out.println("Searching by Name");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement name = (MobileElement) driver.findElementByXPath("//android.widget.RadioGroup/android.widget.RadioButton[1]");
        name.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementById("android:id/button1");
        filterBtn.click();
    }
    private void searchByShortName(){
        System.out.println("Searching by Short Name");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement shortName = (MobileElement) driver.findElementByXPath("//android.widget.RadioGroup/android.widget.RadioButton[2]");
        shortName.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementById("android:id/button1");
        filterBtn.click();
    }
    private void searchByCode(){
        System.out.println("Searching by Code");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement code = (MobileElement) driver.findElementByXPath("//android.widget.RadioGroup/android.widget.RadioButton[3]");
        code.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementById("android:id/button1");
        filterBtn.click();
    }
    private void searchByBarcode(){
        System.out.println("Searching by Barcode");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement barcode = (MobileElement) driver.findElementByXPath("//android.widget.RadioGroup/android.widget.RadioButton[4]");
        barcode.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementById("android:id/button1");
        filterBtn.click();
    }
    private void searchByDescription(){
        System.out.println("Searching by Description");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement description = (MobileElement) driver.findElementByXPath("//android.widget.RadioGroup/android.widget.RadioButton[5]");
        description.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementById("android:id/button1");
        filterBtn.click();
    }
    private void searchByBrand(){
        System.out.println("Searching by Brand");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement brand = (MobileElement) driver.findElementByXPath("//android.widget.RadioGroup/android.widget.RadioButton[6]");
        brand.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementById("android:id/button1");
        filterBtn.click();
    }
    private void searchByKeyword(){
        System.out.println("Searching by Keyword");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement keyword = (MobileElement) driver.findElementByXPath("//android.widget.RadioGroup/android.widget.RadioButton[7]");
        keyword.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementById("android:id/button1");
        filterBtn.click();
    }
    //Filter By Functions
    private void prodFilterByAllProd(){
        System.out.println("Product Filter By All Product");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Allproduct
        MobileElement allProd = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_all");
        allProd.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void prodFilterByProdGroup(){
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Product Group
        MobileElement prodGroup = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_product_group");
        prodGroup.click();
        //Click on Certain  Product Group
        MobileElement selProdGroup = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.TextView[1]");
        selProdGroup.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void prodFilterByMustCarry(){
        System.out.println("Product Filter By Must Carry");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Must Carry
        MobileElement mustCarry = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_must_carry");
        mustCarry.click();
        //Click on Certain Must Carry
        MobileElement selMustCarry = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.TextView[1]");
        selMustCarry.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void prodFilterByBrand(){
        System.out.println("Product Filter By Brand");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Brand
        MobileElement brand = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_brand");
        brand.click();
        //Click on Certain Must Carry
        MobileElement selMustCarry = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.TextView[1]");
        selMustCarry.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void prodFilterByHistoricalSalesVolume(){
        System.out.println("Product Filter By Historical Sales Sort By Volume");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Historical Sales
        MobileElement historicalSales = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_w_historical_sales");
        historicalSales.click();
        //Click on Volume
        MobileElement selVolume = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.TextView[1]");
        selVolume.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void prodFilterByHistoricalSalesValue(){
        System.out.println("Product Filter By Historical Sales Sort By Value");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Historical Sales
        MobileElement historicalSales = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_w_historical_sales");
        historicalSales.click();
        //Click on Value
        MobileElement selValue = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.TextView[2]");
        selValue.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void prodFilterByMustCarryHistoricalSalesVolume(){
        System.out.println("Product Filter By Must Carry + Historical Sales Sort By Volume");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Must Carry + Historical Sales
        MobileElement historicalSales = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_must_carry_w_historical_sales");
        historicalSales.click();
        //Click on Certain Must Carry
        MobileElement selMustCarry = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.TextView[1]");
        selMustCarry.click();
        //Click on Volume
        MobileElement selVolume = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.TextView[1]");
        selVolume.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void prodFilterByMustCarryHistoricalSalesValue(){
        System.out.println("Product Filter By Must Carry + Historical Sales Sort By Volume");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Must Carry + Historical Sales
        MobileElement historicalSales = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_must_carry_w_historical_sales");
        historicalSales.click();
        //Click on Certain Must Carry
        MobileElement selMustCarry = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.TextView[1]");
        selMustCarry.click();
        //Click on Value
        MobileElement selValue = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.TextView[2]");
        selValue.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void prodFilterByDocuSequence(){
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Document Sequence
        MobileElement docuSeq = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_document_sequence");
        docuSeq.click();
        //Click on Certain  Product Group
        MobileElement selProdGroup = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.TextView[1]");
        selProdGroup.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void prodFilterByDeal(){
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Deals
        MobileElement deal = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_deals");
        deal.click();
        //Click on Certain  Product Group
        MobileElement selProdGroup = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.TextView[1]");
        selProdGroup.click();
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement btnOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
        btnOk.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement minimumQuantity = (MobileElement) driver.findElementById("com.engagia.android:id/txt_multiplier");
        minimumQuantity.sendKeys("1");
        MobileElement ok = (MobileElement) driver.findElementById("android:id/button1");
        ok.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void prodFilterByActiveProd(){
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Active Products
        MobileElement activeProd = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_active");
        activeProd.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void prodFilterByCarriedProd(){
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Carried Products
        MobileElement carriedProd = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_carried");
        carriedProd.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void prodFilterByNotCarriedProd(){
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Click Not Carried Products
        MobileElement notCarriedProd = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_not_carried");
        notCarriedProd.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void infoFilterByNone(){
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement infoFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_information_filter");
        infoFilter.click();
        //Click None
        MobileElement infoNone = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_information_none");
        infoNone.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void infoFilterByProductsWithInputs(){
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement infoFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_information_filter");
        infoFilter.click();
        //Click Products with Inputs
        MobileElement prodWithInputs = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_information_with_inputs");
        prodWithInputs.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void infoFilterByProductsWithoutStock(){
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement infoFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_information_filter");
        infoFilter.click();
        //Click Product without Stock
        MobileElement prodWithoutStock = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_information_without_stock");
        prodWithoutStock.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void infoFilterByProductsWithStock(){
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement infoFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_information_filter");
        infoFilter.click();
        //Click Product without Stock
        MobileElement prodWithoutStock = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_information_without_stock");
        prodWithoutStock.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void infoFilterByReturnable(){
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement infoFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_information_filter");
        infoFilter.click();
        //Click Returnable
        MobileElement prodReturnable = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_information_returnable");
        prodReturnable.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void infoFilterBy631(){
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement infoFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_information_filter");
        infoFilter.click();
        //Click Product 631
        MobileElement prod631 = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_information_6_3_1");
        prod631.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void infoFilterByProductsWithOrder(){
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement infoFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_information_filter");
        infoFilter.click();
        //Click Product with Order
        MobileElement prodWithOrder = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_information_with_order");
        prodWithOrder.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void infoFilterByStocksAvailNoStock(){
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement infoFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_information_filter");
        infoFilter.click();
        //Click Product Stock Availability No Stock
        MobileElement prodStockAvailNoStock = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_information_stock_availability_no_stock");
        prodStockAvailNoStock.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void infoFilterByStocksAvailWithStock(){
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement infoFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_information_filter");
        infoFilter.click();
        //Click Product Stock Availability No Stock
        MobileElement prodStockAvailWithStock = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_information_stock_availability_with_stock");
        prodStockAvailWithStock.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void infoFilterByStockWeightLow(){
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement infoFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_information_filter");
        infoFilter.click();
        //Click Product Stock Weight = Low
        MobileElement prodStockAvailWithStock = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_information_stock_weight_low");
        prodStockAvailWithStock.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void infoFilterByStockWeightMed(){
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement infoFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_information_filter");
        infoFilter.click();
        //Click Product Stock Weight = Med
        MobileElement prodStockAvailWithStock = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_information_stock_weight_medium");
        prodStockAvailWithStock.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void infoFilterByStockWeightHigh(){
        System.out.println("Product Filter By Product Group");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement infoFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_information_filter");
        infoFilter.click();
        //Click Product Stock Weight = High
        MobileElement prodStockAvailWithStock = (MobileElement) driver.findElementById("com.engagia.android:id/txt_filter_information_stock_weight_high");
        prodStockAvailWithStock.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }

    //Order functions
    private void orderPC(){
        for(int z = 1; z<=3; z++) {
            try {
                //1st Product per PC
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement orderPC = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout[" + z + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView");
                orderPC.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Enter random numbers
                randomNum();
                MobileElement btnOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
                btnOk.click();
                System.out.println("Order PC " + z + " done");
            }
            catch (NoSuchElementException e){
                System.out.println("Can't Find Element");
            }
        }
    }
    private void orderNegativePC(){
        for(int z = 1; z<=3; z++) {
            try {
                //1st Product per PC
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                MobileElement orderPC = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout[" + z + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView");
                orderPC.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Enter negative numbers
                MobileElement subtractBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_subtract");
                subtractBtn.click();
                randomNum();
                MobileElement btnOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
                btnOk.click();
                driver.navigate().back();
                System.out.println("Order Negative PC " + z + " done");
            }
            catch (NoSuchElementException e){
                System.out.println("Can't Find Element");
            }
        }
    }
    private void deleteOrderPC(){
        for(int z = 1; z<=3; z++) {
            try {
                //1st Product per PC
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                MobileElement orderPC = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout["+z+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView");
                orderPC.click();
                //Click Delete btn
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement deleteBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_clr");
                deleteBtn.click();
                MobileElement btnOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
                btnOk.click();
                System.out.println("Delete Order PC "+z+" done");
            }
            catch (NoSuchElementException e){
                System.out.println("Can't Find Element");
            }
        }
    }
    private void orderBox(){
        for(int z = 1; z<=3; z++) {
            try {
                //1st Product per Box
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement orderBox = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout[" + z + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView");
                orderBox.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Enter random numbers
                randomNum();
                MobileElement btnOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
                btnOk.click();
                System.out.println("Order Box " + z + " done");
            }
            catch (NoSuchElementException e){
                System.out.println("Can't Find Element");
            }
        }
    }
    private void orderNegativeBox(){
        for(int z = 1; z<=3; z++) {
            try {
            //1st Product per PC
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                MobileElement orderBox = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout["+z+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView");
                orderBox.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Enter negative numbers
                MobileElement subtractBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_subtract");
                subtractBtn.click();
                randomNum();
                MobileElement btnOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
                btnOk.click();
                driver.navigate().back();
                System.out.println("Order Negative Box "+z+" done");
            }
            catch (NoSuchElementException e){
                System.out.println("Can't Find Element");
            }
        }
    }
    private void deleteOrderBox(){
        for(int z = 1; z<=3; z++) {
            try {
                //1st Product per PC
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                MobileElement orderBox = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout[" + z + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView");
                orderBox.click();
                //Click Delete btn
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement deleteBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_clr");
                deleteBtn.click();
                MobileElement btnOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
                btnOk.click();
                System.out.println("Delete Order Box " + z + " done");
            }
            catch (NoSuchElementException e){
                System.out.println("Can't Find Element");
            }
        }
    }
    private void orderPC_outOfVisit(){
        for(int z = 1; z<=3; z++) {
            try {
                //1st Product per PC
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                MobileElement orderPC = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout[" + z + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView");
                orderPC.click();
                System.out.println("Order PC out of Visit " + z + " done");
            }
            catch (NoSuchElementException e){
                System.out.println("Can't Find Element");
            }
        }
    }
    private void orderBox_outOfVisit(){
        for(int z = 1; z<=3; z++) {
            try {
                //1st Product per PC
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                MobileElement orderBox = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout["+z+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView");
                orderBox.click();
                System.out.println("Order Box out of Visit "+z+" done");
            }
            catch (NoSuchElementException e){
                System.out.println("Can't Find Element");
            }
        }
    }
    private void viewProductSummary(){
        for(int z = 1; z<=3; z++) {
            MobileElement clickProd = (MobileElement) driver.findElementByXPath(productDrctry+"/android.widget.LinearLayout["+z+"]/android.widget.LinearLayout[1]/android.widget.TextView");
            clickProd.click();
            MobileElement arrowRight = (MobileElement) driver.findElementById("com.engagia.android:id/pager_next");
            arrowRight.click();
            MobileElement arrowLeft = (MobileElement) driver.findElementById("com.engagia.android:id/pager_previous");
            arrowLeft.click();
            driver.navigate().back();
        }
    }

    private void completeOrderTransactionWithPayment(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement arrow = (MobileElement) driver.findElementById("com.engagia.android:id/custom_table_next_pagination");
        while(arrow != null) {
            orderPC();
            orderBox();
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
            } catch (NoSuchElementException e) {
                System.out.println("Save");
                break;
            }
        }
        //Insert finalize here
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement summaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
        summaryMenu.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement finalize = (MobileElement) driver.findElementById("com.engagia.android:id/btn_finalize");
        finalize.click();
        //Try catch for deal
        try{
            MobileElement dealBox = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.CheckBox");
            dealBox.click();
            MobileElement nextBtn = (MobileElement) driver.findElementById("android:id/button1");
            nextBtn.click();
            MobileElement reward = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RadioGroup");
            reward.click();
            MobileElement ok = (MobileElement) driver.findElementById("android:id/button1");
            ok.click();
        }
        catch (NoSuchElementException e){
            System.out.println("Walang deals");
        }
        finalizeOrderInput();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement btnSave = (MobileElement) driver.findElementById("com.engagia.android:id/btn_save");
        btnSave.click();
        MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
        yesBtn.click();
        yesBtn.click();
        //INSERT APPLY PAYMENT METHOD HERE
        applyPayment();
        finalizeOrder();
    }
    private void completeOrderTransactionWithOutPayment(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement arrow = (MobileElement) driver.findElementById("com.engagia.android:id/custom_table_next_pagination");
        while(arrow != null) {
            orderPC();
            orderBox();
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
            } catch (NoSuchElementException e) {
                System.out.println("Save");
                break;
            }
        }
        //Insert finalize here
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement summaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
        summaryMenu.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement finalize = (MobileElement) driver.findElementById("com.engagia.android:id/btn_finalize");
        finalize.click();
        //Try catch for deal
        try{
            MobileElement dealBox = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.CheckBox");
            dealBox.click();
            MobileElement nextBtn = (MobileElement) driver.findElementById("android:id/button1");
            nextBtn.click();
            MobileElement reward = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RadioGroup");
            reward.click();
            MobileElement ok = (MobileElement) driver.findElementById("android:id/button1");
            ok.click();
        }
        catch (NoSuchElementException e){
            System.out.println("Walang deals");
        }
        finalizeOrderInput();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement btnSave = (MobileElement) driver.findElementById("com.engagia.android:id/btn_save");
        btnSave.click();
        MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
        yesBtn.click();
        MobileElement noBtn = (MobileElement) driver.findElementById("android:id/button2");
        noBtn.click();
        MobileElement backBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_back");
        backBtn.click();
        yesBtn.click();
    }
    //Trade Inventory
    private void tradeInventoryPC(){
        for(int z = 1; z<=3; z++) {
            //1st Product per PC
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            MobileElement tradeInventoryPC1 = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout["+z+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
            tradeInventoryPC1.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            randomNum();
            MobileElement btnOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
            btnOk.click();
            System.out.println("Trade Inventory "+z+" done");
        }
    }
    private void deleteTradeInventoryPC(){
        for(int z = 1; z<=3; z++) {
            //1st Product per PC
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            MobileElement tradeInventoryPC1 = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout["+z+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
            tradeInventoryPC1.click();
            //Click Delete btn
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            MobileElement deleteBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_clr");
            deleteBtn.click();
            MobileElement btnOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
            btnOk.click();
            System.out.println("Delete Trade Inventory "+z+" done");
        }
    }
    private void tradeNegativeInventoryPC(){
        for(int z = 1; z<=3; z++) {
            //1st Product per PC
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            MobileElement tradeInventoryPC1 = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout["+z+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
            tradeInventoryPC1.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter negative numbers
            MobileElement subtractBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_subtract");
            subtractBtn.click();
            randomNum();
            MobileElement btnOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
            btnOk.click();
            driver.navigate().back();
            System.out.println("Trade Negative Inventory "+z+" done");
        }
    }
    private void tradeInventoryPC_outOfVisit(){
        for(int z = 1; z<=3; z++) {
            //1st Product per PC
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            MobileElement tradeInventoryPC1 = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout["+z+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
            tradeInventoryPC1.click();
            System.out.println("Trade Inventory "+z+" done");
        }
    }
    //Inventory
    private void inventory(){
        for(int z = 1; z<=3; z++) {
            //1st Product per PC
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            MobileElement orderPC1 = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout[" + z + "]/android.widget.LinearLayout[2]/android.widget.TextView");
            orderPC1.click();
            System.out.println("Inventory Click");
        }
    }
    //Return From Trade
    private void returnFromTrade(){
        for(int z = 1; z<=3; z++) {
            //1st Product per PC
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            MobileElement returnFromTrade = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout["+z+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
            returnFromTrade.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            randomNum();
            MobileElement btnOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
            btnOk.click();
            System.out.println("Trade Inventory "+z+" done");
        }
    }
    //Return From Trade with product with no bottle
    private void returnFromTradeNoReturnable(){
        //PC
        for(int z = 1; z<=3; z++) {
            //1st Product per PC
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            MobileElement returnFromTrade = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout["+z+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
            returnFromTrade.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            MobileElement Ok = (MobileElement) driver.findElementById("android:id/button1");
            Ok.click();
            System.out.println("Trade Inventory "+z+" done");
        }
        //Box
        for(int x = 1; x<=3; x++) {
            //1st Product per PC
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            MobileElement returnFromTrade = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout["+x+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView");
            returnFromTrade.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            MobileElement Ok = (MobileElement) driver.findElementById("android:id/button1");
            Ok.click();
            System.out.println("Trade Inventory "+x+" done");
        }
    }
    private void returnFromTrade_outOfVisit(){
        for(int z = 1; z<=3; z++) {
            //PC AND BOX OF RETURN FROM TRADE
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            MobileElement returnFromTradePC = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout["+z+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
            returnFromTradePC.click();
            MobileElement returnFromTradeBox = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout["+z+"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
            returnFromTradeBox.click();
            System.out.println("Return From Trade "+z+" done");
        }
    }
    //Stock Availability
    private void stockAvail(){
        for(int z = 1; z<=3; z++) {
            //1st Product per PC
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            MobileElement stockAvailability = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout[" + z + "]/android.widget.LinearLayout[1]/android.widget.TextView");
            stockAvailability.click();
            System.out.println("Stock Availability Click");
        }
    }
    //Stock Weight
    private void stockWeight(){
        for(int z = 1; z<=3; z++) {
            //1st Product per PC
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            MobileElement stockWeight = (MobileElement) driver.findElementByXPath(orderDrctry + "/android.widget.LinearLayout[" + z + "]/android.widget.LinearLayout[1]/android.widget.TextView");
            stockWeight.click();
            System.out.println("Stock Weight Click");
        }
    }


    private void finalizeOrderInput(){
        MobileElement poNumber = (MobileElement) driver.findElementById("com.engagia.android:id/input_po_number");
        poNumber.sendKeys("123456");
        MobileElement salesInvoiceNumber = (MobileElement) driver.findElementById("com.engagia.android:id/input_si_number");
        salesInvoiceNumber.sendKeys("654321");
        MobileElement custName = (MobileElement) driver.findElementById("com.engagia.android:id/input_customer_name");
        custName.sendKeys("John Roe");
        MobileElement contactDetails = (MobileElement) driver.findElementById("com.engagia.android:id/input_contact_detail");
        contactDetails.sendKeys("0917 XXX XXXX");
        driver.hideKeyboard();
    }
    private void addDeduction(){
        System.out.println("Adding Deduction");
        //ADD/EDIT Deduction
        MobileElement addDeduction = (MobileElement) driver.findElementById("com.engagia.android:id/txt_total_deduction");
        addDeduction.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement addItem = (MobileElement) driver.findElementById("com.engagia.android:id/item_add");
        addItem.click();
        //Deduction Type
        for(int w = 1; w<= 4; w++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement deductionType = (MobileElement) driver.findElementById("com.engagia.android:id/spinner_deduction_type");
            deductionType.click();
            MobileElement selectDeductionType = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView["+w+"]");
            selectDeductionType.click();
        }
        //Transaction P.O/S.I.
        MobileElement transactionPOSI = (MobileElement) driver.findElementById("com.engagia.android:id/spinner_transaction_po_si");
        transactionPOSI.click();
//        MobileElement clickPanel = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout");
//        clickPanel.click();
        driver.navigate().back();
        MobileElement docuName = (MobileElement) driver.findElementById("com.engagia.android:id/input_document_name");
        docuName.sendKeys("DocuName");
        MobileElement docuNum = (MobileElement) driver.findElementById("com.engagia.android:id/input_document_number");
        docuNum.sendKeys("12345");
        driver.hideKeyboard();
        MobileElement docuValueApplied = (MobileElement) driver.findElementById("com.engagia.android:id/input_document_value");
        docuValueApplied.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement calcuBtn1 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_1");
        calcuBtn1.click();
        MobileElement calcuBtn0 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_0");
        calcuBtn0.click();
        MobileElement calcuOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
        calcuOk.click();
        MobileElement docuDate = (MobileElement) driver.findElementById("com.engagia.android:id/input_document_date");
        docuDate.click();
        //Insert code here if you want to modify the date
        MobileElement calendarOkBtn = (MobileElement) driver.findElementById("android:id/button1");
        calendarOkBtn.click();
        MobileElement saveDocu = (MobileElement) driver.findElementById("com.engagia.android:id/item_save");
        saveDocu.click();
        MobileElement back = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
        back.click();
    }
    private void addCheckAmount(){
        System.out.println("Adding Check Amount");
        //Select Total Check Amount
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement addCheckAmount = (MobileElement) driver.findElementById("com.engagia.android:id/txt_total_check_amount");
        addCheckAmount.click();
        MobileElement addItem = (MobileElement) driver.findElementById("com.engagia.android:id/item_add");
        addItem.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement bankName = (MobileElement) driver.findElementById("com.engagia.android:id/input_bank_name");
        bankName.sendKeys("BankName");
        MobileElement checkNumber = (MobileElement) driver.findElementById("com.engagia.android:id/input_check_number");
        checkNumber.sendKeys("123456");
        MobileElement checkAmount = (MobileElement) driver.findElementById("com.engagia.android:id/input_check_amount");
        checkAmount.click();
        MobileElement calcuBtn1 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_1");
        calcuBtn1.click();
        MobileElement calcuBtn0 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_0");
        calcuBtn0.click();
        calcuBtn0.click();
        MobileElement calcuOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
        calcuOk.click();
        MobileElement checkDate = (MobileElement) driver.findElementById("com.engagia.android:id/input_check_date");
        checkDate.click();
        MobileElement inputCheckDate = (MobileElement) driver.findElementByAccessibilityId("28 February 2019");
        inputCheckDate.click();
        MobileElement calendarOk = (MobileElement) driver.findElementById("android:id/button1");
        calendarOk.click();
        MobileElement save = (MobileElement) driver.findElementById("com.engagia.android:id/item_save");
        save.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
        el2.click();

    }
    private void addCashAmount(){
        System.out.println("Adding Cash Amount");
        //Select Cash Amount
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cashAmount = (MobileElement) driver.findElementById("com.engagia.android:id/txt_total_cash_amount");
        cashAmount.click();
        //Edit this if you want to change the value to be entered on Cash Amount
        MobileElement calcuBtn1 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_1");
        calcuBtn1.click();
        MobileElement calcuBtn0 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_0");
        calcuBtn0.click();
        calcuBtn0.click();
        calcuBtn0.click();
        MobileElement calcuOK = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
        calcuOK.click();
    }
    private void applyPayment(){
        MobileElement nextItem = (MobileElement) driver.findElementById("com.engagia.android:id/item_next");
        nextItem.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement promptMessage = (MobileElement) driver.findElementById("android:id/parentPanel");
        boolean promptMessageDisplayed = promptMessage.isDisplayed();
        if (promptMessageDisplayed) {
            System.out.println("Prompt message of 'Please enter check or cash amount' with ok button displayed");
            MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
            okBtn.click();
        }
        for(int w = 1; w <= 4; w++){
            //Loop for Payment type
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement paymentType = (MobileElement) driver.findElementById("com.engagia.android:id/txt_payment_type");
            paymentType.click();
            if(w<=3){
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement selectPaymentType = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[" + w + "]");
                selectPaymentType.click();
            }
            else if(w == 4) {
                MobileElement selectPaymentType = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[1]");
                selectPaymentType.click();
            }
        }
        //Total Deduction
        addDeduction();
        //Total Check Amount
        addCheckAmount();
        //Cash Amount
        addCashAmount();
        //Click Next
        nextItem.click();
    }
    private void finalizeOrder(){
        MobileElement receiptDropdown = (MobileElement) driver.findElementById("com.engagia.android:id/btn_official_receipt_dropdown");
        receiptDropdown.click();
        MobileElement selectReceipt = (MobileElement) driver.findElementById("android:id/text1");
        selectReceipt.click();
        MobileElement inputReceiptNum = (MobileElement) driver.findElementById("com.engagia.android:id/input_receipt_number");
        inputReceiptNum.sendKeys("201900011");
        driver.hideKeyboard();
        MobileElement receiptDate = (MobileElement) driver.findElementById("com.engagia.android:id/input_receipt_date");
        receiptDate.click();
        //Calendar Cancel Btn
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement calendarCancel = (MobileElement) driver.findElementById("android:id/button2");
        calendarCancel.click();
        receiptDate.click();
        //Calendar Ok Btn
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement calendarOk = (MobileElement) driver.findElementById("android:id/button1");
        calendarOk.click();
        //Notes
        finalizeNote();
        //Picture
        finalizePicture();
        //Click save on Finalize
        MobileElement finalizeSave = (MobileElement) driver.findElementById("com.engagia.android:id/item_save");
        finalizeSave.click();
        MobileElement saveBack = (MobileElement) driver.findElementById("android:id/button2");
        saveBack.click();
        finalizeSave.click();
        MobileElement save = (MobileElement) driver.findElementById("android:id/button1");
        save.click();
        MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button1");
        dismissBtn.click();
        MobileElement back = (MobileElement) driver.findElementById("com.engagia.android:id/btn_back");
        back.click();
        MobileElement no = (MobileElement) driver.findElementById("android:id/button2");
        no.click();
        back.click();
        MobileElement yes = (MobileElement) driver.findElementById("android:id/button1");
        yes.click();
    }
    private void finalizeNote(){
        System.out.println("Adding Note");
        MobileElement notesBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_notes");
        notesBtn.click();
        MobileElement addNote = (MobileElement) driver.findElementById("com.engagia.android:id/list_item_var_note_add");
        addNote.click();
        MobileElement inputNote = (MobileElement) driver.findElementById("com.engagia.android:id/input_var_note");
        inputNote.sendKeys("VAOF Note");
        MobileElement saveNote = (MobileElement) driver.findElementById("android:id/button1");
        saveNote.click();
        MobileElement addedNote = (MobileElement) driver.findElementById("com.engagia.android:id/list_item_var_note");
        addedNote.click();
        saveNote.click();
        MobileElement removeNote = (MobileElement) driver.findElementByAccessibilityId("remove");
        removeNote.click();
        driver.navigate().back();
    }
    private void finalizePicture(){
        System.out.println("Adding Picture");
        for(int z=1; z<=5; z++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement pictureBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_picture");
            pictureBtn.click();
            if(z == 1){
                //Add Picture
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement cameraShutter = (MobileElement) driver.findElementById("com.simplemobiletools.camera:id/shutter");
                cameraShutter.click();
            }
            else if(z == 2){
                //View Picture Then click Back Btn
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement pictureBackBtn = (MobileElement) driver.findElementById("android:id/button3");
                pictureBackBtn.click();
            }
            else if(z == 3){
                //View Picture Then click Replace Btn and Camera will appear
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement pictureReplaceBtn = (MobileElement) driver.findElementById("android:id/button1");
                pictureReplaceBtn.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement cameraShutter = (MobileElement) driver.findElementById("com.simplemobiletools.camera:id/shutter");;
                cameraShutter.click();
            }
            else if(z == 4){
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement pictureDeleteBtn = (MobileElement) driver.findElementById("android:id/button2");
                pictureDeleteBtn.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noBtn = (MobileElement) driver.findElementById("android:id/button2");
                noBtn.click();
            }
            else if(z == 5){
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement pictureDeleteBtn = (MobileElement) driver.findElementById("android:id/button2");
                pictureDeleteBtn.click();
                MobileElement pictureYesBtn = (MobileElement) driver.findElementById("android:id/button1");
                pictureYesBtn.click();
            }
        }
    }



    public void orderBoxPCa() {
        //NEED TIME TO LOAD LOL
        //Pwede rin while kita un arrow loop sya
//        for (int z = 0; z <5; z++){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement arrow = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'custom_table_next_pagination') and @text = '   ›   ']");
        while(arrow != null){
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            //FIRST PRODUCT!
            //PER PC
            //Enter Value on Trade Inventory
            MobileElement tradePC1 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']");
            tradePC1.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            randomNum();
            System.out.println("trade pc 1 done");
            //Click ok
            MobileElement clckOk1 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
            clckOk1.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter Value on Order Inventory
            MobileElement orderPCa1 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']");
            orderPCa1.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            randomNum();
            System.out.println("order pc 1 done");
            //Click ok
            MobileElement clckOk2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
            clckOk2.click();
            //PER BOX
            //Enter Value on Trade Inventory
            MobileElement tradeBox1 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.LinearLayout[@index='1']");
            tradeBox1.click();
            //Enter value here
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            randomNum();
            System.out.println("trade box 1 done");
            //Click ok
            MobileElement clckOk3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
            clckOk3.click();
            //Enter Value on Order Inventory
            MobileElement orderBox1 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']");
            orderBox1.click();
            //Enter value
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            randomNum();
            System.out.println("order box 1 done");
            //Click ok
            MobileElement clckOk4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
            clckOk4.click();

            //SECOND PRODUCT!
            //PER PC
            //Enter Value on Trade Inventory
            MobileElement tradePC2 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']");
            tradePC2.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            randomNum();
            System.out.println("trade pc 2 done");
            //Click ok
            MobileElement clckOk5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
            clckOk5.click();
            //Enter Value on Order Inventory
            MobileElement orderPCa2 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']");
            orderPCa2.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            randomNum();
            System.out.println("order pc 2 done");
            //Click ok
            MobileElement clckOk6 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
            clckOk6.click();
            //PER BOX
            //Enter Value on Trade Inventory
            MobileElement tradeBox2 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.LinearLayout[@index='1']");
            tradeBox2.click();
            //Enter value here
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            randomNum();
            System.out.println("trade box 2 done");
            //Click ok
            MobileElement clckOk7 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
            clckOk7.click();
            //Enter Value on Order Inventory
            MobileElement orderBox2 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']");
            orderBox2.click();
            //Enter value here
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            randomNum();
            System.out.println("order box 2 done");
            //Click ok
            MobileElement clckOk8 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
            clckOk8.click();


            //THIRD PRODUCT!
            //PER PC
            //Enter Value on Trade Inventory
//            MobileElement tradePC3 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
//                    "/android.widget.HorizontalScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.ScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.LinearLayout[@index='2']" +
//                    "/android.widget.LinearLayout[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']");
//            tradePC3.click();
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            //Enter random numbers
//            randomNum();
//            //Click ok
//            MobileElement clckOk9 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
//            clckOk9.click();
//            //Enter Value on Order Inventory
//            MobileElement orderPCa3 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
//                    "/android.widget.HorizontalScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.ScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.LinearLayout[@index='2']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.LinearLayout[@index='0']");
//            orderPCa3.click();
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            //Enter random numbers
//            randomNum();
//            //Click ok
//            MobileElement clckOk10 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
//            clckOk10.click();
//            //PER BOX
//            //Enter Value on Trade Inventory
//            MobileElement tradeBox3 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
//                    "/android.widget.HorizontalScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.ScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.LinearLayout[@index='2']" +
//                    "/android.widget.LinearLayout[@index='1']" +
//                    "/android.widget.LinearLayout[@index='1']");
//            tradeBox3.click();
//            //Enter value here
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            //Enter random numbers
//            randomNum();
//            //Click ok
//            MobileElement clckOk11 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
//            clckOk11.click();
//            //Enter Value on Order Inventory
//            MobileElement orderBox3 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
//                    "/android.widget.HorizontalScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.ScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.LinearLayout[@index='2']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.LinearLayout[@index='1']");
//            orderBox3.click();
//            //Enter value here
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            //Enter random numbers
//            randomNum();
//            //Click ok
//            MobileElement clckOk12 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
//            clckOk12.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            try {
                MobileElement page = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'custom_table_next_pagination') and @text = '   ›   ']");
//            boolean isDisplayed1 =     Page.isDisplayed();
                if (page != null) {
                    //NXT PAGE
                    MobileElement nxtPage = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'custom_table_next_pagination') and @text = '   ›   ']");
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


//
//
//            // ! THIRD PRODUCT !
//            //3. product trade inventory pc
//            //samsung x=380 , y=665
//            MobileElement TrdPC3 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
//            boolean isDisplayed9 = TrdPC3.isDisplayed();
//            if (isDisplayed9) {
//                TouchAction touchAction = new TouchAction(driver);
//                touchAction.tap(new PointOption().withCoordinates(380, 665)).perform();
//            }
//            MobileElement clckNO5I = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_5') and @index = '1']");
//            clckNO5I.click();
//            MobileElement clckNO0I = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_0') and @index = '0']");
//            clckNO0I.click();
//            //Click ok
//            MobileElement clckOk9 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
//            clckOk9.click();
//            //3. product order pc
//            //samsung x=390 , y=665
//            MobileElement OrdPC3 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
//            boolean isDisplayed10 = OrdPC3.isDisplayed();
//            if (isDisplayed10) {
//                TouchAction touchAction = new TouchAction(driver);
//                touchAction.tap(new PointOption().withCoordinates(285, 665)).perform();
//            }

//            MobileElement clckOk10 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
//            clckOk10.click();
//            //3. product trade inventory box
//            //samsung x=380 , y=620
//            MobileElement TrdBox3 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
//            boolean isDisplayed11 = TrdBox3.isDisplayed();
//            if (isDisplayed11) {
//                TouchAction touchAction = new TouchAction(driver);
//                touchAction.tap(new PointOption().withCoordinates(380, 750)).perform();
//            }

//            //2. product order box
//            //samsung x=390 , y=440
//            MobileElement OrdBox3 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
//            boolean isDisplayed12 = OrdBox3.isDisplayed();
//            if (isDisplayed12) {
//                TouchAction touchAction = new TouchAction(driver);
//                touchAction.tap(new PointOption().withCoordinates(285, 750)).perform();
//            }
//            //Enter value here


//        }
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click triple Dots
        MobileElement clckDots = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls') and @index = '0']");
        clckDots.click();
        //Click Finalize
        MobileElement clckTrnsctn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'btn_finalize')]");
        clckTrnsctn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Enter P.O Number
        MobileElement POnuFIELD = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_po_number')]");
        POnuFIELD.sendKeys(ranNum[rand(ranNum.length-1)]);
        //Enter Sales Invoice Number
        MobileElement INField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_si_number')]");
        INField.sendKeys(ranNum[rand(ranNum.length-1)]);
        //Enter Customer Name
        MobileElement custField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_customer_name')]");
        custField.sendKeys(customerName[rand(customerName.length-1)]);
        //Enter Customer Name
        MobileElement cntctField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_contact_detail')]");
        cntctField.sendKeys(customerCont[rand(customerCont.length-1)]);
        //Hide keyboard
        driver.hideKeyboard();
        //Click save
        MobileElement saveBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'btn_save')]");
        saveBtn.click();
        //Click yes
        MobileElement yesBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        yesBtn1.click();
        //Click no
        MobileElement noBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2')]");
        noBtn.click();
        //Click arrow
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        arrowBtn.click();
        //Click yes
        MobileElement yesBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        yesBtn2.click();
        System.out.println("Order PC AND BOX COMPLETE!");
    }
    public void orderPCa() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //UNIT
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(new PointOption().withCoordinates(200, 250)).perform();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement arrow = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'custom_table_next_pagination') and @text = '   ›   ']");
        while(arrow != null){
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        MobileElement arrow = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'custom_table_next_pagination') and @text = '   ›   ']");
//        while(arrow != null){
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            //FIRST PRODUCT!
            //PER PC
            //Enter Value on Trade Inventory
            MobileElement tradePC1 = (MobileElement) driver.findElementByXPath(vaofDrctryByPC +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']");
            tradePC1.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            randomNum();
            //Click ok
            MobileElement clckOk1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
            clckOk1.click();

            //Enter Value on Order Inventory
            MobileElement orderPCa1 = (MobileElement) driver.findElementByXPath(vaofDrctryByPC +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']");
            orderPCa1.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            randomNum();
            //Click ok
            MobileElement clckOk2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
            clckOk2.click();

            //!!!!SECOND PRODUCT!!!!
            //PER PC
            //Enter Value on Trade Inventory
            MobileElement tradePC2 = (MobileElement) driver.findElementByXPath(vaofDrctryByPC +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']");
            tradePC2.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            randomNum();
            //Click ok
            MobileElement clckOk3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
            clckOk3.click();

            //Enter Value on Order Inventory
            MobileElement orderPCa2 = (MobileElement) driver.findElementByXPath(vaofDrctryByPC +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']");
            orderPCa2.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            randomNum();
            //Click ok
            MobileElement clckOk4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
            clckOk4.click();


            //!!!!THIRD PRODUCT!!!!
            //PER PC
            //Enter Value on Trade Inventory
//            MobileElement tradePC3 = (MobileElement) driver.findElementByXPath(vaofDrctryByPC +
//                    "/android.widget.HorizontalScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.ScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.LinearLayout[@index='2']" +
//                    "/android.widget.LinearLayout[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']");
//            tradePC3.click();
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            //Enter random numbers
//            randomNum();
//            //Click ok
//            MobileElement clckOk5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
//            clckOk5.click();
//
//            //Enter Value on Order Inventory
//            MobileElement orderPCa3 = (MobileElement) driver.findElementByXPath(vaofDrctryByPC +
//                    "/android.widget.HorizontalScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.ScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.LinearLayout[@index='2']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.LinearLayout[@index='0']");
//            orderPCa3.click();
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            //Enter random numbers
//            randomNum();
//            //Click ok
//            MobileElement clckOk6 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
//            clckOk6.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            try {
                MobileElement page = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'custom_table_next_pagination') and @text = '   ›   ']");
//            boolean isDisplayed1 =     Page.isDisplayed();
                if (page != null) {
                    //NXT PAGE
                    MobileElement nxtPage = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'custom_table_next_pagination') and @text = '   ›   ']");
                    nxtPage.click();
                    System.out.println("Next Page");
                } else {
                    System.out.println("STAPH");
                    break;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Save");
                break;
            }
        }
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click triple Dots
        MobileElement clckDots = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls') and @index = '0']");
        clckDots.click();
        //Click Finalize
        MobileElement clckTrnsctn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'btn_finalize')]");
        clckTrnsctn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Enter P.O Number
        MobileElement POnuFIELD = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_po_number')]");
        POnuFIELD.sendKeys(ranNum[rand(ranNum.length-1)]);
        //Enter Sales Invoice Number
        MobileElement INField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_si_number')]");
        INField.sendKeys(ranNum[rand(ranNum.length-1)]);
        //Enter Customer Name
        MobileElement custField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_customer_name')]");
        custField.sendKeys(customerName[rand(customerName.length-1)]);
        //Enter Customer Name
        MobileElement cntctField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_contact_detail')]");
        cntctField.sendKeys(customerCont[rand(customerCont.length-1)]);
        //Hide keyboard
        driver.hideKeyboard();
        //Click save
        MobileElement saveBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'btn_save')]");
        saveBtn.click();
        //Click yes
        MobileElement yesBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        yesBtn1.click();
        //Click no
        MobileElement noBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2')]");
        noBtn.click();
        //Click arrow
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        arrowBtn.click();
        //Click yes
        MobileElement yesBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        yesBtn2.click();
        System.out.println("Order per PC COMPLETE!");

    }
    public void orderBoxa() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //UNIT Coodinates depends on Phone
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(new PointOption().withCoordinates(200, 250)).perform();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement element2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_uom_filtered') and @text='Uom filtered by smallest']");
        boolean isDisplayed2 = element2.isDisplayed();
        if (isDisplayed2) {
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(new PointOption().withCoordinates(200, 300)).perform();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement arrow = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'custom_table_next_pagination') and @text = '   ›   ']");
        while(arrow != null){
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        MobileElement arrow = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'custom_table_next_pagination') and @text = '   ›   ']");
//        while(arrow != null){
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            //FIRST PRODUCT!
            //PER PC
            //Enter Value on Trade Inventory
            MobileElement tradeBox1 = (MobileElement) driver.findElementByXPath(vaofDrctryByPC +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']");
            tradeBox1.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            randomNum();
            MobileElement clckOk1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
            clckOk1.click();
            //Enter Value on Order Inventory
            MobileElement orderBox1 = (MobileElement) driver.findElementByXPath(vaofDrctryByPC +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']");
            orderBox1.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            randomNum();
            //Click ok
            MobileElement clckOk2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
            clckOk2.click();

            //!!!!SECOND PRODUCT!!!!
            //PER PC
            //Enter Value on Trade Inventory
            MobileElement tradeBox2 = (MobileElement) driver.findElementByXPath(vaofDrctryByPC +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']");
            tradeBox2.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            randomNum();
            //Click ok
            MobileElement clckOk3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
            clckOk3.click();
            //Enter Value on Order Inventory
            MobileElement orderBox2 = (MobileElement) driver.findElementByXPath(vaofDrctryByPC +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']");
            orderBox2.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter random numbers
            randomNum();
            //Click ok
            MobileElement clckOk4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
            clckOk4.click();


            //!!!!THIRD PRODUCT!!!!
            //PER PC
            //Enter Value on Trade Inventory
//            MobileElement tradeBox3 = (MobileElement) driver.findElementByXPath(vaofDrctryByPC +
//                    "/android.widget.HorizontalScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.ScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.LinearLayout[@index='2']" +
//                    "/android.widget.LinearLayout[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']");
//            tradeBox3.click();
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            //Enter random numbers
//            randomNum();
//            //Click ok
//            MobileElement clckOk5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
//            clckOk5.click();
//
//            //Enter Value on Order Inventory
//            MobileElement orderBox3 = (MobileElement) driver.findElementByXPath(vaofDrctryByPC +
//                    "/android.widget.HorizontalScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.ScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.LinearLayout[@index='2']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.LinearLayout[@index='0']");
//            orderBox3.click();
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            //Enter random numbers
//            randomNum();
//            //Click ok
//            MobileElement clckOk6 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
//            clckOk6.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            try {
                MobileElement page = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'custom_table_next_pagination') and @text = '   ›   ']");
//            boolean isDisplayed1 =     Page.isDisplayed();
                if (page != null) {
                    //NXT PAGE
                    MobileElement nxtPage = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'custom_table_next_pagination') and @text = '   ›   ']");
                    nxtPage.click();
                    System.out.println("Next Page");
                } else {
                    System.out.println("STAPH");
                    break;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Save");
                break;
            }
        }
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click triple Dots
        MobileElement clckDots = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls') and @index = '0']");
        clckDots.click();
        //Click Finalize
        MobileElement clckTrnsctn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'btn_finalize')]");
        clckTrnsctn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Enter P.O Number
        MobileElement POnuFIELD = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_po_number')]");
        POnuFIELD.sendKeys(ranNum[rand(ranNum.length-1)]);
        //Enter Sales Invoice Number
        MobileElement INField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_si_number')]");
        INField.sendKeys(ranNum[rand(ranNum.length-1)]);
        //Enter Customer Name
        MobileElement custField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_customer_name')]");
        custField.sendKeys(customerName[rand(customerName.length-1)]);
        //Enter Customer Name
        MobileElement cntctField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_contact_detail')]");
        cntctField.sendKeys(customerCont[rand(customerCont.length-1)]);
        //Hide keyboard
        driver.hideKeyboard();
        //Click save
        MobileElement saveBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'btn_save')]");
        saveBtn.click();
        //Click yes
        MobileElement yesBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        yesBtn1.click();
        //Click no
        MobileElement noBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2')]");
        noBtn.click();
        //Click arrow
        MobileElement arrowBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        arrowBtn.click();
        //Click yes
        MobileElement yesBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        yesBtn2.click();
        System.out.println("Order per BOX COMPLETE!");

    }
    public void logVisit(){
        for(int i=1; i<11;i++) {
            //CLick on drawer
            MobileElement sideBarBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
            sideBarBtn.click();
            //click arrow down
            MobileElement loginVisitBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'image_visit_dropdown')]");
            loginVisitBtn.click();
            //branch list
            List<MobileElement> logBtn = (List<MobileElement>) driver.findElementsByClassName("android.widget.RelativeLayout");
            logBtn.get(3).click();
            MobileElement cntBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
            cntBtn.click();
            //click on Ok
            //should have wait here atleast 20 secs
            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
            MobileElement cntBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
            cntBtn1.click();
        }
    }
    public void logOutVisit(){
        MobileElement sideBarBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
        sideBarBtn1.click();
        MobileElement logOutBtn = (MobileElement) driver.findElementByXPath("//android.view.View[contains(@resource-id,'action_visit')]");
        logOutBtn.click();
        //Insert Swipe down
        MobileElement logOutBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'btn_visit_logout')]");
        logOutBtn1.click();

    }
    public void SearchVan(){
        //click drawer
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement sideBarBtn = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
        sideBarBtn.click();
        //search van
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/edit_text_search");
        searchField.sendKeys(search);
        //click search result
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckRes = (MobileElement) driver.findElementByAccessibilityId("Van Account Order Form");
        clckRes.click();

    }
    public void SearchVanSum(){
        //click drawer
        MobileElement sideBarBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
        sideBarBtn.click();
        //search van
        MobileElement searchField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'edit_text_search')]");
        searchField.sendKeys(search1);
        //click search result
        MobileElement clckRes = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text_title')]");
        clckRes.click();
    }
    public void orderTransac(){
        //NEED TIME TO LOAD LOL
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Enter Value on Trade Inventory
        MobileElement tradeField = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='0']");
        tradeField.click();
        //Value to be enter 50
        MobileElement clckNO5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_5') and @index = '1']");
        clckNO5.click();
        MobileElement clckNO0 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_0') and @index = '0']");
        clckNO0.click();
        //Click ok
        MobileElement clckOk1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk1.click();
        //Enter Value on Order per PC
        MobileElement orderField = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']");
        orderField.click();
        //Value to be enter 50
        MobileElement clckNO5A = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_5') and @index = '1']");
        clckNO5A.click();
        MobileElement clckNO0A = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_0') and @index = '0']");
        clckNO0A.click();
        //Click ok
        MobileElement clckOk2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk2.click();

    }
    public void invalidOrderTransac(){
        //NEED TIME TO LOAD LOL
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Enter Value on Trade Inventory
        MobileElement tradeField = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.LinearLayout[@index='0']");
        tradeField.click();

        //Value to be enter 50
        MobileElement clckNO5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_5') and @index = '1']");
        clckNO5.click();
        MobileElement clckNO0A = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_0') and @index = '0']");
        clckNO0A.click();
        //Click ok
        MobileElement clckOk1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk1.click();
        //Enter Value on Order per PC
        MobileElement orderField = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                "/android.widget.HorizontalScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.ScrollView[@index='1']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']");
        orderField.click();
        //Value to be enter 50
        MobileElement clckNO5A = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_5') and @index = '1']");
        clckNO5A.click();
        MobileElement clckNO0Ab = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_0') and @index = '0']");
        clckNO0Ab.click();
        MobileElement clckNO0Bb = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_0') and @index = '0']");
        clckNO0Bb.click();
        MobileElement clckNO0Cb = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_0') and @index = '0']");
        clckNO0Cb.click();
        //Click ok
        MobileElement clckOk2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
        clckOk2.click();

    }
    public void clckUnit(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckUnit1 = (MobileElement) driver.findElementByXPath( vaofDrctryTbl+
                "android.widget.LinearLayout[@index='0']/" +
                "android.widget.LinearLayout[@index='0']/" +
                "android.widget.LinearLayout[@index='0']/" +
                "android.widget.LinearLayout[@index='0']/" +
                "android.widget.TextView[@index='1']");
        clckUnit1.click();
    }
    public void clear(){
        //Click triple Dots
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckDots = (MobileElement) driver.findElementByAccessibilityId("Show action");
        clckDots.click();
        //Click ClearAll
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement btnClear = (MobileElement) driver.findElementById("com.engagia.android:id/btn_clear");
        btnClear.click();
        //Click CLEAR ALL
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clear = (MobileElement) driver.findElementById("android:id/button1");
        clear.click();
        System.out.println("Clear done");
    }
    public void preview(){
        //Click triple Dots
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckDots = (MobileElement) driver.findElementByAccessibilityId("Show action");
        clckDots.click();
        //Click ClearAll
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement preview = (MobileElement) driver.findElementById("com.engagia.android:id/btn_preview");
        preview.click();
        //Click CLEAR ALL
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement back = (MobileElement) driver.findElementById("com.engagia.android:id/btn_back");
        back.click();
        driver.navigate().back();
        System.out.println("Preview done");
    }
    public void finalize(){
        //Click triple Dots
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckDots = (MobileElement) driver.findElementByAccessibilityId("Show action");
        clckDots.click();
        //Click ClearAll
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement preview = (MobileElement) driver.findElementById("com.engagia.android:id/btn_preview");
        preview.click();
        //Click CLEAR ALL
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement back = (MobileElement) driver.findElementById("com.engagia.android:id/btn_back");
        back.click();
        driver.navigate().back();
        System.out.println("Clear done");
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
    public void swipeRight(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Dimension dim = driver.manage().window().getSize();
            int width = dim.getWidth();
            //Para nasa gilid un pag scroll walang tatamaan textfield
            int x1 = (int) (width * 0.99);
            int x2 = (int) (width * 0.65);
            TouchAction touchAction = new TouchAction(driver);
            //try this
            touchAction.longPress(new PointOption().withCoordinates(x1, 300)).moveTo(new PointOption().withCoordinates(x2, 300)).release().perform();
        }
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
    private void swipeDown(){
        Dimension dim = driver.manage().window().getSize();
        int width = dim.getWidth();
        int height = dim.getHeight();
        int x = (int) (width * 0.50);
        int y1 = (int) (height * 0.80);
        int y2 = (int) (height * 0.50);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/buttonPanel");
        boolean element1Displayed = element1.isDisplayed();
        if (element1Displayed) {
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
