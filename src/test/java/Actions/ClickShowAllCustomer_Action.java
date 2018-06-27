package Actions;

import Objects.ClickShowAllCustomer_Object;
import Pages.ClickShowAllCustomer_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickShowAllCustomer_Action {

    public static void clickShowAllCustomer(WebDriver dr){
        dr.findElement(By.xpath(ClickShowAllCustomer_Page.btn_Show)).click();
    }
    public static void clickName(WebDriver dr){
        dr.findElement(By.xpath(ClickShowAllCustomer_Page.btn_name)).click();
    }
    public static void enterName(ClickShowAllCustomer_Object ob1, WebDriver dr){
        dr.findElement(By.xpath(ClickShowAllCustomer_Page.txt_name)).sendKeys(ob1.getName());
    }
}
