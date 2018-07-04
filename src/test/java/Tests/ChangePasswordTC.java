package Tests;

import Actions.ChangePass_Actions;
import Actions.Login_Actions;
import Commons.Result2Excels;
import Objects.ChangePass_Objects;
import Objects.Users;
import Pages.ChangePassword_Page;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ChangePasswordTC {
    WebDriver dr;
    String SiteURL = "http://113.176.100.130:8081/EBankingWebsite/";
    Users user1 = new Users();
    int TimeOut = 10;
    String WebDriver_Resource = ".\\src\\test\\drivers\\chromedriver.exe";

    @BeforeMethod
    public void init() throws InterruptedException {
        user1.setUsername("vandai123");
        user1.setPassword("uhkhjuhkhj");

        //System.setProperty("allure.results.directory", "/target");
        System.setProperty("webdriver.chrome.driver", WebDriver_Resource);
        dr = new ChromeDriver();
        dr.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        dr.manage().window().maximize();
        // Navigate to site
        dr.get(SiteURL);
        System.out.println(dr.getTitle());
        Thread.sleep(1000);
    }
    @Test
    public  void ChangePassTC1() throws InterruptedException, IOException {


        Login_Actions.enterUsernameAndPassword(dr,user1.getUsername(),user1.getPassword());
        Login_Actions.clickLoginButton(dr);

        ChangePass_Actions.ClickDoiMatKhau(dr);
        Thread.sleep(1000);



        if(dr.findElement(By.xpath(".//span[text()='Thay đổi mật khẩu']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_10","Verify that opens \"Thay đổi mật khẩu\" page displays when users change password","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_10","Verify that opens \"Thay đổi mật khẩu\" page displays when users change password","Failed");


        Assert.assertEquals(true,dr.findElement(By.xpath(".//span[text()='Thay đổi mật khẩu']")).isDisplayed());
        Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/changepass.xhtml",dr.getCurrentUrl());

        dr.close();

    }
    @Test
    public  void ChangePassTC2() throws InterruptedException, IOException {


        Login_Actions.enterUsernameAndPassword(dr,user1.getUsername(),user1.getPassword());
        Login_Actions.clickLoginButton(dr);

        dr.findElement(By.xpath(ChangePassword_Page.DoiMatkhau)).click();

        ChangePass_Objects Chg1 = new ChangePass_Objects();

        Chg1.setMatKhauCu("uhkhjuhkhj");
        Chg1.setMatKhauMoi("uhkhjuhkhj");
        Chg1.setNhapLaiMatKhauMoi("uhkhjuhkhj");

        ChangePass_Actions.DoiMatKhau(dr,Chg1);
        ChangePass_Actions.SubmitChangePass(dr);
        Thread.sleep(1000);



        if(dr.findElement(By.xpath(".//span[text()='Thông báo']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_12","Verify that validation message \"Đổi mật khẩu thành công\" display when users Clicking \"Đổi mật khẩu\" button.","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_12","Verify that validation message \"Đổi mật khẩu thành công\" display when users Clicking \"Đổi mật khẩu\" button.","Failed");

        Assert.assertEquals(true,dr.findElement(By.xpath(".//span[text()='Thông báo']")).isDisplayed());
        Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/changepass.xhtml",dr.getCurrentUrl());

        dr.close();

    }
    @Test
    public  void ChangePassTC3() throws InterruptedException, IOException {


        Login_Actions.enterUsernameAndPassword(dr,user1.getUsername(),user1.getPassword());
        Login_Actions.clickLoginButton(dr);

        dr.findElement(By.xpath(ChangePassword_Page.DoiMatkhau)).click();

        ChangePass_Objects Chg1 = new ChangePass_Objects();

        Chg1.setMatKhauCu("ertdfg");
        Chg1.setMatKhauMoi("ygjghygjgh");
        Chg1.setNhapLaiMatKhauMoi("ygjghygjgh");

        ChangePass_Actions.DoiMatKhau(dr,Chg1);
        ChangePass_Actions.SubmitChangePass(dr);
        Thread.sleep(1000);



        if(dr.findElement(By.xpath(".//span[text()='Thay đổi mật khẩu']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_13","Verify that validation message \"Mật khẩu cũ không đúng\" display when users Clicking \"Đổi mật khẩu\" button","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_13","Verify that validation message \"Mật khẩu cũ không đúng\" display when users Clicking \"Đổi mật khẩu\" button","Failed");

        Assert.assertEquals(true,dr.findElement(By.xpath(".//span[text()='Thay đổi mật khẩu']")).isDisplayed());
        Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/changepass.xhtml",dr.getCurrentUrl());

        dr.close();

    }
    @Test
    public  void ChangePassTC4() throws InterruptedException, IOException {


        Login_Actions.enterUsernameAndPassword(dr,user1.getUsername(),user1.getPassword());
        Login_Actions.clickLoginButton(dr);

        dr.findElement(By.xpath(ChangePassword_Page.DoiMatkhau)).click();

        ChangePass_Objects Chg1 = new ChangePass_Objects();

        Chg1.setMatKhauCu("");
        Chg1.setMatKhauMoi("ygjghygjgh");
        Chg1.setNhapLaiMatKhauMoi("ygjghygjgh");

        ChangePass_Actions.DoiMatKhau(dr,Chg1);
        ChangePass_Actions.SubmitChangePass(dr);
        Thread.sleep(1000);



        if(dr.findElement(By.xpath(".//span[text()='Chưa nhập mật khẩu']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_14","Verify that validation message \"Mật khẩu cũ không đúng\" display when users not enter on \"Mật khẩu cũ\" and clicking \"Đổi mật khẩu\" button","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_14","Verify that validation message \"Mật khẩu cũ không đúng\" display when users not enter on \"Mật khẩu cũ\" and clicking \"Đổi mật khẩu\" button","Failed");

        Assert.assertEquals(true,dr.findElement(By.xpath(".//span[text()='Thay đổi mật khẩu']")).isDisplayed());
        Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/changepass.xhtml",dr.getCurrentUrl());

        dr.close();

    }
    @Test
    public  void ChangePassTC5() throws InterruptedException, IOException {


        Login_Actions.enterUsernameAndPassword(dr,user1.getUsername(),user1.getPassword());
        Login_Actions.clickLoginButton(dr);

        dr.findElement(By.xpath(ChangePassword_Page.DoiMatkhau)).click();

        ChangePass_Objects Chg1 = new ChangePass_Objects();


        Chg1.setMatKhauCu("uhkhjuhkhj");
        Chg1.setMatKhauMoi("");
        Chg1.setNhapLaiMatKhauMoi("ygjghygjgh");

        ChangePass_Actions.DoiMatKhau(dr,Chg1);
        ChangePass_Actions.SubmitChangePass(dr);
        Thread.sleep(1000);



        if(dr.findElement(By.xpath(".//span[text()='Thay đổi mật khẩu']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_15","Verify that validation message \"Mật khẩu phải lớn hơn 8 kí tự\" display when users not enter on \"Mật khẩu mới\" and clicking \"Đổi mật khẩu\" button","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_15","Verify that validation message \"Mật khẩu phải lớn hơn 8 kí tự\" display when users not enter on \"Mật khẩu mới\" and clicking \"Đổi mật khẩu\" button","Failed");

        Assert.assertEquals(true,dr.findElement(By.xpath(".//span[text()='Thay đổi mật khẩu']")).isDisplayed());
        Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/changepass.xhtml",dr.getCurrentUrl());
        dr.close();

    }
    @Test
    public  void ChangePassTC6() throws InterruptedException, IOException {


        Login_Actions.enterUsernameAndPassword(dr,user1.getUsername(),user1.getPassword());
        Login_Actions.clickLoginButton(dr);

        dr.findElement(By.xpath(ChangePassword_Page.DoiMatkhau)).click();

        ChangePass_Objects Chg1 = new ChangePass_Objects();


        Chg1.setMatKhauCu("");
        Chg1.setMatKhauMoi("");
        Chg1.setNhapLaiMatKhauMoi("");

        ChangePass_Actions.DoiMatKhau(dr,Chg1);
        ChangePass_Actions.SubmitChangePass(dr);
        Thread.sleep(1000);



        if(dr.findElement(By.xpath(".//span[text()='Thay đổi mật khẩu']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_16","Verify that validation message \"Mật khẩu phải lớn hơn 8 kí tự\" and \"không trùng mật khẩu\"  display when users clicking \"Đổi mật khẩu\" button","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_16","Verify that validation message \"Mật khẩu phải lớn hơn 8 kí tự\" and \"không trùng mật khẩu\"  display when users clicking \"Đổi mật khẩu\" button","Failed");

        Assert.assertEquals(true,dr.findElement(By.xpath(".//span[text()='Thay đổi mật khẩu']")).isDisplayed());
        Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/changepass.xhtml",dr.getCurrentUrl());
        dr.close();

    }
    @Test
    public  void ChangePassTC7() throws InterruptedException, IOException {


        Login_Actions.enterUsernameAndPassword(dr,user1.getUsername(),user1.getPassword());
        Login_Actions.clickLoginButton(dr);

        dr.findElement(By.xpath(ChangePassword_Page.DoiMatkhau)).click();

        ChangePass_Objects Chg1 = new ChangePass_Objects();


        Chg1.setMatKhauCu("uhkhjuhkhj");
        Chg1.setMatKhauMoi("ygjghygjgh");
        Chg1.setNhapLaiMatKhauMoi("tyurtyufgh");

        ChangePass_Actions.DoiMatKhau(dr,Chg1);
        ChangePass_Actions.SubmitChangePass(dr);
        Thread.sleep(1000);



        if(dr.findElement(By.xpath(".//span[text()='Confirm password wrong']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_18","Verify that validation message \"j_idt24:pwd1: Validation Error.\" display when users clicking \"Đổi mật khẩu\" button","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_18","Verify that validation message \"j_idt24:pwd1: Validation Error.\" display when users clicking \"Đổi mật khẩu\" button","Failed");

        Assert.assertEquals(true,dr.findElement(By.xpath(".//span[text()='Thay đổi mật khẩu']")).isDisplayed());
        Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/changepass.xhtml",dr.getCurrentUrl());
        dr.close();

    }
    @AfterTest
    public void end()
    {
        dr.quit();
    }
}
