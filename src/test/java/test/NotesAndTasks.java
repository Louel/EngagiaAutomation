package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;

public class NotesAndTasks {

    AppiumDriver driver;
    String search = "Not";
    String [] randomTitle = {"Title 1","Title 2","Title 3"};
    String [] randomNote = {"Asdfg!!1","AASDAF!!@@2","_+_+_+_+_3","1_5_8_9_4","123456","notenote", "sendnotes" , "1337", ">:d" , "nOteEDd 0"};
    String titleNoteTask = "TitleNoteTasks";
    String drctryNoteTask = "//android.widget.FrameLayout[@index='0']" +
            "/android.widget.LinearLayout[@index='0']" +
            "/android.widget.FrameLayout[@index='0']" +
            "/android.widget.LinearLayout[@index='0']" +
            "/android.widget.FrameLayout[@index='0']" +
            "/android.support.v4.widget.DrawerLayout[@index='0']" +
            "/android.widget.LinearLayout[@index='0']" +
            "/android.widget.FrameLayout[@index='1']" +
            "/android.view.ViewGroup[@index='0']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.LinearLayout[@index='0']" +
            "/android.support.v7.widget.RecyclerView[@index='0']";



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
        SearcNoteTask();
//        Case1();
//        Case2();
//        Case3();
//        Case4();
//        Case5();
//        Case6();
        Case7();
//        Case8();
//        Case9();
//        Case10();
//        Case11();
//        Case12();
//        Case13();
//        Case14();
//        Case15();
//        Case16();
//        Case17();
//        Case18();
//        Case19();
//        selectCreatedTasks();
//        icLogInToVisit();
    }
    //Cases
    //Check Accessing Notes & Tasks
    public void Case1(){
        SearcNoteTask();
        //Loop
        //Navigate Home and Relaunching Engagia step (Step 6 and 7)
        driver.launchApp();
        //Close app (Step 8)
        driver.closeApp();
        //Open Engagia Again (Step 9)
        driver.launchApp();
        System.out.println("Case 1 Done");
    }
    //Check Notes and Task "Create" button
    public void Case2(){
        SearcNoteTask();
        for(int z = 1; z<=4; z++) {
            //Click Create
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement createNoteTask = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_create_notes_and_tasks') and @text='Create notes or task']");
            createNoteTask.click();
            //Click Cancel
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement cancelBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='Cancel']");
            cancelBtn.click();
        }
        cancelNotes();
        cancelTasks();
        System.out.println("Case 2 Done");
    }
    //Check Notes and Tasks "Alarm"
    public void Case3(){
        for(int z = 1; z<=14; z++) {
            //Notes
            if(z<=2) {
                //Click Create
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement createNoteTask = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_create_notes_and_tasks') and @text='Create notes or task']");
                createNoteTask.click();
                //Click Cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement cancelBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='Cancel']");
                cancelBtn.click();
            }
            else if(z==3){
                selectNotes();
                //Click Alarm Icon
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckAlarm = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_reminder') and @index='1']");
                clckAlarm.click();
                //Click cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'dialog_add_reminder_cancel') and @text='CANCEL']");
                clckCancel.click();
            }
            else if(z==4){
                //Click Alarm Icon
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckAlarm = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_reminder') and @index='1']");
                clckAlarm.click();
                //Click date
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckDate = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'dialog_add_reminder_select_date') and @index='1']");
                clckDate.click();
                //Click today
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckToday = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Today']");
                clckToday.click();
                //Click cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'dialog_add_reminder_cancel') and @text='CANCEL']");
                clckCancel.click();
            }
            else if(z==5){
                //Click Alarm Icon
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckAlarm = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_reminder') and @index='1']");
                clckAlarm.click();
                //Click date
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckDate = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'dialog_add_reminder_select_date') and @index='1']");
                clckDate.click();
                //Click today
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckToday = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Tomorrow']");
                clckToday.click();
                //Click cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'dialog_add_reminder_cancel') and @text='CANCEL']");
                clckCancel.click();
            }
            else if(z==6){
                //Click Alarm Icon
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckAlarm = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_reminder') and @index='1']");
                clckAlarm.click();
                //Click date
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckDate = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'dialog_add_reminder_select_date') and @index='1']");
                clckDate.click();
                //Click today
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckToday = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Pick a date']");
                clckToday.click();
                //Select 8
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckNum8 = (MobileElement) driver.findElementByXPath("//android.view.View[@index='7']");
                clckNum8.click();
                //Click ok
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
                clckOk.click();
                //Click cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'dialog_add_reminder_cancel') and @text='CANCEL']");
                clckCancel.click();
            }
            else if(z==7){
                setAlarmNoteTask();
                //Back
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement back = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
                back.click();
            }
            //Task
            else if(z<=9) {
                //Click Create
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement createNoteTask = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_create_notes_and_tasks') and @text='Create notes or task']");
                createNoteTask.click();
                //Click Cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement cancelBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='Cancel']");
                cancelBtn.click();
            }
            else if(z==10){
                selectTasks();
                //Click Alarm Icon
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckAlarm = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_reminder') and @index='1']");
                clckAlarm.click();
                //Click cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'dialog_add_reminder_cancel') and @text='CANCEL']");
                clckCancel.click();
            }
            else if(z==11){
                //Click Alarm Icon
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckAlarm = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_reminder') and @index='1']");
                clckAlarm.click();
                //Click date
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckDate = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'dialog_add_reminder_select_date') and @index='1']");
                clckDate.click();
                //Click today
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckToday = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Today']");
                clckToday.click();
                //Click cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'dialog_add_reminder_cancel') and @text='CANCEL']");
                clckCancel.click();
            }
            else if(z==12){
                //Click Alarm Icon
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckAlarm = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_reminder') and @index='1']");
                clckAlarm.click();
                //Click date
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckDate = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'dialog_add_reminder_select_date') and @index='1']");
                clckDate.click();
                //Click today
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckToday = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Tomorrow']");
                clckToday.click();
                //Click cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'dialog_add_reminder_cancel') and @text='CANCEL']");
                clckCancel.click();
            }
            else if(z==13){
                //Click Alarm Icon
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckAlarm = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_reminder') and @index='1']");
                clckAlarm.click();
                //Click date
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckDate = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'dialog_add_reminder_select_date') and @index='1']");
                clckDate.click();
                //Click today
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckToday = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Pick a date']");
                clckToday.click();
                //Select 8
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckNum8 = (MobileElement) driver.findElementByXPath("//android.view.View[@index='7']");
                clckNum8.click();
                //Click ok
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
                clckOk.click();
                //Click cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'dialog_add_reminder_cancel') and @text='CANCEL']");
                clckCancel.click();
            }
            else if(z==14){
                setAlarmNoteTask();
                //Back
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement back = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
                back.click();
            }
        }
        System.out.println("Case 3 Done");
    }
    //Check Notes and Tasks "Pin"
    public void Case4(){
        for(int z=1; z<=2; z++) {
            if(z==1) {
                //Select Notes
                selectNotes();
                //Click on pin
                pinNoteTask();
                unpinNoteTask();
                //Back
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement back = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
                back.click();
                System.out.println("Case 4 Notes Done");
            }
            else if(z==2){
                //Select Taks
                selectTasks();
                //Click on pin
                pinNoteTask();
                unpinNoteTask();
                //Back
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement back = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
                back.click();
                System.out.println("Case 4 Tasks Done");
            }
        }
    }
    //Check Create Note Window
    public void Case5(){
        //Selecting Notes
        selectNotes();
        inputNoteTitle();
        inputTitleByEMS();
        inputNote();
        setAlarmNoteTask();
        //Tagging Branch on notes or tasks
        tagBranchInNote();
        pinNoteTask();
        unpinNoteTask();
        pinNoteTask();
        //Back
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement back = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        back.click();
        System.out.println("Note Created");
        System.out.println("Case 5 Done");
    }
    //Check Create Task Window
    public void Case6(){
        //Selecting Notes
        selectTasks();
        inputTaskTitle();
        inputTask();
        setAlarmNoteTask();
        //tagging branch
        tagBranchInTask();
        pinNoteTask();
        unpinNoteTask();
        pinNoteTask();
        //Back
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement back = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        back.click();
        System.out.println("Task saved");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckTitle1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'list_tasks_title') and @text='TitleNoteTasks']");
        clckTitle1.click();
        for(int x=1; x<=3; x++) {
            if(x==1) {
                //Check checkbox
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement check = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[contains(@resource-id,'activity_add_tasks_checkbox') and @index='0']");
                check.click();
                //No
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement btnNo = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='No']");
                btnNo.click();
            }
            else if(x==2) {
                //Check checkbox
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement check = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[contains(@resource-id,'activity_add_tasks_checkbox') and @index='0']");
                check.click();
                //Yes
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement btnYes = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Yes']");
                btnYes.click();
                //Cancel Task Remark
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement btnCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='Cancel']");
                btnCancel.click();
            }
            else if(x==3) {
                //Check checkbox
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement check = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[contains(@resource-id,'activity_add_tasks_checkbox') and @index='0']");
                check.click();
                //Yes
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement btnYes = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Yes']");
                btnYes.click();
                //Add Task Remark
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement txtField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_task_remark') and @index='0']");
                txtField.sendKeys("Task Done!");
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement btnCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Continue']");
                btnCancel.click();
            }
        }
        //Back or save
        back.click();
        System.out.println("Tasks created");
        System.out.println("Case 6 Done");
