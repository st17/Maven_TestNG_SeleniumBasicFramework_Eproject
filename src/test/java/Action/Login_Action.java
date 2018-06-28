package Action;

import Page.Login_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Action {
    public static void enterUsernameAndPassword(WebDriver dr, String username, String password ){
        dr.findElement(By.xpath(Login_Page.txtUsername)).sendKeys(username);
        dr.findElement(By.xpath(Login_Page.txtPassword)).sendKeys(password);
    }
    public static void ClickLogin(WebDriver dr){
        dr.findElement(By.xpath(Login_Page.ClickLogin)).click();
    }

}
