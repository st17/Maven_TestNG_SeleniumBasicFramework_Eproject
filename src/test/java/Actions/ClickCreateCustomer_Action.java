package Actions;

import Pages.ClickCreateCustomer_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickCreateCustomer_Action {
    public static void clickCreateCustomer(WebDriver dr){
        dr.findElement(By.xpath(ClickCreateCustomer_Page.btn_Create)).click();
    }
}
