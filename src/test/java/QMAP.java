import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
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
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

public class QMAP {

    AppiumDriver driver;
    AndroidDriver ADdriver;
    String search = "Qui";
    String [] randomText = {"zczxczxc","12331231","Abbbccde","Abcde!@#","1a2b3c","A1B1C1"};
    String [] randomUpdateText = {"update!","updateyyyyqqqq","updatewwwwww","aaaaaaaupdate","cccupdateccc!@#","update11111","update222231!!!"};

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
        driver = new AppiumDriver(new URL("http://192.168.1.33:4723/wd/hub"), capabilities);

    }

    @Test
    public void testQMAP(){

//        Case1();
//        Case2();
//        ADdriver.toggleWifi();
//        swipingHorizontal();
//        Case4();
        testSwiping();

    }
    //ACCESSING QUICKMAP WHILE LOCATION SERVICES IS OFF (NO WIFI / NO DATA)
    public void Case1(){
        //LOOP 4 TIMES (STEP 10)
        for(int a = 1; a <= 12; a++) {
            SearchQMAP();
            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
            if (a <= 4){
                //Wait
                driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
                //Tap outside the alert dialog(Step 5)
                for (int x = 250; x < 255; x++) {
                    for (int y = 150; y < 155; y++) {
                        TouchAction touchAction = new TouchAction(driver);
                        touchAction.tap(new PointOption().withCoordinates(x, y)).perform();
                    }
                }
                //Navigate Home and Relaunching Engagia step (Step 6 and 7)
                driver.launchApp();
                //Close app (Step 8)
                driver.closeApp();
                //Open Engagia Again (Step 9)
                driver.launchApp();
                System.out.println("Step: "+a);
            }
            else if (a <= 8){
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckDny = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button2')]");
                clckDny.click();
                driver.closeApp();
                //Open Engagia Again (Step 9)
                driver.launchApp();
                System.out.println("Step: "+a);
            }
            else if (a <= 12){
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckDny = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
                clckDny.click();
                driver.closeApp();
                //Open Engagia Again (Step 9)
                driver.launchApp();
                System.out.println("Step: "+a);
            }
        }

    }
    //ACCESSING QUICKMAP WHILE LOCATION SERVICES IS OFF (ONLINE VIA WIFI)
    public void Case2(){
        SearchQMAP();
//        ADdriver.toggleWifi();
//        ADdriver.setConnection(Connection.WIFI);
        //Location




    }
    //ACCESSING QUICKMAP WHILE LOCATION SERVICES IS OFF (ONLINE VIA DATA)
    public void Case3(){

    }
    //FORMS
    public void Case4(){
        SearchQMAP();
        //SWIPE
//        for (int a = 1; a < 18; a++) {
//            MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn')]");
//            boolean isDisplayed = element1.isDisplayed();
//            MobileElement element2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text = 'Form_Lock1']");
//            boolean isDisplayed1 = element2.isDisplayed();
//            if (isDisplayed) {
//                TouchAction touchAction = new TouchAction(driver);
//                touchAction.longPress(new PointOption().withCoordinates(50, 480)).moveTo(new PointOption().withCoordinates(350, 150)).release().perform();
//            }
//            else if (isDisplayed1){
//                element2.click();
//            }
//        }
//        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn')]");
//        boolean isDisplayed = element1.isDisplayed();
//        while(!isDisplayed){
//            TouchAction touchAction = new TouchAction(driver);
//            touchAction.longPress(new PointOption().withCoordinates(50, 480)).moveTo(new PointOption().withCoordinates(350, 150)).release().perform();
//        }
//        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id, 'qmPictureIv') and @index = '1']");
//        boolean isDisplayed = element1.isDisplayed();
//        if (!isDisplayed) {
//            TouchAction touchAction = new TouchAction(driver);
//            touchAction.longPress(new PointOption().withCoordinates(250, 600)).moveTo(new PointOption().withCoordinates(250, 300)).release().perform();
//        }

        //Click and answer form here
        answerNotLockForms();
//        answeringForms();
        System.out.println("Done Answering Not Lock Forms");
        //Swipe down to view forms attached
        swipeDown();
        //Click on all answered Form from the list
        for (int d = 1; d<=5; d++) {
            //View then cancel
            if(d<=2) {
                cancelingForms();
            }
            //View then Update answers
            else if(d==3){
                updatingForms();
            }
            //Delete form
            else if (d==4){
                deletingForms();
            }
            //answering forms again..
            else if(d==5){
                answeringForms();
            }
        }
//        }
        //Update Forms
//        for (int b = 1; b < 4; b++) {
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            MobileElement clckFrms = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn')]");
//            clckFrms.click();
//            //Select Form 1
//            MobileElement selFrms1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock1']");
//            selFrms1.click();
//            //Fill up Form
//            MobileElement txtField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index = '1']");
//            txtField.sendKeys(randomUpdateText[rand(randomUpdateText.length-1)]);
//            //Hide KeyBoard
//            driver.hideKeyboard();
//            //CheckBox
//            MobileElement cb1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB1' and @index='1']");
//            cb1.click();
//            MobileElement cb2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB2' and @index='2']");
//            cb2.click();
////            MobileElement cb3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB3' and @index='3']");
////            cb3.click();
//            //RadioButton
//            MobileElement rb3 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB3' and @index='2']");
//            rb3.click();
//            MobileElement rb1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
//            rb1.click();
//            MobileElement rb2 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB2' and @index='1']");
//            rb2.click();
//
//            if (b <=3) {
//                //Save and Cancel
//                MobileElement cancelBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Cancel' and @index='0']");
//                cancelBtn.click();
//            }
//            else if (b==4){
//                MobileElement saveBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Update' and @index='1']");
//                saveBtn.click();
//            }
//        }
    }
