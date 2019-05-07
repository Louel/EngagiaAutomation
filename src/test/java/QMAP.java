import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;

public class QMAP {

    AppiumDriver driver;
    AndroidDriver ADdriver;
    String search = "Quick Map";
    String[] randomText = {"zczxczxc", "12331231", "Abbbccde", "Abcde!@#", "A1B1C1"};
    String[] randomUpdateText = {"update!", "updateyyyyqqqq", "updatewwwwww", "aaaaaaaupdate", "cccupdateccc!@#", "update11111", "update222231!!!"};
    String[] location = {"Marikina", "Pasig", "Pasay", "Quezon City", "Mandaluyong", "Ortigas"};
    String[] branch = {"branchAaaaaa123!", "branchBbbbb123", "branchCccccccc!@#", "branchDddddd!@#$", "branchEeeee", "branchFffffffffff"};
    String formLockDrctry = "//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout" +
            "/android.widget.LinearLayout/android.widget.LinearLayout[1]" +
            "/android.widget.ListView/android.widget.TextView";

    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Samsung Galaxy J1 (2016)");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("appPackage", "com.engagia.android");
        capabilities.setCapability("appActivity", "com.engagia.android.activities.LoginActivity");
        capabilities.setCapability("noSign", true);
        capabilities.setCapability(FULL_RESET, false);
        capabilities.setCapability(NO_RESET, true);
//        driver = new AppiumDriver(new URL("http://192.168.1.33:4723/wd/hub"), capabilities);
//        driver = new AppiumDriver(new URL("http://192.168.0.167:4723/wd/hub"), capabilities);
        driver = new AppiumDriver(new URL("http://192.168.1.40:4723/wd/hub"), capabilities);

    }

    @Test
    public void testQMAP() {

//        Case1();
//        Case2();
//       ADdriver.toggleWifi();
//        swipingHorizontal();
        answerLockForms();
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
        //vvvvv
        Case24();
        Case25();
        Case26();
        Case27();
//        Case28();
//        Case29();
    }

    //Cases functions
    //ACCESSING QUICKMAP WHILE LOCATION SERVICES IS OFF (NO WIFI / NO DATA)
    public void Case1() {
        //LOOP 4 TIMES (STEP 10)
        for (int a = 1; a <= 13; a++) {
            //SearchQMAP();
            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
            if (a <= 4) {
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
                System.out.println("Step: " + a);
            } else if (a <= 8) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckDny = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button2')]");
                clckDny.click();
                driver.closeApp();
                //Open Engagia Again (Step 9)
                driver.launchApp();
                System.out.println("Step: " + a);
            } else if (a <= 12) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                //Click Enable/Okay
                MobileElement clckOkay = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
                clckOkay.click();
                driver.closeApp();
                //Open Engagia Again (Step 9)
                driver.launchApp();
                System.out.println("Step: " + a);
            } else if (a == 13) {
                turnOnLocation();
                System.out.println("Step: " + a);
            }
        }

    }

    //ACCESSING QUICKMAP WHILE LOCATION SERVICES IS OFF (ONLINE VIA WIFI)
    public void Case2() {
        //SearchQMAP();
//        ADdriver.toggleWifi();
//        ADdriver.setConnection(Connection.WIFI);
        //Location


    }

    //ACCESSING QUICKMAP WHILE LOCATION SERVICES IS OFF (ONLINE VIA DATA)
    public void Case3() {

    }

    //FORMS
    public void Case4() {
        System.out.println("Testing Case 4");
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

        System.out.println("Done Answering Not Lock Forms");
        //Swipe down to view forms attached
        swipeDown();
//        answerLockForms();
        //Click on all answered Form from the list
        for (int d = 1; d <= 6; d++) {
            //View then cancel
            if (d <= 2) {
                cancelingForms();
            }
            //View then Update answers
            else if (d == 3) {
                updatingForms();
            }
            //Delete form
            else if (d == 4) {
                deletingForms();
            }
            //answering forms again..
            else if (d == 5) {
                answerLockForms();
            }
//            else if(d==6){
//                answeringNotLockForms();
//            }
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

    //Magkaiba un ppindutin sa camera pag na open pag dating sa ibang device
    public void Case5() {
        System.out.println("Testing Case 5");
//        SearchQMAP();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement forms = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn') and @text='FORMS']");
        boolean isDisplayed1 = forms.isDisplayed();
//        for (int o = 1; o <=8; o++){
        while (isDisplayed1) {
            try {
                MobileElement clickImg = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id, 'qmPictureIv') and @index='1']");
                clickImg.click();
                System.out.println("Open Camera..");
                break;
            } catch (NoSuchElementException e) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                swipeUpPercentage();
                continue;
            }

        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement takeImg = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id, 'shutter') and @index='1']");
        takeImg.click();

    }

    //CLEAR
    //Checkbox Only
    public void Case6() {
        System.out.println("Testing Case 6");
//        SearchQMAP();
        //Ticking all check box
        checkBoxTick();
        //Clear
        clear();
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Cleared']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 6 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Fields Only
    public void Case7() {
        System.out.println("Testing Case 7");
        //Alisin to pag irrun na lahat ng cases v
//        SearchQMAP();
        fieldOnly();
        clear();
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Cleared']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 7 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Forms only
    public void Case8() {
        System.out.println("Testing Case 8");
//        SearchQMAP();
        answerLockForms();
        answeringNotLockForms();
        clear();
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Cleared']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 8 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Case 9 to 12 can't script camera can't click on both device
    //Image only
    public void Case9() {
        System.out.println("Testing Case 9");
        pictureOnly();
        clear();
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Cleared']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 9 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Image and Checkbox
    public void Case10() {
        System.out.println("Testing Case 10");
        //Take picture
        pictureOnly();
        //Ticking all check box
        checkBoxTick();
        clear();
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Cleared']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 10 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Image and Forms
    public void Case11() {
        System.out.println("Testing Case 11");
        //Take picture
        pictureOnly();
        answerLockForms();
        answeringNotLockForms();
        clear();
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Cleared']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 11 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Image and Fields
    public void Case12() {
        System.out.println("Testing Case 12");
        pictureOnly();
        fieldOnly();
        clear();
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Cleared']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 12 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Fields and Forms only
    public void Case13() {
        System.out.println("Testing Case 13");
        fieldOnly();
        answerLockForms();
        answeringNotLockForms();
        clear();
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Cleared']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 13 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Fields and Checkbox
    public void Case14() {
        System.out.println("Testing Case 14");
        //Ticking all check box
        checkBoxTick();
        //Click on Account Classification
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accClass = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'qmAccountClassEt') and @index='0']");
        accClass.click();
        //Click on Certain Acc Classification
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accClass1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='1']");
        accClass1.click();
        //Click on Account
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement acc = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'qmAccountEt') and @index='0']");
        acc.click();
        //Click on Certain Account
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAcc = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='1']");
        clckAcc.click();
        //Clear
        clear();
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Cleared']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 14 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Forms and Checkbox
    public void Case15() {
        System.out.println("Testing Case 15");
        //Ticking all check box
        checkBoxTick();
        //Answering forms
        answerLockForms();
        answeringNotLockForms();
        clear();
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Cleared']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 15 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Fields , Forms and Checkbox
    public void Case16() {
        System.out.println("Testing Case 16");
        //Ticking all check box
        checkBoxTick();
        //Click on Account Classification
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accClass = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'qmAccountClassEt') and @index='0']");
        accClass.click();
        //Click on Certain Acc Classification
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accClass1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='1']");
        accClass1.click();
        //Click on Account
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement acc = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'qmAccountEt') and @index='0']");
        acc.click();
        //Click on Certain Account
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAcc = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='1']");
        clckAcc.click();
        //Answering forms
        answerLockForms();
        answeringNotLockForms();
        //Clear
        clear();
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Cleared']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 16 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Image , Forms and Checkbox
    public void Case17() {
        System.out.println("Testing Case 17");
        //Take picture
        pictureOnly();
        //Ticking all check box
        checkBoxTick();
        //Answering forms
        answerLockForms();
        answeringNotLockForms();
        //Clear
        clear();
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Cleared']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 17 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Image , Forms and Fields
    public void Case18() {
        System.out.println("Testing Case 18");
        //Take picture
        pictureOnly();
        fieldOnly();
        answerLockForms();
        answeringNotLockForms();
        clear();
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Cleared']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 18 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Image , Forms , Fields and Checkbox
    public void Case19() {
        System.out.println("Testing Case 19");
        //Take Picture
        pictureOnly();
        //Ticking all check box
        checkBoxTick();
        //Click on Account Classification
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accClass = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'qmAccountClassEt') and @index='0']");
        accClass.click();
        //Click on Certain Acc Classification
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accClass1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='1']");
        accClass1.click();
        //Click on Account
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement acc = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'qmAccountEt') and @index='0']");
        acc.click();
        //Click on Certain Account
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAcc = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='1']");
        clckAcc.click();
        //Answering forms
        answerLockForms();
        answeringNotLockForms();
        //Clear
        clear();
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Cleared']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 16 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Clear only
    public void Case20() {
        System.out.println("Testing Case 20");
        clear();
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Cleared']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Case 20 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Summary Menu (No Data)
    public void Case21() {
        System.out.println("Testing Case 21");
        MobileElement summaryMenu = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'quick_mapped_location_menu') and @index = '0']");
        summaryMenu.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement noMapped = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'no_mapped_locations_tv') and @text = 'No mapped locations']");
        boolean isDisplayed1 = noMapped.isDisplayed();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'No mapped locations']");
        boolean isDisplayed2 = snackBar.isDisplayed();
        if (isDisplayed1 && isDisplayed2) {
            System.out.println("Case 21 Pass");
        } else if (!isDisplayed1 && !isDisplayed2) {
            System.out.println("Failed");
        }
        summaryMenu.click();
    }

    //Save without Checkbox
    public void Case22() {
        System.out.println("Testing Case 22");
        //Take Picture
        pictureOnly();
        fieldOnly();
        //Answering forms
        answerLockForms();
        answeringNotLockForms();
        //Save
        save();
        MobileElement message = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'message') and @index = '0']");
        boolean messageIsDisplayed = message.isDisplayed();
        if (messageIsDisplayed) {
            MobileElement clickOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1') and @text = 'OK']");
            clickOk.click();
            System.out.println("Case 22 Pass");
        } else if (!messageIsDisplayed) {
            System.out.println("Failed");
        }
        //Dapat Saved to v hindi cleared
        //Location will display
