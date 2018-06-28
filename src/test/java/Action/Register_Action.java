package Action;

import Page.Register_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register_Action {
    public static void ClickRegisterlink(WebDriver dr)
    {
        dr.findElement(By.xpath(Register_Page.ClickRegisterlink)).click();
    }
}
