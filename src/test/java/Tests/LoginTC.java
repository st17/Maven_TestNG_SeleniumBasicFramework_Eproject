package Tests;

import Actions.Login_Actions;
import Commons.Result2Excels;
import Objects.Users;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;


public class LoginTC {
    ///dsdsdsxfcxc
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
    public  void LoginTC1() throws InterruptedException, IOException {



        Login_Actions.enterUsernameAndPassword(dr, user1.getUsername(), user1.getPassword());
        Login_Actions.clickLoginButton(dr);

        Thread.sleep(1000);

        if(dr.findElement(By.xpath(".//span[text()='THÔNG TIN TÀI KHOẢN']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_01","Verify that login successfully when users clicking \"Đăng nhập\" button","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_01","Verify that login successfully when users clicking \"Đăng nhập\" button","Failed");


        Assert.assertEquals(true,dr.findElement(By.xpath(".//span[text()='THÔNG TIN TÀI KHOẢN']")).isDisplayed());
        //   Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/index.xhtml",dr.getCurrentUrl());




        //End
        dr.close();

    }

    //Verify user cannot loggin with invalid username and password
    @Test
    public  void LoginTC2() throws InterruptedException, IOException {

        /*BankLogin_Page.enterUsernameAndPassword(dr,user1.getUsername(),user1.getPassword());
        BankLogin_Page.clickLoginButton(dr);*/

        Login_Actions.enterUsernameAndPassword(dr,user1.getUsername(),user1.getPassword());
        Login_Actions.clickLoginButton(dr);

        Thread.sleep(1000);

        if(dr.findElement(By.xpath(".//span[text()='THÔNG TIN TÀI KHOẢN']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_02","Verify that the opens \"THÔNG TIN TÀI KHOẢN\" page display when users login successfully system","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_02","Verify that the opens \"THÔNG TIN TÀI KHOẢN\" page display when users login successfully system","Failed");


        Assert.assertEquals(true,dr.findElement(By.xpath(".//span[text()='THÔNG TIN TÀI KHOẢN']")).isDisplayed());
        //   Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/index.xhtml",dr.getCurrentUrl());

        //End
        dr.close();

    }


    @Test
    public  void LoginTC3() throws InterruptedException, IOException {

        user1.setUsername("rtyfgh");
        user1.setPassword("uhkhjuhkhj");

        //System.setProperty("allure.results.directory", "/target");
        // System.setProperty("webdriver.chrome.driver", WebDriver_Resource);
        // dr = new ChromeDriver();
        dr.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        dr.manage().window().maximize();
        // Navigate to site
        dr.get(SiteURL);
        System.out.println(dr.getTitle());

        Login_Actions.enterUsernameAndPassword(dr,user1.getUsername(),user1.getPassword());
        Login_Actions.clickLoginButton(dr);

        Thread.sleep(1000);

        if(dr.findElement(By.xpath(".//p[text()='Tài khoản không tồn tại ']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_03","Verify that validation message \"Tài khoản không tồn tại\" display when users login with enter username and password","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_03","Verify that validation message \"Tài khoản không tồn tại\" display when users login with enter username and password","Failed");

        Assert.assertEquals(true,dr.findElement(By.xpath(".//p[text()='ĐĂNG NHẬP']")).isDisplayed());
        //   Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/index.xhtml",dr.getCurrentUrl());

        //End
        dr.close();

    }
    @Test
    public  void LoginTC4() throws InterruptedException, IOException {

        user1.setUsername("");
        user1.setPassword("rtyfg");

        //System.setProperty("allure.results.directory", "/target");
        // System.setProperty("webdriver.chrome.driver", WebDriver_Resource);
        // dr = new ChromeDriver();
        dr.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        dr.manage().window().maximize();
        // Navigate to site
        dr.get(SiteURL);
        System.out.println(dr.getTitle());

        Login_Actions.enterUsernameAndPassword(dr,user1.getUsername(),user1.getPassword());
        Login_Actions.clickLoginButton(dr);

        Thread.sleep(1000);

        if(dr.findElement(By.xpath(".//span[text()='Bạn chưa nhập tài khoản']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_04","Verify that validation message \"Bạn chưa nhập tài khoản\" display when user login with password","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_04","Verify that validation message \"Bạn chưa nhập tài khoản\" display when user login with password","Failed");

        Assert.assertEquals(true,dr.findElement(By.xpath(".//p[text()='ĐĂNG NHẬP']")).isDisplayed());
        //   Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/index.xhtml",dr.getCurrentUrl());


        dr.close();
    }
    @Test
    public  void LoginTC5() throws InterruptedException, IOException {

        user1.setUsername("rtyrtfg");
        user1.setPassword("");

        //System.setProperty("allure.results.directory", "/target");
        // System.setProperty("webdriver.chrome.driver", WebDriver_Resource);
        // dr = new ChromeDriver();
        dr.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        dr.manage().window().maximize();
        // Navigate to site
        dr.get(SiteURL);
        System.out.println(dr.getTitle());

        Login_Actions.enterUsernameAndPassword(dr,user1.getUsername(),user1.getPassword());
        Login_Actions.clickLoginButton(dr);

        Thread.sleep(1000);

        if(dr.findElement(By.xpath(".//span[text()='Bạn chưa nhập mật khẩu']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_05","Verify that validation message \"Bạn chưa nhập mật khẩu\" display when user login with username","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_05","Verify that validation message \"Bạn chưa nhập mật khẩu\" display when user login with username","Failed");

        Assert.assertEquals(true,dr.findElement(By.xpath(".//p[text()='ĐĂNG NHẬP']")).isDisplayed());
        //    Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/index.xhtml",dr.getCurrentUrl());


        dr.close();
    }
    @AfterTest
    public void end()
    {
        dr.quit();
    }
}