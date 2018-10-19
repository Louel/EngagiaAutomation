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
        Case4();

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
                System.out.println(a);
            }
            else if (a <= 8){
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckDny = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button2')]");
                clckDny.click();
                driver.closeApp();
                //Open Engagia Again (Step 9)
                driver.launchApp();
                System.out.println(a);
            }
            else if (a <= 12){
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckDny = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
                clckDny.click();
                driver.closeApp();
                //Open Engagia Again (Step 9)
                driver.launchApp();
                System.out.println(a);
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
        //SCROLL Or SWIPE
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
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn')]");
        boolean isDisplayed = element1.isDisplayed();
        while(!isDisplayed){
            TouchAction touchAction = new TouchAction(driver);
            touchAction.longPress(new PointOption().withCoordinates(50, 480)).moveTo(new PointOption().withCoordinates(350, 150)).release().perform();
        }
//        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id, 'qmPictureIv') and @index = '1']");
//        boolean isDisplayed = element1.isDisplayed();
//        if (!isDisplayed) {
//            TouchAction touchAction = new TouchAction(driver);
//            touchAction.longPress(new PointOption().withCoordinates(250, 600)).moveTo(new PointOption().withCoordinates(250, 300)).release().perform();
//        }
        //Click Forms
        //CLick Form
        //Loop
        //Filling up form 1 and saving
        for (int a = 1; a <= 8; a++) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            MobileElement clckFrms1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn')]");
            clckFrms1.click();
            //Select Form 1
            MobileElement selFrms1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock1']");
            selFrms1.click();
            //Fill up Form
            MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index = '1']");
            txtField1.sendKeys("Abc123!@#");
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
            if (a <=3) {
                //Save and Cancel
                MobileElement cancelBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Cancel' and @index='0']");
                cancelBtn1.click();
            }
            else if (a==4){
                MobileElement saveBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Save' and @index='1']");
                saveBtn1.click();
            }
            //Form 2
            else if (a<=7){
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckFrms2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn')]");
                clckFrms2.click();
                //Select Form 1
                MobileElement selFrms2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock2']");
                selFrms2.click();
                //Fill up field
                MobileElement txtField2 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField2.sendKeys("Def456!@#");
                //Hide keyboard
                driver.hideKeyboard();
                //Cancel
                MobileElement cancelBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Cancel' and @index='0']");
                cancelBtn2.click();
            }
            else if (a==8){
                //Save
                MobileElement saveBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Save' and @index='1']");
                saveBtn2.click();
            }
        }
        //Update Forms
        for (int b = 1; b < 4; b++) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            MobileElement clckFrms = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn')]");
            clckFrms.click();
            //Select Form 1
            MobileElement selFrms1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock1']");
            selFrms1.click();
            //Fill up Form
            MobileElement txtField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index = '1']");
            txtField.sendKeys("123123Abcde!@#");
            //Hide KeyBoard
            driver.hideKeyboard();
            //CheckBox
            MobileElement cb1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB1' and @index='1']");
            cb1.click();
            MobileElement cb2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB2' and @index='2']");
            cb2.click();
//            MobileElement cb3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB3' and @index='3']");
//            cb3.click();
            //RadioButton
            MobileElement rb3 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB3' and @index='2']");
            rb3.click();
            MobileElement rb1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
            rb1.click();
            MobileElement rb2 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB2' and @index='1']");
            rb2.click();

            if (b <=3) {
                //Save and Cancel
                MobileElement cancelBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Cancel' and @index='0']");
                cancelBtn.click();
            }
            else if (b==4){
                MobileElement saveBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Update' and @index='1']");
                saveBtn.click();
            }
        }
    }

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

}