//        MobileElement clckTitle1 = (MobileElement) driver.findElementByXPath(drctryNoteTask +
//                "/android.widget.FrameLayout[@index='2']" +
//                "/android.widget.LinearLayout[@index='0']");
//        clckTitle1.click();

        //Click task created

//        MobileElement pinnedTxt = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Pinned notes and tasks']");
//        boolean isAppear = pinnedTxt.isDisplayed();
//        while(isAppear){
//            try {
//                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//                MobileElement clckTitle1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'list_tasks_title') and @text='Title 1']");
//                MobileElement clckTitle2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'list_tasks_title') and @text='Title 2']");
//                MobileElement clckTitle3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'list_tasks_title') and @text='Title 3']");
//                boolean isDisplayed1 = clckTitle1.isDisplayed();
//                boolean isDisplayed2 = clckTitle2.isDisplayed();
//                boolean isDisplayed3 = clckTitle3.isDisplayed();
//                if (isDisplayed1 && !isDisplayed2 && !isDisplayed3) {
//                    clckTitle1.click();
//                } else if (isDisplayed2 && !isDisplayed1 && !isDisplayed3) {
//                    clckTitle2.click();
//                } else if (isDisplayed3 && !isDisplayed1 && !isDisplayed2) {
//                    clckTitle3.click();
//                }
//            }
//            catch(NoSuchElementException e){
//                System.out.println("Looking for..");
//                break;
//            }
//        }

    }
    //todo Check Notes and Tasks "View" dapat ilagay to bago mag filter kasi may delete module dito
    public void Case7(){
        //Loop for viewing the created task or note
        for (int z=0; z<=1; z++){
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            List<MobileElement> logBtn = (List<MobileElement>) driver.findElementsByXPath("//android.support.v7.widget.RecyclerView[@index='0']/android.widget.FrameLayout");
            logBtn.get(z).click();
            System.out.println(z);
            //Back
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement back = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
            back.click();
        }
        //Delete note or task by swiping
        //Loop for viewing the created task or note
        List<MobileElement> boxNoteTask = (List<MobileElement>) driver.findElementsByXPath("//android.support.v7.widget.RecyclerView[@index='0']/android.widget.FrameLayout");
//        boxNoteTask.get(1).getCoordinates();

        //swipe to right
//        MobileElement box = (MobileElement) driver.findElementsByXPath("//android.support.v7.widget.RecyclerView[@index='0']/android.widget.FrameLayout[@index='1']");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1')]");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Dimension dim = driver.manage().window().getSize();
            int width = dim.getWidth();
            //Para nasa gilid un pag scroll walang tatamaan textfield
            int x1 = (int) (width * 0.99);
            TouchAction touchAction = new TouchAction(driver);
//     TODO       touchAction.press(boxNoteTask.get(1)).moveTo(new PointOption().withCoordinates(x1, 200)).release().perform();
            touchAction.longPress((PointOption) driver.findElementsByXPath("//android.support.v7.widget.RecyclerView[@index='0']/android.widget.FrameLayout[@index='1']")).moveTo(new PointOption().withCoordinates(x1,200)).release().perform();
//            touchAction.longPress(driver.findElementsByXPath("//android.support.v7.widget.RecyclerView[@index='0']/android.widget.FrameLayout[@index='1']")).moveTo(new PointOption().withCoordinates(x1,200)).release().perform();
//            touchAction.longPress(boxNoteTask).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).moveTo(new PointOption().withCoordinates(x2, 300)).release().perform();
            //try this
//            touchAction.longPress(new PointOption().withCoordinates(x1, 300)).moveTo(new PointOption().withCoordinates(x2, 300)).release().perform();
        }
        System.out.println("Case 7 Done");
    }
    //Check + icon left bottom corner
    public void Case8(){
        selectNotes();
        inputNoteTitle();
        inputNote();
        tagBranchInNote();
        unpinNoteTask();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement back = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        back.click();
        System.out.println("Note saved");
        System.out.println(" >>Case 8 Done");
    }
    //Check "Switch View"
    public void Case9(){
        for(int z=1; z<=2; z++) {
            //Click Option button
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
            optionBtn.click();
            //Click on switch view
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement switchViewBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_switch_view') and @index='0']");
            switchViewBtn.click();
            if(z==1) {
                //Select list
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement listRadioBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='List']");
                listRadioBtn.click();
            }
            else if(z==2){
                //Select list
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement listRadioBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Grid']");
                listRadioBtn.click();
            }
        }
    }
    //Check Filter by "All notes and tasks"
    public void Case10(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='All notes and tasks']");
        allNotesAndTasks.click();
    }
    //Check Filter by "All notes"
    public void Case11(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='All notes']");
        allNotesAndTasks.click();
    }
    //Check Filter by "All tasks"
    public void Case12(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='All tasks']");
        allNotesAndTasks.click();
    }
    //Check Filter by "Accomplished task"
    public void Case13(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Accomplished tasks']");
        allNotesAndTasks.click();
    }
    //Check Filter by "Notes Overdue"
    public void Case14(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Notes overdue']");
        allNotesAndTasks.click();
    }
    //Check Filter by "Task Overdue"
    public void Case15(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Task overdue']");
        allNotesAndTasks.click();
    }
    //Check Filter by "Deleted notes"
    public void Case16(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        swipeDown();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Deleted notes']");
        allNotesAndTasks.click();
    }
    //Check Filter by "Deleted Task"
    public void Case17(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        swipeDown();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Deleted notes']");
        allNotesAndTasks.click();
    }
    //Check Filter by "Reminder Date"
    public void Case18(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        swipeDown();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Deleted tasks']");
        allNotesAndTasks.click();
    }
    //Check "EMS: Accessing Notes and Tasks"
    public void Case19(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        swipeDown();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Reminder date']");
        allNotesAndTasks.click();
        //Pwede palitan value ng index depende kung anong date ittest
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckNum8 = (MobileElement) driver.findElementByXPath("//android.view.View[@index='29']");
        clckNum8.click();
        //Click ok on calendar
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
        clckOk.click();
    }

    //inCase = use this for log in to visit
    //Check Accessing Notes & Tasks
    public void inCase1(){
        SearcNoteTask();
        //Loop
        //Navigate Home and Relaunching Engagia step (Step 6 and 7)
        driver.launchApp();
        //Close app (Step 8)
        driver.closeApp();
        //Open Engagia Again (Step 9)
        driver.launchApp();
        System.out.println(" >>Log in to visit Case 1 Done");
    }
    //Check Notes and Task "Create" button
    public void inCase2(){
        SearcNoteTask();
        for(int z = 1; z<=2; z++) {
            //Click Create
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement createNoteTask = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_create_notes_and_tasks') and @text='Create notes or task']");
            createNoteTask.click();
            //Click Cancel
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement cancelBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='Cancel']");
            cancelBtn.click();
        }
        cancelNotes();
        cancelTasks();


        System.out.println(" >>Log in to visit Case 2 Done");
    }
    //Check Notes and Tasks "Alarm"
    public void inCase3(){
        for(int z = 1; z<=14; z++) {
            //Notes
            if(z<=2) {
                //Click Create
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement createNoteTask = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_create_notes_and_tasks') and @text='Create notes or task']");
                createNoteTask.click();
                //Click Cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement cancelBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='Cancel']");
                cancelBtn.click();
            }
            else if(z==3){
                selectNotes();
                //Click Alarm Icon
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckAlarm = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_reminder') and @index='1']");
                clckAlarm.click();
                //Click cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'dialog_add_reminder_cancel') and @text='CANCEL']");
                clckCancel.click();
            }
            else if(z==4){
                //Click Alarm Icon
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckAlarm = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_reminder') and @index='1']");
                clckAlarm.click();
                //Click date
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckDate = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'dialog_add_reminder_select_date') and @index='1']");
                clckDate.click();
                //Click today
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckToday = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Today']");
                clckToday.click();
                //Click cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'dialog_add_reminder_cancel') and @text='CANCEL']");
                clckCancel.click();
            }
            else if(z==5){
                //Click Alarm Icon
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckAlarm = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_reminder') and @index='1']");
                clckAlarm.click();
                //Click date
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckDate = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'dialog_add_reminder_select_date') and @index='1']");
                clckDate.click();
                //Click today
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckToday = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Tomorrow']");
                clckToday.click();
                //Click cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'dialog_add_reminder_cancel') and @text='CANCEL']");
                clckCancel.click();
            }
            else if(z==6){
                //Click Alarm Icon
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckAlarm = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_reminder') and @index='1']");
                clckAlarm.click();
                //Click date
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckDate = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'dialog_add_reminder_select_date') and @index='1']");
                clckDate.click();
                //Click today
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckToday = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Pick a date']");
                clckToday.click();
                //Select 8
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckNum8 = (MobileElement) driver.findElementByXPath("//android.view.View[@index='7']");
                clckNum8.click();
                //Click ok
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
                clckOk.click();
                //Click cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'dialog_add_reminder_cancel') and @text='CANCEL']");
                clckCancel.click();
            }
            else if(z==7){
                setAlarmNoteTask();
                //Back
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement back = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
                back.click();
            }
            //Task
            else if(z<=9) {
                //Click Create
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement createNoteTask = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_create_notes_and_tasks') and @text='Create notes or task']");
                createNoteTask.click();
                //Click Cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement cancelBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='Cancel']");
                cancelBtn.click();
            }
            else if(z==10){
                selectTasks();
                //Click Alarm Icon
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckAlarm = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_reminder') and @index='1']");
                clckAlarm.click();
                //Click cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'dialog_add_reminder_cancel') and @text='CANCEL']");
                clckCancel.click();
            }
            else if(z==11){
                //Click Alarm Icon
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckAlarm = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_reminder') and @index='1']");
                clckAlarm.click();
                //Click date
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckDate = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'dialog_add_reminder_select_date') and @index='1']");
                clckDate.click();
                //Click today
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckToday = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Today']");
                clckToday.click();
                //Click cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'dialog_add_reminder_cancel') and @text='CANCEL']");
                clckCancel.click();
            }
            else if(z==12){
                //Click Alarm Icon
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckAlarm = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_reminder') and @index='1']");
                clckAlarm.click();
                //Click date
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckDate = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'dialog_add_reminder_select_date') and @index='1']");
                clckDate.click();
                //Click today
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckToday = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Tomorrow']");
                clckToday.click();
                //Click cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'dialog_add_reminder_cancel') and @text='CANCEL']");
                clckCancel.click();
            }
            else if(z==13){
                //Click Alarm Icon
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckAlarm = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_reminder') and @index='1']");
                clckAlarm.click();
                //Click date
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckDate = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'dialog_add_reminder_select_date') and @index='1']");
                clckDate.click();
                //Click today
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckToday = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Pick a date']");
                clckToday.click();
                //Select 8
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckNum8 = (MobileElement) driver.findElementByXPath("//android.view.View[@index='7']");
                clckNum8.click();
                //Click ok
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
                clckOk.click();
                //Click cancel
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement clckCancel = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'dialog_add_reminder_cancel') and @text='CANCEL']");
                clckCancel.click();
            }
            else if(z==14){
                setAlarmNoteTask();
                //Back
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement back = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
                back.click();
            }
        }
        System.out.println(" >>Log in to visit Case 3 Done");
    }
    //Check Notes and Tasks "Pin"
    public void inCase4(){
        for(int z=1; z<=2; z++) {
            if(z==1) {
                //Select Notes
                selectNotes();
                //Click on pin
                pinNoteTask();
                unpinNoteTask();
                //Back
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement back = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
                back.click();
                System.out.println(" >>Case 4 Notes Done");
            }
            else if(z==2){
                //Select Taks
                selectTasks();
                //Click on pin
                pinNoteTask();
                unpinNoteTask();
                //Back
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement back = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
                back.click();
                System.out.println(" >>Case 4 Tasks Done");
            }
        }
    }
    //Check Create Note Window
    public void inCase5(){
        //Selecting Notes
        selectNotes();
        inputNoteTitle();
        inputTitleByEMS();
        inputNote();
        setAlarmNoteTask();
        //Tagging Branch on notes or tasks
        loginTagBranchInNote();
        pinNoteTask();
        unpinNoteTask();
        pinNoteTask();
        //Back
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement back = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        back.click();
        System.out.println("Note saved");
        System.out.println(" >>Log in to visit Case 5 Done");
    }
    //Check Create Task Window
    public void inCase6(){
        selectTasks();
        inputTaskTitle();
        inputTask();
        setAlarmNoteTask();
        //tagging branch
        loginTagBranchInTask();
        pinNoteTask();
        unpinNoteTask();
        pinNoteTask();
        //Back
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement back = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        back.click();
        System.out.println("Task saved");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckTitle1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'list_tasks_title') and @text='TitleNoteTasks']");
        clckTitle1.click();
        for(int x=1; x<=3; x++) {
            //Check checkbox
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement check = (MobileElement) driver.findElementByXPath("//android.widget.CheckBox[contains(@resource-id,'activity_add_tasks_checkbox') and @index='0']");
            check.click();
            if(x==1) {
                //No
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement btnNo = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='No']");
                btnNo.click();
            }
            else if(x==2) {
                //Yes
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement btnYes = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Yes']");
                btnYes.click();
                //Cancel Task Remark
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement btnCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button2') and @text='Cancel']");
                btnCancel.click();
            }
            else if(x==3) {
                //Yes
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement btnYes = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Yes']");
                btnYes.click();
                //Add Task Remark
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement txtField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_task_remark') and @index='0']");
                txtField.sendKeys("Task Done!");
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement btnCancel = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='Continue']");
                btnCancel.click();
            }
        }
        //Back or save
        back.click();
        System.out.println(" >>Log in to visit Case 6 Done");
    }
    //todo Check Notes and Tasks "View"
    public void inCase7(){

    }
    //Check + icon left bottom corner
    public void inCase8(){
        selectNotes();
        inputNoteTitle();
        inputNote();
        loginTagBranchInNote();
        unpinNoteTask();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement back = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        back.click();
        System.out.println("Note saved");
        System.out.println(" >>Log in to visit Case 8 Done");
    }
    //Check "Switch View"
    public void inCase9(){
        for(int z=1; z<=2; z++) {
            //Click Option button
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
            optionBtn.click();
            //Click on switch view
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            MobileElement switchViewBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_switch_view') and @index='0']");
            switchViewBtn.click();
            if(z==1) {
                //Select list
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement listRadioBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='List']");
                listRadioBtn.click();
            }
            else if(z==2){
                //Select list
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement listRadioBtn = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Grid']");
                listRadioBtn.click();
            }
        }
    }
    //Check Filter by "All notes and tasks"
    public void inCase10(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='All notes and tasks']");
        allNotesAndTasks.click();
    }
    //Check Filter by "All notes"
    public void inCase11(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='All notes']");
        allNotesAndTasks.click();
    }
    //Check Filter by "All tasks"
    public void inCase12(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='All tasks']");
        allNotesAndTasks.click();
    }
    //Check Filter by "Accomplished task"
    public void inCase13(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Accomplished tasks']");
        allNotesAndTasks.click();
    }
    //Check Filter by "Notes Overdue"
    public void inCase14(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Notes overdue']");
        allNotesAndTasks.click();
    }
    //Check Filter by "Task Overdue"
    public void inCase15(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Task overdue']");
        allNotesAndTasks.click();
    }
    //Check Filter by "Deleted notes"
    public void inCase16(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        swipeDown();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Deleted notes']");
        allNotesAndTasks.click();
    }
    //Check Filter by "Deleted Task"
    public void inCase17(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        swipeDown();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Deleted notes']");
        allNotesAndTasks.click();
    }
    //Check Filter by "Reminder Date"
    public void inCase18(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        swipeDown();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Deleted tasks']");
        allNotesAndTasks.click();
    }
    //Check "EMS: Accessing Notes and Tasks"
    public void inCase19(){
        //Click Option button
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement optionBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_option') and @index='1']");
        optionBtn.click();
        //Click on filter
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement filterBtn = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_content_notes_and_tasks_main_v2_filter') and @index='1']");
        filterBtn.click();
        swipeDown();
        //Filter by
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement allNotesAndTasks = (MobileElement) driver.findElementByXPath("//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Reminder date']");
        allNotesAndTasks.click();
        //Pwede palitan value ng index depende kung anong date ittest
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckNum29= (MobileElement) driver.findElementByXPath("//android.view.View[@index='29']");
        clckNum29.click();
        //Click ok on calendar
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
        clckOk.click();
    }

    //Functions
    public void SearcNoteTask(){
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
    public void cancelNotes(){
        //Click Create
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement createNoteTask = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_create_notes_and_tasks') and @text='Create notes or task']");
        createNoteTask.click();
        //Click Noes
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement notes = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='0' and @text='Notes']");
        notes.click();
        //Back
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement back = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        back.click();
        System.out.println("Clicking and canceling Notes Done");
    }
    public void cancelTasks(){
        //Click Create
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement createNoteTask = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_create_notes_and_tasks') and @text='Create notes or task']");
        createNoteTask.click();
        //Click Tasks
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement tasks = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='1' and @text='Tasks']");
        tasks.click();
        //Back
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement back = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@index='0']");
        back.click();
        System.out.println("Clicking and canceling Notes Done");
    }
    public void selectNotes(){
        //Click Create
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement createNoteTask = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_create_notes_and_tasks') and @text='Create notes or task']");
        createNoteTask.click();
        //Click Notes
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement notes = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='0' and @text='Notes']");
        notes.click();
        System.out.println("Selecting notes");
    }
    public void selectTasks(){
        //Click Create
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement createNoteTask = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'fragment_notes_and_tasks_main_v2_create_notes_and_tasks') and @text='Create notes or task']");
        createNoteTask.click();
        //Click Tasks
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement tasks = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@index='1' and @text='Tasks']");
        tasks.click();
        System.out.println("Selecting tasks");
    }
    public void setAlarmNoteTask(){
        //Click Alarm Icon
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAlarm = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_reminder') and @index='1']");
        clckAlarm.click();
        //Click date
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckDate = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'dialog_add_reminder_select_date') and @index='1']");
        clckDate.click();
        //Click today
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckToday = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Pick a date']");
        clckToday.click();
        //Pwede palitan value ng index depende kung anong date ittest
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckNum8 = (MobileElement) driver.findElementByXPath("//android.view.View[@index='29']");
        clckNum8.click();
        //Click ok on calendar
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckOk = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @text='OK']");
        clckOk.click();
        //Click time
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckTime = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[contains(@resource-id,'dialog_add_reminder_select_time') and @index='3']");
        clckTime.click();
        //Select Morning
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckMorning = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='0']");
        clckMorning.click();
        //Click time again
        clckTime.click();
        //Select Afternoon
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckAfternoon = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='1']");
        clckAfternoon.click();
        //Click time again
        clckTime.click();
        //Select Evening
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckEvening = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='2']");
        clckEvening.click();
        //Click time again
        clckTime.click();
        //Select Night
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckNight = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='3']");
        clckNight.click();
        clckTime.click();
        //Select Pick Time
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckPickTime = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@index='4']");
        clckPickTime.click();
        //Select Hour
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckPickHr = (MobileElement) driver.findElement(By.xpath("//*[@content-desc='12']"));
        clckPickHr.click();
        //Select Minute
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckPickMin = (MobileElement) driver.findElement(By.xpath("//*[@content-desc='55']"));
        clckPickMin.click();
        //Click ok on time
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckOk2 = (MobileElement) driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'button1') and @index='1']");
        clckOk2.click();
        //Click on save
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckSave = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'dialog_add_reminder_save') and @index='1']");
        clckSave.click();
    }
    public void pinNoteTask(){
        //Click on pin
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckPin = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_pin') and @index='0']");
        clckPin.click();
        System.out.println("Pinning Notes/Tasks");
    }
    public void unpinNoteTask(){
        //Click on pin
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckPin = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'add_notes_or_task_menu_pin') and @index='0']");
        clckPin.click();
        clckPin.click();
        clckPin.click();
        System.out.println("Unpinning Notes/Tasks");
    }
    public void inputNoteTitle(){
        //Input on title
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement title = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'activity_add_notes_note_title') and @index='0']");
//        title.sendKeys(randomTitle[rand(randomTitle.length-1)]);
        title.sendKeys(titleNoteTask);
        driver.hideKeyboard();
    }
    public void inputTaskTitle(){
        //Input on title
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement title = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'activity_add_tasks_tasks_title') and @index='0']");
//        title.sendKeys(randomTitle[rand(randomTitle.length-1)]);
        title.sendKeys(titleNoteTask);
        driver.hideKeyboard();
    }
    public void inputTitleByEMS(){
        switch(rand(3 ) ){
            case 0:
                //Select 3 dots (NAF)
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement titleMenu1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'menu_option') and @index='1']");
                titleMenu1.click();
                //Select title
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement titleNote1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Title_EMS_auto1']");
                titleNote1.click();
                System.out.println("Selected Title: Title_EMS_auto1");
                break;
            case 1:
                //Select 3 dots (NAF)
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement titleMenu2 = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'menu_option') and @index='1']");
                titleMenu2.click();
                //Select title
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement titleNote2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Title_EMS_auto2']");
                titleNote2.click();
                System.out.println("Selected Title: Title_EMS_auto2");
                break;
            case 2:
                //Select 3 dots (NAF)
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement titleMenu3 = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'menu_option') and @index='1']");
                titleMenu3.click();
                //Select title
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                MobileElement titleNote3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Title_EMS_auto3']");
                titleNote3.click();
                System.out.println("Selected Title: Title_EMS_auto3");
                break;
        }
    }
    public void inputNote(){
        //Input on NoteField
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noteField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'activity_add_notes_note_content') and @index='2']");
        noteField.sendKeys(randomNote[rand(randomNote.length-1)]);
        driver.hideKeyboard();
    }
    public void inputTask(){
        //Input on TaskField
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement noteField = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'activity_add_tasks_tasks_content') and @index='1']");
        noteField.sendKeys(randomNote[rand(randomNote.length-1)]);
        driver.hideKeyboard();
    }
    public void tagBranchInNote(){
        //Click on plus icon
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckPlusIcon = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'activity_add_notes_add_menu') and @index='0']");
        clckPlusIcon.click();
        //Select tag account or branches
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement tagAccBrnch = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_add_notes_or_task_add_menu_tagged_branch') and @index='0']");
        tagAccBrnch.click();
        //Search branch
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBranch = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_search') and @index='0']");
        searchBranch.sendKeys("Alfamart Marikina 9Z");
        MobileElement brnchNotFound = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_empty_list') and @text = 'BRANCH NOT FOUND']");
        boolean isDisplayed1 = brnchNotFound.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Branch not found text displayed");
        }
        searchBranch.clear();
        searchBranch.sendKeys("Alfamart Marikina 9");
        driver.hideKeyboard();
        List<MobileElement> branches = (List<MobileElement>) driver.findElementsByClassName("android.widget.RelativeLayout");
        branches.get(0).click();
        MobileElement brnchFound = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[contains(@resource-id, 'chip_tagged_branch')]");
        boolean isDisplayed2 = brnchFound.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Branch tag is displayed");
        }
        else if(!isDisplayed2){
            System.out.println("Branch tag is not displayed");
        }
    }
    public void tagBranchInTask(){
        //Click on plus icon
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckPlusIcon = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'activity_add_tasks_add_menu') and @index='0']");
        clckPlusIcon.click();
        //Select tag account or branches
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement tagAccBrnch = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_add_notes_or_task_add_menu_tagged_branch') and @index='0']");
        tagAccBrnch.click();
        //Search branch
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement searchBranch = (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'text_search') and @index='0']");
        searchBranch.sendKeys("Alfamart Marikina 9Z");
        MobileElement brnchNotFound = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'txt_empty_list') and @text = 'BRANCH NOT FOUND']");
        boolean isDisplayed1 = brnchNotFound.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Branch not found text displayed");
        }
        searchBranch.clear();
        searchBranch.sendKeys("Alfamart Marikina 9");
        driver.hideKeyboard();
        List<MobileElement> branches = (List<MobileElement>) driver.findElementsByClassName("android.widget.RelativeLayout");
        branches.get(0).click();
        MobileElement brnchFound = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[contains(@resource-id, 'chip_tagged_branch')]");
        boolean isDisplayed2 = brnchFound.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Branch tag is displayed");
        }
        else if(!isDisplayed2){
            System.out.println("Branch tag is not displayed");
        }
    }
    public void loginTagBranchInNote(){
        //Click on plus icon
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckPlusIcon = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'activity_add_notes_add_menu') and @index='0']");
        clckPlusIcon.click();
        //Select tag account or branches
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement tagAccBrnch = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_add_notes_or_task_add_menu_tagged_branch') and @index='0']");
        tagAccBrnch.click();
        //SnackBar is displayed?
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement brnchFound = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'snackbar_text') and @text='Please logout first']");
        boolean isDisplayed1 = brnchFound.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Please logout first Snackbar message is displayed");
        }
        else if(!isDisplayed1){
            System.out.println("Please logout first Snackbar message is not displayed");
        }
        //Chip tagged branch is displayed?
        MobileElement taggedBranch = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'chip_tagged_branch')]");
        boolean isDisplayed2 = taggedBranch.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Please logout first Chip tagged branch  is displayed");
        }
        else if(!isDisplayed2){
            System.out.println("Please logout first Chip tagged branch  is not displayed");
        }

    }
    public void loginTagBranchInTask(){
        //Click on plus icon
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckPlusIcon = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'activity_add_tasks_add_menu') and @index='0']");
        clckPlusIcon.click();
        //Select tag account or branches
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement tagAccBrnch = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[contains(@resource-id,'bottom_sheet_add_notes_or_task_add_menu_tagged_branch') and @index='0']");
        tagAccBrnch.click();
        //SnackBar is displayed?
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement brnchFound = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'snackbar_text') and @text='Please logout first']");
        boolean isDisplayed1 = brnchFound.isDisplayed();
        if (isDisplayed1) {
            System.out.println("Please logout first Snackbar message is displayed");
        }
        else if(!isDisplayed1){
            System.out.println("Please logout first Snackbar message is not displayed");
        }
        //Chip tagged branch is displayed?
        MobileElement taggedBranch = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'chip_tagged_branch')]");
        boolean isDisplayed2 = taggedBranch.isDisplayed();
        if (isDisplayed2) {
            System.out.println("Please logout first Chip tagged branch  is displayed");
        }
        else if(!isDisplayed2){
            System.out.println("Please logout first Chip tagged branch  is not displayed");
        }
    }
    public void selectCreatedTasks(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement clckTitle1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'list_tasks_title') and @text='Title 1']");
        clckTitle1.click();
    }
    public void swipeDown() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MobileElement element1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'alertTitle')]");
        boolean isDisplayed1 = element1.isDisplayed();
        if (isDisplayed1) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Dimension dim = driver.manage().window().getSize();
            int width = dim.getWidth();
            //Para nasa gilid un pag scroll walang tatamaan textfield
            int x = (int) (width * 0.25);
            TouchAction touchAction = new TouchAction(driver);
            //try this
            touchAction.longPress(new PointOption().withCoordinates(x, 500)).moveTo(new PointOption().withCoordinates(x, 100)).release().perform();
        }
    }
    public void icLogInToVisit(){
        for (int x = 2; x <=8; x++) {
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            //CLick on drawer
            MobileElement sideBarBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open drawer']");
            sideBarBtn.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //click arrow down
            MobileElement loginVisitBtn = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'image_visit_dropdown') and @index = '3']");
            loginVisitBtn.click();
            //branch list
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
            //Search
//            SearcNoteTask();
            //Insert inCase here
            inCase1();
            inCase2();
            inCase3();
            inCase4();
            inCase5();
            inCase6();
            inCase8();
            inCase9();
            inCase10();
            inCase11();
            inCase12();
            inCase13();
            inCase14();
            inCase15();
            inCase16();
            inCase17();
            inCase18();
            inCase19();
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

    private static int rand(int bound) {
        return (int) (Math.random() * bound);
    }
}
