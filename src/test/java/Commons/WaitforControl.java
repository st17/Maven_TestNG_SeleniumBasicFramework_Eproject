package Commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitforControl {

    public static void waitforControlVisible(WebDriver dr, String LocatorOfControl)
    {
        WebDriverWait wait = new WebDriverWait(dr, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( LocatorOfControl)));
    }
}

