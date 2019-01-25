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

public class AR {

    AppiumDriver driver;
    String search = "Ac";

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
//        driver = new AppiumDriver(new URL("http://192.168.1.33:4723/wd/hub"), capabilities);
        driver = new AppiumDriver(new URL("http://192.168.0.167:4723/wd/hub"), capabilities);
    }

    @Test
    public void testAR(){
//        SearchAR();
//        Case1();
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
//        testCase();

    }

    //Check Accessing Account Receivables
    public void Case1(){
        SearchAR();
        //Loop
        //Navigate Home and Relaunching Engagia step (Step 6 and 7)
        driver.launchApp();
        //Close app (Step 8)
        driver.closeApp();
        //Open Engagia Again (Step 9)
        driver.launchApp();
        System.out.println("Case 1 Done");
    }
    //Check Search by " Account Name"
    public void Case2(){
        SearchAR();
        searchByAccName();
        noFoundOk();
        System.out.println("Case 2 Done");
    }
    //Check Search by "Account Code"
    public void Case3(){
        searchByAccCode();
        noFoundOk();
        System.out.println("Case 3 Done");
    }
    //Check Search by "Branch Name"
    public void Case4(){
        searchByBranchName();
        noFoundOk();
        System.out.println("Case 4 Done");
    }
    //Check Search by "Branch Code"
    public void Case5(){
        searchByBranchCode();
        noFoundOk();
        System.out.println("Case 5 Done");
    }
    //Check Search by "Invoice Number"
    public void Case6(){
        searchByInvoiceNum();
        noFoundOk();
        System.out.println("Case 6 Done");
    }
    //Check Search by "Invoice Date"
    public void Case7(){
        searchByInvoiceDate();
        noFoundDateOk();
        System.out.println("Case 7 Done");
    }
    //Check Summary button "Total Amount to Pay"
    public void Case8(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement summaryBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'action_function_controls')]");
        summaryBtn.click();
        driver.navigate().back();
        System.out.println("Case 8 Done");
    }
    //Check Summary button "Apply Payment"
    public void Case9(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement summaryBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'action_function_controls')]");
        summaryBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement payment = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'btn_save')]");
        payment.click();
        driver.navigate().back();
        //Check any of the checkbox
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='0' and @text='1']");
        checkBox1.click();
        summaryBtn.click();
        payment.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement navigateBack = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Navigate up']");
        navigateBack.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cnclBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button2') and @text='Cancel']");
        cnclBtn.click();
        navigateBack.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement contBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1') and @text='Continue']");
        contBtn.click();
        System.out.println("Case 9 Done");
    }
    //Check Table View "#"
    public void Case10(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='0' and @text='1']");
        checkBox1.click();
        checkBox1.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkBox2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='0' and @text='2']");
        checkBox2.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkBox3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='0' and @text='3']");
        checkBox3.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Please select same account and branch']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Snack bar text displayed: Please select same account and branch");
            checkBox1.click();
        }
        System.out.println("Case 10 Done");
    }
    //Check Table View "Account Name" naka depende to kung ano inupload ng user sa ems
    public void Case11(){
        //Account name 1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accName1 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.TextView[@index='0' and @text='ALFA MART']");
        boolean isDisplayed1 = accName1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Account name 1 is same with the uploaded data");
        }
        //Account name 2
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accName2 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='0']" +
                "/android.widget.TextView[@index='0' and @text='ALFA MART']");
        boolean isDisplayed2 = accName2.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Account name 3 is same with the uploaded data");
        }
        System.out.println("Case 11 Done");
    }
    //Check Table View "Account Code"
    public void Case12(){
        //Account Code 1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accCode1 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.TextView[@index='0' and @text='MARACC0002']");
        boolean isDisplayed1 = accCode1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Account Code 1 is same with the uploaded data");
        }
        //Account Code 2
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accCode2 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.TextView[@index='0' and @text='MARACC0004']");
        boolean isDisplayed2 = accCode2.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Account Code 3 is same with the uploaded data");
        }
        System.out.println("Case 12 Done");
    }
    //Check Table View "Branch Name"
    public void Case13(){
        swipeRight();
        //Branch name 1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement brnchName1 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='2']" +
                "/android.widget.TextView[@index='0' and @text='ALFAMART MARIKINA 2']");
        boolean isDisplayed1 = brnchName1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Branch name 2 is same with the uploaded data");
        }
        //Branch name 2
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement brnchName2 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='2']" +
                "/android.widget.TextView[@index='0' and @text='ALFAMART MARIKINA 4']");
        boolean isDisplayed2 = brnchName2.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Branch name 4 is same with the uploaded data");
        }
        System.out.println("Case 13 Done");
    }
    //Check Table View "Branch Code"
    public void Case14(){
        swipeRight();
        //Branch name 1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement brnchCode1 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='3']" +
                "/android.widget.TextView[@index='0' and @text='MARACCGCODE002']");
        boolean isDisplayed1 = brnchCode1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Branch Code 2 is same with the uploaded data");
        }
        //Branch name 2
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement brnchCode2 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='3']" +
                "/android.widget.TextView[@index='0' and @text='MARACCGCODE004']");
        boolean isDisplayed2 = brnchCode2.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Branch Code 4 is same with the uploaded data");
        }
        System.out.println("Case 14 Done");
    }
    //Check Table View "Invoice Number"
    public void Case15(){
        swipeRight();
        //Branch name 1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoNum1 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='4']" +
                "/android.widget.TextView[@index='0' and @text='1111111112']");
        boolean isDisplayed1 = invoNum1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Invoice number 1 is same with the uploaded data");
        }
        //Branch name 2
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoNum2 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='4']" +
                "/android.widget.TextView[@index='0' and @text='1111111114']");
        boolean isDisplayed2 = invoNum2.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Invoice number 3 is same with the uploaded data");
        }
        System.out.println("Case 15 Done");
    }
    //Check Table View "Invoice Date"
    public void Case16(){
        swipeRight();
        //Branch name 1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoDate1 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='5']" +
                "/android.widget.TextView[@index='0' and @text='2019-01-07']");
        boolean isDisplayed1 = invoDate1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Invoice date 1 is same with the uploaded data");
        }
        //Branch name 2
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoDate2 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='5']" +
                "/android.widget.TextView[@index='0' and @text='2019-01-11']");
        boolean isDisplayed2 = invoDate2.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Invoice date 3 is same with the uploaded data");
        }
        System.out.println("Case 16 Done");
    }
    //Check Table View "Invoice Due Date"
    public void Case17(){
        swipeRight();
        //Branch name 1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoDueDate1 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='6']" +
                "/android.widget.TextView[@index='0' and @text='2019-01-10']");
        boolean isDisplayed1 = invoDueDate1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Invoice Due date 1 is same with the uploaded data");
        }
        //Branch name 2
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoDueDate2 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='6']" +
                "/android.widget.TextView[@index='0' and @text='2019-01-14']");
        boolean isDisplayed2 = invoDueDate2.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Invoice Due date 3 is same with the uploaded data");
        }
        System.out.println("Case 17 Done");
    }
    //Check Table View "Days Outstanding"
    public void Case18(){
        swipeRight();
        swipeRight();
        System.out.println("Case 18 Done");
    }
    //Check Table View "Amount Due"
    public void Case19(){
        swipeRight();
        //Branch name 1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoDueDate1 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='8']" +
                "/android.widget.TextView[@index='0' and @text='1000.00']");
        boolean isDisplayed1 = invoDueDate1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Amount Due 1 is same with the uploaded data");
        }
        //Branch name 2
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoDueDate2 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='8']" +
                "/android.widget.TextView[@index='0' and @text='1000.00']");
        boolean isDisplayed2 = invoDueDate2.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Amount Due 3 is same with the uploaded data");
        }
        System.out.println("Case 19 Done");
    }
    //Check Table View "Payment Made" after dapat to ng transaction
    public void Case20(){
        swipeRight();
        System.out.println("Case 20 Done");
        //Index 9
    }
    //Check Table View "Deduction" after rin ng transaction
    public void Case21(){
        swipeRight();
        swipeRight();
        System.out.println("Case 21 Done");
        //Index 10
    }
    //Check Table View "Running Balance"
    public void Case22(){
        swipeRight();
        //Branch name 1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoDueDate1 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='11']" +
                "/android.widget.TextView[@index='0' and @text='1000.00']");
        boolean isDisplayed1 = invoDueDate1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Amount Due 1 is same with the uploaded data");
        }
        //Branch name 2
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoDueDate2 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='11']" +
                "/android.widget.TextView[@index='0' and @text='1000.00']");
        boolean isDisplayed2 = invoDueDate2.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Amount Due 3 is same with the uploaded data");
        }
        System.out.println("Case 22 Done");
    }
    //Check Table View "Discount"
    public void Case23(){
        swipeRight();
    }
    //Check Table View "OR Number"
    public void Case24(){
        swipeRight();
        //Branch name 1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoDueDate1 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='13']" +
                "/android.widget.TextView[@index='0' and @text='8888886510']");
        boolean isDisplayed1 = invoDueDate1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("OR Number 1 is same with the uploaded data");
        }
        //Branch name 2
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoDueDate2 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='13']" +
                "/android.widget.TextView[@index='0' and @text='8888886512']");
        boolean isDisplayed2 = invoDueDate2.isDisplayed();
        if (isDisplayed2) {
            System.out.println("OR Number 1 is same with the uploaded data");
        }
        System.out.println("Case 24 Done");
    }
    //Check Table View "OR Date"
    public void Case25(){
        swipeRight();
        //Branch name 1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoDueDate1 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='14']" +
                "/android.widget.TextView[@index='0' and @text='2019-01-07']");
        boolean isDisplayed1 = invoDueDate1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("OR Number 1 is same with the uploaded data");
        }
        //Branch name 2
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoDueDate2 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='14']" +
                "/android.widget.TextView[@index='0' and @text='2019-01-07']");
        boolean isDisplayed2 = invoDueDate2.isDisplayed();
        if (isDisplayed2) {
            System.out.println("OR Number 1 is same with the uploaded data");
        }
        swipeLeft();
        System.out.println("Case 25 Done");
    }
    //Check Apply Payment "Total Amount to be paid"
    public void Case26(){

    }
    //Check Apply Payment "Payment Type"
    public void Case27(){
        //Check box
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='0' and @text='1']");
        checkBox1.click();
        summaryMenu();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement payType = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'spinner_payment_type')]");
        payType.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement selectChck = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Check']");
        selectChck.click();
        payType.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement selectCash = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Cash']");
        selectCash.click();
        payType.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement selectCashAndCheck = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Cash and Check']");
        selectCashAndCheck.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement navigateBack = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Navigate up']");
        navigateBack.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement contBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1') and @text='Continue']");
        contBtn.click();
        System.out.println("Case 27 Done");
    }
    //Check Apply Payment "Total Deduction"
    public void Case28(){
        //Check box
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='0' and @text='1']");
        checkBox1.click();
        summaryMenu();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement totalDeduc = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text_total_deduction')]");
        totalDeduc.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement addBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'item_add') and @text='Add']");
        addBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement save = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'item_save') and @text='Save']");
        save.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement okBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
        okBtn.click();
        //Deduction Type
        for(int z = 1; z <= 4; z++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement deducType = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'spinner_deduction_type')]");
            deducType.click();
            if(z==1){
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement creditMemo = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Credit Memo']");
                creditMemo.click();
            }
            else if(z==2){
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement creditMemo = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Credit Note']");
                creditMemo.click();
            }
            else if(z==3){
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement creditMemo = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Witholding Tax']");
                creditMemo.click();
            }
            else if(z==4){
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement creditMemo = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Other']");
                creditMemo.click();
            }
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement menuBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'menu_option')]");
        menuBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement selectTrans = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='0']");
        selectTrans.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement docName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_document_name') and @index='0']");
        docName.sendKeys("Document Name!");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement docNum = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_document_number') and @index='0']");
        docNum.sendKeys("Document Number 123!");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement docVal = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_value_applied') and @index='0']");
        docVal.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckNO1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_1') and @index = '0']");
        clckNO1.click();
        MobileElement clckNO0 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_0') and @index = '1']");
        clckNO0.click();
        clckNO0.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkAmountOk = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'btn_ok')]");
        checkAmountOk.click();
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement docDate = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_document_date') and @index='0']");
        docDate.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clndrOkBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
        clndrOkBtn.click();
        //SAVE
        save.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement xRed = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'image_delete')]");
        xRed.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement navigateBack = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Navigate up']");
        navigateBack.click();
        totalDeduction();
        navigateBack.click();
        System.out.println("Case 28 Done");
    }
    //Check Apply Payment "Total Check Amount"
    public void Case29(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement payType = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'spinner_payment_type')]");
        payType.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement selectChck = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Check']");
        selectChck.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement totalChck = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text_check_amount')]");
        totalChck.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement addAmount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'item_add')]");
        addAmount.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement bnkOfCheck = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_bank_of_check')]");
        bnkOfCheck.sendKeys("BANK ABC");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkNum = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_check_number')]");
        checkNum.sendKeys("123456789");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkAmount = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_check_amount')]");
        checkAmount.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckNO1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_1') and @index = '0']");
        clckNO1.click();
        MobileElement clckNO0 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_0') and @index = '1']");
        clckNO0.click();
        clckNO0.click();
        clckNO0.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkAmountOk = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'btn_ok')]");
        checkAmountOk.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkDate = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_check_date')]");
        checkDate.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clndrNum1 = (MobileElement) driver.findElementByXPath("//android.view.View[@index='28' ]");
        clndrNum1.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clndrOK = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
        clndrOK.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement save = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'item_save') and @text='Save']");
        save.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement xRed = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'image_delete')]");
        xRed.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement navigateBack = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Navigate up']");
        navigateBack.click();
        payViaCheck();
        System.out.println("Case 29 Done");
    }
    //Check Apply Payment "Cash Amount"
    public void Case30(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement payType = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'spinner_payment_type')]");
        payType.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement selectCash = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Cash']");
        selectCash.click();
        //Continue btn
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement contBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        contBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement totalCash = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text_cash_amount')]");
        totalCash.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement delBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'btn_clr')]");
        for(int z=1; z<=4; z++){
            delBtn.click();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckNO0 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_0') and @index = '1']");
        clckNO0.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkAmountOk = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'btn_ok')]");
        checkAmountOk.click();
        //Snackbar
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'snackbar_text')]");
        boolean isDisplayed = snackBar.isDisplayed();
        if (isDisplayed) {
            System.out.println("Snackbar message displayed: Invalid input, must be greater than 0 ");
        }
        totalCash.click();
        //Negative value
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        for(int x=1; x<=4; x++){
            delBtn.click();
        }
        //Negative sign
        for(int y = 1; y<=2; y++) {
            if(y==1) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement sbtrctBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_subtract')]");
                sbtrctBtn.click();
            }
            else if(y==2) {
                delBtn.click();
            }
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement clckNO1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_1') and @index = '0']");
            clckNO1.click();
            clckNO0.click();
            clckNO0.click();
            clckNO0.click();
            checkAmountOk.click();

        }
        System.out.println("Case 30 Done");
    }
    //Check Apply Payment "Total Over Under"
    public void Case31(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement totalOverUnder = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_over_under') and @text='100.00']");
        boolean isDisplayed = totalOverUnder.isDisplayed();
        if (isDisplayed) {
            System.out.println("Case 32 Done");
        }
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement contBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Continue']");
        contBtn.click();
        System.out.println("Case 31 Done");
    }
    //Check Apply Payment "NEXT" nandito un transaction dapat last to
    public void Case32(){
        //Check box
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='0' and @text='1']");
        checkBox1.click();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        MobileElement checkBox2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='0' and @text='6']");
