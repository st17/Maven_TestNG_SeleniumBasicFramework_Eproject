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

    WebDriver dr;
    String SiteURL = "http://demo.guru99.com/V1/index.php";
    Users user1 = new Users();
    int TimeOut = 10;
    String WebDriver_Resource = ".\\src\\test\\drivers\\chromedriver.exe";

    @BeforeMethod
    public void init() throws InterruptedException {
        user1.setUsername("mngr138445");
        user1.setPassword("tujAsUb");

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

        /*BankLogin_Page.enterUsernameAndPassword(dr,user1.getUsername(),user1.getPassword());
        BankLogin_Page.clickLoginButton(dr);*/

        Login_Actions.enterUsernameAndPassword(dr,user1.getUsername(),user1.getPassword());
        Login_Actions.clickLoginButton(dr);

        if(dr.getTitle().equals("GTPL Bank Manager HomePage"))
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC01","Verify user can login with valid username and password","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC01","Verify user can login with valid username and password","Failed");
        //Check Home page display after login successful
        Assert.assertEquals(" GTPL Bank Manager HomePage ".trim(),dr.getTitle());
        Assert.assertEquals(true,dr.findElement(By.xpath(".//a[@href='addcustomerpage.php']")).isDisplayed());
        Assert.assertEquals("http://demo.guru99.com/V1/html/Managerhomepage.php",dr.getCurrentUrl());

        //End
        dr.close();

    }

    //Verify user cannot loggin with invalid username and password
//    @Test
//    public  void LoginTC2() throws InterruptedException {
//
//        /*BankLogin_Page.enterUsernameAndPassword(dr,user1.getUsername(),user1.getPassword()+"_wrong");
//        BankLogin_Page.clickLoginButton(dr);*/
//
//        Login_Actions.enterUsernameAndPassword(dr,user1.getUsername(),user1.getPassword()+"_wrong");
//        Login_Actions.clickLoginButton(dr);
//
//        Alert alert = dr.switchTo().alert();
//
//        Assert.assertEquals("User is not valid",alert.getText());
//
//        alert.accept();
//        dr.switchTo().defaultContent();
//
//        //Check Home page display after login successful
//        Assert.assertEquals(" GTPL Bank Home Page ".trim(),dr.getTitle());
//        Assert.assertEquals(true,dr.findElement(By.xpath(".//input[@name='uid']")).isDisplayed());
//        Assert.assertEquals("http://demo.guru99.com/V1/index.php",dr.getCurrentUrl());
//
//        //End
//        dr.close();
//
//    }

    @AfterTest
    public void end()
    {
        dr.quit();
    }
}
