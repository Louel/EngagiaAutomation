package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class bookSummary extends BAOF{
    AppiumDriver driver;

    String search = "Booking Summary";
    String accountNameDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout";
    //Android Version 7.0 only v
    String accountNameDrctryV7 = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout";

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
        SearchBookingSummary();
//        Case1();
//        Case2();
        Case3();
    }

    /**
     * Long press a transaction:
     * Print Preview
     * Re-Order
     * Edit Transaction
     * Upload
     */

    //Cases

    //Check "Date from/Date to"
    public void Case1(){
        System.out.println("Testing Case 1");
        selectInvalidDate();
        selectDate();
        System.out.println("Case 1 Done");
    }
    //Check "Total with tax"
    public void Case2(){
        System.out.println("Testing Case 2");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement totalWithTax = (MobileElement) driver.findElementById("com.engagia.android:id/txt_total_with_tax");
        String TotalWithTaxValue = totalWithTax.getText();
        System.out.println("Total with tax = "+TotalWithTaxValue);
        System.out.println("Case 2 Done");
    }
    //Check table view"Account Name"
    public void Case3(){
        System.out.println("Testing Case 3");
        for(int z=1; z <=2; z++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//            MobileElement accountName = (MobileElement) driver.findElementByXPath(accountNameDrctry + "/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView");
            MobileElement accountName = (MobileElement) driver.findElementByXPath(accountNameDrctryV7+"/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView");
            TouchAction touchAction = new TouchAction(driver);
            touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(accountName)).withDuration(Duration.ofMillis(1200))).release().perform();
            MobileElement reOrder = (MobileElement) driver.findElementByXPath("//android.widget.ListView/android.widget.LinearLayout[2]");
