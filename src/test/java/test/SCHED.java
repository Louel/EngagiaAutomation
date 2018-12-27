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

public class SCHED {

    AppiumDriver driver;
    String search = "Sche";
    String brnchName [] = {"Alfamart MarikiNa 1" , "Alfamart marikIna 2" , "Alfamart marikina 3"};
    String wrongBrnchName [] = {"125 MarikiNa 1" , "Alfamart asdadas 2" , "asda adasdas 3"};
    String brnchCode [] = {"MARACCGCODE001" , "MARAccgCODE001" , "MaraCCGCODE001"};
    String wrongBrnchCode [] = {"MARACCGCODE001211" , "21321321321" , "asdadaAS213"};
    String accName [] = {"ALfa marT" , "Alfa mart" , "ALFA MART"};
    String wrongAccName [] = {"AALLFFAA MMAARRTT" , "MART ALFA" , "TRAM AFLA"};
    String accCode [] = {"MARACC0001" , "MARACC0002" , "MARACC0003"};
    String wrongAccCode [] = {"AALLFFAA MMAARRTT" , "MART ALFA" , "TRAM AFLA"};
    String location [] = {"Marikina" , "MariKINA" , "MARikINA"};
    String wrongLocation [] = {"13211654" , "A252521" , "!@#$%^&"};

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
    public void testNotesAndTask(){
        SearcSchedule();
        Case4();
        Case5();
        Case6();
        Case7();
        Case10();
        Case11();
        Case12();
        Case13();
        Case14();
        Case16();
        Case17();
        Case18();
    }
    //Cases
    //Check Accessing Schedule
    public void Case1(){
        SearcSchedule();
        //Loop
        //Navigate Home and Relaunching Engagia step (Step 6 and 7)
        driver.launchApp();
        //Close app (Step 8)
        driver.closeApp();
        //Open Engagia Again (Step 9)
        driver.launchApp();
        System.out.println("Case 1 Done");
    }
    //Check Schedule "List"
    public void Case2(){

    }
    //Check Schedule "Calendar"
    public void Case3(){

    }
    //Check Schedule "Select View - Month View"
    public void Case4(){
        //Click arrow to view month and agenda
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckArrowDown = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id, 'schedules_main_spinner')]");
        clckArrowDown.click();
        //Select month
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMonth = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Month']");
        clckMonth.click();
        clickLeftArrow();
        clickRightArrow();

    }
    //Check Schedule "Select View - Agenda View"
    public void Case5(){
        //Click arrow to view month and agenda
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckArrowDown = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id, 'schedules_main_spinner')]");
        clckArrowDown.click();
        //Select agenda
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMonth = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'text1') and @text='Agenda']");
        clckMonth.click();
        clickLeftArrow();
        clickRightArrow();
    }
    //Check Schedule "Add Branch Schedule Request"
    public void Case6(){
        for(int z = 1; z<=2; z++){
            if(z==1) {
                addBranchSchedReq();
                //Click yes
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckYes = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1') and @text='YES']");
                clckYes.click();
                //Click close
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckClose = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1') and @text='Close']");
                clckClose.click();
                System.out.println("Uploaded on ems");
            }
            else if(z==2){
                SearcSchedule();
                addBranchSchedReq();
                //Click no
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckNo = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button2') and @text='NO']");
                clckNo.click();
                System.out.println("Not uploaded on ems");
            }
        }
    }
    //Check Schedule "View Schedule Requests"
    public void Case7(){
        //Click on 3 dots or Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMenu = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls')]");
        clckMenu.click();
        //Click add branch sched
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckViewSched = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='View schedule requests']");
        clckViewSched.click();
        //Long press
        for(int z = 1; z<=3; z++) {
            TouchAction touchAction = new TouchAction(driver);
            MobileElement schedReq = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'list_schedule_requests_description')]");
            int x = schedReq.getLocation().getX();
            int y = schedReq.getLocation().getY();
            touchAction.longPress(new PointOption().withCoordinates(x, y)).release().perform();
            if(z<=2){
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button2') and @text='Cancel']");
                clckCancel.click();
            }
            else if(z==3){
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1') and @text='Ok']");
                clckOk.click();
            }
        }
        driver.navigate().back();

    }
    //Check Schedule "Request for Reschedule" need interaction with ems
    public void Case8(){
//        SearcSchedule(); //remove this later
        //Click on 3 dots or Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMenu = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls')]");
        clckMenu.click();
        //Click add branch sched
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckReqSched = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Request for reschedule']");
        clckReqSched.click();
    }
    //Check Schedule "Request for Delete Schedule" need interaction with ems
    public void Case9(){
        //Click on 3 dots or Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMenu = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls')]");
        clckMenu.click();
        //Click add branch sched
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckDelSched = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Request for delete schedule']");
        clckDelSched.click();
    }
    //Check Select Branch (Search by "Branch Name")
    public void Case10(){
        //Click on 3 dots or Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMenu = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls')]");
        clckMenu.click();
        //Click add branch sched
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAddBranch = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Add branch schedule request']");
        clckAddBranch.click();
        //Click branch menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBranchMenu = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'txtSelectAssignedBranch')]");
        clckBranchMenu.click();
        searchByBranchName();
        //Back
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBack = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        clckBack.click();
        clckBack.click();
        System.out.println("Case 10 Done");
    }
    //Check Select Branch (Search by "Branch Code")
    public void Case11(){
        //Click on 3 dots or Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMenu = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls')]");
        clckMenu.click();
        //Click add branch sched
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAddBranch = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Add branch schedule request']");
        clckAddBranch.click();
        //Click branch menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBranchMenu = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'txtSelectAssignedBranch')]");
        clckBranchMenu.click();
        searchByBranchCode();

        //Back
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBack = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        clckBack.click();
        clckBack.click();
        System.out.println("Case 11 Done");
    }
    //Check Select Branch (Search by "Account Name")
    public void Case12(){
        //Click on 3 dots or Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMenu = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls')]");
        clckMenu.click();
        //Click add branch sched
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAddBranch = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Add branch schedule request']");
        clckAddBranch.click();
        //Click branch menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBranchMenu = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'txtSelectAssignedBranch')]");
        clckBranchMenu.click();
        searchByAccName();
        //Back
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBack = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        clckBack.click();
        clckBack.click();
        System.out.println("Case 12 Done");
    }
    //Check Select Branch (Search by "Account Code")
    public void Case13(){
        //Click on 3 dots or Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMenu = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls')]");
        clckMenu.click();
        //Click add branch sched
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAddBranch = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Add branch schedule request']");
        clckAddBranch.click();
        //Click branch menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBranchMenu = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'txtSelectAssignedBranch')]");
        clckBranchMenu.click();
        searchByAccCode();
        //Back
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBack = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        clckBack.click();
        clckBack.click();
        System.out.println("Case 13 Done");
    }
    //Check Select Branch (Search by "Location")
    public void Case14(){
        //Click on 3 dots or Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMenu = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls')]");
        clckMenu.click();
        //Click add branch sched
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAddBranch = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Add branch schedule request']");
        clckAddBranch.click();
        //Click branch menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBranchMenu = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'txtSelectAssignedBranch')]");
        clckBranchMenu.click();
        searchByLocation();
        //Search specific branch
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBranchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
        searchBranchName.sendKeys(location[rand(location.length-1)]);
        //Click on magnifying glass
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        //Type a word that is not in the search criteria
        searchBranchName.sendKeys(wrongLocation[rand(wrongLocation.length-1)]);
        clckSearch.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        clckOk.click();
        //Back
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBack = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        clckBack.click();
        clckBack.click();
        System.out.println("Case 14 Done");
    }
    //Check Select Branch (Search by "Scheduled Branch Date") magkaibang calendarf???
    public void Case15(){
        //Click on 3 dots or Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMenu = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls')]");
        clckMenu.click();
        //Click add branch sched
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAddBranch = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Add branch schedule request']");
        clckAddBranch.click();
        //Click branch menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBranchMenu = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'txtSelectAssignedBranch')]");
        clckBranchMenu.click();
        searchByLocation();

        //Back
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBack = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        clckBack.click();
        clckBack.click();
        System.out.println("Case 12 Done");
    }
    //Check Select Branch (Filter by "Selected Branches")
    public void Case16(){
        //Click on 3 dots or Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMenu = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls')]");
        clckMenu.click();
        //Click add branch sched
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAddBranch = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Add branch schedule request']");
        clckAddBranch.click();
        //Click branch menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBranchMenu = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'txtSelectAssignedBranch')]");
        clckBranchMenu.click();
        //Search specific branch
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBranchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
        searchBranchName.sendKeys("Alfamart MarikiNa 1");
        //Click on magnifying glass
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        //Click on certain branch to add
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement branchCheckBox = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']/" +
                "android.widget.LinearLayout[@index=2]/" +
                "android.widget.CheckBox[@index='0']");
        branchCheckBox.click();
        searchBranchName.sendKeys("Alfamart MarikiNa 2");
        clckSearch.click();
        branchCheckBox.click();
        searchBranchName.sendKeys("Alfamart MarikiNa 3");
        clckSearch.click();
        branchCheckBox.click();

        for(int z=1; z<=5; z++) {
            filterBySelectedBrnch();
            if(z==1){
                searchByBranchName();
            }
            else if(z==2){
                searchByBranchCode();
            }
            else if(z==3){
                searchByAccName();
            }
            else if(z==4){
                searchByAccCode();
            }
            else if(z==5){
//                searchByLocation();
                //mali un sinesearch
            }
//            else if(z==6){
//                searchBySchedBrnchDate();
//            }
        }
        //Back
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBack = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        clckBack.click();
        clckBack.click();
        System.out.println("Case 16 Done");
    }
    //Check Select Branch (Filter by "Not Selected Branches")
    public void Case17(){
        //Click on 3 dots or Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMenu = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls')]");
        clckMenu.click();
        //Click add branch sched
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAddBranch = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Add branch schedule request']");
        clckAddBranch.click();
        //Click branch menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBranchMenu = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'txtSelectAssignedBranch')]");
        clckBranchMenu.click();
        for(int z=1; z<=5; z++) {
            filterByNotSelectedBrnch();
            if(z==1){
                searchByBranchName();
            }
            else if(z==2){
                searchByBranchCode();
            }
            else if(z==3){
                searchByAccName();
            }
            else if(z==4){
                searchByAccCode();
            }
            else if(z==5){
                searchByLocation();
            }
//            else if(z==6){
//                searchBySchedBrnchDate();
//            }
        }
        //Back
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBack = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        clckBack.click();
        clckBack.click();
        System.out.println("Case 17 Done");
    }
    //Check Select Branch (Filter by "No Filter")
    public void Case18(){
        //Click on 3 dots or Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMenu = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls')]");
        clckMenu.click();
        //Click add branch sched
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAddBranch = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Add branch schedule request']");
        clckAddBranch.click();
        //Click branch menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBranchMenu = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'txtSelectAssignedBranch')]");
        clckBranchMenu.click();
        for(int z=1; z<=5; z++) {
            filterByNoFilter();
            if(z==1){
                searchByBranchName();
            }
            else if(z==2){
                searchByBranchCode();
            }
            else if(z==3){
                searchByAccName();
            }
            else if(z==4){
                searchByAccCode();
            }
            else if(z==5){
                searchByLocation();
            }
//            else if(z==6){
//                searchBySchedBrnchDate();
//            }
        }
        System.out.println("Case 18 Done");
    }

    //Functions
    public void SearcSchedule(){
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
    public void clickLeftArrow(){
        //Click left arrow
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckArrowLeft = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='<' and @index='0']");
        clckArrowLeft.click();
    }
    public void clickRightArrow(){
        //Click right arrow
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckArrowRight = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='>' and @index='2']");
        clckArrowRight.click();
    }
    private void addBranchSchedReq(){
        //Click on 3 dots or Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMenu = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'action_function_controls')]");
        clckMenu.click();
        //Click add branch sched
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAddBranch = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title') and @text='Add branch schedule request']");
        clckAddBranch.click();
        //Click branch menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBranchMenu = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'txtSelectAssignedBranch')]");
        clckBranchMenu.click();
        //Search specific branch
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBranchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
        searchBranchName.sendKeys("ALFAMART MARIKINA 11");
        //Click on magnifying glass
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        //Click on certain branch to add
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement branchCheckBox = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']/" +
                "android.widget.LinearLayout[@index=2]/" +
                "android.widget.CheckBox[@index='0']");
        branchCheckBox.click();
        //Click Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMenuToCont = (MobileElement) driver.findElementByXPath("//android.support.v7.widget.LinearLayoutCompat[@index='2']");
        clckMenuToCont.click();
        //Click Continue
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckCont = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'title')]");
        clckCont.click();
        //Check Checkbox
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckCheckBox = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[contains(@resource-id, 'schedules_add_schedule_request_is_so_generating')]");
        clckCheckBox.click();
        clckCheckBox.click();
        //Select Date
        MobileElement yearDownBtn = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='2']"+
                "/android.widget.Button[@index = '1']");
        yearDownBtn.click();
        MobileElement monthDownBtn = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='0']"+
                "/android.widget.Button[@index = '2']");
        monthDownBtn.click();
        MobileElement dayDownBtn = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='1']"+
                "/android.widget.Button[@index = '2']");
        dayDownBtn.click();
        //Swipe Down
        swipeDown();
        //Click one time event
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckOneTime = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[contains(@resource-id, 'schedules_add_schedule_request_repeat_0')]");
        clckOneTime.click();
        //Click Daily
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckDaily = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='Daily']");
        clckDaily.click();
        //Select Date
        MobileElement monthDownBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='0']"+
                "/android.widget.Button[@index = '2']");
        monthDownBtn1.click();
        MobileElement dayDownBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='1']"+
                "/android.widget.Button[@index = '2']");
        dayDownBtn1.click();
        MobileElement yearDownBtn1 = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='2']"+
                "/android.widget.Button[@index = '2']");
        yearDownBtn1.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'custom_date_picker_spinner_mode_ok_btn')]");
        clckOk.click();
        //Every weekday
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckEveryWeekday = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@text='Every weekday (Mon-Fri)' and @index='2']");
        clckEveryWeekday.click();
        monthDownBtn1.click();
        dayDownBtn1.click();
        yearDownBtn1.click();
        clckOk.click();
        //Weekly
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckWeekly = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[contains(@resource-id, 'schedules_add_schedule_request_repeat_3')]");
        clckWeekly.click();
        monthDownBtn1.click();
        dayDownBtn1.click();
        yearDownBtn1.click();
        clckOk.click();
        //Monthly
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMonthly = (MobileElement) driver.findElementByXPath("//android.widget.RadioButton[@index='4']");
        clckMonthly.click();
        monthDownBtn1.click();
        dayDownBtn1.click();
        yearDownBtn1.click();
        clckOk.click();
        swipeDown();
        //Select Time
        //PICK AM OR PM
        //        MobileElement downAmPmBtn = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='1']"+
        //                "/android.widget.Button[@index = '1']");
        //        downAmPmBtn.click();
        MobileElement hrsDownBtn = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='0']"+
                "/android.widget.Button[@index = '2']");
        hrsDownBtn.click();
        MobileElement minDownBtn = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[@index='2']"+
                "/android.widget.Button[@index = '2']");
        minDownBtn.click();
        //Input notes nacclick bigla un cancel
        //        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //        MobileElement schedNotes = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'text_note')]");
        //        schedNotes.sendKeys("ABCDEFG12345");
        //Click save
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'schedules_add_schedule_request_save_btn')]");
        clckSave.click();
    }
    private void searchByBranchName(){
        //Arrow down
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckDownArrow = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        clckDownArrow.click();
        //Search by Branch Name
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBranchName = (MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[contains(@resource-id, 'relBranchName')]");
        clckBranchName.click();
        //Filter button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckFilterBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        clckFilterBtn.click();
        //Search specific branch
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBranchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
        searchBranchName.sendKeys(brnchName[rand(brnchName.length-1)]);
        //Click on magnifying glass
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        //Type a word that is not in the search criteria
        searchBranchName.sendKeys(wrongBrnchName[rand(wrongBrnchName.length-1)]);
        clckSearch.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        clckOk.click();
    }
    private void searchByBranchCode(){
        //Arrow down
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckDownArrow = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        clckDownArrow.click();
        //Search by Branch Code
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBranchCode = (MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[contains(@resource-id, 'relBranchCode')]");
        clckBranchCode.click();
        //Filter button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckFilterBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        clckFilterBtn.click();
        //Search specific branch
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBranchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
        searchBranchName.sendKeys(brnchCode[rand(brnchCode.length-1)]);
        //Click on magnifying glass
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        //Type a word that is not in the search criteria
        searchBranchName.sendKeys(wrongBrnchCode[rand(wrongBrnchCode.length-1)]);
        clckSearch.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        clckOk.click();
    }
    private void searchByAccName(){
        //Arrow down
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckDownArrow = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        clckDownArrow.click();
        //Search by Account Name
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBranchCode = (MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[contains(@resource-id, 'relAccountName')]");
        clckBranchCode.click();
        //Filter button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckFilterBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        clckFilterBtn.click();
        //Search specific branch
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBranchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
        searchBranchName.sendKeys(accName[rand(accName.length-1)]);
        //Click on magnifying glass
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        //Type a word that is not in the search criteria
        searchBranchName.sendKeys(wrongAccName[rand(wrongAccName.length-1)]);
        clckSearch.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        clckOk.click();
    }
    private void searchByAccCode(){
        //Arrow down
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckDownArrow = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        clckDownArrow.click();
        //Search by Account Code
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBranchCode = (MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[contains(@resource-id, 'relAccountCode')]");
        clckBranchCode.click();
        //Filter button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckFilterBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        clckFilterBtn.click();
        //Search specific branch
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBranchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
        searchBranchName.sendKeys(accCode[rand(accCode.length-1)]);
        //Click on magnifying glass
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        //Type a word that is not in the search criteria
        searchBranchName.sendKeys(wrongAccCode[rand(wrongAccCode.length-1)]);
        clckSearch.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        clckOk.click();
    }
    private void searchByLocation(){
        //Arrow down
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckDownArrow = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        clckDownArrow.click();
        //Search by Account Code
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBranchCode = (MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[contains(@resource-id, 'relLocation')]");
        clckBranchCode.click();
        //Filter button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckFilterBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        clckFilterBtn.click();
        //Search specific branch
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBranchName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id, 'search_auto_complete_text_view')]");
        searchBranchName.sendKeys(location[rand(location.length-1)]);
        //Click on magnifying glass
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckSearch = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'search_button')]");
        clckSearch.click();
        //Type a word that is not in the search criteria
        searchBranchName.sendKeys(wrongLocation[rand(wrongLocation.length-1)]);
        clckSearch.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        clckOk.click();
    }
    private void searchBySchedBrnchDate(){
        //Arrow down
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckDownArrow = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        clckDownArrow.click();
        //Search by Account Code
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckBranchCode = (MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[contains(@resource-id, 'relScheduledBranchDate')]");
        clckBranchCode.click();
        //Filter button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckFilterBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        clckFilterBtn.click();
    }
    private void filterByNoFilter(){
        //Arrow down
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckDownArrow = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        clckDownArrow.click();
        //Swipe down
        swipeDownFilter();
        //Search by Account Code
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckNoFilter = (MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[contains(@resource-id, 'relFilterNoFilter')]");
        clckNoFilter.click();
        //Filter button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckFilterBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        clckFilterBtn.click();
    }
    private void filterBySelectedBrnch(){
        //Arrow down
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckDownArrow = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        clckDownArrow.click();
        //Swipe down
        swipeDownFilter();
        //Search by Account Code
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckNoFilter = (MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[contains(@resource-id, 'relFilterSelectedBranch')]");
        clckNoFilter.click();
        //Filter button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckFilterBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        clckFilterBtn.click();
    }
    private void filterByNotSelectedBrnch(){
        //Arrow down
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckDownArrow = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id, 'filter_by_button')]");
        clckDownArrow.click();
        //Swipe down
        swipeDownFilter();
        //Search by Account Code
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckNoFilter = (MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[contains(@resource-id, 'relFilterNotSelectedBranch')]");
        clckNoFilter.click();
        //Filter button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckFilterBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id, 'button1')]");
        clckFilterBtn.click();
    }

    public void swipeDown(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Request Schedule']");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Dimension dim = driver.manage().window().getSize();
            int width = dim.getWidth();
            int height = dim.getHeight();
            //Para nasa gilid un pag scroll walang tatamaan textfield
            int x = (int) (width * 0.99);
            int y1 = (int) (height * 0.50);
            int y2 = (int) (height * 0.01);
            TouchAction touchAction = new TouchAction(driver);
            //try this
            touchAction.longPress(new PointOption().withCoordinates(x, y1)).moveTo(new PointOption().withCoordinates(x, y2)).release().perform();
        }

    }
    public void swipeDownFilter(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Filter by']");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Dimension dim = driver.manage().window().getSize();
            int width = dim.getWidth();
            int height = dim.getHeight();
            //Para nasa gilid un pag scroll walang tatamaan textfield
            int x = (int) (width * 0.50);
            int y1 = (int) (height * 0.50);
            int y2 = (int) (height * 0.01);
            TouchAction touchAction = new TouchAction(driver);
            //try this
            touchAction.longPress(new PointOption().withCoordinates(x, y1)).moveTo(new PointOption().withCoordinates(x, y2)).release().perform();
        }

    }
    private static int rand(int bound) {
        return (int) (Math.random() * bound);
    }
}
