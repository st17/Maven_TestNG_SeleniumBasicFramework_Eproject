package Tests;

import Actions.Login_Action;
import Pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CustomerTC {
    public static void main(String args[]){
        System.setProperty("webdriver.chrome.driver",".\\src\\test\\drivers\\chromedriver.exe");
        WebDriver dr = new ChromeDriver();
        String pageURL = "http://mobile.myvnc.com";
        dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        dr.get(pageURL);
//        Login_Action.clickOnLogin(dr);
//        Login_Action.inputUsernameAndPassword(dr,"tranthang212@gmail.com","123123");
//        Login_Action.clickOnLoginBtn(dr);
        dr.findElement(By.xpath(HomePage.xpSearch)).click();

    }
}
