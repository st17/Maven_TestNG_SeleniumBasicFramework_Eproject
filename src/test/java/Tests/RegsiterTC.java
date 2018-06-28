package Tests;

import Actions.Login_Actions;
import Actions.Regsiter_Actions;
import Commons.Result2Excels;
import Objects.Regsiter_Objects;
import Objects.Users;
import Pages.Regsiter_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RegsiterTC {
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
    public  void RegsiterTC1() throws InterruptedException, IOException {


        dr.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        dr.manage().window().maximize();
        // Navigate to site
        dr.get(SiteURL);
        System.out.println(dr.getTitle());

        Regsiter_Actions.ClickTaoTaiKhoan(dr);

        Regsiter_Objects Reg1 = new Regsiter_Objects();
        Reg1.setTaiKhoan("rtfd");
        Reg1.setMatKhau("");
        Reg1.setNhapLaiMatKhau("ertydf");
        Reg1.setHoTen("erdf");
        Reg1.setSoDienThoai("0932449263");
        dr.findElement(By.xpath(Regsiter_Page.txtGioiTinhNam)).click();
        Reg1.setCMND("892394");
        Reg1.setEmail("cxii@gmail.com");

        Regsiter_Actions.DangKi(dr,Reg1);
        Regsiter_Actions.SubmitDangki(dr);


        Thread.sleep(1000);

        if(dr.getTitle().equals("Ebanking"))
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC01","Verify that login successfully when users clicking \"Đăng nhập\" button","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC01","Verify that login successfully when users clicking \"Đăng nhập\" button","Failed");
        //Check Home page display after login successful
        //   Assert.assertEquals("Ebanking".trim(),dr.getTitle());
        //   Assert.assertEquals(true,dr.findElement(By.xpath(".//a[contains(.,\"Tài khoản\")]")).isDisplayed());
        //   Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/index.xhtml;jsessionid=4565378be1c8470256356789ae6a",dr.getCurrentUrl());

        //End
        dr.close();

    }
}
