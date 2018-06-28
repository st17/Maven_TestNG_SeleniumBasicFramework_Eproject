package Tests;

import Action.Login_Action;
import Action.Register_Action;
import Commons.ResultExcel;
import Objects.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Testcases {
    String URL = "http://113.176.100.130:8081/EBankingWebsite/";
//    String URL = "http://113.176.100.130:8081/EBankingWebsite/";
    WebDriver dr;
    Users user = new Users();

    @BeforeMethod
    public void Input() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\drivers\\chromedriver.exe");
      //  dr = new ChromeDriver();
        dr = new ChromeDriver();
        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dr.get(URL);
    }

    @Test
    public void TCs1_Login() throws IOException {
        user.setUsername("DiepDo101");
        user.setPassword("1234567890");
        Login_Action.enterUsernameAndPassword(dr, user.getUsername(), user.getPassword());
        Login_Action.ClickLogin(dr);

        if (dr.findElement(By.xpath("//span[text()='THÔNG TIN TÀI KHOẢN']")).isDisplayed()) {
            ResultExcel.SaveResultExcels("Result", "1", "Verify that user login successfully when enter valid 'Tài khoản' and 'Mật khẩu'", "Pass");
        } else {
            ResultExcel.SaveResultExcels("Result", "1", "Verify that user login successfully when enter valid 'Tài khoản' and 'Mật khẩu'", "Fail");
        }

        Assert.assertEquals(true, dr.findElement(By.xpath("//span[text()='THÔNG TIN TÀI KHOẢN']")).isDisplayed());

    }
    @Test
    public void TCs2_Login() throws IOException {
        user.setUsername("");
        user.setPassword("");
        Login_Action.enterUsernameAndPassword(dr, user.getUsername(), user.getPassword());
        Login_Action.ClickLogin(dr);

        if (dr.findElement(By.xpath("//span[text()='CHÀO MỪNG BẠN ĐẾN VỚI EBANKING']")).isDisplayed()) {
            ResultExcel.SaveResultExcels("Result", "2", "Verify that '- Bạn chưa nhập tài khoản. - Bạn chưa nhập Mật khẩu' Error message displays in the upper right corner of the page when user clicks on 'Đăng Nhập' without entering 'Tài Khoản' và'Mật khẩu' fields", "Pass");
        } else {
            ResultExcel.SaveResultExcels("Result", "2", "Verify that '- Bạn chưa nhập tài khoản. - Bạn chưa nhập Mật khẩu' Error message displays in the upper right corner of the page when user clicks on 'Đăng Nhập' without entering 'Tài Khoản' và'Mật khẩu' fields", "Fail");
    }
        Assert.assertEquals(true, dr.findElement(By.xpath("//span[text()='CHÀO MỪNG BẠN ĐẾN VỚI EBANKING']")).isDisplayed());
    }
