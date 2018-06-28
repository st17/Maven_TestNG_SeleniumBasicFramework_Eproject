package Action;

import Page.Login_Page;
import Page.Register_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register_Action {
    public static void ClickRegisterlink(WebDriver dr)
    {
        dr.findElement(By.xpath(Register_Page.ClickRegisterlink)).click();
    }
    public static void enterInfomation(WebDriver dr)
    {
        dr.findElement(By.xpath(Register_Page.Taikhoan)).sendKeys();
        dr.findElement(By.xpath(Register_Page.Matkhau)).sendKeys();
        dr.findElement(By.xpath(Register_Page.NhaplaiMK)).sendKeys();
        dr.findElement(By.xpath(Register_Page.Hoten)).sendKeys();
        dr.findElement(By.xpath(Register_Page.Sodienthoai)).sendKeys();
        dr.findElement(By.xpath(Register_Page.Ngaysinh)).sendKeys();
        dr.findElement(By.xpath(Register_Page.GioitinhNu)).click();
        dr.findElement(By.xpath(Register_Page.GioitinhNam)).click();
        dr.findElement(By.xpath(Register_Page.SoCMND)).sendKeys();
        dr.findElement(By.xpath(Register_Page.Email)).sendKeys();
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
