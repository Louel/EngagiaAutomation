import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class FDC {
    String search = "Field Data Cap";
    AppiumDriver driver;
    String [] randomText = {"zczxczxc","12331231","Abbbccde","Abcde!@#","1a2b3c","A1B1C1"};
//    public TouchAction touchAction = new TouchAction(driver);

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
    public void testFDC(){

//        Case1();
//        Case3();
//        Case5();
//        Case7();
        Case11();

    }
    //Case functions
    //ACCESSING FIELD DATA CAPTURE WHILE LOCATION SERVICES IS OFF
    public void Case1(){
        SearcFDC();
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
        SearcFDC();
    }
    //TAKE PICTURE WHILE LOCATION SERVICES IS OFF
    public void Case3(){
        SearcFDC();
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
            //branch list
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
        SearcFDC();
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
            //branch list
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
    //ACCOUNT / BRANCH  WHILE LOCATION SERVICES IS OFF (Need to log in to visit)
    public void Case9(){

    }
    //ACCOUNT / BRANCH  WHILE LOCATION SERVICES IS ON (Need to log in to visit)
    public void Case10(){

    }
    //PRODUCT GROUP  WHILE LOCATION SERVICES IS OFF
    public void Case11(){
        SearcFDC();
        for(int z = 1; z <=3; z++) {
            //Click Product Group
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement clckProdGrp = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etProdGroup') and @index='0']");
            clckProdGrp.click();
            //List of product groups
            List<MobileElement> selectAccBranch = (List<MobileElement>) driver.findElementsByClassName("android.widget.CheckedTextView");
            selectAccBranch.get(0).click();
            selectAccBranch.get(1).click();
            selectAccBranch.get(2).click();
            //Press ok
            MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Ok']");
            clckOk.click();
        }
        MobileElement clckProdGrp = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'etProdGroup') and @index='0']");
        clckProdGrp.click();
        holdThis();


    }




    //FUNCTIONS
    public void pictureOnly(){
//        wait.until(ExpectedConditions.visibilityOf(clckTakePic));
        openCamera();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement takeImg = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'shutter') and @index='1']");
        takeImg.click();
        System.out.println("Picture Captured...");
        //Condition where if snackbar is displayed Case 3 pass
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
    public void SearcFDC(){
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
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(ProdGrp)).withDuration(Duration.ofMillis(10000))).release().perform();

    }
    private static int rand(int bound) {
        return (int) (Math.random() * bound);
    }
}
