package Tests;

import Actions.Login_Action;
import Commons.Result_Execls;
import Objects.CreateCustomer1_Object;
import Objects.Excel_Object;
import Objects.Login_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Login {
    String siteURL = "http://113.176.100.130:8081/CRMweb/faces/login.xhtml";
    WebDriver dr;
    //Verify that error message ' Please enter your email' displays when user leave Email field blank
    @Test
    public void dangnhap1() throws IOException {
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\drivers\\chromedriver.exe");

        Login_Object ob2 = new Login_Object();
        //2. Leave Email field blank
        ob2.setEmail("");
        //3. Enter password.
        ob2.setPassword("abc123");
        dr = new ChromeDriver();
        dr.get(siteURL);

        //4. Click Login button.
        Login_Action.enterEmailAndPassword(dr, ob2);
        Login_Action.clickLogin(dr);

        Excel_Object ex = new Excel_Object();
        if (dr.findElement(By.xpath(".//span[text()='Please enter your email']")).isDisplayed() == true) {
            ex.setTC_ID("6");
            ex.setTC_Summary("Verify that error message ' Please enter your email' displays when user leave Email field blank");
            ex.setTC_Result("Passed");
            ex.setTC_Note("TC_01");
        } else {
            ex.setTC_ID("6");
            ex.setTC_Summary("Verify that error message ' Please enter your email' displays when user leave Email field blank");
            ex.setTC_Result("Failed");
            ex.setTC_Note("TC_01");
        }

        //Result_Execls.saveResultExcel(ex);
    }

    //Verify that Error message " The Email  or Password is incorrect !" displays when user login with incorrect Username or Password.
    @Test
    public void dangnhap2() throws IOException{
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\drivers\\chromedriver.exe");

        Login_Object ob2 = new Login_Object();
        //2. Enter email and password is incorrect
        ob2.setEmail("vyvanviet@gmail.com");
        ob2.setPassword("aab123");
        dr = new ChromeDriver();
        dr.get(siteURL);

        //3. Click on Login button.
        Login_Action.enterEmailAndPassword(dr, ob2);
        Login_Action.clickLogin(dr);

        Excel_Object ex = new Excel_Object();
        if (dr.findElement(By.xpath(".//p[text()='The email or password is incorrect!']")).isDisplayed() == true) {
            ex.setTC_ID("7");
            ex.setTC_Summary("Verify that Error message \" The Email  or Password is incorrect !\" displays when user login with incorrect Username or Password");
            ex.setTC_Result("Passed");
            ex.setTC_Note("TC_04");
        } else {
            ex.setTC_ID("7");
            ex.setTC_Summary("Verify that Error message \" The Email  or Password is incorrect !\" displays when user login with incorrect Username or Password");
            ex.setTC_Result("Failed");
            ex.setTC_Note("TC_04");
        }

        //Result_Execls.saveResultExcel(ex);
    }
    //Verify that Moves to Customer List page when user login successfully.
    CreateCustomer1_Object create = new CreateCustomer1_Object();
    @Test
    public void First () throws IOException{
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

        Excel_Object ex = new Excel_Object();
        if (dr.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div[2]/div/div/div/div[2]")).isDisplayed() == true) {
            ex.setTC_ID("8");
            ex.setTC_Summary("Verify that Moves to Customer List page when user login successfully.");
            ex.setTC_Result("Passed");
            ex.setTC_Note("TC_03");
        } else {
            ex.setTC_ID("8");
            ex.setTC_Summary("Verify that Moves to Customer List page when user login successfully.");
            ex.setTC_Result("Failed");
            ex.setTC_Note("TC_03");
        }

        //Result_Execls.saveResultExcel(ex);

    }
}