//            MobileElement reOrder = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]");
            reOrder.click();
            MobileElement engagiaMessage = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
            boolean engagiaMessageDisplayed = engagiaMessage.isDisplayed();
            if (engagiaMessageDisplayed) {
                MobileElement message = (MobileElement) driver.findElementById("android:id/message");
                String messageText = message.getText();
                System.out.println("A prompt appear with message: " + messageText);
                if(z==1) {
                    MobileElement noBtn = (MobileElement) driver.findElementById("android:id/button2");
                    String noBtnText = noBtn.getText();
                    System.out.println(noBtnText+" button clicked");
                    noBtn.click();
                }else if(z==2){
                    MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
                    String yesBtnText = yesBtn.getText();
                    System.out.println(yesBtnText+" button clicked");
                    yesBtn.click();
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    MobileElement clckOnBranch = (MobileElement) driver.findElementByXPath(branchListDrctry + "/android.widget.RelativeLayout[1]");
                    clckOnBranch.click();
                    deleteOrderPC();
                    orderPC();
                    deleteOrderBox();
                    orderBox();
                    orderFinalize();
                }
            }
        }
        System.out.println("Case 3 Done");
    }
    //Check table view "Account Code"
    public void Case4(){

    }

    //Functions
    public void SearchBookingSummary(){
        //click Hamburger Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement HamburgerBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
        HamburgerBtn.click();
        System.out.println("Seaching Booking Summary");
        //search test.BAOF
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/edit_text_search");
        searchField.sendKeys(search);
        //click search result
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckRes = (MobileElement) driver.findElementByAccessibilityId("Booking Summary");
        clckRes.click();
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
                String orderEnteredValue = orderBox.getText();
                System.out.println("Order Box " + z + " done: Value = "+ orderEnteredValue);
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
                    MobileElement message = (MobileElement) driver.findElementById("android:id/message");
                    String messageText = message.getText();
                    System.out.println("A prompt appear with message: "+messageText);
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
                    MobileElement message = (MobileElement) driver.findElementById("android:id/message");
                    String messageText = message.getText();
                    System.out.println("A prompt appear with message: "+messageText);
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
            MobileElement message = (MobileElement) driver.findElementById("android:id/message");
            String messageText = message.getText();
            System.out.println("A prompt appear with message: "+messageText);
            MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
            yesBtn.click();
        }
        MobileElement transactionUploadMessage = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
        boolean transactionUploadMessageDisplayed = transactionUploadMessage.isDisplayed();
        if (transactionUploadMessageDisplayed) {
            MobileElement message = (MobileElement) driver.findElementById("android:id/message");
            String messageText = message.getText();
            System.out.println("A prompt appear with message: "+messageText);
            MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
            String yesBtnText = yesBtn.getText();
            System.out.println(yesBtnText+" button clicked");
            yesBtn.click();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement syncCompletedMessage = (MobileElement) driver.findElementById("com.engagia.android:id/text_successful_sync_header");
        boolean syncCompletedMessageDisplayed = syncCompletedMessage.isDisplayed();
        if (syncCompletedMessageDisplayed) {
            String syncCompletedMessageText = syncCompletedMessage.getText();
            System.out.println("A prompt appear with message: "+syncCompletedMessageText);
            MobileElement closeBtn = (MobileElement) driver.findElementById("android:id/button1");
            String closeBtnText = closeBtn.getText();
            System.out.println(closeBtnText+" button clicked");
            closeBtn.click();
        }
    }

    private void selectDate(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement dateFrom_dateTo = (MobileElement) driver.findElementById("com.engagia.android:id/txt_date_from_date_to");
        dateFrom_dateTo.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement dateFrom = (MobileElement) driver.findElementByAccessibilityId("01 February 2019");
        dateFrom.click();
        MobileElement dateFromOkBtn = (MobileElement) driver.findElementById("android:id/button1");
        dateFromOkBtn.click();
        MobileElement dateTo = (MobileElement) driver.findElementByAccessibilityId("28 February 2019");
        dateTo.click();
        MobileElement dateToOkBtn = (MobileElement) driver.findElementById("android:id/button1");
        dateToOkBtn.click();
    }
    private void selectInvalidDate(){
        for(int z = 1; z<=2; z++) {
            //Future date on date From
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement dateFrom_dateTo = (MobileElement) driver.findElementById("com.engagia.android:id/txt_date_from_date_to");
            dateFrom_dateTo.click();
            if(z==1) {
                MobileElement dateFrom = (MobileElement) driver.findElementByAccessibilityId("28 February 2019");
                dateFrom.click();
                MobileElement dateFromOkBtn = (MobileElement) driver.findElementById("android:id/button1");
                dateFromOkBtn.click();
                MobileElement engagiaMessage = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean engagiaMessageDisplayed = engagiaMessage.isDisplayed();
                if (engagiaMessageDisplayed) {
                    MobileElement message = (MobileElement) driver.findElementById("android:id/message");
                    String messageText = message.getText();
                    System.out.println("A prompt appear with message: " + messageText);
                    MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
                    okBtn.click();
                }
            }
            else if(z==2) {
                MobileElement dateFromOkBtn = (MobileElement) driver.findElementById("android:id/button1");
                dateFromOkBtn.click();
                MobileElement dateTo = (MobileElement) driver.findElementByAccessibilityId("01 February 2019");
                dateTo.click();
                MobileElement dateToOkBtn = (MobileElement) driver.findElementById("android:id/button1");
                dateToOkBtn.click();
                MobileElement engagiaMessage = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean engagiaMessageDisplayed = engagiaMessage.isDisplayed();
                if (engagiaMessageDisplayed) {
                    MobileElement message = (MobileElement) driver.findElementById("android:id/message");
                    String messageText = message.getText();
                    System.out.println("A prompt appear with message: " + messageText);
                    MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
                    okBtn.click();
                }
            }
        }
    }
    private void printPreview(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accountName = (MobileElement) driver.findElementByXPath(accountNameDrctryV7 + "/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(accountName)).withDuration(Duration.ofMillis(1200))).release().perform();
        MobileElement printView = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]");
        printView.click();
        MobileElement printPreviewPanel = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
        boolean printPreviewPanelDisplayed = printPreviewPanel.isDisplayed();
        if (printPreviewPanelDisplayed) {
            MobileElement printData = (MobileElement) driver.findElementById("com.engagia.android:id/txt_print_data");
            String printDataText = printData.getText();
            System.out.println("Print Preview Data: \n" + printDataText);
            MobileElement exitBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_exit");
            exitBtn.click();
        }
    }
    private void randomNum(){
        switch(rand(9 ) + 1){
            case 1: MobileElement clckNO1 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_1"); clckNO1.click();
                System.out.println("Click value: 1");
                break;
            case 2: MobileElement clckNO2 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_2"); clckNO2.click();
                System.out.println("Click value: 2");
                break;
            case 3: MobileElement clckNO3 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_3"); clckNO3.click();
                System.out.println("Click value: 3");
                break;
            case 4: MobileElement clckNO4 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_4"); clckNO4.click();
                System.out.println("Click value: 4");
                break;
            case 5: MobileElement clckNO5 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_5"); clckNO5.click();
                System.out.println("Click value: 5");
                break;
            case 6: MobileElement clckNO6 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_6"); clckNO6.click();
                System.out.println("Click value: 6");
                break;
            case 7: MobileElement clckNO7 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_7"); clckNO7.click();
                System.out.println("Click value: 7");
                break;
            case 8: MobileElement clckNO8 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_8"); clckNO8.click();
                System.out.println("Click value: 8");
                break;
            case 9: MobileElement clckNO9 = (MobileElement) driver.findElementById("com.engagia.android:id/btn_9");; clckNO9.click();
                System.out.println("Click value: 9");
                break;
        }
    }
    private static int rand(int bound) {
        return (int) (Math.random() * bound);
    }
}
