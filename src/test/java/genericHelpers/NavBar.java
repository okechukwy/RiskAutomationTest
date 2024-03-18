package genericHelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBar {

    private WebDriver driver;
    private WebElementHelpers webElementHelpers = new WebElementHelpers(driver);

    public static By aboutUsLink = By.linkText("About Us");

    public NavBar(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAboutUsLink(){
         webElementHelpers.safeWaitToBeVisible(driver, aboutUsLink, 5);
        driver.findElement(aboutUsLink).click();
    }


}
