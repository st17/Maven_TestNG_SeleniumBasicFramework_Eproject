package Actions;

import Objects.EditCustomer_Object;
import Pages.EditCustomer_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditCustomer_Action {
    public static void clickEdit(WebDriver dr){
        dr.findElement(By.xpath(EditCustomer_Page.btn_edit)).click();
    }
    public static void enterCustomer(WebDriver dr, EditCustomer_Object ob1){
        dr.findElement(By.xpath(EditCustomer_Page.txt_Name)).sendKeys(ob1.getName());
        dr.findElement(By.xpath(EditCustomer_Page.txt_Email)).sendKeys(ob1.getEmail());
        dr.findElement(By.xpath(EditCustomer_Page.txt_Address)).sendKeys(ob1.getAddress());
        dr.findElement(By.xpath(EditCustomer_Page.txt_Phone)).sendKeys(ob1.getPhone());
    }
    public static void clickSave(WebDriver dr){
        dr.findElement(By.xpath(EditCustomer_Page.btn_Save)).click();
    }
}
