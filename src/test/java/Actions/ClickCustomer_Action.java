package Actions;

import Pages.ClickCustomer_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickCustomer_Action {
    public static void clickCustomer(WebDriver dr){
        dr.findElement(By.xpath(ClickCustomer_Page.btn_Customer)).click();
    }
}