//TODO LIPAT SA qmapTestAuto lahat ng code
    public void SearchQMAP(){
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
    public void answerNotLockForms(){
        //Click Forms
        //Loop
        //Filling up form 1 and saving
        for (int a = 1; a <= 28; a++) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            MobileElement clckFrms1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn')]");
            clckFrms1.click();
            //Cancel and Save
            if (a <=3) {
                //Select Form 1
                MobileElement selFrms1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock1']");
                selFrms1.click();
                //Fill up Form
                MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index = '1']");
                txtField1.sendKeys(randomText[rand(randomText.length-1)]);
                //Hide KeyBoard
                driver.hideKeyboard();
                //CheckBox
                MobileElement cb1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB1' and @index='1']");
                cb1.click();
                MobileElement cb2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB2' and @index='2']");
                cb2.click();
                MobileElement cb3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB3' and @index='3']");
                cb3.click();
                //RadioButton
                MobileElement rb1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
                rb1.click();
                MobileElement rb2 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB2' and @index='1']");
                rb2.click();
                MobileElement rb3 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB3' and @index='2']");
                rb3.click();
                //Cancel
                MobileElement cancelBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Cancel' and @index='0']");
                cancelBtn1.click();
                System.out.println("Cancel " +a);
            }
            else if (a==4){
                //Select Form 1
                MobileElement selFrms1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock1']");
                selFrms1.click();
                //Fill up Form
                MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index = '1']");
                txtField1.sendKeys(randomText[rand(randomText.length-1)]);
                //Hide KeyBoard
                driver.hideKeyboard();
                //CheckBox
                MobileElement cb1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB1' and @index='1']");
                cb1.click();
                MobileElement cb2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB2' and @index='2']");
                cb2.click();
                MobileElement cb3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB3' and @index='3']");
                cb3.click();
                //RadioButton
                MobileElement rb1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
                rb1.click();
                MobileElement rb2 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB2' and @index='1']");
                rb2.click();
                MobileElement rb3 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB3' and @index='2']");
                rb3.click();
                //Save
                MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Save' and @index='1']");
                clckSave.click();
                System.out.println("Save " +a);
            }
            //Form 2
            else if (a<=7){
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 1
                MobileElement selFrms2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock2']");
                selFrms2.click();
                //Fill up field
                MobileElement txtField2 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField2.sendKeys(randomText[rand(randomText.length-1)]);
                //Hide keyboard
                driver.hideKeyboard();
                //Cancel
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Cancel' and @index='0']");
                clckCancel.click();
                System.out.println("Cancel " +a);
            }
            else if (a==8){
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 2
                MobileElement selFrms2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock2']");
                selFrms2.click();
                //Fill up field
                MobileElement txtField2 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField2.sendKeys(randomText[rand(randomText.length-1)]);
                //Hide keyboard
                driver.hideKeyboard();
                //Save
                MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Save' and @index='1']");
                clckSave.click();
                System.out.println("Save " +a);
            }
            //Forms 3
            else if(a<=11){
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 3
                MobileElement selFrms3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock3']");
                selFrms3.click();
                //Click on Check box
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='1' and @text='CB1']");
                chckBox1.click();
                //Cancel
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='0' and @text='Cancel']");
                clckCancel.click();
                System.out.println("Cancel " +a);
            }
            else if(a==12){
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 3
                MobileElement selFrms3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock3']");
                selFrms3.click();
                //Click on Check box
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='1' and @text='CB1']");
                chckBox1.click();
                //Save
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='1' and @text='Save']");
                clckSave.click();
                System.out.println("Save " +a);
            }
            //Forms 4
            else if(a<=15){
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 4
                MobileElement selFrms4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock4']");
                selFrms4.click();
                //Click on Radio button
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
                radioBtn1.click();
                //Cancel
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='0' and @text='Cancel']");
                clckCancel.click();
                System.out.println("Cancel " +a);
            }
            else if(a==16){
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 4
                MobileElement selFrms4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock4']");
                selFrms4.click();
                //Click on Radio button
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@index='0' and @text='RB1']");
                radioBtn1.click();
                //Save
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='1' and @text='Save']");
                clckSave.click();
                System.out.println("Save " +a);
            }
            //Form 5
            else if(a<=19){driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 5
                MobileElement selFrms5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock5']");
                selFrms5.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField1.sendKeys(randomText[rand(randomText.length-1)]);
                driver.hideKeyboard();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='1' and @text='CB1']");
                chckBox1.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='2' and @text='CB2']");
                chckBox2.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='3' and @text='CB3']");
                chckBox3.click();
                //Cancel
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='0' and @text='Cancel']");
                clckCancel.click();
                System.out.println("Cancel " +a);


            }
            else if(a==20){
                //Select Form 5
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement selFrms5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock5']");
                selFrms5.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField1.sendKeys(randomText[rand(randomText.length-1)]);
                driver.hideKeyboard();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='1' and @text='CB1']");
                chckBox1.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='2' and @text='CB2']");
                chckBox2.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='3' and @text='CB3']");
                chckBox3.click();
                //Save
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='1' and @text='Save']");
                clckSave.click();
                System.out.println("Save " +a);
            }
            //Forms 6
            else if (a<=23){
                //Select Form 6
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement selFrms5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock6']");
                selFrms5.click();
                //Tick all checkbox
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='1' and @text='CB1']");
                chckBox1.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='2' and @text='CB2']");
                chckBox2.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='3' and @text='CB3']");
                chckBox3.click();
                //Click on Radio button
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
                radioBtn1.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB2' and @index='1']");
                radioBtn2.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn3 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB3' and @index='2']");
                radioBtn3.click();
                //Cancel
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='0' and @text='Cancel']");
                clckCancel.click();
                System.out.println("Cancel " +a);
            }
            else if (a==24){
                //Select Form 6
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement selFrms5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock6']");
                selFrms5.click();
                //Tick all checkbox
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='1' and @text='CB1']");
                chckBox1.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='2' and @text='CB2']");
                chckBox2.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='3' and @text='CB3']");
                chckBox3.click();
                //Click on Radio button
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
                radioBtn1.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB2' and @index='1']");
                radioBtn2.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn3 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB3' and @index='2']");
                radioBtn3.click();
                //Save
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='1' and @text='Save']");
                clckSave.click();
                System.out.println("Save " +a);
            }
            //Forms 7
            else if (a<=27){
                //Insert Swipe
                //Swipe
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement element2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock6']");
                boolean isDisplayed2 = element2.isDisplayed();
                if (isDisplayed2) {
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    TouchAction touchAction = new TouchAction(driver);
                    touchAction.longPress(new PointOption().withCoordinates(150, 730)).moveTo(new PointOption().withCoordinates(150, 670)).release().perform();
                }
                //Select Form 7
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement selFrms7 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock7']");
                selFrms7.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField1.sendKeys(randomText[rand(randomText.length-1)]);
                driver.hideKeyboard();
                //Click on Radio button
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
                radioBtn1.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB2' and @index='1']");
                radioBtn2.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn3 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB3' and @index='2']");
                radioBtn3.click();
                //Cancel
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='0' and @text='Cancel']");
                clckCancel.click();
                System.out.println("Cancel " +a);
            }
            else if (a==28){
                //Insert Swipe
                //Swipe
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement element2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock7']");
                boolean isDisplayed2 = element2.isDisplayed();
                if (isDisplayed2) {
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    TouchAction touchAction = new TouchAction(driver);
                    touchAction.longPress(new PointOption().withCoordinates(150, 730)).moveTo(new PointOption().withCoordinates(150, 670)).release().perform();
                }
                //Select Form 7
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement selFrms7 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock7']");
                selFrms7.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField1.sendKeys(randomText[rand(randomText.length-1)]);
                driver.hideKeyboard();
                //Click on Radio button
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
                radioBtn1.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB2' and @index='1']");
                radioBtn2.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn3 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB3' and @index='2']");
                radioBtn3.click();
                //Save
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='1' and @text='Save']");
                clckSave.click();
                System.out.println("Save " +a);
            }

        }
    }
    public void answeringForms(){
        //Click Forms
        //Loop
        //Filling up form 1 and saving
        System.out.println("Answering forms again...");
        for (int a = 1; a <= 7; a++) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            MobileElement clckFrms1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn')]");
            clckFrms1.click();
            //Cancel and Save
            //Form 1
            if (a == 1) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 1
                MobileElement selFrms1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock1']");
                selFrms1.click();
                //Fill up Form
                MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index = '1']");
                txtField1.sendKeys(randomText[rand(randomText.length-1)]);
                //Hide KeyBoard
                driver.hideKeyboard();
                //CheckBox
                MobileElement cb1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB1' and @index='1']");
                cb1.click();
                MobileElement cb2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB2' and @index='2']");
                cb2.click();
                MobileElement cb3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB3' and @index='3']");
                cb3.click();
                //RadioButton
                MobileElement rb1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
                rb1.click();
                MobileElement rb2 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB2' and @index='1']");
                rb2.click();
                MobileElement rb3 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB3' and @index='2']");
                rb3.click();
                //Save
                MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Save' and @index='1']");
                clckSave.click();
                System.out.println("Save " +a);
            }
            //Form 2
            else if (a==2){
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 2
                MobileElement selFrms2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock2']");
                selFrms2.click();
                //Fill up field
                MobileElement txtField2 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField2.sendKeys(randomText[rand(randomText.length-1)]);
                //Hide keyboard
                driver.hideKeyboard();
                //Save
                MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Save' and @index='1']");
                clckSave.click();
                System.out.println("Save " +a);
            }
            //Forms 3
            else if(a==3){
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 3
                MobileElement selFrms3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock3']");
                selFrms3.click();
                //Click on Check box
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='1' and @text='CB1']");
                chckBox1.click();
                //Save
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='1' and @text='Save']");
                clckSave.click();
                System.out.println("Save " +a);
            }
            //Forms 4
            else if(a==4){
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 4
                MobileElement selFrms4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock4']");
                selFrms4.click();
                //Click on Radio button
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@index='0' and @text='RB1']");
                radioBtn1.click();
                //Save
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='1' and @text='Save']");
                clckSave.click();
                System.out.println("Save " +a);
            }
            //Form 5
            else if(a==5){
                //Select Form 5
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement selFrms5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock5']");
                selFrms5.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField1.sendKeys(randomText[rand(randomText.length-1)]);
                driver.hideKeyboard();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='1' and @text='CB1']");
                chckBox1.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='2' and @text='CB2']");
                chckBox2.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='3' and @text='CB3']");
                chckBox3.click();
                //Save
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='1' and @text='Save']");
                clckSave.click();
                System.out.println("Save " +a);
            }
            //Forms 6
            else if (a==6){
                //Select Form 6
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement selFrms5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock6']");
                selFrms5.click();
                //Tick all checkbox
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='1' and @text='CB1']");
                chckBox1.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='2' and @text='CB2']");
                chckBox2.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='3' and @text='CB3']");
                chckBox3.click();
                //Click on Radio button
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
                radioBtn1.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB2' and @index='1']");
                radioBtn2.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn3 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB3' and @index='2']");
                radioBtn3.click();
                //Save
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='1' and @text='Save']");
                clckSave.click();
                System.out.println("Save " +a);
            }
            //Forms 7
            else if (a==7){
                //Insert Swipe
                //Swipe
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement element2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock7']");
                boolean isDisplayed2 = element2.isDisplayed();
                if (isDisplayed2) {
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    TouchAction touchAction = new TouchAction(driver);
                    touchAction.longPress(new PointOption().withCoordinates(150, 730)).moveTo(new PointOption().withCoordinates(150, 670)).release().perform();
                }
                //Select Form 7
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement selFrms7 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock7']");
                selFrms7.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField1.sendKeys(randomText[rand(randomText.length-1)]);
                driver.hideKeyboard();
                //Click on Radio button
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
                radioBtn1.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB2' and @index='1']");
                radioBtn2.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn3 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB3' and @index='2']");
                radioBtn3.click();
                //Save
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='1' and @text='Save']");
                clckSave.click();
                System.out.println("Save " +a);
            }

        }
    }
    public void swipeDown(){
        //Loop swipe 10 times to view all forms attached
        for (int c = 0; c<10; c++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.longPress(new PointOption().withCoordinates(270, 760)).moveTo(new PointOption().withCoordinates(270, 230)).release().perform();
            System.out.println("Swiping down("+c+")...");
        }
    }
    public void viewForms(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clickView = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='0' and @text='View']");
        clickView.click();
    }
    public void deleteForms(){
        //Click delete
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clickView = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='0' and @text='Delete']");
        clickView.click();
        //Click ok
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement clickOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='1' and @text='Ok']");
        clickOk.click();
        System.out.println("Deleting a Form... Done");
    }
    public void cancel(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clickCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='0' and @text='Cancel']");
        clickCancel.click();
        System.out.println("Cancel... Form");
    }
    public void update(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clickCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='1' and @text='Update']");
        clickCancel.click();
        System.out.println("Updating... Form");
    }
    public void cancelingForms(){
        //Click Form_Not_Lock1
        System.out.println("Viewing Form_Not_Lock1...");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='0' and @text='Form_Not_Lock1']");
        Form_Not_Lock1.click();
        //Click View
        viewForms();
        //Change answer
        //Fill up Form
        MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index = '1']");
        txtField1.clear();
        txtField1.sendKeys(randomUpdateText[rand(randomUpdateText.length-1)]);
        //Hide KeyBoard
        driver.hideKeyboard();
        //UncheckBox cb3
        MobileElement cb3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB3' and @index='3']");
        cb3.click();
        //Select rb1
        MobileElement rb1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
        rb1.click();
        //Click Cancel
        cancel();
        //need swipe because Form 1 have textbox(When inputting text on textbox it automatic scrolling up)
        swipeDown();
        //Click Form_Not_Lock2
        System.out.println("Viewing Form_Not_Lock2...");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='1' and @text='Form_Not_Lock2']");
        Form_Not_Lock2.click();
        //Click View
        viewForms();
        //Change answer
        MobileElement txtField2 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
        txtField2.sendKeys(randomUpdateText[rand(randomUpdateText.length-1)]);
        //Hide keyboard
        driver.hideKeyboard();
        //Click Cancel
        cancel();
        //need swipe because Form 2 have textbox(When inputting text on textbox it automatic scrolling up)
        swipeDown();
        //Click Form_Not_Lock3
        System.out.println("Viewing Form_Not_Lock3...");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='2' and @text='Form_Not_Lock3']");
        Form_Not_Lock3.click();
        //Click View
        viewForms();
        //Change answer
        //Unchecking cb1
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement chckBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='1' and @text='CB1']");
        chckBox1.click();
        //Click Cancel
        cancel();
        //Click Form_Not_Lock4
        System.out.println("Viewing Form_Not_Lock4...");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='3' and @text='Form_Not_Lock4']");
        Form_Not_Lock4.click();
        //Click View
        viewForms();
        //Change answer
        //Click on RB1
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement radioBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
        radioBtn1.click();
        //Click Cancel
        cancel();
        //Click Form_Not_Lock5
        System.out.println("Viewing Form_Not_Lock5...");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='4' and @text='Form_Not_Lock5']");
        Form_Not_Lock5.click();
        //Click View
        viewForms();
        //Change answer
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement txtField3 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
        txtField3.sendKeys(randomUpdateText[rand(randomUpdateText.length-1)]);
        driver.hideKeyboard();
        //Unchecking cb2 and cb3
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement chckBox2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='2' and @text='CB2']");
        chckBox2.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement chckBox3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='3' and @text='CB3']");
        chckBox3.click();
        //Click Cancel
        cancel();
        //need swipe because Form 1 have textbox(When inputting text on textbox it automatic scrolling up)
        swipeDown();
        //Click Form_Not_Lock6
        System.out.println("Viewing Form_Not_Lock6...");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock6 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='5' and @text='Form_Not_Lock6']");
        Form_Not_Lock6.click();
        //Click View
        viewForms();
        //Change answer
        //Unchecking cb2
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement cb2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='2' and @text='CB2']");
        cb2.click();
        //Click on rb2
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement radioBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB2' and @index='1']");
        radioBtn2.click();
        //Click Cancel
        cancel();
        //Click Form_Not_Lock7
        System.out.println("Viewing Form_Not_Lock7...");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock7 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='6' and @text='Form_Not_Lock7']");
        Form_Not_Lock7.click();
        //Click View
        viewForms();
        //Change answer
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement txtField4 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
        txtField4.sendKeys(randomUpdateText[rand(randomUpdateText.length-1)]);
        driver.hideKeyboard();
        //Click on rb1
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement rb1A = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
        rb1A.click();
        //Click Cancel
        cancel();
        //need swipe because Form 1 have textbox(When inputting text on textbox it automatic scrolling up)
        swipeDown();
    }
    public void updatingForms(){
        //Click Form_Not_Lock1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='0' and @text='Form_Not_Lock1']");
        Form_Not_Lock1.click();
        //Click View
        viewForms();
        //Change answer
        //Fill up Form
        MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index = '1']");
        txtField1.clear();
        txtField1.sendKeys(randomUpdateText[rand(randomUpdateText.length-1)]);
        //Hide KeyBoard
        driver.hideKeyboard();
        //UncheckBox cb3
        MobileElement cb3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB3' and @index='3']");
        cb3.click();
        //Select rb1
        MobileElement rb1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
        rb1.click();
        //Click Update
        update();
        //need swipe because Form 1 have textbox(When inputting text on textbox it automatic scrolling up)
        swipeDown();
        //Click Form_Not_Lock2
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='1' and @text='Form_Not_Lock2']");
        Form_Not_Lock2.click();
        //Click View
        viewForms();
        //Change answer
        MobileElement txtField2 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
        txtField2.sendKeys(randomUpdateText[rand(randomUpdateText.length-1)]);
        //Hide keyboard
        driver.hideKeyboard();
        //Click Update
        update();
        //need swipe because Form 2 have textbox(When inputting text on textbox it automatic scrolling up)
        swipeDown();
        //Click Form_Not_Lock3
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='2' and @text='Form_Not_Lock3']");
        Form_Not_Lock3.click();
        //Click View
        viewForms();
        //Change answer
        //Unchecking cb1
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement chckBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='1' and @text='CB1']");
        chckBox1.click();
        //Click Update
        update();
        //Click Form_Not_Lock4
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='3' and @text='Form_Not_Lock4']");
        Form_Not_Lock4.click();
        //Click View
        viewForms();
        //Change answer
        //Click on RB1
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement radioBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
        radioBtn1.click();
        //Click Update
        update();
        //Click Form_Not_Lock5
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='4' and @text='Form_Not_Lock5']");
        Form_Not_Lock5.click();
        //Click View
        viewForms();
        //Change answer
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement txtField3 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
        txtField3.sendKeys(randomUpdateText[rand(randomUpdateText.length-1)]);
        driver.hideKeyboard();
        //Unchecking cb2 and cb3
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement chckBox2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='2' and @text='CB2']");
        chckBox2.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement chckBox3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='3' and @text='CB3']");
        chckBox3.click();
        //Click Update
        update();
        //need swipe because Form 1 have textbox(When inputting text on textbox it automatic scrolling up)
        swipeDown();
        //Click Form_Not_Lock6
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock6 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='5' and @text='Form_Not_Lock6']");
        Form_Not_Lock6.click();
        //Click View
        viewForms();
        //Change answer
        //Unchecking cb2
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement cb2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='2' and @text='CB2']");
        cb2.click();
        //Click on rb2
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement radioBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB2' and @index='1']");
        radioBtn2.click();
        //Click Update
        update();
        //Click Form_Not_Lock7
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock7 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='6' and @text='Form_Not_Lock7']");
        Form_Not_Lock7.click();
        //Click View
        viewForms();
        //Change answer
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement txtField4 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
        txtField4.sendKeys(randomUpdateText[rand(randomUpdateText.length-1)]);
        driver.hideKeyboard();
        //Click on rb1
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement rb1A = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
        rb1A.click();
        //Click Update
        update();
        //need swipe because Form 1 have textbox(When inputting text on textbox it automatic scrolling up)
        swipeDown();
    }
    public void deletingForms(){
        //Click Form_Not_Lock1
        System.out.println("Viewing Form_Not_Lock1...");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Not_Lock1']");
        Form_Not_Lock1.click();
        deleteForms();
        //Click Form_Not_Lock2
        System.out.println("Viewing Form_Not_Lock2...");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Not_Lock2']");
        Form_Not_Lock2.click();
        deleteForms();
        //Click Form_Not_Lock3
        System.out.println("Viewing Form_Not_Lock3...");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Not_Lock3']");
        Form_Not_Lock3.click();
        deleteForms();
        //Click Form_Not_Lock4
        System.out.println("Viewing Form_Not_Lock4...");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Not_Lock4']");
        Form_Not_Lock4.click();
        deleteForms();
        //Click Form_Not_Lock5
        System.out.println("Viewing Form_Not_Lock5...");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Not_Lock5']");
        Form_Not_Lock5.click();
        deleteForms();
        //Click Form_Not_Lock6
        System.out.println("Viewing Form_Not_Lock6...");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock6 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Not_Lock6']");
        Form_Not_Lock6.click();
        deleteForms();
        //Click Form_Not_Lock7
        System.out.println("Viewing Form_Not_Lock7...");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement snackbar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Not_Lock7']");
        while (snackbar != null) {
            try {
                MobileElement Form_Not_Lock = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Not_Lock7']");
                Form_Not_Lock.click();
                deleteForms();
            }
            catch (NoSuchElementException e){
                MobileElement Form_Not_Lock = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Not_Lock7']");
                Form_Not_Lock.click();
                deleteForms();
                break;
            }
        }


    }
    //Todo swiping till element is visible
    public void testSwiping(){
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Lock1']");
        boolean isDisplayed1 = element1.isDisplayed();
        while(!isDisplayed1){
            try{

            }
            catch(NoSuchElementException e){
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                TouchAction touchAction = new TouchAction(driver);
                touchAction.longPress(new PointOption().withCoordinates(270, 500)).moveTo(new PointOption().withCoordinates(270, 230)).release().perform();
            }

        }
    }
    private static int rand(int bound) {
        return (int) (Math.random() * bound);
    }
}
