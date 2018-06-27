package Actions;

import Pages.DetailCustomer_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailCustomer_Action {
    public static void clickACustomer(WebDriver dr){
        dr.findElement(By.xpath(DetailCustomer_Page.btn_select)).click();
    }
}
