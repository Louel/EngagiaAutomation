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

    }

    //TODO Check App: "Search by Name"
    public void Case2a(){
        System.out.println("Testing Case 1");
        prodFilterByAllProd();
        //Search a product "Nova"
        MobileElement searchName = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
        searchName.sendKeys(productNames[rand(productNames.length-1)]);
        //Click on search btn
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        System.out.println("Case 1 Pass");
    }
    //Check Product Filter by "Product Group": Both logged in and not logged in
    public void Case2(){
        System.out.println("Testing Case 2");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Search Van Account Order Form
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on Product Filter
        MobileElement clckAllProd1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_product_filter')]");
        clckAllProd1.click();
        //Click Product Group
        MobileElement clckAllProd2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_product_group')]");
        clckAllProd2.click();
        //Click on CERTAIN product group
        MobileElement clckAllProd3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='0']");
        clckAllProd3.click();
//        //Click on information filter
//        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
//        clckInfoFil.click();
//        //Click on none
//        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_none')]");
//        clckNone.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        //Search a product "Nova"
//        MobileElement invalidSearchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
//        invalidSearchName.sendKeys(invalidProduct);
        MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
        searchName.sendKeys(productNames[rand(productNames.length-1)]);
        //Click on search btn
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        System.out.println("Case 2 Pass");
    }
    //Check Product Filter by "Must carry per Account Classification": Must be logged in
    public void Case3(){
        System.out.println("Testing Case 3");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //!!!!!!!!!!!!!!!! LOGIN TO VISIT!!!!!!!!!!!!!!!!!
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on Product Filter
        MobileElement clckAllProd1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_product_filter')]");
        clckAllProd1.click();
        //Click Must Carry Per account classification
        MobileElement clckAllProd2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_must_carry')]");
        clckAllProd2.click();
        //Click on CERTAIN product group
        MobileElement clckAllProd3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index = '0']");
        clckAllProd3.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        //Search a product "NAME"
        //erorr 1
//        MobileElement invalidSearchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
//        invalidSearchName.sendKeys(invalidProduct);
        MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
        searchName.sendKeys(products[rand(products.length-1)]);
        //Click on search btn
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        System.out.println("Case 3 Pass");
    }
    //Check Product Filter by "Brand": Both logged in and not logged in
    public void Case4(){
        System.out.println("Testing Case 4");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on Product Filter
        MobileElement clckAllProd1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_product_filter')]");
        clckAllProd1.click();
        //Click Brand
        MobileElement clckAllProd2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_brand') and @index='4']");
        clckAllProd2.click();
        //Click on CERTAIN product brand
        MobileElement clckAllProd3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='0']");
        clckAllProd3.click();
        //Click on filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        System.out.println("Case 4 Pass");
    }
    //Check Product Filter by "Product with Historical Sales" by  volume: Must be logged in
    public void Case5A(){
        System.out.println("Testing Case 5A");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //BY VOLUME!!!
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index='0']");
        clckArrw.click();
        //Click on Product Filter
        MobileElement clckAllProd1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_product_filter')]");
        clckAllProd1.click();
        //Click Product with historical sales
        MobileElement clckAllProd2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_w_historical_sales') and @index='5']");
        clckAllProd2.click();
        //Click on Volume
        MobileElement clckAllProd3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='0']");
        clckAllProd3.click();
        //Click on filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        System.out.println("Case 5a Pass");

    }
    //Check Product Filter by "Product with Historical Sales" by  value: Must be logged in
    public void Case5B(){
        System.out.println("Testing Case 5B");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //BY VALUE!!!
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index='0']");
        clckArrw.click();
        //Click on Product Filter
        MobileElement clckAllProd1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_product_filter')]");
        clckAllProd1.click();
        //Click Product with historical sales
        MobileElement clckAllProd2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_w_historical_sales') and @index='5']");
        clckAllProd2.click();
        //Click on Value
        MobileElement clckAllProd3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='1']");
        clckAllProd3.click();
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        System.out.println("Case 5b Pass");
    }
    //Check Product Filter by "Must carry + Products with Historical Sales": Must be logged in
    public void Case6(){
        System.out.println("Testing Case 6");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on Product Filter
        MobileElement clckAllProd1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_product_filter')]");
        clckAllProd1.click();
        //Click Must Carry + Historical Sales
        MobileElement clckAllProd2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_must_carry_w_historical_sales')]");
        clckAllProd2.click();
        //Select must carry
        MobileElement clckAllProd3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='0']");
        clckAllProd3.click();
        //Select if Volume or Value
        //Click on Volume
        MobileElement clckVol = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='0']");
        clckVol.click();
        //Click on Value
