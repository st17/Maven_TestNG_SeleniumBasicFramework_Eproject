package Actions;

import Objects.CreateCustomer1_Object;
import Objects.Status;
import Pages.Opportunity_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Opportunity_Action {
    public static void clickOpportunities(WebDriver dr)
    {
        dr.findElement(By.xpath(Opportunity_Page.dro_Opportunity)).click();
    }
    public static void clickShowAllOpportunitys(WebDriver dr)
    {
        dr.findElement(By.xpath(Opportunity_Page.item_Opportunity)).click();
    }
    public static void clickCustomer(WebDriver dr)
    {
        dr.findElement(By.xpath(Opportunity_Page.customer_name)).click();
    }
    public static void clickAddOpptunity(WebDriver dr)
    {
        dr.findElement(By.xpath(Opportunity_Page.btn_AddOpportunity)).click();
    }
    public static void clickCheckbox(WebDriver dr)
    {
        dr.findElement(By.xpath(Opportunity_Page.checkbox)).isSelected();
        dr.findElement(By.xpath(Opportunity_Page.checkbox)).click();
    }
    public static void selectStatus(WebDriver dr, Status ob1)
    {
        Select sta = new Select(dr.findElement(By.xpath(Opportunity_Page.sel_status)));
        sta.selectByVisibleText(ob1.getSel2());
    }
    public static void clickCreateOpportunity(WebDriver dr)
    {
        dr.findElement(By.xpath(Opportunity_Page.btn_CreateOpportunity)).click();
    }
    public static void clickCancel(WebDriver dr)
    {
        dr.findElement(By.xpath(Opportunity_Page.btn_cancel)).click();
    }
    public static void enter_CustomerName(WebDriver dr, CreateCustomer1_Object cus1)
    {
        dr.findElement(By.xpath(Opportunity_Page.txt_Customername)).sendKeys(cus1.getName());
    }
}
