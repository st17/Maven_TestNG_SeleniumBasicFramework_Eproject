package Actions;

import Pages.MoTaikhoan_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Creatacc_Actions {
    public static void chontaikhoademo (WebDriver wd ) {
        wd.findElement(By.xpath(MoTaikhoan_Page.chontaikhoan)).click();
        }
    public static void clickmotaikhoan (WebDriver wd)
    {
        wd.findElement(By.xpath(MoTaikhoan_Page.taotaikhoan)).click();

        }
    public static void chonmotaikhoan(WebDriver wd){
        wd.findElement(By.xpath(MoTaikhoan_Page.motaikhoan)).click();

    }
    public static void taikhoaantietkiem(WebDriver wd){
        wd.findElement(By.xpath(MoTaikhoan_Page.taikhoantietkiem)).click();

    }

}