//        MobileElement clckVal = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='1']");
//        clckVal.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on none
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_none')]");
        clckNone.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        //Search a product "Nova"
//        MobileElement invalidSearchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
//        invalidSearchName.sendKeys(invalidProduct);
        MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
        searchName.sendKeys(products[rand(products.length-1)]);
        //Click on search btn
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        System.out.println("Case 6 Pass");

    }
    //Check Product Filter by "Document Sequence"
    public void Case7(){
        System.out.println("Testing Case 7");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on Product Filter
        MobileElement clckAllProd1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_product_filter')]");
        clckAllProd1.click();
        //Click Document sequence
        MobileElement clckAllProd2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_document_sequence')]");
        clckAllProd2.click();
        //Select docu sequence
        MobileElement clckAllProd3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='0']");
        clckAllProd3.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on none
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_none')]");
        clckNone.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        System.out.println("Case 7 Pass");
    }
    //Check Product Filter by "Deals"
    public void Case8(){
        System.out.println("Testing Case 8");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on Product Filter
        MobileElement clckAllProd1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_product_filter')]");
        clckAllProd1.click();
        //Click Deals
        MobileElement clckAllProd2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_deals')]");
        clckAllProd2.click();
        //Select docu sequence change this deal 3 depends on target deal -> [@text='Deal 3' and @index='0']
        MobileElement clckAllProd3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Deal 1' and @index='0']");
        clckAllProd3.click();
        //Click ok
        MobileElement clckOK = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'btn_ok')]");
        clckOK.click();
        //Enter minimum quantity of deals to apply
        MobileElement userField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'txt_multiplier')]");
        userField.sendKeys("10");
        //Click ok
        MobileElement clckOK1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        clckOK1.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on none
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_none')]");
        clckNone.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        System.out.println("Case 8 Pass");

    }
    //Check Product Filter by "Active Products"
    public void Case9(){
        System.out.println("Testing Case 9");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on Product Filter
        MobileElement clckAllProd1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_product_filter')]");
        clckAllProd1.click();
        //Click Active products
        MobileElement clckAllProd2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_active')]");
        clckAllProd2.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on none
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_none')]");
        clckNone.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        System.out.println("Case 9 Pass");
    }
    //Check Product Filter by "Carried Products"
    public void Case10(){
        System.out.println("Testing Case 10");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on Product Filter
        MobileElement clckAllProd1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_product_filter')]");
        clckAllProd1.click();
        //Click Carried products
        MobileElement clckAllProd2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_carried')]");
        clckAllProd2.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on none
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_none')]");
        clckNone.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        System.out.println("Case 10 Pass");
    }
    //Check Product Filter by "Not Carried Products"
    public void Case11(){
        System.out.println("Testing Case 11");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on Product Filter
        MobileElement clckAllProd1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_product_filter')]");
        clckAllProd1.click();
        //Click Not carried products
        MobileElement clckAllProd2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_not_carried')]");
        clckAllProd2.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on none
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_none')]");
        clckNone.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        //Hide keyboard
//        driver.hideKeyboard();
        System.out.println("Case 11 Pass");

    }
    //Check Information Filter by "None"
    public void Case12(){
        System.out.println("Testing Case 12");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on none
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_none')]");
        clckNone.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        System.out.println("Case 12 Pass");
    }
    //Check Information Filter by "Products without Stock"
    public void Case13(){
        System.out.println("Testing Case 13");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on Products without stock
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_without_stock')]");
        clckNone.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        System.out.println("Case 13 Pass");
    }
    //Check Information Filter by "Products with Stock"
    public void Case14(){
        System.out.println("Testing Case 14");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on Products with stock
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_with_stock')]");
        clckNone.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        System.out.println("Case 14 Pass");
    }
    //Check Information Filter by "Returnable"
    public void Case15(){
        System.out.println("Testing Case 15");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on Products without stock
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_returnable')]");
        clckNone.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        System.out.println("Case 15 Pass");
    }
    //Check Information Filter by "6,3,1 > 0"
    public void Case16(){
        System.out.println("Testing Case 16");
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on 6,3,1 > 0
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_6_3_1')]");
        clckNone.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        System.out.println("Case 16 Pass");
    }
    //Check Information Filter by "Products with Order"
    public void Case17(){
        System.out.println("Testing Case 17");
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on Products with order
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_with_order')]");
        clckNone.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        System.out.println("Case 17 Pass");
    }
    //Check Information Filter by "Stock Availability = No Stock"
    public void Case18(){
        System.out.println("Testing Case 18");
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on "Stock Availability = No Stock"
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_stock_availability_no_stock')]");
        clckNone.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        System.out.println("Case 18 Pass");
    }
    //Check Information Filter by "Stock Availability = with Stock"
    public void Case19(){
        System.out.println("Testing Case 19");
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on "Stock Availability = with Stock"
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_stock_availability_with_stock')]");
        clckNone.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        System.out.println("Case 19 Pass");
    }
    //Check Information Filter by "Stock Weight = Low"
    public void Case20(){
        System.out.println("Testing Case 20");
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on "Stock Availability = with Stock"
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_stock_weight_low')]");
        clckNone.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        System.out.println("Case 20 Pass");
    }
    //Check Information Filter by "Stock Weight = Medium"
    public void Case21(){
        System.out.println("Testing Case 21");
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on "Stock Availability = with Stock"
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_stock_weight_medium')]");
        clckNone.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        System.out.println("Case 21 Pass");
    }
    //Check Information Filter by "Stock Weight = High"
    public void Case22(){
        System.out.println("Testing Case 22");
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on "Stock Availability = with Stock"
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_stock_weight_high')]");
        clckNone.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        System.out.println("Case 22 Pass");
    }
    //Check "Search by Name"
    //todo lagyan ng value un pag ffilter like kung ano un issearch
    public void Case23(){
        System.out.println("Testing Case 23");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on Product Filter
        MobileElement clckAllProd1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_product_filter')]");
        clckAllProd1.click();
        //Click txt_filter_all
        MobileElement clckAllProd2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_all')]");
        clckAllProd2.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on none
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_none')]");
        clckNone.click();
        //Search by Name
        MobileElement SrchBy = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text ='Name' and @index = '0']");
        SrchBy.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        //Search a product by NAME
        MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
        searchName.sendKeys(productNames[rand(productNames.length-1)]);
        //Click on search btn
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        System.out.println("Case 23 Pass");
    }
    //Check "Search by Short Name"
    public void Case24(){
        System.out.println("Testing Case 24");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on Product Filter
        MobileElement clckAllProd1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_product_filter')]");
        clckAllProd1.click();
        //Click txt_filter_all
        MobileElement clckAllProd2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_all')]");
        clckAllProd2.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on none
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_none')]");
        clckNone.click();
        //Search by Short name
        MobileElement SrchBy = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text ='Short name' and @index = '1']");
        SrchBy.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
        searchName.sendKeys(productShortNames[rand(productShortNames.length-1)]);
        //Click on search btn
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        System.out.println("Case 24 Pass");
    }
    //Check "Search by Code"
    public void Case25(){
        System.out.println("Testing Case 25");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on Product Filter
        MobileElement clckAllProd1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_product_filter')]");
        clckAllProd1.click();
        //Click txt_filter_all
        MobileElement clckAllProd2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_all')]");
        clckAllProd2.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on none
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_none')]");
        clckNone.click();
        //Search by Code
        MobileElement SrchBy = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text ='Code' and @index = '2']");
        SrchBy.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
        searchName.sendKeys(productCode[rand(productCode.length-1)]);
        //Click on search btn
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        System.out.println("Case 25 Pass");
    }
    //Check "Search by Bar code"
    public void Case26(){
        System.out.println("Testing Case 26");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on Product Filter
        MobileElement clckAllProd1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_product_filter')]");
        clckAllProd1.click();
        //Click txt_filter_all
        MobileElement clckAllProd2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_all')]");
        clckAllProd2.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on none
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_none')]");
        clckNone.click();
        //Search by Bar code
        MobileElement SrchBy = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text ='Bar code' and @index = '3']");
        SrchBy.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        //Search Barcode
        MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
        searchName.sendKeys(productBarCode[rand(productBarCode.length-1)]);
        //Click on search btn
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        System.out.println("Case 26 Pass");
    }
    //Check "Search by Description"
    public void Case27(){
        System.out.println("Testing Case 27");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on Product Filter
        MobileElement clckAllProd1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_product_filter')]");
        clckAllProd1.click();
        //Click txt_filter_all
        MobileElement clckAllProd2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_all')]");
        clckAllProd2.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on none
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_none')]");
        clckNone.click();
        //Search by Description
        MobileElement SrchBy = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text ='Description' and @index = '4']");
        SrchBy.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        //Search Description
        MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
        searchName.sendKeys(productDescrip[rand(productDescrip.length-1)]);
        //Click on search btn
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        System.out.println("Case 27 Pass");
    }
    //Check "Search by Brand"
    public void Case28(){
        System.out.println("Testing Case 28");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on Product Filter
        MobileElement clckAllProd1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_product_filter')]");
        clckAllProd1.click();
        //Click txt_filter_all
        MobileElement clckAllProd2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_all')]");
        clckAllProd2.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on none
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_none')]");
        clckNone.click();
        //Search by Brand
        MobileElement SrchBy = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text ='Brand' and @index = '5']");
        SrchBy.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        //Search Brand
        MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
        searchName.sendKeys(productBrand[rand(productBrand.length-1)]);
        //Click on search btn
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        System.out.println("Case 28 Pass");
    }
    //Check "Search by Keyword"
    public void Case29(){
        System.out.println("Testing Case 29");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click arrow down
        MobileElement clckArrw = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button') and @index = '0']");
        clckArrw.click();
        //Click on Product Filter
        MobileElement clckAllProd1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_product_filter')]");
        clckAllProd1.click();
        //Click txt_filter_all
        MobileElement clckAllProd2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_all')]");
        clckAllProd2.click();
        //Click on information filter
        MobileElement clckInfoFil = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_information_filter')]");
        clckInfoFil.click();
        //Click on none
        MobileElement clckNone = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_filter_information_none')]");
        clckNone.click();
        //Swipe
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.longPress(new PointOption().withCoordinates(250, 580)).moveTo(new PointOption().withCoordinates(250, 520)).release().perform();
        }
        //Search by Keyword
        MobileElement SrchBy = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text ='Keyword' and @index = '6']");
        SrchBy.click();
        //Click filter
        MobileElement btnFil = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        btnFil.click();
        //Search Keyword
        MobileElement searchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
        searchName.sendKeys(productKeyword[rand(productKeyword.length-1)]);
        //Click on search btn
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        System.out.println("Case 29 Pass");
    }
    //Check "Summary Menu"
    //Error on Samsung
    public void Case30(){
        System.out.println("Testing Case 30");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click triple Dots
        MobileElement clckDots = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls') and @index = '0']");
        clckDots.click();
        //BACK BUTTON
        driver.navigate().back();
        System.out.println("Case 30 Pass");
    }
    //Check Summary Menu "Preview"
    public void Case31(){
        System.out.println("Testing Case 31");
        //wait to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click triple Dots
        MobileElement clckDots = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls') and @index = '0']");
        clckDots.click();
        //Click preview
        MobileElement clckPreview = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'btn_preview')]");
        clckPreview.click();
        //Click back
        MobileElement clckBack = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'btn_back')]");
        clckBack.click();
        //BACK BUTTON
        driver.navigate().back();
        System.out.println("Case 31 Pass");
    }
    //Check Summary Menu "Clear All"
    public void Case32(){
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
    public void Case33(){
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
    public void Case34(){
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
    public void Case35(){
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
    public void Case36(){
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
    public void Case37(){
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
    public void Case38(){
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
    public void Case39(){
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
        orderBoxPC();
        //not enough... inventory..
//        invalidOrderTransac();
        //need
        System.out.println("Case 39 Pass");

    }
    //Check "Inventory by UOM" Column walang laman sa script sa DOVOP
    public void Case40(){

    }
    //Check "Inventory" Column
    public void Case41(){
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
    public void Case42(){
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
    public void Case43(){
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
    public void Case44(){
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
    public void Case48(){
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
    public void Case49(){
        SearchVanSum();

    }
    /**
     //Check Deals no Steps to Execute on DOVOP
     public void Case50(){
     }
     //Check Discount
     public void Case51(){
     }
     //Check Product Returnable
     public void Case52(){
     }
     //Check Summary Menu "Salesman Discount'
     public void Case53(){
     }
     */

    //FUNCTIONS
    private void prodFilterByAllProd(){
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
    public void orderBoxPC() {
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
            MobileElement clckOk1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_ok') and @index = '1']");
            clckOk1.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Enter Value on Order Inventory
            MobileElement orderPC1 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']");
            orderPC1.click();
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
            MobileElement orderPC2 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']");
            orderPC2.click();
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
//            MobileElement orderPC3 = (MobileElement) driver.findElementByXPath(vaofDrctryTbl +
//                    "/android.widget.HorizontalScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.ScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.LinearLayout[@index='2']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.LinearLayout[@index='0']");
//            orderPC3.click();
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
    public void orderPC() {
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
            MobileElement orderPC1 = (MobileElement) driver.findElementByXPath(vaofDrctryByPC +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']");
            orderPC1.click();
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
            MobileElement orderPC2 = (MobileElement) driver.findElementByXPath(vaofDrctryByPC +
                    "/android.widget.HorizontalScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.ScrollView[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='1']" +
                    "/android.widget.LinearLayout[@index='0']" +
                    "/android.widget.LinearLayout[@index='0']");
            orderPC2.click();
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
//            MobileElement orderPC3 = (MobileElement) driver.findElementByXPath(vaofDrctryByPC +
//                    "/android.widget.HorizontalScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.ScrollView[@index='1']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.LinearLayout[@index='2']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.LinearLayout[@index='0']");
//            orderPC3.click();
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
    public void orderBox() {
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click triple Dots
        MobileElement clckDots = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls') and @index = '0']");
        clckDots.click();
        //Click ClearAll
        MobileElement clckClearAll1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'btn_clear')]");
        clckClearAll1.click();
        //Click CLEAR ALL
        MobileElement clckClearAll2 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        clckClearAll2.click();
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
    public void vaofLogInToVisit(){
        for (int x = 2; x < 3; x++) {
            //Click on Drawer
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement drawerOpen = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
            drawerOpen.click();
            //Click on Arrow down btn
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement clckArrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/image_visit_dropdown");
            clckArrowDown.click();
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
            Case5A();
            Case5B();
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
            Case29(); //<---- need swipe on myphone uno
//            //Summary  Three dots functions
//            //Test this vv
            Case30();
//            //lagyan ng transactions
            Case31();
            Case32();
            Case33();
//            Case34(); //Adjust should
//            //Qualified DEALS
            Case35();
////////        Case36(); //manual test this
//            Case37();
//            Case38();
//            Case39();
//            Case41();
//        //need swipe
//            Case42();
//            Case43();
            Case44();
//            Case48();
//            Case49();
//            orderBoxPC();
//            orderPC();
//            orderBox();

            //Log out to visit
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

    public void Listahan(){
        List<MobileElement> logBtn = (List<MobileElement>) driver.findElementsByClassName("com.engagia.android.utils.table.DataCell");
        logBtn.get(0).click();
    }

}