//        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Cleared']");
//        boolean isDisplayed1 =  snackBar.isDisplayed();
//        if(isDisplayed1){
//            System.out.println("Case 22 Pass");
//        }
//        else if(!isDisplayed1){
//            System.out.println("Failed");
//        }
    }

    //Save without Fields
    //test this vvvv
    public void Case23() {
        System.out.println("Testing Case 23");
        //Take Picture
        pictureOnly();
        //Ticking all check box
        checkBoxTick();
        //Answering forms
        answerLockForms();
        answeringNotLockForms();
        //Clear
        save();
        MobileElement message = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'snackbar_text') and @text='Please complete all the fields']");
        boolean isDisplayed1 = message.isDisplayed();
        if (isDisplayed1) {
            clear();
            System.out.println("Case 23 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Save without forms
    public void Case24() {
        System.out.println("Testing Case 24");
        //Take Picture
        pictureOnly();
        //Ticking all check box
        checkBoxTick();
        //Click on Account Classification
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accClass = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'qmAccountClassEt') and @index='0']");
        accClass.click();
        //Click on Certain Acc Classification
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accClass1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='1']");
        accClass1.click();
        //Click on Account
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement acc = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'qmAccountEt') and @index='0']");
        acc.click();
        //Click on Certain Account
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAcc = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='1']");
        clckAcc.click();
        //Save
        save();
        MobileElement message = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView[contains(@resource-id,'scrollView') and @index='0']");
        boolean isDisplayed1 = message.isDisplayed();
        if (isDisplayed1) {
            MobileElement messageClick = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
            messageClick.click();
            clear();
            System.out.println("Case 24 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Save without Picture
    public void Case25() {
        System.out.println("Testing Case 25");
        //Ticking all check box
        checkBoxTick();
        //Click on Account Classification
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accClass = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'qmAccountClassEt') and @index='0']");
        accClass.click();
        //Click on Certain Acc Classification
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accClass1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='1']");
        accClass1.click();
        //Click on Account
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement acc = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'qmAccountEt') and @index='0']");
        acc.click();
        //Click on Certain Account
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAcc = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='1']");
        clckAcc.click();
        //Answering forms
        answerLockForms();
        answeringNotLockForms();
        //Save
        save();
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Image is required. Please take a picture']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (isDisplayed1) {
            clear();
            System.out.println("Case 25 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Save without Fields and Image
    public void Case26() {
        System.out.println("Testing Case 26");
        //Ticking all check box
        checkBoxTick();
        //Answering forms
        answerLockForms();
        answeringNotLockForms();
        //Save
        save();
        MobileElement snackBar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'snackbar_text') and @text = 'Please complete all the fields']");
        boolean isDisplayed1 = snackBar.isDisplayed();
        if (isDisplayed1) {
            clear();
            System.out.println("Case 26 Pass");
        } else if (!isDisplayed1) {
            System.out.println("Failed");
        }
    }

    //Save
    public void Case27() {
        System.out.println("Testing Case 27");
        //Take Picture
        pictureOnly();
        //Ticking all check box
        checkBoxTick();
        //Click on Account Classification
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accClass = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'qmAccountClassEt') and @index='0']");
        accClass.click();
        //Click on Certain Acc Classification
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accClass1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='1']");
        accClass1.click();
        //Click on Account
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement acc = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'qmAccountEt') and @index='0']");
        acc.click();
        //Click on Certain Account
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAcc = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='1']");
        clckAcc.click();
        //Answering forms
        answerLockForms();
        answeringNotLockForms();
        //Save
        save();
        MobileElement message = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'message') and @index = '0']");
        boolean messageIsDisplayed = message.isDisplayed();
        if (messageIsDisplayed) {
            MobileElement clickOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1') and @text = 'OK']");
            clickOk.click();
            System.out.println("Case 27 Pass");
        } else if (!messageIsDisplayed) {
            System.out.println("Failed");
        }

    }

    //Summary Menu
    public void Case28() {
        //SearchQMAP();
        System.out.println("Testing Case 28");
        //Loop atleast 4 times
        //Click on 3 dots
        for (int a = 1; a <= 4; a++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement summMenu = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'quick_mapped_location_menu') and @index='0']");
            summMenu.click();
        }
    }

    //Mapped Location
    public void Case29() {
        System.out.println("Testing Case 29");
        //Click on 3 dots
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement summMenu = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'quick_mapped_location_menu') and @index='0']");
        summMenu.click();
        //Mapped Location is displayed
        for (int a = 1; a <= 4; a++) {
            if (a <= 2) {
                //Click on Magnifying Glass
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clickMagniGlass = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id, 'search_button') and @index='0']");
                clickMagniGlass.click();
                //Keyboard appeared and Branch Name will appear in search bar
                //Click on "X"
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clickX = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id, 'search_close_btn') and @index='1']");
                clickX.click();
            } else if (a == 3) {
                //Click on Magnifying Glass
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clickMagniGlass = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id, 'search_button') and @index='0']");
                clickMagniGlass.click();
                //Search branch
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement searchBranch = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_src_text') and @index='0']");
                searchBranch.sendKeys("Branch");
                //hide keyboard
                driver.hideKeyboard();

            }
        }


    }

    //TODO DEBUG BAKIT YUN TAKE PICTURE DI PINIPINDOT
