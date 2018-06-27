package Actions;

import Pages.Pagination_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pagination_Action {
    public static void clickPaginationNext(WebDriver dr){
        dr.findElement(By.xpath(Pagination_Page.btn_paginationNext)).click();
    }
}
