package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;

public class DEALS {

    AppiumDriver driver;
    String search = "Dea";
    String branch = "ALFAMART MARIKINA 5";
    String [] deal = {"Deal 1","Deal 2","Deal 3","Deal 4","Deal 5"};

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
    public void testDeals(){
         dealsLogInToVisit();
    }

    //Cases
    public void Case40(){
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        MobileElement searchBar = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'search_auto_complete_text_view') and @text='Search deals...']");
        searchBar.sendKeys(deal[rand(deal.length-1)]);
        //Click Search button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        MobileElement searchBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'search_button') and @index='1']");
        searchBtn.click();
        //Click Result
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        MobileElement resultDeal = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='0']");
        resultDeal.click();
        driver.navigate().back();
    }
    public void Case41(){
        SearchDeals();
        //Click
        for (int z=1; z<=2; z++) {
            for (int x = 0; x <= 4; x++) {
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                List<MobileElement> resultDeal = (List<MobileElement>) driver.findElementsByXPath("//android.widget.ScrollView[@index='1']" +
                        "/android.widget.LinearLayout[@index='0']" +
                        "/android.widget.LinearLayout");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                resultDeal.get(x).click();
                int w = x + 1;
                if (z==1) {
                    //Click jump to vaof
                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                    MobileElement jumpVaof = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'btn_jump_vaof') and @index='0']");
                    jumpVaof.click();
                    System.out.println("Go to Vaof");
                }
//                else if (z==2){
//                    //Click jump to baof
//                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//                    MobileElement jumpBaof = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'btn_jump_baof') and @index='1']");
//                    jumpBaof.click();
//                    System.out.println("Go to Baof");
//                }
                System.out.println("Deals " + w + " done");
                //Enter minimum quantity
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                MobileElement minimumQuan = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'txt_multiplier') and @text='Minimum quantity of deals to apply']");
                minimumQuan.sendKeys("1");
                //ClickOk
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                MobileElement clckOK = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
                clckOK.click();
                driver.navigate().back();
                SearchDeals();
            }
        }
    }



    //Functions
    public void SearchDeals(){
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
    public void dealsLogInToVisit(){
        for (int x = 0; x <=4; x++) {
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            //CLick on drawer
            MobileElement sideBarBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
            sideBarBtn.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //click arrow down
            MobileElement loginVisitBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'image_visit_dropdown') and @index = '3']");
            loginVisitBtn.click();
            //branch list
            //search branch here
            searchBranch();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            //Time to load
            List<MobileElement> logBtn = (List<MobileElement>) driver.findElementsByClassName("android.widget.RelativeLayout");
            logBtn.get(x).click();
            System.out.println(x);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            MobileElement cntBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
            cntBtn.click();
            //click on Ok
            //should have wait here atleast 20 secs
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            MobileElement cntBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1')]");
            cntBtn1.click();


//            SearchDeals();
//            Case40();
            Case41();
            //LOGOUT
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement sideBarBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
            sideBarBtn1.click();
            //Scroll down vvvv
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'edit_text_search')]");
            boolean isDisplayed1 = element1.isDisplayed();
            if (isDisplayed1) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                TouchAction touchAction = new TouchAction(driver);
                touchAction.longPress(new PointOption().withCoordinates(160, 200)).moveTo(new PointOption().withCoordinates(160, 520)).release().perform();
            }
            //Scroll ^^^^^
            System.out.println("Branch " +x+ " done!");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement logOutBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'image_visit_dropdown') and @index = '3']");
            logOutBtn.click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement logOutBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'btn_visit_logout')]");
            logOutBtn1.click();
        }
    }
    public void searchBranch(){
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        MobileElement searchBar = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_search') and @text='Search branch']");
        searchBar.sendKeys(branch);
        driver.hideKeyboard();
    }


    private static int rand(int bound) {
        return (int) (Math.random() * bound);
    }


}
