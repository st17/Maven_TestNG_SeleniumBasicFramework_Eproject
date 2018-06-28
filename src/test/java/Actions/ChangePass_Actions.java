package Actions;

import Objects.ChangePass_Objects;
import Pages.ChangePassword_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ChangePass_Actions {
    public static void DoiMatKhau(WebDriver dr, ChangePass_Objects Chg) {
        dr.findElement(By.xpath(ChangePassword_Page.txtMatkhauCu)).sendKeys(Chg.getMatKhauCu());
        dr.findElement(By.xpath(ChangePassword_Page.txtMatKhauMoi)).sendKeys(Chg.getMatKhauMoi());
        dr.findElement(By.xpath(ChangePassword_Page.txtNhapLaiMatKhauMoi)).sendKeys(Chg.getNhapLaiMatKhauMoi());

    }

    public static void SubmitChangPass(WebDriver dr) {
        dr.findElement(By.xpath(ChangePassword_Page.txtChangPass)).click();
    }

}