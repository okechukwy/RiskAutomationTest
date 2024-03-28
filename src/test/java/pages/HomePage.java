package pages;

import genericHelpers.WebElementHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private WebElementHelpers webElementHelpers;

    public static By ACCEPT_ALL_COOKIES_ID = By.id("onetrust-accept-btn-handler");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.webElementHelpers  = new WebElementHelpers(driver);
    }

    public void acceptAllCookies(){
        try{
            driver.findElement(ACCEPT_ALL_COOKIES_ID).click();
        }catch (Exception e) {
            throw new NoSuchElementException("Could not locate the cookie",e);

        }

   }

}
