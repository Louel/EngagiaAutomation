import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class TAKEPICTURE {

    AppiumDriver driver;
    String search = "Take Picture";
    String [] randomString = {"Note12345!@#$%", "Note12345" , "Note!@#$%" , "Note", "12345", "12345!@#$%" , "!@#$%"};
    String branchListDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout" +
            "/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView";
    String summaryMenuViewsDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.ListView";
    String filterDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView";
    String pictureRowDrctry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.support.v7.widget.RecyclerView";

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Samsung Galaxy J1 (2016)");
//        capabilities.setCapability("deviceName","HUAWEI");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("platformVersion", "5.1.1");
//        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("appPackage", "com.engagia.android");
        capabilities.setCapability("appActivity","com.engagia.android.activities.LoginActivity");
        capabilities.setCapability("noSign", true);
        capabilities.setCapability(FULL_RESET, false);
        capabilities.setCapability(NO_RESET, true);
        //Papalitan un Ip depende sa pc
        driver = new AppiumDriver(new URL("http://192.168.0.167:4723/wd/hub"), capabilities);
    }
    @Test
    public void testTP(){
        SearchTakePicture();
        testingWithoutPic();
        //Log in to visit
        loginToVisit();
        SearchTakePicture();
        testingWithPic();
    }

    //Functions
    private void loginToVisit() {
        for (int x = 1; x <= 1; x++) {
            //Click on Drawer
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement drawerOpen = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
            drawerOpen.click();
            //
            swipeUp();
            //Click on Arrow down btn
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement clckArrowDown = (MobileElement) driver.findElementById("com.engagia.android:id/image_visit_dropdown");
            clckArrowDown.click();
            //Click on branch depends on index or int of the loop
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement clckOnBranch = (MobileElement) driver.findElementByXPath(branchListDrctry + "/android.widget.RelativeLayout[" + x + "]");
            clckOnBranch.click();
            //IF BRANCH IS NOT SCHEDULED A PROMPT WILL APPEAR
//            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//            MobileElement contBtn = (MobileElement) driver.findElementById("android:id/button1");
//            contBtn.click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement confirmBtn = (MobileElement) driver.findElementById("android:id/button1");
            confirmBtn.click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
            okBtn.click();
            //INSERT CASES OR FUNCTION HERE
            SearchTakePicture();
            visit_testingWithoutPic();
            visit_testingWithPic();

            //Click on Drawer to logout to visit
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement drawerOpen2 = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
            drawerOpen2.click();
            //Insert swipe up to arrow
            swipeUp();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            clckArrowDown.click();
            //Log out
            MobileElement logoutBtn = (MobileElement) driver.findElementById("com.engagia.android:id/btn_visit_logout");
            logoutBtn.click();
        }
    }
    private void SearchTakePicture(){
        //click Hamburger Menu
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement HamburgerBtn = (MobileElement) driver.findElementByAccessibilityId("Open drawer");
        HamburgerBtn.click();
        System.out.println("Seaching Take Picture");
        //search test.BAOF
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/edit_text_search");
        searchField.sendKeys(search);
        //click search result
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckRes = (MobileElement) driver.findElementByAccessibilityId("Take Picture");
        clckRes.click();
    }
    private void swipeUp(){
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
    private void visit_testingWithoutPic(){
        visit_summaryMenuNoPic();
        visit_filterByNoPic();
        visit_searchFieldNoPic();
    }
    private void visit_testingWithPic(){
        visit_takePictureCancel();
        for(int z=1; z<=6; z++) {
            visit_takePicture();
        }
        visit_summaryMenuWithPic();
        visit_filterByWithPic();
        visit_searchFieldWithPic();
        addNote();
        for(int x=1; x<=4; x++) {
            deletePicture();
        }
    }
    private void visit_summaryMenuNoPic(){
        for(int z=1; z<=2; z++) {
            MobileElement summaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
            summaryMenu.click();
            //Summary menu view grid and list
            MobileElement viewGridList = (MobileElement) driver.findElementByXPath("//android.widget.ListView");
            boolean viewGridListisDisplayed = viewGridList.isDisplayed();
            if(viewGridListisDisplayed){
                //LIST VIEW IS THE DEFAULT FILTER
                MobileElement gridView = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout["+z+"]");
                gridView.click();
                MobileElement gridPanel = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean gridPanelisDisplayed = gridPanel.isDisplayed();
                if(gridPanelisDisplayed) {
                    if(z==1) {
                        MobileElement noDataMsgGridview = (MobileElement) driver.findElementById("android:id/message");
                        String noDataText = noDataMsgGridview.getText();
                        System.out.println("Grid View "+noDataText);
                    }
                    else if(z==2){
                        MobileElement noDataMsgGridview = (MobileElement) driver.findElementById("android:id/message");
                        String noDataText = noDataMsgGridview.getText();
                        System.out.println("List View "+noDataText);
                    }
                    MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
                    okBtn.click();
                }
            }
        }
    }
    private void visit_filterByNoPic(){
        for(int z=1; z<=4; z++) {
            System.out.print(z);
            MobileElement filterByBtn = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
            filterByBtn.click();
            MobileElement filterByPanel = (MobileElement) driver.findElementById("android:id/parentPanel");
            boolean filterByPanelisDisplayed = filterByPanel.isDisplayed();
            if(filterByPanelisDisplayed){
                MobileElement searchByTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                String searchByTitleText = searchByTitle.getText();
                System.out.println("Alert displayed: "+searchByTitleText);
                MobileElement dateTakenBtn = (MobileElement) driver.findElementById("android:id/text1");
                dateTakenBtn.click();
                if(z==1){
                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                    String calendarTitleText = calendarTitle.getText();
                    //Uncomment this and change date if you want a specific date
                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                    selectDateFrom.click();
                    MobileElement cancelBtnDateFrom = (MobileElement) driver.findElementById("android:id/button2");
                    cancelBtnDateFrom.click();
                    System.out.println(calendarTitleText+" canceled");
                }
                else if(z==2) {
                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                    String calendarTitleText = calendarTitle.getText();
                    //Uncomment this and change date if you want a specific date (Set this date as a Future date A L W A Y S)
                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                    selectDateFrom.click();
                    MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
                    okBtnDateFrom.click();
                    System.out.println(calendarTitleText + " filtered a Date");
                    MobileElement engagiaMessage = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                    boolean engagiaMessagelisDisplayed = engagiaMessage.isDisplayed();
                    if (engagiaMessagelisDisplayed) {
                        MobileElement futureDateMsg = (MobileElement) driver.findElementById("android:id/message");
                        String futureDateMsgText = futureDateMsg.getText();
                        System.out.println("A prompt appear with message " + futureDateMsgText);
                        MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
                        okBtn.click();
                    }
                }
                else if(z==3){
                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                    String calendarTitleText = calendarTitle.getText();
                    //Uncomment this and change date if you want a specific date
//                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
//                    selectDateFrom.click();
                    MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
                    okBtnDateFrom.click();
                    System.out.println(calendarTitleText + " filtered a Date");
                    //Uncomment this and change date if you want a specific date
                    MobileElement selectDateTo = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                    selectDateTo.click();
                    MobileElement cancelBtnDateTo = (MobileElement) driver.findElementById("android:id/button2");
                    cancelBtnDateTo.click();
                    System.out.println(calendarTitleText+" canceled");
                }
                else if(z==4){
                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                    String calendarTitleText = calendarTitle.getText();
                    //Uncomment this and change date if you want a specific date
//                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
//                    selectDateFrom.click();
                    MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
                    okBtnDateFrom.click();
                    System.out.println(calendarTitleText+" filtered a Date");
                    //Uncomment this and change date if you want a specific date
                    MobileElement selectDateTo = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                    selectDateTo.click();
                    MobileElement okBtnDateTo = (MobileElement) driver.findElementById("android:id/button1");
                    okBtnDateTo.click();
                    System.out.println(calendarTitleText+" filtered a Date");
                }
//                else if(z==5){
//                    //todo tignan kung ano mangyayari pag pass date ang pinili sa Date To
//                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
//                    String calendarTitleText = calendarTitle.getText();
//                    //Uncomment this and change date if you want a specific date
////                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
////                    selectDateFrom.click();
//                    MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
//                    okBtnDateFrom.click();
//                    System.out.println(calendarTitleText+" filtered a Date");
//                    //Uncomment this and change date if you want a specific date
//                    MobileElement selectDateTo = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
//                    selectDateTo.click();
//                    MobileElement okBtnDateTo = (MobileElement) driver.findElementById("android:id/button1");
//                    okBtnDateTo.click();
//                    System.out.println(calendarTitleText+" filtered a Date");
//                }
            }
        }
        MobileElement dateTakenPanel = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
        boolean dateTakenPanelisDisplayed = dateTakenPanel.isDisplayed();
        if (dateTakenPanelisDisplayed) {
            MobileElement noDataMsgDateTaken = (MobileElement) driver.findElementById("android:id/message");
            String noDataText = noDataMsgDateTaken.getText();
            System.out.println("Date Taken " + noDataText);
            MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
            okBtn.click();
        }
    }
    private void visit_searchFieldNoPic(){
        for(int z=1; z<=2; z++) {
            if(z==1) {
                for (int x = 1; x <= 3; x++) {
                    System.out.print(x);
                    MobileElement searchByField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                    searchByField.click();
                    if (x == 1) {
                        MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                        String calendarTitleText = calendarTitle.getText();
                        //Uncomment this and change date if you want a specific date
                        //                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                        //                    selectDateFrom.click();
                        MobileElement cancelBtnDateFrom = (MobileElement) driver.findElementById("android:id/button2");
                        cancelBtnDateFrom.click();
                        System.out.println(calendarTitleText + " canceled");
                    } else if (x == 2) {
                        MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                        String calendarTitleText = calendarTitle.getText();
                        //Uncomment this and change date if you want a specific date
                        //                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                        //                    selectDateFrom.click();
                        MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
                        okBtnDateFrom.click();
                        System.out.println(calendarTitleText + " filtered a Date");
                        //Uncomment this and change date if you want a specific date
                        //                    MobileElement selectDateTo = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                        //                    selectDateTo.click();
                        MobileElement cancelBtnDateTo = (MobileElement) driver.findElementById("android:id/button2");
                        cancelBtnDateTo.click();
                        System.out.println(calendarTitleText + " canceled");
                    } else if (x == 3) {
                        MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                        String calendarTitleText = calendarTitle.getText();
                        //Uncomment this and change date if you want a specific date
                        //                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                        //                    selectDateFrom.click();
                        MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
                        okBtnDateFrom.click();
                        System.out.println(calendarTitleText + " filtered a Date");
                        //Uncomment this and change date if you want a specific date
                        //                    MobileElement selectDateTo = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                        //                    selectDateTo.click();
                        MobileElement okBtnDateTo = (MobileElement) driver.findElementById("android:id/button1");
                        okBtnDateTo.click();
                        System.out.println(calendarTitleText + " filtered a Date");
                    }
                }
            }
            else if(z == 2){
                MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                searchBtn.click();
                System.out.print("Searching without data");
            }
            MobileElement dateTakenPanel = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
            boolean dateTakenPanelisDisplayed = dateTakenPanel.isDisplayed();
            if (dateTakenPanelisDisplayed) {
                MobileElement noDataMsgDateTaken = (MobileElement) driver.findElementById("android:id/message");
                String noDataText = noDataMsgDateTaken.getText();
                System.out.println("search By Date Taken " + noDataText);
                MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
                okBtn.click();
            }
        }
    }
    private void visit_summaryMenuWithPic(){
        for(int z=1; z<=2; z++) {
            MobileElement summaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
            summaryMenu.click();
            //Summary menu view grid and list
            MobileElement viewGridList = (MobileElement) driver.findElementByXPath("//android.widget.ListView");
            boolean viewGridListisDisplayed = viewGridList.isDisplayed();
            if(viewGridListisDisplayed){
                //LIST VIEW IS THE DEFAULT FILTER
                MobileElement gridView = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout["+z+"]");
                gridView.click();
            }
        }
    }
    private void visit_filterByWithPic(){
        for(int z=1; z<=4; z++) {
            System.out.print(z);
            MobileElement filterByBtn = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
            filterByBtn.click();
            MobileElement filterByPanel = (MobileElement) driver.findElementById("android:id/parentPanel");
            boolean filterByPanelisDisplayed = filterByPanel.isDisplayed();
            if(filterByPanelisDisplayed){
                MobileElement searchByTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                String searchByTitleText = searchByTitle.getText();
                System.out.println("Alert displayed: "+searchByTitleText);
                MobileElement dateTakenBtn = (MobileElement) driver.findElementById("android:id/text1");
                dateTakenBtn.click();
                if(z==1){
                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                    String calendarTitleText = calendarTitle.getText();
                    //Uncomment this and change date if you want a specific date
                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                    selectDateFrom.click();
                    MobileElement cancelBtnDateFrom = (MobileElement) driver.findElementById("android:id/button2");
                    cancelBtnDateFrom.click();
                    System.out.println(calendarTitleText+" canceled");
                }
                else if(z==2) {
                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                    String calendarTitleText = calendarTitle.getText();
                    //Uncomment this and change date if you want a specific date (Set this date as a Future date A L W A Y S)
                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                    selectDateFrom.click();
                    MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
                    okBtnDateFrom.click();
                    System.out.println(calendarTitleText + " filtered a Date");
                    MobileElement engagiaMessage = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                    boolean engagiaMessagelisDisplayed = engagiaMessage.isDisplayed();
                    if (engagiaMessagelisDisplayed) {
                        MobileElement futureDateMsg = (MobileElement) driver.findElementById("android:id/message");
                        String futureDateMsgText = futureDateMsg.getText();
                        System.out.println("A prompt appear with message " + futureDateMsgText);
                        MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
                        okBtn.click();
                    }
                }
                else if(z==3){
                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                    String calendarTitleText = calendarTitle.getText();
                    //Uncomment this and change date if you want a specific date
//                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
//                    selectDateFrom.click();
                    MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
                    okBtnDateFrom.click();
                    System.out.println(calendarTitleText + " filtered a Date");
                    //Uncomment this and change date if you want a specific date
                    MobileElement selectDateTo = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                    selectDateTo.click();
                    MobileElement cancelBtnDateTo = (MobileElement) driver.findElementById("android:id/button2");
                    cancelBtnDateTo.click();
                    System.out.println(calendarTitleText+" canceled");
                }
                else if(z==4){
                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                    String calendarTitleText = calendarTitle.getText();
                    //Uncomment this and change date if you want a specific date
//                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
//                    selectDateFrom.click();
                    MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
                    okBtnDateFrom.click();
                    System.out.println(calendarTitleText+" filtered a Date");
                    //Uncomment this and change date if you want a specific date
                    MobileElement selectDateTo = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                    selectDateTo.click();
                    MobileElement okBtnDateTo = (MobileElement) driver.findElementById("android:id/button1");
                    okBtnDateTo.click();
                    System.out.println(calendarTitleText+" filtered a Date");
                }
//                else if(z==5){
//                    //todo tignan kung ano mangyayari pag pass date ang pinili sa Date To
//                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
//                    String calendarTitleText = calendarTitle.getText();
//                    //Uncomment this and change date if you want a specific date
////                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
////                    selectDateFrom.click();
//                    MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
//                    okBtnDateFrom.click();
//                    System.out.println(calendarTitleText+" filtered a Date");
//                    //Uncomment this and change date if you want a specific date
//                    MobileElement selectDateTo = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
//                    selectDateTo.click();
//                    MobileElement okBtnDateTo = (MobileElement) driver.findElementById("android:id/button1");
//                    okBtnDateTo.click();
//                    System.out.println(calendarTitleText+" filtered a Date");
//                }
            }
        }
    }
    private void visit_searchFieldWithPic(){
        for(int z=1; z<=2; z++) {
            if(z==1) {
                for (int x = 1; x <= 3; x++) {
                    System.out.print(x);
                    MobileElement searchByField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                    searchByField.click();
                    if (x == 1) {
                        MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                        String calendarTitleText = calendarTitle.getText();
                        //Uncomment this and change date if you want a specific date
                        //                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                        //                    selectDateFrom.click();
                        MobileElement cancelBtnDateFrom = (MobileElement) driver.findElementById("android:id/button2");
                        cancelBtnDateFrom.click();
                        System.out.println(calendarTitleText + " canceled");
                    } else if (x == 2) {
                        MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                        String calendarTitleText = calendarTitle.getText();
                        //Uncomment this and change date if you want a specific date
                        //                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                        //                    selectDateFrom.click();
                        MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
                        okBtnDateFrom.click();
                        System.out.println(calendarTitleText + " filtered a Date");
                        //Uncomment this and change date if you want a specific date
                        //                    MobileElement selectDateTo = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                        //                    selectDateTo.click();
                        MobileElement cancelBtnDateTo = (MobileElement) driver.findElementById("android:id/button2");
                        cancelBtnDateTo.click();
                        System.out.println(calendarTitleText + " canceled");
                    } else if (x == 3) {
                        MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                        String calendarTitleText = calendarTitle.getText();
                        //Uncomment this and change date if you want a specific date
                        //                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                        //                    selectDateFrom.click();
                        MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
                        okBtnDateFrom.click();
                        System.out.println(calendarTitleText + " filtered a Date");
                        //Uncomment this and change date if you want a specific date
                        //                    MobileElement selectDateTo = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                        //                    selectDateTo.click();
                        MobileElement okBtnDateTo = (MobileElement) driver.findElementById("android:id/button1");
                        okBtnDateTo.click();
                        System.out.println(calendarTitleText + " filtered a Date");
                    }
                }
            }
            else if(z == 2){
                MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                searchBtn.click();
                System.out.print("Searching without data");
            }
        }
    }
    private void visit_takePicture(){
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement takePicBtn = (MobileElement) driver.findElementById("com.engagia.android:id/fab_take_picture");
        takePicBtn.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement cameraBtn = (MobileElement) driver.findElementById("com.simplemobiletools.camera:id/shutter");
        cameraBtn.click();
        MobileElement pictureSaved = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
        String pictureSavedText = pictureSaved.getText();
        System.out.println("A prompt appear with a message: "+pictureSavedText);
    }
    private void visit_takePictureCancel(){
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement takePicBtn = (MobileElement) driver.findElementById("com.engagia.android:id/fab_take_picture");
        takePicBtn.click();
        MobileElement cameraBtn = (MobileElement) driver.findElementById("com.simplemobiletools.camera:id/shutter");
        boolean cameraBtnDisplayed = cameraBtn.isDisplayed();
        if(cameraBtnDisplayed) {
            driver.navigate().back();
        }
        MobileElement pictureMsg = (MobileElement) driver.findElementById("com.engagia.android:id/snackbar_text");
        String pictureMsgText = pictureMsg.getText();
        System.out.println("A prompt appear with a message: "+pictureMsgText);
    }
    private void testingWithoutPic(){
        summaryMenuNoPic();
        filterByNoPic();
    }
    private void summaryMenuNoPic(){
        for(int z=1; z<=2; z++) {
            MobileElement summaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
            summaryMenu.click();
            //Summary menu view grid and list
            MobileElement viewGridList = (MobileElement) driver.findElementByXPath("//android.widget.ListView");
            boolean viewGridListisDisplayed = viewGridList.isDisplayed();
            if(viewGridListisDisplayed){
                //LIST VIEW IS THE DEFAULT FILTER
                MobileElement gridView = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout["+z+"]");
                gridView.click();
                MobileElement gridPanel = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                boolean gridPanelisDisplayed = gridPanel.isDisplayed();
                if(gridPanelisDisplayed) {
                    if(z==1) {
                        MobileElement noDataMsgGridview = (MobileElement) driver.findElementById("android:id/message");
                        String noDataText = noDataMsgGridview.getText();
                        System.out.println("Grid View "+noDataText);
                    }
                    else if(z==2){
                        MobileElement noDataMsgGridview = (MobileElement) driver.findElementById("android:id/message");
                        String noDataText = noDataMsgGridview.getText();
                        System.out.println("List View "+noDataText);
                    }
                    MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
                    okBtn.click();
                }
            }
        }
    }
    private void filterByNoPic(){
        for(int z=1; z<=6; z++) {
            System.out.print(z);
            MobileElement filterByBtn = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
            filterByBtn.click();
            MobileElement filterByPanel = (MobileElement) driver.findElementById("android:id/parentPanel");
            boolean filterByPanelisDisplayed = filterByPanel.isDisplayed();
            if(filterByPanelisDisplayed){
                MobileElement searchByTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                String searchByTitleText = searchByTitle.getText();
                System.out.println("Alert displayed: "+searchByTitleText);
                if(z==1){
                    MobileElement branchCode = (MobileElement) driver.findElementByXPath(filterDrctry+"/android.widget.TextView[1]");
                    branchCode.click();
                    MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                    searchField.sendKeys("ALFAMART MARIKINA 1");
                    MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                    searchBtn.click();
                    MobileElement branchCodePanel = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                    boolean branchCodePanelisDisplayed = branchCodePanel.isDisplayed();
                    if (branchCodePanelisDisplayed) {
                        MobileElement noDataMsgBranchCode = (MobileElement) driver.findElementById("android:id/message");
                        String noDataText = noDataMsgBranchCode.getText();
                        System.out.println("Branch Code " + noDataText);
                        MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
                        okBtn.click();
                    }
                }
                else if(z==2){
                    MobileElement branchName = (MobileElement) driver.findElementByXPath(filterDrctry+"/android.widget.TextView[2]");
                    branchName.click();
                    MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                    searchField.sendKeys("ALFAMART MARIKINA 1");
                    MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                    searchBtn.click();
                    MobileElement branchNamePanel = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                    boolean branchNamePanelisDisplayed = branchNamePanel.isDisplayed();
                    if (branchNamePanelisDisplayed) {
                        MobileElement noDataMsgBranchName = (MobileElement) driver.findElementById("android:id/message");
                        String noDataText = noDataMsgBranchName.getText();
                        System.out.println("Branch Name " + noDataText);
                        MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
                        okBtn.click();
                    }
                }
                else if(z==3){
                    MobileElement dateTakenBtn = (MobileElement) driver.findElementByXPath(filterDrctry+"/android.widget.TextView[3]");
                    dateTakenBtn.click();
                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                    String calendarTitleText = calendarTitle.getText();
                    //Uncomment this and change date if you want a specific date
                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                    selectDateFrom.click();
                    MobileElement cancelBtnDateFrom = (MobileElement) driver.findElementById("android:id/button2");
                    cancelBtnDateFrom.click();
                    System.out.println(calendarTitleText+" canceled");
                }
                else if(z==4) {
                    MobileElement dateTakenBtn = (MobileElement) driver.findElementByXPath(filterDrctry+"/android.widget.TextView[3]");
                    dateTakenBtn.click();
                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                    String calendarTitleText = calendarTitle.getText();
                    //Uncomment this and change date if you want a specific date (Set this date as a Future date A L W A Y S)
                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                    selectDateFrom.click();
                    MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
                    okBtnDateFrom.click();
                    System.out.println(calendarTitleText + " filtered a Date");
                    MobileElement engagiaMessage = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                    boolean engagiaMessagelisDisplayed = engagiaMessage.isDisplayed();
                    if (engagiaMessagelisDisplayed) {
                        MobileElement futureDateMsg = (MobileElement) driver.findElementById("android:id/message");
                        String futureDateMsgText = futureDateMsg.getText();
                        System.out.println("A prompt appear with message " + futureDateMsgText);
                        MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
                        okBtn.click();
                    }
                }
                else if(z==5){
                    MobileElement dateTakenBtn = (MobileElement) driver.findElementByXPath(filterDrctry+"/android.widget.TextView[3]");
                    dateTakenBtn.click();
                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                    String calendarTitleText = calendarTitle.getText();
                    //Uncomment this and change date if you want a specific date
//                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
//                    selectDateFrom.click();
                    MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
                    okBtnDateFrom.click();
                    System.out.println(calendarTitleText + " filtered a Date");
                    //Uncomment this and change date if you want a specific date
                    MobileElement selectDateTo = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                    selectDateTo.click();
                    MobileElement cancelBtnDateTo = (MobileElement) driver.findElementById("android:id/button2");
                    cancelBtnDateTo.click();
                    System.out.println(calendarTitleText+" canceled");
                }
                else if(z==6){
                    MobileElement dateTakenBtn = (MobileElement) driver.findElementByXPath(filterDrctry+"/android.widget.TextView[3]");
                    dateTakenBtn.click();
                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                    String calendarTitleText = calendarTitle.getText();
                    //Uncomment this and change date if you want a specific date
//                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
//                    selectDateFrom.click();
                    MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
                    okBtnDateFrom.click();
                    System.out.println(calendarTitleText+" filtered a Date");
                    //Uncomment this and change date if you want a specific date
                    MobileElement selectDateTo = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                    selectDateTo.click();
                    MobileElement okBtnDateTo = (MobileElement) driver.findElementById("android:id/button1");
                    okBtnDateTo.click();
                    System.out.println(calendarTitleText+" filtered a Date");
                }
//                else if(z==5){
//                    //todo tignan kung ano mangyayari pag pass date ang pinili sa Date To
//                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
//                    String calendarTitleText = calendarTitle.getText();
//                    //Uncomment this and change date if you want a specific date
////                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
////                    selectDateFrom.click();
//                    MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
//                    okBtnDateFrom.click();
//                    System.out.println(calendarTitleText+" filtered a Date");
//                    //Uncomment this and change date if you want a specific date
//                    MobileElement selectDateTo = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
//                    selectDateTo.click();
//                    MobileElement okBtnDateTo = (MobileElement) driver.findElementById("android:id/button1");
//                    okBtnDateTo.click();
//                    System.out.println(calendarTitleText+" filtered a Date");
//                }
            }
        }
        MobileElement dateTakenPanel = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
        boolean dateTakenPanelisDisplayed = dateTakenPanel.isDisplayed();
        if (dateTakenPanelisDisplayed) {
            MobileElement noDataMsgDateTaken = (MobileElement) driver.findElementById("android:id/message");
            String noDataText = noDataMsgDateTaken.getText();
            System.out.println("Date Taken " + noDataText);
            MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
            okBtn.click();
        }
    }
    private void testingWithPic(){
        summaryMenuWithPic();
        filterByWithPic();
        addNote();
    }
    private void summaryMenuWithPic(){
        for(int z=1; z<=2; z++) {
            MobileElement summaryMenu = (MobileElement) driver.findElementByAccessibilityId("Show action");
            summaryMenu.click();
            //Summary menu view grid and list
            MobileElement viewGridList = (MobileElement) driver.findElementByXPath("//android.widget.ListView");
            boolean viewGridListisDisplayed = viewGridList.isDisplayed();
            if(viewGridListisDisplayed){
                //LIST VIEW IS THE DEFAULT FILTER
                MobileElement gridView = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout["+z+"]");
                gridView.click();
            }
        }
    }
    private void filterByWithPic(){
        for(int z=1; z<=6; z++) {
            MobileElement filterByBtn = (MobileElement) driver.findElementById("com.engagia.android:id/filter_by_button");
            filterByBtn.click();
            MobileElement filterByPanel = (MobileElement) driver.findElementById("android:id/parentPanel");
            boolean filterByPanelisDisplayed = filterByPanel.isDisplayed();
            if(filterByPanelisDisplayed){
                MobileElement searchByTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                String searchByTitleText = searchByTitle.getText();
                System.out.println("Panel displayed: "+searchByTitleText);
                if(z==1){
                    MobileElement branchCode = (MobileElement) driver.findElementByXPath(filterDrctry+"/android.widget.TextView[1]");
                    branchCode.click();
                    MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                    searchField.sendKeys("MARACCGCODE001");
                    MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                    searchBtn.click();
                }
                else if(z==2){
                    MobileElement branchName = (MobileElement) driver.findElementByXPath(filterDrctry+"/android.widget.TextView[2]");
                    branchName.click();
                    MobileElement searchField = (MobileElement) driver.findElementById("com.engagia.android:id/search_auto_complete_text_view");
                    searchField.sendKeys("ALFAMART MARIKINA 1");
                    MobileElement searchBtn = (MobileElement) driver.findElementById("com.engagia.android:id/search_button");
                    searchBtn.click();
                }
                else if(z==3){
                    MobileElement dateTakenBtn = (MobileElement) driver.findElementByXPath(filterDrctry+"/android.widget.TextView[3]");
                    dateTakenBtn.click();
                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                    String calendarTitleText = calendarTitle.getText();
                    //Uncomment this and change date if you want a specific date
                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                    selectDateFrom.click();
                    MobileElement cancelBtnDateFrom = (MobileElement) driver.findElementById("android:id/button2");
                    cancelBtnDateFrom.click();
                    System.out.println(calendarTitleText+" canceled");
                }
                else if(z==4) {
                    MobileElement dateTakenBtn = (MobileElement) driver.findElementByXPath(filterDrctry+"/android.widget.TextView[3]");
                    dateTakenBtn.click();
                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                    String calendarTitleText = calendarTitle.getText();
                    //Uncomment this and change date if you want a specific date (Set this date as a Future date A L W A Y S)
                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                    selectDateFrom.click();
                    MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
                    okBtnDateFrom.click();
                    System.out.println(calendarTitleText + " filtered a Date");
                    MobileElement engagiaMessage = (MobileElement) driver.findElementById("com.engagia.android:id/parentPanel");
                    boolean engagiaMessagelisDisplayed = engagiaMessage.isDisplayed();
                    if (engagiaMessagelisDisplayed) {
                        MobileElement futureDateMsg = (MobileElement) driver.findElementById("android:id/message");
                        String futureDateMsgText = futureDateMsg.getText();
                        System.out.println("A prompt appear with message " + futureDateMsgText);
                        MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
                        okBtn.click();
                    }
                }
                else if(z==5){
                    MobileElement dateTakenBtn = (MobileElement) driver.findElementByXPath(filterDrctry+"/android.widget.TextView[3]");
                    dateTakenBtn.click();
                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                    String calendarTitleText = calendarTitle.getText();
                    //Uncomment this and change date if you want a specific date
//                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
//                    selectDateFrom.click();
                    MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
                    okBtnDateFrom.click();
                    System.out.println(calendarTitleText + " filtered a Date");
                    //Uncomment this and change date if you want a specific date
                    MobileElement selectDateTo = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                    selectDateTo.click();
                    MobileElement cancelBtnDateTo = (MobileElement) driver.findElementById("android:id/button2");
                    cancelBtnDateTo.click();
                    System.out.println(calendarTitleText+" canceled");
                }
                else if(z==6){
                    MobileElement dateTakenBtn = (MobileElement) driver.findElementByXPath(filterDrctry+"/android.widget.TextView[3]");
                    dateTakenBtn.click();
                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
                    String calendarTitleText = calendarTitle.getText();
                    //Uncomment this and change date if you want a specific date
//                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
//                    selectDateFrom.click();
                    MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
                    okBtnDateFrom.click();
                    System.out.println(calendarTitleText+" filtered a Date");
                    //Uncomment this and change date if you want a specific date
                    MobileElement selectDateTo = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
                    selectDateTo.click();
                    MobileElement okBtnDateTo = (MobileElement) driver.findElementById("android:id/button1");
                    okBtnDateTo.click();
                    System.out.println(calendarTitleText+" filtered a Date");
                }
//                else if(z==5){
//                    //todo tignan kung ano mangyayari pag pass date ang pinili sa Date To
//                    MobileElement calendarTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
//                    String calendarTitleText = calendarTitle.getText();
//                    //Uncomment this and change date if you want a specific date
////                    MobileElement selectDateFrom = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
////                    selectDateFrom.click();
//                    MobileElement okBtnDateFrom = (MobileElement) driver.findElementById("android:id/button1");
//                    okBtnDateFrom.click();
//                    System.out.println(calendarTitleText+" filtered a Date");
//                    //Uncomment this and change date if you want a specific date
//                    MobileElement selectDateTo = (MobileElement) driver.findElementByAccessibilityId("30 March 2019");
//                    selectDateTo.click();
//                    MobileElement okBtnDateTo = (MobileElement) driver.findElementById("android:id/button1");
//                    okBtnDateTo.click();
//                    System.out.println(calendarTitleText+" filtered a Date");
//                }
            }
        }
    }
    private void addNote(){
        for(int z=1; z<=2; z++) {
            holdPicture();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement addBtn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]");
            addBtn.click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement textNote = (MobileElement) driver.findElementById("com.engagia.android:id/text_note");
            textNote.sendKeys(randomString[rand(randomString.length-1)]);
            if(z==1){
            MobileElement cancelBtn = (MobileElement) driver.findElementById("android:id/button2");
            cancelBtn.click();
            }
            else if(z==2){
                MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
                okBtn.click();
            }
            System.out.println("Adding Note");
        }
    }
    private void deletePicture(){
        for(int z=1; z<=2; z++) {
            holdPicture();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement deleteBtn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]");
            deleteBtn.click();
            if(z==1){
                MobileElement cancelBtn = (MobileElement) driver.findElementById("android:id/button2");
                cancelBtn.click();
            }
            else if(z==2){
                MobileElement okBtn = (MobileElement) driver.findElementById("android:id/button1");
                okBtn.click();
            }
        }
    }
    private void holdPicture(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement pictureRow = (MobileElement) driver.findElementByXPath(pictureRowDrctry+"/android.widget.FrameLayout[1]");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(element(pictureRow)).withDuration(Duration.ofMillis(1000))).release().perform();
    }

    private static int rand(int bound) {
        return (int) (Math.random() * bound);
    }

}