//TODO LIPAT SA qmapTestAuto lahat ng code
    //App functions
    public void SearchQMAP() {
        //click Hamburger Menu
        MobileElement HamburgerBtn = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
        HamburgerBtn.click();
        //search van
        MobileElement searchField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'edit_text_search')]");
        searchField.sendKeys(search);
        //click search result
        MobileElement clckRes = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text_title')]");
        clckRes.click();
    }

    public void answerNotLockForms() {
        //Click Forms
        //Loop
        //Filling up form 1 and saving
        for (int a = 1; a <= 28; a++) {
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            MobileElement clckFrms1 = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[contains(@resource-id, 'fragment_container')]" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.LinearLayout[@index='0']" +
//                    "/android.widget.TextView[@text='FORMS']");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement clckFrms1 = (MobileElement) driver.findElementById("com.engagia.android:id/qmFormsBtn");
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            MobileElement quickMapTitle = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Quick Map' and @index='1']");
            boolean isDisplayed = clckFrms1.isDisplayed();
            if (isDisplayed) {
                clckFrms1.click();
            }
            //Cancel and Save
            if (a <= 3) {
                //Select Form 1
                MobileElement selFrms1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock1']");
                String formText = selFrms1.getText();
                selFrms1.click();
                //Fill up Form
                MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index = '1']");
                txtField1.sendKeys(randomText[rand(randomText.length - 1)]);
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
                System.out.println("Cancel " + formText);
            } else if (a == 4) {
                //Select Form 1
                MobileElement selFrms1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock1']");
                String formText = selFrms1.getText();
                selFrms1.click();
                //Fill up Form
                MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index = '1']");
                txtField1.sendKeys(randomText[rand(randomText.length - 1)]);
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
                System.out.println("Save " + formText);
            }
            //Form 2
            else if (a <= 7) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 1
                MobileElement selFrms2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock2']");
                String formText = selFrms2.getText();
                selFrms2.click();
                //Fill up field
                MobileElement txtField2 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField2.sendKeys(randomText[rand(randomText.length - 1)]);
                //Hide keyboard
                driver.hideKeyboard();
                //Cancel
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Cancel' and @index='0']");
                clckCancel.click();
                System.out.println("Cancel " + formText);
            } else if (a == 8) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 2
                MobileElement selFrms2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock2']");
                String formText = selFrms2.getText();
                selFrms2.click();
                //Fill up field
                MobileElement txtField2 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField2.sendKeys(randomText[rand(randomText.length - 1)]);
                //Hide keyboard
                driver.hideKeyboard();
                //Save
                MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Save' and @index='1']");
                clckSave.click();
                System.out.println("Save " + formText);
            }
            //Forms 3
            else if (a <= 11) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 3
                MobileElement selFrms3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock3']");
                String formText = selFrms3.getText();
                selFrms3.click();
                //Click on Check box
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='1' and @text='CB1']");
                chckBox1.click();
                //Cancel
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='0' and @text='Cancel']");
                clckCancel.click();
                System.out.println("Cancel " + formText);
            } else if (a == 12) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 3
                MobileElement selFrms3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock3']");
                String formText = selFrms3.getText();
                selFrms3.click();
                //Click on Check box
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement chckBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='1' and @text='CB1']");
                chckBox1.click();
                //Save
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='1' and @text='Save']");
                clckSave.click();
                System.out.println("Save " + formText);
            }
            //Forms 4
            else if (a <= 15) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 4
                MobileElement selFrms4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock4']");
                String formText = selFrms4.getText();
                selFrms4.click();
                //Click on Radio button
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
                radioBtn1.click();
                //Cancel
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='0' and @text='Cancel']");
                clckCancel.click();
                System.out.println("Cancel " + formText);
            } else if (a == 16) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 4
                MobileElement selFrms4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock4']");
                String formText = selFrms4.getText();
                selFrms4.click();
                //Click on Radio button
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement radioBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@index='0' and @text='RB1']");
                radioBtn1.click();
                //Save
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='1' and @text='Save']");
                clckSave.click();
                System.out.println("Save " + formText);
            }
            //Form 5
            else if (a <= 19) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 5
                MobileElement selFrms5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock5']");
                String formText = selFrms5.getText();
                selFrms5.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField1.sendKeys(randomText[rand(randomText.length - 1)]);
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
                System.out.println("Cancel: " + formText);


            } else if (a == 20) {
                //Select Form 5
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement selFrms5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock5']");
                String formText = selFrms5.getText();
                selFrms5.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField1.sendKeys(randomText[rand(randomText.length - 1)]);
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
                System.out.println("Save: " + formText);
            }
            //Forms 6
            else if (a <= 23) {
                //Select Form 6
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement selFrms6 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock6']");
                String formText = selFrms6.getText();
                selFrms6.click();
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
                System.out.println("Cancel " + formText);
            } else if (a == 24) {
                //Select Form 6
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement selFrms6 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock6']");
                String formText = selFrms6.getText();
                selFrms6.click();
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
                System.out.println("Save: " + formText);
            }
            //Forms 7
            else if (a <= 27) {
                //Insert Swipe
                //Swipe
//                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//                MobileElement element2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock6']");
//                boolean isDisplayed2 = element2.isDisplayed();
//                if (isDisplayed2) {
//                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//                    TouchAction touchAction = new TouchAction(driver);
//                    touchAction.longPress(new PointOption().withCoordinates(150, 730)).moveTo(new PointOption().withCoordinates(150, 670)).release().perform();
//                }
                //Select Form 7
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement selFrms7 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock7']");
                String formText = selFrms7.getText();
                selFrms7.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField1.sendKeys(randomText[rand(randomText.length - 1)]);
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
                System.out.println("Cancel " + formText);
            } else if (a == 28) {
                //Insert Swipe
                //Swipe
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//                MobileElement element2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock7']");
//                boolean isDisplayed2 = element2.isDisplayed();
//                if (isDisplayed2) {
//                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//                    TouchAction touchAction = new TouchAction(driver);
//                    touchAction.longPress(new PointOption().withCoordinates(150, 730)).moveTo(new PointOption().withCoordinates(150, 670)).release().perform();
//                }
                //Select Form 7
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement selFrms7 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock7']");
                String formText = selFrms7.getText();
                selFrms7.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField1.sendKeys(randomText[rand(randomText.length - 1)]);
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
                System.out.println("Save: " + formText);
            }

        }
    }

    public void answerLockForms() {
        //Remove search later
        SearchQMAP();
        //this Search  F O R M  L O C K  1
        formLock1();
        //CheckBox
        swipeDown11();
        MobileElement cb1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB1' and @index='1']");
        cb1.click();
        MobileElement cb2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB2' and @index='2']");
        cb2.click();
        MobileElement cb3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@text='CB3' and @index='3']");
        cb3.click();
        //Answering form 1
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index = '1']");
        txtField1.sendKeys("TRY THISS");
