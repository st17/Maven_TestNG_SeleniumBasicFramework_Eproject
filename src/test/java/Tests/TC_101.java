package Tests;

import Actions.Campaign_Action;
import Actions.Login_Action;
import Commons.Result_Execls;
import Objects.CreateCustomer1_Object;
import Objects.Excel_Object;
import Objects.Login_Object;
import Pages.Campaign_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_101 {
    String siteURL = "http://113.176.100.130:8081/CRMweb/faces/login.xhtml";
    WebDriver dr;
    //Verify that Moves to Customer List page when user login successfully.
    CreateCustomer1_Object create = new CreateCustomer1_Object();
    @BeforeMethod
    public void First () throws IOException {
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\drivers\\chromedriver.exe");
        Login_Object ob1 = new Login_Object();
        //2. Enter email and password correct
        ob1.setEmail("vyvanviet@gmail.com");
        ob1.setPassword("abc123");
        dr = new ChromeDriver();
        dr.manage().window().maximize();
        dr.get(siteURL);

        //3. Click on Login button.
        Login_Action.enterEmailAndPassword(dr, ob1);
        Login_Action.clickLogin(dr);
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    //Verify that Campaigns dropdown contains these data when clicking on it: Show All Campaigns, Create Campaign, Show All Campaigns Type, Create Campaigns Type
    @Test
    public void dropdownCampaign() throws IOException
    {
        Campaign_Action.clickCampaign(dr);
        Excel_Object ex1 = new Excel_Object();
        if(dr.findElement(By.xpath(Campaign_Page.item1_campaigns)).isDisplayed() == true && dr.findElement(By.xpath(Campaign_Page.item2_campaigns)).isDisplayed()==true
                &&dr.findElement(By.xpath(Campaign_Page.item3_campaigns)).isDisplayed() == true && dr.findElement(By.xpath(Campaign_Page.item4_campaigns)).isDisplayed() == true)
        {
            ex1.setTC_ID("70");
            ex1.setTC_Summary("Verify that Campaigns dropdown contains these data when clicking on it: Show All Campaigns, Create Campaign, Show All Campaigns Type, Create Campaigns Type");
            ex1.setTC_Result("Passed");
            ex1.setTC_Note("TC_101");
        }
        else
        {
            ex1.setTC_ID("70");
            ex1.setTC_Summary("Verify that Campaigns dropdown contains these data when clicking on it: Show All Campaigns, Create Campaign, Show All Campaigns Type, Create Campaigns Type");
            ex1.setTC_Result("Failed");
            ex1.setTC_Note("TC_101");
        }
        Result_Execls.saveResultExcel(ex1);
    }
}
