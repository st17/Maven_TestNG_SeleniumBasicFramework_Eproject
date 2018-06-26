package Actions;

import Objects.Register_Object;
import Pages.Register_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register_Action {
    public static void enterRegister(WebDriver dr, Register_Object register){
        dr.findElement(By.xpath(Register_Page.txt_Email)).sendKeys(register.getEmail());
        dr.findElement(By.xpath(Register_Page.txt_Password)).sendKeys(register.getPassword());
        dr.findElement(By.xpath(Register_Page.txt_ConfirmPassword)).sendKeys(register.getConfirmPassword());
        dr.findElement(By.xpath(Register_Page.txt_Name)).sendKeys(register.getName());
        dr.findElement(By.xpath(Register_Page.txt_Company)).sendKeys(register.getCompany());
        dr.findElement(By.xpath(Register_Page.txt_Phone)).sendKeys(register.getPhone());
    }
    public static void clickRegister(WebDriver dr){
        dr.findElement(By.xpath(Register_Page.btn_Register)).click();
    }
}
