package Actions;

import Pages.PaginationEnd_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginationEnd_Action {
    public static void clickPaginationEnd(WebDriver dr){
        dr.findElement(By.xpath(PaginationEnd_Page.btn_End)).click();
    }
}
