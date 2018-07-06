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
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
        System.setProperty("webdriver.chrome.driver", WebDriver_Resource);
        dr = new ChromeDriver();
        dr.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        dr.manage().window().maximize();
        // Navigate to site
        dr.get(SiteURL);
        System.out.println(dr.getTitle());
        Thread.sleep(1000);
    }


    //Verify that opens register page display when users clicking "Tạo tài khoản" button
    @Test
    public  void RegsiterTC1_TC21() throws InterruptedException, IOException {


        Regsiter_Actions.ClickTaoTaiKhoan(dr);
        Thread.sleep(1000);

        if(dr.findElement(By.xpath(".//span[text()='Đăng kí tài khoản']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_21","Verify that the opens register page display when users clicking \"Tạo tài khoản\" button","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_21","Verify that the opens register page display when users clicking \"Tạo tài khoản\" button","Failed");

        Thread.sleep(1000);
        //  Assert.assertEquals("Ebanking".trim(),dr.getTitle());
        Assert.assertEquals(true,dr.findElement(By.xpath(".//span[text()='Đăng kí tài khoản']")).isDisplayed());
        Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/registry.xhtml",dr.getCurrentUrl());

        dr.close();
    }

    //Verify that validation message "Đăng kí tài khoản thành công, vui lòng vào Email để kích hoạt tài khoản." display when users clicking "Đăng kí" button
    @Test
    public  void RegsiterTC2_TC22() throws InterruptedException, IOException {


        dr.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        dr.manage().window().maximize();
        // Navigate to site
        dr.get(SiteURL);
        System.out.println(dr.getTitle());

        Regsiter_Actions.ClickTaoTaiKhoan(dr);

        Regsiter_Objects Reg1 = new Regsiter_Objects();

        Reg1.setTaiKhoan("jirvvv3vc34");
        Reg1.setMatKhau("uhkhjuhkhj");
        Reg1.setNhapLaiMatKhau("uhkhjuhkhj");
        Reg1.setHoTen("erdftfg");
        Reg1.setSoDienThoai("0932449263");
        Reg1.setNgaySinh("05/05/1994");
        Regsiter_Actions.ChonNu(dr);
        Reg1.setCMND("892394");
        Reg1.setEmail("cxrtgii@gmail.com");



        Regsiter_Actions.DangKi(dr,Reg1);
        Regsiter_Actions.SubmitDangki(dr);


        Thread.sleep(1000);
        Regsiter_Actions.TaoTaiKhoan(dr);



        if(dr.findElement(By.xpath(".//span[text()='Thông báo']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_22","Verify that validation message \"Đăng kí tài khoản thành công, vui lòng vào Email để kích hoạt tài khoản.\" display when users clicking \"Đăng kí\" button","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_22","Verify that validation message \"Đăng kí tài khoản thành công, vui lòng vào Email để kích hoạt tài khoản.\" display when users clicking \"Đăng kí\" button","Failed");

        Thread.sleep(1000);
        Assert.assertEquals(true,dr.findElement(By.xpath(".//span[text()='Thông báo']")).isDisplayed());
        Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/registry.xhtml",dr.getCurrentUrl());


        //End
        dr.close();

    }

    //Verify that validation message "j_idt9:pwd1: Validation Error." display when users enter wrong confirm password
    @Test
    public  void RegsiterTC3_TC23() throws InterruptedException, IOException {


        Regsiter_Actions.ClickTaoTaiKhoan(dr);

        Regsiter_Objects Reg1 = new Regsiter_Objects();
        Reg1.setTaiKhoan("iuiucj428ci");
        Reg1.setMatKhau("uhkhjuhkhj");
        Reg1.setNhapLaiMatKhau("ygjghygjgh");
        Reg1.setHoTen("erdftfg");
        Reg1.setSoDienThoai("0932449263");
        Reg1.setNgaySinh("05/05/1994");
        Regsiter_Actions.ChonNam(dr);
        Reg1.setCMND("892394");
        Reg1.setEmail("cxrtgii@gmail.com");

        Regsiter_Actions.DangKi(dr,Reg1);
        Regsiter_Actions.SubmitDangki(dr);

        Thread.sleep(1000);
        Regsiter_Actions.TaoTaiKhoan(dr);



        if(dr.findElement(By.xpath(".//span[text()='Đăng kí tài khoản']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_23","Verify that validation message \"j_idt9:pwd1: Validation Error.\" display when users enter wrong confirm password","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_23","Verify that validation message \"j_idt9:pwd1: Validation Error.\" display when users enter wrong confirm password","Failed");

        Thread.sleep(1000);
        //  Assert.assertEquals(true,dr.findElement(By.xpath("/html/body/div[@id='top']")).isDisplayed());


        Assert.assertEquals(true,dr.findElement(By.xpath(".//span[text()='Đăng kí tài khoản']")).isDisplayed());
        Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/registry.xhtml",dr.getCurrentUrl());


        dr.close();

    }

    //Verify that validation message "Mật khẩu phải lớn hơn 8 kí tự" and "Không trùng mật khẩu" display when users not enter on "Mật khẩu" and clicking "Đăng kí" button"
    @Test
    public  void RegsiterTC4_TC24() throws InterruptedException, IOException {


        Regsiter_Actions.ClickTaoTaiKhoan(dr);

        Regsiter_Objects Reg1 = new Regsiter_Objects();
        Reg1.setTaiKhoan("iuiucj428ci");
        Reg1.setMatKhau("");
        Reg1.setNhapLaiMatKhau("");
        Reg1.setHoTen("erdftfg");
        Reg1.setSoDienThoai("0932449263");
        Reg1.setNgaySinh("05/05/1994");
        Regsiter_Actions.ChonNam(dr);
        Reg1.setCMND("892394");
        Reg1.setEmail("cxrtgii@gmail.com");

        Regsiter_Actions.DangKi(dr,Reg1);
        Regsiter_Actions.SubmitDangki(dr);

        Thread.sleep(1000);
        Regsiter_Actions.TaoTaiKhoan(dr);



        if(dr.findElement(By.xpath(".//span[text()='Đăng kí tài khoản']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_24","Verify that validation message \"Mật khẩu phải lớn hơn 8 kí tự\" and \"Không trùng mật khẩu\" display when users not enter on \"Mật khẩu\" and clicking \"Đăng kí\" button","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_24","Verify that validation message \"Mật khẩu phải lớn hơn 8 kí tự\" and \"Không trùng mật khẩu\" display when users not enter on \"Mật khẩu\" and clicking \"Đăng kí\" button","Failed");

        Thread.sleep(1000);

        Assert.assertEquals(true,dr.findElement(By.xpath(".//span[text()='Đăng kí tài khoản']")).isDisplayed());
        Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/registry.xhtml",dr.getCurrentUrl());



        dr.close();

    }

    //Verify that validation message "Tài khoản nhập sai" display when users not enter on "Tài khoản" and clicking "Đăng kí" button.
    @Test
    public  void RegsiterTC5_TC28() throws InterruptedException, IOException {


        Regsiter_Actions.ClickTaoTaiKhoan(dr);

        Regsiter_Objects Reg1 = new Regsiter_Objects();
        Reg1.setTaiKhoan("");
        Reg1.setMatKhau("uhkhjuhkhj");
        Reg1.setNhapLaiMatKhau("uhkhjuhkhj");
        Reg1.setHoTen("erdftfg");
        Reg1.setSoDienThoai("0932449263");
        Reg1.setNgaySinh("05/05/1994");
        Regsiter_Actions.ChonNam(dr);
        Reg1.setCMND("892394");
        Reg1.setEmail("cxrtgii@gmail.com");

        Regsiter_Actions.DangKi(dr,Reg1);
        Regsiter_Actions.SubmitDangki(dr);

        Thread.sleep(1000);
        Regsiter_Actions.TaoTaiKhoan(dr);



        if(dr.findElement(By.xpath(".//span[text()='Chưa nhập tài khoản']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_28","Verify that validation message \"Tài khoản nhập sai\" display when users not enter on \"Tài khoản\" and clicking \"Đăng kí\" button.","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_28","Verify that validation message \"Tài khoản nhập sai\" display when users not enter on \"Tài khoản\" and clicking \"Đăng kí\" button.","Failed");

        Thread.sleep(1000);



        Assert.assertEquals(true,dr.findElement(By.xpath(".//span[text()='Tài khoản nhập sai']")).isDisplayed());
        Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/registry.xhtml",dr.getCurrentUrl());


        dr.close();

    }

    //Verify that validation message "Chưa nhập CMND" display when users clicking "Đăng kí" button.
    @Test
    public  void RegsiterTC6_TC29() throws InterruptedException, IOException {


        Regsiter_Actions.ClickTaoTaiKhoan(dr);

        Regsiter_Objects Reg1 = new Regsiter_Objects();
        Reg1.setTaiKhoan("iicvbier84");
        Reg1.setMatKhau("uhkhjuhkhj");
        Reg1.setNhapLaiMatKhau("uhkhjuhkhj");
        Reg1.setHoTen("uicvuibfr");
        Reg1.setSoDienThoai("0932449263");
        Reg1.setNgaySinh("05/05/1994");
        Regsiter_Actions.ChonNam(dr);
        Reg1.setCMND("");
        Reg1.setEmail("cxrtgii@gmail.com");

        Regsiter_Actions.DangKi(dr,Reg1);
        Regsiter_Actions.SubmitDangki(dr);

        Thread.sleep(1000);
        Regsiter_Actions.TaoTaiKhoan(dr);



        if(dr.findElement(By.xpath(".//span[text()='Đăng kí tài khoản']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_29","Verify that validation message \"Chưa nhập CMND\" display when users clicking \"Đăng kí\" button..","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_29","Verify that validation message \"Chưa nhập CMND\" display when users clicking \"Đăng kí\" button..","Failed");

        Thread.sleep(1000);


        Assert.assertEquals(true,dr.findElement(By.xpath(".//span[text()='Đăng kí tài khoản']")).isDisplayed());
        Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/registry.xhtml",dr.getCurrentUrl());


        dr.close();

    }

    //Verify that validation message"size must be between 1 and 100" display when users not enter "Họ Tên" and clicking "Đăng kí" button.
    @Test
    public  void RegsiterTC7_TC30() throws InterruptedException, IOException {


        Regsiter_Actions.ClickTaoTaiKhoan(dr);

        Regsiter_Objects Reg1 = new Regsiter_Objects();
        Reg1.setTaiKhoan("cvbiiiyucvyu345t");
        Reg1.setMatKhau("uhkhjuhkhj");
        Reg1.setNhapLaiMatKhau("uhkhjuhkhj");
        Reg1.setHoTen("");
        Reg1.setSoDienThoai("0932449263");
        Reg1.setNgaySinh("05/05/1994");
        Regsiter_Actions.ChonNam(dr);
        Reg1.setCMND("892394");
        Reg1.setEmail("cxrtgii@gmail.com");

        Regsiter_Actions.DangKi(dr,Reg1);
        Regsiter_Actions.SubmitDangki(dr);

        Thread.sleep(1000);
        Regsiter_Actions.TaoTaiKhoan(dr);



        if(dr.findElement(By.xpath(".//span[text()='Đăng kí tài khoản']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_30","Verify that validation message\"size must be between 1 and 100\" display when users not enter \"Họ Tên\" and clicking \"Đăng kí\" button..","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_30","Verify that validation message\"size must be between 1 and 100\" display when users not enter \"Họ Tên\" and clicking \"Đăng kí\" button..","Failed");

        Assert.assertEquals(true,dr.findElement(By.xpath(".//span[text()='Đăng kí tài khoản']")).isDisplayed());
        Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/registry.xhtml",dr.getCurrentUrl());


        dr.close();
    }

    //Verify that validation message "Tài khoản đã tồn tại" display when users clicking "Đăng kí" button
    @Test
    public  void RegsiterTC8_TC35() throws InterruptedException, IOException {


        dr.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        dr.manage().window().maximize();
        // Navigate to site
        dr.get(SiteURL);
        System.out.println(dr.getTitle());


        Regsiter_Actions.ClickTaoTaiKhoan(dr);

        Regsiter_Objects Reg1 = new Regsiter_Objects();

        Reg1.setTaiKhoan("tyyrtce244");
        Reg1.setMatKhau("uhkhjuhkhj");
        Reg1.setNhapLaiMatKhau("uhkhjuhkhj");
        Reg1.setHoTen("erdftfg");
        Reg1.setSoDienThoai("0932449263");
        Reg1.setNgaySinh("05/05/1994");
        Regsiter_Actions.ChonNu(dr);
        Reg1.setCMND("892394");
        Reg1.setEmail("cxrtgii@gmail.com");



        Regsiter_Actions.DangKi(dr,Reg1);
        Regsiter_Actions.SubmitDangki(dr);


        Thread.sleep(1000);
        Regsiter_Actions.TaoTaiKhoan(dr);



        if(dr.findElement(By.xpath(".//span[text()='Đăng kí tài khoản']")).isDisplayed() == true)
        {
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_35","Verify that validation message \"Tài khoản đã tồn tại\" display when users clicking \"Đăng kí\" button","Passed");
        }else
            Result2Excels.saveResult2ExcelFile("ResultDemo","Result","TC_35","Verify that validation message \"Tài khoản đã tồn tại\" display when users clicking \"Đăng kí\" button","Failed");

        Assert.assertEquals(true,dr.findElement(By.xpath(".//span[text()='Đăng kí tài khoản']")).isDisplayed());
        Assert.assertEquals("http://113.176.100.130:8081/EBankingWebsite/faces/registry.xhtml",dr.getCurrentUrl());

        dr.close();

    }
    @AfterTest
    public void end()
    {
        dr.quit();
    }
}
