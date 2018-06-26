package Actions;

import Objects.CreateCustomer1_Object;
import Pages.CreateCustomer1_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateCustomer1_Action {
    public static void enterCreateACustomer(WebDriver dr, CreateCustomer1_Object ob1){
        dr.findElement(By.xpath(CreateCustomer1_Page.txt_Name)).sendKeys(ob1.getName());
        dr.findElement(By.xpath(CreateCustomer1_Page.txt_Email)).sendKeys(ob1.getEmail());
        dr.findElement(By.xpath(CreateCustomer1_Page.txt_Phone)).sendKeys(ob1.getPhone());
        dr.findElement(By.xpath(CreateCustomer1_Page.txt_Address)).sendKeys(ob1.getAddress());
    }
    public static void clickCreateACustomer(WebDriver dr){
        dr.findElement(By.xpath(CreateCustomer1_Page.btn_Create)).click();
    }
}
