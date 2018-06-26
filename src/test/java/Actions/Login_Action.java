package Actions;

import Objects.Login_Object;
import Pages.Login_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Action {
    public static void enterEmailAndPassword(WebDriver dr, Login_Object ob1)
    {
        dr.findElement(By.xpath(Login_Page.txtEmail)).sendKeys(ob1.getEmail());
        dr.findElement(By.xpath(Login_Page.txtPassword)).sendKeys(ob1.getPassword());
    }
    public static void clickLogin(WebDriver dr)
    {
        dr.findElement(By.xpath(Login_Page.btnLogin)).click();
    }
}