//        txtField1.sendKeys(randomText[rand(randomText.length - 1)]);
        //Hide KeyBoard
        driver.hideKeyboard();
        //RadioButton
        MobileElement rb1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
        rb1.click();
        System.out.println("Form 1 done answering ");
        //this Search  F O R M  L O C K  2
        formLock2();
        //Answering form 2
        swipeDown11();
        MobileElement txtField2 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
        txtField2.sendKeys(randomText[rand(randomText.length - 1)]);
        //Hide keyboard
        driver.hideKeyboard();
        System.out.println("Form 2 done answering ");
        //this Search  F O R M  L O C K  3
        formLock3();
        //Answering form 3
        //Click on Check box
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement chckBox1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='1' and @text='CB1']");
        chckBox1.click();
        System.out.println("Form 3 done answering ");
        //this Search  F O R M  L O C K  4
        formLock4();
        //Answering form 4
        //Click on Radio button
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement radioBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@index='0' and @text='RB1']");
        radioBtn1.click();
        System.out.println("Form 4 done answering ");
        //this Search  F O R M  L O C K  5
        formLock5();
        //Answering form 5
        //Enter value at text field
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement txtField3 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
        txtField3.sendKeys(randomText[rand(randomText.length - 1)]);
        driver.hideKeyboard();
        //Check boxes
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement chckBox1A = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='1' and @text='CB1']");
        chckBox1A.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement chckBox2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='2' and @text='CB2']");
        chckBox2.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement chckBox3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='3' and @text='CB3']");
        chckBox3.click();
        System.out.println("Form 5 done answering ");
        //this Search  F O R M  L O C K  6
        formLock6();
        //Answering form 6
        //Tick all checkbox
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement chckBox1B = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='1' and @text='CB1']");
        chckBox1B.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement chckBox2B = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='2' and @text='CB2']");
        chckBox2B.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement chckBox3B = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='3' and @text='CB3']");
        chckBox3B.click();
        //Click on Radio button
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement radioBtn1A = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB1' and @index='0']");
        radioBtn1A.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement radioBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB2' and @index='1']");
        radioBtn2.click();
        System.out.println("Form 6 done answering ");
        //this Search  F O R M  L O C K  7
        formLock7();
        //Answering form 7
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement txtField1A = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
        txtField1A.sendKeys(randomText[rand(randomText.length - 1)]);
        driver.hideKeyboard();
        //Click on Radio button
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement radioBtn2A = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='RB2' and @index='1']");
        radioBtn2A.click();
        System.out.println("Form 7 done answering ");
        //this Search F O R M  W/  S P E C I A L  C H A R A C T E R S
        formSpChar();
        //Answering form with Special Charactrs
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement txtField2A = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
        txtField2A.sendKeys(randomText[rand(randomText.length - 1)]);
        driver.hideKeyboard();
        //Tick all checkbox
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement chckBox1C = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='1' and @text='~!@#CheckBox#@!~']");
        chckBox1C.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement chckBox2C = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='2' and @text='~!@#CheckBox#@!~']");
        chckBox2C.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement chckBox3C = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[@index='3' and @text='~!@#CheckBox#@!~']");
        chckBox3C.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement radioBtn2B = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='~!@#RadioButton#@!~' and @index='1']");
        radioBtn2B.click();

    }

    public void answeringNotLockForms() {
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
                txtField1.sendKeys(randomText[rand(randomText.length - 1)]);
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
                System.out.println("Save " + a);
            }
            //Form 2
            else if (a == 2) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 2
                MobileElement selFrms2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock2']");
                selFrms2.click();
                //Fill up field
                MobileElement txtField2 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField2.sendKeys(randomText[rand(randomText.length - 1)]);
                //Hide keyboard
                driver.hideKeyboard();
                //Save
                MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Save' and @index='1']");
                clckSave.click();
                System.out.println("Save " + a);
            }
            //Forms 3
            else if (a == 3) {
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
                System.out.println("Save " + a);
            }
            //Forms 4
            else if (a == 4) {
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
                System.out.println("Save " + a);
            }
            //Form 5
            else if (a == 5) {
                //Select Form 5
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement selFrms5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock5']");
                selFrms5.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField1.sendKeys(randomText[rand(randomText.length - 1)]);
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
                System.out.println("Save " + a);
            }
            //Forms 6
            else if (a == 6) {
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
                System.out.println("Save " + a);
            }
            //Forms 7
            else if (a == 7) {
                //Insert Swipe
                //Swipe
//                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//                MobileElement element2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock7']");
//                boolean isDisplayed2 = element2.isDisplayed();
//                if (isDisplayed2) {
//                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//                    TouchAction touchAction = new TouchAction(driver);
//                    touchAction.longPress(new PointOption().withCoordinates(150, 730)).moveTo(new PointOption().withCoordinates(150, 670)).release().perform();
//                }
                //Select Form 7
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement selFrms7 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock7']");
                selFrms7.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField1.sendKeys(randomText[rand(randomText.length - 1)]);
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
                System.out.println("Save " + a);
            }

        }
    }

    public void swipeDown() {
        //Loop swipe 10 times to view all forms attached
        for (int c = 0; c < 10; c++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement forms = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'com.engagia.android:id/qmFormsBtn') and @text='FORMS']");
            boolean isDisplayed = forms.isDisplayed();
            if (isDisplayed) {
                Dimension dim = driver.manage().window().getSize();
                int width = dim.getWidth();
                //Para nasa gilid un pag scroll walang tatamaan textfield
                int x = (int) (width * 0.99);
                TouchAction touchAction = new TouchAction(driver);
//            touchAction.longPress(new PointOption().withCoordinates(270, 760)).moveTo(new PointOption().withCoordinates(270, 230)).release().perform();
                //try this
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                touchAction.press(new PointOption().withCoordinates(x, 770)).moveTo(new PointOption().withCoordinates(x, 200)).release().perform();
                System.out.println("Swiping down...");
            }
        }
    }

    public void viewForms() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clickView = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='0' and @text='View']");
        clickView.click();
    }

    public void deleteForms() {
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

    public void cancel() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clickCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='0' and @text='Cancel']");
        clickCancel.click();
        System.out.println("Cancel... Form");
    }

    public void update() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clickCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[@index='1' and @text='Update']");
        clickCancel.click();
        System.out.println("Updating... Form");
    }

    public void cancelingForms() {
        //Click Form_Not_Lock1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='0' and @text='Form_Not_Lock1']");
        String formText1 = Form_Not_Lock1.getText();
        System.out.println("Viewing: " + formText1);
        Form_Not_Lock1.click();
        //Click View
        viewForms();
        //Change answer
        //Fill up Form
        MobileElement txtField1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index = '1']");
        txtField1.clear();
        txtField1.sendKeys(randomUpdateText[rand(randomUpdateText.length - 1)]);
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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='1' and @text='Form_Not_Lock2']");
        String formText2 = Form_Not_Lock2.getText();
        System.out.println("Viewing: " + formText2);
        Form_Not_Lock2.click();
        //Click View
        viewForms();
        //Change answer
        MobileElement txtField2 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
        txtField2.sendKeys(randomUpdateText[rand(randomUpdateText.length - 1)]);
        //Hide keyboard
        driver.hideKeyboard();
        //Click Cancel
        cancel();
        //need swipe because Form 2 have textbox(When inputting text on textbox it automatic scrolling up)
        swipeDown();
        //Click Form_Not_Lock3
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='2' and @text='Form_Not_Lock3']");
        String formText3 = Form_Not_Lock3.getText();
        System.out.println("Viewing: " + formText3);
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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='3' and @text='Form_Not_Lock4']");
        String formText4 = Form_Not_Lock4.getText();
        System.out.println("Viewing: " + formText4);
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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='4' and @text='Form_Not_Lock5']");
        String formText5 = Form_Not_Lock5.getText();
        System.out.println("Viewing: " + formText5);
        Form_Not_Lock5.click();
        //Click View
        viewForms();
        //Change answer
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement txtField3 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
        txtField3.sendKeys(randomUpdateText[rand(randomUpdateText.length - 1)]);
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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock6 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='5' and @text='Form_Not_Lock6']");
        String formText6 = Form_Not_Lock6.getText();
        System.out.println("Viewing: " + formText6);
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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Form_Not_Lock7 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='6' and @text='Form_Not_Lock7']");
        String formText7 = Form_Not_Lock7.getText();
        System.out.println("Viewing: " + formText7);
        Form_Not_Lock7.click();
        //Click View
        viewForms();
        //Change answer
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement txtField4 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
        txtField4.sendKeys(randomUpdateText[rand(randomUpdateText.length - 1)]);
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

    public void updatingForms() {
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
        txtField1.sendKeys(randomUpdateText[rand(randomUpdateText.length - 1)]);
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
        txtField2.sendKeys(randomUpdateText[rand(randomUpdateText.length - 1)]);
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
        txtField3.sendKeys(randomUpdateText[rand(randomUpdateText.length - 1)]);
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
        txtField4.sendKeys(randomUpdateText[rand(randomUpdateText.length - 1)]);
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

    public void deletingForms() {
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
            } catch (NoSuchElementException e) {
                MobileElement Form_Not_Lock = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Not_Lock7']");
                Form_Not_Lock.click();
                deleteForms();
                break;
            }
        }


    }

    public void clear() {
        for (int z = 1; z <= 3; z++) {
            if (z <= 2) {
                //Click clear
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckClear = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmClearBtn') and @text='CLEAR']");
                clckClear.click();
                //Click cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button2') and @text='Cancel']");
                clckCancel.click();
            } else if (z == 3) {
                //Click clear
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckClear = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmClearBtn') and @text='CLEAR']");
                clckClear.click();
                //Click Ok
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1') and @text='Ok']");
                clckOk.click();
                System.out.println("Cleared");
            }
        }
    }

    public void save() {
        //Click clear
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckClear = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmSaveBtn') and @text='SAVE']");
        clckClear.click();
        System.out.println("Clicked save");
    }

    public void checkBoxTick() {
        swipeUp();
        //Tick all check boxes
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cb1 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[contains(@resource-id, 'qmCbox1') and @index='0']");
        cb1.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cb2 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[contains(@resource-id, 'qmCbox2') and @index='1']");
        cb2.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement cb3 = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[contains(@resource-id, 'qmCbox3') and @index='2']");
        cb3.click();
        System.out.println("All Checkbox are ticked");
    }

    public void fieldOnly() {
        swipeUp();
        //Click on Location Group
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement locationGroup = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'qmLocationGroupEt') and @index='0']");
        locationGroup.click();
        //Click certain Location Group
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement locationGroup1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='0']");
        locationGroup1.click();
        //Click on Location
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement locationField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'qmLocationEt') and @index='0']");
        locationField.sendKeys(location[rand(location.length - 1)]);
        //Hidekey
        driver.hideKeyboard();
        //Click on Account Classification
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accClass = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'qmAccountClassEt') and @index='0']");
        accClass.click();
        //Click on Certain Acc Classification
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement accClass1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='1']");
        accClass1.click();
        //Click on Account
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement acc = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'qmAccountEt') and @index='0']");
        acc.click();
        //Click on Certain Account
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAcc = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @index='1']");
        clckAcc.click();
        //Click on Branch
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement branchField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'qmBranchEt') and @index='0']");
        branchField.sendKeys(branch[rand(branch.length - 1)]);
        //Hidekey
        driver.hideKeyboard();
        System.out.println("Fields done...");
    }

    public void pictureOnly() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        MobileElement takeImgBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'qmTakePictureBtn') and @text='TAKE PICTURE' and @index='1']");
        MobileElement takeImgBtn = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'qmTakePictureBtn') and @index='1']");
        takeImgBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement takeImg = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'shutter') and @index='1']");
        takeImg.click();
        System.out.println("Picture Captured...");
    }

    //Debug this swiping till element is visible
