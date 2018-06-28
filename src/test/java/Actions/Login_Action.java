package Actions;

import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Action {
    public static void inputUsernameAndPassword(WebDriver dr, String username, String password){
        dr.findElement(By.xpath(HomePage.xpUserName)).sendKeys(username);
        dr.findElement(By.xpath(HomePage.xpPassword)).sendKeys(password);
    }
    public static void clickOnLogin(WebDriver dr){
        dr.findElement(By.xpath(HomePage.xpLogin)).click();
    }
    public static void clickOnLoginBtn(WebDriver dr){
        dr.findElement(By.xpath(HomePage.xpLoginBtn)).click();
        dr.findElement(By.xpath(HomePage.xpLoginBtn)).click();
    }
}
