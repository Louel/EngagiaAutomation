import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
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
//        capabilities.setCapability("deviceName","Samsung Galaxy J1 (2016)");
        capabilities.setCapability("deviceName","HUAWEI");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("platformVersion", "8.0.0");
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

    //Functions
    public void SearchBAOF(){
        //click Hamburger Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement HamburgerBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
        HamburgerBtn.click();
        System.out.println("Seaching BAOF");
        //search Note and Tasks
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/edit_text_search");
        searchField.sendKeys(search);
        //click search result
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckRes = (MobileElement) driver.findElementByAccessibilityId("Booking Account Order Form");
        clckRes.click();
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
    public void orderFinalize(){
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
    public void searchByName(){
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
    public void searchByCode(){
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
//        searchByName();
        bookingOrder();
//        filterByDocuSeq();
//        searchByCode();
        bookingTradeInventory();
        orderFinalize();
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
            MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
            okBtn.click();
            //INSERT CASES OR FUNCTION HERE
            SearchBAOF();
            demoFunction();
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
}
