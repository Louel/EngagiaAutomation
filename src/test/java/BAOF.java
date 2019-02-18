import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;

public class BAOF {

    AppiumDriver driver;
//    WebDriverWait wait = new WebDriverWait(driver, 5);
    String search = "Booking Acc";
    String[] productNames = {"Anlene", "lene" , "lack" , "lover", "soda", "banana" , "Tos" , "Mentos"};
    String[] productShortNames = {"Coke" , "oke" , "beEr" , "RC"};
    String[] productCode = {"51232143" , "51232208" , "535353" , "545454" , "565656" , "686868" , "829382"};
    String[] productBarCode = {"10182017015" , "100000216" , "10182017010" , "10182017031" , "1018201704" , "131213" , "242424"};
    String[] productDescrip = {"Soda", "Cracker" , "Biscuit" , "Milk" , "Candy" , "Chocolate"};
    String[] productBrand = {"MEGA SARDINES", "Clover Chips" , "Exo Candy" , "Mentos" , "Coca-Cola" , "Moutain Dew"};
    String[] productKeyword = {"Coke", "Sprite" , "Beer" , "Crispy Fishbol Flavor" , "Soft Drink" , "Piattos"};
    String[] productPrincipal = {"URC" , "Coca-Cola Corp." , "Pepsi Cola Products Philippines" , "MFC" };
    /**
     * 1. Prod PC = "/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]" +
     *                 "/android.widget.LinearLayout[1]/android.widget.TextView"
     *    Prod Box ="/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]" +
     *                 "/android.widget.LinearLayout[2]/android.widget.TextView"
     * 2. Prod PC = "/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]" +
     *                 "/android.widget.LinearLayout[1]/android.widget.TextView"
     *    Prod Box = "/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]" +
     *                 "/android.widget.LinearLayout[2]/android.widget.TextView"
     */
    String bookingOrderDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout";
    String productDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout";
    String unitDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
    String searchByDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout" +
            "/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RadioGroup";
    String filterByDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout" +
            "/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView";
    String branchListDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout" +
            "/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView";