//        checkBox2.click();
        summaryMenu();
        //Next
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement next = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'ac_next') and @text='NEXT']");
        next.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement okBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
        okBtn.click();
        //Select Check
        payViaCheck();
        next.click();
        //Finalize
        finalizeAR();
        //Print
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement print = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'ac_print') and @text='PRINT']");
        print.click();
        driver.navigate().back();
        //Save
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement save = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'ac_save') and @text='SAVE']");
        save.click();
        //Cont
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement contBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Continue']");
        contBtn.click();
        okBtn.click();
        System.out.println("Case 32 Done");

    }
    //TEST
    public void testCase(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='1' and @index='0']");
        cBox1.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cBox2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='3' and @index='0']");
        cBox2.click();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        MobileElement threeDots = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls')]");
//        threeDots.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'snackbar_text') and @text='Please select same account and branch']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (!isDisplayed1) {
            System.out.println("Snackbar appear");
        }
    }

    //Functions
    public void SearchAR(){
        //click Hamburger Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement HamburgerBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
        HamburgerBtn.click();
        //search van
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'edit_text_search')]");
        searchField.sendKeys(search);
        //click search result
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckRes = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text_title')]");
        clckRes.click();
    }
    public void searchByAccName(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterByArrow = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        filterByArrow.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement srchByAccName = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Account Name']");
        srchByAccName.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBox = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchBox.sendKeys("Alfa");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
    }
    public void searchByAccCode(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterByArrow = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        filterByArrow.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement srchByAccCode = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Account Code']");
        srchByAccCode.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBox = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchBox.sendKeys("MARACC0002");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
    }
    public void searchByBranchName(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterByArrow = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        filterByArrow.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement srchByBrnchName = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Branch Name']");
        srchByBrnchName.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBox = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchBox.sendKeys("ALFAMART MARIKINA 2");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
    }
    public void searchByBranchCode(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterByArrow = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        filterByArrow.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement srchByBrnchCode = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Branch Code']");
        srchByBrnchCode.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBox = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchBox.sendKeys("MARACCGCODE002");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
    }
    public void searchByInvoiceNum(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterByArrow = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        filterByArrow.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement srchByInvoNum = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Invoice Number']");
        srchByInvoNum.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBox = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchBox.sendKeys("11111");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
    }
    public void searchByInvoiceDate(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterByArrow = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        filterByArrow.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement srchByInvoDate = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Invoice Date']");
        srchByInvoDate.click();
        //Calendar pwede palitan un index at text depende sa naka set sa ems na date
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clndrNum1 = (MobileElement) driver.findElementByXPath("//android.view.View[@index='6' ]");
        clndrNum1.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement okBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
        okBtn.click();
    }
    public void noFoundOk(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBox = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchBox.sendKeys("88888a2s5s");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button')]");
        searchBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         MobileElement okBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        okBtn.click();

    }
    public void noFoundDateOk(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterByArrow = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'filter_by_button')]");
        filterByArrow.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement srchByInvoDate = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Invoice Date']");
        srchByInvoDate.click();
        //Calendar pwede palitan un index at text depende sa naka set sa ems na date
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clndrNum1 = (MobileElement) driver.findElementByXPath("//android.view.View[@index='28' ]");
        clndrNum1.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement okBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
        okBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement okBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
        okBtn1.click();

    }
    public void summaryMenu(){
        //Summary
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement summaryBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'action_function_controls')]");
        summaryBtn.click();
        //Click Apply Payment
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement payment = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'btn_save')]");
        payment.click();
    }
    public void payViaCheck(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement payType = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'spinner_payment_type')]");
        payType.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement selectChck = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Check']");
        selectChck.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement totalChck = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text_check_amount')]");
        totalChck.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement addAmount = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'item_add')]");
        addAmount.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement bnkOfCheck = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_bank_of_check')]");
        bnkOfCheck.sendKeys("BANK ABC");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkNum = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_check_number')]");
        checkNum.sendKeys("123456789");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkAmount = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_check_amount')]");
        checkAmount.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckNO1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_1') and @index = '0']");
        clckNO1.click();
        MobileElement clckNO0 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_0') and @index = '1']");
        clckNO0.click();
        clckNO0.click();
        clckNO0.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkAmountOk = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'btn_ok')]");
        checkAmountOk.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkDate = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_check_date')]");
        checkDate.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clndrNum1 = (MobileElement) driver.findElementByXPath("//android.view.View[@index='28' ]");
        clndrNum1.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clndrOK = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
        clndrOK.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement save = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'item_save') and @text='Save']");
        save.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement navigateBack = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Navigate up']");
        navigateBack.click();
    }
    public void payViaCash(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement payType = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'spinner_payment_type')]");
        payType.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement selectCash = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Cash']");
        selectCash.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement totalCash = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text_cash_amount')]");
        totalCash.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement delBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'btn_clr')]");
        for(int z=1; z<=4; z++){
            delBtn.click();
        }
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        MobileElement clckNO1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_1') and @index = '0']");
//        clckNO1.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckNO0 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_0') and @index = '1']");
        clckNO0.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkAmountOk = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'btn_ok')]");
        checkAmountOk.click();
        //Snackbar
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'snackbar_text')]");
        boolean isDisplayed = snackBar.isDisplayed();
        if (isDisplayed) {
            System.out.println("Snackbar message displayed: Invalid input, must be greater than 0 ");
        }
        //Negative value

        totalCash.click();
        checkAmountOk.click();
