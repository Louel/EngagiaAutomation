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
        driver = new AppiumDriver(new URL("http://192.168.1.33:4723/wd/hub"), capabilities);
    }

    @Test
    public void testAR(){
        SearchAR();
//        Case1();
//        Case2();
//        Case3();
//        Case4();
//        Case5();
//        Case6();
//        Case7();
//        Case8();
//        Case9();
//        Case10();
        Case11();
        Case12();
        Case13();
        Case14();
        Case15();
        Case16();
        Case17();
        Case18();
        Case19();

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
    }
    //Check Table View "Account Code"
    public void Case12(){
        //Account Code 1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accCode1 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.TextView[@index='0' and @text='MARACC0001']");
        boolean isDisplayed1 = accCode1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Account Code 1 is same with the uploaded data");
        }
        //Account Code 2
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accCode2 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='1']" +
                "/android.widget.TextView[@index='0' and @text='MARACC0002']");
        boolean isDisplayed2 = accCode2.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Account Code 3 is same with the uploaded data");
        }
    }
    //Check Table View "Branch Name"
    public void Case13(){
        swipeRight();
        //Branch name 1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement brnchName1 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='2']" +
                "/android.widget.TextView[@index='0' and @text='ALFAMART MARIKINA 1']");
        boolean isDisplayed1 = brnchName1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Branch name 1 is same with the uploaded data");
        }
        //Branch name 2
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement brnchName2 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='2']" +
                "/android.widget.TextView[@index='0' and @text='ALFAMART MARIKINA 2']");
        boolean isDisplayed2 = brnchName2.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Branch name 3 is same with the uploaded data");
        }
    }
    //Check Table View "Branch Code"
    public void Case14(){
        swipeRight();
        //Branch name 1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement brnchCode1 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='3']" +
                "/android.widget.TextView[@index='0' and @text='MARACCGCODE001']");
        boolean isDisplayed1 = brnchCode1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Branch Code 1 is same with the uploaded data");
        }
        //Branch name 2
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement brnchCode2 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='3']" +
                "/android.widget.TextView[@index='0' and @text='MARACCGCODE002']");
        boolean isDisplayed2 = brnchCode2.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Branch Code 3 is same with the uploaded data");
        }
    }
    //Check Table View "Invoice Number"
    public void Case15(){
        swipeRight();
        //Branch name 1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoNum1 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='4']" +
                "/android.widget.TextView[@index='0' and @text='123123123']");
        boolean isDisplayed1 = invoNum1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Invoice number 1 is same with the uploaded data");
        }
        //Branch name 2
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoNum2 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='4']" +
                "/android.widget.TextView[@index='0' and @text='1111111112']");
        boolean isDisplayed2 = invoNum2.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Invoice number 3 is same with the uploaded data");
        }
    }
    //Check Table View "Invoice Date"
    public void Case16(){
        swipeRight();
        //Branch name 1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoDate1 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='5']" +
                "/android.widget.TextView[@index='0' and @text='2019-01-02']");
        boolean isDisplayed1 = invoDate1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Invoice date 1 is same with the uploaded data");
        }
        //Branch name 2
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoDate2 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='5']" +
                "/android.widget.TextView[@index='0' and @text='2019-01-03']");
        boolean isDisplayed2 = invoDate2.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Invoice date 3 is same with the uploaded data");
        }
    }
    //Check Table View "Invoice Due Date"
    public void Case17(){
        swipeRight();
        //Branch name 1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoDueDate1 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']" +
                "/android.widget.LinearLayout[@index='6']" +
                "/android.widget.TextView[@index='0' and @text='2019-01-08']");
        boolean isDisplayed1 = invoDueDate1.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Invoice Due date 1 is same with the uploaded data");
        }
        //Branch name 2
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement invoDueDate2 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='2']" +
                "/android.widget.LinearLayout[@index='6']" +
                "/android.widget.TextView[@index='0' and @text='2019-01-09']");
        boolean isDisplayed2 = invoDueDate2.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Invoice Due date 3 is same with the uploaded data");
        }
    }
    //Check Table View "Days Outstanding"
    public void Case18(){
        swipeRight();
        swipeRight();
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
        swipeLeft();
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
        searchBox.sendKeys("MARACC0001");
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
        searchBox.sendKeys("ALFAMART MARIKINA 1");
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
        searchBox.sendKeys("MARACCGCODE001");
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
        MobileElement clndrNum1 = (MobileElement) driver.findElementByXPath("//android.view.View[@index='5' ]");
        clndrNum1.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement okBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
        okBtn.click();
    }
    public void noFoundOk(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBox = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view')]");
        searchBox.sendKeys("a2s5s");
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