    /**
     * 1. PROD1 STOCK /android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView
     * 2. PROD2 STOCK /android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView
     */
    String stockDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout";
    String tradeInventDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout";

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
    public void testBAOF(){
        //Log in to visit
        loginToVisit();
    }
    //Cases
    //Check App: "Search by Name"
    public void Case9(){
        System.out.println("Testing Case 9");
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
        MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
        boolean noProdFoundDisplayed = noProdFound.isDisplayed();
        if (noProdFoundDisplayed) {
            System.out.println("No Products Found");
            MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
            dismissBtn.click();
            System.out.println("Case 9 Pass");
        }
    }
    //Check App: "Search by Short Name"
    public void Case10(){
        System.out.println("Testing Case 10");
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
        MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
        boolean noProdFoundDisplayed = noProdFound.isDisplayed();
        if (noProdFoundDisplayed) {
            System.out.println("No Products Found");
            MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
            dismissBtn.click();
            System.out.println("Case 10 Pass");
        }
    }
    //Check App: "Search by Code"
    public void Case11(){
        System.out.println("Testing Case 11");
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
        MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
        boolean noProdFoundDisplayed = noProdFound.isDisplayed();
        if (noProdFoundDisplayed) {
            System.out.println("No Products Found");
            MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
            dismissBtn.click();
            System.out.println("Case 11 Pass");
        }
    }
    //Check App: "Search by Barcode"
    public void Case12(){
        System.out.println("Testing Case 12");
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
        MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
        boolean noProdFoundDisplayed = noProdFound.isDisplayed();
        if (noProdFoundDisplayed) {
            System.out.println("No Products Found");
            MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
            dismissBtn.click();
            System.out.println("Case 12 Pass");
        }
    }
    //Check App: "Search by Description"
    public void Case13(){
        System.out.println("Testing Case 13");
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
        MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
        boolean noProdFoundDisplayed = noProdFound.isDisplayed();
        if (noProdFoundDisplayed) {
            System.out.println("No Products Found");
            MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
            dismissBtn.click();
            System.out.println("Case 13 Pass");
        }
    }
    //Check App: "Search by Brand"
    public void Case14(){
        System.out.println("Testing Case 14");
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
        MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
        boolean noProdFoundDisplayed = noProdFound.isDisplayed();
        if (noProdFoundDisplayed) {
            System.out.println("No Products Found");
            MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
            dismissBtn.click();
            System.out.println("Case 14 Pass");
        }
    }
    //Check App: "Search by Keyword"
    public void Case15(){
        System.out.println("Testing Case 15");
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
        MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
        boolean noProdFoundDisplayed = noProdFound.isDisplayed();
        if (noProdFoundDisplayed) {
            System.out.println("No Products Found");
            MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
            dismissBtn.click();
            clear();
            System.out.println("Case 15 Pass");
        }
    }
    ///Check App: "Search by Principal"
    public void Case16(){
        System.out.println("Testing Case 16");
        //Search By Principal
        searchByPrincipal();
        //Search a product Principal
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchField.sendKeys(productPrincipal[rand(productPrincipal.length-1)]);
        //Click on search button
        MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        clckSearch.click();
        searchField.sendKeys("abcdefg123");
        clckSearch.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
        boolean noProdFoundDisplayed = noProdFound.isDisplayed();
        if (noProdFoundDisplayed) {
            System.out.println("No Products Found");
            MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
            dismissBtn.click();
            clear();
            System.out.println("Case 16 Pass");
        }
    }
    //Check product filter "All products"
    public void Case17(){
        System.out.println("Testing Case 17");
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        MobileElement productFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        productFilter.click();
        MobileElement prodFilterByAllProd = (MobileElement) driver.findElementByXPath("//android.widget.ListView/android.widget.TextView[1]");
        prodFilterByAllProd.click();
        MobileElement filterBtn = (MobileElement) driver.findElementById("android:id/button1");
        filterBtn.click();


    }
    //Check App: Product Filter by "All Product"
    public void Case18(){
        System.out.println("Testing Case 18");
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
                searchByName();
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 18 Pass");
                    clear();
                }
            }
        }
    }
    //Check App: Product Filter by "Product Group"
    public void Case19(){
        System.out.println("Testing Case 19");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            prodFilterByProdGroup();
            if(z==1) {
                searchByName();
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 19 Pass");
                    clear();
                }
            }
        }
    }
    //Check App: Product Filter by "Must carry per Account Classification"
    public void Case20(){
        System.out.println("Testing Case 20");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            prodFilterByMustCarry();
            if(z==1) {
                searchByName();
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 20 Pass");
                    clear();
                }
            }
        }
    }
    //Check App: Product Filter by "Brand"
    public void Case21(){
        System.out.println("Testing Case 21");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            prodFilterByBrand();
            if(z==1) {
                searchByName();
                //Search a product Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Adartrel (ropinirole hydrochloride) 2.0mg");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==2){
                searchByShortName();
                //Search a product Short Name
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Adartrel 2.0mg");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==3){
                searchByCode();
                //Search a product Code
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("51232166");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==4){
                searchByBarcode();
                //Search a product Barcode
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("51232167");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==5){
                searchByDescription();
                //Search a product Description
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Tablets");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==6){
                searchByBrand();
                //Search a product Brand
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Adartrel");
                //Click on search button
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
            }
            else if(z==7){
                searchByKeyword();
                //Search a product Keyword
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("Adartrel");
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 21 Pass");
                    clear();
                }
            }
        }
    }
    //Check App: Product Filter by "Product with Historical Sales"
    public void Case22(){
        System.out.println("Testing Case 22");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=16; z++){
            if(z==1) {
                searchByName();
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
                    System.out.println("Case 22 Pass Volume");
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 22 Pass Value");
                    clear();
                }
            }
        }
    }
    //Check app: Product Filter by "Must carry + Products with Historical Sales"
    public void Case23(){
        System.out.println("Testing Case 23");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=16; z++){
            if(z==1) {
                searchByName();
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 23 Pass Volume");
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 23 Pass Value");
                    clear();
                }
            }
        }
    }
    //Check app: Product Filter by "Document Sequence"
    public void Case24(){
        System.out.println("Testing Case 24");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            prodFilterByDocuSequence();
            if(z==1) {
                searchByName();
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 24 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Product Filter by "Deals"
    public void Case25(){
        System.out.println("Testing Case 25");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            prodFilterByDeal();
            if(z==1) {
                searchByName();
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 25 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Product Filter by "Active Products"
    public void Case26(){
        System.out.println("Testing Case 26");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            prodFilterByActiveProd();
            if(z==1) {
                searchByName();
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 26 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Product Filter by "Carried Products"
    public void Case27(){
        System.out.println("Testing Case 27");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            prodFilterByCarriedProd();
            if(z==1) {
                searchByName();
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 27 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Product Filter by "Not Carried Products" may bug dito sa not carried ibang product yung lumalabas compare sa nilagay sa EMS
    public void Case28(){
        System.out.println("Testing Case 28");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            prodFilterByNotCarriedProd();
            if(z==1) {
                searchByName();
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
                System.out.println("Entering invalid input");
                MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                searchField.sendKeys("abcdefg123");
                MobileElement clckSearch = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                clckSearch.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 28 Pass");
                    clear();
                }
            }
        }
    }
    //
    //Check app: information filter "All Products"
    public void Case29(){
        System.out.println("Testing Case 29");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByAllProd();
            if(z==1) {
                searchByName();
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 29 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: information filter "Trade Inventory > 0"
    public void Case30(){
        System.out.println("Testing Case 30");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByTradeInventoryGreaterThanZero();
            if(z==1) {
                searchByName();
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 30 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: information filter "Trade Inventory = 0"
    public void Case31(){
        System.out.println("Testing Case 31");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByTradeInventoryEqualZero();
            if(z==1) {
                searchByName();
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 31 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: information filter "Product with Order"
    public void Case32(){
        System.out.println("Testing Case 32");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByProductsWithOrder();
            if(z==1) {
                searchByName();
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 32 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: information filter "6,3,1 sales > 0"
    public void Case33(){
        System.out.println("Testing Case 24");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterBy631();
            if(z==1) {
                searchByName();
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 33 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: information filter "Stock Availability = no stock"
    public void Case34(){
        System.out.println("Testing Case 34");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByStockAvailabilityNoStock();
            if(z==1) {
                searchByName();
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 34 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: information filter "Stock Availability = with stock"
    public void Case35(){
        System.out.println("Testing Case 35");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByStockAvailabilityWithStock();
            if(z==1) {
                searchByName();
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 35 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Information Filter by "Stock Weight = Low"
    public void Case36(){
        System.out.println("Testing Case 36");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByStockWeightLow();
            if(z==1) {
                searchByName();
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 36 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Information Filter by "Stock Weight = Medium"
    public void Case37(){
        System.out.println("Testing Case 37");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByStockWeightMed();
            if(z==1) {
                searchByName();
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 37 Pass");
                    clear();
                }
            }
        }
    }
    //Check app: Information Filter by "Stock Weight = High"
    public void Case38(){
        System.out.println("Testing Case 38");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cancel = (MobileElement) driver.findElementById("android:id/button2");
        cancel.click();
        for(int z=1; z<=8; z++){
            infoFilterByStockWeightHigh();
            if(z==1) {
                searchByName();
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
                MobileElement noProdFound = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean noProdFoundDisplayed = noProdFound.isDisplayed();
                if (noProdFoundDisplayed) {
                    System.out.println("No Products Found");
                    MobileElement dismissBtn = (MobileElement) driver.findElementById("android:id/button2");
                    dismissBtn.click();
                    System.out.println("Case 38 Pass");
                    clear();
                }
            }
        }
    }
    //Check Summary Menu "Select Branch" //todo need to create script for not log in to visit
    public void Case39(){
        System.out.println("Testing Case 39");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement summaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
        summaryMenu.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accountBranch = (MobileElement) driver.findElementById("com.engagia.android:id/txt_account_branch");
        accountBranch.click();
        String selectedBranchName = accountBranch.getText();
        System.out.println(selectedBranchName);
        driver.navigate().back();
        System.out.println("Case 39 Pass");
    }
    //Click Summary Menu "Grand Total with Tax" Field
    public void Case40(){
        System.out.println("Testing Case 40");
        for(int z = 1; z <=2; z++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement summaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
            summaryMenu.click();
            MobileElement grandTotalWTax = (MobileElement) driver.findElementById("com.engagia.android:id/list_str_temporary_saved_grand_total_w_tax");
            grandTotalWTax.click();
            String grandTotalText = grandTotalWTax.getText();
            driver.navigate().back();
            if(z==1) {
                System.out.println("Grand Total Without order: " + grandTotalText);
                orderPC();
            }
            else if (z==2){
                System.out.println("Grand Total With order: "+grandTotalText);
                deleteOrderPC();
                orderPC();
                System.out.println("Edited Grand Total With order: "+grandTotalText);
            }
        }
        System.out.println("Case 40 Pass");
        clear();
    }
    //Click Summary Menu "VAT" Field
    public void Case41(){
        System.out.println("Testing Case 41");
        for(int z = 1; z <=2; z++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement summaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
            summaryMenu.click();
            MobileElement vat = (MobileElement) driver.findElementById("com.engagia.android:id/txt_grand_total_w_o_tax");
            vat.click();
            String vatTextValue = vat.getText();
            driver.navigate().back();
            if(z==1) {
                System.out.println("VAT Without order: " + vatTextValue);
                orderPC();
            }
            else if (z==2){
                System.out.println("VAT With order: "+vatTextValue);
                deleteOrderPC();
                orderPC();
                System.out.println("VAT With order: "+vatTextValue);
            }
        }
        System.out.println("Case 41 Pass");
        clear();
    }
    //Click Summary Menu "Source Warehouse" Field
    public void Case42(){
        System.out.println("Testing Case 42");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement summaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
        summaryMenu.click();
        for(int z = 1; z<=4; z++) {
            try {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement sourceWarehouse = (MobileElement) driver.findElementById("com.engagia.android:id/txt_source_warehouse");
                sourceWarehouse.click();
                //Select Certain Warehouse Checkbox
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement selectWarehouseSource = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout" +
                        "/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView["+z+"]");
                selectWarehouseSource.click();
                MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
                goBtn.click();
            }
            catch (NoSuchElementException e){
                int x = z-1;
                System.out.println("There is only "+x+ " Warehouse");
                MobileElement goBtn = (MobileElement) driver.findElementById("android:id/button1");
                goBtn.click();
                break;
            }
        }
        driver.navigate().back();
        clear();
        System.out.println("Case 42 Pass");
    }
    //Click Summary Menu "Discounts" Field
    public void Case43(){

    }
    //
    public void Case44(){

    }
    //Check triple dot menu "Order Protection to all Products"
    public void Case45(){
        System.out.println("Testing Case 45");
        for(int z = 1; z<=3; z++) {
            orderProtect();
            if (z==1){
                System.out.println("Order Protect Toggle on");
            }else if(z==2){
                System.out.println("Order Protect Toggle off");
            }else if(z==3){
                System.out.println("Order Protect Toggle on");
            }
        }
        System.out.println("Case 45 Pass");
    }
    //Check triple dot menu "PREVIEW"
    public void Case46(){
        System.out.println("Testing Case 46");
        for(int z = 1; z<=3; z++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement summaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
            summaryMenu.click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement btnPreview = (MobileElement) driver.findElementById("com.engagia.android:id/txt_preview_btn");
            btnPreview.click();
            MobileElement previewSummary = (MobileElement) driver.findElementById("com.engagia.android:id/txt_print_data");
            String previewSummaryText = previewSummary.getText();
            MobileElement closeBtn = (MobileElement) driver.findElementById("android:id/button1");
            closeBtn.click();
            driver.navigate().back();
            if(z==1) {
                System.out.println("Preview Without order: \n" + previewSummaryText);
                orderPC();
            }
            else if (z==2){
                System.out.println("Preview With order: \n"+previewSummaryText);
                deleteOrderPC();
                orderPC();
                System.out.println("Preview With order: \n"+previewSummaryText);
            }
        }
        System.out.println("Case 46 Pass");
    }
    //Check triple dot menu "CLEAR"
    public void Case47(){
        System.out.println("Testing Case 47");
        clear();
        System.out.println("Case 47 Pass");
    }
    //Check summary menu : "Salesman Discount"
    public void Case48(){
        System.out.println("Testing Case 48");

        System.out.println("Case 48 Pass");
    }
    //Check summary menu : "FINALIZE"
    public void Case49(){
        System.out.println("Testing Case 49");
        orderPC();
        orderFinalize();
        SearchBAOF();
        System.out.println("Case 49 Pass");
    }
    //
    public void Case51(){

    }
    //Check table view "PRODUCT NAME"
    public void Case52(){
        System.out.println("Testing Case 52");
        viewProductSummary();
        System.out.println("Case 52 Pass");
    }
    //Check table view "UNIT"
    public void Case53(){
        System.out.println("Testing Case 53");
        //1st click
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            MobileElement unit = (MobileElement) driver.findElementByXPath(unitDrctry);
            unit.click();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement filteredBySmall = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_uom_filtered') and @text='Uom filtered by smallest']");
        String filteredBySmallText = filteredBySmall.getText();
        boolean filteredBySmallDisplayed = filteredBySmall.isDisplayed();
        if (filteredBySmallDisplayed) {
            System.out.println(filteredBySmallText+" is Displayed");
            MobileElement unit = (MobileElement) driver.findElementByXPath(unitDrctry);
            unit.click();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement filteredByBig = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_uom_filtered') and @text='Uom filtered by biggest']");
        String filteredByBigText = filteredByBig.getText();
        boolean filteredByBigDisplayed = filteredByBig.isDisplayed();
        if (filteredByBigDisplayed) {
            System.out.println(filteredByBigText+" is Displayed");
            MobileElement unit = (MobileElement) driver.findElementByXPath(unitDrctry);
            unit.click();
        }
        System.out.println("Case 53 Pass");
    }
    //
    public void Case54(){
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
            MobileElement orderPC1 = (MobileElement) driver.findElementByXPath(bookingOrderDrctry + "/android.widget.LinearLayout["+z+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView");
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
    //Functions




    public void SearchBAOF(){
        //click Hamburger Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement HamburgerBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
        HamburgerBtn.click();
        System.out.println("Seaching BAOF");
        //search BAOF
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/edit_text_search");
        searchField.sendKeys(search);
        //click search result
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckRes = (MobileElement) driver.findElementByAccessibilityId("Booking Account Order Form");
        clckRes.click();
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
    private void searchByPrincipal(){
        System.out.println("Searching by Keyword");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        swipeDown();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement keyword = (MobileElement) driver.findElementByXPath("//android.widget.RadioGroup/android.widget.RadioButton[8]");
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement allProd = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.TextView[1]");
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
        MobileElement prodGroup = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.TextView[2]");
        prodGroup.click();
        //Click on Certain  Product Group
        MobileElement selProdGroup = (MobileElement) driver.findElementByXPath("//android.widget.ListView/android.widget.TextView[1]");
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
        MobileElement mustCarry = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.TextView[3]");
        mustCarry.click();
        //Click on Certain Must Carry
        MobileElement selMustCarry = (MobileElement) driver.findElementByXPath("//android.widget.ListView/android.widget.TextView[1]");
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
        MobileElement brand = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.TextView[5]");
        brand.click();
        //Click on Certain Brand
        MobileElement selBrand = (MobileElement) driver.findElementByXPath("//android.widget.ListView/android.widget.TextView[1]");
        selBrand.click();
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
        MobileElement historicalSales = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.TextView[6]");
        historicalSales.click();
        //Click on Volume
        MobileElement selVolume = (MobileElement) driver.findElementByXPath("//android.widget.ListView/android.widget.TextView[1]");
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
        MobileElement historicalSales = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.TextView[6]");
        historicalSales.click();
        //Click on Value
        MobileElement selValue = (MobileElement) driver.findElementByXPath("//android.widget.ListView/android.widget.TextView[2]");
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
        MobileElement historicalSales = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.TextView[7]");
        historicalSales.click();
        //Click on Certain Must Carry
        MobileElement selMustCarry = (MobileElement) driver.findElementByXPath("//android.widget.ListView/android.widget.TextView[1]");
        selMustCarry.click();
        //Click on Volume
        MobileElement selVolume = (MobileElement) driver.findElementByXPath("//android.widget.ListView/android.widget.TextView[1]");
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
        MobileElement historicalSales = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.TextView[7]");
        historicalSales.click();
        //Click on Certain Must Carry
        MobileElement selMustCarry = (MobileElement) driver.findElementByXPath("//android.widget.ListView/android.widget.TextView[1]");
        selMustCarry.click();
        //Click on Value
        MobileElement selValue = (MobileElement) driver.findElementByXPath("//android.widget.ListView/android.widget.TextView[2]");
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
        MobileElement docuSeq = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.TextView[8]");
        docuSeq.click();
        //Click on Certain  Product Group
        MobileElement selDocuSeq = (MobileElement) driver.findElementByXPath("//android.widget.ListView/android.widget.TextView[1]");
        selDocuSeq.click();
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
        swipeDown();
        //Click Deals
        MobileElement deal = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Deals']");
        deal.click();
        //Click on Certain  deal
        MobileElement selDeal = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.TextView[1]");
        selDeal.click();
        //Click Ok
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
        System.out.println("Product Filter By Active Product");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        swipeDown();
        //Click Active Products
        MobileElement activeProd = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Active Products']");
        activeProd.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void prodFilterByCarriedProd(){
        System.out.println("Product Filter By Carried Product");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        swipeDown();
        //Click Carried Products
        MobileElement carriedProd = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Carried Products']");
        carriedProd.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void prodFilterByNotCarriedProd(){
        System.out.println("Product Filter By Not Carried Product");
        //Click arrow down
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrow = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        clckArrow.click();
        //Click on all product filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        swipeDown();
        //Click Not Carried Products
        MobileElement notCarriedProd = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Not Carried Products']");
        notCarriedProd.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }

    private void infoFilterByAllProd(){
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
        MobileElement allProd = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.TextView[1]");
        allProd.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void infoFilterByTradeInventoryGreaterThanZero(){
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
        MobileElement tradeInvent_zero = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.TextView[2]");
        tradeInvent_zero.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void infoFilterByTradeInventoryEqualZero(){
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
        MobileElement tradeInventEqualZero = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.TextView[3]");
        tradeInventEqualZero.click();
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
        //Click Product without Stock
        MobileElement prodWithOrder = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.TextView[4]");
        prodWithOrder.click();
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
        //Click Returnable
        MobileElement sales631 = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.TextView[5]");
        sales631.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void infoFilterByStockAvailabilityNoStock(){
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
        MobileElement prod631 = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.TextView[6]");
        prod631.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }
    private void infoFilterByStockAvailabilityWithStock(){
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
        MobileElement prodWithOrder = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.TextView[7]");
        prodWithOrder.click();
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
        swipeDown();
        //Click Product Stock Weight = Low
        MobileElement prodStockAvailWithStock = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Stock weight = low']");
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
        swipeDown();
        //Click Product Stock Weight = Med
        MobileElement prodStockAvailWithStock = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Stock weight = medium']");
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
        swipeDown();
        //Click Product Stock Weight = High
        MobileElement prodStockAvailWithStock = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Stock weight = high']");
        prodStockAvailWithStock.click();
        //Click filter
        MobileElement filter = (MobileElement) driver.findElementById("android:id/button1");
        filter.click();
    }

    public void clear(){
        //Click triple Dots
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckDots = (MobileElement) driver.findElementByAccessibilityId("Show action");
        clckDots.click();
        //Click ClearAll
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement btnClear = (MobileElement) driver.findElementById("com.engagia.android:id/txt_clear_all_btn");
        btnClear.click();
        //Click CLEAR ALL
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement contBtn = (MobileElement) driver.findElementById("android:id/button1");
        contBtn.click();
        System.out.println("Clear done");
    }
    private void orderProtect(){
        //Click triple Dots
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckDots = (MobileElement) driver.findElementByAccessibilityId("Show action");
        clckDots.click();
        //Click ClearAll
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement orderProtect = (MobileElement) driver.findElementById("com.engagia.android:id/order_protection_switch");
        orderProtect.click();
        driver.navigate().back();
        System.out.println("Order Protection Clicked");
    }
    private void viewProductSummary(){
        for(int z = 1; z<=3; z++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement clickProd = (MobileElement) driver.findElementByXPath(productDrctry+"/android.widget.LinearLayout["+z+"]/android.widget.LinearLayout[1]/android.widget.TextView");
            clickProd.click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement prodTitle = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_title");
            String prodTitleText = prodTitle.getText();
            System.out.println("Product "+z+": "+prodTitleText);
            MobileElement arrowRight = (MobileElement) driver.findElementById("com.engagia.android:id/pager_next");
            arrowRight.click();
            MobileElement arrowLeft = (MobileElement) driver.findElementById("com.engagia.android:id/pager_previous");
            arrowLeft.click();
            driver.navigate().back();
        }
    }

    //Order functions
    private void orderPC(){
        for(int z = 1; z<=3; z++) {
            try {
                //1st Product per PC
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement orderPC = (MobileElement) driver.findElementByXPath(bookingOrderDrctry + "/android.widget.LinearLayout[" + z + "]/android.widget.LinearLayout[1]" +
                        "/android.widget.LinearLayout[1]/android.widget.TextView");
                orderPC.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Enter random numbers
                randomNum();
                MobileElement btnOk = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
                btnOk.click();
                String orderEnteredValue = orderPC.getText();
                System.out.println("Order PC " + z + " done: Value = "+ orderEnteredValue);
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
                MobileElement orderPC = (MobileElement) driver.findElementByXPath(bookingOrderDrctry + "/android.widget.LinearLayout[" + z + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView");
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
                MobileElement orderPC = (MobileElement) driver.findElementByXPath(bookingOrderDrctry + "/android.widget.LinearLayout["+z+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView");
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
                MobileElement orderBox = (MobileElement) driver.findElementByXPath(bookingOrderDrctry + "/android.widget.LinearLayout[" + z + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView");
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
                MobileElement orderBox = (MobileElement) driver.findElementByXPath(bookingOrderDrctry + "/android.widget.LinearLayout["+z+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView");
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
                MobileElement orderBox = (MobileElement) driver.findElementByXPath(bookingOrderDrctry + "/android.widget.LinearLayout[" + z + "]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView");
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
    private void orderFinalize(){
        //This Click the summary menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement summaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
        summaryMenu.click();
        //Click on Finalize
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement finalizeBtn = (MobileElement) driver.findElementById("com.engagia.android:id/txt_finalize_btn");
        finalizeBtn.click();
        //Enter Details on Finalize Order
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement custName = (MobileElement) driver.findElementById("com.engagia.android:id/txt_customer_name");
        custName.sendKeys("John Roe");
        MobileElement contactDtl = (MobileElement) driver.findElementById("com.engagia.android:id/txt_contact_detail");
        contactDtl.sendKeys("0917 XXX XXXX");
        MobileElement poNumber = (MobileElement) driver.findElementById("com.engagia.android:id/txt_po_number");
        poNumber.sendKeys("88888888");
        driver.hideKeyboard();
        //Click on Request Date
        MobileElement reqDate = (MobileElement) driver.findElementById("com.engagia.android:id/txt_request_delivery_date");
        reqDate.click();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        MobileElement clckArrow = (MobileElement) driver.findElementByAccessibilityId("Next month");
//        clckArrow.click();
        //This Accessibility Id can change depends on what date
//        MobileElement clickOnReqDate = (MobileElement) driver.findElementByAccessibilityId("28 February 2019");
//        clickOnReqDate.click();
        MobileElement clckOk = (MobileElement) driver.findElementById("android:id/button1");
        clckOk.click();
        //Location
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement location = (MobileElement) driver.findElementById("com.engagia.android:id/txt_ship_location");
        location.sendKeys("Makati City");
        //Notes
        driver.hideKeyboard();
        MobileElement notes = (MobileElement) driver.findElementById("com.engagia.android:id/txt_notes");
        notes.sendKeys("ASAP");
        driver.hideKeyboard();
        //PO Cancel Date
        MobileElement poCancelDate = (MobileElement) driver.findElementById("com.engagia.android:id/txt_po_cancel_date");
        poCancelDate.click();
        //Next Month or Arrow
//        clckArrow.click();
        MobileElement clickOnPoCancelDate = (MobileElement) driver.findElementByAccessibilityId("28 February 2019");
        clickOnPoCancelDate.click();
        clckOk.click();
        //Click on Save
        for(int z = 1; z<=2; z++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement saveBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_save_transaction");
            saveBtn.click();
            if(z==1){
                MobileElement engagiaMessage = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean engagiaMessageDisplayed = engagiaMessage.isDisplayed();
                if (engagiaMessageDisplayed) {
                    String engagiaMessageDisplayedText = engagiaMessage.getText();
                    System.out.println("Prompt appeared with message: " + engagiaMessageDisplayedText);
                    MobileElement cancelBtn = (MobileElement) driver.findElementById("android:id/button2");
                    String cancelBtnText = cancelBtn.getText();
                    cancelBtn.click();
                    System.out.println(cancelBtnText+" button clicked");
                }
            }
            else if(z==2) {
                //Prompt will appear
                MobileElement engagiaMessage = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean engagiaMessageDisplayed = engagiaMessage.isDisplayed();
                if (engagiaMessageDisplayed) {
                    String engagiaMessageDisplayedText = engagiaMessage.getText();
                    System.out.println("Prompt appeared with message: " + engagiaMessageDisplayedText);
                    MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
                    yesBtn.click();
                    String yesBtnText = yesBtn.getText();
                    System.out.println(yesBtnText+" button clicked");
                }
            }
        }
        MobileElement successMessage = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
        boolean successMessageDisplayed = successMessage.isDisplayed();
        if (successMessageDisplayed) {
            String successMessageText = successMessage.getText();
            System.out.println("Prompt appeared with message: " + successMessageText);
            MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
            yesBtn.click();
        }
        MobileElement transactionUploadMessage = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
        boolean transactionUploadMessageDisplayed = transactionUploadMessage.isDisplayed();
        if (transactionUploadMessageDisplayed) {
            String transactionUploadMessageText = transactionUploadMessage.getText();
            System.out.println("Prompt appeared with message: " + transactionUploadMessageText);
            MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
            yesBtn.click();
            String yesBtnText = yesBtn.getText();
            System.out.println(yesBtnText+" button clicked");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement syncCompletedMessage = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
        boolean syncCompletedMessageDisplayed = syncCompletedMessage.isDisplayed();
        if (syncCompletedMessageDisplayed) {
            String syncCompletedMessageText = syncCompletedMessage.getText();
            System.out.println("Prompt appeared with message: " + syncCompletedMessageText);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement closeBtn = (MobileElement) driver.findElementById("android:id/button1");
            closeBtn.click();
        }
    }

    /**
     *THIS FUNCTIONS IS FOR DEMO ONLY
     */
    public void bookingOrder(){
        //This click order on PC of product 1
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
//            wait.until(ExpectedConditions.visibilityOf())
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement bookingProd1 = (MobileElement) driver.findElementByXPath(bookingOrderDrctry + "/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]" +
                    "/android.widget.LinearLayout[1]/android.widget.TextView");
            bookingProd1.click();
        }
        //Enter value of 10
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement calBtn1 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_1");
        calBtn1.click();
        MobileElement calBtn0 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_0");
        calBtn0.click();
        MobileElement calOkBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
        calOkBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement bookingProd2 = (MobileElement) driver.findElementByXPath(bookingOrderDrctry + "/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView");
        bookingProd2.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        calBtn1.click();
        calBtn0.click();
        calOkBtn.click();
    }
    public void bookingTradeInventory(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement stockAvail = (MobileElement) driver.findElementByXPath(stockDrctry+"/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView");
        stockAvail.click();
        stockAvail.click();
        swipeRight();
        swipeRight();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement tradeInventoryPC1 = (MobileElement) driver.findElementByXPath(tradeInventDrctry+"/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]" +
                "/android.widget.LinearLayout[1]/android.widget.TextView");
        tradeInventoryPC1.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement calBtn1 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_1");
        calBtn1.click();
        MobileElement calBtn0 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_0");
        calBtn0.click();
        MobileElement calOkBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_ok");
        calOkBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement tradeInventoryPC2 = (MobileElement) driver.findElementByXPath(tradeInventDrctry+"/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]" +
                "/android.widget.LinearLayout[1]/android.widget.TextView");
        tradeInventoryPC2.click();
        calBtn1.click();
        calBtn0.click();
        calOkBtn.click();

    }
    public void orderFinalizeWithPreview(){
        //This Click the summary menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement summaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
        summaryMenu.click();
        //Click on preview
        MobileElement previewBtn = (MobileElement) driver.findElementById("com.engagia.android:id/txt_preview_btn");
        previewBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement closeBtn = (MobileElement) driver.findElementById("android:id/button1");
        closeBtn.click();
        //Click on Finalize
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement finalizeBtn = (MobileElement) driver.findElementById("com.engagia.android:id/txt_finalize_btn");
        finalizeBtn.click();
        //Enter Details on Finalize Order
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement custName = (MobileElement) driver.findElementById("com.engagia.android:id/txt_customer_name");
        custName.sendKeys("John Roe");
        MobileElement contactDtl = (MobileElement) driver.findElementById("com.engagia.android:id/txt_contact_detail");
        contactDtl.sendKeys("0917 XXX XXXX");
        MobileElement poNumber = (MobileElement) driver.findElementById("com.engagia.android:id/txt_po_number");
        poNumber.sendKeys("88888888");
        driver.hideKeyboard();
        //Click on Request Date
        MobileElement reqDate = (MobileElement) driver.findElementById("com.engagia.android:id/txt_request_delivery_date");
        reqDate.click();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        MobileElement clckArrow = (MobileElement) driver.findElementByAccessibilityId("Next month");
//        clckArrow.click();
        //This Accessibility Id can change depends on what date
        MobileElement clickOnDate1 = (MobileElement) driver.findElementByAccessibilityId("29 January 2019");
        clickOnDate1.click();
        MobileElement clckOk = (MobileElement) driver.findElementById("android:id/button1");
        clckOk.click();
        //Location
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement location = (MobileElement) driver.findElementById("com.engagia.android:id/txt_ship_location");
        location.sendKeys("Makati City");
        //Notes
        driver.hideKeyboard();
        MobileElement notes = (MobileElement) driver.findElementById("com.engagia.android:id/txt_notes");
        notes.sendKeys("ASAP");
        driver.hideKeyboard();
        //PO Cancel Date
        MobileElement poCancelDate = (MobileElement) driver.findElementById("com.engagia.android:id/txt_po_cancel_date");
        poCancelDate.click();
        //Next Month or Arrow
//        clckArrow.click();
        MobileElement clickOnDate2 = (MobileElement) driver.findElementByAccessibilityId("31 January 2019");
        clickOnDate2.click();
        clckOk.click();
        //Click on Save
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement saveBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_save_transaction");
        saveBtn.click();
        MobileElement yesBtn1 = (MobileElement) driver.findElementById("android:id/button1");
        yesBtn1.click();
        MobileElement yesBtn2 = (MobileElement) driver.findElementById("android:id/button1");
        yesBtn2.click();
        MobileElement yesBtn3 = (MobileElement) driver.findElementById("android:id/button1");
        yesBtn3.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement closeBtn2 = (MobileElement) driver.findElementById("android:id/button1");
        closeBtn2.click();
    }
    public void searchByNameDemo(){
        System.out.println("Searching by Name");
        //Click on arrow down or Filter by button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        //Click on Name
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement nameRadBtn = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.RadioButton[1]");
        nameRadBtn.click();
        MobileElement filterBtn = (MobileElement) driver.findElementById("android:id/button1");
        filterBtn.click();
        //Search on field
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchField.sendKeys("BOT PRODUCT");
        driver.hideKeyboard();
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
    }
    public void searchByCodeDemo(){
        System.out.println("Searching by Code");
        //Click on arrow down or Filter by button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        //Click on Name
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement codeRadBtn = (MobileElement) driver.findElementByXPath(searchByDrctry+"/android.widget.RadioButton[3]");
        codeRadBtn.click();
        MobileElement filterBtn = (MobileElement) driver.findElementById("android:id/button1");
        filterBtn.click();
        //Search on field
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchField.sendKeys("1018201701");
        driver.hideKeyboard();
        MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
        searchBtn.click();
    }
    public void filterByDocuSeq(){
        System.out.println("Filtering by Document Sequence");
        //Click on arrow down or Filter by button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        //Click on Prod Filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Document Sequence
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement docuSequence = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.TextView[8]");
        docuSequence.click();
        //Click on result of Docu Sequence
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement resultDocSeq = (MobileElement) driver.findElementById("android:id/text1");
        resultDocSeq.click();
        MobileElement filterBtn = (MobileElement) driver.findElementById("android:id/button1");
        filterBtn.click();

    }
    public void filterByMustCarry(){
        System.out.println("Filtering by Must Carry");
        //Click on arrow down or Filter by button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement arrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
        arrowDown.click();
        //Click on Prod Filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement prodFilter = (MobileElement) driver.findElementById("com.engagia.android:id/txt_product_filter");
        prodFilter.click();
        //Document Sequence
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement mustCarry = (MobileElement) driver.findElementByXPath(filterByDrctry+"/android.widget.TextView[3]");
        mustCarry.click();
        //Click on result of Docu Sequence
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement resultDocSeq = (MobileElement) driver.findElementById("android:id/text1");
        resultDocSeq.click();
        MobileElement filterBtn = (MobileElement) driver.findElementById("android:id/button1");
        filterBtn.click();

    }
    private void demoFunction(){
        System.out.println("Running Demo...");
//        filterByMustCarry();
//        searchByNameDemo();
        bookingOrder();
//        filterByDocuSeq();
//        searchByCodeDemo();
        bookingTradeInventory();
        orderFinalizeWithPreview();
        System.out.println("Demo finish running...");
    }
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
            SearchBAOF();
//            Case9();
//            Case10();
//            Case11();
//            Case12();
//            Case13();
//            Case14();
//            Case15();
//            Case16();
            //FILTER BY
//            Case17();
//            Case18();
//            Case19();
//            Case20();
//            Case21();
//            Case22(); No Historical Sales
//            Case23(); No Historical Sales + Must Carry?
//            Case24();
//            Case25();  force close with case 24
//            Case26();
//            Case27();
//            Case28(); CANCER TO
//            Case29(); NEED THIS TO TEST VVVV
//            Case30();
//            Case31();
//            Case32();
//            Case33();
//            Case34();
//            Case35();
//            Case36();
//            Case37();
//            Case38();
//            Case39();
//            Case40();
//            Case41();
//            Case42();
//            Case45();
//            Case46();
//            Case47();
//            Case49();
            Case52();
            Case53();
            Case54();



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
        int y1 = (int) (height * 0.75);
        int y2 = (int) (height * 0.50);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementById("com.engagia.android:id/buttonPanel");
        boolean element1Displayed = element1.isDisplayed();
        if (element1Displayed) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.press(new PointOption().withCoordinates(x, y1)).moveTo(new PointOption().withCoordinates(x, y2)).release().perform();
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
            int x2 = (int) (width * 0.55);
            int y = (int) (height * 0.30);
            TouchAction touchAction = new TouchAction(driver);
            //try this 300
            touchAction.longPress(new PointOption().withCoordinates(x1, y)).moveTo(new PointOption().withCoordinates(x2, y)).release().perform();
        }
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
