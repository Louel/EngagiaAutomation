package test.qmapTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.annotations.Test;
import test.BaseTest;

import java.util.concurrent.TimeUnit;

public class qmapTestAuto extends BaseTest {

    String search = "Qui";

    @Test
    public void testQMAP(){
//        Case1();
        Case4();

    }
    //todo lagay ibang case
    //todo this only if location is off
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
                MobileElement clckOkay = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
                clckOkay.click();
                driver.closeApp();
                //Open Engagia Again (Step 9)
                driver.launchApp();
                System.out.println("Step: "+a);
            }
        }

    }
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
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn')]");
        boolean isDisplayed = element1.isDisplayed();
        while(!isDisplayed){
            TouchAction touchAction = new TouchAction(driver);
            touchAction.longPress(new PointOption().withCoordinates(50, 480)).moveTo(new PointOption().withCoordinates(350, 150)).release().perform();
        }

        //Filling up form 1 and saving
        for (int a = 1; a <= 8; a++) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            MobileElement clckFrms1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'qmFormsBtn')]");
            clckFrms1.click();
            //Save and Cancel
            if (a <=3) {
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
                MobileElement cancelBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Cancel' and @index='0']");
                cancelBtn1.click();
                System.out.println("cancel " +a);
            }
            else if (a==4){
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
                MobileElement saveBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Save' and @index='1']");
                saveBtn1.click();
                System.out.println("save " +a);
            }
            //Form 2
            else if (a<=7){
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
                System.out.println("cancel " +a);
            }
            else if (a==8){
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //Select Form 1
                MobileElement selFrms2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Form_Not_Lock2']");
                selFrms2.click();
                //Fill up field
                MobileElement txtField2 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
                txtField2.sendKeys("Def456!@#");
                //Hide keyboard
                driver.hideKeyboard();
                //Save
                MobileElement saveBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='Save' and @index='1']");
                saveBtn2.click();
                System.out.println("save " +a);
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
    public void turnOn(){
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
    private static int rand(int bound) {
        return (int) (Math.random() * bound);
    }

}
