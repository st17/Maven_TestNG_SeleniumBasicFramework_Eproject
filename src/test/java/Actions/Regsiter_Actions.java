package Actions;

import Objects.Regsiter_Objects;
import Pages.Regsiter_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Regsiter_Actions {

    public static void ClickTaoTaiKhoan(WebDriver dr){
        dr.findElement(By.xpath(Regsiter_Page.TaoTaiKhoan)).click();
    }

    public static void DangKi(WebDriver dr, Regsiter_Objects Reg){
        dr.findElement(By.xpath(Regsiter_Page.txtTaiKhoan)).sendKeys(Reg.getTaiKhoan());
        dr.findElement(By.xpath(Regsiter_Page.txtMatKhau)).sendKeys(Reg.getMatKhau());
        dr.findElement(By.xpath(Regsiter_Page.txtNhapLaiMatKhau)).sendKeys(Reg.getNhapLaiMatKhau());
        dr.findElement(By.xpath(Regsiter_Page.txtHoTen)).sendKeys(Reg.getHoTen());
        dr.findElement(By.xpath(Regsiter_Page.txtSoDienThoai)).sendKeys(Reg.getSoDienThoai());
        dr.findElement(By.xpath(Regsiter_Page.txtNgaySinh)).sendKeys(Reg.getNgaySinh());
        dr.findElement(By.xpath(Regsiter_Page.txtCMND)).sendKeys(Reg.getCMND());
        dr.findElement(By.xpath(Regsiter_Page.txtEmail)).sendKeys(Reg.getEmail());
    }
    public static void SubmitDangki(WebDriver dr){
        dr.findElement(By.xpath(Regsiter_Page.txtDangky)).click();
    }
    public static void TaoTaiKhoan(WebDriver dr){
        dr.findElement(By.xpath(Regsiter_Page.ClickTaoTaiKhoan)).click();
    }
    public static void ChonNam(WebDriver dr) {
        dr.findElement(By.xpath(Regsiter_Page.txtGioiTinhNam)).click();
    }
    public static void ChonNu(WebDriver dr) {
        dr.findElement(By.xpath(Regsiter_Page.txtGioiTinhNu)).click();
    }
}