//
    @Test
    public void TCs3_Login() throws IOException {
        user.setUsername("Diepdo101");
        user.setPassword("");
        Login_Action.enterUsernameAndPassword(dr, user.getUsername(), user.getPassword());
        Login_Action.ClickLogin(dr);

        if (dr.findElement(By.xpath("//span[text()='Bạn chưa nhập mật khẩu']")).isDisplayed()) {
            ResultExcel.SaveResultExcels("Result", "3", "Verify that '- Bạn chưa nhập Mật khẩu.' Error message displays in the upper right corner of the page when enter to only one 'Tài khoản' field and clicking on 'Đăng nhập' button", "Pass");
        } else {
            ResultExcel.SaveResultExcels("Result", "3", "Verify that '- Bạn chưa nhập Mật khẩu.' Error message displays in the upper right corner of the page when enter to only one 'Tài khoản' field and clicking on 'Đăng nhập' button", "Fail");
        }

        Assert.assertEquals(true, dr.findElement(By.xpath("//span[text()='Bạn chưa nhập mật khẩu']")).isDisplayed());
    }

    @Test
    public void TCs4_Login() throws IOException {
        user.setUsername("");
        user.setPassword("1234567890");
        Login_Action.enterUsernameAndPassword(dr, user.getUsername(), user.getPassword());
        Login_Action.ClickLogin(dr);

        if (dr.findElement(By.xpath("//span[text()='Bạn chưa nhập tài khoản']")).isDisplayed()) {
            ResultExcel.SaveResultExcels("Result", "4", "Verify that '- Bạn chưa nhập Tài khoản.' Error message displays in the upper right corner of the page when enter to only one 'Mật khẩu' field and clicking on 'Đăng nhập' button", "Pass");
        } else {
            ResultExcel.SaveResultExcels("Result", "4", "Verify that '- Bạn chưa nhập Tài khoản.' Error message displays in the upper right corner of the page when enter to only one 'Mật khẩu' field and clicking on 'Đăng nhập' button", "Fail");
        }

        Assert.assertEquals(true, dr.findElement(By.xpath("//span[text()='Bạn chưa nhập tài khoản']")).isDisplayed());
}
//
    @Test
    public void TCs5_Login() throws IOException {
        user.setUsername("Diepdo101");
        user.setPassword("12345678");
        Login_Action.enterUsernameAndPassword(dr, user.getUsername(), user.getPassword());
        Login_Action.ClickLogin(dr);

        if (dr.findElement(By.xpath("//span[text()='Sai tài khoản hoặmk']")).isDisplayed()) {
            ResultExcel.SaveResultExcels("Result", "5", "Verify that 'Sai tài khoản hoặc mật khẩu.' Error message displays  in the upper right corner of the page when enter valid 'Tài khoản', invalid 'Mật khẩu' and click on 'Đăng nhập' button", "Pass");
        } else {
            ResultExcel.SaveResultExcels("Result", "5", "Verify that 'Sai tài khoản hoặc mật khẩu.' Error message displays  in the upper right corner of the page when enter valid 'Tài khoản', invalid 'Mật khẩu' and click on 'Đăng nhập' button", "Fail");
        }

        Assert.assertEquals(true, dr.findElement(By.xpath("//span[text()='Sai tài khoản hoặmk']")).isDisplayed());
    }

    @Test
    public void TCs6_Login() throws IOException {
        user.setUsername("Diepd101");
        user.setPassword("1234567890");
        Login_Action.enterUsernameAndPassword(dr, user.getUsername(), user.getPassword());
        Login_Action.ClickLogin(dr);

        if (dr.findElement(By.xpath("//p[text()='Tài khoản không tồn tại ']")).isDisplayed()) {
            ResultExcel.SaveResultExcels("Result", "6", "Verify that' Tài khoản không tồn tại.' Error message displays  in the upper right corner of the page when enter invalid 'Tài khoản', valid 'Mật khẩu' and click on 'Đăng nhập' button", "Pass");
        } else {
            ResultExcel.SaveResultExcels("Result", "6", "Verify that' Tài khoản không tồn tại.' Error message displays  in the upper right corner of the page when enter invalid 'Tài khoản', valid 'Mật khẩu' and click on 'Đăng nhập' button", "Fail");
        }

        Assert.assertEquals(true, dr.findElement(By.xpath("//p[text()='Tài khoản không tồn tại ']")).isDisplayed());
    }

    @Test
    public void TCs7_Login() throws IOException {
        user.setUsername("Diepd101");
        user.setPassword("12345678");
        Login_Action.enterUsernameAndPassword(dr, user.getUsername(), user.getPassword());
        Login_Action.ClickLogin(dr);

        if (dr.findElement(By.xpath("//p[text()='Tài khoản không tồn tại ']")).isDisplayed()) {
            ResultExcel.SaveResultExcels("Result", "7", "Verify that 'Tài khoản không tồn tại' Error message display  in the upper right corner of the page when user enters invalid account and invalid password", "Pass");
        } else {
            ResultExcel.SaveResultExcels("Result", "7", "Verify that 'Tài khoản không tồn tại' Error message display  in the upper right corner of the page when user enters invalid account and invalid password", "Fail");
        }

        Assert.assertEquals(true, dr.findElement(By.xpath("//p[text()='Tài khoản không tồn tại ']")).isDisplayed());
    }

    @Test
    public void TCs8_Register() throws IOException
    {
        Register_Action.ClickRegisterlink(dr);

        if (dr.findElement(By.xpath("//span[text()='Đăng kí tài khoản']")).isDisplayed()) {
            ResultExcel.SaveResultExcels("Result", "8", "Verify that Register page display when user clicks on 'Tạo tài khoản' button", "Pass");
        } else {
            ResultExcel.SaveResultExcels("Result", "8", "Verify that Register page display when user clicks on 'Tạo tài khoản' button", "Fail");
        }

        Assert.assertEquals(true, dr.findElement(By.xpath("//span[text()='Đăng kí tài khoản']")).isDisplayed());

    }

    @Test
    public void TCs9_Register() throws IOException
    {
        Register_Action.ClickRegisterlink(dr);


        if (dr.findElement(By.xpath("//span[text()='Đăng kí tài khoản']")).isDisplayed()) {
            ResultExcel.SaveResultExcels("Result", "9", "Verify that 'Length is less than allowable minimum of '8''Validation Error message display in the upper right corner of the page when user register with account less than 8 characters", "Pass");
        } else {
            ResultExcel.SaveResultExcels("Result", "9", "Verify that 'Length is less than allowable minimum of '8'' Validation Error message display in the upper right corner of the page when user register with account less than 8 characters", "Fail");
        }

        Assert.assertEquals(true, dr.findElement(By.xpath("//span[text()='Đăng kí tài khoản']")).isDisplayed());
    }





    @AfterMethod
    public void End(){dr.quit();}
}