//        MobileElement save = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'item_save') and @text='Save']");
//        save.click();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        MobileElement navigateBack = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Navigate up']");
//        navigateBack.click();
    }
    public void totalDeduction(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement totalDeduc = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text_total_deduction')]");
        totalDeduc.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement addBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'item_add') and @text='Add']");
        addBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement save = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'item_save') and @text='Save']");
        save.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement okBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
        okBtn.click();
        //Deduction Type
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement deducType = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'spinner_deduction_type')]");
        deducType.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement creditMemo = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Credit Memo']");
        creditMemo.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement menuBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'menu_option')]");
        menuBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement selectTrans = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='0']");
        selectTrans.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement docName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_document_name') and @index='0']");
        docName.sendKeys("Document Name!");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement docNum = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_document_number') and @index='0']");
        docNum.sendKeys("Document Number 123!");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement docVal = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_value_applied') and @index='0']");
        docVal.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckNO1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_1') and @index = '0']");
        clckNO1.click();
        MobileElement clckNO0 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'btn_0') and @index = '1']");
        clckNO0.click();
        clckNO0.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement checkAmountOk = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'btn_ok')]");
        checkAmountOk.click();
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement docDate = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_document_date') and @index='0']");
        docDate.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clndrOkBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
        clndrOkBtn.click();
        //SAVE
        save.click();
    }
    public void finalizeAR(){
        //Save
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement save = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'ac_save') and @text='SAVE']");
        save.click();
        //Official receipt # is required click ok
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement msgRequired1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'message') and @text='Official Receipt # is required']");
        boolean isDisplayed1 = msgRequired1.isDisplayed();
        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement ok = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
            ok.click();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement print = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'ac_print') and @text='PRINT']");
        print.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement ok = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
            ok.click();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement receiptNum1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_receipt_number') and @index='0']");
        receiptNum1.sendKeys("ABC123!@#$");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement receiptNum2 = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'menu_receipt_number') and @index='1']");
        receiptNum2.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement selectTrans = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @index='0']");
        selectTrans.click();
        driver.hideKeyboard();
        //Click print and save again
        save.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement msgRequired2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'message') and @text='Official Receipt Date is required']");
        boolean isDisplayed2 = msgRequired2.isDisplayed();
        if (isDisplayed2) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement ok = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
            ok.click();
        }
        print.click();
        if (isDisplayed2) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement ok = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
            ok.click();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement receiptDate = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_official_date') and @index='3']");
        receiptDate.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clndrOK = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
        clndrOK.click();
        //Open Camera
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement openCam = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'button_take_picture') and @index='1']");
        openCam.click();
        //Take pic
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement takeImg = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'shutter') and @index='1']");
        takeImg.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noteField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_notes') and @index='7']");
        noteField1.click();
        MobileElement noteField2 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'input_notes') and @index='7']");
        noteField2.sendKeys("1234");
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

}