//    public void formLock1(){
//
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        MobileElement forms = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn') and @text='FORMS']");
//        boolean isDisplayed1 = forms.isDisplayed();
//        while(isDisplayed1){
//            try{
//                //Try palitan ng Text and index lang
//                MobileElement form1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Lock1']");
//                form1.click();
//                System.out.println("Found it..");
//                break;
//            }
//            catch(NoSuchElementException e){
//                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//                TouchAction touchAction = new TouchAction(driver);
////                touchAction.longPress(new PointOption().withCoordinates(270, 760)).moveTo(new PointOption().withCoordinates(270, 230)).release().perform();
//                touchAction.press(new PointOption().withCoordinates(400, 760)).moveTo(new PointOption().withCoordinates(400, 230)).release().perform();
//                continue;
//            }
//
//        }
//    }
//    public void formLock2(){
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        MobileElement forms = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn') and @text='FORMS']");
//        boolean isDisplayed1 = forms.isDisplayed();
//        while(isDisplayed1){
//            try{
//                MobileElement form1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Lock2']");
//                form1.click();
//                System.out.println("Found it..");
//                break;
//            }
//            catch(NoSuchElementException e){
//                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//                TouchAction touchAction = new TouchAction(driver);
////                touchAction.longPress(new PointOption().withCoordinates(270, 760)).moveTo(new PointOption().withCoordinates(270, 230)).release().perform();
//                touchAction.press(new PointOption().withCoordinates(400, 760)).moveTo(new PointOption().withCoordinates(400, 230)).release().perform();
//                continue;
//            }
//
//        }
//    }
//    public void formLock3(){
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        MobileElement forms = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn') and @text='FORMS']");
//        boolean isDisplayed1 = forms.isDisplayed();
//        while(isDisplayed1){
//            try{
//                MobileElement form1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Lock3']");
//                form1.click();
//                System.out.println("Found it..");
//                break;
//            }
//            catch(NoSuchElementException e){
//                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//                TouchAction touchAction = new TouchAction(driver);
////                touchAction.longPress(new PointOption().withCoordinates(270, 760)).moveTo(new PointOption().withCoordinates(270, 230)).release().perform();
//                touchAction.press(new PointOption().withCoordinates(400, 760)).moveTo(new PointOption().withCoordinates(400, 230)).release().perform();
//                continue;
//            }
//
//        }
//    }
//    public void formLock4(){
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        MobileElement forms = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn') and @text='FORMS']");
//        boolean isDisplayed1 = forms.isDisplayed();
//        while(isDisplayed1){
//            try{
//                MobileElement form1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Lock4']");
//                form1.click();
//                System.out.println("Found it..");
//                break;
//            }
//            catch(NoSuchElementException e){
//                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//                TouchAction touchAction = new TouchAction(driver);
////                touchAction.longPress(new PointOption().withCoordinates(270, 760)).moveTo(new PointOption().withCoordinates(270, 230)).release().perform();
//                touchAction.press(new PointOption().withCoordinates(400, 760)).moveTo(new PointOption().withCoordinates(400, 230)).release().perform();
//                continue;
//            }
//
//        }
//    }
//    public void formLock5(){
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        MobileElement forms = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn') and @text='FORMS']");
//        boolean isDisplayed1 = forms.isDisplayed();
//        while(isDisplayed1){
//            try{
//                MobileElement form1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Lock5']");
//                form1.click();
//                System.out.println("Found it..");
//                break;
//            }
//            catch(NoSuchElementException e){
//                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//                TouchAction touchAction = new TouchAction(driver);
////                touchAction.longPress(new PointOption().withCoordinates(270, 760)).moveTo(new PointOption().withCoordinates(270, 230)).release().perform();
//                touchAction.press(new PointOption().withCoordinates(400, 760)).moveTo(new PointOption().withCoordinates(400, 230)).release().perform();
//                continue;
//            }
//
//        }
//    }
//    public void formLock6(){
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        MobileElement forms = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn') and @text='FORMS']");
//        boolean isDisplayed1 = forms.isDisplayed();
//        while(isDisplayed1){
//            try{
//                MobileElement form1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Lock6']");
//                form1.click();
//                System.out.println("Found it..");
//                break;
//            }
//            catch(NoSuchElementException e){
//                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//                TouchAction touchAction = new TouchAction(driver);
////                touchAction.longPress(new PointOption().withCoordinates(270, 760)).moveTo(new PointOption().withCoordinates(270, 230)).release().perform();
//                touchAction.press(new PointOption().withCoordinates(400, 760)).moveTo(new PointOption().withCoordinates(400, 230)).release().perform();
//                continue;
//            }
//
//        }
//    }
//    public void formLock7(){
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        MobileElement forms = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn') and @text='FORMS']");
//        boolean isDisplayed1 = forms.isDisplayed();
//        while(isDisplayed1){
//            try{
//                MobileElement form1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Lock7']");
//                form1.click();
//                System.out.println("Found it..");
//                break;
//            }
//            catch(NoSuchElementException e){
//                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//                TouchAction touchAction = new TouchAction(driver);
////                touchAction.longPress(new PointOption().withCoordinates(270, 760)).moveTo(new PointOption().withCoordinates(270, 230)).release().perform();
//                touchAction.press(new PointOption().withCoordinates(400, 760)).moveTo(new PointOption().withCoordinates(400, 230)).release().perform();
//                continue;
//            }
//
//        }
//    }
//    public void formSpChar(){
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        MobileElement forms = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn') and @text='FORMS']");
//        boolean isDisplayed1 = forms.isDisplayed();
//        while(isDisplayed1){
//            try{
//                MobileElement form1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='~!@#FORM#@!~']");
//                form1.click();
//                System.out.println("Found it..");
//                break;
//            }
//            catch(NoSuchElementException e){
//                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//                TouchAction touchAction = new TouchAction(driver);
////                touchAction.longPress(new PointOption().withCoordinates(270, 760)).moveTo(new PointOption().withCoordinates(270, 230)).release().perform();
//                touchAction.press(new PointOption().withCoordinates(400, 760)).moveTo(new PointOption().withCoordinates(400, 230)).release().perform();
//                continue;
//            }
//
//        }
//    }

    public void formLock1() {
        swipeDown();
        //Try palitan ng Text and index lang
//        List<MobileElement> logBtn = (List<MobileElement>) driver.findElementsByClassName("android.widget.ListView");
//        logBtn.get(0).click();
//        MobileElement form1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='0' and @text='Form_Lock1']");
//        form1.click();
//        MobileElement form1 = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView[contains(@resource-id, 'quick_map_scroll_view')]" +
//                "/android.widget.LinearLayout[@index='0']" +
//                "/android.widget.LinearLayout[@index='2']" +
//                "/android.widget.LinearLayout[@index='0']" +
//                "/android.widget.ListView[contains(@resource-id, 'qmRequiredFormsLv')]"+
//                "/android.widget.TextView[@index='0' and @text='Form_Lock1']");
        MobileElement form1 = (MobileElement) driver.findElementByXPath(formLockDrctry + "[1]");
        String formText = form1.getText();
        System.out.println("Found: " + formText);
        form1.click();
//        driver.findElementById("android:id/text1").findElement(By.xpath(formLockDrctry+"[2]")).click();

//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//            driver.findElementById("android:id/text1");

        ////        driver.findElementByName("Form_Lock1").click();
//        driver.findElement(By.name("Form_Lock1")).click();
//        MobileElement form1 = (MobileElement) driver.findElement(By.name("Form_Lock1"));
//        form1.click();
//        MobileElement form1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Form_Lock1']");
//        form1.click();


    }

    public void formLock2() {
        swipeDown();
        MobileElement form2 = (MobileElement) driver.findElementByXPath(formLockDrctry + "[2]");
        String formText = form2.getText();
        System.out.println("Found: " + formText);
        form2.click();
    }

    public void formLock3() {
        swipeDown();
//        MobileElement form3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='2' and @text='Form_Lock3']");
//        form3.click();
        MobileElement form3 = (MobileElement) driver.findElementByXPath(formLockDrctry + "[3]");
        String formText = form3.getText();
        System.out.println("Found: " + formText);
        form3.click();
    }

    public void formLock4() {
        swipeDown();
//        MobileElement form4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='3' and @text='Form_Lock4']");
//        form4.click();
        MobileElement form4 = (MobileElement) driver.findElementByXPath(formLockDrctry + "[4]");
        String formText = form4.getText();
        System.out.println("Found: " + formText);
        form4.click();
    }

    public void formLock5() {
        swipeDown();
//        MobileElement form5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='4' and @text='Form_Lock5']");
//        form5.click();
        MobileElement form5 = (MobileElement) driver.findElementByXPath(formLockDrctry + "[5]");
        String formText = form5.getText();
        System.out.println("Found: " + formText);
        form5.click();
    }

    public void formLock6() {
        swipeDown();
//        MobileElement form6 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='5' and @text='Form_Lock6']");
//        form6.click();
        MobileElement form6 = (MobileElement) driver.findElementByXPath(formLockDrctry + "[6]");
        String formText = form6.getText();
        System.out.println("Found: " + formText);
        form6.click();
    }

    public void formLock7() {
        swipeDown();
//        MobileElement form7 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='6' and @text='Form_Lock7']");
//        form7.click();
        MobileElement form7 = (MobileElement) driver.findElementByXPath(formLockDrctry + "[7]");
        String formText = form7.getText();
        System.out.println("Found: " + formText);
        form7.click();
    }

    public void formSpChar() {
        swipeDown();
//        MobileElement formSp = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='7' and @text='~!@#FORM#@!~']");
//        formSp.click();
        MobileElement formSp = (MobileElement) driver.findElementByXPath(formLockDrctry + "[8]");
        String formText = formSp.getText();
        System.out.println("Found: " + formText);
        formSp.click();
    }

    public void swipeUpPercentage() {
        Dimension dim = driver.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
//        int x = 400;
        //Para nasa gilid un pag scroll walang tatamaan textfield
        int x = (int) (width * 0.99);
        int top_y = (int) (height * 0.30);
        int bottom_y = (int) (height * 0.75);

        System.out.println("Coordinates: " + top_y + " " + bottom_y);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(new PointOption().withCoordinates(x, bottom_y)).moveTo(new PointOption().withCoordinates(x, top_y)).release().perform();
    }

    public void swipeUp() {
        //Loop swipe 10 times to view all forms attached
        for (int c = 0; c < 10; c++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement forms = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'com.engagia.android:id/qmFormsBtn') and @text='FORMS']");
            boolean isDisplayed = forms.isDisplayed();
            if (isDisplayed) {
                Dimension dim = driver.manage().window().getSize();
                int width = dim.getWidth();
                int height = dim.getHeight();
                //Para nasa gilid un pag scroll walang tatamaan textfield
                int x = (int) (width * 0.99);
                int y1 = (int) (height * 0.25);
                int y2 = (int) (height * 0.99);
                TouchAction touchAction = new TouchAction(driver);
//            touchAction.longPress(new PointOption().withCoordinates(270, 760)).moveTo(new PointOption().withCoordinates(270, 230)).release().perform();
                //try this
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                touchAction.press(new PointOption().withCoordinates(x, y1)).moveTo(new PointOption().withCoordinates(x, y2)).release().perform();
                System.out.println("UP...");
            }
        }
    }

    private static int rand(int bound) {
        return (int) (Math.random() * bound);
    }

    public void turnOnLocation() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckOkay = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        clckOkay.click();
        //Turn on location
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckOn = (MobileElement) driver.findElementByXPath("//android.widget.Switch[contains(@resource-id, 'switch_widget')]");
        clckOn.click();
        //Agree
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement agreeBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        agreeBtn.click();
        //Back
        driver.navigate().back();
    }

    private void swipeDown11() {
        Dimension dim = driver.manage().window().getSize();
        int width = dim.getWidth();
        int height = dim.getHeight();
        int x = (int) (width * 0.98);
        int y1 = (int) (height * 0.50);
        int y2 = (int) (height * 0.10);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement Scroll = (MobileElement) driver.findElementById("com.engagia.android:id/qmClearBtn");
        boolean element1Displayed = Scroll.isDisplayed();
        if (element1Displayed) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.longPress(new PointOption().withCoordinates(x, y1)).moveTo(new PointOption().withCoordinates(x, y2)).release().perform();
        }
    }
}