import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.*;
import io.appium.java_client.android.Connection;
import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import sun.rmi.runtime.Log;

import javax.xml.xpath.XPath;

import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;
import static org.junit.Assert.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TestClass {

    AppiumDriver driver;
    String validUser = "qa5user1@louel.com";
    String validPass = "Password1!";
    String invalidUser = "abc@louel.com";
    String invalidPass = "Password123!";
    //String expectedErrorMessage = "Username or Password might be wrong, please try again.";

    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("deviceName","Lenovo A7010a48");
        capabilities.setCapability("deviceName","HUAWEI Y6 2018");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability("platformVersion", "5.1");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("appPackage", "com.engagia.android");
        capabilities.setCapability("appActivity","com.engagia.android.activities.LoginActivity");
//        capabilities.setCapability("appActivity","com.engagia.android.activities.MainActivity");
        capabilities.setCapability("noSign", true);
        capabilities.setCapability(FULL_RESET, false);
        capabilities.setCapability(NO_RESET, true);

        driver = new AppiumDriver(new URL("http://192.168.1.33:4723/wd/hub"), capabilities);


//        File file = new File("/home/lou/Desktop/Engagia_APK_Files", "v161.08.30.2018.05.45.pm.release.apk");
//        capabilities.setCapability("app", file.getAbsolutePath());

    }


    @Test
    public void loginTest() {


        loginToVisit();

//        Scroll();

        //loginToEngagiaUsingXPATH
//        MobileElement userField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_username')]");
//        userField.sendKeys(validUser);
//        MobileElement passField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_password')]");
//        passField.sendKeys(validPass);
//        driver.hideKeyboard();
//        MobileElement agreeBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[contains(@resource-id,'chk_agreement')]");
//        agreeBtn.click();
//        MobileElement loginBtn2 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'btn_login')]");
//        loginBtn2.click();

        //fastLogin
//        MobileElement loginBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'btn_fast_login')]");
//        loginBtn1.click();

 //       WebDriverWait wait = new WebDriverWait(driver, 10); WebElement messageElement = wait.until( ExpectedConditions.presenceOfElementLocated(By.id("loginResponse")) );

//        WebDriverWait wait = new WebDriverWait(driver, 60);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/android.widget.Button[@contains(@resource-id,'button1')]")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/android.widget.TextView[@contains(@resource-id,'alertTitle')]")));

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/android.widget.FrameLayout[@contains(@index]")));
//        MobileElement closeBtn = (MobileElement) driver.findElementByXPath("/android.widget.Button[@contains(@resource-id,'button1')]");
//        closeBtn.click();


//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/android.widget.Button[@content-desc='Open drawer')]")));







//        MobileElement branchBtn = (MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[@index='0')]");
//        branchBtn.click();


        //FIND SOLUTION FOR THE LOADING SCREEN!!!!!!
//        MobileElement closeBtn = (MobileElement) (new WebDriverWait(driver, 120)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id='button1']")));
//        closeBtn.click();
//
//        MobileElement sidebarBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'')]");
//        sidebarBtn.click();
//        MobileElement sideBarBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer')]");
//        sideBarBtn.click();

        //driver.findElement(By.xpath("//*[@class='android.widget.EditText' and @bounds='[156,729][924,865]']"));
        //driver.findElementByXPath("//android.widget.LinearLayout[resource-id=""]");

//        MobileElement userField = (MobileElement) driver.findElement(By.xpath("//*[@class='android.widget.EditText' and @bounds='[156,729][924,865]']"));
        //userField.click();

        //System.out.print(driver.findElement(By.id("com.engagia.android:id/text_username")));

//        MobileElement userField = (MobileElement) (new WebDriverWait(driver,5)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.engagia.android:id/text_username")));
//        userField.sendKeys(validUser);
//        //        MobileElement userField = (MobileElement) driver.findElementByAccessibilityId("com.engagia.android:id/text_username");
//        userField.sendKeys(validUser);

//      MobileElement passField = (MobileElement) driver.findElements(By.id("com.engagia.android:id/text_password"));
        //passField.sendKeys(validPass);
        //        MobileElement agreeBtn  = (MobileElement) driver.findElements(By.id("com.engagia.android:id/chk_agreement"));
        //        MobileElement loginBtn  = (MobileElement) driver.findElements(By.id("com.engagia.android:id/btn_login"));
        //        MobileElement dismissBtn = (MobileElement) (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1")));
//        dismissBtn.click();

//        MobileElement errorMessage = (MobileElement) (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/message")));
//
//        assertEquals(errorMessage.getText(), expectedErrorMessage);
        //android:id/button1 dissmiss button
        //MobileElement dismissBtn  = (MobileElement) (new WebDriverWait(driver.findElements(By.id("android:id/button1")));

        //driver.findElement(By.id("com.engagia.android:id/text_username")).sendKeys(validUser);
//
//
//        MobileElement passField = (MobileElement) driver.findElementByAccessibilityId("com.engagia.android:id/text_password");
//        passField.sendKeys(validPass);
//
//
//        MobileElement agreeBtn  = (MobileElement) driver.findElementByAccessibilityId("com.engagia.android:id/chk_agreement");
//        agreeBtn.click();
//
//        MobileElement loginBtn  = (MobileElement) driver.findElementByAccessibilityId("com.engagia.android:id/btn_login");
//        loginBtn.click();

        //wait for the div to be invisible.
//        long timeoutInSeconds = 30;
//        new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.view.View")));
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

//        MobileElement closeBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[@resource-id='button1')]");
//        closeBtn.click();

//        MobileElement closeBtn = (MobileElement) (new WebDriverWait(driver, 120)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id='button1']")));
//        closeBtn.click();

//        MobileElement sideBarBtn = (MobileElement) (new WebDriverWait(driver, 120)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc='Open drawer']")));
//        sideBarBtn.click();


    }
    private void loginToVisit(){
        //LOOP gang 11 lang :c

        for(int i=0; i<11;i++) {

            //OpenDrawer to see log in to visit

            MobileElement sideBarBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
            sideBarBtn.click();
            MobileElement loginVisitBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'image_visit_dropdown')]");
            loginVisitBtn.click();
            //branch list
            List<MobileElement> logBtn = (List<MobileElement>) driver.findElementsByClassName("android.widget.RelativeLayout");
//            List <MobileElement> logBtn = driver.findElements(By.id("list_branches"));
            System.out.print(logBtn.size()+"");
            logBtn.get(i).click();
            //click on continue
            MobileElement cntBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
            cntBtn.click();
            //click on Ok
            //should have wait here atleast 20 secs
            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
            MobileElement cntBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
            cntBtn1.click();
            //log out branch
            MobileElement sideBarBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
            sideBarBtn1.click();
            MobileElement logOutBtn = (MobileElement) driver.findElementByXPath("//android.view.View[contains(@resource-id,'action_visit')]");
            logOutBtn.click();
            MobileElement logOutBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'btn_visit_logout')]");
            logOutBtn1.click();
//            Scroll();
//            System.out.print("Complete!1!");
        }
    }

    //todo Add turn on & off wifi/gps



//    public void turnWifi() {
//
//        set
//
//
//    }




//    @After
//    public void tearDown(){
//
//        driver.quit();
////       driver.closeApp();
//    }


}