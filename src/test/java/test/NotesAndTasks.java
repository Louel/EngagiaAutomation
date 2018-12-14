package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;

public class NotesAndTasks {

    AppiumDriver driver;
    String search = "Not";

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
        Case3();
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
                cancelNotes();
            }
            else if(z==4){
                cancelTasks();
            }
        }
        System.out.println("Case 2 Done");
    }
    //Check Notes and Tasks "Alarm"
    public void Case3(){
        for(int z = 1; z<=7; z++) {
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
                //Click ok
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
            }

        }
        System.out.println("Case 3 Done");
    }
    //Check Notes and Tasks "Pin"
    public void Case4(){

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
        System.out.println("Clicking Notes Done");
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
        System.out.println("Clicking Notes Done");
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
    }
}
