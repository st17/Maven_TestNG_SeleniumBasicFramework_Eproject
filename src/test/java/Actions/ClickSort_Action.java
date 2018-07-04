package Actions;


import Pages.ClickSort_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickSort_Action {
    public static void clickSort(WebDriver dr){
        dr.findElement(By.xpath(ClickSort_Page.btn_sort)).click();
    }
}
