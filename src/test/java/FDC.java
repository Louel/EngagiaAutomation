import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import test.ThreadLocalDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class FDC {

    AppiumDriver driver;
    String search = "Field Data Cap";
    String searchFDA = "Field Data Archive";
    String [] randomText = {"zczxczxc","12331231","Abbbccde","Abcde!@#","1a2b3c","A1B1C1", "random" , "somerandomtxt", "randomtxtsome" , "randomsometxt"};
    String branchListDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout" +
            "/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView";
    String fdaDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.support.v7.widget.RecyclerView";


    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Samsung Galaxy J1 (2016)");
//        capabilities.setCapability("deviceName","HUAWEI");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("platformVersion", "5.1.1");
//        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("appPackage", "com.engagia.android");
        capabilities.setCapability("appActivity", "com.engagia.android.activities.LoginActivity");
        capabilities.setCapability("noSign", true);
        capabilities.setCapability(FULL_RESET, false);
        capabilities.setCapability(NO_RESET, true);
        //Papalitan un Ip depende sa pc
        driver = new AppiumDriver(new URL("http://192.168.1.40:4723/wd/hub"), capabilities);

    }
    @Test
    public void testFDC(){
        Case3();
        Case5();
        Case7();
        Case11();
        Case13();
        Case15();
        Case17();
        Case19();
        Case21();
        //Log in to visit function/code here
        fdcLogInToVisit();
        fdaFunction();
        syncAll();
    }
    //Case functions
    //ACCESSING FIELD DATA CAPTURE WHILE LOCATION SERVICES IS OFF
    public void Case1(){
        SearchFDC();
        //Loop
        //Navigate Home and Relaunching Engagia step (Step 6 and 7)
        driver.launchApp();
        //Close app (Step 8)
        driver.closeApp();
        //Open Engagia Again (Step 9)
        driver.launchApp();
        System.out.println("Case 1 Done");
    }
    //ACCESSING FIELD DATA CAPTURE WHILE LOCATION SERVICES IS ON
    public void Case2(){
        SearchFDC();
    }
    //TAKE PICTURE WHILE LOCATION SERVICES IS OFF
    public void Case3(){
        SearchFDC();
        //Steps 1 to 3: Open camera then press back
        for(int a = 1; a<=2; a++) {
            openCamera();
            driver.navigate().back();
            //Snackbar condition
            MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Taking picture was cancelled']");
            boolean isDisplayed1 =  snackBar.isDisplayed();
            if(isDisplayed1){
                System.out.println("Snack bar text displayed");
            }
            else if(!isDisplayed1){
                System.out.println("Failed: Snack bar text does not displayed");
            }
        }
        System.out.println("Steps 1 , 2 and 3 done.");
        //Take picture and save it
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        for(int b = 1; b<=4; b++) {
            pictureOnly();
        }
        //Insert swipe
        swipeDown();
        //Selecting pictures
        for(int c = 0; c<=3; c++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            //Pictures
            List<MobileElement> clckPic = (List<MobileElement>) driver.findElementsByClassName("android.widget.ImageView");
            clckPic.get(c).click();
            //press back
            driver.navigate().back();
        }
        System.out.println("Case 3 Done");
    }
    //Need ng clear dito kada mag transition sa panibagong case
    //TAKE PICTURE  WHILE LOCATION SERVICES IS ON
    public void Case4(){
        SearchFDC();
        //Steps 1 to 3: Open camera then press back
        for(int a = 1; a<=2; a++) {
            openCamera();
            driver.navigate().back();
            //Snackbar condition
            MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Taking picture was cancelled']");
            boolean isDisplayed1 =  snackBar.isDisplayed();
            if(isDisplayed1){
                System.out.println("Snack bar text displayed");
            }
            else if(!isDisplayed1){
                System.out.println("Failed: Snack bar text does not displayed");
            }
        }
        System.out.println("Steps 1 , 2 and 3 done.");
        //Take picture and save it
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        for(int b = 1; b<=4; b++) {
            pictureOnly();
        }
        //Insert swipe
        swipeDown();
        //Selecting pictures
        for(int c = 0; c<=3; c++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            //picture list
            List<MobileElement> clckPic = (List<MobileElement>) driver.findElementsByClassName("android.widget.ImageView");
            clckPic.get(c).click();
            //press back
            driver.navigate().back();
        }
        System.out.println("Case 4 Done");
    }
    //TEXT NOTE  WHILE LOCATION SERVICES IS OFF
    public void Case5(){
//        SearcFDC();
        //Insert swipe up
        swipeUp();
        for(int z = 1; z<=2; z++) {
//            textNoteCancel();
            noteTitleCancel();
            noteBodyCancel();
        }
        noteBodyOnly();
        textNote();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckTxtNoteOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
        clckTxtNoteOk.click();
        System.out.print("Case5 Done");
    }
    //TEXT NOTE  WHILE LOCATION SERVICES IS ON
    public void Case6(){
//        SearcFDC();
        //Insert swipe up
//        swipeUp();
        for(int z = 1; z<=2; z++) {
//            textNoteCancel();
            noteTitleCancel();
            noteBodyCancel();
        }
        noteBodyOnly();
        textNote();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckTxtNoteOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
        clckTxtNoteOk.click();
        System.out.print("Case5 Done");
    }
    //ACCOUNT / BRANCH  WHILE LOCATION SERVICES IS OFF
    public void Case7(){
//        SearcFDC();
        for(int z = 0; z<=3; z++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement clckAccBranch = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etAccountbranch') and @index='0']");
            clckAccBranch.click();
            //Insert Search Branch
            MobileElement searchBranch = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@text='Search' and @index='0']");
            searchBranch.sendKeys("MINI");
            driver.hideKeyboard();
            List<MobileElement> selectAccBranch = (List<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
            selectAccBranch.get(z).click();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAccBranch1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etAccountbranch') and @index='0']");
        clckAccBranch1.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='Cancel']");
        clckCancel.click();

    }
    //ACCOUNT / BRANCH  WHILE LOCATION SERVICES IS ON
    public void Case8(){
//        SearcFDC();
        accountBranch();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAccBranch1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etAccountbranch') and @index='0']");
        clckAccBranch1.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='Cancel']");
        clckCancel.click();

    }
    //ACCOUNT / BRANCH  WHILE LOCATION SERVICES IS OFF (Need to log in to visit)
    public void Case9(){

    }
    //ACCOUNT / BRANCH  WHILE LOCATION SERVICES IS ON (Need to log in to visit)
    public void Case10(){

    }
    //PRODUCT GROUP  WHILE LOCATION SERVICES IS OFF
    public void Case11(){
//        SearcFDC();
        for(int z = 1; z <=3; z++) {
            prodGroup();
        }
//        MobileElement clckProdGrp = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etProdGroup') and @index='0']");
        MobileElement clckProdGrp = (MobileElement) driver.findElementById("com.engagia.android:id/etProdGroup");
        clckProdGrp.click();

        for(int x = 1; x <=3; x++) {
            holdThis();
            prod();
        }
        //Press ok
        MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
        clckOk.click();
        //TODO lagay un ibang steps

    }
    //PRODUCT GROUP  WHILE LOCATION SERVICES IS ON
    public void Case12(){
//        SearcFDC();
        for(int z = 1; z <=3; z++) {
            prodGroup();
        }
        MobileElement clckProdGrp = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etProdGroup') and @index='0']");
        clckProdGrp.click();

        for(int x = 1; x <=3; x++) {
            holdThis();
            prod();
        }
        //Press ok
        MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
        clckOk.click();
        //TODO lagay un ibang steps

    }
    //KPI WHILE LOCATION SERVICES IS OFF
    public void Case13(){
//        SearcFDC();
        for(int z = 1; z<=3; z++) {
                kpi();
            if(z<=2) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCncl = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @index='0']");
                clckCncl.click();
                System.out.println("Canceled kpi");
            }
            else if(z==3) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @index='1']");
                clckOk.click();
                System.out.println("Done KPI");
            }
        }
    }
    //KPI WHILE LOCATION SERVICES IS ON
    public void Case14(){
//        SearcFDC();
        for(int z = 1; z<=3; z++) {
            kpi();
            if(z<=2) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCncl = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @index='0']");
                clckCncl.click();
                System.out.println("Canceled kpi");
            }
            else if(z==3) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @index='1']");
                clckOk.click();
                System.out.println("Done KPI");
            }
        }
    }
    //MARKET ACTIVITY  WHILE LOCATION SERVICES IS OFF
    public void Case15(){
//        SearcFDC();
        //Swipe
        swipeDown();
        for(int z = 1; z<=4; z++) {
            if(z==1) {
                marketActivities();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
                clckOk.click();
                System.out.println("Done selecting Market Activities");
            }
            else if(z==2){
                marketActivities();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCncl = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='Cancel']");
                clckCncl.click();
                System.out.println("Canceling Market Activities");
            }
            else if(z==3){
                newMrktActivites();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCncl = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='CANCEL']");
                clckCncl.click();
            }
            else if(z==4){
                newMrktActivites();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
                clckOk.click();
            }
        }
    }
    //MARKET ACTIVITY  WHILE LOCATION SERVICES IS ON
    public void Case16(){
//        SearcFDC();
        //Swipe
        swipeDown();
        for(int z = 1; z<=4; z++) {
            if(z==1) {
                marketActivities();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
                clckOk.click();
                System.out.println("Done selecting Market Activities");
            }
            else if(z==2){
                marketActivities();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCncl = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='Cancel']");
                clckCncl.click();
                System.out.println("Canceling Market Activities");
            }
            else if(z==3){
                newMrktActivites();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCncl = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='CANCEL']");
                clckCncl.click();
            }
            else if(z==4){
                newMrktActivites();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
                clckOk.click();
            }
        }
    }
    //COMPETITORS  WHILE LOCATION SERVICES IS OFF
    public void Case17(){
//        SearcFDC();
        //Swipe
        swipeDown();

        for(int z = 1; z<=4; z++) {
            if(z==1) {
                competitors();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
                clckOk.click();
                System.out.println("Done selecting Competitors");
            }
            else if(z==2){
                competitors();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCncl = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='Cancel']");
                clckCncl.click();
                System.out.println("Canceling Competitors");
            }
            else if(z==3){
                newCompetitors();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCncl = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='CANCEL']");
                clckCncl.click();
            }
            else if(z==4){
                newCompetitors();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
                clckOk.click();
            }
        }
    }
    //COMPETITORS  WHILE LOCATION SERVICES IS ON
    public void Case18(){
//        SearcFDC();
        //Swipe
        swipeDown();

        for(int z = 1; z<=4; z++) {
            if(z==1) {
                competitors();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
                clckOk.click();
                System.out.println("Done selecting Competitors");
            }
            else if(z==2){
                competitors();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCncl = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='Cancel']");
                clckCncl.click();
                System.out.println("Canceling Competitors");
            }
            else if(z==3){
                newCompetitors();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCncl = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='CANCEL']");
                clckCncl.click();
            }
            else if(z==4){
                newCompetitors();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
                clckOk.click();
            }
        }
    }
    //CLEAR WHILE LOCATION SERVICES IS OFF
    public void Case19(){
//        SearcFDC();
        clearAll();
        //Cancel
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckCncl = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='Cancel']");
        clckCncl.click();
        clearAll();
        //YES
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckYes = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='YES']");
        clckYes.click();
    }
    //CLEAR WHILE LOCATION SERVICES IS ON
    public void Case20(){
//        SearcFDC();
        clearAll();
        //Cancel
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckCncl = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='Cancel']");
        clckCncl.click();
        clearAll();
        //YES
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckYes = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='YES']");
        clckYes.click();
    }
    //SAVE  WHILE LOCATION SERVICES IS OFF
    public void Case21(){
//        SearcFDC();
        saveRequired();
        saveAll();
        System.out.println("Case 21 done");
        //Todo save all field
    }
    //For Visit
    public void Case21B(){
        saveRequired();
        savePerVisit();
        System.out.println("Case 21 done");
    }
    //Check Accessing Field Data Archive
    public void fieldDataArchive(){

    }


    //FUNCTIONS
    public void saveBtn(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckTakePic = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'btnSave') and @text='Save']");
        clckTakePic.click();
    }
    public void saveRequired(){
        for(int z = 1; z<=4; z++) {
            if(z==1){
                //Click save with out any input
                saveBtn();
                //Condition where if snackbar is displayed or not
                MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Text Note is Required']");
                boolean isDisplayed1 = snackBar.isDisplayed();
                if (isDisplayed1) {
                    System.out.println("Snack bar text displayed: Text Note is Required");
                } else if (!isDisplayed1) {
                    System.out.println("Failed: Snack bar text does not displayed");
                }
            }
            else if(z==2){
                textNote();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckTxtNoteOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
                clckTxtNoteOk.click();
                saveBtn();
                //Condition where if snackbar is displayed or not
                MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Market Activity is Required']");
                boolean isDisplayed1 = snackBar.isDisplayed();
                if (isDisplayed1) {
                    System.out.println("Snack bar text displayed: Market Activity is Required");
                } else if (!isDisplayed1) {
                    System.out.println("Failed: Snack bar text does not displayed");
                }
            }
            else if(z==3){
                marketActivities();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
                clckOk.click();
                saveBtn();
                //Condition where if snackbar is displayed or not
                MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Competitors are Required']");
                boolean isDisplayed1 = snackBar.isDisplayed();
                if (isDisplayed1) {
                    System.out.println("Snack bar text displayed: Competitors are Required");
                } else if (!isDisplayed1) {
                    System.out.println("Failed: Snack bar text does not displayed");
                }
            }
            else if(z==4){
                swipeHoldDown();
//                MobileElement snackBarComp = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Competitors are Required']");
//                WebDriverWait wait = new WebDriverWait(webDriver, 20);
//                wait.until(ExpectedConditions.invisibilityOfAllElements(snackBarComp));
                competitors();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
                clckOk.click();
                saveBtn();
                MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Save Successful']");
                boolean isDisplayed1 = snackBar.isDisplayed();
                if (isDisplayed1) {
                    System.out.println("Snack bar text displayed: Save Successful");
                } else if (!isDisplayed1) {
                    System.out.println("Failed: Snack bar text does not displayed");
                }
            }
        }
    }
    public void saveAll(){
        for(int z = 1; z<=7; z++) {
            if(z==1){
                //Fill up textnote
                textNote();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckTxtNoteOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
                clckTxtNoteOk.click();
                saveBtn();
                //Condition where if snackbar is displayed or not
                MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Market Activity is Required']");
                boolean isDisplayed1 = snackBar.isDisplayed();
                if (isDisplayed1) {
                    System.out.println("Snack bar text displayed: Market Activity is Required");
                } else if (!isDisplayed1) {
                    System.out.println("Failed: Snack bar text does not displayed");
                }
            }
            else if(z==2){
                //Fill up account branch
                accountBranch();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckAccBranch1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etAccountbranch') and @index='0']");
                clckAccBranch1.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='Cancel']");
                clckCancel.click();
            }
            else if(z==3){
                prodGroup();
            }
            else if(z==4){
                kpi();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @index='1']");
                clckOk.click();
                System.out.println("Done KPI");
            }
            else if(z==5){
                pictureOnly();
            }
            else if(z==6){
                swipeHoldDown();
                marketActivities();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
                clckOk.click();
                saveBtn();
                //Condition where if snackbar is displayed or not
                MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Competitors are Required']");
                boolean isDisplayed1 = snackBar.isDisplayed();
                if (isDisplayed1) {
                    System.out.println("Snack bar text displayed: Competitors are Required");
                } else if (!isDisplayed1) {
                    System.out.println("Failed: Snack bar text does not displayed");
                }
            }
            else if(z==7){
                swipeHoldDown();
                competitors();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
                clckOk.click();
                saveBtn();
                MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Save Successful']");
                boolean isDisplayed1 = snackBar.isDisplayed();
                if (isDisplayed1) {
                    System.out.println("Snack bar text displayed: Save Successful");
                } else if (!isDisplayed1) {
                    System.out.println("Failed: Snack bar text does not displayed");
                }
            }

        }
    }
    public void savePerVisit(){
        for(int z = 1; z<=7; z++) {
            if(z==1){
                //Fill up textnote
                textNote();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckTxtNoteOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
                clckTxtNoteOk.click();
                saveBtn();
                //Condition where if snackbar is displayed or not
                MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Market Activity is Required']");
                boolean isDisplayed1 = snackBar.isDisplayed();
                if (isDisplayed1) {
                    System.out.println("Snack bar text displayed: Market Activity is Required");
                } else if (!isDisplayed1) {
                    System.out.println("Failed: Snack bar text does not displayed");
                }
            }
            else if(z==2){
                prodGroup();
            }
            else if(z==3){
                kpi();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @index='1']");
                clckOk.click();
                System.out.println("Done KPI");
            }
            else if(z==4){
                pictureOnly();
            }
            else if(z==5){
                swipeHoldDown();
                marketActivities();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
                clckOk.click();
                saveBtn();
                //Condition where if snackbar is displayed or not
                MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Competitors are Required']");
                boolean isDisplayed1 = snackBar.isDisplayed();
                if (isDisplayed1) {
                    System.out.println("Snack bar text displayed: Competitors are Required");
                } else if (!isDisplayed1) {
                    System.out.println("Failed: Snack bar text does not displayed");
                }
            }
            else if(z==6){
                swipeHoldDown();
                competitors();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
                clckOk.click();
                saveBtn();
                MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Save Successful']");
                boolean isDisplayed1 = snackBar.isDisplayed();
                if (isDisplayed1) {
                    System.out.println("Snack bar text displayed: Save Successful");
                } else if (!isDisplayed1) {
                    System.out.println("Failed: Snack bar text does not displayed");
                }
            }

        }
    }
    public void pictureOnly(){
//        wait.until(ExpectedConditions.visibilityOf(clckTakePic));
        openCamera();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement takeImg = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'shutter') and @index='1']");
        takeImg.click();
        System.out.println("Picture Captured...");
        //Condition where if snackbar is displayed Case 3 pass
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Image Captured']");
        boolean isDisplayed1 =  snackBar.isDisplayed();
        if(isDisplayed1){
            System.out.println("Snack bar text displayed");
        }
        else if(!isDisplayed1){
            System.out.println("Failed: Snack bar text does not displayed");
        }
    }
    public void openCamera(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckTakePic = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'btnTakePic') and @text='Take Picture']");
        clckTakePic.click();
    }
    public void SearchFDC(){
        //click Hamburger Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement HamburgerBtn = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
        HamburgerBtn.click();
        //search FDA
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/edit_text_search");
        searchField.sendKeys(search);
        //click search result
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckRes = (MobileElement) driver.findElementByAccessibilityId("Field Data Capture");
        clckRes.click();
    }
    public void SearchFDA(){
        //click Hamburger Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement HamburgerBtn = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
        HamburgerBtn.click();
        //search FDA
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/edit_text_search");
        searchField.sendKeys(searchFDA);
        //click search result
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckRes = (MobileElement) driver.findElementByAccessibilityId("Field Data Archive");
        clckRes.click();
    }
    public void swipeDown(){
        //Loop swipe 10 times to view all forms attached
        for (int c = 0; c<3; c++) {
            Dimension dim = driver.manage().window().getSize();
            int width = dim.getWidth();
            //Para nasa gilid un pag scroll walang tatamaan textfield
            int x = (int) (width * 0.99);
            TouchAction touchAction = new TouchAction(driver);
//            touchAction.longPress(new PointOption().withCoordinates(270, 760)).moveTo(new PointOption().withCoordinates(270, 230)).release().perform();
            //try this
            touchAction.press(new PointOption().withCoordinates(x, 660)).moveTo(new PointOption().withCoordinates(x, 450)).release().perform();
            System.out.println("Swiping down("+c+")...");
        }
    }
    public void swipeHoldDown(){
        //Loop swipe 10 times to view all forms attached
        for (int c = 0; c<5; c++) {
            Dimension dim = driver.manage().window().getSize();
            int width = dim.getWidth();
            //Para nasa gilid un pag scroll walang tatamaan textfield
            int x = (int) (width * 0.99);
            TouchAction touchAction = new TouchAction(driver);
//            touchAction.longPress(new PointOption().withCoordinates(270, 760)).moveTo(new PointOption().withCoordinates(270, 230)).release().perform();
            //try this
            touchAction.longPress(new PointOption().withCoordinates(x, 660)).moveTo(new PointOption().withCoordinates(x, 450)).release().perform();
            System.out.println("Swiping down("+c+")...");
        }
    }
    public void swipeUp(){
        //Loop swipe 10 times to view all forms attached
        for (int c = 0; c<3; c++) {
            Dimension dim = driver.manage().window().getSize();
            int width = dim.getWidth();
            //Para nasa gilid un pag scroll walang tatamaan textfield
            int x = (int) (width * 0.99);
            TouchAction touchAction = new TouchAction(driver);
//            touchAction.longPress(new PointOption().withCoordinates(270, 760)).moveTo(new PointOption().withCoordinates(270, 230)).release().perform();
            //try this
            touchAction.press(new PointOption().withCoordinates(x, 300)).moveTo(new PointOption().withCoordinates(x, 500)).release().perform();
            System.out.println("Swiping up("+c+")...");
        }
    }
    public void swipeUpToLogin(){
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
    public void textNoteCancel(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckTxtNote = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etTextnote') and @index='0']");
        clckTxtNote.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement TxtNote = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etNoteTitle') and @index='0']");
        TxtNote.sendKeys(randomText[rand(randomText.length-1)]);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement NoteBody = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etNoteBody') and @index='0']");
        NoteBody.sendKeys();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckTxtNoteCncl = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='CANCEL']");
        clckTxtNoteCncl.click();
    }
    public void noteTitleCancel(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckTxtNote = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etTextnote') and @index='0']");
        clckTxtNote.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noteTitle = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etNoteTitle') and @index='0']");
        noteTitle.sendKeys(randomText[rand(randomText.length-1)]);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckTxtNoteCncl = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='CANCEL']");
        clckTxtNoteCncl.click();
        System.out.println("Note title cancel");
    }
    public void noteBodyCancel(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckTxtNote = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etTextnote') and @index='0']");
        clckTxtNote.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement NoteBody = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etNoteBody') and @index='0']");
        NoteBody.sendKeys(randomText[rand(randomText.length-1)]);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckTxtNoteCncl = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='CANCEL']");
        clckTxtNoteCncl.click();
        System.out.println("Note body cancel");
    }
    public void noteBodyOnly(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckTxtNote = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etTextnote') and @index='0']");
        clckTxtNote.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement NoteBody = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etNoteBody') and @index='0']");
        NoteBody.sendKeys(randomText[rand(randomText.length-1)]);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckTxtNoteOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
        clckTxtNoteOk.click();
        System.out.println("Note body filled up");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'textinput_error') and @text = 'Title is required!']");
        boolean isDisplayed1 =  snackBar.isDisplayed();
        if(isDisplayed1){
            System.out.println("Title is required text displayed");
        }
        else if(!isDisplayed1){
            System.out.println("Title is required text does not displayed");
        }
    }
    //Both title and body
    public void textNote(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckTxtNote = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etTextnote') and @index='0']");
        clckTxtNote.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement TxtNote = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etNoteTitle') and @index='0']");
        TxtNote.sendKeys(randomText[rand(randomText.length-1)]);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement NoteBody = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etNoteBody') and @index='0']");
        NoteBody.sendKeys(randomText[rand(randomText.length-1)]);


    }
    public void accountBranch(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAccBranch = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etAccountbranch') and @index='0']");
        clckAccBranch.click();
        //Insert Search Branch
        MobileElement searchBranch = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@text='Search' and @index='0']");
        searchBranch.sendKeys("MINI");
        driver.hideKeyboard();
        List<MobileElement> selectAccBranch = (List<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
        selectAccBranch.get(1).click();
    }
    public void holdThis(){

        MobileElement ProdGrp = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @index='0']");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(ProdGrp)).withDuration(Duration.ofMillis(1000))).release().perform();

    }
    public void prodGroup(){
        //Click Product Group
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        MobileElement clckProdGrp = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etProdGroup') and @index='0']");
        MobileElement clckProdGrp = (MobileElement) driver.findElementById("com.engagia.android:id/etProdGroup");
        clckProdGrp.click();
        //List of product groups
        List<MobileElement> selectProdGroup = (List<MobileElement>) driver.findElementsByClassName("android.widget.CheckedTextView");
        selectProdGroup.get(0).click();
        selectProdGroup.get(1).click();
        selectProdGroup.get(2).click();
        //Press ok
        MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
        clckOk.click();

    }
    public void prod(){
        //Click Product
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //List of product groups
        List<MobileElement> selectProd = (List<MobileElement>) driver.findElementsByClassName("android.widget.CheckedTextView");
        selectProd.get(0).click();
        selectProd.get(1).click();
        selectProd.get(2).click();
        //Press ok
        MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
        clckOk.click();
    }
    public void kpi(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckKPI = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etKpi') and @index='0']");
        clckKPI.click();
        //Atleast 3 un kpi na isetup sa EMS
        //List of KPI
        List<MobileElement> selectKPI = (List<MobileElement>) driver.findElementsByClassName("android.widget.CheckedTextView");
        selectKPI.get(0).click();
        selectKPI.get(1).click();
        selectKPI.get(2).click();
    }
    public void marketActivities(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMrktAct = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etMarketActivity') and @index='0']");
        clckMrktAct.click();
        //Atleast 3 un market activities na isetup sa EMS
        //List of Market Activities
        List<MobileElement> selectMrktAct = (List<MobileElement>) driver.findElementsByClassName("android.widget.CheckedTextView");
        selectMrktAct.get(0).click();
        selectMrktAct.get(1).click();
        selectMrktAct.get(2).click();
    }
    public void newMrktActivites(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMrktAct = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etMarketActivity') and @index='0']");
        clckMrktAct.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckNew = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button3') and @text='New ']");
        clckNew.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckNewMrktAct = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etNewMarketActivity') and @index='0']");
        clckNewMrktAct.sendKeys("New Market Activity!");
    }
    public void competitors(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckcompetitors = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etCompetitors') and @index='0']");
        clckcompetitors.click();
        //Atleast 3 un competitors na isetup sa EMS
        //List of clckcompetitors
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        List<MobileElement> selectCompetitors = (List<MobileElement>) driver.findElementsByClassName("android.widget.CheckedTextView");
        selectCompetitors.get(1).click();
        selectCompetitors.get(2).click();
    }
    public void newCompetitors(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMrktAct = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etCompetitors') and @index='0']");
        clckMrktAct.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckNew = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button3') and @text='New']");
        clckNew.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckNewMrktAct = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etNewCompetitor') and @index='0']");
        clckNewMrktAct.sendKeys("New Competitor!");
    }
    public void clearAll(){
        //Summary Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckSumMenu = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'action_function_controls') and @index='0']");
        clckSumMenu.click();
        //Clear
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckClear = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'title') and @text='Clear']");
        clckClear.click();
    }
    public void fdcLogInToVisit(){
        for (int x = 3; x <=5; x++) {
            //Click on Drawer
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement drawerOpen = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
            drawerOpen.click();
            swipeUpToLogin();
            //Click on Arrow down btn
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement clckArrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/image_visit_dropdown");
            clckArrowDown.click();
            //Click on branch depends on index or int of the loop
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            MobileElement clckOnBranch = (MobileElement) driver.findElementByXPath(branchListDrctry + "/android.widget.RelativeLayout[" + x + "]");
            clckOnBranch.click();
            //click on Ok
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
            okBtn.click();
//            SearcFDC();
            Case3();
            Case5();
            Case11();
            Case13();
            Case15();
            Case17();
            Case19();
            Case21B();
            //LogOut
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement sideBarBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
            sideBarBtn1.click();
            swipeUp();
            //Scroll down vvvv
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'edit_text_search')]");
            swipeUpToLogin();
            System.out.println("Branch " +x+ " done!");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            clckArrowDown.click();
            //Log out
            MobileElement logoutBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_visit_logout");
            logoutBtn.click();

        }
    }
    public void fdaFunction(){
        SearchFDA();
        for(int z=1; z<=5; z++) {
            if(z<=3){
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement fdaRecord1 = (MobileElement) driver.findElementByXPath(fdaDrctry + "/android.widget.LinearLayout["+ z +"]");
                fdaRecord1.click();
                driver.navigate().back();
            }
            else if(z==4 || z==5){
                //Delete records
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement fdaRecord1 = (MobileElement) driver.findElementByXPath(fdaDrctry + "/android.widget.LinearLayout[3]");
                TouchAction touchAction = new TouchAction(driver);
                touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(fdaRecord1)).withDuration(Duration.ofMillis(1000))).release().perform();
                if(z==4){
                    MobileElement noBtn = (MobileElement) driver.findElementById("android:id/button2");
                    noBtn.click();
                }
                else if(z==5){
                    MobileElement yesBtn = (MobileElement) driver.findElementById("android:id/button1");
                    yesBtn.click();
                }
            }
        }
    }
    public void syncAll(){
        MobileElement openDrawer = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
        openDrawer.click();
        swipeUpToLogin();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement dropDownMenu = (MobileElement) driver.findElementById("com.engagia.android:id/image_main_menu_dropdown");
        dropDownMenu.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement syncBtn = (MobileElement) driver.findElementById("com.engagia.android:id/action_sync");
        syncBtn.click();
        //INSERT TRY CATCH MESSAGE OF SLOW INTERNET SPEED
        try {
            MobileElement messageSlowNet = (MobileElement) driver.findElementById("android:id/message");
            if (messageSlowNet != null) {
                MobileElement contBtn = (MobileElement) driver.findElementById("android:id/button1");
                contBtn.click();
                System.out.println("Internet speed is slow ...");
            }
        }
        catch (NoSuchElementException e){
            System.out.println("Internet is fast ...");
        }
        driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
        MobileElement closeBtn = (MobileElement) driver.findElementById("android:id/button1");
        closeBtn.click();
        System.out.println("Sync done");
    }

    private static int rand(int bound) {
        return (int) (Math.random() * bound);
    }

}
