package Action;

import Objects.Register;
import Page.Login_Page;
import Page.Register_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register_Action {
    public static void ClickRegisterlink(WebDriver dr)
    {
        dr.findElement(By.xpath(Register_Page.ClickRegisterlink)).click();
    }
    public static void enterInfomation(WebDriver dr, Register register)
    {
        dr.findElement(By.xpath(Register_Page.Taikhoan)).sendKeys(register.getTaikhoan());
        dr.findElement(By.xpath(Register_Page.Matkhau)).sendKeys(register.getMatkhau());
        dr.findElement(By.xpath(Register_Page.NhaplaiMK)).sendKeys(register.getNhaplaiMK());
        dr.findElement(By.xpath(Register_Page.Hoten)).sendKeys(register.getHoten());
        dr.findElement(By.xpath(Register_Page.Sodienthoai)).sendKeys(register.getSodienthoai());
        dr.findElement(By.xpath(Register_Page.Ngaysinh)).sendKeys(register.getNgaysinh());
        dr.findElement(By.xpath(Register_Page.SoCMND)).sendKeys(register.getSoCMND());
        dr.findElement(By.xpath(Register_Page.Email)).sendKeys(register.getEmail());
    }
    public static void ClickGTnu (WebDriver dr)
    {
        dr.findElement(By.xpath(Register_Page.GioitinhNu)).click();
    }
    public static void ClickGTnam (WebDriver dr)
    {
        dr.findElement(By.xpath(Register_Page.GioitinhNam)).click();
    }
    public static void ClickDangkyButton (WebDriver dr)
    {
        dr.findElement(By.xpath(Register_Page.ClickDangkyBt)).click();
    }
    public static void ClickTaoTKButton (WebDriver dr)
    {
        dr.findElement(By.xpath(Register_Page.ClickTaotaikhoanBt)).click();
    }
}
