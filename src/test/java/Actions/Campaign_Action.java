package Actions;

import Objects.CampaignType;
import Pages.Campaign_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Campaign_Action {
    public static void clickCampaign(WebDriver dr)
    {
        dr.findElement(By.xpath(Campaign_Page.dro_campaigns)).click();
    }
    public static void selectItem4Campaign(WebDriver dr)
    {
        dr.findElement(By.xpath(Campaign_Page.item4_campaigns)).click();
    }
    //
    public static void enterCampaignType(CampaignType ob1, WebDriver dr)
    {
        dr.findElement(By.xpath(Campaign_Page.txt_campaigntype)).sendKeys(ob1.getName());
    }
    //
    public static void clickSubmit(WebDriver dr)
    {
        dr.findElement(By.xpath(Campaign_Page.btn_submit)).click();
    }
}
